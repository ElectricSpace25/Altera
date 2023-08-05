package cyanite.altera.blocks;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlockRegistry {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.GALAXY_VINES, 15, 60);
        registry.add(ModBlocks.GALAXY_VINES_PLANT, 15, 60);

    }
}
