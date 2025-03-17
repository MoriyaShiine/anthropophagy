/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.client.event;

import moriyashiine.anthropophagy.common.component.entity.CannibalLevelComponent;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.strawberrylib.api.event.client.ModifyNightVisionStrengthEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;

public class CannibalNightVisionEvent implements ModifyNightVisionStrengthEvent {
	@Override
	public float modify(float strength, LivingEntity entity) {
		@Nullable CannibalLevelComponent cannibalLevelComponent = ModEntityComponents.CANNIBAL_LEVEL.getNullable(entity);
		return cannibalLevelComponent != null ? MathHelper.clamp(MathHelper.lerp((cannibalLevelComponent.getCannibalLevel() - CannibalLevelComponent.MIN_FUNCTIONAL_LEVEL) / 20F, 0, 1F), 0, 1) : 0;
	}
}
