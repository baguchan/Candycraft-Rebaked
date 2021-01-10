package com.evo.candycraft.common.core.registry;

import com.evo.candycraft.common.blocks.ModSaplingBlock;
import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.world.features.ConfiguredFeatures;
import com.minecraftabnormals.abnormals_core.common.blocks.VerticalSlabBlock;
import com.minecraftabnormals.abnormals_core.core.events.CompatEvents;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import javafx.scene.transform.Rotate;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.Minecraft;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Direction;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CandyCraftBlocks {

    public static final BlockSubRegistryHelper BLOCKS = CandyCraft.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> WAFFLE_CONE_BLOCK = registerBlock("waffle_cone_block", () -> new Block(AbstractBlock.Properties.create(Material.ROCK).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.NETHER_GOLD)));

    public static final RegistryObject<Block> CANDY_CANE_BLOCK = registerBlock("candy_cane_block", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.WHITE_TERRACOTTA, MaterialColor.WHITE_TERRACOTTA)).hardnessAndResistance(1.0f, 1.0f).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CANDY_CANE_WOOD = registerBlock("candy_cane_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.from(CANDY_CANE_BLOCK.get())));
    public static final RegistryObject<Block> CANDY_CANE_SAPLING = registerBlock("candy_cane_sapling", () -> new ModSaplingBlock(ConfiguredFeatures.CANDY_CANE_TREE_FEATURE, AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.WHITE_TERRACOTTA).zeroHardnessAndResistance().doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> POTTED_CANDY_CANE_SAPLING = registerBlockNoItem("potted_candy_cane_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CANDY_CANE_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0f).notSolid()));

    public static final RegistryObject<Block> RED_LICORICE_LOG = registerBlock("red_licorice_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.RED, MaterialColor.BROWN)).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_RED_LICORICE_LOG = registerBlock("stripped_red_licorice_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.RED, MaterialColor.RED)).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RED_LICORICE_WOOD = registerBlock("red_licorice_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.BROWN, MaterialColor.BROWN)).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_RED_LICORICE_WOOD = registerBlock("stripped_red_licorice_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD, pillarProp(MaterialColor.RED, MaterialColor.RED)).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RED_LICORICE_PLANKS = registerBlock("red_licorice_planks", () -> new Block(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.RED).hardnessAndResistance(1.0f).harvestTool(ToolType.AXE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RED_LICORICE_STAIRS = registerBlock("red_licorice_stairs", () -> new StairsBlock(RED_LICORICE_PLANKS.get()::getDefaultState, AbstractBlock.Properties.from(RED_LICORICE_PLANKS.get())));
    public static final RegistryObject<Block> RED_LICORICE_SLAB = registerBlock("red_licorice_slab", () -> new SlabBlock(AbstractBlock.Properties.from(RED_LICORICE_PLANKS.get())));
    public static final RegistryObject<Block> RED_LICORICE_VERTICAL_SLAB = registerCompatBlock("quark", "red_licorice_vertical_slab", () -> new VerticalSlabBlock(AbstractBlock.Properties.from(RED_LICORICE_PLANKS.get())));
    public static final RegistryObject<Block> RED_LICORICE_TREE_SAPLING = registerBlock("red_licorice_tree_sapling", () -> new ModSaplingBlock(ConfiguredFeatures.CANDY_CANE_TREE_FEATURE, AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.WHITE_TERRACOTTA).zeroHardnessAndResistance().doesNotBlockMovement().tickRandomly().sound(SoundType.PLANT)));
    public static final RegistryObject<Block> POTTED_RED_LICORICE_TREE_SAPLING = registerBlockNoItem("potted_red_licorice_tree_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, RED_LICORICE_TREE_SAPLING, AbstractBlock.Properties.create(Material.MISCELLANEOUS).hardnessAndResistance(0.0f).notSolid()));


    public static void registerBlockData() {
        registerPottablePlant(CANDY_CANE_SAPLING, POTTED_CANDY_CANE_SAPLING);
        registerPottablePlant(RED_LICORICE_TREE_SAPLING, POTTED_RED_LICORICE_TREE_SAPLING);
    }

    private static void registerPottablePlant(Supplier<Block> plant, Supplier<Block> pottedPlant) {
        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(Objects.requireNonNull(plant.get().getRegistryName()), pottedPlant);
    }

    private static RegistryObject<Block> registerBlockNoItem(String name, Supplier<Block> blockSupplier) {
        return BLOCKS.createBlockNoItem(name, blockSupplier);
    }

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> blockSupplier) {
        return BLOCKS.createBlock(name, blockSupplier, CandyCraft.ITEM_GROUP);
    }

    private static RegistryObject<Block> registerCompatBlock(String modid, String name, Supplier<Block> blockSupplier) {
        return BLOCKS.createCompatBlock(modid, name, blockSupplier, CandyCraft.ITEM_GROUP);
    }

    private static Function<BlockState, MaterialColor> pillarProp(MaterialColor topColor, MaterialColor sideColor) {
        return (blockState) -> blockState.get(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor;
    }
}
