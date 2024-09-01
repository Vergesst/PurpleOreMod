package vergesst.demomod.demo.Dimension;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class DemoDimensions {
    public static final RegistryKey<DimensionType> DEEP_DARK = DemoDimensions.of("deep_dark");
    public static final Identifier DEEP_DARK_ID = new Identifier("deep_dark");


    private static RegistryKey<DimensionType> of(String id){
        return RegistryKey.of(RegistryKeys.DIMENSION_TYPE, new Identifier(id));
    }
}
