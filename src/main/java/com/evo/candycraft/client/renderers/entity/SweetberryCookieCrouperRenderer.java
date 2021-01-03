package com.evo.candycraft.client.renderers.entity;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entities.SweetberryCookieCrouperEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class SweetberryCookieCrouperRenderer<T extends SweetberryCookieCrouperEntity> extends CookieCrouperRenderer<T> {

    private static final ResourceLocation OH_GOD_HE_LOST_HIS_FRICKING_BERRIES = CandyCraft.resourceLoc("textures/entity/cookie_crouper/sweetberry_cookie_crouper_nommed_on.png");

    public SweetberryCookieCrouperRenderer(EntityRendererManager renderManagerIn, String textureName) {
        super(renderManagerIn, textureName);
    }

    @Override
    public ResourceLocation getEntityTexture(SweetberryCookieCrouperEntity entity) {
        return entity.hasBerries() ? TEXTURE : OH_GOD_HE_LOST_HIS_FRICKING_BERRIES;
    }
}
