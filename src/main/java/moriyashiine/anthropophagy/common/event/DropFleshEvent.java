/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.event;

import moriyashiine.anthropophagy.common.ModConfig;
import moriyashiine.anthropophagy.common.tag.ModItemTags;
import moriyashiine.anthropophagy.common.util.FleshDrop;
import moriyashiine.anthropophagy.common.world.entity.Piglutton;
import moriyashiine.anthropophagy.common.world.item.FleshItem;
import moriyashiine.strawberrylib.api.event.AfterDamageIncludingDeathEvent;
import moriyashiine.strawberrylib.api.module.SLibUtils;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class DropFleshEvent implements AfterDamageIncludingDeathEvent {
	@Override
	public void afterDamage(LivingEntity victim, DamageSource source, float originalDamage, float modifiedDamage, boolean blocked) {
		if (SLibUtils.isAttackingPlayerCooldownWithinThreshold(0.7F)) {
			if (source.getDirectEntity() instanceof LivingEntity attacker && (attacker.getMainHandItem().is(ModItemTags.KNIVES) || source.getEntity() instanceof Piglutton)) {
				boolean dropCooked = victim.getRemainingFireTicks() > 0 || EnchantmentHelper.hasTag(attacker.getMainHandItem(), EnchantmentTags.SMELTS_LOOT);
				for (EntityType<?> type : FleshDrop.DROP_MAP.keySet()) {
					if (victim.getType() == type && victim.getRandom().nextFloat() * ModConfig.damageNeededForGuaranteedFleshDrop < modifiedDamage) {
						FleshDrop entry = FleshDrop.DROP_MAP.get(type);
						ItemStack drop = new ItemStack(dropCooked ? entry.cooked() : entry.raw());
						if (drop.getItem() instanceof FleshItem) {
							FleshItem.setOwner(drop, victim);
						}
						victim.spawnAtLocation((ServerLevel) victim.level(), drop).setPickUpDelay(40);
					}
				}
			}
		}
	}
}
