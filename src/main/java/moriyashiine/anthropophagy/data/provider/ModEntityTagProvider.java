/*
 * All Rights Reserved (c) MoriyaShiine
 */

package moriyashiine.anthropophagy.data.provider;

import moriyashiine.anthropophagy.common.init.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModEntityTagProvider extends FabricTagProvider.EntityTypeTagProvider {
	public ModEntityTagProvider(FabricDataOutput output) {
		super(output, CompletableFuture.supplyAsync(BuiltinRegistries::createWrapperLookup));
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		getOrCreateTagBuilder(ModTags.EntityTypes.PIGLUTTON_TARGETS).add(EntityType.PLAYER).add(EntityType.EVOKER).add(EntityType.ILLUSIONER).add(EntityType.PIGLIN).add(EntityType.PIGLIN_BRUTE).add(EntityType.PILLAGER).add(EntityType.VILLAGER).add(EntityType.VINDICATOR).add(EntityType.WANDERING_TRADER).add(EntityType.WITCH);
	}
}
