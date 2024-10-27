/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.mixin.client;

import moriyashiine.anthropophagy.common.component.entity.CannibalLevelComponent;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.MathHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
	@Unique
	private static boolean checkingStrength = false;

	@Shadow
	public static float getNightVisionStrength(LivingEntity entity, float tickDelta) {
		return 0;
	}

	@Inject(method = "getNightVisionStrength", at = @At("HEAD"), cancellable = true)
	private static void anthropophagy$cannibalNightVision(LivingEntity entity, float tickDelta, CallbackInfoReturnable<Float> cir) {
		if (checkingStrength) {
			return;
		}
		float strength = 0;
		CannibalLevelComponent cannibalLevelComponent = ModEntityComponents.CANNIBAL_LEVEL.getNullable(entity);
		if (cannibalLevelComponent != null) {
			strength = MathHelper.clamp(MathHelper.lerp((cannibalLevelComponent.getCannibalLevel() - CannibalLevelComponent.MIN_FUNCTIONAL_LEVEL) / 20F, 0, 1F), 0, 1);
		}
		if (strength > 0) {
			float original = 0;
			if (entity.getActiveStatusEffects().containsKey(StatusEffects.NIGHT_VISION)) {
				checkingStrength = true;
				original = getNightVisionStrength(entity, tickDelta);
				checkingStrength = false;
			}
			cir.setReturnValue(Math.max(original, strength));
		}
	}
}