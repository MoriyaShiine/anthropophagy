/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.client;

import moriyashiine.anthropophagy.client.event.CannibalNightVisionEvent;
import moriyashiine.anthropophagy.client.render.entity.PigluttonEntityRenderer;
import moriyashiine.anthropophagy.client.render.entity.model.PigluttonEntityModel;
import moriyashiine.anthropophagy.common.init.ModEntityTypes;
import moriyashiine.strawberrylib.api.event.client.ModifyNightVisionStrengthEvent;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.EntityRendererFactories;

public class AnthropophagyClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		initEntities();
		initEvents();
	}

	private void initEntities() {
		EntityModelLayerRegistry.registerModelLayer(PigluttonEntityModel.MODEL_LAYER, PigluttonEntityModel::getTexturedModelData);
		EntityRendererFactories.register(ModEntityTypes.PIGLUTTON, PigluttonEntityRenderer::new);
	}

	private void initEvents() {
		ModifyNightVisionStrengthEvent.ADD.register(new CannibalNightVisionEvent());
	}
}
