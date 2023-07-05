package com.evo.candycraft_rebaked.client.renderers.entity.model;// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.evo.candycraft_rebaked.common.entity.MintolotlEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LerpingModel;
import org.joml.Vector3f;

import java.util.Map;

public class MintolotlModel<T extends MintolotlEntity & LerpingModel> extends AgeableListModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart tail;
	private final ModelPart top_gills;
	private final ModelPart left_gills;
	private final ModelPart right_gills;
	private final ModelPart front_left_leg;
	private final ModelPart back_left_leg;
	private final ModelPart front_right_leg;
	private final ModelPart back_right_leg;

	public MintolotlModel(ModelPart root) {
		super(true, 8.0F, 3.35F);
		this.body = root.getChild("body");
		this.head = body.getChild("head");
		this.tail = body.getChild("tail");
		this.top_gills = head.getChild("top_gills");
		this.left_gills = head.getChild("left_gills");
		this.right_gills = head.getChild("right_gills");
		this.front_left_leg = body.getChild("front_left_leg");
		this.back_left_leg = body.getChild("back_left_leg");
		this.front_right_leg = body.getChild("front_right_leg");
		this.back_right_leg = body.getChild("back_right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, 0.0F, -5.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(12, 12).addBox(0.0F, -1.0F, -4.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -1.5F, -2.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 4.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, -2.0F, -4.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -5.0F));

		PartDefinition top_gills = head.addOrReplaceChild("top_gills", CubeListBuilder.create().texOffs(16, 10).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.5F));

		PartDefinition left_gills = head.addOrReplaceChild("left_gills", CubeListBuilder.create().texOffs(17, 0).addBox(0.0F, -2.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -2.0F, -1.5F));

		PartDefinition right_gills = head.addOrReplaceChild("right_gills", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, 0.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -2.0F, -1.5F));

		PartDefinition front_left_leg = body.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(20, 13).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, -4.0F));

		PartDefinition back_left_leg = body.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(20, 13).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 2.0F, 1.0F));

		PartDefinition front_right_leg = body.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(20, 13).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, -4.0F));

		PartDefinition back_right_leg = body.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(20, 13).addBox(-1.5F, 0.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, 1.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);

	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.setupInitialAnimationValues(entity, netHeadYaw, headPitch);
		if (entity.isPlayingDead()) {
			this.setupPlayDeadAnimation(netHeadYaw);
			this.saveAnimationValues(entity);
		} else {
			boolean flag = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7D || entity.getXRot() != entity.xRotO || entity.getYRot() != entity.yRotO || entity.xOld != entity.getX() || entity.zOld != entity.getZ();
			if (entity.isInWaterOrBubble()) {
				if (flag) {
					this.setupSwimmingAnimation(ageInTicks, headPitch);
				} else {
					this.setupWaterHoveringAnimation(ageInTicks);
				}

				this.saveAnimationValues(entity);
			} else {
				if (entity.onGround()) {
					if (flag) {
						this.setupGroundCrawlingAnimation(ageInTicks, netHeadYaw);
					} else {
						this.setupLayStillOnGroundAnimation(ageInTicks, netHeadYaw);
					}
				}

				this.saveAnimationValues(entity);
			}
		}
	}

	private void saveAnimationValues(T p_170389_) {
		Map<String, Vector3f> map = p_170389_.getModelRotationValues();
		map.put("body", this.getRotationVector(this.body));
		map.put("head", this.getRotationVector(this.head));
		map.put("back_right_leg", this.getRotationVector(this.back_right_leg));
		map.put("back_left_leg", this.getRotationVector(this.back_left_leg));
		map.put("front_right_leg", this.getRotationVector(this.front_right_leg));
		map.put("front_left_leg", this.getRotationVector(this.front_left_leg));
		map.put("tail", this.getRotationVector(this.tail));
		map.put("top_gills", this.getRotationVector(this.top_gills));
		map.put("left_gills", this.getRotationVector(this.left_gills));
		map.put("right_gills", this.getRotationVector(this.right_gills));
	}

	private Vector3f getRotationVector(ModelPart p_170402_) {
		return new Vector3f(p_170402_.xRot, p_170402_.yRot, p_170402_.zRot);
	}

	private void setRotationFromVector(ModelPart p_170409_, Vector3f p_170410_) {
		p_170409_.setRotation(p_170410_.x(), p_170410_.y(), p_170410_.z());
	}

	private void setupInitialAnimationValues(T p_170391_, float p_170392_, float p_170393_) {
		this.body.x = 0.0F;
		this.head.y = 0.0F;
		this.body.y = 20.0F;
		Map<String, Vector3f> map = p_170391_.getModelRotationValues();
		if (map.isEmpty()) {
			this.body.setRotation(p_170393_ * ((float) Math.PI / 180F), p_170392_ * ((float) Math.PI / 180F), 0.0F);
			this.head.setRotation(0.0F, 0.0F, 0.0F);
			this.back_left_leg.setRotation(0.0F, 0.0F, 0.0F);
			this.back_right_leg.setRotation(0.0F, 0.0F, 0.0F);
			this.front_left_leg.setRotation(0.0F, 0.0F, 0.0F);
			this.front_right_leg.setRotation(0.0F, 0.0F, 0.0F);
			this.left_gills.setRotation(0.0F, 0.0F, 0.0F);
			this.right_gills.setRotation(0.0F, 0.0F, 0.0F);
			this.top_gills.setRotation(0.0F, 0.0F, 0.0F);
			this.tail.setRotation(0.0F, 0.0F, 0.0F);
		} else {
			this.setRotationFromVector(this.body, map.get("body"));
			this.setRotationFromVector(this.head, map.get("head"));
			this.setRotationFromVector(this.back_left_leg, map.get("back_left_leg"));
			this.setRotationFromVector(this.back_right_leg, map.get("back_right_leg"));
			this.setRotationFromVector(this.front_left_leg, map.get("front_left_leg"));
			this.setRotationFromVector(this.front_right_leg, map.get("front_right_leg"));
			this.setRotationFromVector(this.left_gills, map.get("left_gills"));
			this.setRotationFromVector(this.right_gills, map.get("right_gills"));
			this.setRotationFromVector(this.top_gills, map.get("top_gills"));
			this.setRotationFromVector(this.tail, map.get("tail"));
		}

	}

	private float lerpTo(float p_170375_, float p_170376_) {
		return this.lerpTo(0.05F, p_170375_, p_170376_);
	}

	private float lerpTo(float p_170378_, float p_170379_, float p_170380_) {
		return Mth.rotLerp(p_170378_, p_170379_, p_170380_);
	}

	private void lerpPart(ModelPart p_170404_, float p_170405_, float p_170406_, float p_170407_) {
		p_170404_.setRotation(this.lerpTo(p_170404_.xRot, p_170405_), this.lerpTo(p_170404_.yRot, p_170406_), this.lerpTo(p_170404_.zRot, p_170407_));
	}

	private void setupLayStillOnGroundAnimation(float p_170415_, float p_170416_) {
		float f = p_170415_ * 0.09F;
		float f1 = Mth.sin(f);
		float f2 = Mth.cos(f);
		float f3 = f1 * f1 - 2.0F * f1;
		float f4 = f2 * f2 - 3.0F * f1;
		this.head.xRot = this.lerpTo(this.head.xRot, -0.09F * f3);
		this.head.yRot = this.lerpTo(this.head.yRot, 0.0F);
		this.head.zRot = this.lerpTo(this.head.zRot, -0.2F);
		this.tail.yRot = this.lerpTo(this.tail.yRot, -0.1F + 0.1F * f3);
		this.top_gills.xRot = this.lerpTo(this.top_gills.xRot, 0.6F + 0.05F * f4);
		this.left_gills.yRot = this.lerpTo(this.left_gills.yRot, -this.top_gills.xRot);
		this.right_gills.yRot = this.lerpTo(this.right_gills.yRot, -this.left_gills.yRot);
		this.lerpPart(this.back_left_leg, 1.1F, 1.0F, 0.0F);
		this.lerpPart(this.front_left_leg, 0.8F, 2.3F, -0.5F);
		this.applyMirrorLegRotations();
		this.body.xRot = this.lerpTo(0.2F, this.body.xRot, 0.0F);
		this.body.yRot = this.lerpTo(this.body.yRot, p_170416_ * ((float) Math.PI / 180F));
		this.body.zRot = this.lerpTo(this.body.zRot, 0.0F);
	}

	private void setupGroundCrawlingAnimation(float p_170419_, float p_170420_) {
		float f = p_170419_ * 0.11F;
		float f1 = Mth.cos(f);
		float f2 = (f1 * f1 - 2.0F * f1) / 5.0F;
		float f3 = 0.7F * f1;
		this.head.xRot = this.lerpTo(this.head.xRot, 0.0F);
		this.head.yRot = this.lerpTo(this.head.yRot, 0.09F * f1);
		this.head.zRot = this.lerpTo(this.head.zRot, 0.0F);
		this.tail.yRot = this.lerpTo(this.tail.yRot, this.head.yRot);
		this.top_gills.xRot = this.lerpTo(this.top_gills.xRot, 0.6F - 0.08F * (f1 * f1 + 2.0F * Mth.sin(f)));
		this.left_gills.yRot = this.lerpTo(this.left_gills.yRot, -this.top_gills.xRot);
		this.right_gills.yRot = this.lerpTo(this.right_gills.yRot, -this.left_gills.yRot);
		this.lerpPart(this.back_left_leg, 0.9424779F, 1.5F - f2, -0.1F);
		this.lerpPart(this.front_left_leg, 1.0995574F, ((float) Math.PI / 2F) - f3, 0.0F);
		this.lerpPart(this.back_right_leg, this.back_left_leg.xRot, -1.0F - f2, 0.0F);
		this.lerpPart(this.front_right_leg, this.front_left_leg.xRot, (-(float) Math.PI / 2F) - f3, 0.0F);
		this.body.xRot = this.lerpTo(0.2F, this.body.xRot, 0.0F);
		this.body.yRot = this.lerpTo(this.body.yRot, p_170420_ * ((float) Math.PI / 180F));
		this.body.zRot = this.lerpTo(this.body.zRot, 0.0F);
	}

	private void setupWaterHoveringAnimation(float p_170373_) {
		float f = p_170373_ * 0.075F;
		float f1 = Mth.cos(f);
		float f2 = Mth.sin(f) * 0.15F;
		this.body.xRot = this.lerpTo(this.body.xRot, -0.15F + 0.075F * f1);
		this.body.y -= f2;
		this.head.xRot = this.lerpTo(this.head.xRot, -this.body.xRot);
		this.top_gills.xRot = this.lerpTo(this.top_gills.xRot, 0.2F * f1);
		this.left_gills.yRot = this.lerpTo(this.left_gills.yRot, -0.3F * f1 - 0.19F);
		this.right_gills.yRot = this.lerpTo(this.right_gills.yRot, -this.left_gills.yRot);
		this.lerpPart(this.back_left_leg, 2.3561945F - f1 * 0.11F, 0.47123894F, 1.7278761F);
		this.lerpPart(this.front_left_leg, ((float) Math.PI / 4F) - f1 * 0.2F, 2.042035F, 0.0F);
		this.applyMirrorLegRotations();
		this.tail.yRot = this.lerpTo(this.tail.yRot, 0.5F * f1);
		this.head.yRot = this.lerpTo(this.head.yRot, 0.0F);
		this.head.zRot = this.lerpTo(this.head.zRot, 0.0F);
	}

	private void setupSwimmingAnimation(float p_170423_, float p_170424_) {
		float f = p_170423_ * 0.33F;
		float f1 = Mth.sin(f);
		float f2 = Mth.cos(f);
		float f3 = 0.13F * f1;
		this.body.xRot = this.lerpTo(0.1F, this.body.xRot, p_170424_ * ((float) Math.PI / 180F) + f3);
		this.head.xRot = -f3 * 1.8F;
		this.body.y -= 0.45F * f2;
		this.top_gills.xRot = this.lerpTo(this.top_gills.xRot, -0.5F * f1 - 0.8F);
		this.left_gills.yRot = this.lerpTo(this.left_gills.yRot, 0.3F * f1 + 0.9F);
		this.right_gills.yRot = this.lerpTo(this.right_gills.yRot, -this.left_gills.yRot);
		this.tail.yRot = this.lerpTo(this.tail.yRot, 0.3F * Mth.cos(f * 0.9F));
		this.lerpPart(this.back_left_leg, 1.8849558F, -0.4F * f1, ((float) Math.PI / 2F));
		this.lerpPart(this.front_left_leg, 1.8849558F, -0.2F * f2 - 0.1F, ((float) Math.PI / 2F));
		this.applyMirrorLegRotations();
		this.head.yRot = this.lerpTo(this.head.yRot, 0.0F);
		this.head.zRot = this.lerpTo(this.head.zRot, 0.0F);
	}

	private void setupPlayDeadAnimation(float p_170413_) {
		this.lerpPart(this.back_left_leg, 1.4137167F, 1.0995574F, ((float) Math.PI / 4F));
		this.lerpPart(this.front_left_leg, ((float) Math.PI / 4F), 2.042035F, 0.0F);
		this.body.xRot = this.lerpTo(this.body.xRot, -0.15F);
		this.body.zRot = this.lerpTo(this.body.zRot, 0.35F);
		this.applyMirrorLegRotations();
		this.body.yRot = this.lerpTo(this.body.yRot, p_170413_ * ((float) Math.PI / 180F));
		this.head.xRot = this.lerpTo(this.head.xRot, 0.0F);
		this.head.yRot = this.lerpTo(this.head.yRot, 0.0F);
		this.head.zRot = this.lerpTo(this.head.zRot, 0.0F);
		this.tail.yRot = this.lerpTo(this.tail.yRot, 0.0F);
		this.lerpPart(this.top_gills, 0.0F, 0.0F, 0.0F);
		this.lerpPart(this.left_gills, 0.0F, 0.0F, 0.0F);
		this.lerpPart(this.right_gills, 0.0F, 0.0F, 0.0F);
	}

	private void applyMirrorLegRotations() {
		this.lerpPart(this.back_right_leg, this.back_left_leg.xRot, -this.back_left_leg.yRot, -this.back_left_leg.zRot);
		this.lerpPart(this.front_right_leg, this.front_left_leg.xRot, -this.front_left_leg.yRot, -this.front_left_leg.zRot);
	}

	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of();
	}

	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.body);
	}
}