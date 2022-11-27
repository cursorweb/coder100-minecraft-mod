package net.fabricmc.garden;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.garden.register.GardenBlocks;
import net.fabricmc.garden.register.GardenItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Garden implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("gardenmod");

    @Override
    public void onInitialize() {
        LOGGER.info("Hello Fabric world!");

        GardenItems.init();
        GardenBlocks.init();
    }
}
