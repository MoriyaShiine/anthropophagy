package moriyashiine.anthropophagy.common.world.entity.ai.goal.target;

import moriyashiine.anthropophagy.common.world.entity.monster.Piglutton;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;

public class PigluttonHurtByTargetGoal extends HurtByTargetGoal {
	public PigluttonHurtByTargetGoal(Piglutton mob, Class<?>... ignoreDamageFromTheseTypes) {
		super(mob, ignoreDamageFromTheseTypes);
	}

	@Override
	public void start() {
		if (((Piglutton) mob).isCapableOfActing()) {
			super.start();
		}
	}
}
