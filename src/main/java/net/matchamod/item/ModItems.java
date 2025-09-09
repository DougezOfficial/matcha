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

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MatchaMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MatchaMod.LOGGER.info("Registering Mod Items for " + MatchaMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(KRATOM_SEEDS);
        });
    }
}
