package milamber.brass.bezoar.item;

import milamber.brass.bezoar.item.custom.Bezoar;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ModItemGroup {

    public static final CreativeModeTab BEZOAR_GROUP = new CreativeModeTab("bezoarTab")
    {
        @Override
        public @NotNull ItemStack makeIcon()
        {
            return new ItemStack((ModItems.BEZOAR.get());
        }
    };
}
