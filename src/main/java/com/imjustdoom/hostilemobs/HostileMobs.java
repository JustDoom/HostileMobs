package com.imjustdoom.hostilemobs;

import com.imjustdoom.hostilemobs.entity.EntityTypeInit;
import com.imjustdoom.hostilemobs.item.ItemInit;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("hostilemobs")
public class HostileMobs {

    public static final String MOD_ID = "hostilemobs";

    public HostileMobs() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);
        eventBus.addListener(this::entityRenderers);

        ItemInit.init();
        EntityTypeInit.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypeInit.MOBBALL.get(), ThrownItemRenderer::new);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final CreativeModeTab HostileMobsTab = new CreativeModeTab("hostilemobstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ItemInit.MOBBALL.get());
        }
    };
}
