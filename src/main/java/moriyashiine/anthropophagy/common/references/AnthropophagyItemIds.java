/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.references;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.key;

public class AnthropophagyItemIds {
	public static final ResourceKey<Item> WOODEN_KNIFE = key(Registries.ITEM, "wooden_knife");
	public static final ResourceKey<Item> STONE_KNIFE = key(Registries.ITEM, "stone_knife");
	public static final ResourceKey<Item> COPPER_KNIFE = key(Registries.ITEM, "copper_knife");
	public static final ResourceKey<Item> IRON_KNIFE = key(Registries.ITEM, "iron_knife");
	public static final ResourceKey<Item> GOLDEN_KNIFE = key(Registries.ITEM, "golden_knife");
	public static final ResourceKey<Item> DIAMOND_KNIFE = key(Registries.ITEM, "diamond_knife");
	public static final ResourceKey<Item> NETHERITE_KNIFE = key(Registries.ITEM, "netherite_knife");

	public static final ResourceKey<Item> FLESH = key(Registries.ITEM, "flesh");
	public static final ResourceKey<Item> COOKED_FLESH = key(Registries.ITEM, "cooked_flesh");
	public static final ResourceKey<Item> CORRUPT_FLESH = key(Registries.ITEM, "corrupt_flesh");

	public static final ResourceKey<Item> PIGLUTTON_HEART = key(Registries.ITEM, "piglutton_heart");
	public static final ResourceKey<Item> TETHERED_HEART = key(Registries.ITEM, "tethered_heart");

	public static final ResourceKey<Item> PIGLUTTON_SPAWN_EGG = key(Registries.ITEM, "piglutton_spawn_egg");
}
