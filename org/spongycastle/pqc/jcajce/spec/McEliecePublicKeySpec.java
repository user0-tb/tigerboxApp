package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeySpec implements KeySpec {

    /* renamed from: g */
    private GF2Matrix f1487g;

    /* renamed from: n */
    private int f1488n;
    private String oid;

    /* renamed from: t */
    private int f1489t;

    public McEliecePublicKeySpec(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.f1488n = i;
        this.f1489t = i2;
        this.f1487g = new GF2Matrix(gF2Matrix);
    }

    public McEliecePublicKeySpec(String str, int i, int i2, byte[] bArr) {
        this.oid = str;
        this.f1488n = i2;
        this.f1489t = i;
        this.f1487g = new GF2Matrix(bArr);
    }

    public int getN() {
        return this.f1488n;
    }

    public int getT() {
        return this.f1489t;
    }

    public GF2Matrix getG() {
        return this.f1487g;
    }

    public String getOIDString() {
        return this.oid;
    }
}
