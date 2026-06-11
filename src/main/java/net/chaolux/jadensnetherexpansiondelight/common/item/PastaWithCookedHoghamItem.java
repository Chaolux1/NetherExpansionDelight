package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class PastaWithCookedHoghamItem extends JNEDConsumableItem {
    public PastaWithCookedHoghamItem(Properties properties) {
        super(properties, true, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (level.isClientSide || !(consumer instanceof Player player)) return;
        double radius=10.0;
        List<Pig> pigs=level.getEntitiesOfClass(Pig.class,consumer.getBoundingBox().inflate(radius), pig -> true);
        for(Pig pig : pigs) {
            PathNavigation navigation=pig.getNavigation();
            if(navigation !=null) {
                navigation.moveTo(player,1.25);
            }
            pig.getLookControl().setLookAt(player,30.0f,30.0f);
            if(level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.HEART,pig.getX(),pig.getY() + 0.7,pig.getZ(),1,0.05,0.05,0.05,0.0);
            }
        }
            level.playSound(null, player.blockPosition(), SoundEvents.PIG_SADDLE, SoundSource.PLAYERS,1.0f,1.0f);
    }
}
