package com.evo.candycraft.client.renderers.entity;

import com.evo.candycraft.client.renderers.entity.model.CookieCrouperModel;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.CookieCrouperEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class CookieCrouperRenderer extends MobRenderer<CookieCrouperEntity, CookieCrouperModel<CookieCrouperEntity>> {

    private static final ResourceLocation TEXTURE = CandyCraft.resourceLoc("textures/entity/cookie_crouper/cookie_crouper.png");

    public CookieCrouperRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CookieCrouperModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(CookieCrouperEntity entity) {
        return TEXTURE;
    }

    @Override
    protected void preRenderCallback(CookieCrouperEntity cookieCrouperEntity, MatrixStack matrixStackIn, float partialTickTime) {
        float f = cookieCrouperEntity.getCreeperFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        matrixStackIn.scale(f2, f3, f2);
    }

    @Override
    protected float getOverlayProgress(CookieCrouperEntity cookieCrouperEntity, float partialTicks) {
        float f = cookieCrouperEntity.getCreeperFlashIntensity(partialTicks);
        return (int)(f * 10.0F) % 2 == 0 ? 0.0F : MathHelper.clamp(f, 0.5F, 1.0F);
    }

}
