package com.imjustdoom.hostilemobs.entity.entities;

import com.imjustdoom.hostilemobs.entity.EntityTypeInit;
import com.imjustdoom.hostilemobs.item.ItemInit;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ThrownMobBallEntity extends ThrowableItemProjectile {

    public ThrownMobBallEntity(EntityType<? extends ThrownMobBallEntity> p_37473_, Level p_37474_) {
        super(p_37473_, p_37474_);
    }

    public ThrownMobBallEntity(Level p_37481_, LivingEntity p_37482_) {
        super(EntityTypeInit.MOBBALL.get(), p_37482_, p_37481_);
    }

    public ThrownMobBallEntity(Level p_37476_, double p_37477_, double p_37478_, double p_37479_) {
        super(EntityTypeInit.MOBBALL.get(), p_37477_, p_37478_, p_37479_, p_37476_);
    }

    public void handleEntityEvent(byte p_37484_) {
        if (p_37484_ == 3) {
            double d0 = 0.08D;

            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D, ((double)this.random.nextFloat() - 0.5D) * 0.08D);
            }
        }

    }

    protected void onHitEntity(EntityHitResult p_37486_) {
        super.onHitEntity(p_37486_);

        Entity entity = p_37486_.getEntity();

    }

    protected void onHit(HitResult p_37488_) {
        super.onHit(p_37488_);
        if (!this.level.isClientSide) {

            // TODO: make it do something here
            this.getItem().addTagElement();

            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }

    }

    protected Item getDefaultItem() {
        return ItemInit.MOBBALL.get();
    }
}
