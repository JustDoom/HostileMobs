package com.imjustdoom.hostilemobs.item.items;

import com.imjustdoom.hostilemobs.HostileMobs;
import com.imjustdoom.hostilemobs.entity.entities.ThrownMobBallEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MobBallItem extends Item {

    public MobBallItem() {
        super(new Item.Properties()
                .tab(HostileMobs.HostileMobsTab)
        );
    }

    public InteractionResultHolder<ItemStack> use(Level p_41128_, Player p_41129_, InteractionHand p_41130_) {
        ItemStack itemstack = p_41129_.getItemInHand(p_41130_);
        p_41128_.playSound((Player)null, p_41129_.getX(), p_41129_.getY(), p_41129_.getZ(), SoundEvents.SPLASH_POTION_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (p_41128_.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!p_41128_.isClientSide) {
            ThrownMobBallEntity thrownegg = new ThrownMobBallEntity(p_41128_, p_41129_);
            thrownegg.setItem(itemstack);
            thrownegg.shootFromRotation(p_41129_, p_41129_.getXRot(), p_41129_.getYRot(), 0.0F, 1.5F, 1.0F);
            p_41128_.addFreshEntity(thrownegg);
        }

        p_41129_.awardStat(Stats.ITEM_USED.get(this));
        if (!p_41129_.getAbilities().instabuild) {
            itemstack.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemstack, p_41128_.isClientSide());
    }

    public void setMob(Entity entity) {
        this.getShareTag()
    }
}
