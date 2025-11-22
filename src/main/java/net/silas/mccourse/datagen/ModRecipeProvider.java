package net.silas.mccourse.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.block.ModBlocks;
import net.silas.mccourse.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.silas.mccourse.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> AZURITE_SMELTABLES = List.of(ModItems.RAW_AZURITE.get(),
                ModBlocks.AZURITE_ORE.get(), ModBlocks.AZURITE_DEEPSLATE_ORE.get(), ModBlocks.AZURITE_END_ORE.get(), ModBlocks.AZURITE_NETHER_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern(" H ")
                .pattern("HAH")
                .pattern(" H ")
                .define('A', ModBlocks.AZURITE_BLOCK.get())
                .define('H', ModItems.AURORA_ASHES.get())
                .unlockedBy("has_aurora_ashes", has(ModItems.AURORA_ASHES.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHAINSAW.get())
                .pattern("  I")
                .pattern("OI ")
                .pattern("AO ")
                .define('A', ModItems.AZURITE.get())
                .define('O', Items.ORANGE_DYE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.AZURITE_SWORD.get())
                .pattern(" A ")
                .pattern(" A ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZURITE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZURITE_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZURITE_AXE.get())
                .pattern("AA ")
                .pattern("AS ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZURITE_HOE.get())
                .pattern("AA ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.AZURITE.get(), 9)
                .requires(ModBlocks.AZURITE_BLOCK.get())
                .unlockedBy("has_azurite_block", has(ModBlocks.AZURITE_BLOCK.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZURITE_PAXEL.get())
                .pattern("PAH")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AZURITE_AXE.get())
                .define('P', ModItems.AZURITE_PICKAXE.get())
                .define('H', ModItems.AZURITE_SHOVEL.get())
                .define('S', Items.STICK)
                .unlockedBy("has_heavy_core", has(Items.HEAVY_CORE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.AZURITE_HAMMER.get())
                .pattern("AHA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModBlocks.AZURITE_BLOCK.get())
                .define('S', Items.STICK)
                .define('H', Items.HEAVY_CORE)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("   ")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AZURITE_BOOTS.get())
                .pattern("   ")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.AZURITE.get())
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DECIBEL_SMITHING_TEMPLATE.get(), 2)
                .pattern("DSD")
                .pattern("DND")
                .pattern("DDD")
                .define('S', ModItems.DECIBEL_SMITHING_TEMPLATE.get())
                .define('D', Items.DIAMOND)
                .define('N', Items.NOTE_BLOCK)
                .unlockedBy("has_decibel_smithing_template", has(ModItems.DECIBEL_SMITHING_TEMPLATE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.AZURITE_LAMP.get())
                .pattern(" A ")
                .pattern("AGA")
                .pattern(" A ")
                .define('A', ModItems.AZURITE.get())
                .define('G', Items.GLOWSTONE)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DATA_TABLET.get())
                .pattern(" I ")
                .pattern("IGI")
                .pattern(" I ")
                .define('I', Items.IRON_INGOT)
                .define('G', Items.GLASS_PANE)
                .unlockedBy("has_glass_pane", has(Items.GLASS_PANE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRIAL_DETECTOR.get())
                .pattern(" SM")
                .pattern(" SS")
                .pattern("I  ")
                .define('I', Items.IRON_INGOT)
                .define('S', Items.STICK)
                .define('M', Items.TRIAL_KEY)
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.TNT_BOW.get())
                .pattern("NTN")
                .pattern("TBT")
                .pattern("NTN")
                .define('T', Items.TNT)
                .define('B', Items.BOW)
                .define('N', Items.NETHERITE_SCRAP)
                .unlockedBy("has_tnt", has(Items.BOW)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TNT_ARROW.get(), 4)
                .pattern(" A ")
                .pattern("ATA")
                .pattern(" A ")
                .define('T', Items.TNT)
                .define('A', Items.ARROW)
                .unlockedBy("has_tnt", has(Items.BOW)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SMOOTH_STONE_WALL.get(), 6)
                .pattern("   ")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', Blocks.SMOOTH_STONE)
                .unlockedBy("has_smooth_stone", has(Items.SMOOTH_STONE)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PEDESTAL.get(), 1)
                .pattern(" S ")
                .pattern(" W ")
                .pattern("SSS")
                .define('S', Blocks.SMOOTH_STONE_SLAB)
                .define('W', ModBlocks.SMOOTH_STONE_WALL.get())
                .unlockedBy("has_smooth_stone_slab", has(Items.SMOOTH_STONE_SLAB)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PURPLE_DYE)
                .requires(ModBlocks.BLUEBELL.get())
                .unlockedBy("has_bluebell", has(ModBlocks.BLUEBELL.get())).save(recipeOutput);






        oreSmelting(recipeOutput, AZURITE_SMELTABLES, RecipeCategory.MISC, ModItems.AZURITE.get(), 0.25f, 200, "azurite");
        oreBlasting(recipeOutput, AZURITE_SMELTABLES, RecipeCategory.MISC, ModItems.AZURITE.get(), 0.25f, 100, "azurite");

        trimSmithing(recipeOutput, ModItems.DECIBEL_SMITHING_TEMPLATE.get(),
                ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "decibel"));

        stairBuilder(ModBlocks.AZURITE_STAIRS.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                        .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_SLAB.get(), ModItems.AZURITE.get());

        buttonBuilder(ModBlocks.AZURITE_BUTTON.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.AZURITE_PRESSURE_PLATE.get(), ModItems.AZURITE.get());

        fenceBuilder(ModBlocks.AZURITE_FENCE.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.AZURITE_FENCE_GATE.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZURITE_WALL.get(), ModItems.AZURITE.get());

        doorBuilder(ModBlocks.AZURITE_DOOR.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.AZURITE_TRAPDOOR.get(), Ingredient.of(ModItems.AZURITE.get())).group("azurite")
                .unlockedBy("has_azurite", has(ModItems.AZURITE.get())).save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MCCourseMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
