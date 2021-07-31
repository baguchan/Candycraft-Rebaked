// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Created by Evo
package com.evo.candycraft.client.renderers.entity.model;

import com.evo.candycraft.common.entities.CookieCroncherEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CookieCroncherModel<T extends CookieCroncherEntity> extends SegmentedModel<T> {

	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leg1;
	private final ModelRenderer leg2;
	private final ModelRenderer leg3;
	private final ModelRenderer leg4;

	public CookieCroncherModel() {
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
	public void setRotationAngles(CookieCroncherEntity cookieCrouperEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
		this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);

		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
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