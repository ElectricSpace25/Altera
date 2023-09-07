package cyanite.altera.blocks;

import cyanite.altera.AlteraMod;
import cyanite.altera.blocks.custom.GalaxyVinesBodyBlock;
import cyanite.altera.blocks.custom.GalaxyVinesHeadBlock;
import cyanite.altera.items.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block SILVER_ORE = registerBlock("silver_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.create()
                    .strength(3.0f, 3.0f)
                    .requiresTool()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(Instrument.BASEDRUM),
                    UniformIntProvider.create(0, 2)),
                    null);

    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.create()
                    .strength(4.5f, 3.0f)
                    .requiresTool()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(Instrument.BASEDRUM),
                    UniformIntProvider.create(0, 2)),
                    ModItemGroup.ALTERA_GROUP);

    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            new Block(FabricBlockSettings.create()
                    .strength(5.0f, 6.0f)
                    .requiresTool()
                    .mapColor(MapColor.IRON_GRAY)
                    .sounds(BlockSoundGroup.METAL)),
                    ModItemGroup.ALTERA_GROUP);

    public static final Block GALAXY_VINES = registerBlockNoGroup("galaxy_vines",
            new GalaxyVinesHeadBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.DARK_AQUA)
                    .ticksRandomly().noCollision()
                    .luminance(CaveVines.getLuminanceSupplier(14))
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CAVE_VINES)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block GALAXY_VINES_PLANT = registerBlockNoGroup("galaxy_vines_plant",
            new GalaxyVinesBodyBlock(FabricBlockSettings.create()
                    .mapColor(MapColor.DARK_AQUA)
                    .noCollision()
                    .luminance(CaveVines.getLuminanceSupplier(14))
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CAVE_VINES)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(AlteraMod.MOD_ID, name), block);
    }

    private static Block registerBlockNoGroup(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(AlteraMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(AlteraMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        AlteraMod.LOGGER.info("Registering ModBlocks for Altera");
    }
}
