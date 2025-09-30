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
import net.minecraft.text.Text;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerItem;
import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerItemGroup;

public class ModItems {
	public static ItemGroup GROUP;

	public static final Item WOODEN_KNIFE = registerItem("wooden_knife", settings -> new KnifeItem(ToolMaterial.WOOD, settings));
	public static final Item STONE_KNIFE = registerItem("stone_knife", settings -> new KnifeItem(ToolMaterial.STONE, settings));
	public static final Item COPPER_KNIFE = registerItem("copper_knife", settings -> new KnifeItem(ToolMaterial.COPPER, settings));
	public static final Item IRON_KNIFE = registerItem("iron_knife", settings -> new KnifeItem(ToolMaterial.IRON, settings));
	public static final Item GOLDEN_KNIFE = registerItem("golden_knife", settings -> new KnifeItem(ToolMaterial.GOLD, settings));
	public static final Item DIAMOND_KNIFE = registerItem("diamond_knife", settings -> new KnifeItem(ToolMaterial.DIAMOND, settings));
	public static final Item NETHERITE_KNIFE = registerItem("netherite_knife", settings -> new KnifeItem(ToolMaterial.NETHERITE, settings), settings().fireproof());

	public static final Item FLESH = registerItem("flesh", FleshItem::new, settings().food(ModFoodComponents.FLESH));
	public static final Item COOKED_FLESH = registerItem("cooked_flesh", FleshItem::new, settings().food(ModFoodComponents.COOKED_FLESH));
	public static final Item CORRUPT_FLESH = registerItem("corrupt_flesh", FleshItem::new, settings().food(ModFoodComponents.CORRUPT_FLESH, ModConsumableComponents.CORRUPT_FLESH));

	public static final Item PIGLUTTON_HEART = registerItem("piglutton_heart", FleshItem::new, settings().food(ModFoodComponents.COOKED_FLESH));
	public static final Item TETHERED_HEART = registerItem("tethered_heart", TetheredHeartItem::new, settings().food(ModFoodComponents.TETHERED_HEART));

	public static final Item PIGLUTTON_SPAWN_EGG = registerItem("piglutton_spawn_egg", SpawnEggItem::new, settings().spawnEgg(ModEntityTypes.PIGLUTTON));

	private static Item.Settings settings() {
		return new Item.Settings();
	}

	public static void init() {
		GROUP = registerItemGroup(FabricItemGroup.builder().displayName(Text.translatable("itemGroup." + Anthropophagy.MOD_ID)).icon(ModItems.IRON_KNIFE::getDefaultStack).entries((displayContext, entries) -> {
			entries.add(WOODEN_KNIFE);
			entries.add(STONE_KNIFE);
			entries.add(COPPER_KNIFE);
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
		}).build());
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.add(PIGLUTTON_SPAWN_EGG));
	}
}
