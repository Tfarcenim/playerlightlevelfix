//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tfar.playerlightlevelfix.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import tfar.playerlightlevelfix.MatrixLighting;

@Mixin({InventoryScreen.class})
public class InventoryScreenMixin {
    public InventoryScreenMixin() {
    }

    @Inject(
            at = {@At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/systems/RenderSystem;pushMatrix()V",
                    shift = Shift.AFTER,
                    ordinal = 0
            )},
            method = {"drawEntityOnScreen"}
    )
    private static void fixDrawEntityLighting1(int p_228187_0_, int p_228187_1_, int p_228187_2_, float p_228187_3_, float p_228187_4_, LivingEntity p_228187_5_, CallbackInfo ci) {
        on();
    }

    @Unique
    private static void on() {
        RenderSystem.assertThread(RenderSystem::isOnRenderThread);
        RenderHelper.setupLevelDiffuseLighting(MatrixLighting.getOn());
    }

    @Inject(
            at = {@At(
                    value = "INVOKE",
                    target = "Lcom/mojang/blaze3d/systems/RenderSystem;popMatrix()V",
                    shift = Shift.AFTER,
                    ordinal = 0
            )},
            method = "drawEntityOnScreen"
    )
    private static void fixDrawEntityLighting2(int p_228187_0_, int p_228187_1_, int p_228187_2_, float p_228187_3_, float p_228187_4_, LivingEntity p_228187_5_, CallbackInfo ci) {
        off();
    }

    @Unique
    private static void off() {
        RenderSystem.assertThread(RenderSystem::isOnRenderThread);
        RenderHelper.setupLevelDiffuseLighting(MatrixLighting.getOff());
    }
}
