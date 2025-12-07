package net.matchamod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;

import net.minecraft.util.shape.VoxelShape;

public class IceTea extends Block {

    private static final VoxelShape SHAPE = Block.createCuboidShape(6, 0, 5, 10, 10, 9);

    public IceTea() {
        super(FabricBlockSettings.copyOf(Blocks.BAMBOO)
                .breakInstantly()
                .ticksRandomly()
                .nonOpaque());
    }}





