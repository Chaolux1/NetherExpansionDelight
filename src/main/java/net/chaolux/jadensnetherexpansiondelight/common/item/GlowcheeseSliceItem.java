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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneLampBlock;
import net.minecraft.world.level.block.state.BlockState;

public class GlowcheeseSliceItem extends JNEDConsumableItem {

    public GlowcheeseSliceItem(Properties properties) {
        super(properties, false, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(!(level instanceof ServerLevel serverLevel)) return;
        BlockPos player=consumer.blockPosition();
        BlockPos.betweenClosedStream(consumer.blockPosition().offset(-12,-6,-12),consumer.blockPosition().offset(12,6,12)).forEach(pos -> {
            BlockState blockState = level.getBlockState(pos);
            Block block=blockState.getBlock();
            if(block instanceof RedstoneLampBlock && blockState.hasProperty(RedstoneLampBlock.LIT)) {
                boolean lit=blockState.getValue(RedstoneLampBlock.LIT);
                serverLevel.setBlock(pos,blockState.setValue(RedstoneLampBlock.LIT,!lit),3);
                serverLevel.sendParticles(ParticleTypes.ELECTRIC_SPARK,pos.getX() + 0.5,pos.getY() + 0.9,pos.getZ() + 0.5,10,0.15,0.15,0.15,0.02);
            }
        });
        if(consumer instanceof Player players) {
            level.playSound(null, players.blockPosition(), SoundEvents.LADDER_BREAK, SoundSource.PLAYERS,0.6f,0.7f);
        }
    }
}

