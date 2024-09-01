package vergesst.demomod.demo.Global;

import net.minecraft.potion.Potion;
import vergesst.demomod.demo.Util.PotionUtil;

public class GlobalPotion{
    public static Potion FROST;


    /*register*/
    public static void register(){
        FROST = PotionUtil.register("frost", GlobalEffects.FROST, 2400);
    }
}
