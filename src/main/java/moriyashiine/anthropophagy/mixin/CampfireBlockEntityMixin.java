/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import moriyashiine.anthropophagy.common.world.item.FleshItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.entity.CampfireBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(CampfireBlockEntity.class)
public class CampfireBlockEntityMixin {
	@WrapOperation(method = "lambda$cookTick$0", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/crafting/CampfireCookingRecipe;assemble(Lnet/minecraft/world/item/crafting/SingleRecipeInput;)Lnet/minecraft/world/item/ItemStack;"))
	private static ItemStack anthropophagy$persistFleshOwner(CampfireCookingRecipe instance, SingleRecipeInput singleRecipeInput, Operation<ItemStack> original) {
		ItemStack output = original.call(instance, singleRecipeInput);
		if (output.getItem() instanceof FleshItem) {
			ItemStack toCook = singleRecipeInput.getItem(0);
			if (toCook.getItem() instanceof FleshItem) {
				FleshItem.setOwner(output, FleshItem.getOwnerName(toCook), FleshItem.isOwnerPlayer(toCook));
			}
		}
		return output;
	}
}
