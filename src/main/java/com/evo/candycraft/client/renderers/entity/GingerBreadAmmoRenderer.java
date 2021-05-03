package com.evo.candycraft.client.renderers.entity;

import com.evo.candycraft.client.renderers.entity.model.GingerBabyModel;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.GingerBreadAmmoEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class GingerBreadAmmoRenderer<T extends GingerBreadAmmoEntity> extends EntityRenderer<T> {
	public static final ResourceLocation TEXTURE = new ResourceLocation(CandyCraft.MODID, "textures/entity/baby.png");
	private final GingerBabyModel model = new GingerBabyModel();


	public GingerBreadAmmoRenderer(EntityRendererManager rendererManager) {
		super(rendererManager);
	}

	public void render(T entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();
		matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
		matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90.0F));
		IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.getEntityGlintVertexBuilder(bufferIn, this.model.getRenderType(this.getEntityTexture(entityIn)), false, false);
		this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getEntityTexture(T entity) {
		return TEXTURE;
	}
}
