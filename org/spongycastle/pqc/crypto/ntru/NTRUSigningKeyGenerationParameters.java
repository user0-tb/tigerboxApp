package org.spongycastle.pqc.crypto.ntru;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.tls.CipherSuite;

public class NTRUSigningKeyGenerationParameters extends KeyGenerationParameters implements Cloneable {
    public static final NTRUSigningKeyGenerationParameters APR2011_439 = new NTRUSigningKeyGenerationParameters(439, 2048, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 1, 1, 0.165d, 490.0d, 280.0d, false, true, 0, new SHA256Digest());
    public static final NTRUSigningKeyGenerationParameters APR2011_439_PROD;
    public static final NTRUSigningKeyGenerationParameters APR2011_743 = new NTRUSigningKeyGenerationParameters(743, 2048, 248, 1, 1, 0.127d, 560.0d, 360.0d, true, false, 0, new SHA512Digest());
    public static final NTRUSigningKeyGenerationParameters APR2011_743_PROD;
    public static final int BASIS_TYPE_STANDARD = 0;
    public static final int BASIS_TYPE_TRANSPOSE = 1;
    public static final int KEY_GEN_ALG_FLOAT = 1;
    public static final int KEY_GEN_ALG_RESULTANT = 0;
    public static final NTRUSigningKeyGenerationParameters TEST157 = new NTRUSigningKeyGenerationParameters(CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, 256, 29, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, new SHA256Digest());
    public static final NTRUSigningKeyGenerationParameters TEST157_PROD;

    /* renamed from: B */
    public int f1420B;

    /* renamed from: N */
    public int f1421N;
    public int basisType;
    double beta;
    public double betaSq;
    int bitsF = 6;

    /* renamed from: d */
    public int f1422d;

    /* renamed from: d1 */
    public int f1423d1;

    /* renamed from: d2 */
    public int f1424d2;

    /* renamed from: d3 */
    public int f1425d3;
    public Digest hashAlg;
    public int keyGenAlg;
    double keyNormBound;
    public double keyNormBoundSq;
    double normBound;
    public double normBoundSq;
    public int polyType;
    public boolean primeCheck;

    /* renamed from: q */
    public int f1426q;
    public int signFailTolerance = 100;
    public boolean sparse;

    static {
        SHA256Digest sHA256Digest = r1;
        SHA256Digest sHA256Digest2 = new SHA256Digest();
        APR2011_439_PROD = new NTRUSigningKeyGenerationParameters(439, 2048, 9, 8, 5, 1, 1, 0.165d, 490.0d, 280.0d, false, true, 0, sHA256Digest);
        SHA512Digest sHA512Digest = r1;
        SHA512Digest sHA512Digest2 = new SHA512Digest();
        APR2011_743_PROD = new NTRUSigningKeyGenerationParameters(743, 2048, 11, 11, 15, 1, 1, 0.127d, 560.0d, 360.0d, true, false, 0, sHA512Digest);
        SHA256Digest sHA256Digest3 = r1;
        SHA256Digest sHA256Digest4 = new SHA256Digest();
        TEST157_PROD = new NTRUSigningKeyGenerationParameters(CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, 256, 5, 5, 8, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, sHA256Digest3);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NTRUSigningKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, boolean z, boolean z2, int i6, Digest digest) {
        super(new SecureRandom(), i);
        this.f1421N = i;
        this.f1426q = i2;
        this.f1422d = i3;
        this.f1420B = i4;
        this.basisType = i5;
        this.beta = d;
        this.normBound = d2;
        this.keyNormBound = d3;
        this.primeCheck = z;
        this.sparse = z2;
        this.keyGenAlg = i6;
        this.hashAlg = digest;
        this.polyType = 0;
        init();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NTRUSigningKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, double d, double d2, double d3, boolean z, boolean z2, int i8, Digest digest) {
        super(new SecureRandom(), i);
        this.f1421N = i;
        this.f1426q = i2;
        this.f1423d1 = i3;
        this.f1424d2 = i4;
        this.f1425d3 = i5;
        this.f1420B = i6;
        this.basisType = i7;
        this.beta = d;
        this.normBound = d2;
        this.keyNormBound = d3;
        this.primeCheck = z;
        this.sparse = z2;
        this.keyGenAlg = i8;
        this.hashAlg = digest;
        this.polyType = 1;
        init();
    }

    private void init() {
        double d = this.beta;
        this.betaSq = d * d;
        double d2 = this.normBound;
        this.normBoundSq = d2 * d2;
        double d3 = this.keyNormBound;
        this.keyNormBoundSq = d3 * d3;
    }

    public NTRUSigningKeyGenerationParameters(InputStream inputStream) throws IOException {
        super(new SecureRandom(), 0);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f1421N = dataInputStream.readInt();
        this.f1426q = dataInputStream.readInt();
        this.f1422d = dataInputStream.readInt();
        this.f1423d1 = dataInputStream.readInt();
        this.f1424d2 = dataInputStream.readInt();
        this.f1425d3 = dataInputStream.readInt();
        this.f1420B = dataInputStream.readInt();
        this.basisType = dataInputStream.readInt();
        this.beta = dataInputStream.readDouble();
        this.normBound = dataInputStream.readDouble();
        this.keyNormBound = dataInputStream.readDouble();
        this.signFailTolerance = dataInputStream.readInt();
        this.primeCheck = dataInputStream.readBoolean();
        this.sparse = dataInputStream.readBoolean();
        this.bitsF = dataInputStream.readInt();
        this.keyGenAlg = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        if ("SHA-512".equals(readUTF)) {
            this.hashAlg = new SHA512Digest();
        } else if ("SHA-256".equals(readUTF)) {
            this.hashAlg = new SHA256Digest();
        }
        this.polyType = dataInputStream.read();
        init();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.f1421N);
        dataOutputStream.writeInt(this.f1426q);
        dataOutputStream.writeInt(this.f1422d);
        dataOutputStream.writeInt(this.f1423d1);
        dataOutputStream.writeInt(this.f1424d2);
        dataOutputStream.writeInt(this.f1425d3);
        dataOutputStream.writeInt(this.f1420B);
        dataOutputStream.writeInt(this.basisType);
        dataOutputStream.writeDouble(this.beta);
        dataOutputStream.writeDouble(this.normBound);
        dataOutputStream.writeDouble(this.keyNormBound);
        dataOutputStream.writeInt(this.signFailTolerance);
        dataOutputStream.writeBoolean(this.primeCheck);
        dataOutputStream.writeBoolean(this.sparse);
        dataOutputStream.writeInt(this.bitsF);
        dataOutputStream.write(this.keyGenAlg);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
        dataOutputStream.write(this.polyType);
    }

    public NTRUSigningParameters getSigningParameters() {
        return new NTRUSigningParameters(this.f1421N, this.f1426q, this.f1422d, this.f1420B, this.beta, this.normBound, this.hashAlg);
    }

    public NTRUSigningKeyGenerationParameters clone() {
        if (this.polyType != 0) {
            return new NTRUSigningKeyGenerationParameters(this.f1421N, this.f1426q, this.f1423d1, this.f1424d2, this.f1425d3, this.f1420B, this.basisType, this.beta, this.normBound, this.keyNormBound, this.primeCheck, this.sparse, this.keyGenAlg, this.hashAlg);
        }
        int i = this.f1421N;
        int i2 = this.f1426q;
        int i3 = this.f1422d;
        int i4 = this.f1420B;
        int i5 = this.basisType;
        double d = this.beta;
        double d2 = this.normBound;
        double d3 = this.keyNormBound;
        boolean z = this.primeCheck;
        boolean z2 = this.sparse;
        return new NTRUSigningKeyGenerationParameters(i, i2, i3, i4, i5, d, d2, d3, z, z2, this.keyGenAlg, this.hashAlg);
    }

    public int hashCode() {
        int i = ((((this.f1420B + 31) * 31) + this.f1421N) * 31) + this.basisType;
        long doubleToLongBits = Double.doubleToLongBits(this.beta);
        long doubleToLongBits2 = Double.doubleToLongBits(this.betaSq);
        int i2 = ((((((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.bitsF) * 31) + this.f1422d) * 31) + this.f1423d1) * 31) + this.f1424d2) * 31) + this.f1425d3) * 31;
        Digest digest = this.hashAlg;
        int hashCode = ((i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode())) * 31) + this.keyGenAlg;
        long doubleToLongBits3 = Double.doubleToLongBits(this.keyNormBound);
        long doubleToLongBits4 = Double.doubleToLongBits(this.keyNormBoundSq);
        long doubleToLongBits5 = Double.doubleToLongBits(this.normBound);
        long doubleToLongBits6 = Double.doubleToLongBits(this.normBoundSq);
        int i3 = 1231;
        int i4 = ((((((((((((((((hashCode * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + this.polyType) * 31) + (this.primeCheck ? 1231 : 1237)) * 31) + this.f1426q) * 31) + this.signFailTolerance) * 31;
        if (!this.sparse) {
            i3 = 1237;
        }
        return i4 + i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUSigningKeyGenerationParameters)) {
            return false;
        }
        NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = (NTRUSigningKeyGenerationParameters) obj;
        if (this.f1420B != nTRUSigningKeyGenerationParameters.f1420B || this.f1421N != nTRUSigningKeyGenerationParameters.f1421N || this.basisType != nTRUSigningKeyGenerationParameters.basisType || Double.doubleToLongBits(this.beta) != Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.beta) || Double.doubleToLongBits(this.betaSq) != Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.betaSq) || this.bitsF != nTRUSigningKeyGenerationParameters.bitsF || this.f1422d != nTRUSigningKeyGenerationParameters.f1422d || this.f1423d1 != nTRUSigningKeyGenerationParameters.f1423d1 || this.f1424d2 != nTRUSigningKeyGenerationParameters.f1424d2 || this.f1425d3 != nTRUSigningKeyGenerationParameters.f1425d3) {
            return false;
        }
        Digest digest = this.hashAlg;
        if (digest == null) {
            if (nTRUSigningKeyGenerationParameters.hashAlg != null) {
                return false;
            }
        } else if (!digest.getAlgorithmName().equals(nTRUSigningKeyGenerationParameters.hashAlg.getAlgorithmName())) {
            return false;
        }
        return this.keyGenAlg == nTRUSigningKeyGenerationParameters.keyGenAlg && Double.doubleToLongBits(this.keyNormBound) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.keyNormBound) && Double.doubleToLongBits(this.keyNormBoundSq) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.keyNormBoundSq) && Double.doubleToLongBits(this.normBound) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.normBound) && Double.doubleToLongBits(this.normBoundSq) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.normBoundSq) && this.polyType == nTRUSigningKeyGenerationParameters.polyType && this.primeCheck == nTRUSigningKeyGenerationParameters.primeCheck && this.f1426q == nTRUSigningKeyGenerationParameters.f1426q && this.signFailTolerance == nTRUSigningKeyGenerationParameters.signFailTolerance && this.sparse == nTRUSigningKeyGenerationParameters.sparse;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder sb = new StringBuilder("SignatureParameters(N=" + this.f1421N + " q=" + this.f1426q);
        if (this.polyType == 0) {
            sb.append(" polyType=SIMPLE d=" + this.f1422d);
        } else {
            sb.append(" polyType=PRODUCT d1=" + this.f1423d1 + " d2=" + this.f1424d2 + " d3=" + this.f1425d3);
        }
        sb.append(" B=" + this.f1420B + " basisType=" + this.basisType + " beta=" + decimalFormat.format(this.beta) + " normBound=" + decimalFormat.format(this.normBound) + " keyNormBound=" + decimalFormat.format(this.keyNormBound) + " prime=" + this.primeCheck + " sparse=" + this.sparse + " keyGenAlg=" + this.keyGenAlg + " hashAlg=" + this.hashAlg + ")");
        return sb.toString();
    }
}
