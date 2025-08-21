package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.UUID;

public class PastaWithCookedHoghamItem extends JNEDConsumableItem {
    public PastaWithCookedHoghamItem(Properties properties) {
        super(properties, false, true);
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
        }
            level.playSound(null, player.blockPosition(), SoundEvents.PIG_SADDLE, SoundSource.PLAYERS,1.0f,1.0f);
    }
}
