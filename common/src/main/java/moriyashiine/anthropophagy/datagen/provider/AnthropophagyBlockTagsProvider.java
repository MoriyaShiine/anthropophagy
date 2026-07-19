package moriyashiine.anthropophagy.datagen.provider;

import moriyashiine.anthropophagy.common.tag.AnthropophagyBlockTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class AnthropophagyBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
	public AnthropophagyBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		valueLookupBuilder(AnthropophagyBlockTags.PIGLUTTON_BREAKABLE)
				.forceAddTag(BlockTags.FENCE_GATES)
				.forceAddTag(BlockTags.LOGS)
				.forceAddTag(BlockTags.PLANKS)
				.forceAddTag(BlockTags.WOODEN_FENCES)
				.add(Blocks.BAMBOO);
	}
}
