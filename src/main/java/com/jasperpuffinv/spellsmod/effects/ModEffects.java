package com.jasperpuffinv.spellsmod.effects;


import com.jasperpuffinv.spellsmod.Main;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect GRAV;
    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Main.MOD_ID, name),
                new GravStatusEffect(StatusEffectCategory.HARMFUL, 3124687));
    }

    public static void registerEffects() {
        GRAV = registerStatusEffect("grav");
    }
}