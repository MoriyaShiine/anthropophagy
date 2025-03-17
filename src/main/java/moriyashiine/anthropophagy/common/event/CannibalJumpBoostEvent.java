/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.event;

import moriyashiine.anthropophagy.common.component.entity.CannibalLevelComponent;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.strawberrylib.api.event.ModifyJumpVelocityEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class CannibalJumpBoostEvent implements ModifyJumpVelocityEvent {
	@Override
	public Vec3d modify(Vec3d velocity, LivingEntity entity) {
		if (entity.isSneaking()) {
			@Nullable CannibalLevelComponent cannibalLevelComponent = ModEntityComponents.CANNIBAL_LEVEL.getNullable(entity);
			if (cannibalLevelComponent != null) {
				return velocity.add(0, cannibalLevelComponent.getJumpBoost(), 0);
			}
		}
		return velocity;
	}
}
