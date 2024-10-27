/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import moriyashiine.anthropophagy.common.component.entity.CannibalLevelComponent;
import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.anthropophagy.common.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@ModifyReturnValue(method = {"canEquip", "canEquipFromDispenser"}, at = @At("RETURN"))
	private boolean anthropophagy$preventEquipping(boolean original, ItemStack stack) {
		if (original) {
			@Nullable CannibalLevelComponent cannibalLevelComponent = ModEntityComponents.CANNIBAL_LEVEL.getNullable(this);
			if (cannibalLevelComponent != null && cannibalLevelComponent.cannotEquip(stack)) {
				return false;
			}
		}
		return original;
	}

	@Inject(method = "dropEquipment", at = @At("HEAD"))
	private void anthropophagy$dropTetheredHeart(ServerWorld world, DamageSource source, boolean causedByPlayer, CallbackInfo ci) {
		ModEntityComponents.TETHERED.maybeGet(this).ifPresent(tetheredComponent -> {
			if (tetheredComponent.isTethered()) {
				dropItem(world, ModItems.PIGLUTTON_HEART);
			}
		});
	}

	@ModifyArg(method = "jump", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/LivingEntity;setVelocity(DDD)V"), index = 1)
	private double anthropophagy$cannibalJumpBoost(double value) {
		if (isSneaking()) {
			CannibalLevelComponent cannibalLevelComponent = ModEntityComponents.CANNIBAL_LEVEL.getNullable(this);
			if (cannibalLevelComponent != null) {
				return value + cannibalLevelComponent.getJumpBoost();
			}
		}
		return value;
	}
}
