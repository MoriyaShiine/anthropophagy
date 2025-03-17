/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.event;

import moriyashiine.anthropophagy.common.ModConfig;
import moriyashiine.anthropophagy.common.component.entity.CannibalLevelComponent;
import moriyashiine.anthropophagy.common.component.entity.TetheredComponent;
import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.anthropophagy.common.item.FleshItem;
import moriyashiine.anthropophagy.common.tag.ModItemTags;
import moriyashiine.strawberrylib.api.event.EatFoodEvent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class CannibalEatingEvent implements EatFoodEvent {
	@Override
	public void eat(World world, LivingEntity entity, ItemStack stack, FoodComponent foodComponent) {
		@Nullable CannibalLevelComponent cannibalLevelComponent = ModEntityComponents.CANNIBAL_LEVEL.getNullable(entity);
		@Nullable TetheredComponent tetheredComponent = ModEntityComponents.TETHERED.getNullable(entity);
		if (cannibalLevelComponent == null || tetheredComponent == null) {
			return;
		}
		if (stack.isIn(ModItemTags.FLESH)) {
			if (!tetheredComponent.isTethered()) {
				if (cannibalLevelComponent.getCannibalLevel() < CannibalLevelComponent.MAX_LEVEL) {
					cannibalLevelComponent.setCannibalLevel(Math.min(CannibalLevelComponent.MAX_LEVEL, cannibalLevelComponent.getCannibalLevel() + 2));
					cannibalLevelComponent.updateAttributes();
				}
				if (!world.isClient && cannibalLevelComponent.getCannibalLevel() == 20 || cannibalLevelComponent.getCannibalLevel() == 21) {
					entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
					entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200));
				}
			}
			if (ModConfig.enablePiglutton) {
				PigluttonEntity.attemptSpawn(entity, cannibalLevelComponent.getCannibalLevel(), FleshItem.isOwnerPlayer(stack) && entity.getName().getString().equals(FleshItem.getOwnerName(stack)));
			}
		} else {
			if (!tetheredComponent.isTethered() && cannibalLevelComponent.getCannibalLevel() > 0) {
				cannibalLevelComponent.setCannibalLevel(Math.max(0, cannibalLevelComponent.getCannibalLevel() - 1));
				cannibalLevelComponent.updateAttributes();
			}
			if (!world.isClient && cannibalLevelComponent.getCannibalLevel() >= 20) {
				ModEntityComponents.playerCannibalLevel = cannibalLevelComponent.getCannibalLevel();
			}
		}
	}
}
