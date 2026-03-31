/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.world.item;

import moriyashiine.anthropophagy.common.init.ModComponentTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class FleshItem extends Item {
	public FleshItem(Properties properties) {
		super(properties);
	}

	@Override
	public Component getName(ItemStack stack) {
		String ownerName = getOwnerName(stack);
		if (!ownerName.isEmpty()) {
			return Component.translatable(getDescriptionId() + "_owned", ownerName);
		}
		return super.getName(stack);
	}

	public static String getOwnerName(ItemStack stack) {
		return stack.getOrDefault(ModComponentTypes.OWNER_NAME, "");
	}

	public static boolean isOwnerPlayer(ItemStack stack) {
		return stack.getOrDefault(ModComponentTypes.FROM_PLAYER, false);
	}

	public static void setOwner(ItemStack stack, String ownerName, boolean fromPlayer) {
		if (ownerName.isEmpty()) {
			return;
		}
		stack.set(ModComponentTypes.OWNER_NAME, ownerName);
		stack.set(ModComponentTypes.FROM_PLAYER, fromPlayer);
	}

	public static void setOwner(ItemStack stack, Entity entity) {
		setOwner(stack, entity.getName().getString(), entity instanceof Player);
	}
}
