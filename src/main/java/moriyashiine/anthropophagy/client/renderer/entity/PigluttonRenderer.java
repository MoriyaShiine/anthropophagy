/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.client.renderer.entity;

import moriyashiine.anthropophagy.client.renderer.entity.model.PigluttonModel;
import moriyashiine.anthropophagy.client.renderer.entity.state.PigluttonRenderState;
import moriyashiine.anthropophagy.common.Anthropophagy;
import moriyashiine.anthropophagy.common.world.entity.Piglutton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.resources.Identifier;

public class PigluttonRenderer extends MobRenderer<Piglutton, PigluttonRenderState, PigluttonModel> {
	private static final Identifier TEXTURE = Anthropophagy.id("textures/entity/piglutton/piglutton.png");

	public PigluttonRenderer(EntityRendererProvider.Context context) {
		super(context, new PigluttonModel(context.bakeLayer(PigluttonModel.MODEL_LAYER)), 1.1F);
		addLayer(new ItemInHandLayer<>(this));
	}

	@Override
	public PigluttonRenderState createRenderState() {
		return new PigluttonRenderState();
	}

	@Override
	public Identifier getTextureLocation(PigluttonRenderState state) {
		return TEXTURE;
	}

	@Override
	public void extractRenderState(Piglutton entity, PigluttonRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		ArmedEntityRenderState.extractArmedEntityRenderState(entity, state, itemModelResolver, partialTicks);
		state.idleAnimationState.copyFrom(entity.idleAnimationState);
		state.attackLeftAnimationState.copyFrom(entity.attackLeftAnimationState);
		state.attackRightAnimationState.copyFrom(entity.attackRightAnimationState);
		state.attackTusksAnimationState.copyFrom(entity.attackTusksAnimationState);
		state.eatAnimationState.copyFrom(entity.eatAnimationState);
	}
}
