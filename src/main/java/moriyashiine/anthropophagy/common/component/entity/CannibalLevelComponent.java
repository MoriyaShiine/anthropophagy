/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.component.entity;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.math.MathHelper;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

import java.util.ArrayList;
import java.util.List;

public class CannibalLevelComponent implements AutoSyncedComponent {
	public static final int MAX_LEVEL = 120;
	private static final int MIN_FUNCTIONAL_LEVEL = 30;
	private static final float MAX_FUNCTIONAL_LEVEL = MAX_LEVEL - MIN_FUNCTIONAL_LEVEL;

	private static final Identifier ATTACK_DAMAGE_ID = Anthropophagy.id("attack_damage");
	private static final Identifier ARMOR_ID = Anthropophagy.id("armor");
	private static final Identifier KNOCKBACK_RESISTANCE_ID = Anthropophagy.id("knockback_resistance");
	private static final Identifier MOVEMENT_SPEED_ID = Anthropophagy.id("movement_speed");
	private static final Identifier SAFE_FALL_DISTANCE_ID = Anthropophagy.id("safe_fall_distance");
	private static final Identifier STEP_HEIGHT_ID = Anthropophagy.id("step_height");

	private final PlayerEntity obj;
	private int cannibalLevel = 0;

	public CannibalLevelComponent(PlayerEntity obj) {
		this.obj = obj;
	}

	@Override
	public void readFromNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
		cannibalLevel = tag.getInt("CannibalLevel");
	}

	@Override
	public void writeToNbt(NbtCompound tag, RegistryWrapper.WrapperLookup registryLookup) {
		tag.putInt("CannibalLevel", cannibalLevel);
	}

	public void sync() {
		ModEntityComponents.CANNIBAL_LEVEL.sync(obj);
	}

	public int getCannibalLevel() {
		return cannibalLevel;
	}

	public void setCannibalLevel(int cannibalLevel) {
		this.cannibalLevel = cannibalLevel;
	}

	public boolean canEquip(ItemStack stack) {
		if ((stack.getItem() instanceof ArmorItem armorItem && armorItem.getProtection() > 0) || stack.getItem() instanceof ElytraItem) {
			EquipmentSlot slot = obj.getPreferredEquipmentSlot(stack);
			if (cannibalLevel >= 30 && slot == EquipmentSlot.LEGS) {
				return false;
			} else if (cannibalLevel >= 50 && slot == EquipmentSlot.HEAD) {
				return false;
			} else if (cannibalLevel >= 70 && slot == EquipmentSlot.FEET) {
				return false;
			} else return cannibalLevel < 90 || slot != EquipmentSlot.CHEST;
		}
		return true;
	}

	public void updateAttributes() {
		if (!obj.getWorld().isClient) {
			for (ItemStack stack : obj.getEquippedItems()) {
				if (!canEquip(stack)) {
					obj.dropStack(stack.copyAndEmpty());
				}
			}
			obj.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(ATTACK_DAMAGE_ID);
			obj.getAttributeInstance(EntityAttributes.GENERIC_ARMOR).removeModifier(ARMOR_ID);
			obj.getAttributeInstance(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE).removeModifier(KNOCKBACK_RESISTANCE_ID);
			obj.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).removeModifier(MOVEMENT_SPEED_ID);
			obj.getAttributeInstance(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE).removeModifier(SAFE_FALL_DISTANCE_ID);
			obj.getAttributeInstance(EntityAttributes.GENERIC_STEP_HEIGHT).removeModifier(STEP_HEIGHT_ID);
			getModifiersForLevel(cannibalLevel).attributes().forEach(pair -> obj.getAttributeInstance(pair.getLeft()).addPersistentModifier(pair.getRight()));
		}
	}

	public float getJumpBoost() {
		if (compareLevel(obj, 90, MAX_LEVEL + 1)) {
			return 0.3F;
		} else if (compareLevel(obj, 70, 90)) {
			return 0.23F;
		} else if (compareLevel(obj, 50, 70)) {
			return 0.16F;
		} else if (compareLevel(obj, 30, 50)) {
			return 0.09F;
		}
		return 0;
	}

	private static AttributeModifierSet getModifiersForLevel(int level) {
		AttributeModifierSet attributes = new AttributeModifierSet(new ArrayList<>());
		if (level > MIN_FUNCTIONAL_LEVEL) {
			attributes.addModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
					new EntityAttributeModifier(ATTACK_DAMAGE_ID,
							lerp(level, 6),
							EntityAttributeModifier.Operation.ADD_VALUE));
			attributes.addModifier(EntityAttributes.GENERIC_ARMOR,
					new EntityAttributeModifier(ARMOR_ID,
							lerp(level, 14),
							EntityAttributeModifier.Operation.ADD_VALUE));
			attributes.addModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
					new EntityAttributeModifier(KNOCKBACK_RESISTANCE_ID,
							lerp(level, 0.2F),
							EntityAttributeModifier.Operation.ADD_VALUE));
			attributes.addModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
					new EntityAttributeModifier(MOVEMENT_SPEED_ID,
							lerp(level, 0.5F),
							EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
			attributes.addModifier(EntityAttributes.GENERIC_SAFE_FALL_DISTANCE,
					new EntityAttributeModifier(SAFE_FALL_DISTANCE_ID,
							lerp(level, 4),
							EntityAttributeModifier.Operation.ADD_VALUE));
			if (level >= 60) {
				attributes.addModifier(EntityAttributes.GENERIC_STEP_HEIGHT,
						new EntityAttributeModifier(STEP_HEIGHT_ID,
								1,
								EntityAttributeModifier.Operation.ADD_VALUE));
			}
		}
		attributes.attributes().removeIf(pair -> pair.getRight().value() == 0);
		return attributes;
	}

	private static float lerp(int level, float end) {
		return MathHelper.lerp(Math.min(1, (level - MIN_FUNCTIONAL_LEVEL) / (MAX_FUNCTIONAL_LEVEL - MIN_FUNCTIONAL_LEVEL)), 0, end);
	}

	private static int lerp(int level, int end) {
		return MathHelper.lerp(Math.min(1, (level - MIN_FUNCTIONAL_LEVEL) / (MAX_FUNCTIONAL_LEVEL - MIN_FUNCTIONAL_LEVEL)), 0, end);
	}

	private static boolean compareLevel(PlayerEntity player, int minInc, int maxExc) {
		int level = ModEntityComponents.CANNIBAL_LEVEL.get(player).getCannibalLevel();
		return level >= minInc && level < maxExc;
	}

	private record AttributeModifierSet(
			List<Pair<RegistryEntry<EntityAttribute>, EntityAttributeModifier>> attributes) {
		void addModifier(RegistryEntry<EntityAttribute> attribute, EntityAttributeModifier modifier) {
			attributes().add(new Pair<>(attribute, modifier));
		}
	}
}
