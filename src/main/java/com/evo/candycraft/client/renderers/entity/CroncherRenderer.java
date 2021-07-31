package com.evo.candycraft.client.renderers.entity;

import com.evo.candycraft.client.renderers.entity.model.CroncherModel;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.CroncherEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class CroncherRenderer<T extends CroncherEntity> extends MobRenderer<T, CroncherModel<T>> {

    protected final ResourceLocation TEXTURE;

    public CroncherRenderer(EntityRendererManager renderManagerIn, String textureName) {
        super(renderManagerIn, new CroncherModel<>(), 0.5f);
        this.TEXTURE = CandyCraft.resourceLoc("textures/entity/croncher/" + textureName + ".png");
    }

    @Override
    public ResourceLocation getEntityTexture(CroncherEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void preRenderCallback(CroncherEntity cookieCrouperEntity, MatrixStack matrixStackIn, float partialTickTime) {
        float f = cookieCrouperEntity.getCrouperFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        matrixStackIn.scale(f2, f3, f2);
    }

    @Override
    protected float getOverlayProgress(CroncherEntity cookieCrouperEntity, float partialTicks) {
        float f = cookieCrouperEntity.getCrouperFlashIntensity(partialTicks);
        return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
    }
}
