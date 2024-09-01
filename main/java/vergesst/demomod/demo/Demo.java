package vergesst.demomod.demo;

import net.fabricmc.api.ModInitializer;
import vergesst.demomod.demo.Generate.WorldGenerate.gen.ModWorldGeneration;
import vergesst.demomod.demo.Global.*;
import vergesst.demomod.demo.Util.ItemGroupUtil;

import java.lang.reflect.InvocationTargetException;

public class Demo implements ModInitializer {

    public static final String MOD_ID = "demo";

    @Override
    public void onInitialize() {
        ModWorldGeneration.modWorldGeneration();
        try {
            GlobalMaterials.register();
            GlobalBlocks.blockRegister();
            GlobalItems.itemRegister();
            ItemGroupUtil.itemGroupRegister();
            GlobalEnchant.register();
            GlobalEffects.register();
            GlobalPotion.register();
            System.out.println("demo");
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
