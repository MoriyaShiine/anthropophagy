/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import moriyashiine.anthropophagy.common.item.FleshItem;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CampfireCookingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CampfireBlockEntity.class)
public class CampfireBlockEntityMixin {
	@WrapOperation(method = "method_17504", at = @At(value = "INVOKE", target = "Lnet/minecraft/recipe/CampfireCookingRecipe;craft(Lnet/minecraft/recipe/input/SingleStackRecipeInput;Lnet/minecraft/registry/RegistryWrapper$WrapperLookup;)Lnet/minecraft/item/ItemStack;"))
	private static ItemStack anthropophagy$persistFleshOwner(CampfireCookingRecipe instance, SingleStackRecipeInput singleStackRecipeInput, RegistryWrapper.WrapperLookup wrapperLookup, Operation<ItemStack> original) {
		ItemStack output = original.call(instance, singleStackRecipeInput, wrapperLookup);
		if (output.getItem() instanceof FleshItem) {
			ItemStack toCook = singleStackRecipeInput.getStackInSlot(0);
			if (toCook.getItem() instanceof FleshItem) {
				FleshItem.setOwner(output, FleshItem.getOwnerName(toCook), FleshItem.isOwnerPlayer(toCook));
			}
		}
		return output;
	}
}
