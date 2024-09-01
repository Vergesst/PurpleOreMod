package vergesst.demomod.demo.Feature.Effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class Frost extends StatusEffect {
    protected Frost() {
        super(StatusEffectCategory.HARMFUL, 0x98D982);
        System.out.println("created");
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if(entity instanceof LivingEntity) {
            if(entity.getDamageSources().equals(entity.getDamageSources().inFire())||entity.getDamageSources().equals(entity.getDamageSources().onFire())){
                entity.damage(entity.getDamageSources().onFire(), 1.0f);
            }
            entity.damage(entity.getDamageSources().freeze(), 0.5f*amplifier);
        }
    }
}
//