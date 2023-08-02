package cyanite.altera;

import cyanite.altera.networking.ModMessages;
import cyanite.altera.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;

public class AlteraModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModModelPredicateProvider.registerModModels();
        ModMessages.registerS2CPackets();
    }
}
