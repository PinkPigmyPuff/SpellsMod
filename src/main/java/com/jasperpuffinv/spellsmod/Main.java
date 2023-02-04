package com.jasperpuffinv.spellsmod;

import com.jasperpuffinv.spellsmod.effects.ModEffects;
import com.jasperpuffinv.spellsmod.entity.projectiles.ExplodingProjectileEntity;
import com.jasperpuffinv.spellsmod.item.ModItemGroup;
import com.jasperpuffinv.spellsmod.item.ModItems;
import com.jasperpuffinv.spellsmod.spellCode.ExplodeSpell;
import com.jasperpuffinv.spellsmod.spellCode.LaunchSpell;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("spells");

    public static final String MOD_ID = "spells";

    public static KeyBinding LAUNCH_KEY;
    public static KeyBinding EXPLODE_KEY;
    public static KeyBinding GRAV_KEY;

    //Entity Registration
    public static final EntityType<ExplodingProjectileEntity> ExplodingProjectileEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "death"),
            FabricEntityTypeBuilder.<ExplodingProjectileEntity>create(SpawnGroup.MISC, ExplodingProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F,0.25F))
                    .trackRangeBlocks(4).trackedUpdateRate(10)
                    .build()
    );

    @Override
    public void onInitialize() {
        LOGGER.info("mod loaed");

        ModItemGroup.registerItemGroup();

        ModItems.registerModItems();

        ModEffects.registerEffects();
        //Keybinds
        LAUNCH_KEY = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.spells.launch", GLFW.GLFW_KEY_H, "key.categories.spells"));
        EXPLODE_KEY = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.spells.explode", GLFW.GLFW_KEY_K,"key.categories.spells"));
        GRAV_KEY = KeyBindingHelper.registerKeyBinding(
                new KeyBinding("key.spells.grav",GLFW.GLFW_KEY_J,"key.categories.spells"));

        // Launch Spell
        LaunchSpell.init();

        //Explode Spell
        ExplodeSpell.init();
    }
}
