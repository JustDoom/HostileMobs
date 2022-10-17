package com.imjustdoom.hostilemobs.entity;

import com.imjustdoom.hostilemobs.HostileMobs;
import com.imjustdoom.hostilemobs.entity.entities.ThrownMobBallEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityTypeInit {

    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HostileMobs.MOD_ID);

    public static void init(){
        ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<EntityType<ThrownMobBallEntity>> MOBBALL = ENTITY_TYPES.register("mobball", () ->
            EntityType.Builder.<ThrownMobBallEntity>of(ThrownMobBallEntity::new, MobCategory.MISC).sized(0.25F, 0.25F)
                    .build(new ResourceLocation(HostileMobs.MOD_ID, "mobball").toString()));

//    public static final RegistryObject<EntityType<MudBallEntity>> MUD_BALL_ENTITY = ENTITY_TYPES.register("mud_ball",
//            () -> EntityType.Builder.<MudBallEntity> of(MudBallEntity::new, MobCategory.MISC).sized(0.25f, 0.25f)
//            .build(new ResourceLocation(ImmersiveWeapons.MOD_ID, "mud_ball").toString()));
}