package com.evo.candycraft.client.renderers.entity;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.SweetberryCroncherEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class SweetberryCroncherRenderer<T extends SweetberryCroncherEntity> extends CroncherRenderer<T> {

    private static final ResourceLocation OH_GOD_HE_LOST_HIS_FRICKING_BERRIES  = CandyCraft.resourceLoc("textures/entity/croncher/sweetberry_croncher_nommed_on.png");

    public SweetberryCroncherRenderer(EntityRendererManager renderManagerIn, String textureName) {
        super(renderManagerIn, textureName);
    }

    @Override
    public ResourceLocation getEntityTexture(SweetberryCroncherEntity entity) {
        return entity.hasBerries() ? TEXTURE : OH_GOD_HE_LOST_HIS_FRICKING_BERRIES ;
    }
}
