package cyanite.altera.util;

import cyanite.altera.networking.ModMessages;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public class AlignmentData {
    public static int getAlignment(IEntityDataSaver player) {
        NbtCompound nbt = player.getPersistentData();
        int alignment = nbt.getInt("alignment");

        return alignment;
    }

    public static int addAlignment(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int alignment = nbt.getInt("alignment");
        if (alignment + amount > 100) {
            alignment = 100;
        } else {
            alignment += amount;
        }

        nbt.putInt("alignment", alignment);

        syncAlignment(alignment, (ServerPlayerEntity) player);

        return alignment;
    }

    public static int removeAlignment(IEntityDataSaver player, int amount) {
        NbtCompound nbt = player.getPersistentData();
        int alignment = nbt.getInt("alignment");
        if (alignment + amount < -100) {
            alignment = -100;
        } else {
            alignment -= amount;
        }

        nbt.putInt("alignment", alignment);

        syncAlignment(alignment, (ServerPlayerEntity) player);

        return alignment;
    }

    public static void syncAlignment(int alignment, ServerPlayerEntity player) {
        PacketByteBuf buffer = PacketByteBufs.create();
        buffer.writeInt(alignment);
        ServerPlayNetworking.send(player, ModMessages.ALIGNMENT_SYNC_ID, buffer);
    }
}
