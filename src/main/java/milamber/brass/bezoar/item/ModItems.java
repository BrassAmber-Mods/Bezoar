package milamber.brass.bezoar.item;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.ModEntityTypes;
import milamber.brass.bezoar.item.custom.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BezoarMod.MOD_ID);

    public static final RegistryObject<Item> BEZOAR = ITEMS.register("bezoar",
            () -> new Bezoar(new Item.Properties().stacksTo(1).setNoRepair().rarity(Rarity.EPIC).tab(ModItemGroup.BEZOAR_GROUP).defaultDurability(16)));

    public static final RegistryObject<Item> STINGER = ITEMS.register("stinger",
            () -> new Stinger(new Item.Properties().stacksTo(16).setNoRepair().rarity(Rarity.COMMON).tab(ModItemGroup.BEZOAR_GROUP)));

    public static final RegistryObject<Item> ALLIUM_C = ITEMS.register("allium_chlorophytus",
            () -> new Allium_Chlorophytus(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> ALLIUM_M = ITEMS.register("allium_majora",
            () -> new Allium_Majora(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> Chorus_M = ITEMS.register("chorus_majora",
            () -> new Chorus_Majora(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> WITHER_M = ITEMS.register("wither_majora",
            () -> new Wither_Majora(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> CHORUS_TROPHY = ITEMS.register("chorus_trophy",
            () -> new Item(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> DELTA_TROPHY = ITEMS.register("delta_trophy",
            () -> new Item(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> FLORAL_TROPHY = ITEMS.register("floral_trophy",
            () -> new Item(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> HONEY_TROPHY = ITEMS.register("honey_trophy",
            () -> new Item(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> MOSSY_TROPHY = ITEMS.register("mossy_trophy",
            () -> new Item(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> SPIKEY_TROPHY = ITEMS.register("spikey_trophy",
            () -> new Item(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));

    public static final RegistryObject<Item> BLACKJACKET_TROPHY = ITEMS.register("blackjacket_trophy",
            () -> new Item(new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP).stacksTo(8)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
