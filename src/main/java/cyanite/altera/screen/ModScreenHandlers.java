package cyanite.altera.screen;

import cyanite.altera.AlteraMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<MirrorScreenHandler> MIRROR_SCREEN_HANDLER; //= new ScreenHandlerType<MirrorScreenHandler>(MirrorScreenHandler::new, FeatureFlags.VANILLA_FEATURES);;

    public static void registerAllScreenHandlers() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(AlteraMod.MOD_ID, "cheese_press"), MIRROR_SCREEN_HANDLER);
    }
}
