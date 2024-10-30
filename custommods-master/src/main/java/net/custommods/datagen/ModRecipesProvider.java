package net.custommods.datagen;

import net.custommods.CustomMods;
import net.custommods.block.ModBlocks;
import net.custommods.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipesProvider extends FabricRecipeProvider {

    public ModRecipesProvider(FabricDataOutput output){
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ELEVATOR, 1)
                .pattern("WWW")
                .pattern("WGW")
                .pattern("WWW")
                .input('W', Ingredient.fromTag(ItemTags.WOOL))
                .input('G', Items.GOLD_INGOT)
                .criterion(RecipeProvider.hasItem(Items.GOLD_INGOT), RecipeProvider.conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(consumer, new Identifier(getRecipeName(ModBlocks.ELEVATOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARPENTER, 5)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('P', Ingredient.fromTag(ItemTags.PLANKS))
                .input('S', Items.STICK)
                .criterion(RecipeProvider.hasItem(Items.STICK), RecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(consumer, new Identifier(getRecipeName(ModBlocks.CARPENTER)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.STONE, 16)
                .pattern("   ")
                .pattern(" U ")
                .pattern("   ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "stone_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.GLASS, 32)
                .pattern(" U ")
                .pattern("U U")
                .pattern(" U ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "glass_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.GRASS_BLOCK, 16)
                .pattern("   ")
                .pattern("U  ")
                .pattern("U  ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "grass_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.MOSSY_COBBLESTONE, 16)
                .pattern("   ")
                .pattern(" U ")
                .pattern("U U")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "mossy_cobblestone_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.SAND, 16)
                .pattern("   ")
                .pattern("  U")
                .pattern(" U ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "sand_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.SNOW_BLOCK, 4)
                .pattern("U U")
                .pattern("   ")
                .pattern("   ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "snow_block_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.IRON_ORE, 2)
                .pattern("U U")
                .pattern(" U ")
                .pattern("U U")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "iron_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.GOLD_ORE, 2)
                .pattern(" U ")
                .pattern("UUU")
                .pattern(" U ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "gold_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.OBSIDIAN, 12)
                .pattern("U U")
                .pattern("U U")
                .pattern("   ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "obsidian_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.NETHERRACK, 16)
                .pattern("  U")
                .pattern(" U ")
                .pattern("U  ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "nether-rack_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.GLOWSTONE, 8)
                .pattern(" U ")
                .pattern("U U")
                .pattern("UUU")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "glowstone_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.OAK_LOG, 8)
                .pattern(" UU")
                .pattern("   ")
                .pattern("   ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "oak_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.CACTUS, 48)
                .pattern(" U ")
                .pattern("UUU")
                .pattern("U U")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "cactus_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.VINE, 24)
                .pattern("U  ")
                .pattern("U  ")
                .pattern("U  ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "vine_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.WHITE_WOOL, 12)
                .pattern("U U")
                .pattern("   ")
                .pattern(" U ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "wool_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COAL, 20)
                .pattern("  U")
                .pattern("U  ")
                .pattern("  U")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "coal_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.DIAMOND, 1)
                .pattern("UUU")
                .pattern("UUU")
                .pattern("UUU")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "diamond_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.REDSTONE, 24)
                .pattern("   ")
                .pattern(" U ")
                .pattern("UUU")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "redstone_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.LAPIS_LAZULI, 9)
                .pattern(" U ")
                .pattern(" U ")
                .pattern(" UU")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "lapis_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.FEATHER, 32)
                .pattern(" U ")
                .pattern(" U ")
                .pattern("U U")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "feather_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SNOWBALL, 16)
                .pattern("   ")
                .pattern("   ")
                .pattern("UUU")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "snowball_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GUNPOWDER, 15)
                .pattern("UUU")
                .pattern("U  ")
                .pattern("UUU")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "gunpowder_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.CLAY_BALL, 48)
                .pattern("UU ")
                .pattern("U  ")
                .pattern("UU ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "clay_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COCOA_BEANS, 32)
                .pattern("UU ")
                .pattern("  U")
                .pattern("UU ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "cocoa_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.INK_SAC, 48)
                .pattern(" UU")
                .pattern(" UU")
                .pattern(" U ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "ink_sac_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR_CANE, 48)
                .pattern("U U")
                .pattern("U U")
                .pattern("U U")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "sugar_cane_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.FLINT, 32)
                .pattern(" U ")
                .pattern("UU ")
                .pattern("UU ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "flint_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.BONE, 32)
                .pattern("U  ")
                .pattern("UU ")
                .pattern("U  ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "bone_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.MYCELIUM, 24)
                .pattern("U U")
                .pattern("   ")
                .pattern("U U")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "mycelium_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.CHISELED_STONE_BRICKS, 48)
                .pattern("UU ")
                .pattern("UU ")
                .pattern("   ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "chiselled_stone_bricks_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.COPPER_ORE, 5)
                .pattern("  U")
                .pattern("U U")
                .pattern("   ")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(CustomMods.MOD_ID, "copper_ore_from_uumatter"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_ORE, 5)
                .pattern("   ")
                .pattern("U U")
                .pattern("  U")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(getRecipeName(ModBlocks.TIN_ORE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.STICKY_RESIN, 21)
                .pattern("U U")
                .pattern("   ")
                .pattern("U U")
                .input('U', ModItems.UUMATTER)
                .criterion(RecipeProvider.hasItem(ModItems.UUMATTER), RecipeProvider.conditionsFromItem(ModItems.UUMATTER))
                .offerTo(consumer, new Identifier(getRecipeName(ModItems.STICKY_RESIN)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MASS_FABRICATOR, 1)
                .pattern("DDD")
                .pattern("III")
                .pattern("EQE")
                .input('D', Items.DIAMOND)
                .input('I', Items.IRON_BLOCK)
                .input('E', Items.EMERALD_BLOCK)
                .input('Q', Items.QUARTZ_BLOCK)
                .criterion(RecipeProvider.hasItem(Items.DIAMOND), RecipeProvider.conditionsFromItem(Items.DIAMOND))
                .offerTo(consumer, new Identifier(getRecipeName( ModBlocks.MASS_FABRICATOR)));
    }

}
