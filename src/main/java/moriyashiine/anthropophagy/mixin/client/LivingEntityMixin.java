/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.anthropophagy.common.component.entity.CannibalLevelComponent;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.entry.RegistryEntry;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
	@ModifyReturnValue(method = "hasStatusEffect", at = @At("RETURN"))
	private boolean anthropophagy$cannibalNightVision(boolean original, RegistryEntry<StatusEffect> effect) {
		return original || (effect.equals(StatusEffects.NIGHT_VISION) && hasCannibalNightVision());
	}

	@Unique
	private boolean hasCannibalNightVision() {
		@Nullable CannibalLevelComponent cannibalLevelComponent = ModEntityComponents.CANNIBAL_LEVEL.getNullable(this);
		return cannibalLevelComponent != null && cannibalLevelComponent.getCannibalLevel() > CannibalLevelComponent.MIN_FUNCTIONAL_LEVEL;
	}
}