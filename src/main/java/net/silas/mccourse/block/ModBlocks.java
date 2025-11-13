package net.silas.mccourse.block;

import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.block.custom.AzuriteLampBlock;
import net.silas.mccourse.block.custom.MagicBlock;
import net.silas.mccourse.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MCCourseMod.MOD_ID);

    public static final RegistryObject<Block> AZURITE_BLOCK = registerBlock("azurite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> AZURITE_ORE = registerBlock("azurite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> AZURITE_DEEPSLATE_ORE = registerBlock("azurite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3, 7),
                    BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> AZURITE_END_ORE = registerBlock("azurite_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(5, 9),
                    BlockBehaviour.Properties.of().strength(7f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> AZURITE_NETHER_ORE = registerBlock("azurite_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 5),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));

    public static final RegistryObject<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of().strength(0.2f)));

    public static final RegistryObject<Block> AZURITE_STAIRS = registerBlock("azurite_stairs",
            () -> new StairBlock(ModBlocks.AZURITE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURITE_SLAB = registerBlock("azurite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURITE_PRESSURE_PLATE = registerBlock("azurite_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.of().strength(0.6f)));
    public static final RegistryObject<Block> AZURITE_BUTTON = registerBlock("azurite_button",
            () -> new ButtonBlock(BlockSetType.STONE, 10, BlockBehaviour.Properties.of().strength(0.2f).noCollission()));


    public static final RegistryObject<Block> AZURITE_FENCE = registerBlock("azurite_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURITE_FENCE_GATE = registerBlock("azurite_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> AZURITE_WALL = registerBlock("azurite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> AZURITE_DOOR = registerBlock("azurite_door",
            () -> new DoorBlock(BlockSetType.POLISHED_BLACKSTONE, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> AZURITE_TRAPDOOR = registerBlock("azurite_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.POLISHED_BLACKSTONE, BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> AZURITE_LAMP = registerBlock("azurite_lamp",
            () -> new AzuriteLampBlock(BlockBehaviour.Properties.of().strength(1.5f).sound(SoundType.GLASS)
                    .lightLevel(state -> state.getValue(AzuriteLampBlock.CLICKED) ? 15 : 0)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
