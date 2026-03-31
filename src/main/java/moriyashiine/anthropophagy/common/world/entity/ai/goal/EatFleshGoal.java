/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.world.entity.ai.goal;

import moriyashiine.anthropophagy.common.init.ModItems;
import moriyashiine.anthropophagy.common.tag.ModItemTags;
import moriyashiine.anthropophagy.common.world.entity.Piglutton;
import moriyashiine.anthropophagy.common.world.item.FleshItem;
import moriyashiine.strawberrylib.api.module.SLibUtils;
import moriyashiine.strawberrylib.api.objects.enums.ParticleAnchor;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class EatFleshGoal extends Goal {
	private static final int OVERHEAL_REQUIRED = 30;

	private final Piglutton mob;

	@Nullable
	private ItemEntity closestFleshItem = null;

	public EatFleshGoal(Piglutton mob) {
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
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
			mob.getNavigation().moveTo(closestFleshItem, 1);
			if (mob.distanceTo(closestFleshItem) < mob.getBbWidth()) {
				if (mob.level() instanceof ServerLevel level) {
					ItemStack flesh = closestFleshItem.getItem().split(1);
					if (isTargetFlesh(flesh)) {
						heal(level, mob, flesh, false);
						playEffects(mob, flesh, closestFleshItem.position());
					} else {
						mob.setItemInHand(InteractionHand.MAIN_HAND, flesh);
						mob.setEating(true);
					}
				}
			}
		}
	}

	@Nullable
	public static ItemEntity getNearestFlesh(PathfinderMob mob) {
		List<ItemEntity> drops = mob.level().getEntities(EntityType.ITEM, mob.getBoundingBox().inflate(10, 4, 10), foundEntity -> foundEntity.getItem().is(ModItemTags.FLESH) && !foundEntity.getItem().is(ModItems.CORRUPT_FLESH));
		if (drops.isEmpty()) {
			return null;
		}
		return drops.getFirst();
	}

	private boolean isTargetFlesh(ItemStack flesh) {
		return mob.getTarget() != null && FleshItem.getOwnerName(flesh).equals(mob.getTarget().getName().getString());
	}

	public static void heal(ServerLevel level, Piglutton mob, ItemStack stack, boolean allowOverheal) {
		int healAmount = 6;
		if (stack.has(DataComponents.FOOD)) {
			healAmount = stack.get(DataComponents.FOOD).nutrition() * 2;
		}
		if (allowOverheal && mob.getHealth() >= mob.getMaxHealth()) {
			mob.overhealAmount += healAmount;
			if (mob.overhealAmount >= OVERHEAL_REQUIRED) {
				SLibUtils.addParticles(mob, ParticleTypes.SMOKE, 64, ParticleAnchor.BODY);
				mob.spawnAtLocation(level, ModItems.PIGLUTTON_HEART);
				mob.discard();
			}
		} else {
			mob.heal(healAmount);
		}
	}

	public static void playEffects(Piglutton mob, ItemStack stack, Vec3 pos) {
		((ServerLevel) mob.level()).sendParticles(new ItemParticleOption(ParticleTypes.ITEM, stack.getItem()),
				pos.x(), pos.y(), pos.z(),
				8,
				0.125, 0.125, 0.125,
				0);
		SLibUtils.playSound(mob, SoundEvents.GENERIC_EAT.value());
	}
}
