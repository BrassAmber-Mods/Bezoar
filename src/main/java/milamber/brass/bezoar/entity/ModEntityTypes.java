package milamber.brass.bezoar.entity;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.custom.Giant_Hornet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, BezoarMod.MOD_ID);

    public static final RegistryObject<EntityType<Giant_Hornet>> JUNGLE_HORNET
            = ENTITY_TYPES.register("jungle_hornet", () -> EntityType.Builder.of(Giant_Hornet::new,
            MobCategory.MONSTER).sized(1.0f, 2.0f).build(new ResourceLocation(BezoarMod.MOD_ID,
            "jungle_hornet").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

