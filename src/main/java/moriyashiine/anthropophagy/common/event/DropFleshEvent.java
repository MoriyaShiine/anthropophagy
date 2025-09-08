/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.event;

import moriyashiine.anthropophagy.common.ModConfig;
import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import moriyashiine.anthropophagy.common.item.FleshItem;
import moriyashiine.anthropophagy.common.tag.ModItemTags;
import moriyashiine.anthropophagy.common.util.FleshDropEntry;
import moriyashiine.strawberrylib.api.event.AfterDamageIncludingDeathEvent;
import moriyashiine.strawberrylib.api.module.SLibUtils;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.server.world.ServerWorld;

public class DropFleshEvent implements AfterDamageIncludingDeathEvent {
	@Override
	public void afterDamage(LivingEntity entity, DamageSource source, float baseDamageTaken, float damageTaken, boolean blocked) {
		if (SLibUtils.isAttackingPlayerCooldownWithinThreshold(0.7F)) {
			if (source.getSource() instanceof LivingEntity living && (living.getMainHandStack().isIn(ModItemTags.KNIVES) || source.getAttacker() instanceof PigluttonEntity)) {
				boolean dropCooked = entity.getFireTicks() > 0 || EnchantmentHelper.hasAnyEnchantmentsIn(living.getMainHandStack(), EnchantmentTags.SMELTS_LOOT);
				for (EntityType<?> entityType : FleshDropEntry.DROP_MAP.keySet()) {
					if (entity.getType() == entityType && entity.getWorld().getRandom().nextFloat() * ModConfig.damageNeededForGuaranteedFleshDrop < damageTaken) {
						FleshDropEntry entry = FleshDropEntry.DROP_MAP.get(entityType);
						ItemStack drop = new ItemStack(dropCooked ? entry.cooked_drop() : entry.raw_drop());
						if (drop.getItem() instanceof FleshItem) {
							FleshItem.setOwner(drop, entity);
						}
						entity.dropStack((ServerWorld) entity.getWorld(), drop).setPickupDelay(40);
					}
				}
			}
		}
	}
}
