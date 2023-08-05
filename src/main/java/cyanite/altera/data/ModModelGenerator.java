package cyanite.altera.data;

import cyanite.altera.blocks.ModBlocks;
import cyanite.altera.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SILVER_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SILVER_BLOCK);
        registerGalaxyVines(blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_SILVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GALAXY_BERRIES, Models.GENERATED);
    }

    public void registerGalaxyVines(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = blockStateModelGenerator.createSubModel(ModBlocks.GALAXY_VINES, "", Models.CROSS, TextureMap::cross);
        Identifier identifier2 = blockStateModelGenerator.createSubModel(ModBlocks.GALAXY_VINES, "_lit", Models.CROSS, TextureMap::cross);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.GALAXY_VINES).coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.BERRIES, identifier2, identifier)));
        Identifier identifier3 = blockStateModelGenerator.createSubModel(ModBlocks.GALAXY_VINES_PLANT, "", Models.CROSS, TextureMap::cross);
        Identifier identifier4 = blockStateModelGenerator.createSubModel(ModBlocks.GALAXY_VINES_PLANT, "_lit", Models.CROSS, TextureMap::cross);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.GALAXY_VINES_PLANT).coordinate(BlockStateModelGenerator.createBooleanModelMap(Properties.BERRIES, identifier4, identifier3)));
    }
}
