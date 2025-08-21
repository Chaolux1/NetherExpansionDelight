package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class CerebrageRollsItem extends JNEDConsumableItem {

    public CerebrageRollsItem(Properties properties) {
        super(properties, false, true);
    }

    @Override
    public void affectConsumer(ItemStack stack, Level level, LivingEntity consumer) {
        if(level.isClientSide) return;
        double radius=8.0;
        List<Mob> mobs=level.getEntitiesOfClass(Mob.class,consumer.getBoundingBox().inflate(radius), mob -> mob instanceof Monster);
        List<LivingEntity> entities=level.getEntitiesOfClass(LivingEntity.class,consumer.getBoundingBox().inflate(radius), entity -> true);
        if(entities.isEmpty()) return;
        for(Mob mob : mobs) {
            LivingEntity goal=entities.get(consumer.getRandom().nextInt(entities.size()));
            if(goal !=mob) {
                mob.setTarget(goal);
            }
        }
        if(consumer instanceof Player player) {
            level.playSound(null, player.blockPosition(), SoundEvents.ZOMBIE_INFECT, SoundSource.PLAYERS,0.6f,0.7f);
        }
    }
}

