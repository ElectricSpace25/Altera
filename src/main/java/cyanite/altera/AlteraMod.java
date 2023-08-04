package cyanite.altera;

import cyanite.altera.blocks.ModBlocks;
import cyanite.altera.items.ModItemGroup;
import cyanite.altera.items.ModItems;
import cyanite.altera.networking.ModMessages;
import cyanite.altera.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlteraMod implements ModInitializer {
	public static final String MOD_ID = "altera";
	public static final Logger LOGGER = LoggerFactory.getLogger("altera");

	@Override
	public void onInitialize() {
		LOGGER.info("Altera loading");

		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
		ModMessages.registerC2SPackets();
	}
}