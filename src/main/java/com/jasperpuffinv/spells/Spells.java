package com.jasperpuffinv.spells;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Spells implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("spells");

    public static final String MOD_ID = "spells";

    public static KeyBinding LAUNCH_KEY;

    @Override
    public void onInitialize() {
        LOGGER.info("mod loaed");
        // Register the keybinding
        LAUNCH_KEY = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.mymod.launch", GLFW.GLFW_KEY_H, "key.categories.mymod"));
        // Register the tick event handler
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (LAUNCH_KEY.isPressed()) {
                LOGGER.info("key pressed");
                PlayerEntity player = MinecraftClient.getInstance().player;
                player.fallDistance = 0;
                player.addVelocity(0, 4, 0);
            }
        });
    }
}
