package org.spongycastle.crypto.params;

public class GOST3410ValidationParameters {

    /* renamed from: c */
    private int f1151c;

    /* renamed from: cL */
    private long f1152cL;

    /* renamed from: x0 */
    private int f1153x0;
    private long x0L;

    public GOST3410ValidationParameters(int i, int i2) {
        this.f1153x0 = i;
        this.f1151c = i2;
    }

    public GOST3410ValidationParameters(long j, long j2) {
        this.x0L = j;
        this.f1152cL = j2;
    }

    public int getC() {
        return this.f1151c;
    }

    public int getX0() {
        return this.f1153x0;
    }

    public long getCL() {
        return this.f1152cL;
    }

    public long getX0L() {
        return this.x0L;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        if (gOST3410ValidationParameters.f1151c == this.f1151c && gOST3410ValidationParameters.f1153x0 == this.f1153x0 && gOST3410ValidationParameters.f1152cL == this.f1152cL && gOST3410ValidationParameters.x0L == this.x0L) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.f1153x0 ^ this.f1151c;
        long j = this.x0L;
        long j2 = this.f1152cL;
        return (((i ^ ((int) j)) ^ ((int) (j >> 32))) ^ ((int) j2)) ^ ((int) (j2 >> 32));
    }
}
