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
import org.spongycastle.pqc.asn1.McEliecePublicKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePublicKeyParameters;
import org.spongycastle.pqc.jcajce.spec.McEliecePublicKeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;

public class BCMcEliecePublicKey implements CipherParameters, PublicKey {
    private static final long serialVersionUID = 1;
    private McElieceParameters McElieceParams;

    /* renamed from: g */
    private GF2Matrix f1467g;

    /* renamed from: n */
    private int f1468n;
    private String oid;

    /* renamed from: t */
    private int f1469t;

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

    public BCMcEliecePublicKey(String str, int i, int i2, GF2Matrix gF2Matrix) {
        this.oid = str;
        this.f1468n = i;
        this.f1469t = i2;
        this.f1467g = gF2Matrix;
    }

    public BCMcEliecePublicKey(McEliecePublicKeySpec mcEliecePublicKeySpec) {
        this(mcEliecePublicKeySpec.getOIDString(), mcEliecePublicKeySpec.getN(), mcEliecePublicKeySpec.getT(), mcEliecePublicKeySpec.getG());
    }

    public BCMcEliecePublicKey(McEliecePublicKeyParameters mcEliecePublicKeyParameters) {
        this(mcEliecePublicKeyParameters.getOIDString(), mcEliecePublicKeyParameters.getN(), mcEliecePublicKeyParameters.getT(), mcEliecePublicKeyParameters.getG());
        this.McElieceParams = mcEliecePublicKeyParameters.getParameters();
    }

    public int getN() {
        return this.f1468n;
    }

    public int getK() {
        return this.f1467g.getNumRows();
    }

    public int getT() {
        return this.f1469t;
    }

    public GF2Matrix getG() {
        return this.f1467g;
    }

    public String toString() {
        return (("McEliecePublicKey:\n" + " length of the code         : " + this.f1468n + "\n") + " error correction capability: " + this.f1469t + "\n") + " generator matrix           : " + this.f1467g.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePublicKey)) {
            return false;
        }
        BCMcEliecePublicKey bCMcEliecePublicKey = (BCMcEliecePublicKey) obj;
        if (this.f1468n == bCMcEliecePublicKey.f1468n && this.f1469t == bCMcEliecePublicKey.f1469t && this.f1467g.equals(bCMcEliecePublicKey.f1467g)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f1468n + this.f1469t + this.f1467g.hashCode();
    }

    public String getOIDString() {
        return this.oid;
    }

    /* access modifiers changed from: protected */
    public ASN1ObjectIdentifier getOID() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    }

    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(getOID(), DERNull.INSTANCE), (ASN1Encodable) new McEliecePublicKey(new ASN1ObjectIdentifier(this.oid), this.f1468n, this.f1469t, this.f1467g)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public McElieceParameters getMcElieceParameters() {
        return this.McElieceParams;
    }
}
