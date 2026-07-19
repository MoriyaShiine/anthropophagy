package moriyashiine.anthropophagy.common.world.entity.ai.goal;

import moriyashiine.anthropophagy.common.world.entity.monster.Piglutton;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.entity.ai.goal.Goal;

public class StalkGoal extends Goal {
	private static final int MAX_STALK_TICKS = 120;

	private final Piglutton mob;
	private int stalkTicks = 0;

	public StalkGoal(Piglutton mob) {
		this.mob = mob;
	}

	@Override
	public boolean canUse() {
		return mob.isCapableOfActing() && mob.getTarget() != null && mob.distanceTo(mob.getTarget()) > 16;
	}

	@Override
	public boolean requiresUpdateEveryTick() {
		return true;
	}

	@Override
	public void start() {
		mob.stalking = true;
		stalkTicks = 0;
	}

	@Override
	public void stop() {
		mob.stalking = false;
		stalkTicks = 0;
	}

	@Override
	public void tick() {
		if (mob.getTarget() != null) {
			mob.stalking = ++stalkTicks <= MAX_STALK_TICKS;
			mob.lookAt(EntityAnchorArgument.Anchor.EYES, mob.getTarget().position());
		}
	}
}
