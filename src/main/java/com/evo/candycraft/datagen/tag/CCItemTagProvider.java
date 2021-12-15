package com.evo.candycraft.datagen.tag;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.tag.CCBlockTags;
import com.evo.candycraft.common.tag.CCItemTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class CCItemTagProvider extends ItemTagsProvider {

    public CCItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagProvider, CandyCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        // Tag copying is very cool
        this.copy(CCBlockTags.RED_LICORICE_LOGS, CCItemTags.RED_LICORICE_LOGS);
        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);

        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);
        this.copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
        this.copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
        this.copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
    }
}
