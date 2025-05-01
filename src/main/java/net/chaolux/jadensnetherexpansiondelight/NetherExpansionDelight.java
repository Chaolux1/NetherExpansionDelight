package net.chaolux.jadensnetherexpansiondelight;

import net.chaolux.jadensnetherexpansiondelight.registry.block.ModBlocks;
import net.chaolux.jadensnetherexpansiondelight.registry.item.ModItemCreativeGroup;
import net.chaolux.jadensnetherexpansiondelight.registry.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherExpansionDelight implements ModInitializer {
	public static final String MOD_ID = "jadensnetherexpansiondelight";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.touch();
		ModBlocks.touch();
		ModItemCreativeGroup.touch();

		LOGGER.info("Hello Fabric world!");
	}


}