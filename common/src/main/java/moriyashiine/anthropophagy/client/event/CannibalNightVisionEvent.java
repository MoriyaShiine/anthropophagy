package moriyashiine.anthropophagy.client.event;

import moriyashiine.anthropophagy.common.component.entity.CannibalComponent;
import moriyashiine.anthropophagy.common.init.AnthropophagyEntityComponents;
import moriyashiine.strawberrylib.api.event.client.AddNightVisionScaleEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class CannibalNightVisionEvent implements AddNightVisionScaleEvent {
	@Override
	public float addScale(LivingEntity entity) {
		CannibalComponent cannibal = AnthropophagyEntityComponents.CANNIBAL.getNullable(entity);
		return cannibal != null ? Mth.clamp((cannibal.getLevel() - CannibalComponent.MIN_FUNCTIONAL_LEVEL) / 20F, 0, 1) : 0;
	}
}
