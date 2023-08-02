//package cyanite.corruption_mod.networking;
//
//import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
//import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
//import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
//import net.fabricmc.fabric.api.networking.v1.PacketSender;
//import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
//import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.network.ClientPlayNetworkHandler;
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.server.network.ServerPlayNetworkHandler;
//
//public class ServerPlayConnectionJoin implements ServerPlayConnectionEvents.Join {
//
//    @Override
//    public void onPlayReady(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server) {
//        ServerPlayNetworking.send();
//
//    }
//}
