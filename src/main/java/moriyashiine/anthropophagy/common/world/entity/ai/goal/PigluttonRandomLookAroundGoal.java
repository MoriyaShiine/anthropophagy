/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.world.entity.ai.goal;

import moriyashiine.anthropophagy.common.world.entity.monster.Piglutton;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;

public class PigluttonRandomLookAroundGoal extends RandomLookAroundGoal {
	private final Piglutton mob;

	public PigluttonRandomLookAroundGoal(Piglutton mob) {
		super(mob);
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		return mob.getTarget() == null && !mob.isEating() && super.canUse();
	}
}
