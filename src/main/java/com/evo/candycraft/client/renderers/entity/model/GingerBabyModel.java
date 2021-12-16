package com.evo.candycraft.client.renderers.entity.model;// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports


import com.evo.candycraft.common.entities.GingerBreadAmmoEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GingerBabyModel<T extends GingerBreadAmmoEntity> extends EntityModel<T> {
	private final ModelPart body;

	public GingerBabyModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshDefinition = new MeshDefinition();
		PartDefinition partDefinition = meshDefinition.getRoot();

		PartDefinition body = partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(3, 3).addBox(-4.0F, -18.0F, -2.0F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 16).addBox(-3.0F, -10.0F, -1.0F, 6.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(10, 25).addBox(-3.0F, -4.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(24, 0).mirror().addBox(0.0F, -4.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 25).addBox(-5.0F, -10.0F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 16).addBox(3.0F, -10.0F, -1.0F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshDefinition, 64, 64);
	}

	@Override
	public void setupAnim(T gingerBreadAmmo, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, buffer, packedLight, packedOverlay);
	}
}