package net.silas.mccourse.datagen;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.block.ModBlocks;
import net.silas.mccourse.item.ModItems;
import net.silas.mccourse.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                               CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {


        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.AZURITE.get())
                .add(Items.COAL)
                .add(Items.POISONOUS_POTATO);

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.AZURITE_HELMET.get())
                .add(ModItems.AZURITE_CHESTPLATE.get())
                .add(ModItems.AZURITE_LEGGINGS.get())
                .add(ModItems.AZURITE_BOOTS.get());

        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.AZURITE_SWORD.get())
                .add(ModItems.AZURITE_PAXEL.get())
                .add(ModItems.AZURITE_HAMMER.get())
                .add(ModItems.AZURITE_PICKAXE.get())
                .add(ModItems.AZURITE_SHOVEL.get())
                .add(ModItems.AZURITE_AXE.get())
                .add(ModItems.AZURITE_HOE.get())
                .add(ModItems.AZURITE_HELMET.get())
                .add(ModItems.AZURITE_CHESTPLATE.get())
                .add(ModItems.AZURITE_LEGGINGS.get())
                .add(ModItems.AZURITE_BOOTS.get())
                .add(ModItems.TNT_BOW.get())
                .add(ModItems.CHAINSAW.get());

        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.AZURITE_SWORD.get());


        tag(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.AZURITE_HAMMER.get())
                .add(ModItems.AZURITE_PAXEL.get())
                .add(ModItems.AZURITE_PICKAXE.get())
                .add(ModItems.AZURITE_SHOVEL.get())
                .add(ModItems.AZURITE_AXE.get())
                .add(ModItems.AZURITE_HOE.get());

        tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.AZURITE_HAMMER.get())
                .add(ModItems.AZURITE_PAXEL.get())
                .add(ModItems.AZURITE_PICKAXE.get())
                .add(ModItems.AZURITE_SHOVEL.get())
                .add(ModItems.AZURITE_AXE.get())
                .add(ModItems.AZURITE_HOE.get());

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(ModItems.AZURITE_SWORD.get());

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(ModItems.AZURITE_AXE.get())
                .add(ModItems.AZURITE_SWORD.get());

        tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(ModItems.AZURITE_AXE.get())
                .add(ModItems.AZURITE_SWORD.get());

        tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.AZURITE_HELMET.get())
                .add(ModItems.AZURITE_CHESTPLATE.get())
                .add(ModItems.AZURITE_LEGGINGS.get())
                .add(ModItems.AZURITE_BOOTS.get());

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .add(ModItems.AZURITE_HELMET.get())
                .add(ModItems.AZURITE_CHESTPLATE.get())
                .add(ModItems.AZURITE_LEGGINGS.get())
                .add(ModItems.AZURITE_BOOTS.get());

        tag(ItemTags.VANISHING_ENCHANTABLE)
                .add(ModItems.AZURITE_HELMET.get())
                .add(ModItems.AZURITE_CHESTPLATE.get())
                .add(ModItems.AZURITE_LEGGINGS.get())
                .add(ModItems.AZURITE_BOOTS.get());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.AZURITE_HELMET.get());

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.AZURITE_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.AZURITE_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.AZURITE_BOOTS.get());

        tag(ItemTags.BOW_ENCHANTABLE)
                .add(ModItems.TNT_BOW.get());

        this.tag(ItemTags.TRIM_MATERIALS)
                .add(ModItems.AZURITE.get());

        this.tag(ItemTags.TRIM_TEMPLATES)
                .add(ModItems.DECIBEL_SMITHING_TEMPLATE.get());


        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.ASPEN_LOG.get().asItem())
                .add(ModBlocks.ASPEN_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ASPEN_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ASPEN_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.ASPEN_PLANKS.get().asItem());

        this.tag(ModTags.Items.ASPEN_LOGS)
                .add(ModBlocks.ASPEN_LOG.get().asItem())
                .add(ModBlocks.ASPEN_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_ASPEN_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_ASPEN_WOOD.get().asItem());
    }
}
