package milamber.brass.bezoar.item;

import milamber.brass.bezoar.item.custom.Bezoar;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup BEZOAR_GROUP = new ItemGroup("bezoarTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack((ModItems.BEZOAR.get()));
        }
    };
}
