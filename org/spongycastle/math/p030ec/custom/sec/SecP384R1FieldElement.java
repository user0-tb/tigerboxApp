package org.spongycastle.math.p030ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.p030ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP384R1FieldElement */
public class SecP384R1FieldElement extends ECFieldElement {

    /* renamed from: Q */
    public static final BigInteger f1317Q = SecP384R1Curve.f1314q;

    /* renamed from: x */
    protected int[] f1318x;

    public String getFieldName() {
        return "SecP384R1Field";
    }

    public SecP384R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f1317Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f1318x = SecP384R1Field.fromBigInteger(bigInteger);
    }

    public SecP384R1FieldElement() {
        this.f1318x = Nat.create(12);
    }

    protected SecP384R1FieldElement(int[] iArr) {
        this.f1318x = iArr;
    }

    public boolean isZero() {
        return Nat.isZero(12, this.f1318x);
    }

    public boolean isOne() {
        return Nat.isOne(12, this.f1318x);
    }

    public boolean testBitZero() {
        return Nat.getBit(this.f1318x, 0) == 1;
    }

    public BigInteger toBigInteger() {
        return Nat.toBigInteger(12, this.f1318x);
    }

    public int getFieldSize() {
        return f1317Q.bitLength();
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(12);
        SecP384R1Field.add(this.f1318x, ((SecP384R1FieldElement) eCFieldElement).f1318x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement addOne() {
        int[] create = Nat.create(12);
        SecP384R1Field.addOne(this.f1318x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(12);
        SecP384R1Field.subtract(this.f1318x, ((SecP384R1FieldElement) eCFieldElement).f1318x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(12);
        SecP384R1Field.multiply(this.f1318x, ((SecP384R1FieldElement) eCFieldElement).f1318x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(12);
        Mod.invert(SecP384R1Field.f1316P, ((SecP384R1FieldElement) eCFieldElement).f1318x, create);
        SecP384R1Field.multiply(create, this.f1318x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement negate() {
        int[] create = Nat.create(12);
        SecP384R1Field.negate(this.f1318x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement square() {
        int[] create = Nat.create(12);
        SecP384R1Field.square(this.f1318x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement invert() {
        int[] create = Nat.create(12);
        Mod.invert(SecP384R1Field.f1316P, this.f1318x, create);
        return new SecP384R1FieldElement(create);
    }

    public ECFieldElement sqrt() {
        int[] iArr = this.f1318x;
        if (Nat.isZero(12, iArr) || Nat.isOne(12, iArr)) {
            return this;
        }
        int[] create = Nat.create(12);
        int[] create2 = Nat.create(12);
        int[] create3 = Nat.create(12);
        int[] create4 = Nat.create(12);
        SecP384R1Field.square(iArr, create);
        SecP384R1Field.multiply(create, iArr, create);
        SecP384R1Field.squareN(create, 2, create2);
        SecP384R1Field.multiply(create2, create, create2);
        SecP384R1Field.square(create2, create2);
        SecP384R1Field.multiply(create2, iArr, create2);
        SecP384R1Field.squareN(create2, 5, create3);
        SecP384R1Field.multiply(create3, create2, create3);
        SecP384R1Field.squareN(create3, 5, create4);
        SecP384R1Field.multiply(create4, create2, create4);
        SecP384R1Field.squareN(create4, 15, create2);
        SecP384R1Field.multiply(create2, create4, create2);
        SecP384R1Field.squareN(create2, 2, create3);
        SecP384R1Field.multiply(create, create3, create);
        SecP384R1Field.squareN(create3, 28, create3);
        SecP384R1Field.multiply(create2, create3, create2);
        SecP384R1Field.squareN(create2, 60, create3);
        SecP384R1Field.multiply(create3, create2, create3);
        SecP384R1Field.squareN(create3, 120, create2);
        SecP384R1Field.multiply(create2, create3, create2);
        SecP384R1Field.squareN(create2, 15, create2);
        SecP384R1Field.multiply(create2, create4, create2);
        SecP384R1Field.squareN(create2, 33, create2);
        SecP384R1Field.multiply(create2, create, create2);
        SecP384R1Field.squareN(create2, 64, create2);
        SecP384R1Field.multiply(create2, iArr, create2);
        SecP384R1Field.squareN(create2, 30, create);
        SecP384R1Field.square(create, create2);
        if (Nat.m611eq(12, iArr, create2)) {
            return new SecP384R1FieldElement(create);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP384R1FieldElement)) {
            return false;
        }
        return Nat.m611eq(12, this.f1318x, ((SecP384R1FieldElement) obj).f1318x);
    }

    public int hashCode() {
        return f1317Q.hashCode() ^ Arrays.hashCode(this.f1318x, 0, 12);
    }
}
