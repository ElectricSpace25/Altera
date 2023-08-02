package cyanite.altera.util;

import cyanite.altera.AlteraMod;
import cyanite.altera.items.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider{

    public static void registerModModels() {
        ModelPredicateProviderRegistry.register(ModItems.MIRROR, new Identifier("alignment"), (stack, world, entity, seed) -> {
            //Mirror looks neutral if not held by you

            if (entity != MinecraftClient.getInstance().player) {
                return 0.5f;
            }

            //Corrupt Mirror
            if (((IEntityDataSaver) entity).getPersistentData().getInt("alignment") <= -5) {
                AlteraMod.LOGGER.info("Corrupt Mirror");
                return 0.0f;
            }

            //Pure Mirror
            if (((IEntityDataSaver) entity).getPersistentData().getInt("alignment") >= 5) {
                AlteraMod.LOGGER.info("Pure Mirror");
                return 1.0f;
            }

            //Neutral Mirror
            return 0.5f;
        });

    }

}
