package com.jasperpuffinv.spells.item.custom;

import com.jasperpuffinv.effects.GravStatusEffect;
import com.jasperpuffinv.effects.ModEffects;
import com.jasperpuffinv.spells.Main;
import com.jasperpuffinv.spells.gui.BeginnerGui;
import com.jasperpuffinv.spells.gui.BeginnerScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3d;

import java.awt.event.InputEvent;
import java.util.Iterator;
import java.util.List;

public class BeginnerStaff extends Item {
    public BeginnerStaff(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        // Raycast a line from the player, and store the HitData
        HitResult hit = user.raycast(300, 1, true);
        // get the coordinate position of the HitData
        Vec3d pos = hit.getPos();
        Main.LOGGER.info(pos.toString());
        Box box = Box.from(pos);
        box.expand(100);
        Main.LOGGER.info(box.toString());
        List effectedList  = world.getOtherEntities(user, box);

        Main.LOGGER.info(effectedList.toString());
        if (user.isSneaking()) {
            MinecraftClient.getInstance().setScreen(new BeginnerScreen(new BeginnerGui()));
        } else {
            if (BeginnerGui.isExplode) {
                world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4f, World.ExplosionSourceType.BLOCK);
                Main.LOGGER.info("explode");
                user.getItemCooldownManager().set(this, 20);
            } else if (BeginnerGui.isLaunch) {
                user.addVelocity(0, 1, 0);
                Main.LOGGER.info("launch");
                user.getItemCooldownManager().set(this, 20);
            } else if (BeginnerGui.isGrav) {

                for (int i = 0; i < effectedList.size(); i++) {
                    //LivingEntity ent = effectedList.get(i);
                    //ent.addVelocity(0, .08, 0);
                    Main.LOGGER.info("Adding grav to: ");
                    Main.LOGGER.info(effectedList.get(i).toString());
                }
                //g = GravStatusEffect("GRAV")
                //user.addStatusEffect(ModEffects.GRAV);
                user.addStatusEffect(new StatusEffectInstance(ModEffects.GRAV, 200, 2));
            }
        }
        return super.use(world, user, hand);
    }
}
