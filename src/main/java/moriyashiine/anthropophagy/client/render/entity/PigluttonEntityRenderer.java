/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.client.render.entity;

import moriyashiine.anthropophagy.client.render.entity.model.PigluttonEntityModel;
import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class PigluttonEntityRenderer extends MobEntityRenderer<PigluttonEntity, PigluttonEntityModel<PigluttonEntity>> {
	private static final Identifier TEXTURE = Anthropophagy.id("textures/entity/living/piglutton.png");

	public PigluttonEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new PigluttonEntityModel<>(context.getPart(PigluttonEntityModel.MODEL_LAYER)), 1.1F);
		addFeature(new HeldItemFeatureRenderer<>(this, context.getHeldItemRenderer()));
	}

	@Override
	public Identifier getTexture(PigluttonEntity entity) {
		return TEXTURE;
	}
}
