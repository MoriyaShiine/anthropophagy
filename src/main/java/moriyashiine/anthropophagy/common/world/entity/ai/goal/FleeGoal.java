/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.world.entity.ai.goal;

import moriyashiine.anthropophagy.common.world.entity.Piglutton;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.util.DefaultRandomPos;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;

public class FleeGoal extends Goal {
	private final Piglutton mob;
	private Path fleePath = null;

	public FleeGoal(Piglutton mob) {
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		if (mob.isFleeing()) {
			Vec3 pos = mob.position();
			if (mob.getTarget() != null) {
				pos = mob.getTarget().position();
			}
			Vec3 fleePos = DefaultRandomPos.getPosAway(mob, 6, 7, pos);
			if (fleePos != null) {
				fleePath = mob.getNavigation().createPath(fleePos.x(), fleePos.y(), fleePos.z(), 0);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canContinueToUse() {
		return mob.isFleeing() && !mob.getNavigation().isDone();
	}

	@Override
	public void tick() {
		mob.getNavigation().moveTo(fleePath, 1);
		mob.setTarget(null);
		mob.setLastHurtByMob(null);
	}
}
