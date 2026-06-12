/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.mixin;

import moriyashiine.anthropophagy.common.tag.AnthropophagyEntityTypeTags;
import moriyashiine.anthropophagy.common.world.entity.monster.Piglutton;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public abstract class MobMixin extends LivingEntity {
	@Shadow
	@Final
	protected GoalSelector goalSelector;

	protected MobMixin(EntityType<? extends LivingEntity> type, Level level) {
		super(type, level);
	}

	@SuppressWarnings("ConstantValue")
	@Inject(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Mob;registerGoals()V"))
	private void anthropophagy$fleeFromPiglutton(CallbackInfo ci) {
		if (is(AnthropophagyEntityTypeTags.PIGLUTTON_TARGETS) && (Object) this instanceof PathfinderMob mob) {
			goalSelector.addGoal(2, new AvoidEntityGoal<>(mob, Piglutton.class, 16, 1, 1.2));
		}
	}
}
