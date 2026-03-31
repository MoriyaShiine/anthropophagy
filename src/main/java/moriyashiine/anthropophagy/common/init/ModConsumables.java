/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModConsumables {
	public static final Consumable CORRUPT_FLESH = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 1), 1))
			.build();
}
