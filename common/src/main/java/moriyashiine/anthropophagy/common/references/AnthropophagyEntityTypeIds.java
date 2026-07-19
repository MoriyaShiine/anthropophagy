package moriyashiine.anthropophagy.common.references;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;

import static moriyashiine.strawberrylib.api.module.SLibRegistries.key;

public class AnthropophagyEntityTypeIds {
	public static final ResourceKey<EntityType<?>> PIGLUTTON = key(Registries.ENTITY_TYPE, "piglutton");
}
