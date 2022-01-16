package milamber.brass.bezoar;

import milamber.brass.bezoar.item.StingerItem;
import milamber.brass.bezoar.item.equipment.BezoarArmorItem;

import milamber.brass.bezoar.item.equipment.BezoarItem;
import milamber.brass.bezoar.item.placeable.Allium_Chlorophytus;
import milamber.brass.bezoar.item.placeable.Allium_Majora;
import milamber.brass.bezoar.item.placeable.Chorus_Majora;
import milamber.brass.bezoar.item.placeable.Wither_Majora;
import milamber.brass.bezoar.util.BezoarArmorMaterials;
import milamber.brass.bezoar.util.BezoarTiers;
import milamber.brass.bezoar.util.BezoarCreativeModeTabs;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class BezoarItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Bezoar.MOD_ID);

    public static final Item BEZOAR = registerItem("bezoar",
            new BezoarItem(new Item.Properties().stacksTo(1).setNoRepair().rarity(Rarity.EPIC).tab(BezoarCreativeModeTabs.BEZOAR_GROUP).defaultDurability(16)));

    public static final Item TORTOISE_PLATE = registerItem("tortoise_plate",
            new Item(new Item.Properties().stacksTo(16).tab(CreativeModeTab.TAB_MATERIALS)));

    public static final Item TORTOISE_HELMET = registerItem("tortoise_helmet",
            new BezoarArmorItem(BezoarArmorMaterials.TORTOISE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).rarity(Rarity.EPIC)));

    public static final Item TORTOISE_CHESTPLATE = registerItem("tortoise_chestplate",
            new BezoarArmorItem(BezoarArmorMaterials.TORTOISE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).rarity(Rarity.EPIC)));

    public static final Item TORTOISE_LEGGINGS = registerItem("tortoise_leggings",
            new BezoarArmorItem(BezoarArmorMaterials.TORTOISE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).rarity(Rarity.EPIC)));

    public static final Item TORTOISE_BOOTS = registerItem("tortoise_boots",
            new BezoarArmorItem(BezoarArmorMaterials.TORTOISE, EquipmentSlot.FEET,
                    new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).rarity(Rarity.EPIC)));

    public static final Item TORTOISE_SWORD = registerItem("tortoise_sword",
            new SwordItem(BezoarTiers.TORTOISE, 4, -2.6F,
                    new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).rarity(Rarity.EPIC)) {
                @Override
                public boolean isFoil(@NotNull ItemStack stack) {
                    ListTag tags = stack.getEnchantmentTags();
                    Map<Enchantment, Integer> map = EnchantmentHelper.deserializeEnchantments(tags);
                    if (map.size() == 1 && map.containsKey(Enchantments.KNOCKBACK)) {
                        return false;
                    }
                    return super.isFoil(stack);
                }

                @Override
                public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int i, boolean t) {
                    if (stack.getEnchantmentTags().isEmpty()) {
                        stack.enchant(Enchantments.KNOCKBACK, 1);
                    }
                }
            });

    public static final Item TORTOISE_PICKAXE = registerItem("tortoise_pickaxe",
            new PickaxeItem(BezoarTiers.TORTOISE, 2, -3.2F,
                new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).rarity(Rarity.EPIC)) {
                @Override
                public boolean isFoil(@NotNull ItemStack stack) {
                    ListTag tags = stack.getEnchantmentTags();
                    Map<Enchantment, Integer> map = EnchantmentHelper.deserializeEnchantments(tags);
                    if (map.size() == 1 && map.containsKey(Enchantments.KNOCKBACK)) {
                        return false;
                    }
                    return super.isFoil(stack);
                }

                @Override
                public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int i, boolean t) {
                    if (stack.getEnchantmentTags().isEmpty()) {
                        stack.enchant(Enchantments.KNOCKBACK, 1);
                    }
                }
            });

    public static final Item TORTOISE_AXE = registerItem("tortoise_axe",
            new AxeItem(BezoarTiers.TORTOISE, 6.0F, -3.2F,
                new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).rarity(Rarity.EPIC)) {
                @Override
                public boolean isFoil(@NotNull ItemStack stack) {
                    ListTag tags = stack.getEnchantmentTags();
                    Map<Enchantment, Integer> map = EnchantmentHelper.deserializeEnchantments(tags);
                    if (map.size() == 1 && map.containsKey(Enchantments.KNOCKBACK)) {
                        return false;
                    }
                    return super.isFoil(stack);
                }

                @Override
                public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int i, boolean t) {
                    if (stack.getEnchantmentTags().isEmpty()) {
                        stack.enchant(Enchantments.KNOCKBACK, 1);
                    }
                }
            });

    public static final Item TORTOISE_SHOVEL = registerItem("tortoise_shovel",
            new ShovelItem(BezoarTiers.TORTOISE, 3.0F, -3.2F,
                new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).rarity(Rarity.EPIC)) {
                @Override
                public boolean isFoil(@NotNull ItemStack stack) {
                    ListTag tags = stack.getEnchantmentTags();
                    Map<Enchantment, Integer> map = EnchantmentHelper.deserializeEnchantments(tags);
                    if (map.size() == 1 && map.containsKey(Enchantments.KNOCKBACK)) {
                        return false;
                    }
                    return super.isFoil(stack);
                }

                @Override
                public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int i, boolean t) {
                    if (stack.getEnchantmentTags().isEmpty()) {
                        stack.enchant(Enchantments.KNOCKBACK, 1);
                    }
                }
            });

    public static final Item TORTOISE_SCYTHE = registerItem("tortoise_scythe",
            new HoeItem(BezoarTiers.TORTOISE, 1, -0.2F,
                new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).rarity(Rarity.EPIC)) {
                @Override
                public boolean isFoil(@NotNull ItemStack stack) {
                    ListTag tags = stack.getEnchantmentTags();
                    Map<Enchantment, Integer> map = EnchantmentHelper.deserializeEnchantments(tags);
                    if (map.size() == 1 && map.containsKey(Enchantments.KNOCKBACK)) {
                        return false;
                    }
                    return super.isFoil(stack);
                }

                @Override
                public void inventoryTick(@NotNull ItemStack stack, @NotNull Level level, @NotNull Entity entity, int i, boolean t) {
                    if (stack.getEnchantmentTags().isEmpty()) {
                        stack.enchant(Enchantments.KNOCKBACK, 1);
                    }
                }
            });


    public static final Item STINGER_ITEM = registerItem("stinger_item",
            new StingerItem(new Item.Properties().stacksTo(16).setNoRepair().rarity(Rarity.COMMON).tab(BezoarCreativeModeTabs.BEZOAR_GROUP)));


    public static final Item ALLIUM_C = registerItem("allium_chlorophytus",
            new Allium_Chlorophytus(new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).stacksTo(8)));

    public static final Item ALLIUM_M = registerItem("allium_majora",
            new Allium_Majora(new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).stacksTo(8)));

    public static final Item Chorus_M = registerItem("chorus_majora",
            new Chorus_Majora(new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).stacksTo(8)));

    public static final Item WITHER_M = registerItem("wither_majora",
            new Wither_Majora(new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).stacksTo(8)));

    public static final Item CHORUS_TROPHY = registerItem("chorus_trophy",
            new Item(new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).stacksTo(8)));

    public static final Item FLORAL_TROPHY = registerItem("floral_trophy",
            new Item(new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).stacksTo(8)));

    public static final Item HONEY_TROPHY = registerItem("honey_trophy",
            new Item(new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).stacksTo(8)));

    public static final Item MOSSY_TROPHY = registerItem("mossy_trophy",
            new Item(new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).stacksTo(8)));

    public static final Item SPIKEY_TROPHY = registerItem("spikey_trophy",
            new Item(new Item.Properties().tab(BezoarCreativeModeTabs.BEZOAR_GROUP).stacksTo(8)));


    public static Item registerItem(String registryName, Item item) {
        ITEMS.register(registryName, () -> item);
        return item;
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
