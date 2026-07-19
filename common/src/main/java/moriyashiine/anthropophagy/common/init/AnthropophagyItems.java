package moriyashiine.anthropophagy.common.init;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.references.AnthropophagyItemIds;
import moriyashiine.anthropophagy.common.world.item.FleshItem;
import moriyashiine.anthropophagy.common.world.item.KnifeItem;
import moriyashiine.anthropophagy.common.world.item.TetheredHeartItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerCreativeModeTab;
import static moriyashiine.strawberrylib.api.module.SLibRegistries.registerItem;

public class AnthropophagyItems {
	public static CreativeModeTab TAB;

	public static final Item WOODEN_KNIFE = registerItem(AnthropophagyItemIds.WOODEN_KNIFE, settings -> new KnifeItem(ToolMaterial.WOOD, settings));
	public static final Item STONE_KNIFE = registerItem(AnthropophagyItemIds.STONE_KNIFE, settings -> new KnifeItem(ToolMaterial.STONE, settings));
	public static final Item COPPER_KNIFE = registerItem(AnthropophagyItemIds.COPPER_KNIFE, settings -> new KnifeItem(ToolMaterial.COPPER, settings));
	public static final Item IRON_KNIFE = registerItem(AnthropophagyItemIds.IRON_KNIFE, settings -> new KnifeItem(ToolMaterial.IRON, settings));
	public static final Item GOLDEN_KNIFE = registerItem(AnthropophagyItemIds.GOLDEN_KNIFE, settings -> new KnifeItem(ToolMaterial.GOLD, settings));
	public static final Item DIAMOND_KNIFE = registerItem(AnthropophagyItemIds.DIAMOND_KNIFE, settings -> new KnifeItem(ToolMaterial.DIAMOND, settings));
	public static final Item NETHERITE_KNIFE = registerItem(AnthropophagyItemIds.NETHERITE_KNIFE, settings -> new KnifeItem(ToolMaterial.NETHERITE, settings), properties().fireResistant());

	public static final Item FLESH = registerItem(AnthropophagyItemIds.FLESH, FleshItem::new, properties().food(AnthropophagyFoods.FLESH));
	public static final Item COOKED_FLESH = registerItem(AnthropophagyItemIds.COOKED_FLESH, FleshItem::new, properties().food(AnthropophagyFoods.COOKED_FLESH));
	public static final Item CORRUPT_FLESH = registerItem(AnthropophagyItemIds.CORRUPT_FLESH, FleshItem::new, properties().food(AnthropophagyFoods.CORRUPT_FLESH, AnthropophagyConsumables.CORRUPT_FLESH));

	public static final Item PIGLUTTON_HEART = registerItem(AnthropophagyItemIds.PIGLUTTON_HEART, FleshItem::new, properties().food(AnthropophagyFoods.COOKED_FLESH));
	public static final Item TETHERED_HEART = registerItem(AnthropophagyItemIds.TETHERED_HEART, TetheredHeartItem::new, properties().food(AnthropophagyFoods.TETHERED_HEART));

	public static final Item PIGLUTTON_SPAWN_EGG = registerItem(AnthropophagyItemIds.PIGLUTTON_SPAWN_EGG, SpawnEggItem::new, properties().spawnEgg(AnthropophagyEntityTypes.PIGLUTTON));

	private static Item.Properties properties() {
		return new Item.Properties();
	}

	public static void init() {
		TAB = registerCreativeModeTab(FabricCreativeModeTab.builder().title(Component.translatable("itemGroup." + Anthropophagy.MOD_ID)).icon(AnthropophagyItems.IRON_KNIFE::getDefaultInstance).displayItems((_, output) -> {
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
