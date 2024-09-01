package vergesst.demomod.demo.Feature.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import vergesst.demomod.demo.Global.GlobalEffects;

public class Frost extends Enchantment {
    private final int MinLevel = 1;
    private final int MaxLevel = 5;
    private final int level = 5;

    protected Frost(Enchantment.Rarity weight, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(weight, target, slotTypes);
    }

    public int getMinLevel() {
        return MinLevel;
    }

    public int getMaxLevel() {
        return MaxLevel;
    }

    public int getMinPower() {
        return 1 + level * 10;
    }

    public float getAttackDamage(int level, EntityGroup group) {
        return 1.0F*level-5.0F;
    }

    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity) {
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, level*20, level));
            ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(GlobalEffects.FROST, level*10, level));
        }
        System.out.println("onTargetDamaged");
        super.onTargetDamaged(user, target, level);
    }
}
