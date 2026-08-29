package moriyashiine.anthropophagy.common.event;

import moriyashiine.anthropophagy.common.AnthropophagyConfig;
import moriyashiine.anthropophagy.common.component.entity.CannibalComponent;
import moriyashiine.anthropophagy.common.init.AnthropophagyEntityComponents;
import moriyashiine.anthropophagy.common.tag.AnthropophagyItemTags;
import moriyashiine.anthropophagy.common.world.entity.monster.Piglutton;
import moriyashiine.anthropophagy.common.world.item.FleshItem;
import moriyashiine.strawberrylib.api.event.FoodEvents;
import moriyashiine.strawberrylib.api.event.ModifyMovementEvents;
import moriyashiine.strawberrylib.api.event.PreventEquipmentUsageEvent;
import moriyashiine.strawberrylib.api.objects.enums.PreventionResult;
import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class CannibalEvent {
	public static void init() {
		ModifyMovementEvents.JUMP_DELTA.register(new CrouchJump());
		FoodEvents.EAT.register(new EatFood());
		FoodEvents.MODIFY_NUTRITION.register(new ModifyNutrition());
		PreventEquipmentUsageEvent.EVENT.register(new PreventEquipmentUsage());
		EntitySleepEvents.ALLOW_SLEEPING.register(new PreventSleeping());
		ServerPlayerEvents.COPY_FROM.register(new Respawn());
	}

	private static class CrouchJump implements ModifyMovementEvents.JumpDelta {
		@Override
		public Vec3 modify(Vec3 delta, LivingEntity entity) {
			if (entity.isShiftKeyDown()) {
				CannibalComponent cannibal = AnthropophagyEntityComponents.CANNIBAL.getNullable(entity);
				if (cannibal != null) {
					return delta.add(0, cannibal.getJumpBoost(), 0);
				}
			}
			return delta;
		}
	}

	private static class EatFood implements FoodEvents.Eat {
		@Override
		public void eat(Level level, LivingEntity user, ItemStack stack) {
			AnthropophagyEntityComponents.CANNIBAL.maybeGet(user).ifPresent(cannibal -> {
				if (stack.is(AnthropophagyItemTags.FLESH)) {
					if (!cannibal.isTethered()) {
						if (cannibal.getLevel() < CannibalComponent.MAX_LEVEL) {
							cannibal.setLevel(Math.min(CannibalComponent.MAX_LEVEL, cannibal.getLevel() + 2));
							cannibal.updateAttributes();
						}
						if (!level.isClientSide() && cannibal.getLevel() == 20 || cannibal.getLevel() == 21) {
							user.addEffect(new MobEffectInstance(MobEffects.NAUSEA, 200));
							user.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200));
						}
					}
					if (AnthropophagyConfig.enablePiglutton && level instanceof ServerLevel serverLevel) {
						Piglutton.attemptSpawn(serverLevel, user, cannibal.getLevel(), FleshItem.isOwnerPlayer(stack) && user.getName().getString().equals(FleshItem.getOwnerName(stack)));
					}
				} else {
					if (!cannibal.isTethered() && cannibal.getLevel() > 0) {
						cannibal.setLevel(Math.max(0, cannibal.getLevel() - 1));
						cannibal.updateAttributes();
					}
				}
			});
		}
	}

	private static class ModifyNutrition implements FoodEvents.ModifyNutrition {
		@Override
		public int modify(int nutrition, Level level, Player user, ItemStack stack) {
			if (stack.is(AnthropophagyItemTags.FLESH)) {
				return nutrition;
			}
			return Math.round(nutrition * getFoodModifier(AnthropophagyEntityComponents.CANNIBAL.get(user).getLevel()));
		}

		private static float getFoodModifier(int level) {
			if (level >= 70) {
				return 0.4F;
			}
			if (level >= 60) {
				return 0.5F;
			}
			if (level >= 50) {
				return 0.6F;
			}
			if (level >= 40) {
				return 0.7F;
			}
			if (level >= 30) {
				return 0.8F;
			}
			if (level >= 20) {
				return 0.9F;
			}
			return 1;
		}
	}

	private static class PreventEquipmentUsage implements PreventEquipmentUsageEvent {
		@Override
		public PreventionResult getPreventionResult(LivingEntity entity, ItemStack stack, EquipmentSlot slot) {
			if (slot.isArmor()) {
				CannibalComponent cannibal = AnthropophagyEntityComponents.CANNIBAL.getNullable(entity);
				if (cannibal != null && cannibal.cannotEquip(stack)) {
					return PreventionResult.PREVENT;
				}
			}
			return PreventionResult.PASS;
		}
	}

	private static class PreventSleeping implements EntitySleepEvents.AllowSleeping {
		@Override
		public Player.@Nullable BedSleepingProblem allowSleep(Player player, BlockPos sleepingPos) {
			List<Player> nearbyCannibals = player.level().getEntitiesOfClass(Player.class, new AABB(sleepingPos).inflate(8, 5, 8), foundPlayer -> foundPlayer != player && AnthropophagyEntityComponents.CANNIBAL.get(foundPlayer).getLevel() >= 70);
			if (!nearbyCannibals.isEmpty()) {
				return Player.BedSleepingProblem.NOT_SAFE;
			}
			return null;
		}
	}

	private static class Respawn implements ServerPlayerEvents.CopyFrom {
		@Override
		public void copyFromPlayer(ServerPlayer oldPlayer, ServerPlayer newPlayer, boolean alive) {
			if (!alive) {
				CannibalComponent oldCannibal = AnthropophagyEntityComponents.CANNIBAL.get(oldPlayer);
				if (oldCannibal.isTethered()) {
					CannibalComponent cannibal = AnthropophagyEntityComponents.CANNIBAL.get(newPlayer);
					cannibal.setLevel(oldCannibal.getLevel());
					cannibal.updateAttributes();
					cannibal.sync();
				}
			}
		}
	}
}
