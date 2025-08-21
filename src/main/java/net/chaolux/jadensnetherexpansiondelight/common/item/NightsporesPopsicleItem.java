package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class NightsporesPopsicleItem extends JNEDConsumableItem {

    public NightsporesPopsicleItem(Properties properties) {
        super(properties, false, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(level.isClientSide) return;
        BlockPos.betweenClosedStream(consumer.blockPosition().offset(-7,-4,-7),consumer.blockPosition().offset(7,4,7)).forEach(pos -> {
            BlockState blockState = level.getBlockState(pos);
            Block block = blockState.getBlock();
            if (block instanceof WallTorchBlock && block != Blocks.SOUL_WALL_TORCH) {
                Direction facing = blockState.hasProperty(HorizontalDirectionalBlock.FACING) ? blockState.getValue(HorizontalDirectionalBlock.FACING) : Direction.NORTH;
                level.setBlock(pos, Blocks.SOUL_WALL_TORCH.defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, facing), 3);
                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 6, 0.08, 0.10, 0.08, 0.01);
                    serverLevel.sendParticles(ParticleTypes.SOUL, pos.getX(), pos.getY(), pos.getZ(), 4, 0.10, 0.12, 0.10, 0.005);
                }
            } else if (block instanceof TorchBlock && block != Blocks.SOUL_TORCH) {
                level.setBlock(pos, Blocks.SOUL_TORCH.defaultBlockState(), 3);
                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 6, 0.08, 0.10, 0.08, 0.01);
                    serverLevel.sendParticles(ParticleTypes.SOUL, pos.getX(), pos.getY(), pos.getZ(), 4, 0.10, 0.12, 0.10, 0.005);
                }
            } else if (block instanceof LanternBlock && block != Blocks.SOUL_LANTERN) {
                boolean hanging = blockState.hasProperty(LanternBlock.HANGING) && blockState.getValue(LanternBlock.HANGING);
                level.setBlock(pos, Blocks.SOUL_LANTERN.defaultBlockState().setValue(LanternBlock.HANGING, hanging), 3);
                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 6, 0.08, 0.10, 0.08, 0.01);
                    serverLevel.sendParticles(ParticleTypes.SOUL, pos.getX(), pos.getY(), pos.getZ(), 4, 0.10, 0.12, 0.10, 0.005);
                }
            } else if (block instanceof CampfireBlock && block != Blocks.SOUL_CAMPFIRE) {
                boolean lit = blockState.hasProperty(CampfireBlock.LIT) && blockState.getValue(CampfireBlock.LIT);
                boolean water = blockState.hasProperty(CampfireBlock.WATERLOGGED) && blockState.getValue(CampfireBlock.WATERLOGGED);
                BlockState state = Blocks.SOUL_CAMPFIRE.defaultBlockState().setValue(CampfireBlock.LIT, lit).setValue(CampfireBlock.WATERLOGGED, water);
                level.setBlock(pos, state, 3);
                if (level instanceof ServerLevel serverLevel) {
                    serverLevel.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, pos.getX(), pos.getY(), pos.getZ(), 6, 0.08, 0.10, 0.08, 0.01);
                    serverLevel.sendParticles(ParticleTypes.SOUL, pos.getX(), pos.getY(), pos.getZ(), 4, 0.10, 0.12, 0.10, 0.005);
                }
            }
        });
        if(consumer instanceof Player player) {
            level.playSound(null, player.blockPosition(), SoundEvents.SOUL_SAND_BREAK, SoundSource.PLAYERS,0.9f,0.9f);
        }
    }
}

