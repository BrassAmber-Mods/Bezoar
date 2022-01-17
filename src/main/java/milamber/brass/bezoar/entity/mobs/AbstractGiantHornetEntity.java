package milamber.brass.bezoar.entity.mobs;

import milamber.brass.bezoar.Bezoar;
import milamber.brass.bezoar.BezoarItems;
import milamber.brass.bezoar.entity.ai.ChargingMeleeAttackGoal;
import milamber.brass.bezoar.entity.projectiles.Stinger;
import milamber.brass.bezoar.item.StingerItem;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;


public class AbstractGiantHornetEntity extends Monster implements RangedAttackMob, FlyingAnimal {
    private final RangedBowAttackGoal<AbstractGiantHornetEntity> bowGoal = new RangedBowAttackGoal<>(this, 1.0D, 15, 15.0F);
    private final ChargingMeleeAttackGoal meleeGoal = new ChargingMeleeAttackGoal(this, 3.0D, 8,true);
    private static final ResourceLocation LOOT_TABLE = new ResourceLocation(Bezoar.MOD_ID, "entities/honey_hornet");
    public AbstractGiantHornetEntity(EntityType<? extends AbstractGiantHornetEntity> type, Level worldIn) {
        super(type, worldIn);
        this.setCanPickUpLoot(false);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.lookControl = new LookControl(this);
    }


    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 1.5D, 8.0F));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomFlyingGoal(this, 3.0D));
        this.goalSelector.addGoal(9, new FloatGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<Player>(this, Player.class, true));
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LOOT_TABLE;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.MAX_HEALTH, 25D)
                .add(Attributes.FLYING_SPEED, 2.4f)
                .add(Attributes.ATTACK_DAMAGE, 3)
                .add(Attributes.ATTACK_SPEED, 1.4f);
    }

    @Override
    public void die(DamageSource p_21014_) {
        super.die(p_21014_);
    }

    protected void playStepSound(BlockPos p_32159_, BlockState p_32160_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.PARROT_FLY;
    }

    /**
     * Gives armor or weapon for entity based on given DifficultyInstance
     */

    @Override
    protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
        super.populateDefaultEquipmentSlots(difficulty);
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }


    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_32146_, DifficultyInstance p_32147_, MobSpawnType p_32148_, @Nullable SpawnGroupData p_32149_, @Nullable CompoundTag p_32150_) {
        p_32149_ = super.finalizeSpawn(p_32146_, p_32147_, p_32148_, p_32149_, p_32150_);
        this.populateDefaultEquipmentSlots(p_32147_);
        this.populateDefaultEquipmentEnchantments(p_32147_);
        this.reassessWeaponGoal();
        this.setCanPickUpLoot(this.random.nextFloat() < 0.55F * p_32147_.getSpecialMultiplier());
        if (this.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
            LocalDate localdate = LocalDate.now();
            int i = localdate.get(ChronoField.DAY_OF_MONTH);
            int j = localdate.get(ChronoField.MONTH_OF_YEAR);
            if (j == 10 && i == 31 && this.random.nextFloat() < 0.25F) {
                this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(this.random.nextFloat() < 0.1F ? Blocks.JACK_O_LANTERN : Blocks.CARVED_PUMPKIN));
                this.armorDropChances[EquipmentSlot.HEAD.getIndex()] = 0.0F;
            }
        }

        return p_32149_;
    }

    public void reassessWeaponGoal() {
        if (this.level != null && !this.level.isClientSide) {
            this.goalSelector.removeGoal(this.meleeGoal);
            this.goalSelector.removeGoal(this.bowGoal);
            Player player = this.level.getNearestPlayer(this, -1D);
            if (player.distanceToSqr(this) > 8) {
                this.bowGoal.setMinAttackInterval(30);
                this.goalSelector.addGoal(4, this.bowGoal);
            } else {
                this.goalSelector.addGoal(4, this.meleeGoal);
            }
        }
    }

    public void performRangedAttack(LivingEntity entity, float p_32142_) {
        ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem)));
        Stinger stinger = this.getArrow(itemstack);
        double d0 = entity.getX() - this.getX();
        double d1 = entity.getY(0.3333333333333333D) - stinger.getY();
        double d2 = entity.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        stinger.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level.getDifficulty().getId() * 4));
        this.playSound(SoundEvents.SKELETON_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level.addFreshEntity(stinger);
    }

    protected Stinger getArrow(ItemStack stack) {
        StingerItem stingerItem = (StingerItem) (stack.getItem() instanceof StingerItem ? stack.getItem() : BezoarItems.STINGER_ITEM);
        Stinger stinger = stingerItem.createArrow(this.level, this);
        return stinger;
    }

    public boolean canFireProjectileWeapon(ProjectileWeaponItem p_32144_) {
        return p_32144_ == Items.BOW;
    }

    public void readAdditionalSaveData(CompoundTag p_32152_) {
        super.readAdditionalSaveData(p_32152_);
        this.reassessWeaponGoal();
    }

    public void setItemSlot(EquipmentSlot slotIn, ItemStack stack) {
        super.setItemSlot(slotIn, stack);
        if (!this.level.isClientSide) {
            this.reassessWeaponGoal();
        }

    }

    @Override
    protected void dropAllDeathLoot(DamageSource p_21192_) {
        Entity entity = p_21192_.getEntity();

        int i = net.minecraftforge.common.ForgeHooks.getLootingLevel(this, entity, p_21192_);
        this.captureDrops(new java.util.ArrayList<>());

        boolean flag = this.lastHurtByPlayerTime > 0;
        if (this.shouldDropLoot() && this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT)) {
            this.dropFromLootTable(p_21192_, flag);
            this.dropCustomDeathLoot(p_21192_, i, flag);
        }

        this.dropExperience();

        Collection<ItemEntity> drops = captureDrops(null);
        if (!net.minecraftforge.common.ForgeHooks.onLivingDrops(this, p_21192_, drops, i, lastHurtByPlayerTime > 0))
            drops.forEach(e -> level.addFreshEntity(e));
    }

    public static boolean canSpawn(EntityType<? extends AbstractGiantHornetEntity> entity,
                                       ServerLevelAccessor levelAccess, MobSpawnType spawnType, BlockPos pos, Random random) {
        ChunkGenerator chunkGen = levelAccess.getLevel().getChunkSource().getGenerator();
        int landHeight = chunkGen.getFirstOccupiedHeight(pos.getX(), pos.getY(), Heightmap.Types.WORLD_SURFACE, levelAccess.getLevel());
        Biome.BiomeCategory biomeCategory = levelAccess.getBiome(pos).getBiomeCategory();
        boolean underJungleSwamp = biomeCategory.equals(Biome.BiomeCategory.JUNGLE) || biomeCategory.equals(Biome.BiomeCategory.SWAMP);
        Bezoar.LOGGER.log(org.apache.logging.log4j.Level.DEBUG, biomeCategory.getName().equals(new ResourceLocation("minecraft:lush_caves").toString()));

        if (underJungleSwamp && pos.getY() < landHeight && isDarkEnoughToSpawn(levelAccess, pos, random)) {
            return true;
        } else if (biomeCategory.getName().equals(new ResourceLocation("minecraft:lush_caves").toString())) {
            Bezoar.LOGGER.log(org.apache.logging.log4j.Level.DEBUG, levelAccess.getBlockState(pos).toString());
            return  true;
        }
        return  false;
    }


    /**
     * Returns the Y Offset of this entity.
     */
    public double getPosYHeight() {
        return -0.6D;
    }


    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BEE_DEATH;
    }

    public boolean isFlapping() {
        return this.isFlying();
    }

    public boolean isFlying() {
        return !this.onGround;
    }
}
