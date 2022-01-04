package milamber.brass.bezoar.item.equipment;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Properties;


public class Bezoar extends Item {


    public Bezoar(Properties properties)
    {
        super(properties);
    }

    public void inventoryTick(ItemStack stack, Level worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
        if (entityIn.isAlive()) {
            LivingEntity livingEntity = (LivingEntity) entityIn;
            if (livingEntity.hasEffect(MobEffects.POISON)) {
                livingEntity.removeEffect(MobEffects.POISON);
                stack.hurtAndBreak(1, livingEntity, player -> player.playSound(SoundEvents.ITEM_BREAK, 3, 5));
            }
        }
    }

}

