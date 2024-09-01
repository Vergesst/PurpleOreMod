package vergesst.demomod.demo.Generate.DataGenerate;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.advancement.Advancement;
import net.minecraft.data.server.advancement.AdvancementProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import vergesst.demomod.demo.Generate.WorldGenerate.ModConfiguredFeatures;
import vergesst.demomod.demo.Generate.WorldGenerate.WorldOrePlacedFeatures;
import vergesst.demomod.demo.Generate.Advancements.AdvancementsProvider;

public class DemoDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModWorldGenerator::new);
        fabricDataGenerator.createPack().addProvider(AdvancementsProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, WorldOrePlacedFeatures::boostrap);
    }
}
