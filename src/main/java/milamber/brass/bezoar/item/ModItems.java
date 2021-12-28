package milamber.brass.bezoar.item;

import milamber.brass.bezoar.BezoarMod;
import milamber.brass.bezoar.entity.ModEntityTypes;
import milamber.brass.bezoar.item.custom.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BezoarMod.MOD_ID);

    public static final RegistryObject<Custom_Spawn_Egg_Item> JUNGLE_HORNET_SPAWN_EGG =
            ITEMS.register("jungle_hornet_spawn_egg", () ->
                    new Custom_Spawn_Egg_Item(ModEntityTypes.JUNGLE_HORNET.get(), 0x18c72c, 0xe3d512,
                            new Item.Properties().tab(ModItemGroup.BEZOAR_GROUP)));

    public static final RegistryObject<Item> BEZOAR = ITEMS.register("bezoar",
            () -> new Bezoar(new Item.Properties().maxStackSize(1).setNoRepair().rarity(Rarity.EPIC).group(ModItemGroup.BEZOAR_GROUP).maxDamage(16)));

    public static final RegistryObject<Item> STINGER = ITEMS.register("stinger",
            () -> new Stinger(new Item.Properties().maxStackSize(16).setNoRepair().rarity(Rarity.COMMON).group(ModItemGroup.BEZOAR_GROUP)));

    public static final RegistryObject<Item> ALLIUM_C = ITEMS.register("allium_chlorophytus",
            () -> new Allium_Chlorophytus(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> ALLIUM_M = ITEMS.register("allium_majora",
            () -> new Allium_Majora(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> Chorus_M = ITEMS.register("chorus_majora",
            () -> new Chorus_Majora(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> WITHER_M = ITEMS.register("wither_majora",
            () -> new Wither_Majora(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> CHORUS_TROPHY = ITEMS.register("chorus_trophy",
            () -> new Item(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> DELTA_TROPHY = ITEMS.register("delta_trophy",
            () -> new Item(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> FLORAL_TROPHY = ITEMS.register("floral_trophy",
            () -> new Item(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> HONEY_TROPHY = ITEMS.register("honey_trophy",
            () -> new Item(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> MOSSY_TROPHY = ITEMS.register("mossy_trophy",
            () -> new Item(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> SPIKEY_TROPHY = ITEMS.register("spikey_trophy",
            () -> new Item(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));

    public static final RegistryObject<Item> BLACKJACKET_TROPHY = ITEMS.register("blackjacket_trophy",
            () -> new Item(new Item.Properties().group(ModItemGroup.BEZOAR_GROUP).maxStackSize(8)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
