package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class HoghamStewItem extends JNEDConsumableItem {
    public HoghamStewItem(Properties properties) {
        super(properties, true, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(level.isClientSide || !(consumer instanceof Player player)) return;
        double radius = 8.0;
        List<Animal> animals = level.getEntitiesOfClass(Animal.class, consumer.getBoundingBox().inflate(radius), animal -> animal.isAlive());
        for(Animal animal : animals) {
            animal.setLastHurtByMob(player);
            if(level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.ANGRY_VILLAGER,animal.getX(),animal.getY() + animal.getBbHeight() + 0.1,animal.getZ(),2,0.05,0.05,0.05,0.0);
            }
        }
        if(consumer instanceof Player players) {
            level.playSound(null, players.blockPosition(), SoundEvents.PIG_AMBIENT, SoundSource.PLAYERS,1.6f,0.8f);
        }
    }
}