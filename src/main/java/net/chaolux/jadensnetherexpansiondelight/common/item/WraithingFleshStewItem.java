package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class WraithingFleshStewItem extends JNEDConsumableItem {
    private static final ResourceLocation HEART_UUID = ResourceLocation.fromNamespaceAndPath("jadensnetherexpansiondelight","wraithing_heart");

    public WraithingFleshStewItem(Properties properties) {
        super(properties, true, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (level.isClientSide || !(consumer instanceof Player player)) return;
        var maxHealth=player.getAttribute(Attributes.MAX_HEALTH);
        if(maxHealth == null) return;
        if(maxHealth.getModifier(HEART_UUID) != null) {
            maxHealth.removeModifier(HEART_UUID);
        }
        AttributeModifier attributeModifier=new AttributeModifier(HEART_UUID,-2.0,AttributeModifier.Operation.ADD_VALUE);
        maxHealth.addPermanentModifier(attributeModifier);
        float newMaxHealth= (float) player.getAttributeValue(Attributes.MAX_HEALTH);
        if(player.getHealth() > newMaxHealth) {
            player.setHealth(newMaxHealth);
        }
        level.playSound(null,player.blockPosition(),SoundEvents.SOUL_ESCAPE.value(),SoundSource.PLAYERS,1.5f,0.9f);
        if(level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.SOUL,player.getX(),player.getY() + 0.8,player.getZ(),12,0.25,0.35,0.35,0.02);
        }
    }
}
