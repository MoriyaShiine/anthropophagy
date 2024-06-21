/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.entity.ai.goal;

import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.util.Hand;

public class PigluttonMeleeAttackGoal extends MeleeAttackGoal {
	public PigluttonMeleeAttackGoal(PigluttonEntity mob, double speed, boolean pauseWhenMobIdle) {
		super(mob, speed, pauseWhenMobIdle);
	}

	@Override
	public boolean canStart() {
		PigluttonEntity piglutton = (PigluttonEntity) mob;
		return piglutton.canAttack && !piglutton.isBusy() && super.canStart();
	}

	@Override
	public void tick() {
		PigluttonEntity piglutton = (PigluttonEntity) mob;
		if (piglutton.canAttack && !piglutton.isBusy()) {
			super.tick();
		}
	}

	@Override
	protected void attack(LivingEntity target) {
		if (canAttack(target)) {
			((PigluttonEntity) mob).attack();
			resetCooldown();
			mob.swingHand(Hand.MAIN_HAND);
		}
	}
}
