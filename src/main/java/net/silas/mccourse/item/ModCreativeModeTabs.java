package net.silas.mccourse.item;

import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCCourseMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> AZURITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("azurite_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AZURITE.get()))
                    .title(Component.translatable("creativetab.azurite_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AZURITE.get());
                        output.accept(ModItems.RAW_AZURITE.get());

                        output.accept(ModItems.CHAINSAW.get());
                        output.accept(ModItems.ONION.get());

                        output.accept(ModItems.AURORA_ASHES.get());

                        output.accept(ModItems.AZURITE_SWORD.get());
                        output.accept(ModItems.AZURITE_PICKAXE.get());
                        output.accept(ModItems.AZURITE_SHOVEL.get());
                        output.accept(ModItems.AZURITE_AXE.get());
                        output.accept(ModItems.AZURITE_HOE.get());

                        output.accept(ModItems.AZURITE_PAXEL.get());
                        output.accept(ModItems.AZURITE_HAMMER.get());

                        output.accept(ModItems.AZURITE_HELMET.get());
                        output.accept(ModItems.AZURITE_CHESTPLATE.get());
                        output.accept(ModItems.AZURITE_LEGGINGS.get());
                        output.accept(ModItems.AZURITE_BOOTS.get());

                        output.accept(ModItems.AZURITE_HORSE_ARMOR.get());
                        output.accept(ModItems.DECIBEL_SMITHING_TEMPLATE.get());

                        output.accept(ModItems.TRIAL_DETECTOR.get());
                        output.accept(ModItems.DATA_TABLET.get());

                        output.accept(ModItems.TNT_BOW.get());
                        output.accept(ModItems.TNT_ARROW.get());

                        output.accept(ModItems.ONION_SEEDS.get());

                        output.accept(ModItems.UP_HOUSETOP_MUSIC_DISC.get());

                        output.accept(ModItems.ICE_STAFF.get());


                        output.accept(ModBlocks.AZURITE_BLOCK.get());

                        output.accept(ModBlocks.AZURITE_ORE.get());
                        output.accept(ModBlocks.AZURITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.AZURITE_END_ORE.get());
                        output.accept(ModBlocks.AZURITE_NETHER_ORE.get());

                        output.accept(ModBlocks.MAGIC_BLOCK.get());

                        output.accept(ModBlocks.AZURITE_STAIRS.get());
                        output.accept(ModBlocks.AZURITE_SLAB.get());

                        output.accept(ModBlocks.AZURITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.AZURITE_BUTTON.get());

                        output.accept(ModBlocks.AZURITE_FENCE.get());
                        output.accept(ModBlocks.AZURITE_FENCE_GATE.get());
                        output.accept(ModBlocks.AZURITE_WALL.get());

                        output.accept(ModBlocks.AZURITE_DOOR.get());
                        output.accept(ModBlocks.AZURITE_TRAPDOOR.get());

                        output.accept(ModBlocks.AZURITE_LAMP.get());

                        output.accept(ModBlocks.BLUEBELL.get());

                        output.accept(ModBlocks.COLORED_LEAVES.get());

                        output.accept(ModBlocks.SMOOTH_STONE_WALL.get());
                        output.accept(ModBlocks.PEDESTAL.get());





                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
