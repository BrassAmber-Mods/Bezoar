package milamber.brass.bezoar.item;

import milamber.brass.bezoar.entity.projectiles.Stinger;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StingerItem extends Item {

    public StingerItem(Properties p_41383_) {
        super(p_41383_);
    }

    public Stinger createArrow(Level level, LivingEntity livingEntity) {
        Stinger stinger = new Stinger(level, livingEntity);
        return stinger;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.world.entity.player.Player player) {
        return false;
    }

}
