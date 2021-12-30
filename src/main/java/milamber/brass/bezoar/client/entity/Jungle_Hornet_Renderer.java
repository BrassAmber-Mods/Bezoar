package milamber.brass.bezoar.client.entity;

import milamber.brass.bezoar.BezoarMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class Jungle_Hornet_Renderer extends Abstract_Hornet_Renderer {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BezoarMod.MOD_ID, "textures/entity/jungle_hornet.png");

    public Jungle_Hornet_Renderer(EntityRendererProvider.Context context) {
        super(context, TEXTURE);
    }
}
