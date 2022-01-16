package milamber.brass.bezoar.item.equipment;

import com.google.common.collect.ImmutableMap;
import milamber.brass.bezoar.util.BezoarArmorMaterials;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.Map;


public class BezoarArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffect> MATERIAL_TO_AFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffect>())
                    .put(BezoarArmorMaterials.TORTOISE, MobEffects.MOVEMENT_SLOWDOWN).build();

    public BezoarArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public int getItemEnchantability(ItemStack stack) {
        return super.getItemEnchantability(stack);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        ListTag tags = stack.getEnchantmentTags();
        Map<Enchantment, Integer> map = EnchantmentHelper.deserializeEnchantments(tags);
        if (map.size() == 1 && map.containsKey(Enchantments.THORNS)) {
            return false;
        }
        return super.isFoil(stack);
    }

    public void inventoryTick(net.minecraft.world.item.ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
        if (stack.getEnchantmentTags().isEmpty()) {
            stack.enchant(Enchantments.THORNS, 1);
        }
        if(!world.isClientSide())
            if(entity instanceof Player) {
                Player player = (Player)entity;
                evaluateArmorEffects(player);

            }
    }

    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffect> entry : MATERIAL_TO_AFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffect mapStatusEffect = entry.getValue();

            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }

        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial, MobEffect mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect);

        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect)   {
            player.addEffect(new MobEffectInstance(mapStatusEffect, 1,1));
        }
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
        NonNullList<ItemStack> armor = player.getInventory().armor;
        ArmorItem armorItem = null;
        for (ItemStack item : armor
            ) {
            try {
                 armorItem = (ArmorItem) item.getItem();
            }
            catch (Exception e) {
            }
        }
        if (armorItem != null) {
            return armorItem.getMaterial() == material;
        }
        else {
            return false;
        }
    }


}

