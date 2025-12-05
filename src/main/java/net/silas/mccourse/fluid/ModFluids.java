package net.silas.mccourse.fluid;

import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.block.ModBlocks;
import net.silas.mccourse.item.ModItems;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, MCCourseMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_NETHER_FLUID = FLUIDS.register("source_nether_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.NETHER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_NETHER_FLUID = FLUIDS.register("flowing_nether_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.NETHER_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties NETHER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.NETHER_FLUID_TYPE, SOURCE_NETHER_FLUID, FLOWING_NETHER_FLUID).slopeFindDistance(2).levelDecreasePerBlock(1)
            .block(() -> ModFluids.NETHER_FLUID_BLOCK.get())
            .bucket(() -> ModFluids.NETHER_FLUID_BUCKET.get());

    public static final RegistryObject<Item> NETHER_FLUID_BUCKET = ModItems.ITEMS.register("nether_fluid_bucket",
            () -> new BucketItem(ModFluids.SOURCE_NETHER_FLUID.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<LiquidBlock> NETHER_FLUID_BLOCK = ModBlocks.BLOCKS.register("nether_fluid_block",
            () -> new LiquidBlock(ModFluids.SOURCE_NETHER_FLUID.get(), BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).noLootTable()));



    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
