package moriyashiine.anthropophagy.api.datagen;

import moriyashiine.anthropophagy.common.reloadlistener.FleshDropsReloadListener;
import moriyashiine.anthropophagy.common.util.FleshDrop;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public abstract class FleshDropsProvider extends FabricCodecDataProvider<FleshDrop> {
	public FleshDropsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture, PackOutput.Target.DATA_PACK, FleshDropsReloadListener.DIRECTORY, FleshDrop.CODEC);
	}

	@Override
	protected final void configure(BiConsumer<Identifier, FleshDrop> provider, HolderLookup.Provider registries) {
		configure((type, raw, cooked) -> provider.accept(type.identifier(), new FleshDrop(raw, cooked)));
	}

	protected abstract void configure(Output output);

	@FunctionalInterface
	protected interface Output {
		void accept(ResourceKey<EntityType<?>> type, ResourceKey<Item> raw, ResourceKey<Item> cooked);

		default void accept(ResourceKey<EntityType<?>> type, BlockItemId raw, ResourceKey<Item> cooked) {
			accept(type, raw.item(), cooked);
		}

		default void accept(ResourceKey<EntityType<?>> type, ResourceKey<Item> raw, BlockItemId cooked) {
			accept(type, raw, cooked.item());
		}

		default void accept(ResourceKey<EntityType<?>> type, BlockItemId raw, BlockItemId cooked) {
			accept(type, raw.item(), cooked.item());
		}

		default void accept(ResourceKey<EntityType<?>> type, ResourceKey<Item> drop) {
			accept(type, drop, drop);
		}

		default void accept(ResourceKey<EntityType<?>> type, BlockItemId drop) {
			accept(type, drop.item());
		}
	}
}
