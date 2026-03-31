/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.common.init;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.world.item.FleshItem;
import moriyashiine.anthropophagy.common.world.item.KnifeItem;
import moriyashiine.anthropophagy.common.world.item.TetheredHeartItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerCreativeModeTab;
import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerItem;

public class ModItems {
	public static CreativeModeTab TAB;

	public static final Item WOODEN_KNIFE = registerItem("wooden_knife", settings -> new KnifeItem(ToolMaterial.WOOD, settings));
	public static final Item STONE_KNIFE = registerItem("stone_knife", settings -> new KnifeItem(ToolMaterial.STONE, settings));
	public static final Item COPPER_KNIFE = registerItem("copper_knife", settings -> new KnifeItem(ToolMaterial.COPPER, settings));
	public static final Item IRON_KNIFE = registerItem("iron_knife", settings -> new KnifeItem(ToolMaterial.IRON, settings));
	public static final Item GOLDEN_KNIFE = registerItem("golden_knife", settings -> new KnifeItem(ToolMaterial.GOLD, settings));
	public static final Item DIAMOND_KNIFE = registerItem("diamond_knife", settings -> new KnifeItem(ToolMaterial.DIAMOND, settings));
	public static final Item NETHERITE_KNIFE = registerItem("netherite_knife", settings -> new KnifeItem(ToolMaterial.NETHERITE, settings), properties().fireResistant());

	public static final Item FLESH = registerItem("flesh", FleshItem::new, properties().food(ModFoods.FLESH));
	public static final Item COOKED_FLESH = registerItem("cooked_flesh", FleshItem::new, properties().food(ModFoods.COOKED_FLESH));
	public static final Item CORRUPT_FLESH = registerItem("corrupt_flesh", FleshItem::new, properties().food(ModFoods.CORRUPT_FLESH, ModConsumables.CORRUPT_FLESH));

	public static final Item PIGLUTTON_HEART = registerItem("piglutton_heart", FleshItem::new, properties().food(ModFoods.COOKED_FLESH));
	public static final Item TETHERED_HEART = registerItem("tethered_heart", TetheredHeartItem::new, properties().food(ModFoods.TETHERED_HEART));

	public static final Item PIGLUTTON_SPAWN_EGG = registerItem("piglutton_spawn_egg", SpawnEggItem::new, properties().spawnEgg(ModEntityTypes.PIGLUTTON));

	private static Item.Properties properties() {
		return new Item.Properties();
	}

	public static void init() {
		TAB = registerCreativeModeTab(FabricCreativeModeTab.builder().title(Component.translatable("itemGroup." + Anthropophagy.MOD_ID)).icon(ModItems.IRON_KNIFE::getDefaultInstance).displayItems((_, output) -> {
			output.accept(WOODEN_KNIFE);
			output.accept(STONE_KNIFE);
			output.accept(COPPER_KNIFE);
			output.accept(IRON_KNIFE);
			output.accept(GOLDEN_KNIFE);
			output.accept(DIAMOND_KNIFE);
			output.accept(NETHERITE_KNIFE);

			output.accept(FLESH);
			output.accept(COOKED_FLESH);
			output.accept(CORRUPT_FLESH);

			output.accept(PIGLUTTON_HEART);
			output.accept(TETHERED_HEART);

			output.accept(PIGLUTTON_SPAWN_EGG);
		}).build());
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(output -> output.accept(PIGLUTTON_SPAWN_EGG));
	}
}
