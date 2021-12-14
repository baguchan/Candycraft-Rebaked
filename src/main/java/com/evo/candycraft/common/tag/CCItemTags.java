package com.evo.candycraft.common.tag;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class CCItemTags {

    public static final ITag.INamedTag<Item> RED_LICORICE_LOGS = modTag("red_licorice_logs");


    private static ITag.INamedTag<Item> modTag(String tagName) {
        return ItemTags.makeWrapperTag(new ResourceLocation(CandyCraft.MODID, tagName).toString());
    }

    public static void init() {}
}
