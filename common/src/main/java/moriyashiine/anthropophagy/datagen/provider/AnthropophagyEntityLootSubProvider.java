package moriyashiine.anthropophagy.datagen.provider;

import moriyashiine.anthropophagy.common.init.AnthropophagyEntityTypes;
import moriyashiine.anthropophagy.common.init.AnthropophagyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantedCountIncreaseFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.concurrent.CompletableFuture;

public class AnthropophagyEntityLootSubProvider extends FabricEntityLootSubProvider {
	public AnthropophagyEntityLootSubProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generate() {
		add(AnthropophagyEntityTypes.PIGLUTTON,
				LootTable.lootTable()
						.withPool(LootPool.lootPool()
								.setRolls(ConstantValue.exactly(1))
								.add((LootItem.lootTableItem(AnthropophagyItems.PIGLUTTON_HEART)
										.apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3))))
										.apply(EnchantedCountIncreaseFunction.lootingMultiplier(registries, UniformGenerator.between(0, 1))))
								.when(LootItemKilledByPlayerCondition.killedByPlayer())));
	}
}
