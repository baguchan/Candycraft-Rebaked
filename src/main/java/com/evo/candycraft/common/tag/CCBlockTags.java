package com.evo.candycraft.common.tag;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;

public class CCBlockTags {

    public static final ITag.INamedTag<Block> RED_LICORICE_LOGS = modTag("red_licorice_logs");


    private static ITag.INamedTag<Block> modTag(String tagName) {
        return BlockTags.makeWrapperTag(new ResourceLocation(CandyCraft.MODID, tagName).toString());
    }

    public static void init() {
        CCItemTags.init();
    }
}
