package cyanite.altera.world.biomes;

import com.mojang.datafixers.util.Pair;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class ModRegion extends Region {

    public ModRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<MultiNoiseUtil.NoiseHypercube, RegistryKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();

        //Using default options
        new ParameterUtils.ParameterPointListBuilder().build().forEach(point -> builder.add(point, ModBiomes.PLAGUED_LANDS));

        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.FULL_RANGE.parameter())
                .humidity(ParameterUtils.Temperature.FULL_RANGE.parameter())
                .continentalness(ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.NEAR_INLAND, ParameterUtils.Continentalness.INLAND))
                .erosion(ParameterUtils.Erosion.EROSION_5, ParameterUtils.Erosion.EROSION_6)
                .depth(ParameterUtils.Depth.SURFACE)
                .weirdness(ParameterUtils.Weirdness.span(ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING, ParameterUtils.Weirdness.MID_SLICE_VARIANT_ASCENDING))
                .build().forEach(point -> builder.add(point, ModBiomes.PLAGUED_LANDS));



        // Add our points to the mapper
        builder.build().forEach(mapper::accept);
    }
}
