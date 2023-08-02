package cyanite.altera.networking;

import cyanite.altera.AlteraMod;
import cyanite.altera.networking.packets.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier ADD_1_ALIGNMENT_ID = new Identifier(AlteraMod.MOD_ID, "add_1_alignment");
    public static final Identifier REMOVE_1_ALIGNMENT_ID = new Identifier(AlteraMod.MOD_ID, "remove_1_alignment");
    public static final Identifier ALIGNMENT_SYNC_ID = new Identifier(AlteraMod.MOD_ID, "alignment_sync");
    public static final Identifier ALIGNMENT_CLIENT_SYNC_ID = new Identifier(AlteraMod.MOD_ID, "alignment_client_sync");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(ADD_1_ALIGNMENT_ID, Add1AlignmentC2SPacket::recieve);
        ServerPlayNetworking.registerGlobalReceiver(REMOVE_1_ALIGNMENT_ID, Remove1AlignmentC2SPacket::recieve);
        ServerPlayNetworking.registerGlobalReceiver(ALIGNMENT_CLIENT_SYNC_ID, Remove1AlignmentC2SPacket::recieve);
    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ALIGNMENT_SYNC_ID, AlignmentSyncS2CPacket::recieve);
    }

}
