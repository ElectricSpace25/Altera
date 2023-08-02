package cyanite.altera.items.custom;

import cyanite.altera.networking.ModMessages;
import cyanite.altera.screen.MirrorScreen;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MirrorItem extends Item {

    public MirrorItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient && hand == Hand.MAIN_HAND) {

            //Open GUI
            //MirrorScreen.open();

            PacketByteBuf buf = PacketByteBufs.create();
            //Send packet
            if (user.isSneaking()) {
                buf.writeInt(-1);
                ClientPlayNetworking.send(ModMessages.CHANGE_ALIGNMENT_ID, buf);
            } else {
                buf.writeInt(1);
                ClientPlayNetworking.send(ModMessages.CHANGE_ALIGNMENT_ID, buf);
            }
        }
        return super.use(world, user, hand);
    }



}
