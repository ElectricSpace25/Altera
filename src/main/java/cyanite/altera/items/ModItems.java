package cyanite.altera.items;

import cyanite.altera.AlteraMod;
import cyanite.altera.blocks.ModBlocks;
import cyanite.altera.items.custom.MirrorItem;
import cyanite.altera.items.custom.ModFoodComponents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    
    //Items
    public static final Item MIRROR = registerItem("mirror", new MirrorItem(new FabricItemSettings().maxCount(1)));
    public static final Item MODEL_MIRROR = registerItem("model_mirror", new MirrorItem(new FabricItemSettings().maxCount(1)));
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new FabricItemSettings()));
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new FabricItemSettings()));
    public static final Item GALAXY_BERRIES = registerItem("galaxy_berries", new AliasedBlockItem(ModBlocks.GALAXY_VINES, new Item.Settings().food(ModFoodComponents.GALAXY_BERRIES)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AlteraMod.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.ALTERA_GROUP, MIRROR);
        addToItemGroup(ModItemGroup.ALTERA_GROUP, MODEL_MIRROR);
        addToItemGroup(ModItemGroup.ALTERA_GROUP, RAW_SILVER);
        addToItemGroup(ModItemGroup.ALTERA_GROUP, SILVER_INGOT);
        addToItemGroup(ModItemGroup.ALTERA_GROUP, GALAXY_BERRIES);

    }

    public static void addToItemGroup (RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
            content.add(item);
        });
    }

    public static void registerModItems() {
        AlteraMod.LOGGER.info("Registering mod items for Altera");
        addItemsToItemGroup();
    }

}
