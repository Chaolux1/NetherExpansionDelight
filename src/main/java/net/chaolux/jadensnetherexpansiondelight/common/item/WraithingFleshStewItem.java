package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class WraithingFleshStewItem extends JNEDConsumableItem {
    private static final UUID HEART_UUID = UUID.fromString("17025383-35de-4946-b0a9-4bf68ed531fc");

    public WraithingFleshStewItem(Properties properties) {
        super(properties, false, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if (level.isClientSide || !(consumer instanceof Player player)) return;
        if(player.getAttribute(Attributes.MAX_HEALTH).getModifier(HEART_UUID) !=null) {
            player.getAttribute(Attributes.MAX_HEALTH).removeModifier(HEART_UUID);
        }
        AttributeModifier modifier=new AttributeModifier(HEART_UUID,"wraithing_heart",-2.0,AttributeModifier.Operation.ADDITION);
        player.getAttribute(Attributes.MAX_HEALTH).addPermanentModifier(modifier);
        double current=Math.max(2.0,player.getAttribute(Attributes.MAX_HEALTH).getBaseValue() - 0.0);
        if(player.getHealth() > (float) current) player.setHealth((float) current);
            level.playSound(null, player.blockPosition(), SoundEvents.SOUL_ESCAPE, SoundSource.PLAYERS,1.5f,0.9f);
    }
}
