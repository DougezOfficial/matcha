package net.matchamod.block;

import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class MossyGrassBlock extends GrassBlock {
    public MossyGrassBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient) {

            if (!canSurvive(state, world, pos)) {
                world.setBlockState(pos, ModBlocks.BOG_SOIL.getDefaultState());
            } else {
                if (world.getLightLevel(pos.up()) >= 9) {
                    for (int i = 0; i < 4; ++i) {
                        BlockPos targetPos = pos.add(
                                random.nextInt(3) - 1,
                                random.nextInt(5) - 3,
                                random.nextInt(3) - 1
                        );
                        BlockState targetState = world.getBlockState(targetPos);

                        if (targetState.isOf(ModBlocks.BOG_SOIL)
                                && canSpread(state, world, targetPos)) {
                            world.setBlockState(targetPos, this.getDefaultState());
                        }
                    }
                }
            }
        }
    }

    private static boolean canSurvive(BlockState state, ServerWorld world, BlockPos pos) {
        BlockPos abovePos = pos.up();
        return world.getLightLevel(abovePos) >= 4
                && world.getBlockState(abovePos).getOpacity(world, abovePos) <= 2;
    }

    private static boolean canSpread(BlockState state, ServerWorld world, BlockPos pos) {
        BlockPos abovePos = pos.up();
        return world.getLightLevel(abovePos) >= 9
                && world.getBlockState(abovePos).getOpacity(world, abovePos) <= 2;
    }
}
