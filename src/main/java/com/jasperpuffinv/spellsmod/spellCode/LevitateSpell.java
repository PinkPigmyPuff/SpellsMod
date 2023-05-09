package com.jasperpuffinv.spellsmod.spellCode;

import com.jasperpuffinv.spellsmod.Main;
import com.jasperpuffinv.spellsmod.effects.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;

import static java.lang.Thread.sleep;
import static net.minecraft.client.render.debug.DebugRenderer.drawBox;

public class LevitateSpell {

    public static void levitate(Box effectedArea, int dur, int amp, LivingEntity user) {
        drawBox(effectedArea, 100f, 100f, 100f, 100f);
        Main.LOGGER.info("Drawing Box");
        World world = user.world;
        List effectedList  = world.getOtherEntities(user, effectedArea);
        Main.LOGGER.info("Effected List: " + effectedList.toString());

        Iterator<Object> it = effectedList.iterator();
        while(it.hasNext()) {
            LivingEntity current = (LivingEntity) it.next();
            Main.LOGGER.info("Current: " + current.toString());
            current.addStatusEffect(new StatusEffectInstance(ModEffects.GRAV, dur, amp));

        }
        /*
        for (int i = 0; i <= effectedList.size(); i++) {
            //effectedList.get(i).addStatusEffect(new StatusEffectInstance(ModEffects.GRAV, dur, amp));

            Object current = effectedList.get(i);
            //LivingEntity ent = current.
        }
        */
    }

}
