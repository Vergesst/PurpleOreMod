package vergesst.demomod.demo.Global;

import net.minecraft.item.ArmorMaterial;
import vergesst.demomod.demo.Feature.purpleNetherite;

public class GlobalMaterials {
    public static ArmorMaterial PURPLE_NETHERITE;

    public static void register(){
        PURPLE_NETHERITE = new purpleNetherite();
    }
}
