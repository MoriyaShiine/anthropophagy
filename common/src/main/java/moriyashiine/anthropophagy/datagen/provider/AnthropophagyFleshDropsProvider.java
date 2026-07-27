package moriyashiine.anthropophagy.datagen.provider;

import moriyashiine.anthropophagy.api.datagen.FleshDropsProvider;
import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.references.AnthropophagyItemIds;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockItemIds;
import net.minecraft.references.ItemIds;
import net.minecraft.world.entity.EntityTypeIds;

import java.util.concurrent.CompletableFuture;

public class AnthropophagyFleshDropsProvider extends FleshDropsProvider {
	public AnthropophagyFleshDropsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(Output output) {
		output.accept(EntityTypeIds.BOGGED, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.CAMEL_HUSK, ItemIds.ROTTEN_FLESH);
		output.accept(EntityTypeIds.CAVE_SPIDER, BlockItemIds.TRIPWIRE.item());
		output.accept(EntityTypeIds.CHICKEN, ItemIds.CHICKEN, ItemIds.COOKED_CHICKEN);
		output.accept(EntityTypeIds.COD, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.COPPER_GOLEM, ItemIds.COPPER_NUGGET);
		output.accept(EntityTypeIds.COW, ItemIds.BEEF, ItemIds.COOKED_BEEF);
		output.accept(EntityTypeIds.DROWNED, ItemIds.ROTTEN_FLESH);
		output.accept(EntityTypeIds.ELDER_GUARDIAN, ItemIds.PRISMARINE_SHARD);
		output.accept(EntityTypeIds.EVOKER, AnthropophagyItemIds.CORRUPT_FLESH);
		output.accept(EntityTypeIds.GIANT, ItemIds.ROTTEN_FLESH);
		output.accept(EntityTypeIds.GUARDIAN, ItemIds.PRISMARINE_SHARD);
		output.accept(EntityTypeIds.HOGLIN, ItemIds.PORKCHOP, ItemIds.COOKED_PORKCHOP);
		output.accept(EntityTypeIds.HUSK, ItemIds.ROTTEN_FLESH);
		output.accept(EntityTypeIds.ILLUSIONER, AnthropophagyItemIds.CORRUPT_FLESH);
		output.accept(EntityTypeIds.IRON_GOLEM, ItemIds.IRON_NUGGET);
		output.accept(EntityTypeIds.MANNEQUIN, AnthropophagyItemIds.FLESH, AnthropophagyItemIds.COOKED_FLESH);
		output.accept(EntityTypeIds.MOOSHROOM, ItemIds.BEEF, ItemIds.COOKED_BEEF);
		output.accept(EntityTypeIds.PARCHED, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.PIG, ItemIds.PORKCHOP, ItemIds.COOKED_PORKCHOP);
		output.accept(EntityTypeIds.PIGLIN, ItemIds.PORKCHOP, ItemIds.COOKED_PORKCHOP);
		output.accept(EntityTypeIds.PIGLIN_BRUTE, ItemIds.PORKCHOP, ItemIds.COOKED_PORKCHOP);
		output.accept(EntityTypeIds.PILLAGER, AnthropophagyItemIds.FLESH, AnthropophagyItemIds.COOKED_FLESH);
		output.accept(EntityTypeIds.PUFFERFISH, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.PLAYER, AnthropophagyItemIds.FLESH, AnthropophagyItemIds.COOKED_FLESH);
		output.accept(EntityTypeIds.RABBIT, ItemIds.RABBIT, ItemIds.COOKED_RABBIT);
		output.accept(EntityTypeIds.RAVAGER, AnthropophagyItemIds.CORRUPT_FLESH);
		output.accept(EntityTypeIds.SALMON, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.SHEEP, ItemIds.MUTTON, ItemIds.COOKED_MUTTON);
		output.accept(EntityTypeIds.SKELETON, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.SKELETON_HORSE, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.SNOW_GOLEM, ItemIds.SNOWBALL);
		output.accept(EntityTypeIds.SPIDER, BlockItemIds.TRIPWIRE.item());
		output.accept(EntityTypeIds.STRAY, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.STRIDER, BlockItemIds.TRIPWIRE.item());
		output.accept(EntityTypeIds.TROPICAL_FISH, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.VILLAGER, AnthropophagyItemIds.FLESH, AnthropophagyItemIds.COOKED_FLESH);
		output.accept(EntityTypeIds.VINDICATOR, AnthropophagyItemIds.FLESH, AnthropophagyItemIds.COOKED_FLESH);
		output.accept(EntityTypeIds.WANDERING_TRADER, AnthropophagyItemIds.FLESH, AnthropophagyItemIds.COOKED_FLESH);
		output.accept(EntityTypeIds.WITCH, AnthropophagyItemIds.CORRUPT_FLESH);
		output.accept(EntityTypeIds.WITHER_SKELETON, ItemIds.BONE_MEAL);
		output.accept(EntityTypeIds.ZOGLIN, ItemIds.ROTTEN_FLESH);
		output.accept(EntityTypeIds.ZOMBIE, ItemIds.ROTTEN_FLESH);
		output.accept(EntityTypeIds.ZOMBIE_HORSE, ItemIds.ROTTEN_FLESH);
		output.accept(EntityTypeIds.ZOMBIE_NAUTILUS, ItemIds.ROTTEN_FLESH);
		output.accept(EntityTypeIds.ZOMBIE_VILLAGER, ItemIds.ROTTEN_FLESH);
		output.accept(EntityTypeIds.ZOMBIFIED_PIGLIN, ItemIds.ROTTEN_FLESH);
	}

	@Override
	public String getName() {
		return Anthropophagy.MOD_ID + "_flesh_drops";
	}
}
