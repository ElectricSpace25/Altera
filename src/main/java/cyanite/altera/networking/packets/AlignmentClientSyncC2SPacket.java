package cyanite.altera.networking.packets;

import cyanite.altera.util.AlignmentData;
import cyanite.altera.util.IEntityDataSaver;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class AlignmentClientSyncC2SPacket {
    public static void recieve(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //This ONLY happens on the server

        AlignmentData.syncAlignment(((IEntityDataSaver) player).getPersistentData().getInt("alignment"), player);

    }
}
