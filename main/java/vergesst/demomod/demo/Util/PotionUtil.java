package vergesst.demomod.demo.Util;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class PotionUtil {
    public static <T extends StatusEffect> Potion register(String name, T potion, int duration){
        return Registry.register(
                Registries.POTION,
                new Identifier(MOD_ID, name),
                new Potion(new StatusEffectInstance(potion, duration))
        );
    }
}
