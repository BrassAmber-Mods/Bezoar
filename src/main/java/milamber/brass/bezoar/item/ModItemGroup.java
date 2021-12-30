package milamber.brass.bezoar.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModItemGroup {

    public static final CreativeModeTab BEZOAR_GROUP = new CreativeModeTab("bezoarTab")
    {
        @Override
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack((ModItems.BEZOAR.get()));
        }
    };
}
