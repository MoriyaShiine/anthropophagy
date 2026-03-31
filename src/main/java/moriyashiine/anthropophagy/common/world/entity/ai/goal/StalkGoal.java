/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.world.entity.ai.goal;

import moriyashiine.anthropophagy.common.world.entity.Piglutton;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;

public class StalkGoal extends Goal {
	private static final int MAX_STALK_TICKS = 120;

	private final Piglutton mob;

	public StalkGoal(Piglutton mob) {
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		return !mob.isBusy();
	}

	@Override
	public boolean requiresUpdateEveryTick() {
		return true;
	}

	@Override
	public void start() {
		mob.canAttack = false;
		mob.stalkTicks = 0;
	}

	@Override
	public void tick() {
		if (canAttack(mob.getTarget())) {
			if (++mob.stalkTicks >= MAX_STALK_TICKS || mob.distanceTo(mob.getTarget()) < 12 || mob.getLastHurtByMob() != null) {
				mob.canAttack = true;
			}
			mob.lookAt(EntityAnchorArgument.Anchor.EYES, mob.getTarget().position());
		} else {
			mob.canAttack = false;
			mob.stalkTicks = 0;
		}
	}

	private boolean canAttack(LivingEntity entity) {
		if (entity == null || entity.isDeadOrDying() || !entity.isAttackable()) {
			return false;
		}
		return !(entity instanceof Player player) || !player.getAbilities().invulnerable;
	}
}
