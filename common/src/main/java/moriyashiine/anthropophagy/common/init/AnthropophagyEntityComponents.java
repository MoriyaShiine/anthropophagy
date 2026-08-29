package moriyashiine.anthropophagy.common.init;

import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.component.entity.CannibalComponent;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy;

public class AnthropophagyEntityComponents implements EntityComponentInitializer {
	public static final ComponentKey<CannibalComponent> CANNIBAL = ComponentRegistry.getOrCreate(Anthropophagy.id("cannibal"), CannibalComponent.class);

	@Override
	public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
		registry.registerForPlayers(CANNIBAL, CannibalComponent::new, RespawnCopyStrategy.LOSSLESS_ONLY);
	}
}
