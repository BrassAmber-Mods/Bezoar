package milamber.brass.bezoar.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;


public class Bezoar extends Item {


    public Bezoar(Properties properties)
    {
        super(properties);
    }

    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        if (entityIn.isLiving()) {
            LivingEntity livingEntity = (LivingEntity) entityIn;
            if (livingEntity.isPotionActive(Effects.POISON)) {
                livingEntity.removePotionEffect(Effects.POISON);
                stack.damageItem(1, livingEntity, player -> player.playSound(SoundEvents.ENTITY_ITEM_BREAK, 3, 5));
            }
        }
    }

}

