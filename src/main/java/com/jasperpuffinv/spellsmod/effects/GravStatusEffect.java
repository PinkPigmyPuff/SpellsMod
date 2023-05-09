package com.jasperpuffinv.spellsmod.effects;

import com.jasperpuffinv.spellsmod.Main;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

import java.util.logging.Logger;

public class GravStatusEffect extends StatusEffect {
    double grav = 0.08;
    double CounterGrav = grav * 2;

    public GravStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int level) {
        entity.addVelocity(0, CounterGrav, 0);


    }
//    @SubscribeEvent
//    public void doTick(LivingUpdateEvent event)
//    {
//        if (!event.entityLiving.isAirBorne) return; //Important, this should fix jumping problems
//        if (event.entityLiving.motionY < 0)
//        {
//            event.entityLiving.motionY *= 0.96D;
//        }else
//        {
//
//            event.entityLiving.motionY += 0.041D;
//        }
    @Override
    public boolean canApplyUpdateEffect(int pDuration, int pAmplifier) {
        return true;
    }
}