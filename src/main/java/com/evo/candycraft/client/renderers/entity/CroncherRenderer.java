package com.evo.candycraft.client.renderers.entity;

import com.evo.candycraft.client.ModModelLayers;
import com.evo.candycraft.client.renderers.entity.model.CroncherModel;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.CroncherEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CroncherRenderer<T extends CroncherEntity> extends MobRenderer<T, CroncherModel<T>> {

    protected final ResourceLocation TEXTURE;

    public CroncherRenderer(EntityRendererProvider.Context context, String textureName) {
        super(context, new CroncherModel<>(context.bakeLayer(ModModelLayers.CRONCHER)), 0.5f);
        this.TEXTURE = CandyCraft.resourceLoc("textures/entity/croncher/" + textureName + ".png");
    }

    @Override
    public ResourceLocation getTextureLocation(T croncher) {
        return TEXTURE;
    }

    @Override
    protected void scale(T croncher, PoseStack matrixStackIn, float partialTickTime) {
        float f = croncher.getCrouperFlashIntensity(partialTickTime);
        float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
        f = Mth.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        matrixStackIn.scale(f2, f3, f2);
    }

    @Override
    protected float getWhiteOverlayProgress(T croncher, float partialTicks) {
        float intensity = croncher.getCrouperFlashIntensity(partialTicks);
        return (int)(intensity * 10.0F) % 2 == 0 ? 0.0F : Mth.clamp(intensity, 0.5F, 1.0F);
    }
}
