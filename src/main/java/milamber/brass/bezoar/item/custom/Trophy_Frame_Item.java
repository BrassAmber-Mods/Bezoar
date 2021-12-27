package milamber.brass.bezoar.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HangingEntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Trophy_Frame_Item extends HangingEntityItem {

    public Trophy_Frame_Item(Item.Properties builder) {
        super(EntityType.ITEM_FRAME, builder);
    }

    protected boolean canPlace(PlayerEntity playerIn, Direction directionIn, ItemStack itemStackIn, BlockPos posIn) {
        return !World.isOutsideBuildHeight(posIn) && playerIn.canPlayerEdit(posIn, directionIn, itemStackIn);
    }
}
