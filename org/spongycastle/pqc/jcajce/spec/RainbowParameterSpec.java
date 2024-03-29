package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.util.Arrays;

public class RainbowParameterSpec implements AlgorithmParameterSpec {
    private static final int[] DEFAULT_VI = {6, 12, 17, 22, 33};

    /* renamed from: vi */
    private int[] f1490vi;

    public RainbowParameterSpec() {
        this.f1490vi = DEFAULT_VI;
    }

    public RainbowParameterSpec(int[] iArr) {
        this.f1490vi = iArr;
        try {
            checkParams();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkParams() throws Exception {
        int[] iArr;
        int i;
        int[] iArr2 = this.f1490vi;
        if (iArr2 == null) {
            throw new IllegalArgumentException("no layers defined.");
        } else if (iArr2.length > 1) {
            int i2 = 0;
            do {
                iArr = this.f1490vi;
                if (i2 < iArr.length - 1) {
                    i = iArr[i2];
                    i2++;
                } else {
                    return;
                }
            } while (i < iArr[i2]);
            throw new IllegalArgumentException("v[i] has to be smaller than v[i+1]");
        } else {
            throw new IllegalArgumentException("Rainbow needs at least 1 layer, such that v1 < v2.");
        }
    }

    public int getNumOfLayers() {
        return this.f1490vi.length - 1;
    }

    public int getDocumentLength() {
        int[] iArr = this.f1490vi;
        return iArr[iArr.length - 1] - iArr[0];
    }

    public int[] getVi() {
        return Arrays.clone(this.f1490vi);
    }
}
