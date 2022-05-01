package com.evo.candycraft_rebaked.common.features;

import com.evo.candycraft_rebaked.common.core.registry.CandyCraftBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;

import java.util.Random;

public class CandyCaneTreeFeature extends Feature<TreeConfiguration> {

    public CandyCaneTreeFeature(Codec<TreeConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeConfiguration> placeContext) {
        return this.place(placeContext.level(), placeContext.chunkGenerator(), placeContext.random(), placeContext.origin(), placeContext.config());
    }

    public boolean place(WorldGenLevel worldGenLevel, ChunkGenerator generator, Random rand, BlockPos pos, TreeConfiguration config) {
        int size = 4;
        if (rand.nextInt(3) == 0)
            ++size;
        if (rand.nextInt(4) == 0)
            ++size;

        if (pos.getY() + size <= 256) {
            boolean flag = true;

            for (BlockPos blockPos : BlockPos.betweenClosed(pos.offset(-2, 1, -2), pos.offset(2, size, 2))) {
                if (!TreeFeature.validTreePos(worldGenLevel, blockPos)) {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                return false;
            else {
                Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(rand);
                this.generateCane(worldGenLevel, pos, direction, size);
                return true;
            }
        }
        return false;
    }

    private void generateCane(WorldGenLevel worldGenLevel, BlockPos origin, Direction direction, int size) {
        BlockState CANDY_CANE = CandyCraftBlocks.CANDY_CANE_BLOCK.get().defaultBlockState();
        BlockState CANDY_CANE_BARK = CandyCraftBlocks.CANDY_CANE_WOOD.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.DOWN.getAxis());

        for (int i = 0; i < size; i++) {
            worldGenLevel.setBlock(origin.above(i), CANDY_CANE, 2);
        }
        BlockPos pos = origin.above(size).immutable();

        switch (direction) {
            case NORTH -> {
                worldGenLevel.setBlock(pos, CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.north(), CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.north(2), CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.north(2).below(), CANDY_CANE_BARK, 2);
            }
            case WEST -> {
                worldGenLevel.setBlock(pos, CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.west(), CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.west(2), CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.west(2).below(), CANDY_CANE_BARK, 2);
            }
            case EAST -> {
                worldGenLevel.setBlock(pos, CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.east(), CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.east(2), CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.east(2).below(), CANDY_CANE_BARK, 2);
            }
            case SOUTH -> {
                worldGenLevel.setBlock(pos, CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.south(), CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.south(2), CANDY_CANE_BARK, 2);
                worldGenLevel.setBlock(pos.south(2).below(), CANDY_CANE_BARK, 2);
            }
        }
    }
}
