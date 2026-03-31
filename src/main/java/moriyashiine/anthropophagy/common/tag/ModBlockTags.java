/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.tag;

import moriyashiine.anthropophagy.common.Anthropophagy;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {
	public static final TagKey<Block> PIGLUTTON_BREAKABLE = TagKey.create(Registries.BLOCK, Anthropophagy.id("piglutton_breakable"));
}
