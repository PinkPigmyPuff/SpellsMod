package com.jasperpuffinv.spellsmod.item.custom;

import com.jasperpuffinv.spellsmod.Main;
import com.jasperpuffinv.spellsmod.entity.projectiles.ExplodingProjectileEntity;
import com.jasperpuffinv.spellsmod.gui.BeginnerGui;
import com.jasperpuffinv.spellsmod.gui.BeginnerScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BeginnerStaff extends Item {
    public BeginnerStaff(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        Main.LOGGER.info("item oh yeah");
        if (user.isSneaking()) {
            //MinecraftClient.getInstance().setScreen(new BeginnerScreen(new BeginnerGui())); temp i am testing projectile heehee
            world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_SHOOT, SoundCategory.NEUTRAL, 0.5F, 1F);
            user.getItemCooldownManager().set(this, 10);
            ExplodingProjectileEntity explodeEntity = new ExplodingProjectileEntity(world, user);
            explodeEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(explodeEntity);

        } else {
            if (BeginnerGui.isExplode) {
                world.createExplosion(null, user.getX(), user.getY(), user.getZ(), 4f, World.ExplosionSourceType.BLOCK);
                Main.LOGGER.info("explode");
                user.getItemCooldownManager().set(this, 20);
            } else if (BeginnerGui.isLaunch) {
                user.addVelocity(0, 1, 0);
                Main.LOGGER.info("launch");
                user.getItemCooldownManager().set(this, 20);
            }
        }
        return super.use(world, user, hand);
    }
}
