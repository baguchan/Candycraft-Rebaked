package com.evo.candycraft.common.world.features;

import com.evo.candycraft.common.core.CandyCraft;
import com.evo.candycraft.common.core.registry.CandyCraftBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class CandyCaneTreeFeature extends Feature<BaseTreeFeatureConfig> {

    public CandyCaneTreeFeature(Codec<BaseTreeFeatureConfig> codec) {
        super(codec);
    }

    @Override                                                                                     // Config doesn't matter for this feature
    public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, BaseTreeFeatureConfig config) {
        int size = 4;
        if (rand.nextInt(3) == 0)
            ++size;
        if (rand.nextInt(4) == 0)
            ++size;

        if (pos.getY() + size <= 256) {
            boolean flag = true;

            for (BlockPos blockPos : BlockPos.getAllInBoxMutable(pos.add(-2, 1, -2), pos.add(2, size, 2))) {
                BlockState blockState = reader.getBlockState(blockPos);
                if (!blockState.canBeReplacedByLogs(reader, blockPos)) {
                    flag = false;
                    break;
                }
            }
            if (!flag)
                return false;
            else {
                Direction direction = Direction.byHorizontalIndex(rand.nextInt(4) + 1);
                this.generateCane(reader, pos, direction, size);
                return true;
            }
        }
        return false;
    }

    private void generateCane(ISeedReader reader, BlockPos origin, Direction direction, int size) {
        BlockState CANDY_CANE = CandyCraftBlocks.CANDY_CANE_BLOCK.get().getDefaultState();
        BlockState CANDY_CANE_BARK = CandyCraftBlocks.CANDY_CANE_WOOD.get().getDefaultState().with(RotatedPillarBlock.AXIS, Direction.DOWN.getAxis());

        for (int i = 0; i < size; i++) {
            reader.setBlockState(origin.up(i), CANDY_CANE, 2);
        }
        BlockPos pos = origin.up(size).toImmutable();

        switch (direction) {
            case NORTH:
                reader.setBlockState(pos, CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.north(), CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.north(2), CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.north(2).down(1), CANDY_CANE_BARK, 2);
                break;
            case WEST:
                reader.setBlockState(pos, CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.west(), CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.west(2), CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.west(2).down(1), CANDY_CANE_BARK, 2);
                break;
            case EAST:
                reader.setBlockState(pos, CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.east(), CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.east(2), CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.east(2).down(1), CANDY_CANE_BARK, 2);
                break;
            default:
            case SOUTH:
                reader.setBlockState(pos, CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.south(), CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.south(2), CANDY_CANE_BARK, 2);
                reader.setBlockState(pos.south(2).down(1), CANDY_CANE_BARK, 2);
                break;
        }
    }
}
