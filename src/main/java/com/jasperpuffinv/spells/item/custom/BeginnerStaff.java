package com.jasperpuffinv.spells.item.custom;

import com.jasperpuffinv.spells.Main;
import com.jasperpuffinv.spells.gui.BeginnerGui;
import com.jasperpuffinv.spells.gui.BeginnerScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.input.KeyboardInput;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3d;

import java.awt.event.InputEvent;

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

        Main.LOGGER.info("item oh yeah");
        if (user.isSneaking()) {
            MinecraftClient.getInstance().setScreen(new BeginnerScreen(new BeginnerGui()));
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
