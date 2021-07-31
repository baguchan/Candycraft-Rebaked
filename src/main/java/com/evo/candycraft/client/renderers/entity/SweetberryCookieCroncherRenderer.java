package com.evo.candycraft.client.renderers.entity;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.SweetberryCookieCroncherEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class SweetberryCookieCroncherRenderer<T extends SweetberryCookieCroncherEntity> extends CookieCroncherRenderer<T> {

    private static final ResourceLocation OH_GOD_HE_LOST_HIS_FRICKING_BERRIES = CandyCraft.resourceLoc("textures/entity/cookie_crouper/sweetberry_cookie_croncher_nommed_on.png");

    public SweetberryCookieCroncherRenderer(EntityRendererManager renderManagerIn, String textureName) {
        super(renderManagerIn, textureName);
    }

    @Override
    public ResourceLocation getEntityTexture(SweetberryCookieCroncherEntity entity) {
        return entity.hasBerries() ? TEXTURE : OH_GOD_HE_LOST_HIS_FRICKING_BERRIES;
    }
}
