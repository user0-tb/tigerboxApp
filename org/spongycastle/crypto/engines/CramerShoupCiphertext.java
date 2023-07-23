package org.spongycastle.crypto.engines;

import java.math.BigInteger;

public class CramerShoupCiphertext {

    /* renamed from: e */
    BigInteger f977e;

    /* renamed from: u1 */
    BigInteger f978u1;

    /* renamed from: u2 */
    BigInteger f979u2;

    /* renamed from: v */
    BigInteger f980v;

    public CramerShoupCiphertext() {
    }

    public CramerShoupCiphertext(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f978u1 = bigInteger;
        this.f979u2 = bigInteger2;
        this.f977e = bigInteger3;
        this.f980v = bigInteger4;
    }

    public CramerShoupCiphertext(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        int byteArrayToInt = byteArrayToInt(bArr2);
        byte[] bArr3 = new byte[byteArrayToInt];
        System.arraycopy(bArr, 4, bArr3, 0, byteArrayToInt);
        int i = byteArrayToInt + 4;
        this.f978u1 = new BigInteger(bArr3);
        System.arraycopy(bArr, i, bArr2, 0, 4);
        int byteArrayToInt2 = byteArrayToInt(bArr2);
        byte[] bArr4 = new byte[byteArrayToInt2];
        int i2 = i + 4;
        System.arraycopy(bArr, i2, bArr4, 0, byteArrayToInt2);
        int i3 = i2 + byteArrayToInt2;
        this.f979u2 = new BigInteger(bArr4);
        System.arraycopy(bArr, i3, bArr2, 0, 4);
        int byteArrayToInt3 = byteArrayToInt(bArr2);
        byte[] bArr5 = new byte[byteArrayToInt3];
        int i4 = i3 + 4;
        System.arraycopy(bArr, i4, bArr5, 0, byteArrayToInt3);
        int i5 = i4 + byteArrayToInt3;
        this.f977e = new BigInteger(bArr5);
        System.arraycopy(bArr, i5, bArr2, 0, 4);
        int byteArrayToInt4 = byteArrayToInt(bArr2);
        byte[] bArr6 = new byte[byteArrayToInt4];
        System.arraycopy(bArr, i5 + 4, bArr6, 0, byteArrayToInt4);
        this.f980v = new BigInteger(bArr6);
    }

    public BigInteger getU1() {
        return this.f978u1;
    }

    public void setU1(BigInteger bigInteger) {
        this.f978u1 = bigInteger;
    }

    public BigInteger getU2() {
        return this.f979u2;
    }

    public void setU2(BigInteger bigInteger) {
        this.f979u2 = bigInteger;
    }

    public BigInteger getE() {
        return this.f977e;
    }

    public void setE(BigInteger bigInteger) {
        this.f977e = bigInteger;
    }

    public BigInteger getV() {
        return this.f980v;
    }

    public void setV(BigInteger bigInteger) {
        this.f980v = bigInteger;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("u1: " + this.f978u1.toString());
        stringBuffer.append("\nu2: " + this.f979u2.toString());
        stringBuffer.append("\ne: " + this.f977e.toString());
        stringBuffer.append("\nv: " + this.f980v.toString());
        return stringBuffer.toString();
    }

    public byte[] toByteArray() {
        byte[] byteArray = this.f978u1.toByteArray();
        int length = byteArray.length;
        byte[] byteArray2 = this.f979u2.toByteArray();
        int length2 = byteArray2.length;
        byte[] byteArray3 = this.f977e.toByteArray();
        int length3 = byteArray3.length;
        byte[] byteArray4 = this.f980v.toByteArray();
        int length4 = byteArray4.length;
        byte[] bArr = new byte[(length + length2 + length3 + length4 + 16)];
        System.arraycopy(intToByteArray(length), 0, bArr, 0, 4);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        int i = length + 4;
        System.arraycopy(intToByteArray(length2), 0, bArr, i, 4);
        int i2 = i + 4;
        System.arraycopy(byteArray2, 0, bArr, i2, length2);
        int i3 = i2 + length2;
        System.arraycopy(intToByteArray(length3), 0, bArr, i3, 4);
        int i4 = i3 + 4;
        System.arraycopy(byteArray3, 0, bArr, i4, length3);
        int i5 = i4 + length3;
        System.arraycopy(intToByteArray(length4), 0, bArr, i5, 4);
        System.arraycopy(byteArray4, 0, bArr, i5 + 4, length4);
        return bArr;
    }

    private byte[] intToByteArray(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[3 - i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    private int byteArrayToInt(byte[] bArr) {
        if (bArr.length != 4) {
            return -1;
        }
        int i = 0;
        for (int i2 = 3; i2 >= 0; i2--) {
            i += bArr[i2] << ((3 - i2) * 8);
        }
        return i;
    }
}
