/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.data.provider;

import moriyashiine.anthropophagy.common.init.ModEntityTypes;
import moriyashiine.anthropophagy.common.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantedCountIncreaseLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModEntityLootTableProvider extends SimpleFabricLootTableProvider {
	private final CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture;

	public ModEntityLootTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
		super(output, completableFuture, LootContextTypes.ENTITY);
		this.completableFuture = completableFuture;
	}

	@Override
	public void accept(BiConsumer<RegistryKey<LootTable>, LootTable.Builder> builder) {
		RegistryWrapper.WrapperLookup registries = completableFuture.join();
		builder.accept(
				ModEntityTypes.PIGLUTTON.getLootTableKey().orElseThrow(),
				LootTable.builder()
						.pool(LootPool.builder()
								.rolls(ConstantLootNumberProvider.create(1))
								.with((ItemEntry.builder(ModItems.PIGLUTTON_HEART)
										.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 3))))
										.apply(EnchantedCountIncreaseLootFunction.builder(registries, UniformLootNumberProvider.create(0, 1))))
								.conditionally(KilledByPlayerLootCondition.builder())));
	}
}
