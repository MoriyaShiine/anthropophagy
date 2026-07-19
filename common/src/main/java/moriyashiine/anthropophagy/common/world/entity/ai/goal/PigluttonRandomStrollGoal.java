package moriyashiine.anthropophagy.common.world.entity.ai.goal;

import moriyashiine.anthropophagy.common.world.entity.monster.Piglutton;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;

public class PigluttonRandomStrollGoal extends WaterAvoidingRandomStrollGoal {
	public PigluttonRandomStrollGoal(Piglutton mob, double speedModifier) {
		super(mob, speedModifier);
		interval = DEFAULT_INTERVAL / 2;
	}

	@Override
	public boolean canUse() {
		Piglutton piglutton = (Piglutton) mob;
		return piglutton.isCapableOfActing() && piglutton.getTarget() == null && super.canUse();
	}
}
