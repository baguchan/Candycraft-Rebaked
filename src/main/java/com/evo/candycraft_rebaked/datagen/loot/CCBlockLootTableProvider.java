package com.evo.candycraft_rebaked.datagen.loot;

import com.teamabnormals.blueprint.common.block.VerticalSlabBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.HashSet;
import java.util.Set;

import static com.evo.candycraft_rebaked.common.core.registry.CandyCraftBlocks.*;

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
        this.dropSelf(WAFFLE_CONE_BLOCK.get());
        this.add(WAFFLE_CONE_DOOR.get(), createDoorTable(WAFFLE_CONE_DOOR.get()));
        this.dropSelf(WAFFLE_CONE_TRAPDOOR.get());

        this.dropSelf(CANDY_CANE_BLOCK.get());
        this.dropSelf(CANDY_CANE_WOOD.get());
        this.dropSelf(CANDY_CANE_SAPLING.get());
        this.dropPottedContents(POTTED_CANDY_CANE_SAPLING.get());

        this.dropSelf(RED_LICORICE_LOG.get());
        this.dropSelf(STRIPPED_RED_LICORICE_LOG.get());
        this.dropSelf(RED_LICORICE_WOOD.get());
        this.dropSelf(STRIPPED_RED_LICORICE_WOOD.get());
        this.dropSelf(RED_LICORICE_PLANKS.get());
        this.dropSelf(RED_LICORICE_VERTICAL_PLANKS.get());
        this.dropSelf(RED_LICORICE_STAIRS.get());
        this.add(RED_LICORICE_SLAB.get(), createSlabItemTable(RED_LICORICE_SLAB.get()));
        this.add(RED_LICORICE_VERTICAL_SLAB.get(), createVerticalSlabTable(RED_LICORICE_VERTICAL_SLAB.get()));
        this.dropSelf(RED_LICORICE_FENCE.get());
        this.dropSelf(RED_LICORICE_FENCE_GATE.get());
        this.dropSelf(RED_LICORICE_PRESSURE_PLATE.get());
        this.dropSelf(RED_LICORICE_BUTTON.get());
        this.add(RED_LICORICE_DOOR.get(), createDoorTable(RED_LICORICE_DOOR.get()));
        this.dropSelf(RED_LICORICE_TRAPDOOR.get());
        this.add(RED_LICORICE_LEAVES.get(), (block) -> createLeavesDrops(block, RED_LICORICE_TREE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.dropSelf(RED_LICORICE_TREE_SAPLING.get());
        this.dropPottedContents(POTTED_RED_LICORICE_TREE_SAPLING.get());

        this.dropSelf(NOUGAT_SLATE.get());
    }


    protected static LootTable.Builder createVerticalSlabTable(Block verticalSlab) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1))
                        .add(applyExplosionDecay(verticalSlab, LootItem.lootTableItem(verticalSlab)
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(2))
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(verticalSlab)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(VerticalSlabBlock.TYPE, VerticalSlabBlock.VerticalSlabType.DOUBLE)))))));
    }
}
