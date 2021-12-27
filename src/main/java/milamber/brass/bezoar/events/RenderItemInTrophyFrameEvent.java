package milamber.brass.bezoar.events;

import com.mojang.blaze3d.matrix.MatrixStack;
import milamber.brass.bezoar.client.entity.Trophy_Frame_Renderer;
import milamber.brass.bezoar.entity.item.Trophy_Frame;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nonnull;

/**
 * This event is called when an item is rendered in an item frame.
 *
 * You can set canceled to do no further vanilla processing.
 */
@Cancelable
public class RenderItemInTrophyFrameEvent extends Event
{
    private final ItemStack item;
    private final Trophy_Frame trophyFrame;
    private final Trophy_Frame_Renderer renderer;
    private final MatrixStack matrix;
    private final IRenderTypeBuffer buffers;
    private final int light;

    public RenderItemInTrophyFrameEvent(Trophy_Frame trophyFrame1, Trophy_Frame_Renderer renderTrophyFrame, MatrixStack matrix,
                                        IRenderTypeBuffer buffers, int light)
    {
        item = trophyFrame1.getDisplayedItem();
        trophyFrame = trophyFrame1;
        renderer = renderTrophyFrame;
        this.matrix = matrix;
        this.buffers = buffers;
        this.light = light;
    }

    @Nonnull
    public ItemStack getItem()
    {
        return item;
    }

    public Trophy_Frame getEntityItemFrame()
    {
        return trophyFrame;
    }

    public Trophy_Frame_Renderer getRenderer()
    {
        return renderer;
    }

    public MatrixStack getMatrix() {
        return matrix;
    }

    public IRenderTypeBuffer getBuffers() {
        return buffers;
    }

    public int getLight() {
        return light;
    }
}

