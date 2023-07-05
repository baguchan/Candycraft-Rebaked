package com.evo.candycraft_rebaked.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.HashSet;
import java.util.Set;

import static com.evo.candycraft_rebaked.common.core.registry.CandyCraftBlocks.*;

public class CCBlockLootTableProvider extends BlockLootSubProvider {

    // Standard drop rate from vanilla
    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};

    private final Set<Block> knownBlocks = new HashSet<>();


    private static final Set<Item> EXPLOSION_RESISTANT = Set.of();


    protected CCBlockLootTableProvider() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

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
    protected void generate() {

        this.dropSelf(WAFFLE_CONE_BLOCK.get());
        this.add(WAFFLE_CONE_DOOR.get(), createDoorTable(WAFFLE_CONE_DOOR.get()));
        this.dropSelf(WAFFLE_CONE_TRAPDOOR.get());

        this.dropSelf(CANDY_CANE_BLOCK.get());
        this.dropSelf(CANDY_CANE_WOOD.get());
        //this.dropSelf(CANDY_CANE_SAPLING.get());
        //this.dropPottedContents(POTTED_CANDY_CANE_SAPLING.get());

        this.dropSelf(RED_LICORICE_LOG.get());
        this.dropSelf(STRIPPED_RED_LICORICE_LOG.get());
        this.dropSelf(RED_LICORICE_WOOD.get());
        this.dropSelf(STRIPPED_RED_LICORICE_WOOD.get());
        this.dropSelf(RED_LICORICE_PLANKS.get());
        this.dropSelf(RED_LICORICE_VERTICAL_PLANKS.get());
        this.dropSelf(RED_LICORICE_STAIRS.get());
        this.add(RED_LICORICE_SLAB.get(), createSlabItemTable(RED_LICORICE_SLAB.get()));
        //this.add(RED_LICORICE_VERTICAL_SLAB.get(), createVerticalSlabTable(RED_LICORICE_VERTICAL_SLAB.get()));
        this.dropSelf(RED_LICORICE_FENCE.get());
        this.dropSelf(RED_LICORICE_FENCE_GATE.get());
        this.dropSelf(RED_LICORICE_PRESSURE_PLATE.get());
        this.dropSelf(RED_LICORICE_BUTTON.get());
        this.add(RED_LICORICE_DOOR.get(), createDoorTable(RED_LICORICE_DOOR.get()));
        this.dropSelf(RED_LICORICE_TRAPDOOR.get());
        //this.add(RED_LICORICE_LEAVES.get(), (block) -> createLeavesDrops(block, RED_LICORICE_TREE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        //this.dropSelf(RED_LICORICE_TREE_SAPLING.get());
        //this.dropPottedContents(POTTED_RED_LICORICE_TREE_SAPLING.get());

        this.dropSelf(NOUGAT_SLATE.get());
    }
}
