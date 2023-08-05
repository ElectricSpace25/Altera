package cyanite.altera;

import cyanite.altera.blocks.ModBlocks;
import cyanite.altera.networking.ModMessages;
import cyanite.altera.util.AlignmentData;
import cyanite.altera.util.IEntityDataSaver;
import cyanite.altera.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.network.PacketByteBuf;

public class AlteraModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ModModelPredicateProvider.registerModModels();
        ModMessages.registerS2CPackets();

        //Sync alignment with client
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> syncAlignment());

        //Rendering
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GALAXY_VINES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GALAXY_VINES_PLANT, RenderLayer.getCutout());
    }

    public static void syncAlignment() {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeInt(0);
        ClientPlayNetworking.send(ModMessages.CHANGE_ALIGNMENT_ID, buf);
	}

}
