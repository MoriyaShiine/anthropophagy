/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.tag;

import moriyashiine.anthropophagy.common.Anthropophagy;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModEntityTypeTags {
	public static final TagKey<EntityType<?>> PIGLUTTON_TARGETS = TagKey.create(Registries.ENTITY_TYPE, Anthropophagy.id("piglutton_targets"));
}
