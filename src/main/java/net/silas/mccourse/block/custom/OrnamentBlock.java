package net.silas.mccourse.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OrnamentBlock extends Block {

    public static final IntegerProperty COUNT = IntegerProperty.create("count", 1, 4);

    public OrnamentBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(COUNT, 1));
    }

    // --- Stack ornaments like candles ---
    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        // Prevent stacking while sneaking
        if (context.isSecondaryUseActive()) return false;

        ItemStack stack = context.getItemInHand();

        // Allow stacking if holding the same ornament and count < 4
        if (stack.getItem() == this.asItem() && state.getValue(COUNT) < 4) {
            return true;
        }

        return super.canBeReplaced(state, context);
    }

    // --- When placing an ornament, increase count if already present ---
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState existing = level.getBlockState(pos);

        // 1. --- If placing onto an existing ornament, always stack ---
        if (existing.is(this)) {
            int c = existing.getValue(COUNT);
            return existing.setValue(COUNT, Math.min(4, c + 1));
        }

        // 2. --- Normal placement: only allowed on underside of leaves ---
        Direction face = context.getClickedFace();

        // The block ABOVE the placement spot MUST be leaves
        BlockPos above = pos.above();
        BlockState aboveState = level.getBlockState(above);

        if (face != Direction.DOWN || !aboveState.is(BlockTags.LEAVES)) {
            return null; // placement fails
        }

        // 3. --- Place the first ornament ---
        return this.defaultBlockState().setValue(COUNT, 1);
    }


    // --- Optional: interaction when right-clicking (not needed unless you want behavior) ---
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hit) {
        // If you want features (like removing 1 ornament), tell me.
        return super.useItemOn(stack, state, level, pos, player, hand, hit);
    }

    // --- Register the blockstate properties ---
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COUNT);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        int c = state.getValue(COUNT);

        return switch (c) {
            case 1 -> Block.box(5, 10, 5, 11, 16, 11); // small
            case 2 -> Block.box(4, 10, 4, 12, 16, 12); // slightly bigger
            case 3 -> Block.box(3, 10, 3, 13, 16, 13); // bigger
            case 4 -> Block.box(2, 10, 2, 14, 16, 14); // biggest cluster
            default -> Block.box(5, 10, 5, 11, 16, 11);
        };
    }


    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor level, BlockPos pos, BlockPos neighborPos) {

        // If the block ABOVE changed…
        if (direction == Direction.UP) {
            // …and it's no longer leaves, break the ornament
            if (!neighborState.is(BlockTags.LEAVES)) {
                return Blocks.AIR.defaultBlockState(); // destroy block
            }
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

}
