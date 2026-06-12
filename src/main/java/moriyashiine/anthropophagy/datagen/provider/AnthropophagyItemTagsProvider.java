/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.datagen.provider;

import moriyashiine.anthropophagy.common.references.AnthropophagyItemIds;
import moriyashiine.anthropophagy.common.tag.AnthropophagyItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.concurrent.CompletableFuture;

public class AnthropophagyItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
	public AnthropophagyItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {
		builder(AnthropophagyItemTags.KNIVES)
				.add(AnthropophagyItemIds.WOODEN_KNIFE)
				.add(AnthropophagyItemIds.STONE_KNIFE)
				.add(AnthropophagyItemIds.COPPER_KNIFE)
				.add(AnthropophagyItemIds.IRON_KNIFE)
				.add(AnthropophagyItemIds.GOLDEN_KNIFE)
				.add(AnthropophagyItemIds.DIAMOND_KNIFE)
				.add(AnthropophagyItemIds.NETHERITE_KNIFE);
		builder(AnthropophagyItemTags.FLESH)
				.add(AnthropophagyItemIds.FLESH)
				.add(AnthropophagyItemIds.COOKED_FLESH)
				.add(AnthropophagyItemIds.CORRUPT_FLESH)
				.add(AnthropophagyItemIds.PIGLUTTON_HEART)
				.add(AnthropophagyItemIds.TETHERED_HEART);

		builder(ItemTags.MEAT)
				.addTag(AnthropophagyItemTags.FLESH);
		builder(ItemTags.PIGLIN_LOVED)
				.add(AnthropophagyItemIds.GOLDEN_KNIFE);
		builder(ItemTags.SWORDS)
				.add(AnthropophagyItemIds.WOODEN_KNIFE)
				.add(AnthropophagyItemIds.STONE_KNIFE)
				.add(AnthropophagyItemIds.COPPER_KNIFE)
				.add(AnthropophagyItemIds.IRON_KNIFE)
				.add(AnthropophagyItemIds.GOLDEN_KNIFE)
				.add(AnthropophagyItemIds.DIAMOND_KNIFE)
				.add(AnthropophagyItemIds.NETHERITE_KNIFE);

		builder(ConventionalItemTags.RAW_MEAT_FOODS)
				.add(AnthropophagyItemIds.FLESH)
				.add(AnthropophagyItemIds.CORRUPT_FLESH)
				.add(AnthropophagyItemIds.PIGLUTTON_HEART)
				.add(AnthropophagyItemIds.TETHERED_HEART);
		builder(ConventionalItemTags.COOKED_MEAT_FOODS)
				.add(AnthropophagyItemIds.COOKED_FLESH);
	}
}
