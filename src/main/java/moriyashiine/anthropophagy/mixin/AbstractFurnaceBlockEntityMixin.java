/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import moriyashiine.anthropophagy.common.init.ModComponentTypes;
import moriyashiine.anthropophagy.common.item.FleshItem;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {
	@WrapOperation(method = "canAcceptRecipeOutput", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;areItemsAndComponentsEqual(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;)Z"))
	private static boolean anthropophagy$compareFlesh(ItemStack stack, ItemStack otherStack, Operation<Boolean> original, DynamicRegistryManager dynamicRegistryManager, @Nullable RecipeEntry<? extends AbstractCookingRecipe> recipe, SingleStackRecipeInput input, DefaultedList<ItemStack> inventory) {
		boolean allow = original.call(stack, otherStack);
		ItemStack toCook = inventory.getFirst();
		if (allow && toCook.contains(ModComponentTypes.OWNER_NAME) && !FleshItem.getOwnerName(toCook).equals(FleshItem.getOwnerName(stack))) {
			return false;
		}
		if (!allow && toCook.contains(ModComponentTypes.OWNER_NAME) && FleshItem.getOwnerName(toCook).equals(FleshItem.getOwnerName(stack))) {
			return true;
		}
		return allow;
	}

	@WrapOperation(method = "craftRecipe", at = @At(value = "INVOKE", target = "Lnet/minecraft/recipe/AbstractCookingRecipe;craft(Lnet/minecraft/recipe/input/SingleStackRecipeInput;Lnet/minecraft/registry/RegistryWrapper$WrapperLookup;)Lnet/minecraft/item/ItemStack;"))
	private static ItemStack anthropophagy$persistFleshOwner(AbstractCookingRecipe instance, SingleStackRecipeInput singleStackRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup, Operation<ItemStack> original, DynamicRegistryManager dynamicRegistryManager, @Nullable RecipeEntry<? extends AbstractCookingRecipe> recipe, SingleStackRecipeInput input, DefaultedList<ItemStack> inventory) {
		ItemStack stack = original.call(instance, input, dynamicRegistryManager);
		if (stack.getItem() instanceof FleshItem) {
			ItemStack toCook = inventory.getFirst();
			if (toCook.getItem() instanceof FleshItem) {
				stack = stack.copy();
				FleshItem.setOwner(stack, FleshItem.getOwnerName(toCook), FleshItem.isOwnerPlayer(toCook));
			}
		}
		return stack;
	}
}
