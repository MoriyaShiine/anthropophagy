/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.datagen.provider;

import moriyashiine.anthropophagy.common.init.AnthropophagyItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class AnthropophagyModelProvider extends FabricModelProvider {
	public AnthropophagyModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators generators) {
	}

	@Override
	public void generateItemModels(ItemModelGenerators generators) {
		generators.generateFlatItem(AnthropophagyItems.WOODEN_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(AnthropophagyItems.STONE_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(AnthropophagyItems.COPPER_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(AnthropophagyItems.IRON_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(AnthropophagyItems.GOLDEN_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(AnthropophagyItems.DIAMOND_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(AnthropophagyItems.NETHERITE_KNIFE, ModelTemplates.FLAT_HANDHELD_ITEM);
		generators.generateFlatItem(AnthropophagyItems.FLESH, ModelTemplates.FLAT_ITEM);
		generators.generateFlatItem(AnthropophagyItems.COOKED_FLESH, ModelTemplates.FLAT_ITEM);
		generators.generateFlatItem(AnthropophagyItems.CORRUPT_FLESH, ModelTemplates.FLAT_ITEM);
		generators.generateFlatItem(AnthropophagyItems.PIGLUTTON_HEART, ModelTemplates.FLAT_ITEM);
		generators.generateFlatItem(AnthropophagyItems.TETHERED_HEART, ModelTemplates.FLAT_ITEM);
		generators.generateFlatItem(AnthropophagyItems.PIGLUTTON_SPAWN_EGG, ModelTemplates.FLAT_ITEM);
	}
}
