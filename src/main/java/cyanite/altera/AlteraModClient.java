package cyanite.altera;

import cyanite.altera.networking.ModMessages;
import cyanite.altera.screen.MirrorScreen;
import cyanite.altera.screen.ModScreenHandlers;
import cyanite.altera.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class AlteraModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.MIRROR_SCREEN_HANDLER, MirrorScreen::new);

        ModModelPredicateProvider.registerModModels();
        ModMessages.registerS2CPackets();
    }
}
