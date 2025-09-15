package net.matchamod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.matchamod.MatchaMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RAINFOREST_GRASS_BLOCK = registerBlock("rainforest_grass_block",
            new Block(AbstractBlock.Settings.create().strength(0.11F)
                    .requiresTool().sounds(BlockSoundGroup.GRASS)));

    public static final Block BOG_GRASS_BLOCK = registerBlock("bog_grass_block",
            new Block(AbstractBlock.Settings.create().strength(0.11f)
                    .requiresTool().sounds(BlockSoundGroup.GRASS)));

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
            entries.add(ModBlocks.BOG_GRASS_BLOCK);
        });
    }
}
