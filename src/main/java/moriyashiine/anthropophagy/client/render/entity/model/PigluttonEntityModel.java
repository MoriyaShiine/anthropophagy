/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */
package moriyashiine.anthropophagy.client.render.entity.model;

import moriyashiine.anthropophagy.client.render.entity.animation.PigluttonAnimations;
import moriyashiine.anthropophagy.client.render.entity.state.PigluttonEntityRenderState;
import moriyashiine.anthropophagy.common.Anthropophagy;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;

public class PigluttonEntityModel extends EntityModel<PigluttonEntityRenderState> implements ModelWithArms {
	public static final EntityModelLayer MODEL_LAYER = new EntityModelLayer(Anthropophagy.id("piglutton"), "main");

	private final ModelPart neck;
	private final ModelPart[] heldItemTranslations;

	public PigluttonEntityModel(ModelPart root) {
		super(root);
		neck = root.getChild("body").getChild("neck");
		ModelPart rArm01 = root.getChild("rArm01");
		heldItemTranslations = new ModelPart[]{rArm01, rArm01.getChild("rArm02"), rArm01.getChild("rArm02").getChild("rHandHoof01")};
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.of(0.0F, 21.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		body.addChild("breathingRig", ModelPartBuilder.create().uv(72, 6).cuboid(-11.0F, -14.0F, -7.0F, 22.0F, 20.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -24.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
		ModelPartData back = body.addChild("back", ModelPartBuilder.create().uv(151, 32).cuboid(-10.0F, -3.0F, -1.0F, 20.0F, 10.0F, 24.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -31.0F, 13.0F, -0.7418F, 0.0F, 0.0F));
		back.addChild("stomach", ModelPartBuilder.create().uv(85, 87).cuboid(-12.0F, -9.0F, 1.0F, 24.0F, 19.0F, 20.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 11.0F, -1.0F, -0.0436F, 0.0F, 0.0F));
		back.addChild("tail", ModelPartBuilder.create().uv(216, 3).cuboid(-3.5F, -0.4645F, -0.2929F, 7.0F, 8.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -3.0F, 18.0F, 0.7854F, 0.0F, 0.0F));
		ModelPartData neck = body.addChild("neck", ModelPartBuilder.create(), ModelTransform.of(0.0F, -26.0F, 4.0F, 0.1309F, 0.0F, 0.0F));
		neck.addChild("cube_r1", ModelPartBuilder.create().uv(2, 81).cuboid(-10.0F, -16.0F, -6.0F, 18.0F, 21.0F, 18.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 0.0F, 0.0F, 0.9163F, 0.0F, 0.0F));
		neck.addChild("mane", ModelPartBuilder.create().uv(158, 0).cuboid(-6.0F, -3.0F, -11.0F, 10.0F, 7.0F, 21.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -17.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		ModelPartData head = neck.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -8.0F, -5.0F, 16.0F, 12.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -11.0F, -13.0F, -0.3054F, 0.0F, 0.0F));
		head.addChild("cube_r2", ModelPartBuilder.create().uv(2, 27).cuboid(-5.0F, -2.0F, -10.0F, 9.0F, 7.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.5F, -2.0F, -4.25F, 0.2182F, 0.0F, 0.0F));
		ModelPartData lEar = head.addChild("lEar", ModelPartBuilder.create(), ModelTransform.origin(8.0F, -4.0F, 1.0F));
		lEar.addChild("cube_r3", ModelPartBuilder.create().uv(59, 0).cuboid(-1.0F, -3.0F, -3.0F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, 1.0F, 0.0F, 0.0F, 0.0F, -0.2182F));
		ModelPartData rEar = head.addChild("rEar", ModelPartBuilder.create(), ModelTransform.origin(-8.0F, -4.0F, 1.0F));
		rEar.addChild("cube_r4", ModelPartBuilder.create().uv(59, 0).mirrored().cuboid(-2.0F, -3.0F, -3.0F, 3.0F, 12.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.25F, 1.0F, 0.0F, 0.0F, 0.0F, 0.2182F));
		head.addChild("nose", ModelPartBuilder.create().uv(39, 28).cuboid(-3.5F, -4.75F, -2.0F, 7.0F, 6.0F, 2.0F, new Dilation(0.2F)), ModelTransform.origin(0.0F, 2.0F, -13.0F));
		head.addChild("lowerJaw", ModelPartBuilder.create().uv(3, 55).cuboid(-5.0F, 1.0F, -13.0F, 10.0F, 2.0F, 14.0F, new Dilation(0.0F))
				.uv(57, 25).cuboid(4.0F, -7.0F, -10.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F))
				.uv(57, 25).mirrored().cuboid(-6.0F, -7.0F, -10.0F, 2.0F, 8.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(0.0F, 0.75F, -1.0F, 0.2182F, 0.0F, 0.0F));
		ModelPartData lArm01 = modelPartData.addChild("lArm01", ModelPartBuilder.create().uv(57, 46).cuboid(-6.0F, -7.0F, -4.0F, 10.0F, 18.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, -5.0F, -11.0F, -0.2705F, 0.0F, -0.1745F));
		ModelPartData lArm02 = lArm01.addChild("lArm02", ModelPartBuilder.create().uv(110, 46).cuboid(-2.7942F, 1.5062F, -9.8349F, 7.0F, 14.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 10.0F, 7.0F, -0.1745F, 0.0F, 0.0F));
		ModelPartData lHandHoof01 = lArm02.addChild("lHandHoof01", ModelPartBuilder.create(), ModelTransform.of(1.0F, 15.2562F, -7.8349F, -0.48F, 0.0F, 0.1745F));
		lHandHoof01.addChild("cube_r5", ModelPartBuilder.create().uv(73, 78).cuboid(-5.0F, -4.0F, -3.0F, 8.0F, 9.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.8252F, 0.983F, 2.8706F, 0.9163F, 0.0F, 0.0F));
		lHandHoof01.addChild("lHoofHand02", ModelPartBuilder.create().uv(108, 72).cuboid(-5.0F, -2.3254F, -5.771F, 8.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.8252F, 2.983F, 9.8706F, -0.6545F, 0.0F, 0.0F));
		ModelPartData rArm01 = modelPartData.addChild("rArm01", ModelPartBuilder.create().uv(57, 46).mirrored().cuboid(-4.0F, -7.0F, -4.0F, 10.0F, 18.0F, 11.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-12.0F, -5.0F, -11.0F, -0.2705F, 0.0F, 0.1745F));
		ModelPartData rArm02 = rArm01.addChild("rArm02", ModelPartBuilder.create().uv(110, 46).mirrored().cuboid(-4.2058F, 1.5062F, -9.8349F, 7.0F, 14.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(1.0F, 10.0F, 7.0F, -0.1745F, 0.0F, 0.0F));
		ModelPartData rHandHoof01 = rArm02.addChild("rHandHoof01", ModelPartBuilder.create(), ModelTransform.of(-1.0F, 15.2562F, -7.8349F, -0.48F, 0.0F, -0.1745F));
		rHandHoof01.addChild("cube_r6", ModelPartBuilder.create().uv(73, 78).mirrored().cuboid(-3.0F, -4.0F, -3.0F, 8.0F, 9.0F, 5.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.8252F, 0.983F, 2.8706F, 0.9163F, 0.0F, 0.0F));
		rHandHoof01.addChild("rHoofHand02", ModelPartBuilder.create().uv(108, 72).mirrored().cuboid(-3.0F, -2.3254F, -5.771F, 8.0F, 3.0F, 4.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(-0.8252F, 2.983F, 9.8706F, -0.6545F, 0.0F, 0.0F));
		ModelPartData lLeg01 = modelPartData.addChild("lLeg01", ModelPartBuilder.create().uv(168, 66).cuboid(-7.0F, -4.0F, -8.0F, 13.0F, 20.0F, 11.0F, new Dilation(0.0F))
				.uv(208, 94).cuboid(-7.0F, -4.0F, -8.0F, 13.0F, 21.0F, 11.0F, new Dilation(0.2F)), ModelTransform.of(9.0F, -5.0F, 22.0F, -0.1309F, 0.0F, -0.0436F));
		lLeg01.addChild("lLeg02", ModelPartBuilder.create().uv(222, 66).cuboid(-4.0F, -8.0F, -2.0F, 9.0F, 19.0F, 7.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 19.0F, 0.0F));
		ModelPartData rLeg01 = modelPartData.addChild("rLeg01", ModelPartBuilder.create().uv(168, 66).mirrored().cuboid(-6.0F, -4.0F, -8.0F, 13.0F, 20.0F, 11.0F, new Dilation(0.0F)).mirrored(false)
				.uv(208, 94).mirrored().cuboid(-6.0F, -4.0F, -8.0F, 13.0F, 21.0F, 11.0F, new Dilation(0.2F)).mirrored(false), ModelTransform.of(-9.0F, -5.0F, 22.0F, -0.1309F, 0.0F, 0.0436F));
		rLeg01.addChild("rLeg02", ModelPartBuilder.create().uv(222, 66).mirrored().cuboid(-5.0F, -8.0F, -2.0F, 9.0F, 19.0F, 7.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.origin(0.0F, 19.0F, 0.0F));
		return TexturedModelData.of(modelData, 256, 128);
	}

	@Override
	public void setAngles(PigluttonEntityRenderState state) {
		super.setAngles(state);
		if (!state.eatAnimationState.isRunning()) {
			neck.pitch = (float) Math.toRadians(state.pitch / 2);
			neck.yaw = (float) Math.toRadians(state.relativeHeadYaw / 2);
		}
		animateWalking(PigluttonAnimations.WALK, state.limbSwingAnimationProgress, state.limbSwingAmplitude, 4, 25);
		animate(state.idleAnimationState, PigluttonAnimations.IDLE, state.age);
		animate(state.attackLeftAnimationState, PigluttonAnimations.ATTACK_LEFT, state.age);
		animate(state.attackRightAnimationState, PigluttonAnimations.ATTACK_RIGHT, state.age);
		animate(state.attackTusksAnimationState, PigluttonAnimations.ATTACK_TUSKS, state.age);
		animate(state.eatAnimationState, PigluttonAnimations.EAT, state.age, 0.4F);
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrices) {
		for (ModelPart part : heldItemTranslations) {
			part.applyTransform(matrices);
		}
		matrices.translate(0, -0.5, 0.8);
	}
}
