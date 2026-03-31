/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.client.renderer.entity.state;

import net.minecraft.client.renderer.entity.state.ArmedEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class PigluttonRenderState extends ArmedEntityRenderState {
	public final AnimationState idleAnimationState = new AnimationState();
	public final AnimationState attackLeftAnimationState = new AnimationState();
	public final AnimationState attackRightAnimationState = new AnimationState();
	public final AnimationState attackTusksAnimationState = new AnimationState();
	public final AnimationState eatAnimationState = new AnimationState();
}
