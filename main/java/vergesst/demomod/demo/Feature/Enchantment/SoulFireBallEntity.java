package vergesst.demomod.demo.Feature.Enchantment;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class SoulFireBallEntity extends AbstractFireballEntity {
    private int explosionPower = 1;

    public SoulFireBallEntity(EntityType<? extends FireballEntity> entityType, World world) {
        super((EntityType<? extends AbstractFireballEntity>)entityType, world);
    }

    public SoulFireBallEntity(World world, LivingEntity owner, double velocityX, double velocityY, double velocityZ, int explosionPower) {
        super((EntityType<? extends AbstractFireballEntity>)EntityType.FIREBALL, owner, velocityX, velocityY, velocityZ, world);
        this.explosionPower = explosionPower;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            boolean bl = this.getWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING);
            this.getWorld().createExplosion((Entity)this, this.getX(), this.getY(), this.getZ(), (float)this.explosionPower, bl, World.ExplosionSourceType.MOB);
            this.discard();
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if (this.getWorld().isClient) {
            return;
        }
        Entity entity = entityHitResult.getEntity();
        Entity entity2 = this.getOwner();
        entity.damage(this.getDamageSources().fireball(this, entity2), 6.0f);
        if (entity2 instanceof LivingEntity) {
            this.applyDamageEffects((LivingEntity)entity2, entity);
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putByte("ExplosionPower", (byte)this.explosionPower);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (nbt.contains("ExplosionPower", NbtElement.NUMBER_TYPE)) {
            this.explosionPower = nbt.getByte("ExplosionPower");
        }
    }
}
