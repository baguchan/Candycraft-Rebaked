package com.evo.candycraft.datagen.loot;

import com.evo.candycraft.common.block.ModSaplingBlock;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.evo.candycraft.common.features.ConfiguredFeatures;
import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.Set;

public class CCBlockLootTableProvider extends BlockLoot {

    // Standard drop rate from vanilla
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    private final Set<Block> knownBlocks = new HashSet<>();

    @Override
    protected void add(Block block, LootTable.Builder table) {
        super.add(block, table);
        this.knownBlocks.add(block);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return this.knownBlocks;
    }

    @Override
    protected void addTables() {
        this.dropSelf(CandyCraftBlocks.WAFFLE_CONE_BLOCK.get());
        this.dropSelf(CandyCraftBlocks.WAFFLE_CONE_DOOR.get());
        this.dropSelf(CandyCraftBlocks.WAFFLE_CONE_TRAPDOOR.get());

        this.dropSelf(CandyCraftBlocks.CANDY_CANE_BLOCK.get());
        this.dropSelf(CandyCraftBlocks.CANDY_CANE_WOOD.get());
        this.dropSelf(CandyCraftBlocks.CANDY_CANE_SAPLING.get());
        this.dropPottedContents(CandyCraftBlocks.POTTED_CANDY_CANE_SAPLING.get());

        this.dropSelf(CandyCraftBlocks.RED_LICORICE_LOG.get());
        this.dropSelf(CandyCraftBlocks.STRIPPED_RED_LICORICE_LOG.get());
        this.dropSelf(CandyCraftBlocks.RED_LICORICE_WOOD.get());
        this.dropSelf(CandyCraftBlocks.STRIPPED_RED_LICORICE_WOOD.get());
        this.dropSelf(CandyCraftBlocks.RED_LICORICE_PLANKS.get());
        this.dropSelf(CandyCraftBlocks.RED_LICORICE_STAIRS.get());
        this.dropSelf(CandyCraftBlocks.RED_LICORICE_SLAB.get());
        this.dropSelf(CandyCraftBlocks.RED_LICORICE_VERTICAL_SLAB.get());
        this.add(CandyCraftBlocks.RED_LICORICE_LEAVES.get(), (block) -> createLeavesDrops(block, CandyCraftBlocks.RED_LICORICE_TREE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropPottedContents(CandyCraftBlocks.POTTED_RED_LICORICE_TREE_SAPLING.get());

        this.dropSelf(CandyCraftBlocks.NOUGAT_SLATE.get());
    }
}
