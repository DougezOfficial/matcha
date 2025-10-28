package net.matchamod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.*;

import net.minecraft.util.math.random.Random;

public class IceTea extends Block {

    private static final VoxelShape SHAPE = Block.createCuboidShape(6, 0, 5, 10, 10, 9);

    public IceTea() {
        super(FabricBlockSettings.copyOf(Blocks.BAMBOO)
                .noCollision() // can walk through
                .breakInstantly()
                .ticksRandomly()
                .nonOpaque());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public float getOffsetX(BlockState state, BlockView world, BlockPos pos) {
        Random rand = Random.createLocal();
        return (rand.nextFloat() - 0.5f) * 0.2f;
    }

    @Override
    public float getOffsetZ(BlockState state, BlockView world, BlockPos pos) {
        Random rand = Random.createLocal();
        return (rand.nextFloat() - 0.5f) * 0.2f;
    }

    @Override
    public float getOffsetY(BlockState state, BlockView world, BlockPos pos) {
        return 0f;
    };


