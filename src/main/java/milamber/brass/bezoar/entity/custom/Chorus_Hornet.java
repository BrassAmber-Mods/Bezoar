package milamber.brass.bezoar.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class Chorus_Hornet extends Giant_Hornet {
    private static final DataParameter<Boolean> field_226535_bfx_ = EntityDataManager.createKey(EndermanEntity.class, DataSerializers.BOOLEAN);
    private int targetChangeTime;
    public Chorus_Hornet(EntityType<? extends Chorus_Hornet> type, World worldIn) {
        super(type, worldIn);

    }

    public static AttributeModifierMap.MutableAttribute setAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 13.0f)
                .createMutableAttribute(Attributes.FLYING_SPEED, 2.4f )
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 1.4f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(1, new Chorus_Hornet.FindPlayerGoal(this, (Predicate<LivingEntity>) EntityType.PLAYER));
    }

    protected void updateAITasks() {
        if (this.world.isDaytime() && this.ticksExisted >= this.targetChangeTime + 600) {
            float f = this.getBrightness();
            if (f > 0.5F && this.world.canSeeSky(this.getPosition()) && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F) {
                this.setAttackTarget((LivingEntity)null);
                this.teleportRandomly();
            }
        }

        super.updateAITasks();
    }

    public boolean isAlive() {
        return !this.removed && this.getHealth() > 0.0F;
    }

    public void setAttackTarget(@Nullable LivingEntity entitylivingbaseIn) {
        this.targetChangeTime = this.ticksExisted;
        super.setAttackTarget(entitylivingbaseIn); //Forge: Moved down to allow event handlers to write data manager values.
    }

    private boolean shouldAttackPlayer(PlayerEntity player) {
        Vector3d vector3d = player.getLook(1.0F).normalize();
        Vector3d vector3d1 = new Vector3d(this.getPosX() - player.getPosX(), this.getPosYEye() - player.getPosYEye(), this.getPosZ() - player.getPosZ());
        double d0 = vector3d1.length();
        vector3d1 = vector3d1.normalize();
        double d1 = vector3d.dotProduct(vector3d1);
        return d1 > 1.0D - 0.025D / d0 ? player.canEntityBeSeen(this) : false;
    }

    protected boolean teleportRandomly() {
        if (!this.world.isRemote() && this.isAlive()) {
            double d0 = this.getPosX() + (this.rand.nextDouble() - 0.5D) * 64.0D;
            double d1 = this.getPosY() + (double) (this.rand.nextInt(64) - 32);
            double d2 = this.getPosZ() + (this.rand.nextDouble() - 0.5D) * 64.0D;
            return this.teleportTo(d0, d1, d2);
        } else {
            return false;
        }
    }

    /**
     * Teleport the enderman to another entity
     */
    private boolean teleportToEntity(Entity p_70816_1_) {
        Vector3d vector3d = new Vector3d(this.getPosX() - p_70816_1_.getPosX(), this.getPosYHeight(0.5D) - p_70816_1_.getPosYEye(), this.getPosZ() - p_70816_1_.getPosZ());
        vector3d = vector3d.normalize();
        double d0 = 16.0D;
        double d1 = this.getPosX() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.x * 16.0D;
        double d2 = this.getPosY() + (double) (this.rand.nextInt(16) - 8) - vector3d.y * 16.0D;
        double d3 = this.getPosZ() + (this.rand.nextDouble() - 0.5D) * 8.0D - vector3d.z * 16.0D;
        return this.teleportTo(d1, d2, d3);
    }


    /**
     * Teleport the enderman
     */
    private boolean teleportTo(double x, double y, double z) {
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(x, y, z);

        while (blockpos$mutable.getY() > 0 && !this.world.getBlockState(blockpos$mutable).getMaterial().blocksMovement()) {
            blockpos$mutable.move(Direction.DOWN);
        }

        BlockState blockstate = this.world.getBlockState(blockpos$mutable);
        boolean flag = blockstate.getMaterial().blocksMovement();
        boolean flag1 = blockstate.getFluidState().isTagged(FluidTags.WATER);
        if (flag && !flag1) {
            net.minecraftforge.event.entity.living.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, x, y, z);
            if (event.isCanceled()) return false;
            boolean flag2 = this.attemptTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2 && !this.isSilent()) {
                this.world.playSound((PlayerEntity) null, this.prevPosX, this.prevPosY, this.prevPosZ, SoundEvents.ENTITY_ENDERMAN_TELEPORT, this.getSoundCategory(), 1.0F, 1.0F);
                this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
            }

            return flag2;
        } else {
            return false;
        }
    }

    public void func_226538_eu_() {
        this.dataManager.set(field_226535_bfx_, true);
    }

    static class FindPlayerGoal extends NearestAttackableTargetGoal<PlayerEntity> {
        private final Chorus_Hornet chorus_hornet;
        /**
         * The player
         */
        private PlayerEntity player;
        private int teleportTime;
        private final EntityPredicate field_220791_m;
        private final EntityPredicate field_220792_n = (new EntityPredicate()).setIgnoresLineOfSight();

        public FindPlayerGoal(Chorus_Hornet p_i241912_1_, @Nullable Predicate<LivingEntity> p_i241912_2_) {
            super(p_i241912_1_, PlayerEntity.class, 10, false, false, p_i241912_2_);
            this.chorus_hornet = p_i241912_1_;
            this.field_220791_m = (new EntityPredicate()).setDistance(this.getTargetDistance()).setCustomPredicate((p_220790_1_) -> {
                return p_i241912_1_.shouldAttackPlayer((PlayerEntity) p_220790_1_);
            });
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean shouldExecute() {
            this.player = this.chorus_hornet.world.getClosestPlayer(this.field_220791_m, this.chorus_hornet);
            return this.player != null;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.teleportTime = 0;
            this.chorus_hornet.func_226538_eu_();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            this.player = null;
            super.resetTask();
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            if (this.player != null) {
                if (!this.chorus_hornet.shouldAttackPlayer(this.player)) {
                    return false;
                } else {
                    this.chorus_hornet.faceEntity(this.player, 10.0F, 10.0F);
                    return true;
                }
            } else {
                return this.nearestTarget != null && this.field_220792_n.canTarget(this.chorus_hornet, this.nearestTarget) ? true : super.shouldContinueExecuting();
            }
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void tick() {
            if (this.chorus_hornet.getAttackTarget() == null) {
                super.setNearestTarget((LivingEntity)null);
            }

            if (this.player != null) {
                this.nearestTarget = this.player;
                this.player = null;
                super.startExecuting();
            } else {
                if (this.nearestTarget != null && !this.chorus_hornet.isPassenger()) {
                    if (this.chorus_hornet.shouldAttackPlayer((PlayerEntity)this.nearestTarget)) {
                        if (this.nearestTarget.getDistanceSq(this.chorus_hornet) < 16.0D) {
                            this.chorus_hornet.teleportRandomly();
                        }

                        this.teleportTime = 0;
                    } else if (this.nearestTarget.getDistanceSq(this.chorus_hornet) > 256.0D && this.teleportTime++ >= 30 && this.chorus_hornet.teleportToEntity(this.nearestTarget)) {
                        this.teleportTime = 0;
                    }
                }

                super.tick();
            }

        }
    }
}

