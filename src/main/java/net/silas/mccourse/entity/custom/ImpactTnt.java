package net.silas.mccourse.entity.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class ImpactTnt extends PrimedTnt {
    public ImpactTnt(Level pLevel, double pX, double pY, double pZ, @Nullable LivingEntity pOwner) {
        super(pLevel, pX, pY, pZ, pOwner);
    }

    @Override
    public void tick() {
        super.tick();

        if (this.onGround() || this.horizontalCollision) {
            explodeNow();
        }
    }

    private void explodeNow() {
        if (!this.level().isClientSide) {
            this.level().explode(
                    this,
                    this.getX(),
                    this.getY(),
                    this.getZ(),
                    4.0f,
                    Level.ExplosionInteraction.TNT
            );
            this.discard();
        }
    }
}
