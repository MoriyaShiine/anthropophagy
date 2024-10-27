/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.mixin;

import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EquippableComponent.class)
public class EquippableComponentMixin {
	@Inject(method = "equip", at = @At("HEAD"), cancellable = true)
	private void anthropophagy$preventEquipping(ItemStack stack, PlayerEntity player, CallbackInfoReturnable<ActionResult> cir) {
		if (player.getComponent(ModEntityComponents.CANNIBAL_LEVEL).cannotEquip(stack)) {
			cir.setReturnValue(ActionResult.PASS);
		}
	}
}
