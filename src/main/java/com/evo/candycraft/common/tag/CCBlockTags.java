package com.evo.candycraft.common.tag;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;

public class CCBlockTags {

    public static final Tag.Named<Block> RED_LICORICE_LOGS = modTag("red_licorice_logs");

    private static Tag.Named<Block> modTag(String tagName) {
        return BlockTags.bind(new ResourceLocation(CandyCraft.MODID, tagName).toString());
    }

    public static void init() {
        CCItemTags.init();
    }
}
