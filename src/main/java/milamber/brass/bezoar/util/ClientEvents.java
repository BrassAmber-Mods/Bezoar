package milamber.brass.bezoar.util;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.client.entity.Abstract_Hornet_Renderer;
import milamber.brass.bezoar.client.entity.Jungle_Hornet_Renderer;
import milamber.brass.bezoar.entity.ModEntityTypes;
import milamber.brass.bezoar.entity.custom.Giant_Hornet_Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BezoarMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvents {

    private ClientEvents() {}

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityTypes.JUNGLE_HORNET.get(), Jungle_Hornet_Renderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(new ModelLayerLocation(Abstract_Hornet_Renderer.TEXTURE, "main"), Giant_Hornet_Model::createBodyLayer);
    }


}
