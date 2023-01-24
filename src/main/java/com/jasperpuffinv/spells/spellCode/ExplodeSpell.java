package com.jasperpuffinv.spells.spellCode;

import com.jasperpuffinv.spells.Spells;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplodeSpell {
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(ExplodeSpell::explodeSpell);
    }

    public static void explodeSpell(MinecraftClient client) {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player != null && Spells.EXPLODE_KEY.isPressed()) {
            World world = player.world;
            world.createExplosion(null, player.getX(), player.getY(), player.getZ(), 4f, Explosion.DestructionType.BREAK);
            //unfortunately only client-side atm, no real damage done
            }
    }
}
