package net.chaolux.jadensnetherexpansiondelight.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.item.KnifeItem;

import java.util.List;


public class EctoKnifeItem extends KnifeItem {
    public EctoKnifeItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level level = target.level();
        if (!level.isClientSide) {
            target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0, false, false));
            EntityType<?> type = target.getType();
            double radius = 8.0;
            List<LivingEntity> entities = level.getEntitiesOfClass(LivingEntity.class, target.getBoundingBox().inflate(radius), entity -> entity.isAlive() && entity.getType() == type && entity != target);
            for (LivingEntity entity : entities) {
                entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0, false, false));
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
