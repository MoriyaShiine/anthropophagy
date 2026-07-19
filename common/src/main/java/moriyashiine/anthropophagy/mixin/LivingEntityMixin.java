package moriyashiine.anthropophagy.mixin;

import moriyashiine.anthropophagy.common.init.AnthropophagyEntityComponents;
import moriyashiine.anthropophagy.common.init.AnthropophagyItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin(EntityType<?> type, Level level) {
		super(type, level);
	}

	@Inject(method = "dropCustomDeathLoot", at = @At("HEAD"))
	private void anthropophagy$dropTetheredHeart(ServerLevel level, DamageSource source, boolean killedByPlayer, CallbackInfo ci) {
		AnthropophagyEntityComponents.CANNIBAL.maybeGet(this).ifPresent(cannibal -> {
			if (cannibal.isTethered()) {
				spawnAtLocation(level, AnthropophagyItems.PIGLUTTON_HEART);
			}
		});
	}
}
