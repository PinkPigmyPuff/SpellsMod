package com.jasperpuffinv.effects;

import com.jasperpuffinv.spells.Main;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

public class GravStatusEffect extends StatusEffect {
    public GravStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int level) {
        if (!entity.world.isClient && !entity.isOnGround()) {
            entity.move(MovementType.SELF, new Vec3d(0, 1, 0));
            entity.velocityModified = true;
            Main.LOGGER.info("sdfjls");
        }
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