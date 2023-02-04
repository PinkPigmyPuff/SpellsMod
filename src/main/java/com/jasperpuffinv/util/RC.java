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
        // Raycast a line from the player, and store the HitData
        HitResult hit = user.raycast(300, 1, true);
        // get the coordinate position of the HitData
        Vec3d pos = hit.getPos();
        Main.LOGGER.info(pos.toString());
        return pos;
    }

    public static List effectedList(World world, PlayerEntity user, int boxSize){
        Box box = Box.from(lookLocation(world, user));
        box.expand(boxSize);
        Main.LOGGER.info(box.toString());
        List effectedList  = world.getOtherEntities(user, box);
        Main.LOGGER.info(effectedList.toString());
        return effectedList;
    }
}
