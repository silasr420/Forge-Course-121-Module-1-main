package net.silas.mccourse.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.mccourse.MCCourseMod;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = ResourceLocation.parse("block/nether_portal");
    public static final ResourceLocation WATER_FLOWING_RL = ResourceLocation.parse("block/nether_portal");
    public static final ResourceLocation WATER_OVERLAY_RL = ResourceLocation.parse("block/nether_portal");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, MCCourseMod.MOD_ID);

    public static final RegistryObject<FluidType> NETHER_FLUID_TYPE = registerFluidType("nether_portal_fluid",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL, 0xFFFFFF,
                    new Vector3f(0.40784313f, 0.1372549f, 0.6392157f),
                    FluidType.Properties.create().viscosity(10).canConvertToSource(true).canSwim(false).motionScale(0.1f)));

    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType){
        return FLUID_TYPES.register(name, () -> fluidType);
    }


    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }
}
