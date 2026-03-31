/*
 * Copyright (c) MoriyaShiine. All Rights Reserved.
 */

package moriyashiine.anthropophagy.client.renderer.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import moriyashiine.anthropophagy.client.renderer.entity.animation.PigluttonAnimation;
import moriyashiine.anthropophagy.client.renderer.entity.state.PigluttonRenderState;
import moriyashiine.anthropophagy.common.Anthropophagy;
import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.HumanoidArm;

public class PigluttonModel extends EntityModel<PigluttonRenderState> implements ArmedModel<PigluttonRenderState> {
	public static final ModelLayerLocation MODEL_LAYER = new ModelLayerLocation(Anthropophagy.id("piglutton"), "main");

	private final ModelPart neck;
	private final ModelPart[] heldItemTranslations;

	private final KeyframeAnimation idleAnimation;
	private final KeyframeAnimation walkAnimation;
	private final KeyframeAnimation attackLeftAnimation;
	private final KeyframeAnimation attackRightAnimation;
	private final KeyframeAnimation attackTusksAnimation;
	private final KeyframeAnimation eatAnimation;

	public PigluttonModel(ModelPart root) {
		super(root);
		neck = root.getChild("body").getChild("neck");
		ModelPart rArm01 = root.getChild("rArm01");
		heldItemTranslations = new ModelPart[]{rArm01, rArm01.getChild("rArm02"), rArm01.getChild("rArm02").getChild("rHandHoof01")};

		idleAnimation = PigluttonAnimation.IDLE.bake(root);
		walkAnimation = PigluttonAnimation.WALK.bake(root);
		attackLeftAnimation = PigluttonAnimation.ATTACK_LEFT.bake(root);
		attackRightAnimation = PigluttonAnimation.ATTACK_RIGHT.bake(root);
		attackTusksAnimation = PigluttonAnimation.ATTACK_TUSKS.bake(root);
		eatAnimation = PigluttonAnimation.EAT.bake(root);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 21.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
		body.addOrReplaceChild("breathingRig", CubeListBuilder.create().texOffs(72, 6).addBox(-11.0F, -14.0F, -7.0F, 22.0F, 20.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
		PartDefinition back = body.addOrReplaceChild("back", CubeListBuilder.create().texOffs(151, 32).addBox(-10.0F, -3.0F, -1.0F, 20.0F, 10.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.0F, 13.0F, -0.7418F, 0.0F, 0.0F));
		back.addOrReplaceChild("stomach", CubeListBuilder.create().texOffs(85, 87).addBox(-12.0F, -9.0F, 1.0F, 24.0F, 19.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, -1.0F, -0.0436F, 0.0F, 0.0F));
		back.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(216, 3).addBox(-3.5F, -0.4645F, -0.2929F, 7.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 18.0F, 0.7854F, 0.0F, 0.0F));
		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -26.0F, 4.0F, 0.1309F, 0.0F, 0.0F));
		neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(2, 81).addBox(-10.0F, -16.0F, -6.0F, 18.0F, 21.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.9163F, 0.0F, 0.0F));
		neck.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(158, 0).addBox(-6.0F, -3.0F, -11.0F, 10.0F, 7.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -17.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, -5.0F, 16.0F, 12.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, -13.0F, -0.3054F, 0.0F, 0.0F));
		head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(2, 27).addBox(-5.0F, -2.0F, -10.0F, 9.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.0F, -4.25F, 0.2182F, 0.0F, 0.0F));
		PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create(), PartPose.offset(8.0F, -4.0F, 1.0F));
		lEar.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(59, 0).addBox(-1.0F, -3.0F, -3.0F, 3.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 1.0F, 0.0F, 0.0F, 0.0F, -0.2182F));
		PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create(), PartPose.offset(-8.0F, -4.0F, 1.0F));
		rEar.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(59, 0).mirror().addBox(-2.0F, -3.0F, -3.0F, 3.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 1.0F, 0.0F, 0.0F, 0.0F, 0.2182F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(39, 28).addBox(-3.5F, -4.75F, -2.0F, 7.0F, 6.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 2.0F, -13.0F));
		head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(3, 55).addBox(-5.0F, 1.0F, -13.0F, 10.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(57, 25).addBox(4.0F, -7.0F, -10.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(57, 25).mirror().addBox(-6.0F, -7.0F, -10.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.75F, -1.0F, 0.2182F, 0.0F, 0.0F));
		PartDefinition lArm01 = root.addOrReplaceChild("lArm01", CubeListBuilder.create().texOffs(57, 46).addBox(-6.0F, -7.0F, -4.0F, 10.0F, 18.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -5.0F, -11.0F, -0.2705F, 0.0F, -0.1745F));
		PartDefinition lArm02 = lArm01.addOrReplaceChild("lArm02", CubeListBuilder.create().texOffs(110, 46).addBox(-2.7942F, 1.5062F, -9.8349F, 7.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 10.0F, 7.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition lHandHoof01 = lArm02.addOrReplaceChild("lHandHoof01", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 15.2562F, -7.8349F, -0.48F, 0.0F, 0.1745F));
		lHandHoof01.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(73, 78).addBox(-5.0F, -4.0F, -3.0F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8252F, 0.983F, 2.8706F, 0.9163F, 0.0F, 0.0F));
		lHandHoof01.addOrReplaceChild("lHoofHand02", CubeListBuilder.create().texOffs(108, 72).addBox(-5.0F, -2.3254F, -5.771F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8252F, 2.983F, 9.8706F, -0.6545F, 0.0F, 0.0F));
		PartDefinition rArm01 = root.addOrReplaceChild("rArm01", CubeListBuilder.create().texOffs(57, 46).mirror().addBox(-4.0F, -7.0F, -4.0F, 10.0F, 18.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.0F, -5.0F, -11.0F, -0.2705F, 0.0F, 0.1745F));
		PartDefinition rArm02 = rArm01.addOrReplaceChild("rArm02", CubeListBuilder.create().texOffs(110, 46).mirror().addBox(-4.2058F, 1.5062F, -9.8349F, 7.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 10.0F, 7.0F, -0.1745F, 0.0F, 0.0F));
		PartDefinition rHandHoof01 = rArm02.addOrReplaceChild("rHandHoof01", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 15.2562F, -7.8349F, -0.48F, 0.0F, -0.1745F));
		rHandHoof01.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(73, 78).mirror().addBox(-3.0F, -4.0F, -3.0F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8252F, 0.983F, 2.8706F, 0.9163F, 0.0F, 0.0F));
		rHandHoof01.addOrReplaceChild("rHoofHand02", CubeListBuilder.create().texOffs(108, 72).mirror().addBox(-3.0F, -2.3254F, -5.771F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8252F, 2.983F, 9.8706F, -0.6545F, 0.0F, 0.0F));
		PartDefinition lLeg01 = root.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(168, 66).addBox(-7.0F, -4.0F, -8.0F, 13.0F, 20.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(208, 94).addBox(-7.0F, -4.0F, -8.0F, 13.0F, 21.0F, 11.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(9.0F, -5.0F, 22.0F, -0.1309F, 0.0F, -0.0436F));
		lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(222, 66).addBox(-4.0F, -8.0F, -2.0F, 9.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 19.0F, 0.0F));
		PartDefinition rLeg01 = root.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(168, 66).mirror().addBox(-6.0F, -4.0F, -8.0F, 13.0F, 20.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(208, 94).mirror().addBox(-6.0F, -4.0F, -8.0F, 13.0F, 21.0F, 11.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -5.0F, 22.0F, -0.1309F, 0.0F, 0.0436F));
		rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(222, 66).mirror().addBox(-5.0F, -8.0F, -2.0F, 9.0F, 19.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 19.0F, 0.0F));
		return LayerDefinition.create(mesh, 256, 128);
	}

	@Override
	public void setupAnim(PigluttonRenderState state) {
		super.setupAnim(state);
		if (!state.eatAnimationState.isStarted()) {
			neck.xRot = (float) Math.toRadians(state.xRot / 2);
			neck.yRot = (float) Math.toRadians(state.yRot / 2);
		}
		walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 4, 25);
		idleAnimation.apply(state.idleAnimationState, state.ageInTicks);
		attackLeftAnimation.apply(state.attackLeftAnimationState, state.ageInTicks);
		attackRightAnimation.apply(state.attackRightAnimationState, state.ageInTicks);
		attackTusksAnimation.apply(state.attackTusksAnimationState, state.ageInTicks);
		eatAnimation.apply(state.eatAnimationState, state.ageInTicks, 0.4F);
	}

	@Override
	public void translateToHand(PigluttonRenderState state, HumanoidArm arm, PoseStack poseStack) {
		for (ModelPart part : heldItemTranslations) {
			part.translateAndRotate(poseStack);
		}
		poseStack.translate(0, -0.5, 0.8);
	}
}
