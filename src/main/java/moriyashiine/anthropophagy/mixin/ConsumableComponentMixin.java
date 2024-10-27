/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.mixin;

import moriyashiine.anthropophagy.common.ModConfig;
import moriyashiine.anthropophagy.common.component.entity.CannibalLevelComponent;
import moriyashiine.anthropophagy.common.component.entity.TetheredComponent;
import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.anthropophagy.common.item.FleshItem;
import moriyashiine.anthropophagy.common.tag.ModItemTags;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ConsumableComponent.class)
public class ConsumableComponentMixin {
	@Inject(method = "finishConsumption", at = @At("HEAD"))
	private void anthropophagy$handleCannibalFood(World world, LivingEntity user, ItemStack stack, CallbackInfoReturnable<ItemStack> cir) {
		@Nullable CannibalLevelComponent cannibalLevelComponent = ModEntityComponents.CANNIBAL_LEVEL.getNullable(user);
		@Nullable TetheredComponent tetheredComponent = ModEntityComponents.TETHERED.getNullable(user);
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
					user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200));
					user.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200));
				}
			}
			if (ModConfig.enablePiglutton) {
				PigluttonEntity.attemptSpawn(user, cannibalLevelComponent.getCannibalLevel(), FleshItem.isOwnerPlayer(stack) && user.getName().getString().equals(FleshItem.getOwnerName(stack)));
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
