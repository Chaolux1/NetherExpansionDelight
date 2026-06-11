package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class BlueScaleFungusRollItem extends JNEDConsumableItem {
    public BlueScaleFungusRollItem(Properties properties) {
        super(properties, true, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (level.isClientSide) return;
        double radius = 7.0;
        List<Entity> entities = level.getEntities((Entity) null, consumer.getBoundingBox().inflate(radius), entity -> entity instanceof LivingEntity || entity instanceof ItemEntity);
        Vec3 player=consumer.position();
        for (Entity entity : entities) {
            if(entity == consumer) continue;
            Vec3 direction=entity.position().subtract(player);
            if(direction.lengthSqr() < 1.0E-6) continue;
            Vec3 push=direction.normalize().scale(1.6);
            if(push.length() > 2.4) {
                push=push.normalize().scale(2.4);
            }
            entity.setDeltaMovement(entity.getDeltaMovement().add(push));
            entity.hurtMarked=true;
            if(level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.CLOUD,entity.getX(),entity.getY() + entity.getBbHeight() * 0.5,entity.getZ(),4,0.1,0.1,0.1,0.02);
            }
        }
        if(consumer instanceof Player players) {
            level.playSound(null, players.blockPosition(), SoundEvents.ANVIL_BREAK, SoundSource.PLAYERS,0.5f,0.5f);
        }
    }
}
