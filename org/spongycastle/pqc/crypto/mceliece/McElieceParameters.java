package org.spongycastle.pqc.crypto.mceliece;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class McElieceParameters implements CipherParameters {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private int fieldPoly;

    /* renamed from: m */
    private int f1385m;

    /* renamed from: n */
    private int f1386n;

    /* renamed from: t */
    private int f1387t;

    public McElieceParameters() {
        this(11, 50);
    }

    public McElieceParameters(int i) throws IllegalArgumentException {
        if (i >= 1) {
            this.f1385m = 0;
            this.f1386n = 1;
            while (true) {
                int i2 = this.f1386n;
                if (i2 < i) {
                    this.f1386n = i2 << 1;
                    this.f1385m++;
                } else {
                    int i3 = i2 >>> 1;
                    this.f1387t = i3;
                    int i4 = this.f1385m;
                    this.f1387t = i3 / i4;
                    this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i4);
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("key size must be positive");
        }
    }

    public McElieceParameters(int i, int i2) throws IllegalArgumentException {
        if (i < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i <= 32) {
            this.f1385m = i;
            int i3 = 1 << i;
            this.f1386n = i3;
            if (i2 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i2 <= i3) {
                this.f1387t = i2;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i);
            } else {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            }
        } else {
            throw new IllegalArgumentException("m is too large");
        }
    }

    public McElieceParameters(int i, int i2, int i3) throws IllegalArgumentException {
        this.f1385m = i;
        if (i < 1) {
            throw new IllegalArgumentException("m must be positive");
        } else if (i <= 32) {
            int i4 = 1 << i;
            this.f1386n = i4;
            this.f1387t = i2;
            if (i2 < 0) {
                throw new IllegalArgumentException("t must be positive");
            } else if (i2 > i4) {
                throw new IllegalArgumentException("t must be less than n = 2^m");
            } else if (PolynomialRingGF2.degree(i3) != i || !PolynomialRingGF2.isIrreducible(i3)) {
                throw new IllegalArgumentException("polynomial is not a field polynomial for GF(2^m)");
            } else {
                this.fieldPoly = i3;
            }
        } else {
            throw new IllegalArgumentException(" m is too large");
        }
    }

    public int getM() {
        return this.f1385m;
    }

    public int getN() {
        return this.f1386n;
    }

    public int getT() {
        return this.f1387t;
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }
}
