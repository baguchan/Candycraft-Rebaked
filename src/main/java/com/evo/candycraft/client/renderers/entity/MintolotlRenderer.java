package com.evo.candycraft.client.renderers.entity;

import com.evo.candycraft.client.ModModelLayers;
import com.evo.candycraft.client.renderers.entity.model.MintolotlModel;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.entity.MintolotlEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MintolotlRenderer<T extends MintolotlEntity> extends MobRenderer<T, MintolotlModel<T>> {

	protected static final ResourceLocation TEXTURE = CandyCraft.resourceLoc("textures/entity/mintolotl.png");

	public MintolotlRenderer(EntityRendererProvider.Context context) {
		super(context, new MintolotlModel<>(context.bakeLayer(ModModelLayers.MINTOLOTL)), 0.3f);
	}

	@Override
	public ResourceLocation getTextureLocation(T croncher) {
		return TEXTURE;
	}
}
