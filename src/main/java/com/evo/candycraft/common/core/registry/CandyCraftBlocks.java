package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.blocks.ModSaplingBlock;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.world.features.ConfiguredFeatures;
import com.minecraftabnormals.abnormals_core.common.blocks.VerticalSlabBlock;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CandyCraftBlocks {

    public static final BlockSubRegistryHelper HELPER = CandyCraft.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> WAFFLE_CONE_BLOCK = HELPER.createBlock("waffle_cone_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.NETHER_GOLD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> WAFFLE_CONE_DOOR = HELPER.createBlock("waffle_cone_door", ()->new DoorBlock(Properties.WAFFLE_CONE_DOOR), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> WAFFLE_CONE_TRAPDOOR = HELPER.createBlock("waffle_cone_trapdoor", ()->new TrapDoorBlock(Properties.WAFFLE_CONE_TRAPDOOR), CandyCraft.ITEM_GROUP);

    public static final RegistryObject<Block> CANDY_CANE_BLOCK = HELPER.createBlock("candy_cane_block", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.WHITE_TERRACOTTA, MaterialColor.WHITE_TERRACOTTA)).hardnessAndResistance(1.0f, 1.0f).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> CANDY_CANE_WOOD = HELPER.createBlock("candy_cane_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(CANDY_CANE_BLOCK.get())), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> CANDY_CANE_SAPLING = HELPER.createBlock("candy_cane_sapling", () -> new ModSaplingBlock(ConfiguredFeatures.CANDY_CANE_TREE_FEATURE, AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.WHITE_TERRACOTTA).zeroHardnessAndResistance().doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> POTTED_CANDY_CANE_SAPLING = HELPER.createBlock("potted_candy_cane_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CANDY_CANE_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0f).notSolid()), CandyCraft.ITEM_GROUP);

    public static final RegistryObject<Block> RED_LICORICE_LOG = HELPER.createBlock("red_licorice_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.RED, MaterialColor.BROWN)).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> STRIPPED_RED_LICORICE_LOG = HELPER.createBlock("stripped_red_licorice_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.RED, MaterialColor.RED)).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_WOOD = HELPER.createBlock("red_licorice_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.BROWN, MaterialColor.BROWN)).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> STRIPPED_RED_LICORICE_WOOD = HELPER.createBlock("stripped_red_licorice_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.RED, MaterialColor.RED)).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_PLANKS = HELPER.createBlock("red_licorice_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.RED).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_STAIRS = HELPER.createBlock("red_licorice_stairs", () -> new StairsBlock(RED_LICORICE_PLANKS.get()::getDefaultState, AbstractBlock.Properties.from(RED_LICORICE_PLANKS.get())), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_SLAB = HELPER.createBlock("red_licorice_slab", () -> new SlabBlock(AbstractBlock.Properties.from(RED_LICORICE_PLANKS.get())), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_VERTICAL_SLAB = HELPER.createCompatBlock("quark", "red_licorice_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(RED_LICORICE_PLANKS.get())), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> RED_LICORICE_TREE_SAPLING = HELPER.createBlock("red_licorice_tree_sapling", () -> new ModSaplingBlock(ConfiguredFeatures.CANDY_CANE_TREE_FEATURE, AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.WHITE_TERRACOTTA).zeroHardnessAndResistance().doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)), CandyCraft.ITEM_GROUP);
    public static final RegistryObject<Block> POTTED_RED_LICORICE_TREE_SAPLING = HELPER.createBlockNoItem("potted_red_licorice_tree_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, RED_LICORICE_TREE_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0f).notSolid()));

    public static final RegistryObject<Block> NOUGAT_SLATE = HELPER.createBlock("nougat_slate", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.5F, 6.0F).harvestTool(ToolType.PICKAXE).setRequiresTool().sound(SoundType.STONE)), CandyCraft.ITEM_GROUP);



    public static void registerBlockData() {
        registerPottablePlant(CANDY_CANE_SAPLING, POTTED_CANDY_CANE_SAPLING);
        registerPottablePlant(RED_LICORICE_TREE_SAPLING, POTTED_RED_LICORICE_TREE_SAPLING);
    }

    private static void registerPottablePlant(Supplier<Block> plant, Supplier<Block> pottedPlant) {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Objects.requireNonNull(plant.get().getRegistryName()), pottedPlant);
    }

    private static Function<BlockState, MaterialColor> pillarProp(MaterialColor topColor, MaterialColor sideColor) {
        return (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor;
    }

    public static class Properties {
        public static final AbstractBlock.Properties WAFFLE_CONE_DOOR = AbstractBlock.Properties.from(Blocks.OAK_DOOR).harvestTool(ToolType.AXE);
        public static final AbstractBlock.Properties WAFFLE_CONE_TRAPDOOR = AbstractBlock.Properties.from(Blocks.OAK_TRAPDOOR).harvestTool(ToolType.AXE);
    }
}
