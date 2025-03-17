/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.mixin;

import moriyashiine.anthropophagy.common.init.ModEntityComponents;
import moriyashiine.anthropophagy.common.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Inject(method = "dropEquipment", at = @At("HEAD"))
	private void anthropophagy$dropTetheredHeart(ServerWorld world, DamageSource source, boolean causedByPlayer, CallbackInfo ci) {
		ModEntityComponents.TETHERED.maybeGet(this).ifPresent(tetheredComponent -> {
			if (tetheredComponent.isTethered()) {
				dropItem(world, ModItems.PIGLUTTON_HEART);
			}
		});
	}
}
