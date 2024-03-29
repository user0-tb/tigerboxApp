package org.spongycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceCCA2PrivateKeySpec implements KeySpec {
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;

    /* renamed from: h */
    private GF2Matrix f1476h;

    /* renamed from: k */
    private int f1477k;

    /* renamed from: n */
    private int f1478n;
    private String oid;

    /* renamed from: p */
    private Permutation f1479p;
    private PolynomialGF2mSmallM[] qInv;

    public McElieceCCA2PrivateKeySpec(String str, int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, Permutation permutation, GF2Matrix gF2Matrix, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        this.oid = str;
        this.f1478n = i;
        this.f1477k = i2;
        this.field = gF2mField;
        this.goppaPoly = polynomialGF2mSmallM;
        this.f1479p = permutation;
        this.f1476h = gF2Matrix;
        this.qInv = polynomialGF2mSmallMArr;
    }

    public McElieceCCA2PrivateKeySpec(String str, int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[][] bArr5) {
        this.oid = str;
        this.f1478n = i;
        this.f1477k = i2;
        this.field = new GF2mField(bArr);
        this.goppaPoly = new PolynomialGF2mSmallM(this.field, bArr2);
        this.f1479p = new Permutation(bArr3);
        this.f1476h = new GF2Matrix(bArr4);
        this.qInv = new PolynomialGF2mSmallM[bArr5.length];
        for (int i3 = 0; i3 < bArr5.length; i3++) {
            this.qInv[i3] = new PolynomialGF2mSmallM(this.field, bArr5[i3]);
        }
    }

    public int getN() {
        return this.f1478n;
    }

    public int getK() {
        return this.f1477k;
    }

    public GF2mField getField() {
        return this.field;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public Permutation getP() {
        return this.f1479p;
    }

    public GF2Matrix getH() {
        return this.f1476h;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }

    public String getOIDString() {
        return this.oid;
    }
}
