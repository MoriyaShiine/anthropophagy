/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import moriyashiine.anthropophagy.common.init.ModComponentTypes;
import moriyashiine.anthropophagy.common.world.item.FleshItem;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {
	@WrapOperation(method = "canBurn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isSameItemSameComponents(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)Z"))
	private static boolean anthropophagy$compareFlesh(ItemStack a, ItemStack b, Operation<Boolean> original, NonNullList<ItemStack> items) {
		boolean allow = original.call(a, b);
		ItemStack toCook = items.getFirst();
		if (allow && toCook.has(ModComponentTypes.OWNER_NAME) && !FleshItem.getOwnerName(toCook).equals(FleshItem.getOwnerName(a))) {
			return false;
		}
		if (!allow && toCook.has(ModComponentTypes.OWNER_NAME) && FleshItem.getOwnerName(toCook).equals(FleshItem.getOwnerName(a))) {
			return true;
		}
		return allow;
	}

	@ModifyVariable(method = "burn", at = @At("HEAD"), argsOnly = true, ordinal = 1)
	private static ItemStack anthropophagy$persistFleshOwner(ItemStack result, NonNullList<ItemStack> items, ItemStack inputItemStack) {
		if (result.getItem() instanceof FleshItem && inputItemStack.getItem() instanceof FleshItem) {
			FleshItem.setOwner(result, FleshItem.getOwnerName(inputItemStack), FleshItem.isOwnerPlayer(inputItemStack));
		}
		return result;
	}
}
