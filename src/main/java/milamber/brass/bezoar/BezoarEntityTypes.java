package milamber.brass.bezoar;

import milamber.brass.bezoar.entity.mobs.AbstractGiantHornetEntity;
import milamber.brass.bezoar.entity.mobs.*;
import milamber.brass.bezoar.entity.projectiles.Stinger;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BezoarEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, Bezoar.MOD_ID);

    public static final RegistryObject<EntityType<AbstractGiantHornetEntity>> HONEY_HORNET
            = registerEntityType("honey_hornet", EntityType.Builder.<AbstractGiantHornetEntity>of(AbstractGiantHornetEntity::new,
            MobCategory.MONSTER).sized(1.0f, 2.0f));

    public static final RegistryObject<EntityType<MossyHornetEntity>> MOSSY_HORNET
            = registerEntityType("mossy_hornet", EntityType.Builder.<MossyHornetEntity>of(MossyHornetEntity::new,
            MobCategory.MONSTER).sized(1.0f, 2.0f));

    public static final RegistryObject<EntityType<SpikeyHornetEntity>> SPIKEY_HORNET
            = registerEntityType("spikey_hornet", EntityType.Builder.<SpikeyHornetEntity>of(SpikeyHornetEntity::new,
            MobCategory.MONSTER).sized(1.0f, 2.0f));

    public static final RegistryObject<EntityType<FloralHornetEntity>> FLORAL_HORNET
            = registerEntityType("floral_hornet", EntityType.Builder.<FloralHornetEntity>of(FloralHornetEntity::new,
            MobCategory.MONSTER).sized(1.0f, 2.0f));

    public static final RegistryObject<EntityType<GiantTortoiseEntity>> GIANT_TORTOISE
            = registerEntityType("giant_tortoise", EntityType.Builder.<GiantTortoiseEntity>of(GiantTortoiseEntity::new,
            MobCategory.CREATURE).sized(2.4F, 1.2F));

    public static final RegistryObject<EntityType<Stinger>> STINGER
            = registerEntityType("stinger", EntityType.Builder.<Stinger>of(Stinger::new,
            MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20));

    /**
     * Helper method for registering EntityTypes
     */
    private static <T extends Entity> RegistryObject<EntityType<T>> registerEntityType(String registryName, EntityType.Builder<T> builder) {
        return ENTITY_TYPES.register(registryName, () -> builder.build(registryName));
    }

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

