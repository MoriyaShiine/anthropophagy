/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.client.render.entity.state;

import net.minecraft.client.render.entity.state.ArmedEntityRenderState;
import net.minecraft.entity.AnimationState;

public class PigluttonEntityRenderState extends ArmedEntityRenderState {
	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState attackLeftAnimationState = new AnimationState();
	public final AnimationState attackRightAnimationState = new AnimationState();
	public final AnimationState attackTusksAnimationState = new AnimationState();
	public final AnimationState eatAnimationState = new AnimationState();
}
