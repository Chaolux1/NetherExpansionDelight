package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WispCustardItem extends JNEDConsumableItem {

    public WispCustardItem(Properties properties) {
        super(properties, true, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(level.isClientSide) return;
        double random=consumer.getRandom().nextDouble() * Math.PI * 2.0;
        double direction=3.0;
        double vx=Math.cos(random) * direction;
        double vz=Math.sin(random) * direction;
        consumer.setDeltaMovement(consumer.getDeltaMovement().add(vx,2.25,vz));
        consumer.hurtMarked=true;
        consumer.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING,200,0,false,false));
        if(level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.CLOUD,consumer.getX(),consumer.getY() + 0.1,consumer.getZ(),10,0.25,0.1,0.25,0.02);
            serverLevel.sendParticles(ParticleTypes.END_ROD,consumer.getX(),consumer.getY() + 1.0,consumer.getZ(),8,0.2,0.3,0.2,0.01);
        }
        if(consumer instanceof Player player) {
            level.playSound(null, player.blockPosition(), SoundEvents.AXOLOTL_SWIM, SoundSource.PLAYERS,0.9f,0.8f);
        }
    }
}

