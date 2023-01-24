package com.jasperpuffinv.spells;

import com.jasperpuffinv.spells.spellCode.LaunchSpell;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Spells implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("spells");

    public static final String MOD_ID = "spells";

    public static KeyBinding LAUNCH_KEY;
    public static KeyBinding EXPLODE_KEY;

    @Override
    public void onInitialize() {
        LOGGER.info("mod loaed");

        //Keybinds
        LAUNCH_KEY = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.spells.launch", GLFW.GLFW_KEY_H, "key.categories.spells"));
        EXPLODE_KEY = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.spells.explode", GLFW.GLFW_KEY_K,"key.categories.spells"));

        // Launch Spell
        LaunchSpell.init();
    }
}
