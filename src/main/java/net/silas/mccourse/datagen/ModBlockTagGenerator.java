package net.silas.mccourse.datagen;

import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.silas.mccourse.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MCCourseMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AZURITE_BLOCK.get())
                .add(ModBlocks.AZURITE_ORE.get())
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.AZURITE_END_ORE.get())
                .add(ModBlocks.AZURITE_NETHER_ORE.get())
                .add(ModBlocks.AZURITE_STAIRS.get())
                .add(ModBlocks.AZURITE_SLAB.get())
                .add(ModBlocks.AZURITE_BUTTON.get())
                .add(ModBlocks.AZURITE_DOOR.get())
                .add(ModBlocks.AZURITE_TRAPDOOR.get())
                .add(ModBlocks.AZURITE_FENCE.get())
                .add(ModBlocks.AZURITE_FENCE_GATE.get())
                .add(ModBlocks.AZURITE_WALL.get())
                .add(ModBlocks.AZURITE_LAMP.get())
                .add(ModBlocks.AZURITE_PRESSURE_PLATE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.AZURITE_ORE.get())
                .add(ModBlocks.AZURITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.AZURITE_STAIRS.get())
                .add(ModBlocks.AZURITE_SLAB.get())
                .add(ModBlocks.AZURITE_DOOR.get())
                .add(ModBlocks.AZURITE_FENCE.get())
                .add(ModBlocks.AZURITE_FENCE_GATE.get())
                .add(ModBlocks.AZURITE_WALL.get())
                .add(ModBlocks.AZURITE_TRAPDOOR.get());


        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AZURITE_END_ORE.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.AZURITE_NETHER_ORE.get());


        this.tag(BlockTags.FENCES).add(ModBlocks.AZURITE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.AZURITE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.AZURITE_WALL.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_AXE);


    }
}
