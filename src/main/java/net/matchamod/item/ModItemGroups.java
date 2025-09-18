package net.matchamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.matchamod.MatchaMod;
import net.matchamod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {

    public static final ItemGroup MATCHA_MOD_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MatchaMod.MOD_ID, "matcha_mod_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RAINFOREST_GRASS_BLOCK))
                    .displayName(Text.translatable("itemgroup.matchamod.matcha_mod_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAINFOREST_GRASS_BLOCK);
                        entries.add(ModBlocks.BOG_GRASS_BLOCK);

                    }).build());

    public static final ItemGroup MATCHA_MOD_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MatchaMod.MOD_ID, "matcha_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.KRATOM_LEAF))
                    .displayName(Text.translatable("itemgroup.matchamod.matcha_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.KRATOM_LEAF);
                        entries.add(ModItems.KRATOM_SEEDS);
                        entries.add(ModItems.BLOOD_HIBISCUS);
                        entries.add(ModItems.DRIED_BLOOD_HIBISCUS);

                    }).build());

    public static void registerItemGroups() {
        MatchaMod.LOGGER.info("Registering Item Groups for "+ MatchaMod.MOD_ID);
    }
}
