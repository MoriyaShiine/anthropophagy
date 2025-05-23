/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.event;

import moriyashiine.anthropophagy.common.ModConfig;
import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import moriyashiine.anthropophagy.common.item.FleshItem;
import moriyashiine.anthropophagy.common.tag.ModItemTags;
import moriyashiine.anthropophagy.common.util.FleshDropEntry;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.server.world.ServerWorld;

public class DropFleshEvent implements ServerLivingEntityEvents.AllowDamage {
	public static float attackCooldown = -1;

	@Override
	public boolean allowDamage(LivingEntity entity, DamageSource source, float amount) {
		if (attackCooldown != -1 && attackCooldown < 0.7F) {
			return true;
		}
		if (source.getSource() instanceof LivingEntity living && (living.getMainHandStack().isIn(ModItemTags.KNIVES) || source.getAttacker() instanceof PigluttonEntity)) {
			boolean dropCooked = entity.getFireTicks() > 0 || EnchantmentHelper.hasAnyEnchantmentsIn(living.getMainHandStack(), EnchantmentTags.SMELTS_LOOT);
			for (EntityType<?> entityType : FleshDropEntry.DROP_MAP.keySet()) {
				if (entity.getType() == entityType && entity.getWorld().getRandom().nextFloat() * ModConfig.damageNeededForGuaranteedFleshDrop < amount) {
					FleshDropEntry entry = FleshDropEntry.DROP_MAP.get(entityType);
					ItemStack drop = new ItemStack(dropCooked ? entry.cooked_drop() : entry.raw_drop());
					if (drop.getItem() instanceof FleshItem) {
						FleshItem.setOwner(drop, entity);
					}
					entity.dropStack((ServerWorld) entity.getWorld(), drop).setPickupDelay(40);
				}
			}
		}
		return true;
	}
}
