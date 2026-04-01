/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.reloadlistener;

import com.mojang.serialization.JsonOps;
import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.util.FleshDrop;
import moriyashiine.strawberrylib.api.module.SLibRegistries;
import net.fabricmc.fabric.api.resource.v1.ResourceLoader;
import net.fabricmc.fabric.api.resource.v1.reloader.SimpleReloadListener;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.world.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

public class FleshDropsReloadListener extends SimpleReloadListener<Map<EntityType<?>, FleshDrop>> {
	public static final String DIRECTORY = Anthropophagy.MOD_ID + "/flesh_drops";

	@Override
	protected Map<EntityType<?>, FleshDrop> prepare(SharedState sharedState) {
		Map<Identifier, FleshDrop> unmapped = new HashMap<>();
		SLibRegistries.scanErrorless(DIRECTORY, () -> SimpleJsonResourceReloadListener.scanDirectory(sharedState.resourceManager(), FileToIdConverter.json(DIRECTORY), sharedState.get(ResourceLoader.REGISTRY_LOOKUP_KEY).createSerializationContext(JsonOps.INSTANCE), FleshDrop.CODEC, unmapped));
		Map<EntityType<?>, FleshDrop> map = new HashMap<>();
		unmapped.forEach(((identifier, entry) -> BuiltInRegistries.ENTITY_TYPE.getOptional(identifier).ifPresent(type -> map.put(type, entry))));
		return map;
	}

	@Override
	protected void apply(Map<EntityType<?>, FleshDrop> map, SharedState sharedState) {
		FleshDrop.DROP_MAP.clear();
		FleshDrop.DROP_MAP.putAll(map);
	}
}