package com.jasperpuffinv.spellsmod.spellCode;

import com.jasperpuffinv.spellsmod.Main;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

import static com.jasperpuffinv.spellsmod.Main.LAUNCH_KEY;

public class LaunchSpell {
    public static boolean isFalling = false;
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(LaunchSpell::launchSpell);
    }

    public static void launch(LivingEntity entities) {
        entities.addVelocity(0, 1, 0);
        Main.LOGGER.info("launch");
    }
    private static void launchSpell(MinecraftClient client) {

        PlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) return;
        if (LAUNCH_KEY.isPressed()) {
            Main.LOGGER.info("key pressed");
            player.addVelocity(0, 1, 0);
        }
    }
}
