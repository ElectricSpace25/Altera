package cyanite.altera.world.biomes;

import cyanite.altera.AlteraMod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import terrablender.api.TerraBlenderApi;

public class ModBiomes implements TerraBlenderApi {
    public static final RegistryKey<Biome> PLAGUED_LANDS = register("plagued_lands");

    private static RegistryKey<Biome> register(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, new Identifier(AlteraMod.MOD_ID, name));
    }
}
