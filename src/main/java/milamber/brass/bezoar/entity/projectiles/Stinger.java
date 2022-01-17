package milamber.brass.bezoar.entity.projectiles;

import milamber.brass.bezoar.BezoarEntityTypes;
import milamber.brass.bezoar.BezoarItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nonnull;

public class Stinger extends AbstractArrow {

    private double bezDamage;
    private static final EntityDataAccessor<Integer> ID_EFFECT_COLOR = SynchedEntityData.defineId(Stinger.class, EntityDataSerializers.INT);

    public Stinger(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    public Stinger(EntityType<? extends AbstractArrow> entityType, Level level, LivingEntity shooter) {
        super(entityType, shooter, level);
        this.setBaseDamage(4D);
    }

    public Stinger(Level level, LivingEntity shooter) {
        this(BezoarEntityTypes.STINGER.get(), level, shooter);
    }

    public Stinger(Level level, double x, double y, double z) {
        super(BezoarEntityTypes.STINGER.get(), x, y, z, level);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    protected void doPostHurtEffects(LivingEntity livingEntity) {
        super.doPostHurtEffects(livingEntity);
        Entity entity = this.getEffectSource();


        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 4, 2, false, true), entity);

    }

    public void tick() {
        super.tick();
        super.tick();
        if (this.level.isClientSide) {
            if (this.inGround) {
                if (this.inGroundTime % 5 == 0) {
                    this.makeParticle(1);
                }
            } else {
                this.makeParticle(2);
            }
        } else if (this.inGround && this.inGroundTime != 0 && this.inGroundTime >= 600) {
            this.level.broadcastEntityEvent(this, (byte)0);
        }

    }

    private void makeParticle(int p_36877_) {
        double d0 = 40.0;
        double d1 = 75.0;
        double d2 = 40.0;

        for(int j = 0; j < 20; ++j) {
            this.level.addParticle(ParticleTypes.FALLING_SPORE_BLOSSOM, this.getRandomX(0.5D), this.getRandomY(), this.getRandomZ(0.5D), d0, d1, d2);
        }

    }

    @Override
    public double getBaseDamage() {
        return this.bezDamage;
    }

    @Override
    public void setBaseDamage(double damageIn) {
        this.bezDamage = damageIn;
    }

    /**
     * Returns the correct Item when picking up an arrow.
     */

    protected ItemStack getPickupItem() {

        return new ItemStack(BezoarItems.STINGER_ITEM.asItem());

    }

    /*********************************************************** Networking
     * @return********************************************************/

    @Override
    @Nonnull
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public ItemStack getItem() {
         return new ItemStack(BezoarItems.STINGER_ITEM.asItem());
    }
}
