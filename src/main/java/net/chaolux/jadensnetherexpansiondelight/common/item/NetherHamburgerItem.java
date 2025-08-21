package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class NetherHamburgerItem extends JNEDConsumableItem {
    public NetherHamburgerItem(Properties properties) {
        super(properties, false, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (level.isClientSide) return;
        consumer.clearFire();
        double radius = 7.0;
        List<LivingEntity> mobs = level.getEntitiesOfClass(LivingEntity.class, consumer.getBoundingBox().inflate(radius), entity -> entity instanceof Blaze || entity instanceof MagmaCube);
        Vec3 player=consumer.position();
        for (LivingEntity entity : mobs) {
            entity.hurt(level.damageSources().magic(),4.0f);
            Vec3 directory=entity.position().subtract(player).normalize().scale(0.4);
            entity.setDeltaMovement(entity.getDeltaMovement().add(directory));
            entity.hurtMarked=true;
        }
        if(consumer instanceof Player players) {
            level.playSound(null, players.blockPosition(), SoundEvents.FIRE_EXTINGUISH, SoundSource.PLAYERS,0.4f,0.5f);
        }
    }
}
