package cyanite.altera;

import cyanite.altera.items.ModItemGroup;
import cyanite.altera.items.ModItems;
import cyanite.altera.networking.ModMessages;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AlteraMod implements ModInitializer {
	public static final String MOD_ID = "altera";
	public static final Logger LOGGER = LoggerFactory.getLogger("altera");
	public static int alignment = 0;

	@Override
	public void onInitialize() {
		LOGGER.info("Altera loading");

		ModItemGroup.registerItemGroups();
		ModItems.registerModItems();
		ModMessages.registerC2SPackets();
	}
}