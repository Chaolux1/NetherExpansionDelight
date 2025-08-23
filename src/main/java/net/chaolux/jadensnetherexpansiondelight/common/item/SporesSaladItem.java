package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class SporesSaladItem extends JNEDConsumableItem {

    public SporesSaladItem(Properties properties) {
        super(properties, false, true);
    }
    private boolean isTamable(LivingEntity entity, LivingEntity mobs) {
        if(mobs instanceof Player) {
            return true;
        }
        if(mobs instanceof TamableAnimal tamableAnimal && tamableAnimal.isTame() && tamableAnimal.getOwner() == entity) {
            return true;
        }
        return entity.getTeam() !=null && mobs.getTeam() !=null && entity.getTeam().isAlliedTo(mobs.getTeam());
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(level.isClientSide) return;
        double radius=6.0;
        List<LivingEntity> team=level.getEntitiesOfClass(LivingEntity.class,consumer.getBoundingBox().inflate(radius), entity -> isTamable(consumer, entity));
        for(LivingEntity entity : team) {
            entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION,400,0,false,true));
            if(level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.HEART,entity.getX(),entity.getY() + entity.getBbHeight() + 0.2,entity.getZ(),2,0.05,0.05,0.05,0.0);
            }
        }
        if(consumer instanceof Player player) {
            level.playSound(null, player.blockPosition(), SoundEvents.BONE_BLOCK_STEP, SoundSource.PLAYERS,1.0f,1.0f);
        }
    }
}

