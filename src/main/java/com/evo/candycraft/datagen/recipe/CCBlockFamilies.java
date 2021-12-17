package com.evo.candycraft.datagen.recipe;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CandyCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CCBlockFamilies {

    private static final String GROUP_WOODEN = "wooden";
    private static final String HAS_PLANKS = "has_planks";


    // Constructing right after the block registry event
    // to ensure all blocks are registered before referencing.
    @SubscribeEvent
    public static void constructBlockFamilies(RegistryEvent.Register<Item> event) {
        BlockFamilyHolder.getAllFamilyHolders().forEach(BlockFamilyHolder::constructBlockFamily);
    }


    public static final BlockFamilyHolder RED_LICORICE_PLANKS = new BlockFamilyHolder(CandyCraftBlocks.RED_LICORICE_PLANKS, () -> builder(CandyCraftBlocks.RED_LICORICE_PLANKS.get())
            .button(CandyCraftBlocks.RED_LICORICE_BUTTON.get())
            .fence(CandyCraftBlocks.RED_LICORICE_FENCE.get())
            .fenceGate(CandyCraftBlocks.RED_LICORICE_FENCE_GATE.get())
            .pressurePlate(CandyCraftBlocks.RED_LICORICE_PRESSURE_PLATE.get())
            .slab(CandyCraftBlocks.RED_LICORICE_SLAB.get())
            .stairs(CandyCraftBlocks.RED_LICORICE_STAIRS.get())
            .door(CandyCraftBlocks.RED_LICORICE_DOOR.get())
            .trapdoor(CandyCraftBlocks.RED_LICORICE_TRAPDOOR.get())
            .recipeGroupPrefix(GROUP_WOODEN)
            .recipeUnlockedBy(HAS_PLANKS)
            .getFamily());


    private static BlockFamily.Builder builder(Block block) {
        return new BlockFamily.Builder(block);
    }
}
