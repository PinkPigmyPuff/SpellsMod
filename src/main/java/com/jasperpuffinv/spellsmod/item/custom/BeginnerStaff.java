package com.jasperpuffinv.spellsmod.item.custom;

import com.jasperpuffinv.spellsmod.Main;
import com.jasperpuffinv.spellsmod.gui.BeginnerGui;
import com.jasperpuffinv.spellsmod.gui.BeginnerScreen;
import com.jasperpuffinv.spellsmod.spellCode.ExplodeSpell;
import com.jasperpuffinv.spellsmod.spellCode.LevitateSpell;
import com.jasperpuffinv.spellsmod.spellCode.LaunchSpell;
import com.jasperpuffinv.util.RC;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BeginnerStaff extends Item {
    public BeginnerStaff(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        MinecraftClient client = MinecraftClient.getInstance();
        Main.LOGGER.info("item oh yeah");

        if (user.isSneaking()) {
            MinecraftClient.getInstance().execute(() -> {
                MinecraftClient.getInstance().setScreen(new BeginnerScreen(new BeginnerGui()));
            });
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
                Box area = RC.lookArea(world, user, 100);
                //user.addStatusEffect(ModEffects.GRAV);
                LevitateSpell.levitate(area, 100, 2, user);
            }
        }
        return super.use(world, user, hand);
    }
}
