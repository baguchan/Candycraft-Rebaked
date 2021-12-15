// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Created by Evo
package com.evo.candycraft.client.renderers.entity.model;

import com.evo.candycraft.common.entities.CroncherEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.CreeperModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.Mth;
import net.minecraft.util.math.MathHelper;

public class CroncherModel<T extends CroncherEntity> extends HierarchicalModel<T> {

	CreeperModel

	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart leg1;
	private final ModelPart leg2;
	private final ModelPart leg3;
	private final ModelPart leg4;

	public CroncherModel() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 6.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -6.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 6.0F, 0.0F);
		body.setTextureOffset(16, 16).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 11.0F, 4.0F, 0.0F, false);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(2.0F, 19.0F, 2.0F);
		leg1.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-2.0F, 19.0F, 2.0F);
		leg2.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(2.0F, 19.0F, -2.0F);
		leg3.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(-2.0F, 19.0F, -2.0F);
		leg4.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(T croncher, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
		this.head.yRot = headYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);

		this.leg1.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
	}

	@Override
	public ModelPart root() {
		return this.root;
	}


	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.head, this.body, this.leg1, this.leg2, this.leg3, this.leg4);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}