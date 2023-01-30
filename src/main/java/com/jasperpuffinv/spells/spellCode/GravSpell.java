package com.jasperpuffinv.spells.spellCode;

import com.jasperpuffinv.spells.Main;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import static com.jasperpuffinv.spells.Main.GRAV_KEY;
import static com.jasperpuffinv.spells.Main.LOGGER;

public class GravSpell {



    private void launchSpell(World world, MinecraftClient client, PlayerEntity player) {

        boolean initialGravity = false;
        if (player == null) return;
        if (GRAV_KEY.isPressed()) {

            LOGGER.info("grav");
            //Outdated API rip ((RotatableEntityAccessor) player).gravitychanger$setGravityDirection(Direction.UP,false);
        }
    }
}
