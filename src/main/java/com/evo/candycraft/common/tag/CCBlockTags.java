package com.evo.candycraft.common.tag;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class CCBlockTags {

    public static final TagKey<Block> RED_LICORICE_LOGS = modTag("red_licorice_logs");

    private static TagKey<Block> modTag(String tagName) {
        return BlockTags.create(new ResourceLocation(CandyCraft.MODID, tagName));
    }

    public static void init() {
        CCItemTags.init();
    }
}
