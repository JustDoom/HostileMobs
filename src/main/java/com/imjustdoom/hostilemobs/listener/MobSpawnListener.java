package com.imjustdoom.hostilemobs.listener;

import com.imjustdoom.hostilemobs.HostileMobs;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HostileMobs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class MobSpawnListener {

    @SubscribeEvent
    public static void modSpawnEvent(EntityJoinLevelEvent event) {
        Entity entity = event.getEntity();
        System.out.println("'" + entity.getPersistentData().getInt("hm2") + "'");
        if (entity.getPersistentData().getInt("hm2") == 0) entity.getPersistentData().putInt("hm2", 1);
        System.out.println("'" + entity.getPersistentData().getInt("hm2") + "'");
    }
}
