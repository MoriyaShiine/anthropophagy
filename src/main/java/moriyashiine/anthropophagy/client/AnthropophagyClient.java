/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.client;

import moriyashiine.anthropophagy.client.event.CannibalNightVisionEvent;
import moriyashiine.anthropophagy.client.renderer.entity.PigluttonRenderer;
import moriyashiine.anthropophagy.client.renderer.entity.model.PigluttonModel;
import moriyashiine.anthropophagy.common.init.ModEntityTypes;
import moriyashiine.strawberrylib.api.event.client.AddNightVisionScaleEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class AnthropophagyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		initEntities();
		initEvents();
	}

	private void initEntities() {
		ModelLayerRegistry.registerModelLayer(PigluttonModel.MODEL_LAYER, PigluttonModel::createBodyLayer);
		EntityRenderers.register(ModEntityTypes.PIGLUTTON, PigluttonRenderer::new);
	}

	private void initEvents() {
		AddNightVisionScaleEvent.EVENT.register(new CannibalNightVisionEvent());
	}
}
