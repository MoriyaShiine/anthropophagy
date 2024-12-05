/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.common.init;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.item.FleshItem;
import moriyashiine.anthropophagy.common.item.KnifeItem;
import moriyashiine.anthropophagy.common.item.TetheredHeartItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;

import java.util.function.Function;

public class ModItems {
	static {
		KnifeItem.applyKnifeSettings = true;
	}

	public static ItemGroup GROUP;

	public static final Item WOODEN_KNIFE = register("wooden_knife", settings -> new KnifeItem(ToolMaterial.WOOD, settings), settings());
	public static final Item STONE_KNIFE = register("stone_knife", settings -> new KnifeItem(ToolMaterial.STONE, settings), settings());
	public static final Item IRON_KNIFE = register("iron_knife", settings -> new KnifeItem(ToolMaterial.IRON, settings), settings());
	public static final Item GOLDEN_KNIFE = register("golden_knife", settings -> new KnifeItem(ToolMaterial.GOLD, settings), settings());
	public static final Item DIAMOND_KNIFE = register("diamond_knife", settings -> new KnifeItem(ToolMaterial.DIAMOND, settings), settings());
	public static final Item NETHERITE_KNIFE = register("netherite_knife", settings -> new KnifeItem(ToolMaterial.NETHERITE, settings), settings().fireproof());

	public static final Item FLESH = register("flesh", FleshItem::new, settings().food(ModFoodComponents.FLESH));
	public static final Item COOKED_FLESH = register("cooked_flesh", FleshItem::new, settings().food(ModFoodComponents.COOKED_FLESH));
	public static final Item CORRUPT_FLESH = register("corrupt_flesh", FleshItem::new, settings().food(ModFoodComponents.CORRUPT_FLESH, ModConsumableComponents.CORRUPT_FLESH));

	public static final Item PIGLUTTON_HEART = register("piglutton_heart", FleshItem::new, settings().food(ModFoodComponents.COOKED_FLESH));
	public static final Item TETHERED_HEART = register("tethered_heart", TetheredHeartItem::new, settings().food(ModFoodComponents.TETHERED_HEART));

	public static final Item PIGLUTTON_SPAWN_EGG = register("piglutton_spawn_egg", settings -> new SpawnEggItem(ModEntityTypes.PIGLUTTON, settings), settings());

	private static Item.Settings settings() {
		return new Item.Settings();
	}

	private static Item register(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
		return Items.register(RegistryKey.of(RegistryKeys.ITEM, Anthropophagy.id(name)), factory, settings);
	}

	public static void init() {
		GROUP = FabricItemGroup.builder().displayName(Text.translatable("itemGroup." + Anthropophagy.MOD_ID)).icon(() -> new ItemStack(ModItems.IRON_KNIFE)).entries((displayContext, entries) -> {
			entries.add(WOODEN_KNIFE);
			entries.add(STONE_KNIFE);
			entries.add(IRON_KNIFE);
			entries.add(GOLDEN_KNIFE);
			entries.add(DIAMOND_KNIFE);
			entries.add(NETHERITE_KNIFE);

			entries.add(FLESH);
			entries.add(COOKED_FLESH);
			entries.add(CORRUPT_FLESH);

			entries.add(PIGLUTTON_HEART);
			entries.add(TETHERED_HEART);

			entries.add(PIGLUTTON_SPAWN_EGG);
		}).build();
		Registry.register(Registries.ITEM_GROUP, Anthropophagy.id(Anthropophagy.MOD_ID), GROUP);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.add(PIGLUTTON_SPAWN_EGG));
		KnifeItem.applyKnifeSettings = false;
	}
}
