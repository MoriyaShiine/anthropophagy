/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.datagen.provider;

import moriyashiine.anthropophagy.common.tag.AnthropophagyEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityTypeIds;

import java.util.concurrent.CompletableFuture;

public class AnthropophagyEntityTypeTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {
	public AnthropophagyEntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		builder(AnthropophagyEntityTypeTags.PIGLUTTON_TARGETS)
				.forceAddTag(EntityTypeTags.ILLAGER)
				.add(EntityTypeIds.PIGLIN)
				.add(EntityTypeIds.PIGLIN_BRUTE)
				.add(EntityTypeIds.PLAYER)
				.add(EntityTypeIds.VILLAGER)
				.add(EntityTypeIds.WANDERING_TRADER)
				.add(EntityTypeIds.WITCH);
	}
}
