package org.spongycastle.math.p030ec.custom.sec;

import java.math.BigInteger;
import org.spongycastle.math.p030ec.ECFieldElement;
import org.spongycastle.math.raw.Mod;
import org.spongycastle.math.raw.Nat;
import org.spongycastle.util.Arrays;

/* renamed from: org.spongycastle.math.ec.custom.sec.SecP521R1FieldElement */
public class SecP521R1FieldElement extends ECFieldElement {

    /* renamed from: Q */
    public static final BigInteger f1321Q = SecP521R1Curve.f1319q;

    /* renamed from: x */
    protected int[] f1322x;

    public String getFieldName() {
        return "SecP521R1Field";
    }

    public SecP521R1FieldElement(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f1321Q) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.f1322x = SecP521R1Field.fromBigInteger(bigInteger);
    }

    public SecP521R1FieldElement() {
        this.f1322x = Nat.create(17);
    }

    protected SecP521R1FieldElement(int[] iArr) {
        this.f1322x = iArr;
    }

    public boolean isZero() {
        return Nat.isZero(17, this.f1322x);
    }

    public boolean isOne() {
        return Nat.isOne(17, this.f1322x);
    }

    public boolean testBitZero() {
        return Nat.getBit(this.f1322x, 0) == 1;
    }

    public BigInteger toBigInteger() {
        return Nat.toBigInteger(17, this.f1322x);
    }

    public int getFieldSize() {
        return f1321Q.bitLength();
    }

    public ECFieldElement add(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(17);
        SecP521R1Field.add(this.f1322x, ((SecP521R1FieldElement) eCFieldElement).f1322x, create);
        return new SecP521R1FieldElement(create);
    }

    public ECFieldElement addOne() {
        int[] create = Nat.create(17);
        SecP521R1Field.addOne(this.f1322x, create);
        return new SecP521R1FieldElement(create);
    }

    public ECFieldElement subtract(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(17);
        SecP521R1Field.subtract(this.f1322x, ((SecP521R1FieldElement) eCFieldElement).f1322x, create);
        return new SecP521R1FieldElement(create);
    }

    public ECFieldElement multiply(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(17);
        SecP521R1Field.multiply(this.f1322x, ((SecP521R1FieldElement) eCFieldElement).f1322x, create);
        return new SecP521R1FieldElement(create);
    }

    public ECFieldElement divide(ECFieldElement eCFieldElement) {
        int[] create = Nat.create(17);
        Mod.invert(SecP521R1Field.f1320P, ((SecP521R1FieldElement) eCFieldElement).f1322x, create);
        SecP521R1Field.multiply(create, this.f1322x, create);
        return new SecP521R1FieldElement(create);
    }

    public ECFieldElement negate() {
        int[] create = Nat.create(17);
        SecP521R1Field.negate(this.f1322x, create);
        return new SecP521R1FieldElement(create);
    }

    public ECFieldElement square() {
        int[] create = Nat.create(17);
        SecP521R1Field.square(this.f1322x, create);
        return new SecP521R1FieldElement(create);
    }

    public ECFieldElement invert() {
        int[] create = Nat.create(17);
        Mod.invert(SecP521R1Field.f1320P, this.f1322x, create);
        return new SecP521R1FieldElement(create);
    }

    public ECFieldElement sqrt() {
        int[] iArr = this.f1322x;
        if (Nat.isZero(17, iArr) || Nat.isOne(17, iArr)) {
            return this;
        }
        int[] create = Nat.create(17);
        int[] create2 = Nat.create(17);
        SecP521R1Field.squareN(iArr, 519, create);
        SecP521R1Field.square(create, create2);
        if (Nat.m611eq(17, iArr, create2)) {
            return new SecP521R1FieldElement(create);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SecP521R1FieldElement)) {
            return false;
        }
        return Nat.m611eq(17, this.f1322x, ((SecP521R1FieldElement) obj).f1322x);
    }

    public int hashCode() {
        return f1321Q.hashCode() ^ Arrays.hashCode(this.f1322x, 0, 17);
    }
}
