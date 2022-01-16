package milamber.brass.bezoar.util;

import milamber.brass.bezoar.BezoarItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BezoarCreativeModeTabs {

    public static final CreativeModeTab BEZOAR_GROUP = new CreativeModeTab("bezoarTab")
    {
        @Override
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack((BezoarItems.BEZOAR));
        }
    };


}
