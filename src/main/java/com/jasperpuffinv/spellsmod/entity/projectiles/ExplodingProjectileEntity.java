package com.jasperpuffinv.spellsmod.entity.projectiles;

import com.jasperpuffinv.spellsmod.Main;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class ExplodingProjectileEntity extends ThrownItemEntity {

    public ExplodingProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ExplodingProjectileEntity(World world, LivingEntity owner) {
        super(Main.ExplodingProjectileEntityType, owner, world);
    }

    public ExplodingProjectileEntity(World world, double x, double y, double z) {
        super(Main.ExplodingProjectileEntityType, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return null;
    }

    @Environment(EnvType.CLIENT)
    private ParticleEffect getParticleParameters() { // Not entirely sure, but probably has to do to with the projectiles particles. (OPTIONAL)
        ItemStack itemStack = this.getItem();
        return (ParticleEffect) (itemStack.isEmpty() ? ParticleTypes.FIREWORK : new ItemStackParticleEffect(ParticleTypes.ITEM, itemStack));
    }
    @Environment(EnvType.CLIENT)
    public void handleStatus(byte status) {
        if (status == 3) {
            ParticleEffect particleEffect = this.getParticleParameters();

            for(int i = 0; i < 8; i++) {
                this.world.addParticle(particleEffect, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.kill();
        this.kill();

        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.playSound(SoundEvents.BLOCK_ANVIL_LAND, 10F, 1F);
        }
    }

    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        world.createExplosion(null, this.getX(), this.getY(), this.getZ(), 4f, World.ExplosionSourceType.BLOCK);
        this.kill();
    }

}