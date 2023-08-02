package cyanite.altera.items;

import cyanite.altera.AlteraMod;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final RegistryKey<ItemGroup> ALTERA_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(AlteraMod.MOD_ID, "altera_group"));

    public static void registerItemGroups() {
        AlteraMod.LOGGER.info("Registering item group for Altera");

        Registry.register(Registries.ITEM_GROUP, ALTERA_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.MIRROR))
                .displayName(Text.literal("Altera"))
                .build());
    }
}
