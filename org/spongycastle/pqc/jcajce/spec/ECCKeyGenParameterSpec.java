package org.spongycastle.pqc.jcajce.spec;

import java.security.InvalidParameterException;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.pqc.math.linearalgebra.PolynomialRingGF2;

public class ECCKeyGenParameterSpec implements AlgorithmParameterSpec {
    public static final int DEFAULT_M = 11;
    public static final int DEFAULT_T = 50;
    private int fieldPoly;

    /* renamed from: m */
    private int f1473m;

    /* renamed from: n */
    private int f1474n;

    /* renamed from: t */
    private int f1475t;

    public ECCKeyGenParameterSpec() {
        this(11, 50);
    }

    public ECCKeyGenParameterSpec(int i) throws InvalidParameterException {
        if (i >= 1) {
            this.f1473m = 0;
            this.f1474n = 1;
            while (true) {
                int i2 = this.f1474n;
                if (i2 < i) {
                    this.f1474n = i2 << 1;
                    this.f1473m++;
                } else {
                    int i3 = i2 >>> 1;
                    this.f1475t = i3;
                    int i4 = this.f1473m;
                    this.f1475t = i3 / i4;
                    this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i4);
                    return;
                }
            }
        } else {
            throw new InvalidParameterException("key size must be positive");
        }
    }

    public ECCKeyGenParameterSpec(int i, int i2) throws InvalidParameterException {
        if (i < 1) {
            throw new InvalidParameterException("m must be positive");
        } else if (i <= 32) {
            this.f1473m = i;
            int i3 = 1 << i;
            this.f1474n = i3;
            if (i2 < 0) {
                throw new InvalidParameterException("t must be positive");
            } else if (i2 <= i3) {
                this.f1475t = i2;
                this.fieldPoly = PolynomialRingGF2.getIrreduciblePolynomial(i);
            } else {
                throw new InvalidParameterException("t must be less than n = 2^m");
            }
        } else {
            throw new InvalidParameterException("m is too large");
        }
    }

    public ECCKeyGenParameterSpec(int i, int i2, int i3) throws InvalidParameterException {
        this.f1473m = i;
        if (i < 1) {
            throw new InvalidParameterException("m must be positive");
        } else if (i <= 32) {
            int i4 = 1 << i;
            this.f1474n = i4;
            this.f1475t = i2;
            if (i2 < 0) {
                throw new InvalidParameterException("t must be positive");
            } else if (i2 > i4) {
                throw new InvalidParameterException("t must be less than n = 2^m");
            } else if (PolynomialRingGF2.degree(i3) != i || !PolynomialRingGF2.isIrreducible(i3)) {
                throw new InvalidParameterException("polynomial is not a field polynomial for GF(2^m)");
            } else {
                this.fieldPoly = i3;
            }
        } else {
            throw new InvalidParameterException(" m is too large");
        }
    }

    public int getM() {
        return this.f1473m;
    }

    public int getN() {
        return this.f1474n;
    }

    public int getT() {
        return this.f1475t;
    }

    public int getFieldPoly() {
        return this.fieldPoly;
    }
}
