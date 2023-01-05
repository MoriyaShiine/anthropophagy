/*
 * All Rights Reserved (c) 2022 MoriyaShiine
 */

package moriyashiine.anthropophagy.common.registry;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.item.FleshItem;
import moriyashiine.anthropophagy.common.item.KnifeItem;
import moriyashiine.anthropophagy.common.item.TetheredHeartItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModItems {
	public static final Item WOODEN_KNIFE = new KnifeItem(ToolMaterials.WOOD, settings());
	public static final Item STONE_KNIFE = new KnifeItem(ToolMaterials.STONE, settings());
	public static final Item GOLDEN_KNIFE = new KnifeItem(ToolMaterials.GOLD, settings());
	public static final Item IRON_KNIFE = new KnifeItem(ToolMaterials.IRON, settings());
	public static final Item DIAMOND_KNIFE = new KnifeItem(ToolMaterials.DIAMOND, settings());
	public static final Item NETHERITE_KNIFE = new KnifeItem(ToolMaterials.NETHERITE, settings().fireproof());

	public static final Item FLESH = new FleshItem(settings().food(ModFoodComponents.FLESH));
	public static final Item COOKED_FLESH = new FleshItem(settings().food(ModFoodComponents.COOKED_FLESH));
	public static final Item CORRUPT_FLESH = new FleshItem(settings().food(ModFoodComponents.CORRUPT_FLESH));

	public static final Item PIGLUTTON_HEART = new FleshItem(settings().food(FoodComponents.COOKED_BEEF));
	public static final Item TETHERED_HEART = new TetheredHeartItem(settings());

	public static final Item PIGLUTTON_SPAWN_EGG = new SpawnEggItem(ModEntityTypes.PIGLUTTON, 0x7F3D00, 0xC4C4C4, settings());

	private static Item.Settings settings() {
		return new FabricItemSettings();
	}

	public static void init() {
		FabricItemGroup.builder(Anthropophagy.id(Anthropophagy.MOD_ID)).icon(() -> new ItemStack(ModItems.IRON_KNIFE)).entries((enabledFeatures, entries, operatorEnabled) -> {
			entries.add(WOODEN_KNIFE);
			entries.add(STONE_KNIFE);
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

		Registry.register(Registries.ITEM, Anthropophagy.id("wooden_knife"), WOODEN_KNIFE);
		Registry.register(Registries.ITEM, Anthropophagy.id("stone_knife"), STONE_KNIFE);
		Registry.register(Registries.ITEM, Anthropophagy.id("golden_knife"), GOLDEN_KNIFE);
		Registry.register(Registries.ITEM, Anthropophagy.id("iron_knife"), IRON_KNIFE);
		Registry.register(Registries.ITEM, Anthropophagy.id("diamond_knife"), DIAMOND_KNIFE);
		Registry.register(Registries.ITEM, Anthropophagy.id("netherite_knife"), NETHERITE_KNIFE);

		Registry.register(Registries.ITEM, Anthropophagy.id("flesh"), FLESH);
		Registry.register(Registries.ITEM, Anthropophagy.id("cooked_flesh"), COOKED_FLESH);
		Registry.register(Registries.ITEM, Anthropophagy.id("corrupt_flesh"), CORRUPT_FLESH);

		Registry.register(Registries.ITEM, Anthropophagy.id("piglutton_heart"), PIGLUTTON_HEART);
		Registry.register(Registries.ITEM, Anthropophagy.id("tethered_heart"), TETHERED_HEART);

		Registry.register(Registries.ITEM, Anthropophagy.id("piglutton_spawn_egg"), PIGLUTTON_SPAWN_EGG);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(entries -> entries.add(PIGLUTTON_SPAWN_EGG));
	}
}
