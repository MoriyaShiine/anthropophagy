package moriyashiine.anthropophagy.datagen.provider;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.init.AnthropophagyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;

import java.util.concurrent.CompletableFuture;

public class AnthropophagyRecipeProvider extends FabricRecipeProvider {
	public AnthropophagyRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipes, BootstrapContext<Advancement> advancements) {
		return new RecipeProvider(recipes, advancements) {
			@Override
			public void buildRecipes() {
				shaped(RecipeCategory.COMBAT, AnthropophagyItems.WOODEN_KNIFE).define('M', ItemTags.WOODEN_TOOL_MATERIALS).define('S', Items.STICK).pattern(" M").pattern("S ").unlockedBy("has_wood", has(ItemTags.WOODEN_TOOL_MATERIALS)).save(output);
				shaped(RecipeCategory.COMBAT, AnthropophagyItems.STONE_KNIFE).define('M', ItemTags.STONE_TOOL_MATERIALS).define('S', Items.STICK).pattern(" M").pattern("S ").unlockedBy("has_stone", has(ItemTags.STONE_TOOL_MATERIALS)).save(output);
				shaped(RecipeCategory.COMBAT, AnthropophagyItems.COPPER_KNIFE).define('M', ItemTags.COPPER_TOOL_MATERIALS).define('S', Items.STICK).pattern(" M").pattern("S ").unlockedBy("has_copper", has(ItemTags.COPPER_TOOL_MATERIALS)).save(output);
				shaped(RecipeCategory.COMBAT, AnthropophagyItems.IRON_KNIFE).define('M', ItemTags.IRON_TOOL_MATERIALS).define('S', Items.STICK).pattern(" M").pattern("S ").unlockedBy("has_iron_ingot", has(ItemTags.IRON_TOOL_MATERIALS)).save(output);
				shaped(RecipeCategory.COMBAT, AnthropophagyItems.GOLDEN_KNIFE).define('M', ItemTags.GOLD_TOOL_MATERIALS).define('S', Items.STICK).pattern(" M").pattern("S ").unlockedBy("has_gold_ingot", has(ItemTags.GOLD_TOOL_MATERIALS)).save(output);
				shaped(RecipeCategory.COMBAT, AnthropophagyItems.DIAMOND_KNIFE).define('M', ItemTags.DIAMOND_TOOL_MATERIALS).define('S', Items.STICK).pattern(" M").pattern("S ").unlockedBy("has_diamond", has(ItemTags.DIAMOND_TOOL_MATERIALS)).save(output);
				netheriteSmithing(AnthropophagyItems.DIAMOND_KNIFE, RecipeCategory.COMBAT, AnthropophagyItems.NETHERITE_KNIFE);
				shaped(RecipeCategory.TOOLS, AnthropophagyItems.TETHERED_HEART).define('E', ConventionalItemTags.ENDER_PEARLS).define('I', ConventionalItemTags.IRON_INGOTS).define('H', AnthropophagyItems.PIGLUTTON_HEART).pattern("EIE").pattern("IHI").pattern("EIE").unlockedBy("has_piglutton_heart", has(AnthropophagyItems.PIGLUTTON_HEART)).save(output);
				SimpleCookingRecipeBuilder.smelting(Ingredient.of(AnthropophagyItems.FLESH), RecipeCategory.FOOD, CookingBookCategory.FOOD, AnthropophagyItems.COOKED_FLESH, 0.35F, 200).unlockedBy("has_flesh", has(AnthropophagyItems.FLESH)).save(output);
				simpleCookingRecipe("smoking", SmokingRecipe::new, 100, AnthropophagyItems.FLESH, AnthropophagyItems.COOKED_FLESH, 0.35F);
				simpleCookingRecipe("campfire_cooking", CampfireCookingRecipe::new, 600, AnthropophagyItems.FLESH, AnthropophagyItems.COOKED_FLESH, 0.35F);
			}
		};
	}

	@Override
	public String getName() {
		return Anthropophagy.MOD_ID + "_recipes";
	}
}
