package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PublicKey;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McElieceCCA2PublicKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2Parameters;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2PublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2PublicKeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcElieceCCA2PublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    private McElieceCCA2Parameters McElieceCCA2Params;

    /* renamed from: g */
    private GF2Matrix f1459g;

    /* renamed from: n */
    private int f1460n;
    private String oid;

    /* renamed from: t */
    private int f1461t;

    /* access modifiers changed from: protected */
    public ASN1Primitive getAlgParams() {
        return null;
    }

    public String getAlgorithm() {
        return "McEliece";
    }

    public String getFormat() {
        return null;
    }

    public BCMcElieceCCA2PublicKey(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.f1460n = i;
        this.f1461t = i2;
        this.f1459g = gF2Matrix;
    }

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeySpec mcElieceCCA2PublicKeySpec) {
        this(mcElieceCCA2PublicKeySpec.getOIDString(), mcElieceCCA2PublicKeySpec.getN(), mcElieceCCA2PublicKeySpec.getT(), mcElieceCCA2PublicKeySpec.getMatrixG());
    }

    public BCMcElieceCCA2PublicKey(McElieceCCA2PublicKeyParameters mcElieceCCA2PublicKeyParameters) {
        this(mcElieceCCA2PublicKeyParameters.getOIDString(), mcElieceCCA2PublicKeyParameters.getN(), mcElieceCCA2PublicKeyParameters.getT(), mcElieceCCA2PublicKeyParameters.getMatrixG());
        this.McElieceCCA2Params = mcElieceCCA2PublicKeyParameters.getParameters();
    }

    public int getN() {
        return this.f1460n;
    }

    public int getK() {
        return this.f1459g.getNumRows();
    }

    public int getT() {
        return this.f1461t;
    }

    public GF2Matrix getG() {
        return this.f1459g;
    }

    public String toString() {
        return (("McEliecePublicKey:\n" + " length of the code         : " + this.f1460n + "\n") + " error correction capability: " + this.f1461t + "\n") + " generator matrix           : " + this.f1459g.toString();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BCMcElieceCCA2PublicKey)) {
            return false;
        }
        BCMcElieceCCA2PublicKey bCMcElieceCCA2PublicKey = (BCMcElieceCCA2PublicKey) obj;
        if (this.f1460n == bCMcElieceCCA2PublicKey.f1460n && this.f1461t == bCMcElieceCCA2PublicKey.f1461t && this.f1459g.equals(bCMcElieceCCA2PublicKey.f1459g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f1460n + this.f1461t + this.f1459g.hashCode();
    }

    public String getOIDString() {
        return this.oid;
    }

    /* access modifiers changed from: protected */
    public ASN1ObjectIdentifier getOID() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.2");
    }

    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(getOID(), DERNull.INSTANCE), (ASN1Encodable) new McElieceCCA2PublicKey(new ASN1ObjectIdentifier(this.oid), this.f1460n, this.f1461t, this.f1459g)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public McElieceCCA2Parameters getMcElieceCCA2Parameters() {
        return this.McElieceCCA2Params;
    }
}
