package milamber.brass.bezoar.entity;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.custom.Giant_Hornet;
import milamber.brass.bezoar.entity.custom.Stinger_Entity;
import milamber.brass.bezoar.entity.item.Trophy_Frame;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.HangingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, BezoarMod.MOD_ID);

    public static final RegistryObject<EntityType<Giant_Hornet>> JUNGLE_HORNET
            = ENTITY_TYPES.register("jungle_hornet", () -> EntityType.Builder.create(Giant_Hornet::new,
            EntityClassification.MONSTER).size(1.0f, 2.0f).build(new ResourceLocation(BezoarMod.MOD_ID,
            "jungle_hornet").toString()));

    public static final RegistryObject<EntityType<Stinger_Entity>> STINGER_ENTITY
            = ENTITY_TYPES.register("stinger_entity", () -> EntityType.Builder.<Stinger_Entity>create(Stinger_Entity::new,
            EntityClassification.MISC).size(.5f, .5f).trackingRange(4).updateInterval(20).build(new ResourceLocation(BezoarMod.MOD_ID,
            "stinger").toString()));

    public static final RegistryObject<EntityType<? extends HangingEntity>> TROPHY_FRAME
            = ENTITY_TYPES.register("trophy", () -> EntityType.Builder.<Trophy_Frame>create(Trophy_Frame::new,
            EntityClassification.MISC).size(1.0f, 2.0f).build(new ResourceLocation((BezoarMod.MOD_ID), "trophy").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

