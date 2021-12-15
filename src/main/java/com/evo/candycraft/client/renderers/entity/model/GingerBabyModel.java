package com.evo.candycraft.client.renderers.entity.model;// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.evo.candycraft.common.entities.GingerBreadAmmoEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.world.entity.Entity;

public class GingerBabyModel<T extends GingerBreadAmmoEntity> extends HierarchicalModel<T> {

	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart leftleg;
	private final ModelPart rightleg;

	public GingerBabyModel() {
		textureWidth = 16;
		textureHeight = 16;

		head = new ModelRenderer(this);
		head.setRotationPoint(-0.5F, 19.5F, 0.5F);
		head.setTextureOffset(0, 0).addBox(-2.5F, -4.5F, -1.5F, 5.0F, 5.0F, 3.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(-0.5F, 21.5F, 0.5F);
		body.setTextureOffset(0, 8).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, 0.0F, false);

		leftarm = new ModelRenderer(this);
		leftarm.setRotationPoint(-2.1F, 20.1F, 0.5F);
		leftarm.setTextureOffset(7, 11).addBox(-0.9F, -0.1F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		rightarm = new ModelRenderer(this);
		rightarm.setRotationPoint(1.0F, 20.1F, 0.5F);
		rightarm.setTextureOffset(8, 8).addBox(0.0F, -0.1F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(-1.5F, 23.1F, 0.5F);
		leftleg.setTextureOffset(0, 12).addBox(-0.5F, -0.1F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.5F, 23.0F, 0.5F);
		rightleg.setTextureOffset(11, 10).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//previously the render function, render code was moved to a method below
	}

	@Override
	public Iterable<ModelRenderer> getParts() {
		return ImmutableList.of(this.head, this.body, this.leftarm, this.rightarm, this.leftleg, this.rightleg);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}