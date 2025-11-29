package net.silas.mccourse.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;

public class FestiveEffect extends MobEffect {
    public FestiveEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (!(entity.level() instanceof ServerLevel level)) {
            return true;
        }

        BlockPos center = entity.blockPosition();
        int radius = 2;

        for (BlockPos pos : BlockPos.betweenClosed(
                center.offset(-radius, -1, -radius),
                center.offset(radius, 1, radius))) {

            BlockPos above = pos.above();

            // Only place snow if the block can hold it
            if (level.isEmptyBlock(above)
                    && level.getBlockState(pos).isFaceSturdy(level, pos, Direction.UP)) {

                if (Blocks.SNOW.defaultBlockState().canSurvive(level, above)) {
                    level.setBlock(above, Blocks.SNOW.defaultBlockState(), 2);
                }
            }
        }

        // Snowflake particles
        level.sendParticles(ParticleTypes.SNOWFLAKE,
                entity.getX(), entity.getY() + 3, entity.getZ(),
                20, 1.5, 1.0, 1.5, 0.01);

        return true; // tells Minecraft the effect ran
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }

}

