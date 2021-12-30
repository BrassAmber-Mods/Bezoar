package milamber.brass.bezoar.client.entity;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.custom.Giant_Hornet;
import milamber.brass.bezoar.entity.custom.Giant_Hornet_Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import javax.naming.Context;


public class Abstract_Hornet_Renderer<Type extends Giant_Hornet> extends MobRenderer<Type, Giant_Hornet_Model<Type>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BezoarMod.MOD_ID, "textures/entity/jungle_hornet.png");

    public Abstract_Hornet_Renderer(EntityRendererProvider.Context context, ResourceLocation location) {
        super(context,
                new Giant_Hornet_Model<>(
                        context.bakeLayer(new ModelLayerLocation((location == null) ? TEXTURE : location, "main")),
                        new ModelLayerLocation((location == null) ? TEXTURE : location, "main")
                ),
                .7f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type p_114482_) {
        return TEXTURE;
    }
}
