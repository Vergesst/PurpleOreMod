package vergesst.demomod.demo.Dimension;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import static vergesst.demomod.demo.Demo.MOD_ID;
@Deprecated
public class DemoDimension {
    public static final RegistryKey<World> DEMO_DIMENSION = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(MOD_ID, "dimension"));

    public static final RegistryKey<DimensionType> DEMO_DIMENSION_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            DEMO_DIMENSION.getValue());
}
