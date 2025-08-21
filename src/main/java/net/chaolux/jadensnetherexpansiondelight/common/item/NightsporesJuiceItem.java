package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.utility.TextUtils;

import javax.annotation.Nullable;
import java.util.List;

public class NightsporesJuiceItem extends JNEDConsumableItem {

    public NightsporesJuiceItem(Properties properties) {
        super(properties, false, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(level.isClientSide) return;
        BlockPos.betweenClosedStream(consumer.blockPosition().offset(-12,-6,-12),consumer.blockPosition().offset(12,6,12)).forEach(pos -> {
            BlockState blockState=level.getBlockState(pos);
            if(blockState.getBlock() instanceof CandleBlock && blockState.hasProperty(CandleBlock.LIT) && blockState.getValue(CandleBlock.LIT)) {
                level.setBlock(pos,blockState.setValue(CandleBlock.LIT,false),3);
                level.playSound(null,pos,SoundEvents.CANDLE_EXTINGUISH,SoundSource.BLOCKS,0.6f,0.9f);
                if(level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SMOKE,pos.getX() + 0.5,pos.getY() + 0.9, pos.getZ() + 0.5,6,0.1,0.15,0.1,0.01);
                    serverLevel.sendParticles(ParticleTypes.END_ROD,pos.getX() + 0.5,pos.getY() + 0.9, pos.getZ() + 0.5,4,0.12,0.12,0.12,0.01);
                }
            }
            if (blockState.getBlock() instanceof CandleCakeBlock && blockState.hasProperty(CandleCakeBlock.LIT) && blockState.getValue(CandleCakeBlock.LIT)) {
                level.setBlock(pos,blockState.setValue(CandleCakeBlock.LIT,false),3);
                level.playSound(null,pos,SoundEvents.CANDLE_EXTINGUISH,SoundSource.BLOCKS,0.6f,0.9f);
                if(level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SMOKE,pos.getX() + 0.5,pos.getY() + 0.9, pos.getZ() + 0.5,6,0.1,0.15,0.1,0.01);
                    serverLevel.sendParticles(ParticleTypes.END_ROD,pos.getX() + 0.5,pos.getY() + 0.9, pos.getZ() + 0.5,4,0.12,0.12,0.12,0.01);
                }
            }
        });
        if(consumer instanceof Player player) {
            level.playSound(null, player.blockPosition(), SoundEvents.FIRE_EXTINGUISH,SoundSource.PLAYERS,1.5f,0.6f);
        }
    }
}

