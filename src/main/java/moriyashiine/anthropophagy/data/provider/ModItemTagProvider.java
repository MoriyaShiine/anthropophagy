/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.data.provider;

import moriyashiine.anthropophagy.common.init.ModItems;
import moriyashiine.anthropophagy.common.tag.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		valueLookupBuilder(ModItemTags.KNIVES)
				.add(ModItems.WOODEN_KNIFE)
				.add(ModItems.STONE_KNIFE)
				.add(ModItems.COPPER_KNIFE)
				.add(ModItems.IRON_KNIFE)
				.add(ModItems.GOLDEN_KNIFE)
				.add(ModItems.DIAMOND_KNIFE)
				.add(ModItems.NETHERITE_KNIFE);
		valueLookupBuilder(ModItemTags.FLESH)
				.add(ModItems.FLESH)
				.add(ModItems.COOKED_FLESH)
				.add(ModItems.CORRUPT_FLESH)
				.add(ModItems.PIGLUTTON_HEART)
				.add(ModItems.TETHERED_HEART);

		valueLookupBuilder(ItemTags.MEAT)
				.addTag(ModItemTags.FLESH);
		valueLookupBuilder(ItemTags.PIGLIN_LOVED)
				.add(ModItems.GOLDEN_KNIFE);
		valueLookupBuilder(ItemTags.SWORDS)
				.add(ModItems.WOODEN_KNIFE)
				.add(ModItems.STONE_KNIFE)
				.add(ModItems.COPPER_KNIFE)
				.add(ModItems.IRON_KNIFE)
				.add(ModItems.GOLDEN_KNIFE)
				.add(ModItems.DIAMOND_KNIFE)
				.add(ModItems.NETHERITE_KNIFE);

		valueLookupBuilder(ConventionalItemTags.RAW_MEAT_FOODS)
				.add(ModItems.FLESH)
				.add(ModItems.CORRUPT_FLESH)
				.add(ModItems.PIGLUTTON_HEART)
				.add(ModItems.TETHERED_HEART);
		valueLookupBuilder(ConventionalItemTags.COOKED_MEAT_FOODS)
				.add(ModItems.COOKED_FLESH);
	}
}
