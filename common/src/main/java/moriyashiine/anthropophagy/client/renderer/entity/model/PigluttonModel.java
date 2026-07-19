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
		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0, 21, 0, 0.3927F, 0, 0));
		body.addOrReplaceChild("breathingRig", CubeListBuilder.create().texOffs(72, 6).addBox(-11, -14, -7, 22, 20, 16, CubeDeformation.NONE), PartPose.offsetAndRotation(0, -24, 0, -0.3491F, 0, 0));
		PartDefinition back = body.addOrReplaceChild("back", CubeListBuilder.create().texOffs(151, 32).addBox(-10, -3, -1, 20, 10, 24, CubeDeformation.NONE), PartPose.offsetAndRotation(0, -31, 13, -0.7418F, 0, 0));
		back.addOrReplaceChild("stomach", CubeListBuilder.create().texOffs(85, 87).addBox(-12, -9, 1, 24, 19, 20, CubeDeformation.NONE), PartPose.offsetAndRotation(0, 11, -1, -0.0436F, 0, 0));
		back.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(216, 3).addBox(-3.5F, -0.4645F, -0.2929F, 7, 8, 10, CubeDeformation.NONE), PartPose.offsetAndRotation(0, -3, 18, 0.7854F, 0, 0));
		PartDefinition neck = body.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offsetAndRotation(0, -26, 4, 0.1309F, 0, 0));
		neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(2, 81).addBox(-10, -16, -6, 18, 21, 18, CubeDeformation.NONE), PartPose.offsetAndRotation(1, 0, 0, 0.9163F, 0, 0));
		neck.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(158, 0).addBox(-6, -3, -11, 10, 7, 21, CubeDeformation.NONE), PartPose.offsetAndRotation(1, -17, 0, -0.3927F, 0, 0));
		PartDefinition head = neck.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-8, -8, -5, 16, 12, 13, CubeDeformation.NONE), PartPose.offsetAndRotation(0, -11, -13, -0.3054F, 0, 0));
		head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(2, 27).addBox(-5, -2, -10, 9, 7, 10, CubeDeformation.NONE), PartPose.offsetAndRotation(0.5F, -2, -4.25F, 0.2182F, 0, 0));
		PartDefinition lEar = head.addOrReplaceChild("lEar", CubeListBuilder.create(), PartPose.offset(8, -4, 1));
		lEar.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(59, 0).addBox(-1, -3, -3, 3, 12, 7, CubeDeformation.NONE), PartPose.offsetAndRotation(0.25F, 1, 0, 0, 0, -0.2182F));
		PartDefinition rEar = head.addOrReplaceChild("rEar", CubeListBuilder.create(), PartPose.offset(-8, -4, 1));
		rEar.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(59, 0).mirror().addBox(-2, -3, -3, 3, 12, 7, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-0.25F, 1, 0, 0, 0, 0.2182F));
		head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(39, 28).addBox(-3.5F, -4.75F, -2, 7, 6, 2, new CubeDeformation(0.2F)), PartPose.offset(0, 2, -13));
		head.addOrReplaceChild("lowerJaw", CubeListBuilder.create().texOffs(3, 55).addBox(-5, 1, -13, 10, 2, 14, CubeDeformation.NONE).texOffs(57, 25).addBox(4, -7, -10, 2, 8, 2, CubeDeformation.NONE).texOffs(57, 25).mirror().addBox(-6, -7, -10, 2, 8, 2, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(0, 0.75F, -1, 0.2182F, 0, 0));
		PartDefinition lArm01 = root.addOrReplaceChild("lArm01", CubeListBuilder.create().texOffs(57, 46).addBox(-6, -7, -4, 10, 18, 11, CubeDeformation.NONE), PartPose.offsetAndRotation(12, -5, -11, -0.2705F, 0, -0.1745F));
		PartDefinition lArm02 = lArm01.addOrReplaceChild("lArm02", CubeListBuilder.create().texOffs(110, 46).addBox(-2.7942F, 1.5062F, -9.8349F, 7, 14, 8, CubeDeformation.NONE), PartPose.offsetAndRotation(-1, 10, 7, -0.1745F, 0, 0));
		PartDefinition lHandHoof01 = lArm02.addOrReplaceChild("lHandHoof01", CubeListBuilder.create(), PartPose.offsetAndRotation(1, 15.2562F, -7.8349F, -0.48F, 0, 0.1745F));
		lHandHoof01.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(73, 78).addBox(-5, -4, -3, 8, 9, 5, CubeDeformation.NONE), PartPose.offsetAndRotation(0.8252F, 0.983F, 2.8706F, 0.9163F, 0, 0));
		lHandHoof01.addOrReplaceChild("lHoofHand02", CubeListBuilder.create().texOffs(108, 72).addBox(-5, -2.3254F, -5.771F, 8, 3, 4, CubeDeformation.NONE), PartPose.offsetAndRotation(0.8252F, 2.983F, 9.8706F, -0.6545F, 0, 0));
		PartDefinition rArm01 = root.addOrReplaceChild("rArm01", CubeListBuilder.create().texOffs(57, 46).mirror().addBox(-4, -7, -4, 10, 18, 11, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-12, -5, -11, -0.2705F, 0, 0.1745F));
		PartDefinition rArm02 = rArm01.addOrReplaceChild("rArm02", CubeListBuilder.create().texOffs(110, 46).mirror().addBox(-4.2058F, 1.5062F, -9.8349F, 7, 14, 8, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(1, 10, 7, -0.1745F, 0, 0));
		PartDefinition rHandHoof01 = rArm02.addOrReplaceChild("rHandHoof01", CubeListBuilder.create(), PartPose.offsetAndRotation(-1, 15.2562F, -7.8349F, -0.48F, 0, -0.1745F));
		rHandHoof01.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(73, 78).mirror().addBox(-3, -4, -3, 8, 9, 5, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-0.8252F, 0.983F, 2.8706F, 0.9163F, 0, 0));
		rHandHoof01.addOrReplaceChild("rHoofHand02", CubeListBuilder.create().texOffs(108, 72).mirror().addBox(-3, -2.3254F, -5.771F, 8, 3, 4, CubeDeformation.NONE).mirror(false), PartPose.offsetAndRotation(-0.8252F, 2.983F, 9.8706F, -0.6545F, 0, 0));
		PartDefinition lLeg01 = root.addOrReplaceChild("lLeg01", CubeListBuilder.create().texOffs(168, 66).addBox(-7, -4, -8, 13, 20, 11, CubeDeformation.NONE).texOffs(208, 94).addBox(-7, -4, -8, 13, 21, 11, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(9, -5, 22, -0.1309F, 0, -0.0436F));
		lLeg01.addOrReplaceChild("lLeg02", CubeListBuilder.create().texOffs(222, 66).addBox(-4, -8, -2, 9, 19, 7, CubeDeformation.NONE), PartPose.offset(0, 19, 0));
		PartDefinition rLeg01 = root.addOrReplaceChild("rLeg01", CubeListBuilder.create().texOffs(168, 66).mirror().addBox(-6, -4, -8, 13, 20, 11, CubeDeformation.NONE).mirror(false).texOffs(208, 94).mirror().addBox(-6, -4, -8, 13, 21, 11, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-9, -5, 22, -0.1309F, 0, 0.0436F));
		rLeg01.addOrReplaceChild("rLeg02", CubeListBuilder.create().texOffs(222, 66).mirror().addBox(-5, -8, -2, 9, 19, 7, CubeDeformation.NONE).mirror(false), PartPose.offset(0, 19, 0));
		return LayerDefinition.create(mesh, 256, 128);
	}

	@Override
	public void setupAnim(PigluttonRenderState state) {
		super.setupAnim(state);
		walkAnimation.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 4, 25);
		idleAnimation.apply(state.idleAnimationState, state.ageInTicks);
		attackLeftAnimation.apply(state.attackLeftAnimationState, state.ageInTicks);
		attackRightAnimation.apply(state.attackRightAnimationState, state.ageInTicks);
		attackTusksAnimation.apply(state.attackTusksAnimationState, state.ageInTicks);
		eatAnimation.apply(state.eatAnimationState, state.ageInTicks, 0.5F);
	}

	@Override
	public void translateToHand(PigluttonRenderState state, HumanoidArm arm, PoseStack poseStack) {
		for (ModelPart part : heldItemTranslations) {
			part.translateAndRotate(poseStack);
		}
		poseStack.translate(0, -0.5, 0.8);
	}
}
