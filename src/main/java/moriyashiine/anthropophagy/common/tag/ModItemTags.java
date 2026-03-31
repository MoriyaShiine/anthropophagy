/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.tag;

import moriyashiine.anthropophagy.common.Anthropophagy;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
	public static final TagKey<Item> KNIVES = TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", "knives"));

	public static final TagKey<Item> FLESH = TagKey.create(Registries.ITEM, Anthropophagy.id("flesh"));
}
