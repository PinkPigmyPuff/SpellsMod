package com.jasperpuffinv.spellsmod.spellCode;

import com.jasperpuffinv.spellsmod.effects.ModEffects;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

import static com.jasperpuffinv.spellsmod.Main.GRAV_KEY;
import static com.jasperpuffinv.spellsmod.Main.LOGGER;

public class GravSpell {

    public static void levitate(LivingEntity entities, int dur, int amp) {
        entities.addStatusEffect(new StatusEffectInstance(ModEffects.GRAV, dur, amp));
    }
}
