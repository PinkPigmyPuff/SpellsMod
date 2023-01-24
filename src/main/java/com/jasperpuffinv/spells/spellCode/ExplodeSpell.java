package com.jasperpuffinv.spells.spellCode;

import com.jasperpuffinv.spells.Main;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplodeSpell {
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(ExplodeSpell::explodeSpell);
    }

    public static void explodeSpell(MinecraftClient client) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && Main.EXPLODE_KEY.isPressed()) {
            World world = player.world;
            world.createExplosion(null, player.getX(), player.getY(), player.getZ(), 4f, World.ExplosionSourceType.BLOCK);
        }
    }
}
