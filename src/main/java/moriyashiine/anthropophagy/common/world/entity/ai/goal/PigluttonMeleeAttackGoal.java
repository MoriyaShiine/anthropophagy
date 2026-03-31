/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.world.entity.ai.goal;

import moriyashiine.anthropophagy.common.world.entity.Piglutton;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class PigluttonMeleeAttackGoal extends MeleeAttackGoal {
	private final Piglutton mob;

	public PigluttonMeleeAttackGoal(Piglutton mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
		super(mob, speedModifier, followingTargetEvenIfNotSeen);
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		return mob.canAttack && !mob.isBusy() && super.canUse();
	}

	@Override
	public void tick() {
		if (mob.canAttack && !mob.isBusy()) {
			super.tick();
		}
	}

	@Override
	protected void checkAndPerformAttack(LivingEntity target) {
		if (canPerformAttack(target)) {
			mob.attack();
			resetAttackCooldown();
			mob.swing(InteractionHand.MAIN_HAND);
		}
	}
}
