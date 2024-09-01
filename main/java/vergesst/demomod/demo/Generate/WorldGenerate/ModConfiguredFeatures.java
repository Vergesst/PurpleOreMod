package vergesst.demomod.demo.Generate.WorldGenerate;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import vergesst.demomod.demo.Global.GlobalBlocks;

import java.util.List;

import static vergesst.demomod.demo.Demo.MOD_ID;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_PURPLE_ORE = registerKey("nether_purple_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_PURPLE_ORE = registerKey("end_purple_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest netherPlace = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
        RuleTest endPlace = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> purple = List.of(
                OreFeatureConfig.createTarget(netherPlace, Blocks.AIR.getDefaultState()),
                OreFeatureConfig.createTarget(endPlace, GlobalBlocks.PURPLE_ORE.getDefaultState())
        );

        register(context, NETHER_PURPLE_ORE, Feature.ORE, new OreFeatureConfig(purple, 12));
        register(context, END_PURPLE_ORE, Feature.ORE, new OreFeatureConfig(purple, 3));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MOD_ID, name));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configure) {
        context.register(key, new ConfiguredFeature<>(feature, configure));
    }
}
