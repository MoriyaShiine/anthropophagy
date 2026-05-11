/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.world.entity.ai.goal;

import moriyashiine.anthropophagy.common.init.ModItems;
import moriyashiine.anthropophagy.common.tag.ModItemTags;
import moriyashiine.anthropophagy.common.world.entity.Piglutton;
import moriyashiine.anthropophagy.common.world.item.FleshItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class FindFleshGoal extends Goal {
	private final Piglutton mob;

	@Nullable
	private ItemEntity closestFleshItem = null;

	public FindFleshGoal(Piglutton mob) {
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		closestFleshItem = getNearestFlesh(mob);
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
						mob.heal(level, flesh, false);
						mob.playFoodEffects(level, flesh, closestFleshItem.position());
					} else {
						mob.setItemInHand(InteractionHand.MAIN_HAND, flesh);
						mob.setEating(true);
					}
				}
			}
		}
	}

	private static @Nullable ItemEntity getNearestFlesh(PathfinderMob mob) {
		List<ItemEntity> drops = mob.level().getEntities(EntityType.ITEM, mob.getBoundingBox().inflate(10, 4, 10), foundEntity -> foundEntity.getItem().is(ModItemTags.FLESH) && !foundEntity.getItem().is(ModItems.CORRUPT_FLESH));
		if (drops.isEmpty()) {
			return null;
		}
		return drops.getFirst();
	}

	private boolean isTargetFlesh(ItemStack flesh) {
		return mob.getTarget() != null && FleshItem.getOwnerName(flesh).equals(mob.getTarget().getName().getString());
	}
}
