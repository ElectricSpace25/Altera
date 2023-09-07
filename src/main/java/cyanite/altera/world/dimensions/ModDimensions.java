package cyanite.altera.world.dimensions;

import cyanite.altera.AlteraMod;
import cyanite.altera.blocks.ModBlocks;
import cyanite.altera.items.ModItems;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    //Moonlit Spires
    public static final RegistryKey<World> MOONLIT_SPIRES_DIM_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(AlteraMod.MOD_ID, "moonlit_spires"));
    public static final RegistryKey<DimensionType> MOONLIT_SPIRES_DIM_TYPE_KEY = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, MOONLIT_SPIRES_DIM_KEY.getValue());

    public static void registerModDimensions() {
        AlteraMod.LOGGER.debug("Registering ModDimensions for Altera");
    }
}
