/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.reloadlisteners;

import com.mojang.serialization.JsonOps;
import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.util.FleshDropEntry;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.reloader.SimpleReloadListener;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.world.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class FleshDropsReloadListener extends SimpleReloadListener<Map<EntityType<?>, FleshDropEntry>> {
	public static final String DIRECTORY = Anthropophagy.MOD_ID + "/flesh_drops";

	@Override
	protected Map<EntityType<?>, FleshDropEntry> prepare(SharedState sharedState) {
		Map<Identifier, FleshDropEntry> unmapped = new HashMap<>();
		SimpleJsonResourceReloadListener.scanDirectory(sharedState.resourceManager(), FileToIdConverter.json(DIRECTORY), sharedState.get(ResourceLoader.REGISTRY_LOOKUP_KEY).createSerializationContext(JsonOps.INSTANCE), FleshDropEntry.CODEC, unmapped);
		Map<EntityType<?>, FleshDropEntry> map = new HashMap<>();
		unmapped.forEach(((identifier, entry) -> BuiltInRegistries.ENTITY_TYPE.getOptional(identifier).ifPresent(type -> map.put(type, entry))));
		return map;
	}

	@Override
	protected void apply(Map<EntityType<?>, FleshDropEntry> map, SharedState sharedState) {
		FleshDropEntry.DROP_MAP.clear();
		FleshDropEntry.DROP_MAP.putAll(map);
	}
}