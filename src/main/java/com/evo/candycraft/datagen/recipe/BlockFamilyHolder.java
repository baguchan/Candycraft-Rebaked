package com.evo.candycraft.datagen.recipe;

import com.google.common.collect.Maps;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class BlockFamilyHolder implements Supplier<BlockFamily> {

    private static final Map<ResourceLocation, BlockFamilyHolder> BLOCK_FAMILIES = Maps.newHashMap();

    private final Supplier<BlockFamily> supplier;
    private final ResourceLocation blockID;
    private BlockFamily blockFamily;


    public BlockFamilyHolder(RegistryObject<Block> registryObject, Supplier<BlockFamily> supplier) {
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(registryObject);

        this.supplier = supplier;
        this.blockID = registryObject.getId();

        BlockFamilyHolder familyHolder = BLOCK_FAMILIES.put(getBlockID(), this);

        if (familyHolder != null) {
            throw new IllegalArgumentException("Duplicate block family holder found for block " + "\"" + getBlockID() + "\"");
        }
    }

    @Override
    public BlockFamily get() {
        if (this.blockFamily == null) {
            throw new NullPointerException("Tried to fetch block family object before it had been constructed.");
        }
        else {
            return this.blockFamily;
        }
    }

    public ResourceLocation getBlockID() {
        return this.blockID;
    }

    public void constructBlockFamily() {
        this.blockFamily = supplier.get();
    }

    public static Stream<BlockFamilyHolder> getAllFamilyHolders() {
        return BLOCK_FAMILIES.values().stream();
    }
}
