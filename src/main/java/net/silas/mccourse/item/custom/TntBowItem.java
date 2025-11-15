package net.silas.mccourse.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.silas.mccourse.entity.custom.ImpactTnt;
import net.silas.mccourse.item.ModItems;
import net.silas.mccourse.util.ModTags;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class TntBowItem extends BowItem {
    public TntBowItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected void shootProjectile(
            LivingEntity shooter, Projectile vanillaProjectile, int index,
            float velocity, float inaccuracy, float angle, @Nullable LivingEntity target
    ) {
        if (!shooter.level().isClientSide) {

            // Remove the vanilla arrow
            vanillaProjectile.discard();

            // Spawn primed TNT
            PrimedTnt tnt = new ImpactTnt(
                    shooter.level(),
                    shooter.getX(),
                    shooter.getEyeY() - 0.1,
                    shooter.getZ(),
                    shooter
            );

            // Fire it like a projectile
            Vec3 dir = shooter.getLookAngle()
                    .yRot((float) Math.toRadians(angle))
                    .normalize()
                    .scale(velocity * 0.5f);

            tnt.setDeltaMovement(dir);

            shooter.level().addFreshEntity(tnt);
        }
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return stack -> stack.is(ModItems.TNT_ARROW.get());
    }

    @Override
    public int getDefaultProjectileRange() {
        return 1;
    }

}
