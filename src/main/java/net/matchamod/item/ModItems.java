package net.matchamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.matchamod.MatchaMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class ModItems {

    public static final Item KRATOM_SEEDS = registerItem("kratom_seeds", new Item(new Item.Settings()));
    public static final Item KRATOM_LEAF = registerItem("kratom_leaf", new Item(new Item.Settings()));
    public static final Item BLOOD_HIBISCUS = registerItem("blood_hibiscus", new Item(new Item.Settings()));
    public static final Item DRIED_BLOOD_HIBISCUS = registerItem("dried_blood_hibiscus", new Item(new Item.Settings()));
    public static final Item ICE_TEA = registerItem("ice_tea", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MatchaMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MatchaMod.LOGGER.info("Registering Mod Items for " + MatchaMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(KRATOM_SEEDS);
            entries.add(KRATOM_LEAF);
            entries.add(BLOOD_HIBISCUS);
            entries.add(DRIED_BLOOD_HIBISCUS);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ICE_TEA);
        });
    }
}
