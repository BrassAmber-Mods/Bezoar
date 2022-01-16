package milamber.brass.bezoar.util;

import milamber.brass.bezoar.Bezoar;
import milamber.brass.bezoar.BezoarItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum BezoarArmorMaterials implements ArmorMaterial {
    TORTOISE("tortoise", 74, new int[]{5, 8, 10, 5}, 30,
            SoundEvents.ARMOR_EQUIP_TURTLE, 3.0F, 0.2F,
            () -> {return Ingredient.of(BezoarItems.TORTOISE_PLATE);}
    );

    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    BezoarArmorMaterials(String name, int durabilityMultiplier, int[] slotProtections, int enchantValue,
                         SoundEvent soundEvent, float toughness, float knockbackResist, Supplier<Ingredient> ingredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantValue;
        this.sound = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResist;
        this.repairIngredient = new LazyLoadedValue<>(ingredientSupplier);
    }

    public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
        return HEALTH_PER_SLOT[equipmentSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
        return this.slotProtections[equipmentSlot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return Bezoar.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
