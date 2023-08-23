package cyanite.altera;

import cyanite.altera.blocks.ModBlocks;
import cyanite.altera.blocks.ModFlammableBlockRegistry;
import cyanite.altera.items.ModItemGroup;
import cyanite.altera.items.ModItems;
import cyanite.altera.networking.ModMessages;
import cyanite.altera.world.biomes.ModRegion;
import cyanite.altera.world.biomes.ModSurfaceRuleData;
import cyanite.altera.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class AlteraMod implements ModInitializer, TerraBlenderApi {
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
		ModFlammableBlockRegistry.registerFlammableBlocks();
	}

	@Override
	public void onTerraBlenderInitialized()
	{
		// Weights are kept intentionally low as we add minimal biomes
		Regions.register(new ModRegion(new Identifier(MOD_ID, "overworld_1"), 2));

		// Register our surface rules
		SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, SurfaceRuleManager.getDefaultSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD));
	}

	//NOTE: Changes: added modeled mirror (need to fix missing texture), fixed galaxy vine texture, modified plagued lands biome


}