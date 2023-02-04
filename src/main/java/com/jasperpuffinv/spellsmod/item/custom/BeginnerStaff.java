package com.jasperpuffinv.spellsmod.item.custom;

import com.jasperpuffinv.spellsmod.Main;
import com.jasperpuffinv.spellsmod.effects.ModEffects;
import com.jasperpuffinv.spellsmod.entity.projectiles.ExplodingProjectileEntity;
import com.jasperpuffinv.spellsmod.gui.BeginnerGui;
import com.jasperpuffinv.spellsmod.gui.BeginnerScreen;
import com.jasperpuffinv.spellsmod.spellCode.ExplodeSpell;
import com.jasperpuffinv.spellsmod.spellCode.GravSpell;
import com.jasperpuffinv.spellsmod.spellCode.LaunchSpell;
import com.jasperpuffinv.spellsmod.util.Raycast;
import com.jasperpuffinv.util.RC;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class BeginnerStaff extends Item {
    public BeginnerStaff(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MinecraftClient client = MinecraftClient.getInstance();
        Main.LOGGER.info("item oh yeah");

        if (user.isSneaking()) {
            MinecraftClient.getInstance().setScreen(new BeginnerScreen(new BeginnerGui()));
            /*
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_SHOOT, SoundCategory.NEUTRAL, 0.5F, 1F);
            user.getItemCooldownManager().set(this, 10);
            ExplodingProjectileEntity explodeEntity = new ExplodingProjectileEntity(world, user);
            explodeEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(explodeEntity);
             */

        } else {
            if (BeginnerGui.isExplode) {
                Vec3d pos = RC.lookLocation(world, user);
                ExplodeSpell.explode(world, pos);
                user.getItemCooldownManager().set(this, 20);

            } else if (BeginnerGui.isLaunch) {
                LaunchSpell.launch(user);
                user.getItemCooldownManager().set(this, 20);
            }

            else if (BeginnerGui.isGrav) {
                List effected = RC.effectedList(world, user, 100);
                /* Doesn't work for some reason
                for (int i = 0; i < effected.size(); i++) {
                    //LivingEntity ent = effectedList.get(i);
                    //ent.addVelocity(0, .08, 0);
                    Main.LOGGER.info("Adding grav to: ");
                    Main.LOGGER.info(effected.get(i).toString());
                }
                */
                //g = GravStatusEffect("GRAV")
                //user.addStatusEffect(ModEffects.GRAV);
                GravSpell.levitate(user, 100, 2);
            }
        }
        return super.use(world, user, hand);
    }
}
