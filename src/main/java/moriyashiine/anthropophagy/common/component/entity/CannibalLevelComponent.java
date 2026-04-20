/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.component.entity;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.strawberrylib.api.event.PreventEquipmentUsageEvent;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

import java.util.ArrayList;
import java.util.List;

public class CannibalLevelComponent implements AutoSyncedComponent {
	public static final int MAX_LEVEL = 120;
	public static final int MIN_FUNCTIONAL_LEVEL = 30;
	private static final float MAX_FUNCTIONAL_LEVEL = MAX_LEVEL - MIN_FUNCTIONAL_LEVEL;

	private static final Identifier ATTACK_DAMAGE_ID = Anthropophagy.id("attack_damage");
	private static final Identifier ARMOR_ID = Anthropophagy.id("armor");
	private static final Identifier KNOCKBACK_RESISTANCE_ID = Anthropophagy.id("knockback_resistance");
	private static final Identifier MOVEMENT_SPEED_ID = Anthropophagy.id("movement_speed");
	private static final Identifier SAFE_FALL_DISTANCE_ID = Anthropophagy.id("safe_fall_distance");
	private static final Identifier STEP_HEIGHT_ID = Anthropophagy.id("step_height");

	private final Player obj;
	private int cannibalLevel = 0;

	public CannibalLevelComponent(Player obj) {
		this.obj = obj;
	}

	@Override
	public void readData(ValueInput input) {
		cannibalLevel = input.getIntOr("CannibalLevel", 0);
	}

	@Override
	public void writeData(ValueOutput output) {
		output.putInt("CannibalLevel", cannibalLevel);
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

	public boolean cannotEquip(ItemStack stack) {
		if (stack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY).modifiers().stream().anyMatch(entry -> entry.attribute() == Attributes.ARMOR) || stack.has(DataComponents.GLIDER)) {
			EquipmentSlot slot = obj.getEquipmentSlotForItem(stack);
			if (cannibalLevel >= 30 && slot == EquipmentSlot.LEGS) {
				return true;
			} else if (cannibalLevel >= 50 && slot == EquipmentSlot.HEAD) {
				return true;
			} else if (cannibalLevel >= 70 && slot == EquipmentSlot.FEET) {
				return true;
			} else return cannibalLevel >= 90 && slot == EquipmentSlot.CHEST;
		}
		return false;
	}

	public void updateAttributes() {
		if (!obj.level().isClientSide()) {
			obj.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(ATTACK_DAMAGE_ID);
			obj.getAttribute(Attributes.ARMOR).removeModifier(ARMOR_ID);
			obj.getAttribute(Attributes.KNOCKBACK_RESISTANCE).removeModifier(KNOCKBACK_RESISTANCE_ID);
			obj.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(MOVEMENT_SPEED_ID);
			obj.getAttribute(Attributes.SAFE_FALL_DISTANCE).removeModifier(SAFE_FALL_DISTANCE_ID);
			obj.getAttribute(Attributes.STEP_HEIGHT).removeModifier(STEP_HEIGHT_ID);
			getModifiersForLevel(cannibalLevel).attributes().forEach(pair -> obj.getAttribute(pair.getA()).addPermanentModifier(pair.getB()));
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
			attributes.addModifier(Attributes.ATTACK_DAMAGE,
					new AttributeModifier(ATTACK_DAMAGE_ID,
							lerp(level, 6),
							AttributeModifier.Operation.ADD_VALUE));
			attributes.addModifier(Attributes.ARMOR,
					new AttributeModifier(ARMOR_ID,
							lerp(level, 14),
							AttributeModifier.Operation.ADD_VALUE));
			attributes.addModifier(Attributes.KNOCKBACK_RESISTANCE,
					new AttributeModifier(KNOCKBACK_RESISTANCE_ID,
							lerp(level, 0.2F),
							AttributeModifier.Operation.ADD_VALUE));
			attributes.addModifier(Attributes.MOVEMENT_SPEED,
					new AttributeModifier(MOVEMENT_SPEED_ID,
							lerp(level, 0.5F),
							AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
			attributes.addModifier(Attributes.SAFE_FALL_DISTANCE,
					new AttributeModifier(SAFE_FALL_DISTANCE_ID,
							lerp(level, 4),
							AttributeModifier.Operation.ADD_VALUE));
			if (level >= 60) {
				attributes.addModifier(Attributes.STEP_HEIGHT,
						new AttributeModifier(STEP_HEIGHT_ID,
								1,
								AttributeModifier.Operation.ADD_VALUE));
			}
		}
		attributes.attributes().removeIf(pair -> pair.getB().amount() == 0);
		return attributes;
	}

	private static float lerp(int level, float end) {
		return Mth.lerp(Math.min(1, (level - MIN_FUNCTIONAL_LEVEL) / (MAX_FUNCTIONAL_LEVEL - MIN_FUNCTIONAL_LEVEL)), 0, end);
	}

	private static int lerp(int level, int end) {
		return Mth.lerpInt(Math.min(1, (level - MIN_FUNCTIONAL_LEVEL) / (MAX_FUNCTIONAL_LEVEL - MIN_FUNCTIONAL_LEVEL)), 0, end);
	}

	private static boolean compareLevel(Player player, int minInc, int maxExc) {
		int level = ModEntityComponents.CANNIBAL_LEVEL.get(player).getCannibalLevel();
		return level >= minInc && level < maxExc;
	}

	private record AttributeModifierSet(
			List<Tuple<Holder<Attribute>, AttributeModifier>> attributes) {
		void addModifier(Holder<Attribute> attribute, AttributeModifier modifier) {
			attributes().add(new Tuple<>(attribute, modifier));
		}
	}
}
