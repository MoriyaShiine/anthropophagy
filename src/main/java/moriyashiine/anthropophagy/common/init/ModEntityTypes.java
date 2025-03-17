/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.init;

import moriyashiine.anthropophagy.common.ModConfig;
import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.Heightmap;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerEntityType;

public class ModEntityTypes {
	public static final EntityType<PigluttonEntity> PIGLUTTON = registerEntityType("piglutton", EntityType.Builder.create(PigluttonEntity::new, SpawnGroup.MONSTER).dimensions(3, 2.6F).spawnableFarFromPlayer(), PigluttonEntity.buildAttributes());

	public static void init() {
		SpawnRestriction.register(PIGLUTTON, SpawnLocationTypes.ON_GROUND, Heightmap.Type.WORLD_SURFACE, PigluttonEntity::canSpawn);
		if (ModConfig.enablePiglutton) {
			BiomeModifications.addSpawn(BiomeSelectors.tag(BiomeTags.IS_FOREST), PIGLUTTON.getSpawnGroup(), PIGLUTTON, 1, 1, 1);
		}
	}
}
