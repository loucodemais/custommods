package net.custommods.block;

import net.custommods.CustomMods;
import net.custommods.block.custom.MassFabricator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block ELEVATOR = registerBlock("elevator",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));

    public static final Block CARPENTER = registerBlock("carpenter",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque()));

    public static final Block TIN_ORE = registerBlock("tin_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.COPPER_ORE)));
    public static final Block MASS_FABRICATOR = registerBlock("mass_fabricator",
            new MassFabricator(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(0.5f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CustomMods.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(CustomMods.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CustomMods.LOGGER.info("Registering ModBlocks for " + CustomMods.MOD_ID);
    }
}