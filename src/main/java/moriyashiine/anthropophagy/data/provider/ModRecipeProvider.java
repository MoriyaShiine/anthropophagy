/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.data.provider;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SmokingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture);
	}

	@Override
	protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
		return new RecipeGenerator(wrapperLookup, recipeExporter) {
			@Override
			public void generate() {
				createShaped(RecipeCategory.COMBAT, ModItems.WOODEN_KNIFE).input('I', ItemTags.PLANKS).input('S', Items.STICK).pattern(" I").pattern("S ").criterion("has_stick", conditionsFromItem(Items.STICK)).offerTo(exporter);
				createShaped(RecipeCategory.COMBAT, ModItems.STONE_KNIFE).input('I', ItemTags.STONE_TOOL_MATERIALS).input('S', Items.STICK).pattern(" I").pattern("S ").criterion("has_stone", conditionsFromTag(ItemTags.STONE_TOOL_MATERIALS)).offerTo(exporter);
				createShaped(RecipeCategory.COMBAT, ModItems.IRON_KNIFE).input('I', ConventionalItemTags.IRON_INGOTS).input('S', Items.STICK).pattern(" I").pattern("S ").criterion("has_iron_ingot", conditionsFromTag(ConventionalItemTags.IRON_INGOTS)).offerTo(exporter);
				createShaped(RecipeCategory.COMBAT, ModItems.GOLDEN_KNIFE).input('I', ConventionalItemTags.GOLD_INGOTS).input('S', Items.STICK).pattern(" I").pattern("S ").criterion("has_gold_ingot", conditionsFromTag(ConventionalItemTags.GOLD_INGOTS)).offerTo(exporter);
				createShaped(RecipeCategory.COMBAT, ModItems.DIAMOND_KNIFE).input('I', ConventionalItemTags.DIAMOND_GEMS).input('S', Items.STICK).pattern(" I").pattern("S ").criterion("has_diamond", conditionsFromTag(ConventionalItemTags.DIAMOND_GEMS)).offerTo(exporter);
				offerNetheriteUpgradeRecipe(ModItems.DIAMOND_KNIFE, RecipeCategory.COMBAT, ModItems.NETHERITE_KNIFE);
				createShaped(RecipeCategory.TOOLS, ModItems.TETHERED_HEART).input('E', ConventionalItemTags.ENDER_PEARLS).input('I', ConventionalItemTags.IRON_INGOTS).input('H', ModItems.PIGLUTTON_HEART).pattern("EIE").pattern("IHI").pattern("EIE").criterion("has_piglutton_heart", conditionsFromItem(ModItems.PIGLUTTON_HEART)).offerTo(exporter);
				CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.FLESH), RecipeCategory.FOOD, ModItems.COOKED_FLESH, 0.35F, 200).criterion("has_flesh", conditionsFromItem(ModItems.FLESH)).offerTo(exporter);
				offerFoodCookingRecipe("smoking", RecipeSerializer.SMOKING, SmokingRecipe::new, 100, ModItems.FLESH, ModItems.COOKED_FLESH, 0.35F);
				offerFoodCookingRecipe("campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, CampfireCookingRecipe::new, 600, ModItems.FLESH, ModItems.COOKED_FLESH, 0.35F);
			}
		};
	}

	@Override
	public String getName() {
		return Anthropophagy.MOD_ID;
	}
}
