package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class RedScaleFungusRollItem extends JNEDConsumableItem {
    public RedScaleFungusRollItem(Properties properties) {
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
            Vec3 direction=player.subtract(entity.position());
            if(direction.lengthSqr() < 1.0E-6) continue;
            Vec3 push=direction.normalize().scale(1.2);
            if(push.length() > 2.0) {
                push=push.normalize().scale(2.0);
            }
            entity.setDeltaMovement(entity.getDeltaMovement().add(push));
            entity.hurtMarked=true;
        }
        if(consumer instanceof Player players) {
            level.playSound(null, players.blockPosition(), SoundEvents.ANVIL_BREAK, SoundSource.PLAYERS,0.5f,0.5f);
        }
    }
}
