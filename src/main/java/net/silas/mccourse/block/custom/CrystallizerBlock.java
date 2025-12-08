package net.silas.mccourse.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.silas.mccourse.datagen.ModItemModelProvider;
import net.silas.mccourse.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class CrystallizerBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<CrystallizerBlock> CODEC = simpleCodec(CrystallizerBlock::new);

    public CrystallizerBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        double xPos = pPos.getX() + 0.5f;
        double yPos = pPos.getY() + 1.25f;
        double zPos = pPos.getZ() + 0.5f;
        double offset = pRandom.nextDouble() * 0.6 - 0.3;

        pLevel.addParticle(ParticleTypes.SMOKE, xPos + offset, yPos, zPos + offset, 0.0, 0.0, 0.0);
        pLevel.addParticle(new ItemParticleOption(ParticleTypes.ITEM, ModItems.AZURITE.get()
                .getDefaultInstance()), xPos + offset, yPos, zPos + offset, 0.0, 0.25, 0.0);
        pLevel.addParticle(new ItemParticleOption(ParticleTypes.ITEM, Items.AMETHYST_SHARD
                .getDefaultInstance()), xPos + offset, yPos, zPos + offset, 0.0, 0.25, 0.0);
        pLevel.addParticle(new ItemParticleOption(ParticleTypes.ITEM, Items.EMERALD
                .getDefaultInstance()), xPos + offset, yPos, zPos + offset, 0.0, 0.25, 0.0);
    }
}
