package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class WispCustardItem extends JNEDConsumableItem {

    public WispCustardItem(Properties properties) {
        super(properties, false, true);
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
        if(consumer instanceof Player player) {
            level.playSound(null, player.blockPosition(), SoundEvents.AXOLOTL_SWIM, SoundSource.PLAYERS,0.9f,0.8f);
        }
    }
}

