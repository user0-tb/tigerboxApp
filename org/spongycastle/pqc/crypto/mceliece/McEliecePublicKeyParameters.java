package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters extends McElieceKeyParameters {

    /* renamed from: g */
    private GF2Matrix f1397g;

    /* renamed from: n */
    private int f1398n;
    private String oid;

    /* renamed from: t */
    private int f1399t;

    public McEliecePublicKeyParameters(String str, int i, int i2, GF2Matrix gF2Matrix, McElieceParameters mcElieceParameters) {
        super(false, mcElieceParameters);
        this.oid = str;
        this.f1398n = i;
        this.f1399t = i2;
        this.f1397g = new GF2Matrix(gF2Matrix);
    }

    public McEliecePublicKeyParameters(String str, int i, int i2, byte[] bArr, McElieceParameters mcElieceParameters) {
        super(false, mcElieceParameters);
        this.oid = str;
        this.f1398n = i2;
        this.f1399t = i;
        this.f1397g = new GF2Matrix(bArr);
    }

    public int getN() {
        return this.f1398n;
    }

    public int getT() {
        return this.f1399t;
    }

    public GF2Matrix getG() {
        return this.f1397g;
    }

    public String getOIDString() {
        return this.oid;
    }

    public int getK() {
        return this.f1397g.getNumRows();
    }
}
