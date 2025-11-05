/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.data.provider;

import moriyashiine.anthropophagy.common.init.ModEntityTypes;
import moriyashiine.anthropophagy.common.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricEntityLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantedCountIncreaseLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModEntityLootTableProvider extends FabricEntityLootTableProvider {
	public ModEntityLootTableProvider(FabricDataOutput output, @NotNull CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(output, registryLookup);
	}

	@Override
	public void generate() {
		register(ModEntityTypes.PIGLUTTON,
				LootTable.builder()
						.pool(LootPool.builder()
								.rolls(ConstantLootNumberProvider.create(1))
								.with((ItemEntry.builder(ModItems.PIGLUTTON_HEART)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))))
										.apply(EnchantedCountIncreaseLootFunction.builder(registries, UniformLootNumberProvider.create(0, 1))))
								.conditionally(KilledByPlayerLootCondition.builder())));
	}
}
