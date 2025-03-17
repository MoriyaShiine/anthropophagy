/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.entity.ai.goal;

import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.util.Hand;

public class PigluttonMeleeAttackGoal extends MeleeAttackGoal {
	private final PigluttonEntity mob;

	public PigluttonMeleeAttackGoal(PigluttonEntity mob, double speed, boolean pauseWhenMobIdle) {
		super(mob, speed, pauseWhenMobIdle);
		this.mob = mob;
	}

	@Override
	public boolean canStart() {
		return mob.canAttack && !mob.isBusy() && super.canStart();
	}

	@Override
	public void tick() {
		if (mob.canAttack && !mob.isBusy()) {
			super.tick();
		}
	}

	@Override
	protected void attack(LivingEntity target) {
		if (canAttack(target)) {
			mob.attack();
			resetCooldown();
			mob.swingHand(Hand.MAIN_HAND);
		}
	}
}
