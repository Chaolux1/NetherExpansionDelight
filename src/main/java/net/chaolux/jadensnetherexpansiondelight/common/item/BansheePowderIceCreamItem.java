package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.EnumSet;
import java.util.List;

public class BansheePowderIceCreamItem extends JNEDConsumableItem {

    public BansheePowderIceCreamItem(Properties properties) {
        super(properties, true, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(level.isClientSide) return;
        double radius=8.0;
        List<Mob> mobs=level.getEntitiesOfClass(Mob.class,consumer.getBoundingBox().inflate(radius), entity -> entity.getTarget() == consumer);
        for(Mob mob : mobs) {
            mob.setTarget(null);
            mob.setLastHurtByMob(null);
            mob.setLastHurtMob(null);
            if(mob.getBrain() !=null) {
                mob.getBrain().eraseMemory(MemoryModuleType.ATTACK_TARGET);
                mob.getBrain().eraseMemory(MemoryModuleType.ANGRY_AT);
                mob.getBrain().eraseMemory(MemoryModuleType.HURT_BY);
            }
            if(mob instanceof NeutralMob neutralMob) {
                neutralMob.setPersistentAngerTarget(null);
                neutralMob.stopBeingAngry();
            }
            mob.setAggressive(false);
            if(level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.POOF,mob.getX(),mob.getY() + mob.getBbHeight() * 0.5,mob.getZ(),6,0.15,0.15,0.15,0.01);
            }
        }
        if(consumer instanceof Player player) {
            level.playSound(null, player.blockPosition(), SoundEvents.GOAT_SCREAMING_HURT, SoundSource.PLAYERS,1.0f,1.0f);
        }
    }
}

