package vergesst.demomod.demo.Generate.WorldGenerate.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import vergesst.demomod.demo.Generate.WorldGenerate.WorldOrePlacedFeatures;

public class ModOreGeneration {
    public static void generateOres(){
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, WorldOrePlacedFeatures.NETHER_PURPLE_ORE);
        BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, WorldOrePlacedFeatures.END_PURPLE_ORE);
    }
}
