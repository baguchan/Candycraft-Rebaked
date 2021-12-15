package com.evo.candycraft.common.tag;

import com.evo.candycraft.common.core.CandyCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;

public class CCItemTags {

    public static final Tag.Named<Item> RED_LICORICE_LOGS = modTag("red_licorice_logs");


    private static Tag.Named<Item> modTag(String tagName) {
        return ItemTags.bind(new ResourceLocation(CandyCraft.MODID, tagName).toString());
    }

    public static void init() {}
}
