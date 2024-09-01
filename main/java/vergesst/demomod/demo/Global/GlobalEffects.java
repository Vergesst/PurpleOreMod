package vergesst.demomod.demo.Global;

import vergesst.demomod.demo.Feature.Effect.Frost;
import vergesst.demomod.demo.Util.EffectUtil;

import java.lang.reflect.InvocationTargetException;

public class GlobalEffects {
    public static Frost FROST;

    /*--register--*/
    public static void register() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FROST = EffectUtil.effectCreator("frost", vergesst.demomod.demo.Feature.Effect.Frost.class);
    }
}
