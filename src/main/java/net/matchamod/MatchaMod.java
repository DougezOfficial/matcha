package net.matchamod;

import net.fabricmc.api.ModInitializer;

import net.matchamod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MatchaMod implements ModInitializer {
	public static final String MOD_ID = "matchamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModItems.registerModItems();
    }

}