package com.evo.candycraft_rebaked.client.renderers.entity;

import com.evo.candycraft_rebaked.common.core.CandyCraft;
import com.evo.candycraft_rebaked.common.entity.SweetberryCroncherEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class SweetberryCroncherRenderer<T extends SweetberryCroncherEntity> extends CroncherRenderer<T> {

    private static final ResourceLocation OH_GOD_HE_LOST_HIS_FRICKING_BERRIES  = CandyCraft.resourceLoc("textures/entity/croncher/sweetberry_croncher_nommed_on.png");

    public SweetberryCroncherRenderer(EntityRendererProvider.Context context, String textureName) {
        super(context, textureName);
    }

    @Override
    public ResourceLocation getTextureLocation(SweetberryCroncherEntity entity) {
        return entity.hasBerries() ? TEXTURE : OH_GOD_HE_LOST_HIS_FRICKING_BERRIES ;
    }
}
