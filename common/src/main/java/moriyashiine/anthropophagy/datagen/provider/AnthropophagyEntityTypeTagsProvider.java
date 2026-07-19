package moriyashiine.anthropophagy.datagen.provider;

import moriyashiine.anthropophagy.common.tag.AnthropophagyEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

public class AnthropophagyEntityTypeTagsProvider extends FabricTagsProvider.EntityTypeTagsProvider {
	public AnthropophagyEntityTypeTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		valueLookupBuilder(AnthropophagyEntityTypeTags.PIGLUTTON_TARGETS)
				.forceAddTag(EntityTypeTags.ILLAGER)
				.add(EntityType.PIGLIN)
				.add(EntityType.PIGLIN_BRUTE)
				.add(EntityType.PLAYER)
				.add(EntityType.VILLAGER)
				.add(EntityType.WANDERING_TRADER)
				.add(EntityType.WITCH);
	}
}
