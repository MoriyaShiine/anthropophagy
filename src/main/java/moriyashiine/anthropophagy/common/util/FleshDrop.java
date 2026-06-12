/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.util;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

public record FleshDrop(ResourceKey<Item> raw, ResourceKey<Item> cooked) {
	private static final Codec<FleshDrop> SINGLE_CODEC = RecordCodecBuilder.create(instance -> instance.group(
			ResourceKey.codec(Registries.ITEM).fieldOf("drop").forGetter(FleshDrop::raw)
	).apply(instance, drop -> new FleshDrop(drop, drop)));
	private static final Codec<FleshDrop> BOTH_CODEC = RecordCodecBuilder.create(instance -> instance.group(
			ResourceKey.codec(Registries.ITEM).fieldOf("raw").forGetter(FleshDrop::raw),
			ResourceKey.codec(Registries.ITEM).fieldOf("cooked").forGetter(FleshDrop::cooked)
	).apply(instance, FleshDrop::new));
	public static final Codec<FleshDrop> CODEC = Codec.either(SINGLE_CODEC, BOTH_CODEC).xmap(Either::unwrap, entry -> entry.raw() == entry.cooked() ? Either.left(entry) : Either.right(entry));

	public static final Map<EntityType<?>, FleshDrop> DROP_MAP = new HashMap<>();

	public Item rawItem() {
		return BuiltInRegistries.ITEM.getValue(raw());
	}

	public Item cookedItem() {
		return BuiltInRegistries.ITEM.getValue(cooked());
	}
}
