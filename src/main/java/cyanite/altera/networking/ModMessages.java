package cyanite.altera.networking;

import cyanite.altera.AlteraMod;
import cyanite.altera.AlteraModClient;
import cyanite.altera.networking.packets.*;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static final Identifier CHANGE_ALIGNMENT_ID = new Identifier(AlteraMod.MOD_ID, "change_alignment");
    public static final Identifier ALIGNMENT_SYNC_ID = new Identifier(AlteraMod.MOD_ID, "alignment_sync");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(CHANGE_ALIGNMENT_ID, ChangeAlignmentC2SPacket::receive);
    }

    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ALIGNMENT_SYNC_ID, AlignmentSyncS2CPacket::receive);
    }

}
