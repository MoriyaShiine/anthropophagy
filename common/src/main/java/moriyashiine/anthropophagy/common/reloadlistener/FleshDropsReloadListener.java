package moriyashiine.anthropophagy.common.reloadlistener;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.util.FleshDrop;
import net.fabricmc.fabric.api.resource.v1.reloader.SimpleReloadListener;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.scanDirectory;

public class FleshDropsReloadListener extends SimpleReloadListener<Map<EntityType<?>, FleshDrop>> {
	public static final String DIRECTORY = Anthropophagy.MOD_ID + "/flesh_drops";

	@Override
	protected Map<EntityType<?>, FleshDrop> prepare(SharedState sharedState) {
		Map<EntityType<?>, FleshDrop> map = new HashMap<>();
		scanDirectory(sharedState, DIRECTORY, FleshDrop.CODEC).forEach(((identifier, entry) -> BuiltInRegistries.ENTITY_TYPE.getOptional(identifier).ifPresent(type -> map.put(type, entry))));
		return map;
	}

	@Override
	protected void apply(Map<EntityType<?>, FleshDrop> map, SharedState sharedState) {
		FleshDrop.DROP_MAP.clear();
		FleshDrop.DROP_MAP.putAll(map);
	}
}
