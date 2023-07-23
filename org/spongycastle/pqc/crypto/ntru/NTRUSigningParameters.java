package org.spongycastle.pqc.crypto.ntru;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

public class NTRUSigningParameters implements Cloneable {

    /* renamed from: B */
    public int f1429B;

    /* renamed from: N */
    public int f1430N;
    double beta;
    public double betaSq;
    int bitsF = 6;

    /* renamed from: d */
    public int f1431d;

    /* renamed from: d1 */
    public int f1432d1;

    /* renamed from: d2 */
    public int f1433d2;

    /* renamed from: d3 */
    public int f1434d3;
    public Digest hashAlg;
    double normBound;
    public double normBoundSq;

    /* renamed from: q */
    public int f1435q;
    public int signFailTolerance = 100;

    public NTRUSigningParameters(int i, int i2, int i3, int i4, double d, double d2, Digest digest) {
        this.f1430N = i;
        this.f1435q = i2;
        this.f1431d = i3;
        this.f1429B = i4;
        this.beta = d;
        this.normBound = d2;
        this.hashAlg = digest;
        init();
    }

    public NTRUSigningParameters(int i, int i2, int i3, int i4, int i5, int i6, double d, double d2, double d3, Digest digest) {
        this.f1430N = i;
        this.f1435q = i2;
        this.f1432d1 = i3;
        this.f1433d2 = i4;
        this.f1434d3 = i5;
        this.f1429B = i6;
        this.beta = d;
        this.normBound = d2;
        this.hashAlg = digest;
        init();
    }

    private void init() {
        double d = this.beta;
        this.betaSq = d * d;
        double d2 = this.normBound;
        this.normBoundSq = d2 * d2;
    }

    public NTRUSigningParameters(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f1430N = dataInputStream.readInt();
        this.f1435q = dataInputStream.readInt();
        this.f1431d = dataInputStream.readInt();
        this.f1432d1 = dataInputStream.readInt();
        this.f1433d2 = dataInputStream.readInt();
        this.f1434d3 = dataInputStream.readInt();
        this.f1429B = dataInputStream.readInt();
        this.beta = dataInputStream.readDouble();
        this.normBound = dataInputStream.readDouble();
        this.signFailTolerance = dataInputStream.readInt();
        this.bitsF = dataInputStream.readInt();
        String readUTF = dataInputStream.readUTF();
        if ("SHA-512".equals(readUTF)) {
            this.hashAlg = new SHA512Digest();
        } else if ("SHA-256".equals(readUTF)) {
            this.hashAlg = new SHA256Digest();
        }
        init();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.f1430N);
        dataOutputStream.writeInt(this.f1435q);
        dataOutputStream.writeInt(this.f1431d);
        dataOutputStream.writeInt(this.f1432d1);
        dataOutputStream.writeInt(this.f1433d2);
        dataOutputStream.writeInt(this.f1434d3);
        dataOutputStream.writeInt(this.f1429B);
        dataOutputStream.writeDouble(this.beta);
        dataOutputStream.writeDouble(this.normBound);
        dataOutputStream.writeInt(this.signFailTolerance);
        dataOutputStream.writeInt(this.bitsF);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
    }

    public NTRUSigningParameters clone() {
        return new NTRUSigningParameters(this.f1430N, this.f1435q, this.f1431d, this.f1429B, this.beta, this.normBound, this.hashAlg);
    }

    public int hashCode() {
        int i = ((this.f1429B + 31) * 31) + this.f1430N;
        long doubleToLongBits = Double.doubleToLongBits(this.beta);
        long doubleToLongBits2 = Double.doubleToLongBits(this.betaSq);
        int i2 = ((((((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.bitsF) * 31) + this.f1431d) * 31) + this.f1432d1) * 31) + this.f1433d2) * 31) + this.f1434d3) * 31;
        Digest digest = this.hashAlg;
        int hashCode = i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode());
        long doubleToLongBits3 = Double.doubleToLongBits(this.normBound);
        long doubleToLongBits4 = Double.doubleToLongBits(this.normBoundSq);
        return (((((((hashCode * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + this.f1435q) * 31) + this.signFailTolerance;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUSigningParameters)) {
            return false;
        }
        NTRUSigningParameters nTRUSigningParameters = (NTRUSigningParameters) obj;
        if (this.f1429B != nTRUSigningParameters.f1429B || this.f1430N != nTRUSigningParameters.f1430N || Double.doubleToLongBits(this.beta) != Double.doubleToLongBits(nTRUSigningParameters.beta) || Double.doubleToLongBits(this.betaSq) != Double.doubleToLongBits(nTRUSigningParameters.betaSq) || this.bitsF != nTRUSigningParameters.bitsF || this.f1431d != nTRUSigningParameters.f1431d || this.f1432d1 != nTRUSigningParameters.f1432d1 || this.f1433d2 != nTRUSigningParameters.f1433d2 || this.f1434d3 != nTRUSigningParameters.f1434d3) {
            return false;
        }
        Digest digest = this.hashAlg;
        if (digest == null) {
            if (nTRUSigningParameters.hashAlg != null) {
                return false;
            }
        } else if (!digest.getAlgorithmName().equals(nTRUSigningParameters.hashAlg.getAlgorithmName())) {
            return false;
        }
        return Double.doubleToLongBits(this.normBound) == Double.doubleToLongBits(nTRUSigningParameters.normBound) && Double.doubleToLongBits(this.normBoundSq) == Double.doubleToLongBits(nTRUSigningParameters.normBoundSq) && this.f1435q == nTRUSigningParameters.f1435q && this.signFailTolerance == nTRUSigningParameters.signFailTolerance;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder("SignatureParameters(N=" + this.f1430N + " q=" + this.f1435q);
        sb.append(" B=" + this.f1429B + " beta=" + decimalFormat.format(this.beta) + " normBound=" + decimalFormat.format(this.normBound) + " hashAlg=" + this.hashAlg + ")");
        return sb.toString();
    }
}
