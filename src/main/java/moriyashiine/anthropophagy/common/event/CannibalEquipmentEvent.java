/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.event;

import moriyashiine.anthropophagy.common.component.entity.CannibalLevelComponent;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.strawberrylib.api.event.PreventEquipmentUsageEvent;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CannibalEquipmentEvent implements PreventEquipmentUsageEvent {
	@Override
	public TriState preventsUsage(LivingEntity entity, ItemStack stack) {
		@Nullable CannibalLevelComponent cannibalLevelComponent = ModEntityComponents.CANNIBAL_LEVEL.getNullable(entity);
		if (cannibalLevelComponent != null && cannibalLevelComponent.cannotEquip(stack)) {
			return TriState.TRUE;
		}
		return TriState.DEFAULT;
	}
}
