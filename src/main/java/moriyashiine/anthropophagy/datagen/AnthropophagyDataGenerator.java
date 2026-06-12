/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.datagen;

import moriyashiine.anthropophagy.datagen.provider.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AnthropophagyDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(AnthropophagyAdvancementProvider::new);
		pack.addProvider(AnthropophagyBlockTagsProvider::new);
		pack.addProvider(AnthropophagyEntityLootSubProvider::new);
		pack.addProvider(AnthropophagyEntityTypeTagsProvider::new);
		pack.addProvider(AnthropophagyFleshDropsProvider::new);
		pack.addProvider(AnthropophagyItemTagsProvider::new);
		pack.addProvider(AnthropophagyModelProvider::new);
		pack.addProvider(AnthropophagyRecipeProvider::new);
		pack.addProvider(AnthropophagySoundsProvider::new);
	}
}
