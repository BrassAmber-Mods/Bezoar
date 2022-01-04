package milamber.brass.bezoar.client.render;

import milamber.brass.bezoar.BezoarMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class JungleHornetRenderer extends AbstractHornetRenderer {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BezoarMod.MOD_ID, "textures/entity/jungle_hornet.png");

    public JungleHornetRenderer(EntityRendererProvider.Context context) {
        super(context, TEXTURE);
    }
}
