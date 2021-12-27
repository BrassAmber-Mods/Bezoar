package milamber.brass.bezoar.client.entity;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.custom.Giant_Hornet;
import milamber.brass.bezoar.entity.custom.Giant_Hornet_Model;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class Honey_Hornet_Renderer extends MobRenderer<Giant_Hornet, Giant_Hornet_Model<Giant_Hornet>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BezoarMod.MOD_ID, "textures/entity/honey_hornet.png");

    public Honey_Hornet_Renderer(EntityRendererManager manager) {
        super(manager, new Giant_Hornet_Model<>(), .7f);
    }

    @Override
    public ResourceLocation getEntityTexture(Giant_Hornet entity) {
        return TEXTURE;
    }
}
