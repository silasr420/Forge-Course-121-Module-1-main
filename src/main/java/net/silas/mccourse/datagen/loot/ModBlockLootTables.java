package net.silas.mccourse.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.fml.common.Mod;
import net.silas.mccourse.block.custom.OrnamentBlock;
import net.silas.mccourse.block.ModBlocks;
import net.silas.mccourse.block.custom.OnionCropBlock;
import net.silas.mccourse.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), provider);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.AZURITE_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());

        this.add(ModBlocks.AZURITE_ORE.get(),
                block -> createOreDrop(ModBlocks.AZURITE_ORE.get(), ModItems.RAW_AZURITE.get()));
        this.add(ModBlocks.AZURITE_DEEPSLATE_ORE.get(),
                block -> createOreDrop(ModBlocks.AZURITE_DEEPSLATE_ORE.get(), ModItems.RAW_AZURITE.get()));
        this.add(ModBlocks.AZURITE_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.AZURITE_END_ORE.get(), ModItems.RAW_AZURITE.get(), 4, 8));
        this.add(ModBlocks.AZURITE_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.AZURITE_NETHER_ORE.get(), ModItems.RAW_AZURITE.get(), 1, 6));

        this.dropSelf(ModBlocks.AZURITE_STAIRS.get());
        this.add(ModBlocks.AZURITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.AZURITE_SLAB.get()));

        this.dropSelf(ModBlocks.AZURITE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.AZURITE_BUTTON.get());

        this.dropSelf(ModBlocks.AZURITE_FENCE.get());
        this.dropSelf(ModBlocks.AZURITE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.AZURITE_WALL.get());
        this.dropSelf(ModBlocks.SMOOTH_STONE_WALL.get());
        this.dropSelf(ModBlocks.AZURITE_TRAPDOOR.get());

        this.dropSelf(ModBlocks.AZURITE_LAMP.get());

        this.add(ModBlocks.AZURITE_DOOR.get(),
                block -> createDoorTable(ModBlocks.AZURITE_DOOR.get()));

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.ONION_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 3));
        this.add(ModBlocks.ONION_CROP.get(), this.createCropDrops(ModBlocks.ONION_CROP.get(),
                ModItems.ONION.get(), ModItems.ONION_SEEDS.get(), lootItemConditionBuilder));

        this.dropSelf(ModBlocks.BLUEBELL.get());
        this.add(ModBlocks.POTTED_BLUEBELL.get(),
                createPotFlowerItemTable(ModBlocks.BLUEBELL.get()));

        this.dropSelf(ModBlocks.COLORED_LEAVES.get());

        this.dropSelf(ModBlocks.PEDESTAL.get());

        this.add(ModBlocks.ORNAMENT.get(), block -> {
            LootPool.Builder pool = LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1));

            // Loop through possible ornament counts (1–4)
            for (int i = 1; i <= 4; i++) {
                pool.add(
                        LootItem.lootTableItem(ModBlocks.ORNAMENT.get())
                                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(i)))
                                .when(
                                        LootItemBlockStatePropertyCondition
                                                .hasBlockStateProperties(block)
                                                .setProperties(
                                                        StatePropertiesPredicate.Builder.properties()
                                                                .hasProperty(OrnamentBlock.COUNT, i)
                                                )
                                )
                );
            }

            return LootTable.lootTable().withPool(pool);
        });

        this.dropSelf(ModBlocks.CHRISTMAS_LIGHTS_COLORED.get());
        this.dropSelf(ModBlocks.CHRISTMAS_LIGHTS_WHITE.get());

        this.dropSelf(ModBlocks.CRYSTALLIZER.get());

        this.dropSelf(ModBlocks.ASPEN_LOG.get());
        this.dropSelf(ModBlocks.ASPEN_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ASPEN_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ASPEN_WOOD.get());
        this.dropSelf(ModBlocks.ASPEN_PLANKS.get());

        this.dropSelf(ModBlocks.ASPEN_SAPLING.get());
        this.add(ModBlocks.ASPEN_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.ASPEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.NETHER_CRYSTAL.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
