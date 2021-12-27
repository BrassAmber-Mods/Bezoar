package milamber.brass.bezoar.entity.custom;

import milamber.brass.bezoar.entity.ModEntityTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Stinger_Entity extends AbstractArrowEntity {
    public Stinger_Entity(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public Stinger_Entity(EntityType<? extends AbstractArrowEntity> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    public Stinger_Entity(World worldIn, LivingEntity shooter) {
        super(ModEntityTypes.STINGER_ENTITY.get(), shooter, worldIn);
    }

    @Override
    protected ItemStack getArrowStack() {
        return null;
    }
}
