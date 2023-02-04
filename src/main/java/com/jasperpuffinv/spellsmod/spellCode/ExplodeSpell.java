package com.jasperpuffinv.spellsmod.spellCode;

import com.jasperpuffinv.spellsmod.Main;
import com.jasperpuffinv.util.RC;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ExplodeSpell {
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(ExplodeSpell::explodeSpell);
    }

    public static void explode(World world, Vec3d pos) {
        world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4f, World.ExplosionSourceType.BLOCK);
        Main.LOGGER.info("explode");
    }


    public static void explodeSpell(MinecraftClient client) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && Main.EXPLODE_KEY.isPressed()) {
            World world = player.world;
            world.createExplosion(null, player.getX(), player.getY(), player.getZ(), 4f, World.ExplosionSourceType.BLOCK);
        }
    }
}
