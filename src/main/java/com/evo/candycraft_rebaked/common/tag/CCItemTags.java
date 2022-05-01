package com.evo.candycraft_rebaked.common.tag;

import com.evo.candycraft_rebaked.common.core.CandyCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class CCItemTags {

    public static final TagKey<Item> RED_LICORICE_LOGS = modTag("red_licorice_logs");


    private static TagKey<Item> modTag(String tagName) {
        return ItemTags.create(new ResourceLocation(CandyCraft.MODID, tagName));
    }

    public static void init() {
    }
}
