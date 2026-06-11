package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.CandleCakeBlock;
import net.minecraft.world.level.block.state.BlockState;

public class LightsporesJuiceItem extends JNEDConsumableItem {

    public LightsporesJuiceItem(Properties properties) {
        super(properties, true, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(level.isClientSide) return;
        BlockPos.betweenClosedStream(consumer.blockPosition().offset(-12,-6,-12),consumer.blockPosition().offset(12,6,12)).forEach(pos -> {
            BlockState blockState=level.getBlockState(pos);
            if(blockState.getBlock() instanceof CandleBlock && blockState.hasProperty(CandleBlock.LIT) && !blockState.getValue(CandleBlock.LIT)) {
                level.setBlock(pos,blockState.setValue(CandleBlock.LIT,true),3);
                level.playSound(null,pos,SoundEvents.FLINTANDSTEEL_USE,SoundSource.BLOCKS,0.6f,0.9f);
                if(level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SMALL_FLAME,pos.getX() + 0.5,pos.getY() + 0.9, pos.getZ() + 0.5,6,0.1,0.15,0.1,0.01);
                    serverLevel.sendParticles(ParticleTypes.END_ROD,pos.getX() + 0.5,pos.getY() + 0.9, pos.getZ() + 0.5,4,0.12,0.12,0.12,0.01);
                }
            }
            if (blockState.getBlock() instanceof CandleCakeBlock && blockState.hasProperty(CandleCakeBlock.LIT) && !blockState.getValue(CandleCakeBlock.LIT)) {
                level.setBlock(pos,blockState.setValue(CandleCakeBlock.LIT,true),3);
                level.playSound(null,pos,SoundEvents.FLINTANDSTEEL_USE,SoundSource.BLOCKS,0.6f,0.9f);
                if(level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SMALL_FLAME,pos.getX() + 0.5,pos.getY() + 0.9, pos.getZ() + 0.5,6,0.1,0.15,0.1,0.01);
                    serverLevel.sendParticles(ParticleTypes.END_ROD,pos.getX() + 0.5,pos.getY() + 0.9, pos.getZ() + 0.5,4,0.12,0.12,0.12,0.01);
                }
            }
        });
        if(consumer instanceof Player player) {
            level.playSound(null, player.blockPosition(), SoundEvents.AMETHYST_BLOCK_CHIME,SoundSource.PLAYERS,1.5f,0.6f);
        }
    }
}

