package com.jasperpuffinv.spells.mixins;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Overwrite()
}
