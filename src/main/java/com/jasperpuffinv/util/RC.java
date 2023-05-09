package com.jasperpuffinv.util;

import com.google.common.eventbus.Subscribe;
import com.jasperpuffinv.spellsmod.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class RC {
    @Subscribe
    public static Vec3d lookLocation(World world, PlayerEntity user) {
        // Ray cast a line from the player, and store the HitData
        HitResult hit = user.raycast(300, 1, true);
        // get the coordinate position of the HitData
        Vec3d pos = hit.getPos();
        Main.LOGGER.info(pos.toString());
        return pos;
    }

    public static Box lookArea(World world, PlayerEntity user, int boxSize){
        Main.LOGGER.info("In lookArea");
        Box box = Box.from(lookLocation(world, user));
        Main.LOGGER.info("Created Box");
        box.expand(boxSize);
        Main.LOGGER.info("Exp[anded box");
        Main.LOGGER.info(box.toString());
        return box;
    }
}
