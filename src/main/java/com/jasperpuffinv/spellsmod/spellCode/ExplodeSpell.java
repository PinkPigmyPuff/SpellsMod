package com.jasperpuffinv.spellsmod.spellCode;

import com.jasperpuffinv.spellsmod.Main;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.world.World;

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
