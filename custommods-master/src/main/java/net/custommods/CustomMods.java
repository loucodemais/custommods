package net.custommods;

import net.custommods.block.ModBlocks;
import net.custommods.block.entity.ModBlockEntities;
import net.custommods.item.ModItemGroups;
import net.custommods.item.ModItems;
import net.custommods.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomMods implements ModInitializer {
	public static final String MOD_ID = "custommods";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting CustomMods");


		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

	}
}
