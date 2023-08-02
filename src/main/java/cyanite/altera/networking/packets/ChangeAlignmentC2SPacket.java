package cyanite.altera.networking.packets;

import cyanite.altera.util.AlignmentData;
import cyanite.altera.util.IEntityDataSaver;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ChangeAlignmentC2SPacket {
    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        //This ONLY happens on the server

        //Change alignment
        int change = buf.readInt();
        AlignmentData.changeAlignment((IEntityDataSaver) player, change);

        //Notify player
        player.sendMessage(Text.literal("Alignment: " + ((IEntityDataSaver) player).getPersistentData().getInt("alignment"))
                .fillStyle(Style.EMPTY.withColor(Formatting.AQUA)), true);
    }
}
