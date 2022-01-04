package milamber.brass.bezoar;

import milamber.brass.bezoar.item.Custom_Spawn_Egg_Item;
import milamber.brass.bezoar.client.events.ClientEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BezoarMod.MOD_ID)
public class BezoarMod
{
    public static final String MOD_ID = "bezoar";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public BezoarMod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        BezoarEntityTypes.register(eventBus);
        BezoarBlocks.register(eventBus);
        BezoarItems.register(eventBus);

        eventBus.addListener(ClientEvents::registerLayers);
        eventBus.addListener(ClientEvents::registerRenderers);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
        Custom_Spawn_Egg_Item.eggs();
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        LOGGER.debug("Running common setup.");
    }

    // Helper method for resource locations
    public static ResourceLocation locate(String name) {
        return new ResourceLocation(BezoarMod.MOD_ID, name);
    }

}
