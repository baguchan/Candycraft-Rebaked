package com.evo.candycraft.client.renderers.entity;

import com.evo.candycraft.client.ModModelLayers;
import com.evo.candycraft.client.renderers.entity.model.GingerBabyModel;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.GingerBreadAmmoEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GingerBreadAmmoRenderer<T extends GingerBreadAmmoEntity> extends EntityRenderer<T> {

	public static final ResourceLocation TEXTURE = new ResourceLocation(CandyCraft.MODID, "textures/entity/baby.png");

	private GingerBabyModel<T> model;


	public GingerBreadAmmoRenderer(EntityRendererProvider.Context context) {
		super(context);

		model = new GingerBabyModel<>(context.bakeLayer(ModModelLayers.GINGER_BREAD_MAN));
	}

	// TODO - Check if this is actually working as intended
	public void render(T gingerBreadAmmo, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLightIn) {
		poseStack.pushPose();
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, gingerBreadAmmo.getYRot(), gingerBreadAmmo.yRotO) - 90.0F));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(Mth.lerp(partialTicks, gingerBreadAmmo.getXRot(), gingerBreadAmmo.xRotO) + 90.0F));
		VertexConsumer vertexConsumer = ItemRenderer.getFoilBuffer(bufferSource, this.model.renderType(this.getTextureLocation(gingerBreadAmmo)), false, false);
		this.model.renderToBuffer(poseStack, vertexConsumer, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
		super.render(gingerBreadAmmo, entityYaw, partialTicks, poseStack, bufferSource, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(T gingerBreadAmmo) {
		return TEXTURE;
	}
}
