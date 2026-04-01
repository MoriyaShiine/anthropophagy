/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.data.provider;

import com.mojang.datafixers.util.Either;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.init.ModItems;
import moriyashiine.anthropophagy.common.reloadlistener.FleshDropsReloadListener;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricCodecDataProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModFleshDropsProvider extends FabricCodecDataProvider<ModFleshDropsProvider.DatagenFleshDrop> {
	public ModFleshDropsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture, PackOutput.Target.DATA_PACK, FleshDropsReloadListener.DIRECTORY, DatagenFleshDrop.CODEC);
	}

	@Override
	protected final void configure(BiConsumer<Identifier, DatagenFleshDrop> provider, HolderLookup.Provider registries) {
		configure((typeId, rawId, cookedId) -> provider.accept(typeId, new DatagenFleshDrop(rawId, cookedId)));
	}

	@Override
	public String getName() {
		return Anthropophagy.MOD_ID + "_flesh_drop_entries";
	}

	protected void configure(Output output) {
		output.accept(EntityType.BOGGED, Items.BONE_MEAL);
		output.accept(EntityType.CAMEL_HUSK, Items.ROTTEN_FLESH);
		output.accept(EntityType.CAVE_SPIDER, Items.STRING);
		output.accept(EntityType.CHICKEN, Items.CHICKEN, Items.COOKED_CHICKEN);
		output.accept(EntityType.COD, Items.BONE_MEAL);
		output.accept(EntityType.COPPER_GOLEM, Items.COPPER_NUGGET);
		output.accept(EntityType.COW, Items.BEEF, Items.COOKED_BEEF);
		output.accept(EntityType.DROWNED, Items.ROTTEN_FLESH);
		output.accept(EntityType.ELDER_GUARDIAN, Items.PRISMARINE_SHARD);
		output.accept(EntityType.EVOKER, ModItems.CORRUPT_FLESH);
		output.accept(EntityType.GIANT, Items.ROTTEN_FLESH);
		output.accept(EntityType.GUARDIAN, Items.PRISMARINE_SHARD);
		output.accept(EntityType.HOGLIN, Items.PORKCHOP, Items.COOKED_PORKCHOP);
		output.accept(EntityType.HUSK, Items.ROTTEN_FLESH);
		output.accept(EntityType.ILLUSIONER, ModItems.CORRUPT_FLESH);
		output.accept(EntityType.IRON_GOLEM, Items.IRON_NUGGET);
		output.accept(EntityType.MANNEQUIN, ModItems.FLESH, ModItems.COOKED_FLESH);
		output.accept(EntityType.MOOSHROOM, Items.BEEF, Items.COOKED_BEEF);
		output.accept(EntityType.PARCHED, Items.BONE_MEAL);
		output.accept(EntityType.PIG, Items.PORKCHOP, Items.COOKED_PORKCHOP);
		output.accept(EntityType.PIGLIN, Items.PORKCHOP, Items.COOKED_PORKCHOP);
		output.accept(EntityType.PIGLIN_BRUTE, Items.PORKCHOP, Items.COOKED_PORKCHOP);
		output.accept(EntityType.PILLAGER, ModItems.FLESH, ModItems.COOKED_FLESH);
		output.accept(EntityType.PUFFERFISH, Items.BONE_MEAL);
		output.accept(EntityType.PLAYER, ModItems.FLESH, ModItems.COOKED_FLESH);
		output.accept(EntityType.RABBIT, Items.RABBIT, Items.COOKED_RABBIT);
		output.accept(EntityType.RAVAGER, ModItems.CORRUPT_FLESH);
		output.accept(EntityType.SALMON, Items.BONE_MEAL);
		output.accept(EntityType.SHEEP, Items.MUTTON, Items.COOKED_MUTTON);
		output.accept(EntityType.SKELETON, Items.BONE_MEAL);
		output.accept(EntityType.SKELETON_HORSE, Items.BONE_MEAL);
		output.accept(EntityType.SNOW_GOLEM, Items.SNOWBALL);
		output.accept(EntityType.SPIDER, Items.STRING);
		output.accept(EntityType.STRAY, Items.BONE_MEAL);
		output.accept(EntityType.STRIDER, Items.STRING);
		output.accept(EntityType.TROPICAL_FISH, Items.BONE_MEAL);
		output.accept(EntityType.VILLAGER, ModItems.FLESH, ModItems.COOKED_FLESH);
		output.accept(EntityType.VINDICATOR, ModItems.FLESH, ModItems.COOKED_FLESH);
		output.accept(EntityType.WANDERING_TRADER, ModItems.FLESH, ModItems.COOKED_FLESH);
		output.accept(EntityType.WITCH, ModItems.CORRUPT_FLESH);
		output.accept(EntityType.WITHER_SKELETON, Items.BONE_MEAL);
		output.accept(EntityType.ZOGLIN, Items.ROTTEN_FLESH);
		output.accept(EntityType.ZOMBIE, Items.ROTTEN_FLESH);
		output.accept(EntityType.ZOMBIE_HORSE, Items.ROTTEN_FLESH);
		output.accept(EntityType.ZOMBIE_NAUTILUS, Items.ROTTEN_FLESH);
		output.accept(EntityType.ZOMBIE_VILLAGER, Items.ROTTEN_FLESH);
		output.accept(EntityType.ZOMBIFIED_PIGLIN, Items.ROTTEN_FLESH);
	}

	@FunctionalInterface
	public interface Output {
		void accept(Identifier typeId, Identifier rawId, Identifier cookedId);

		default void accept(Identifier typeId, Identifier dropId) {
			accept(typeId, dropId, dropId);
		}

		default void accept(EntityType<?> type, Identifier rawId, Identifier cookedId) {
			accept(BuiltInRegistries.ENTITY_TYPE.getKey(type), rawId, cookedId);
		}

		default void accept(EntityType<?> type, Identifier dropId) {
			accept(type, dropId, dropId);
		}

		default void accept(EntityType<?> type, Item raw, Item cooked) {
			accept(type, BuiltInRegistries.ITEM.getKey(raw), BuiltInRegistries.ITEM.getKey(cooked));
		}

		default void accept(EntityType<?> type, Item drop) {
			accept(type, drop, drop);
		}
	}

	public record DatagenFleshDrop(Identifier raw, Identifier cooked) {
		private static final Codec<DatagenFleshDrop> SINGLE_CODEC = RecordCodecBuilder.create(instance -> instance.group(
				Identifier.CODEC.fieldOf("drop").forGetter(DatagenFleshDrop::raw)
		).apply(instance, drop -> new DatagenFleshDrop(drop, drop)));
		private static final Codec<DatagenFleshDrop> BOTH_CODEC = RecordCodecBuilder.create(instance -> instance.group(
				Identifier.CODEC.fieldOf("raw").forGetter(DatagenFleshDrop::raw),
				Identifier.CODEC.fieldOf("cooked").forGetter(DatagenFleshDrop::cooked)
		).apply(instance, DatagenFleshDrop::new));
		public static final Codec<DatagenFleshDrop> CODEC = Codec.either(SINGLE_CODEC, BOTH_CODEC).xmap(Either::unwrap, entry -> entry.raw() == entry.cooked() ? Either.left(entry) : Either.right(entry));
	}
}
