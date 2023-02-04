package com.jasperpuffinv.spellsmod.potion;

import com.jasperpuffinv.spellsmod.effects.ModEffects;
import com.jasperpuffinv.spellsmod.Main;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static Potion REVERSE_GRAVITY;

    public static Potion registerPotion(String name) {
        return Registry.register(Registries.POTION, new Identifier(Main.MOD_ID, name),
                new Potion(new StatusEffectInstance(ModEffects.GRAV, 200, 0)));
    }
}
