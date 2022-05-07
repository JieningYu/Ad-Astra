package net.mrscauthd.beyond_earth.entities.mobs;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HoglinEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.mrscauthd.beyond_earth.registry.ModEntities;

public class MoglerEntity extends HoglinEntity {

    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0).add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.6f).add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 1.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0);
    }
    
    public MoglerEntity(EntityType<? extends HoglinEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }

    @Override
    @Nullable
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        MoglerEntity moglerEntity = ModEntities.MOGLER.create(world);
        if (moglerEntity != null) {
            moglerEntity.setPersistent();
        }
        return moglerEntity;
    }
}