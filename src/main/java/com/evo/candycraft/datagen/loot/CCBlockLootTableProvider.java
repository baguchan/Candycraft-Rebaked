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


        /*
        public static final RegistryObject<Block> WAFFLE_CONE_BLOCK = HELPER.createBlock("waffle_cone_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.0f).sound(SoundType.NETHER_GOLD_ORE)), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> WAFFLE_CONE_DOOR = HELPER.createBlock("waffle_cone_door", () -> new DoorBlock(CandyCraftBlocks.Properties.WAFFLE_CONE_DOOR), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> WAFFLE_CONE_TRAPDOOR = HELPER.createBlock("waffle_cone_trapdoor", ()-> new TrapDoorBlock(CandyCraftBlocks.Properties.WAFFLE_CONE_TRAPDOOR), CandyCraft.ITEM_GROUP);

        public static final RegistryObject<Block> CANDY_CANE_BLOCK = HELPER.createBlock("candy_cane_block", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.TERRACOTTA_WHITE, MaterialColor.TERRACOTTA_WHITE)).strength(1.0f, 1.0f).sound(SoundType.STONE)), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> CANDY_CANE_WOOD = HELPER.createBlock("candy_cane_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(CANDY_CANE_BLOCK.get())), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> CANDY_CANE_SAPLING = HELPER.createBlockNoItem("candy_cane_sapling", () -> new ModSaplingBlock(() -> ConfiguredFeatures.CANDY_CANE_TREE_FEATURE, BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).instabreak().noCollission().randomTicks().sound(SoundType.GRASS)));
        public static final RegistryObject<Block> POTTED_CANDY_CANE_SAPLING = HELPER.createBlockNoItem("potted_candy_cane_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CANDY_CANE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noCollission()));

        public static final RegistryObject<Block> RED_LICORICE_LOG = HELPER.createBlock("red_licorice_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.COLOR_RED, MaterialColor.COLOR_BROWN)).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> STRIPPED_RED_LICORICE_LOG = HELPER.createBlock("stripped_red_licorice_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.COLOR_RED, MaterialColor.COLOR_RED)).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> RED_LICORICE_WOOD = HELPER.createBlock("red_licorice_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.COLOR_BROWN, MaterialColor.COLOR_BROWN)).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> STRIPPED_RED_LICORICE_WOOD = HELPER.createBlock("stripped_red_licorice_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, pillarProp(MaterialColor.COLOR_RED, MaterialColor.COLOR_RED)).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> RED_LICORICE_PLANKS = HELPER.createBlock("red_licorice_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_RED).strength(1.0f).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> RED_LICORICE_STAIRS = HELPER.createBlock("red_licorice_stairs", () -> new StairBlock(RED_LICORICE_PLANKS.get()::defaultBlockState, BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> RED_LICORICE_SLAB = HELPER.createBlock("red_licorice_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> RED_LICORICE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "red_licorice_vertical_slab", () -> new VerticalSlabBlock(BlockBehaviour.Properties.copy(RED_LICORICE_PLANKS.get())), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> RED_LICORICE_LEAVES = HELPER.createBlock("red_licorice_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> RED_LICORICE_TREE_SAPLING = HELPER.createBlock("red_licorice_tree_sapling", () -> new ModSaplingBlock(() -> ConfiguredFeatures.RED_LICORICE_TREE_FEATURE, BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_WHITE).instabreak().noCollission().randomTicks().sound(SoundType.GRASS)), CandyCraft.ITEM_GROUP);
        public static final RegistryObject<Block> POTTED_RED_LICORICE_TREE_SAPLING = HELPER.createBlockNoItem("potted_red_licorice_tree_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, RED_LICORICE_TREE_SAPLING, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()));

        public static final RegistryObject<Block> NOUGAT_SLATE = HELPER.createBlock("nougat_slate", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)), CandyCraft.ITEM_GROUP);

    */
    }
}
