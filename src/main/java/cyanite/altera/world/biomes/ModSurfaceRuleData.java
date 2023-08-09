package cyanite.altera.world.biomes;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModSurfaceRuleData {
    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule BLUE_CONCRETE = makeStateRule(Blocks.BLUE_CONCRETE);
    private static final MaterialRules.MaterialRule BLUE_TERRACOTTA = makeStateRule(Blocks.BLUE_TERRACOTTA);

    //NOTE: This class is currently unused!
    public static MaterialRules.MaterialRule makeRules()
    {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.condition(MaterialRules.biome(ModBiomes.PLAGUED_LANDS), DIRT),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block)
    {
        return MaterialRules.block(block.getDefaultState());
    }
}
