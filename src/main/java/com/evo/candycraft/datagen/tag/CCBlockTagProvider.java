package com.evo.candycraft.datagen.tag;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.tag.CCBlockTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class CCBlockTagProvider extends BlockTagsProvider {

    public CCBlockTagProvider(DataGenerator generatorIn, @Nullable ExistingFileHelper existingFileHelper) {
        super(generatorIn, CandyCraft.MODID, existingFileHelper);
    }

    @Override
    @SuppressWarnings("all")
    protected void addTags() {
        addBlocksToToolTags();

        // LOGS
        this.tag(CCBlockTags.RED_LICORICE_LOGS).add(
            CandyCraftBlocks.RED_LICORICE_LOG.get(),
            CandyCraftBlocks.STRIPPED_RED_LICORICE_LOG.get(),
            CandyCraftBlocks.RED_LICORICE_WOOD.get(),
            CandyCraftBlocks.STRIPPED_RED_LICORICE_WOOD.get()
        );

        this.tag(BlockTags.LOGS_THAT_BURN).addTags(
                CCBlockTags.RED_LICORICE_LOGS
        );

        // PLANKS
        this.tag(BlockTags.PLANKS).add(
                CandyCraftBlocks.RED_LICORICE_PLANKS.get(),
                CandyCraftBlocks.RED_LICORICE_VERTICAL_PLANKS.get()
        );

        // WOODEN SLABS
        this.tag(BlockTags.WOODEN_SLABS).add(
                CandyCraftBlocks.RED_LICORICE_SLAB.get()
        );

        // WOODEN STAIRS
        this.tag(BlockTags.WOODEN_STAIRS).add(
                CandyCraftBlocks.RED_LICORICE_STAIRS.get()
        );

        // WOODEN FENCES
        this.tag(Tags.Blocks.FENCES_WOODEN).add(
                CandyCraftBlocks.RED_LICORICE_FENCE.get()
        );

        // WOODEN FENCE GATES
        this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(
                CandyCraftBlocks.RED_LICORICE_FENCE_GATE.get()
        );

        // WOODEN PRESSURE PLATES
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(
                CandyCraftBlocks.RED_LICORICE_PRESSURE_PLATE.get()
        );

        // WOODEN BUTTONS
        this.tag(BlockTags.WOODEN_BUTTONS).add(
                CandyCraftBlocks.RED_LICORICE_BUTTON.get()
        );

        // DOORS
        this.tag(BlockTags.DOORS).add(
                CandyCraftBlocks.WAFFLE_CONE_DOOR.get()
        );

        // WOODEN DOORS
        this.tag(BlockTags.WOODEN_DOORS).add(
                CandyCraftBlocks.RED_LICORICE_DOOR.get()
        );

        // TRAPDOORS
        this.tag(BlockTags.TRAPDOORS).add(
                CandyCraftBlocks.WAFFLE_CONE_TRAPDOOR.get()
        );

        // WOODEN TRAPDOORS
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(
                CandyCraftBlocks.RED_LICORICE_TRAPDOOR.get()
        );

        // SAPLINGS
        this.tag(BlockTags.SAPLINGS).add(
                CandyCraftBlocks.RED_LICORICE_TREE_SAPLING.get()
        );
    }

    @SuppressWarnings("all")
    private void addBlocksToToolTags() {
        // PICKAXE MINEABLES
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                CandyCraftBlocks.WAFFLE_CONE_BLOCK.get(),
                CandyCraftBlocks.WAFFLE_CONE_DOOR.get(),
                CandyCraftBlocks.WAFFLE_CONE_TRAPDOOR.get(),
                CandyCraftBlocks.NOUGAT_SLATE.get()
        );

        // AXE MINEABLES
        this.tag(BlockTags.MINEABLE_WITH_AXE).addTags(
                CCBlockTags.RED_LICORICE_LOGS
        );
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                CandyCraftBlocks.CANDY_CANE_BLOCK.get(),
                CandyCraftBlocks.CANDY_CANE_WOOD.get(),
                CandyCraftBlocks.RED_LICORICE_PLANKS.get(),
                CandyCraftBlocks.RED_LICORICE_SLAB.get(),
                CandyCraftBlocks.RED_LICORICE_STAIRS.get(),
                CandyCraftBlocks.RED_LICORICE_VERTICAL_SLAB.get()
        );
    }
}
