package com.evo.candycraft.client;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

	public static final ModelLayerLocation CRONCHER = registerLocation("croncher");
	public static final ModelLayerLocation GINGER_BREAD_MAN = registerLocation("gingerbread_man");

	public static ModelLayerLocation registerLocation(String locationName) {
		return new ModelLayerLocation(CandyCraft.resourceLoc(locationName), locationName);
	}
}
