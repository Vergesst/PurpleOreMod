package vergesst.demomod.demo.Feature;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;

@Deprecated
public class DemoShield extends ShieldItem {
    public static final float MIN_DAMAGE_AMOUNT_TO_BREAK = 4.0f;
    public DemoShield(Settings settings) {
        super(settings);
    }
    @Override
    public int getMaxUseTime(ItemStack stack) {
        return 144000;
    }
    @Override
    public boolean canRepair(ItemStack toRepair, ItemStack repair) {
        return super.canRepair(toRepair, repair);
    }

}
