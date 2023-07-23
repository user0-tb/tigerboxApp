package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKeySpec implements KeySpec {
    private GF2Matrix matrixG;

    /* renamed from: n */
    private int f1480n;
    private String oid;

    /* renamed from: t */
    private int f1481t;

    public McElieceCCA2PublicKeySpec(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.f1480n = i;
        this.f1481t = i2;
        this.matrixG = new GF2Matrix(gF2Matrix);
    }

    public McElieceCCA2PublicKeySpec(String str, int i, int i2, byte[] bArr) {
        this.oid = str;
        this.f1480n = i;
        this.f1481t = i2;
        this.matrixG = new GF2Matrix(bArr);
    }

    public int getN() {
        return this.f1480n;
    }

    public int getT() {
        return this.f1481t;
    }

    public GF2Matrix getMatrixG() {
        return this.matrixG;
    }

    public String getOIDString() {
        return this.oid;
    }
}
