/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.client.render.entity;

import moriyashiine.anthropophagy.client.render.entity.model.PigluttonEntityModel;
import moriyashiine.anthropophagy.client.render.entity.state.PigluttonEntityRenderState;
import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.entity.PigluttonEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.util.Identifier;

public class PigluttonEntityRenderer extends MobEntityRenderer<PigluttonEntity, PigluttonEntityRenderState, PigluttonEntityModel> {
	private static final Identifier TEXTURE = Anthropophagy.id("textures/entity/living/piglutton.png");

	public PigluttonEntityRenderer(EntityRendererFactory.Context context) {
		super(context, new PigluttonEntityModel(context.getPart(PigluttonEntityModel.MODEL_LAYER)), 1.1F);
		addFeature(new HeldItemFeatureRenderer<>(this));
	}

	@Override
	public PigluttonEntityRenderState createRenderState() {
		return new PigluttonEntityRenderState();
	}

	@Override
	public Identifier getTexture(PigluttonEntityRenderState state) {
		return TEXTURE;
	}

	@Override
	public void updateRenderState(PigluttonEntity entity, PigluttonEntityRenderState state, float tickDelta) {
		super.updateRenderState(entity, state, tickDelta);
		state.idleAnimationState.copyFrom(entity.idleAnimationState);
		state.attackLeftAnimationState.copyFrom(entity.attackLeftAnimationState);
		state.attackRightAnimationState.copyFrom(entity.attackRightAnimationState);
		state.attackTusksAnimationState.copyFrom(entity.attackTusksAnimationState);
		state.eatAnimationState.copyFrom(entity.eatAnimationState);
	}
}
