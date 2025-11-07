package net.matchamod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.matchamod.MatchaMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PumpkinBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RAINFOREST_GRASS_BLOCK = registerBlock(
            "rainforest_grass_block",
            new RainforestGrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK))
    );

    public static final Block BOG_GRASS_BLOCK = registerBlock(
            "bog_grass_block",
            new BogGrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK))
    );

    public static final Block MOSSY_GRASS_BLOCK = registerBlock(
            "mossy_grass_block",
            new MossyGrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK))
    );

    public static final  Block BOG_SOIL = registerBlock(
            "bog_soil",
            new BogSoilBlock(FabricBlockSettings.copyOf(Blocks.DIRT))
    );

    public static final  Block RAINFOREST_SOIL = registerBlock(
            "rainforest_soil",
            new BogSoilBlock(FabricBlockSettings.copyOf(Blocks.DIRT))
    );

    public static final Block MOSSY_GROUND = registerBlock(
            "mossy_ground",
            new MossyGroundBlock(FabricBlockSettings.copy(Blocks.DIRT)));

    public static final Block ICE_TEA = registerBlock(
            "ice_tea",
            new MossyGroundBlock(FabricBlockSettings.copy(Blocks.BAMBOO)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MatchaMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MatchaMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        MatchaMod.LOGGER.info("Registering Block Entities for " + MatchaMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.RAINFOREST_GRASS_BLOCK);
            entries.add(ModBlocks.RAINFOREST_SOIL);
            entries.add(ModBlocks.BOG_GRASS_BLOCK);
            entries.add(ModBlocks.BOG_SOIL);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ModBlocks.ICE_TEA);
        });
    }
}
