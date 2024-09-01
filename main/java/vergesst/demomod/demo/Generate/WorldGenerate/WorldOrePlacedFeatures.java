package vergesst.demomod.demo.Generate.WorldGenerate;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class WorldOrePlacedFeatures {
    public static final RegistryKey<PlacedFeature> NETHER_PURPLE_ORE = registerKey("nether_purple_ore");
    public static final RegistryKey<PlacedFeature> END_PURPLE_ORE = registerKey("end_purple_ore");
/*
modifierWithCount(int count, PlacementModifier placementModifier)
count: how many lode there will be in one chunk
 */
    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(context, END_PURPLE_ORE, configuredRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_PURPLE_ORE),
                WorldOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.fixed(60)))
                );
        register(context, NETHER_PURPLE_ORE, configuredRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_PURPLE_ORE),
                WorldOrePlacement.modifiersWithCount(10,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-50), YOffset.fixed(50)))
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> registryKey, RegistryEntry<ConfiguredFeature<?, ?>> entry
        , List<PlacementModifier> modifiers){
        context.register(registryKey, new PlacedFeature(entry, List.copyOf(modifiers)));
    }
}
