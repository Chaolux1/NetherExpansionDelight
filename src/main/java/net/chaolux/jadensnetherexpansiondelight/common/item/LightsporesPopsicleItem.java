package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

import java.util.EnumSet;
import java.util.List;

public class LightsporesPopsicleItem extends JNEDConsumableItem {

    public LightsporesPopsicleItem(Properties properties) {
        super(properties, true, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(!(level instanceof ServerLevel serverLevel)) return;
        double radius = 16.0;
        List<LivingEntity> mobs = serverLevel.getEntitiesOfClass(LivingEntity.class, consumer.getBoundingBox().inflate(radius), entity -> !(entity instanceof Player) && entity !=consumer);
        if(mobs.isEmpty()) return;
        LivingEntity another=mobs.get(consumer.getRandom().nextInt(mobs.size()));
        double player_x=consumer.getX(),player_y=consumer.getY(),player_z=consumer.getZ();
        double mobs_x=another.getX(),mobs_y=another.getY(),mobs_z=another.getZ();
        serverLevel.sendParticles(ParticleTypes.PORTAL,player_x,player_y + 1.0,player_z,20,0.4,0.6,0.4,0.2);
        serverLevel.sendParticles(ParticleTypes.PORTAL,mobs_x,mobs_y + 1.0,mobs_z,20,0.4,0.6,0.4,0.2);
        consumer.teleportTo(serverLevel,mobs_x,mobs_y,mobs_z, EnumSet.noneOf(RelativeMovement.class),consumer.getYRot(),consumer.getXRot());
        another.teleportTo(serverLevel,player_x,player_y,player_z, EnumSet.noneOf(RelativeMovement.class),another.getYRot(),another.getXRot());
        if(consumer instanceof Player player) {
            level.playSound(null, player.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS,0.7f,0.9f);
        }
    }
}

