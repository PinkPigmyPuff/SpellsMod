package com.jasperpuffinv.spells.item.custom;

import com.jasperpuffinv.spells.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
        user.jump();
        user.getItemCooldownManager().set(this,20);
        return super.use(world, user, hand);
    }
}
