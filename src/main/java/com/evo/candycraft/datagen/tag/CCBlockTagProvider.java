package com.evo.candycraft.datagen.tag;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.tag.CCBlockTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class CCBlockTagProvider extends BlockTagsProvider {

    public CCBlockTagProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, CandyCraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerTags() {

        // LOGS
        this.getOrCreateBuilder(CCBlockTags.RED_LICORICE_LOGS).add(
            CandyCraftBlocks.RED_LICORICE_LOG.get(),
            CandyCraftBlocks.STRIPPED_RED_LICORICE_LOG.get(),
            CandyCraftBlocks.RED_LICORICE_WOOD.get(),
            CandyCraftBlocks.STRIPPED_RED_LICORICE_WOOD.get()
        );
        this.getOrCreateBuilder(BlockTags.LOGS_THAT_BURN).addTag(CCBlockTags.RED_LICORICE_LOGS);

        // PLANKS
        this.getOrCreateBuilder(BlockTags.PLANKS).add(
                CandyCraftBlocks.RED_LICORICE_PLANKS.get()
        );

        // WOODEN SLABS
        this.getOrCreateBuilder(BlockTags.WOODEN_SLABS).add(
                CandyCraftBlocks.RED_LICORICE_SLAB.get()
        );

        // WOODEN STAIRS
        this.getOrCreateBuilder(BlockTags.WOODEN_STAIRS).add(
                CandyCraftBlocks.RED_LICORICE_STAIRS.get()
        );

        // SAPLINGS
        this.getOrCreateBuilder(BlockTags.SAPLINGS).add(
                CandyCraftBlocks.RED_LICORICE_TREE_SAPLING.get()
        );
    }
}
