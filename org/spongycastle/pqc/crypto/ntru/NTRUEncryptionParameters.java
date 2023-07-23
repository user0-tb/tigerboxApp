package org.spongycastle.pqc.crypto.ntru;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

public class NTRUEncryptionParameters implements Cloneable {

    /* renamed from: N */
    public int f1409N;
    public int bufferLenBits;
    int bufferLenTrits;

    /* renamed from: c */
    public int f1410c;

    /* renamed from: db */
    public int f1411db;

    /* renamed from: df */
    public int f1412df;
    public int df1;
    public int df2;
    public int df3;

    /* renamed from: dg */
    public int f1413dg;
    public int dm0;

    /* renamed from: dr */
    public int f1414dr;
    public int dr1;
    public int dr2;
    public int dr3;
    public boolean fastFp;
    public Digest hashAlg;
    public boolean hashSeed;
    int llen;
    public int maxMsgLenBytes;
    public int minCallsMask;
    public int minCallsR;
    public byte[] oid;
    public int pkLen;
    public int polyType;

    /* renamed from: q */
    public int f1415q;
    public boolean sparse;

    public NTRUEncryptionParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.f1409N = i;
        this.f1415q = i2;
        this.f1412df = i3;
        this.f1411db = i5;
        this.dm0 = i4;
        this.f1410c = i6;
        this.minCallsR = i7;
        this.minCallsMask = i8;
        this.hashSeed = z;
        this.oid = bArr;
        this.sparse = z2;
        this.fastFp = z3;
        this.polyType = 0;
        this.hashAlg = digest;
        init();
    }

    public NTRUEncryptionParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.f1409N = i;
        this.f1415q = i2;
        this.df1 = i3;
        this.df2 = i4;
        this.df3 = i5;
        this.f1411db = i7;
        this.dm0 = i6;
        this.f1410c = i8;
        this.minCallsR = i9;
        this.minCallsMask = i10;
        this.hashSeed = z;
        this.oid = bArr;
        this.sparse = z2;
        this.fastFp = z3;
        this.polyType = 1;
        this.hashAlg = digest;
        init();
    }

    private void init() {
        this.f1414dr = this.f1412df;
        this.dr1 = this.df1;
        this.dr2 = this.df2;
        this.dr3 = this.df3;
        int i = this.f1409N;
        this.f1413dg = i / 3;
        this.llen = 1;
        int i2 = this.f1411db;
        this.maxMsgLenBytes = (((((i * 3) / 2) / 8) - 1) - (i2 / 8)) - 1;
        this.bufferLenBits = (((((i * 3) / 2) + 7) / 8) * 8) + 1;
        this.bufferLenTrits = i - 1;
        this.pkLen = i2;
    }

    public NTRUEncryptionParameters(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f1409N = dataInputStream.readInt();
        this.f1415q = dataInputStream.readInt();
        this.f1412df = dataInputStream.readInt();
        this.df1 = dataInputStream.readInt();
        this.df2 = dataInputStream.readInt();
        this.df3 = dataInputStream.readInt();
        this.f1411db = dataInputStream.readInt();
        this.dm0 = dataInputStream.readInt();
        this.f1410c = dataInputStream.readInt();
        this.minCallsR = dataInputStream.readInt();
        this.minCallsMask = dataInputStream.readInt();
        this.hashSeed = dataInputStream.readBoolean();
        byte[] bArr = new byte[3];
        this.oid = bArr;
        dataInputStream.read(bArr);
        this.sparse = dataInputStream.readBoolean();
        this.fastFp = dataInputStream.readBoolean();
        this.polyType = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        if ("SHA-512".equals(readUTF)) {
            this.hashAlg = new SHA512Digest();
        } else if ("SHA-256".equals(readUTF)) {
            this.hashAlg = new SHA256Digest();
        }
        init();
    }

    public NTRUEncryptionParameters clone() {
        if (this.polyType == 0) {
            return new NTRUEncryptionParameters(this.f1409N, this.f1415q, this.f1412df, this.dm0, this.f1411db, this.f1410c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
        }
        int i = this.f1409N;
        int i2 = this.f1415q;
        int i3 = this.df1;
        int i4 = this.df2;
        int i5 = this.df3;
        int i6 = this.dm0;
        int i7 = this.f1411db;
        int i8 = this.f1410c;
        int i9 = this.minCallsR;
        int i10 = this.minCallsMask;
        boolean z = this.hashSeed;
        byte[] bArr = this.oid;
        return new NTRUEncryptionParameters(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, z, bArr, this.sparse, this.fastFp, this.hashAlg);
    }

    public int getMaxMessageLength() {
        return this.maxMsgLenBytes;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.f1409N);
        dataOutputStream.writeInt(this.f1415q);
        dataOutputStream.writeInt(this.f1412df);
        dataOutputStream.writeInt(this.df1);
        dataOutputStream.writeInt(this.df2);
        dataOutputStream.writeInt(this.df3);
        dataOutputStream.writeInt(this.f1411db);
        dataOutputStream.writeInt(this.dm0);
        dataOutputStream.writeInt(this.f1410c);
        dataOutputStream.writeInt(this.minCallsR);
        dataOutputStream.writeInt(this.minCallsMask);
        dataOutputStream.writeBoolean(this.hashSeed);
        dataOutputStream.write(this.oid);
        dataOutputStream.writeBoolean(this.sparse);
        dataOutputStream.writeBoolean(this.fastFp);
        dataOutputStream.write(this.polyType);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
    }

    public int hashCode() {
        int i = 1231;
        int i2 = (((((((((((((((((((((((((((((((this.f1409N + 31) * 31) + this.bufferLenBits) * 31) + this.bufferLenTrits) * 31) + this.f1410c) * 31) + this.f1411db) * 31) + this.f1412df) * 31) + this.df1) * 31) + this.df2) * 31) + this.df3) * 31) + this.f1413dg) * 31) + this.dm0) * 31) + this.f1414dr) * 31) + this.dr1) * 31) + this.dr2) * 31) + this.dr3) * 31) + (this.fastFp ? 1231 : 1237)) * 31;
        Digest digest = this.hashAlg;
        int hashCode = (((((((((((((((((((i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode())) * 31) + (this.hashSeed ? 1231 : 1237)) * 31) + this.llen) * 31) + this.maxMsgLenBytes) * 31) + this.minCallsMask) * 31) + this.minCallsR) * 31) + Arrays.hashCode(this.oid)) * 31) + this.pkLen) * 31) + this.polyType) * 31) + this.f1415q) * 31;
        if (!this.sparse) {
            i = 1237;
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NTRUEncryptionParameters nTRUEncryptionParameters = (NTRUEncryptionParameters) obj;
        if (this.f1409N != nTRUEncryptionParameters.f1409N || this.bufferLenBits != nTRUEncryptionParameters.bufferLenBits || this.bufferLenTrits != nTRUEncryptionParameters.bufferLenTrits || this.f1410c != nTRUEncryptionParameters.f1410c || this.f1411db != nTRUEncryptionParameters.f1411db || this.f1412df != nTRUEncryptionParameters.f1412df || this.df1 != nTRUEncryptionParameters.df1 || this.df2 != nTRUEncryptionParameters.df2 || this.df3 != nTRUEncryptionParameters.df3 || this.f1413dg != nTRUEncryptionParameters.f1413dg || this.dm0 != nTRUEncryptionParameters.dm0 || this.f1414dr != nTRUEncryptionParameters.f1414dr || this.dr1 != nTRUEncryptionParameters.dr1 || this.dr2 != nTRUEncryptionParameters.dr2 || this.dr3 != nTRUEncryptionParameters.dr3 || this.fastFp != nTRUEncryptionParameters.fastFp) {
            return false;
        }
        Digest digest = this.hashAlg;
        if (digest == null) {
            if (nTRUEncryptionParameters.hashAlg != null) {
                return false;
            }
        } else if (!digest.getAlgorithmName().equals(nTRUEncryptionParameters.hashAlg.getAlgorithmName())) {
            return false;
        }
        return this.hashSeed == nTRUEncryptionParameters.hashSeed && this.llen == nTRUEncryptionParameters.llen && this.maxMsgLenBytes == nTRUEncryptionParameters.maxMsgLenBytes && this.minCallsMask == nTRUEncryptionParameters.minCallsMask && this.minCallsR == nTRUEncryptionParameters.minCallsR && Arrays.equals(this.oid, nTRUEncryptionParameters.oid) && this.pkLen == nTRUEncryptionParameters.pkLen && this.polyType == nTRUEncryptionParameters.polyType && this.f1415q == nTRUEncryptionParameters.f1415q && this.sparse == nTRUEncryptionParameters.sparse;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EncryptionParameters(N=" + this.f1409N + " q=" + this.f1415q);
        if (this.polyType == 0) {
            sb.append(" polyType=SIMPLE df=" + this.f1412df);
        } else {
            sb.append(" polyType=PRODUCT df1=" + this.df1 + " df2=" + this.df2 + " df3=" + this.df3);
        }
        sb.append(" dm0=" + this.dm0 + " db=" + this.f1411db + " c=" + this.f1410c + " minCallsR=" + this.minCallsR + " minCallsMask=" + this.minCallsMask + " hashSeed=" + this.hashSeed + " hashAlg=" + this.hashAlg + " oid=" + Arrays.toString(this.oid) + " sparse=" + this.sparse + ")");
        return sb.toString();
    }
}
