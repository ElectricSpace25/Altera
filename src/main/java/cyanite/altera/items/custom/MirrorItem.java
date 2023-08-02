package cyanite.altera.items.custom;

import cyanite.altera.networking.ModMessages;
import cyanite.altera.screen.MirrorScreen;
import cyanite.altera.screen.MirrorScreenHandler;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MirrorItem extends Item {

    public MirrorItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        //Todo: figure out if this should be isClient or !isClient
        if (world.isClient && hand == Hand.MAIN_HAND) {

//            MinecraftClient.getInstance().setScreen(new MirrorScreen(MirrorScreenHandler()));

            if (user.isSneaking()) {
                ClientPlayNetworking.send(ModMessages.REMOVE_1_ALIGNMENT_ID, PacketByteBufs.create());
            } else {
                ClientPlayNetworking.send(ModMessages.ADD_1_ALIGNMENT_ID, PacketByteBufs.create());
            }
        }
        return super.use(world, user, hand);
    }



}
