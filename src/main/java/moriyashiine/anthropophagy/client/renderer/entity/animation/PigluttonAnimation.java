/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.client.renderer.entity.animation;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class PigluttonAnimation {
	public static final AnimationDefinition IDLE = AnimationDefinition.Builder.withLength(1).looping()
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, 0.25F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("stomach", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0.2F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.posVec(0, 0.1F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.posVec(0, -0.1F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, -0.2F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.posVec(0, -0.1F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.posVec(0, 0.1F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, 0.2F, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0, 2.08F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 2.08F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0, -2.08F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0, -2.08F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-0.69F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-0.69F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0.69F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.69F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("mane", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-0.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-0.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(1, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(1.04F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(1.04F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-1.04F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(-1.04F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lEar", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, -2), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0, 0, -1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 0, 1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 2), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0, 0, 1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0, 0, -1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, -2), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rEar", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 2), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0, 0, 1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 0, -1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, -2), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0, 0, -1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0, 0, 1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 2), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lowerJaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(5, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(3.75F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(1.25F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(1.25F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(3.75F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(5, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("breathingRig", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0, KeyframeAnimations.scaleVec(1, 1, 1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.scaleVec(1.02F, 1.02F, 1.02F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.scaleVec(1, 1, 1), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("nose", new AnimationChannel(AnimationChannel.Targets.SCALE,
					new Keyframe(0, KeyframeAnimations.scaleVec(1, 1, 1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.scaleVec(1.03F, 1.03F, 1.03F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.scaleVec(1, 1, 1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.scaleVec(1.03F, 1.03F, 1.03F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.scaleVec(1, 1, 1), AnimationChannel.Interpolations.LINEAR)
			))
			.build();

	public static final AnimationDefinition WALK = AnimationDefinition.Builder.withLength(1).looping()
			.addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0, 2.6F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 2.6F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0, -2.6F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0, -2.6F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("stomach", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0, 0, 3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 0, 3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0, 0, -3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0, 0, -3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(2, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(2, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(2, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-2, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(1, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(2, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lEar", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0, 0, 3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 0, 3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0, 0, -3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0, 0, -3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rEar", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0, 0, -3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 0, -3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(0, 0, 3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(0, 0, 3.46F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lArm01", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(-20, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(10, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(20, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(-20, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lArm01", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0, -0.5F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0, -0.5F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lArm02", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(7.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(10, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(-42.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(7.5F, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lArm02", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lHandHoof01", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(-20, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(-20, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lHandHoof01", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 4, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, 4, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm01", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(10, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-20, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(10, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm01", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, -1, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0, 0.5F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, -1, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm02", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(10, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-31.25F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(7.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(10, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm02", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rHandHoof01", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(-20, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(-20, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rHandHoof01", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 4, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, 4, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lLeg01", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(62.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-17.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(62.5F, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lLeg01", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, -1, 1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, -1, -2), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, -1, 1), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lLeg02", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(-11.62F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.7917F, KeyframeAnimations.degreeVec(-32.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(-11.62F, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lLeg02", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 1, -1.76F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.7917F, KeyframeAnimations.posVec(0, 0, -3), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, 1, -1.76F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rLeg01", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(-17.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(62.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(-17.5F, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rLeg01", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, -1, -2), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, -1, 1), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, -1, -2), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rLeg02", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(-32.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-11.62F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rLeg02", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.posVec(0, 0, -3), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(0, 1, -1.76F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.build();

	public static final AnimationDefinition ATTACK_LEFT = AnimationDefinition.Builder.withLength(0.75F)
			.addAnimation("breathingRig", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0, -7.5F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0, -7.5F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0, 25, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, 25, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0, 15, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lowerJaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(15, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(15, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lArm01", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(6.2504F, -27.0899F, -9.7516F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-38.9337F, -40.8176F, -23.7621F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-46.4112F, 20.7886F, 12.0147F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-44.7896F, 27.3575F, 15.9825F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lArm01", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(4, 0, 4), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4167F, KeyframeAnimations.posVec(2.67F, 0, -6.33F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(2.67F, 0, -6.33F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lArm02", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-30, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lArm02", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.build();

	public static final AnimationDefinition ATTACK_RIGHT = AnimationDefinition.Builder.withLength(0.75F)
			.addAnimation("breathingRig", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(0, 7.5F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0, 7.5F, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0, -25, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0, -25, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.375F, KeyframeAnimations.degreeVec(0, -15, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lowerJaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.0833F, KeyframeAnimations.degreeVec(15, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(15, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm01", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(6.2504F, 27.0899F, 9.7516F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(-38.9337F, 40.8176F, 23.7621F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(-46.4112F, -20.7886F, -12.0147F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(-44.7896F, -27.3575F, -15.9825F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm01", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.posVec(-4, 0, 4), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4167F, KeyframeAnimations.posVec(-2.67F, 0, -6.33F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.posVec(2.67F, 0, -6.33F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm02", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-30, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm02", new AnimationChannel(AnimationChannel.Targets.POSITION,
					new Keyframe(0, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.posVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.build();

	public static final AnimationDefinition ATTACK_TUSKS = AnimationDefinition.Builder.withLength(0.75F)
			.addAnimation("neck", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(20, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-22.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2083F, KeyframeAnimations.degreeVec(12.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(-32.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lowerJaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(20, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(35, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4583F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.build();

	public static final AnimationDefinition EAT = AnimationDefinition.Builder.withLength(2.0833F)
			.addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(15, 10, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(22.5F, 10, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(10, 10, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(20, 10, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5833F, KeyframeAnimations.degreeVec(22.5F, 10, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.6667F, KeyframeAnimations.degreeVec(10, 10, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.75F, KeyframeAnimations.degreeVec(20, 10, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(10, 10, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(20, 10, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.1667F, KeyframeAnimations.degreeVec(-20, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.3333F, KeyframeAnimations.degreeVec(-20, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.4167F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.5417F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("lowerJaw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.4167F, KeyframeAnimations.degreeVec(25, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(2.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.625F, KeyframeAnimations.degreeVec(15, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.7083F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.8333F, KeyframeAnimations.degreeVec(15, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.9167F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.625F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.7083F, KeyframeAnimations.degreeVec(12.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.8333F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.9583F, KeyframeAnimations.degreeVec(12.5F, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(2.0833F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm01", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-52.3285F, -6.9511F, -2.8234F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(-52.3285F, -6.9511F, -2.8234F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1.0833F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("rArm02", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.2917F, KeyframeAnimations.degreeVec(0, 0, -17.5F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.875F, KeyframeAnimations.degreeVec(0, 0, -17.5F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(1, KeyframeAnimations.degreeVec(0, 0, 0), AnimationChannel.Interpolations.LINEAR)
			))
			.build();
}
