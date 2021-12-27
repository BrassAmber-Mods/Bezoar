package milamber.brass.bezoar.util;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.client.entity.Chorus_Hornet_Renderer;
import milamber.brass.bezoar.client.entity.Jungle_Hornet_Renderer;
import milamber.brass.bezoar.entity.ModEntityTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = BezoarMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.JUNGLE_HORNET.get(), Jungle_Hornet_Renderer::new);

    }

}
