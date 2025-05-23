/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.entity.ai.goal;

import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;

public class PigluttonWanderAroundFarGoal extends WanderAroundFarGoal {
	public PigluttonWanderAroundFarGoal(PigluttonEntity pigluttonEntity, double speed) {
		super(pigluttonEntity, speed);
	}

	@Override
	public boolean canStart() {
		return ((PigluttonEntity) mob).stalkTicks == 0 && super.canStart();
	}
}
