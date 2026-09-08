package moriyashiine.anthropophagy.common.tag;

import moriyashiine.anthropophagy.common.Anthropophagy;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class AnthropophagyBlockTags {
	public static final TagKey<Block> PIGLUTTON_BREAKABLE = TagKey.create(Registries.BLOCK, Anthropophagy.id("piglutton_breakable"));
	public static final TagKey<Block> PIGLUTTON_DOES_NOT_TELEPORT_TO = TagKey.create(Registries.BLOCK, Anthropophagy.id("piglutton_does_not_teleport_to"));
}
