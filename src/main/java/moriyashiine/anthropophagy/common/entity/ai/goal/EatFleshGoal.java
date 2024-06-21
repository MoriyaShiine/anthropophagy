/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.entity.ai.goal;

import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import moriyashiine.anthropophagy.common.init.ModItems;
import moriyashiine.anthropophagy.common.item.FleshItem;
import moriyashiine.anthropophagy.common.tag.ModItemTags;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EatFleshGoal extends Goal {
	private static final int OVERHEAL_REQUIRED = 30;

	private final PigluttonEntity mob;

	private ItemEntity closestFleshItem = null;

	public EatFleshGoal(PigluttonEntity mob) {
		this.mob = mob;
	}

	@Override
	public boolean canStart() {
		if (mob.isFleeing()) {
			closestFleshItem = null;
		} else {
			closestFleshItem = getNearestFlesh(mob);
		}
		return closestFleshItem != null;
	}

	@Override
	public void tick() {
		if (closestFleshItem != null) {
			mob.getNavigation().startMovingTo(closestFleshItem, 1);
			if (mob.distanceTo(closestFleshItem) < mob.getWidth()) {
				if (!mob.getWorld().isClient) {
					ItemStack flesh = closestFleshItem.getStack().split(1);
					if (isTargetFlesh(flesh)) {
						heal(mob, flesh, false);
						playEffects(mob, flesh, closestFleshItem.getPos());
					} else {
						mob.setStackInHand(Hand.MAIN_HAND, flesh);
						mob.setEating(true);
					}
				}
			}
		}
	}

	@Nullable
	public static ItemEntity getNearestFlesh(PathAwareEntity mob) {
		List<ItemEntity> drops = mob.getWorld().getEntitiesByType(EntityType.ITEM, mob.getBoundingBox().expand(10, 4, 10), foundEntity -> foundEntity.getStack().isIn(ModItemTags.FLESH) && !foundEntity.getStack().isOf(ModItems.CORRUPT_FLESH));
		if (drops.isEmpty()) {
			return null;
		}
		return drops.getFirst();
	}

	private boolean isTargetFlesh(ItemStack flesh) {
		return mob.getTarget() != null && FleshItem.getOwnerName(flesh).equals(mob.getTarget().getName().getString());
	}

	public static void heal(PigluttonEntity mob, ItemStack stack, boolean allowOverhaul) {
		int healAmount = 6;
		if (stack.contains(DataComponentTypes.FOOD)) {
			healAmount = stack.get(DataComponentTypes.FOOD).nutrition() * 2;
		}
		if (allowOverhaul && mob.getHealth() >= mob.getMaxHealth()) {
			mob.overhealAmount += healAmount;
			if (mob.overhealAmount >= OVERHEAL_REQUIRED) {
				((ServerWorld) mob.getWorld()).spawnParticles(ParticleTypes.SMOKE,
						mob.getX(), mob.getY(), mob.getZ(),
						64,
						mob.getWidth() / 2, mob.getHeight() / 2, mob.getWidth() / 2,
						0);
				mob.dropItem(ModItems.PIGLUTTON_HEART);
				mob.discard();
			}
		} else {
			mob.heal(healAmount);
		}
	}

	public static void playEffects(PigluttonEntity mob, ItemStack stack, Vec3d pos) {
		((ServerWorld) mob.getWorld()).spawnParticles(new ItemStackParticleEffect(ParticleTypes.ITEM, stack),
				pos.getX(), pos.getY(), pos.getZ(),
				8,
				0.125, 0.125, 0.125,
				0);
		mob.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1, 1);
	}
}
