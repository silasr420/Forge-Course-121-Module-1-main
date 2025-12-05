package net.silas.mccourse.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.block.ModBlocks;
import net.silas.mccourse.sound.ModSounds;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, MCCourseMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, MCCourseMod.MOD_ID);

    public static final RegistryObject<PoiType> CAMP_POI = POI_TYPES.register("camp_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.HONEYCOMB_BLOCK.getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> BEEKEEPER =
            VILLAGER_PROFESSIONS.register("beekeeper", () -> new VillagerProfession("beekeeper",
                    holder -> holder.get() == CAMP_POI.get(), holder -> holder.get() == CAMP_POI.get(), ImmutableSet.of(),
                    ImmutableSet.of(), SoundType.HONEY_BLOCK.getBreakSound()));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }



}
