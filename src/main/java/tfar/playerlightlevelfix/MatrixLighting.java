//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package tfar.playerlightlevelfix;

import net.minecraft.util.math.vector.Matrix4f;
import net.minecraftforge.fml.common.Mod;

@Mod("playerlightlevelfix")
public class MatrixLighting {
    public MatrixLighting() {
    }

    public static Matrix4f getOn() {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.setIdentity();
        matrix4f.mul(Matrix4f.makeScale(5.0F, -1.5F, 0.8F));
        return matrix4f;
    }

    public static Matrix4f getOff() {
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.setIdentity();
        matrix4f.mul(Matrix4f.makeScale(3.0F, -1.0F, 2.0F));
        return matrix4f;
    }
}
