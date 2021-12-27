package milamber.brass.bezoar.entity;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.custom.Giant_Hornet;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
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

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

