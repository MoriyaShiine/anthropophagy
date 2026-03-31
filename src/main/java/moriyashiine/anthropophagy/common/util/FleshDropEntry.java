/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.util;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

import java.util.HashMap;
import java.util.Map;

public record FleshDropEntry(Item raw, Item cooked) {
	private static final Codec<FleshDropEntry> SINGLE_CODEC = RecordCodecBuilder.create(instance -> instance.group(
			BuiltInRegistries.ITEM.byNameCodec().fieldOf("drop").forGetter(FleshDropEntry::raw)
	).apply(instance, drop -> new FleshDropEntry(drop, drop)));
	private static final Codec<FleshDropEntry> BOTH_CODEC = RecordCodecBuilder.create(instance -> instance.group(
			BuiltInRegistries.ITEM.byNameCodec().fieldOf("raw").forGetter(FleshDropEntry::raw),
			BuiltInRegistries.ITEM.byNameCodec().fieldOf("cooked").forGetter(FleshDropEntry::cooked)
	).apply(instance, FleshDropEntry::new));
	public static final Codec<FleshDropEntry> CODEC = Codec.either(SINGLE_CODEC, BOTH_CODEC).xmap(Either::unwrap, entry -> entry.raw() == entry.cooked() ? Either.left(entry) : Either.right(entry));

	public static final Map<EntityType<?>, FleshDropEntry> DROP_MAP = new HashMap<>();
}
