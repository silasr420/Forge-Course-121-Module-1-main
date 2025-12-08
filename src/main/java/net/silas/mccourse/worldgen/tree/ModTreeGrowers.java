package net.silas.mccourse.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.silas.mccourse.MCCourseMod;
import net.silas.mccourse.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower ASPEN = new TreeGrower(MCCourseMod.MOD_ID + ":aspen",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ASPEN_KEY), Optional.empty());
}
