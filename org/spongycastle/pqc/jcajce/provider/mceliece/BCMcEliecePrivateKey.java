package org.spongycastle.pqc.jcajce.provider.mceliece;

import java.io.IOException;
import java.security.PrivateKey;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.pqc.asn1.McEliecePrivateKey;
import org.spongycastle.pqc.crypto.mceliece.McElieceParameters;
import org.spongycastle.pqc.crypto.mceliece.McEliecePrivateKeyParameters;
import org.spongycastle.pqc.jcajce.spec.McEliecePrivateKeySpec;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class BCMcEliecePrivateKey implements CipherParameters, PrivateKey {
    private static final long serialVersionUID = 1;
    private GF2mField field;
    private PolynomialGF2mSmallM goppaPoly;

    /* renamed from: h */
    private GF2Matrix f1462h;

    /* renamed from: k */
    private int f1463k;
    private McElieceParameters mcElieceParams;

    /* renamed from: n */
    private int f1464n;
    private String oid;

    /* renamed from: p1 */
    private Permutation f1465p1;

    /* renamed from: p2 */
    private Permutation f1466p2;
    private PolynomialGF2mSmallM[] qInv;
    private GF2Matrix sInv;

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

    public BCMcEliecePrivateKey(String str, int i, int i2, GF2mField gF2mField, PolynomialGF2mSmallM polynomialGF2mSmallM, GF2Matrix gF2Matrix, Permutation permutation, Permutation permutation2, GF2Matrix gF2Matrix2, PolynomialGF2mSmallM[] polynomialGF2mSmallMArr) {
        this.oid = str;
        this.f1464n = i;
        this.f1463k = i2;
        this.field = gF2mField;
        this.goppaPoly = polynomialGF2mSmallM;
        this.sInv = gF2Matrix;
        this.f1465p1 = permutation;
        this.f1466p2 = permutation2;
        this.f1462h = gF2Matrix2;
        this.qInv = polynomialGF2mSmallMArr;
    }

    public BCMcEliecePrivateKey(McEliecePrivateKeySpec mcEliecePrivateKeySpec) {
        this(mcEliecePrivateKeySpec.getOIDString(), mcEliecePrivateKeySpec.getN(), mcEliecePrivateKeySpec.getK(), mcEliecePrivateKeySpec.getField(), mcEliecePrivateKeySpec.getGoppaPoly(), mcEliecePrivateKeySpec.getSInv(), mcEliecePrivateKeySpec.getP1(), mcEliecePrivateKeySpec.getP2(), mcEliecePrivateKeySpec.getH(), mcEliecePrivateKeySpec.getQInv());
    }

    public BCMcEliecePrivateKey(McEliecePrivateKeyParameters mcEliecePrivateKeyParameters) {
        this(mcEliecePrivateKeyParameters.getOIDString(), mcEliecePrivateKeyParameters.getN(), mcEliecePrivateKeyParameters.getK(), mcEliecePrivateKeyParameters.getField(), mcEliecePrivateKeyParameters.getGoppaPoly(), mcEliecePrivateKeyParameters.getSInv(), mcEliecePrivateKeyParameters.getP1(), mcEliecePrivateKeyParameters.getP2(), mcEliecePrivateKeyParameters.getH(), mcEliecePrivateKeyParameters.getQInv());
        this.mcElieceParams = mcEliecePrivateKeyParameters.getParameters();
    }

    public int getN() {
        return this.f1464n;
    }

    public int getK() {
        return this.f1463k;
    }

    public GF2mField getField() {
        return this.field;
    }

    public PolynomialGF2mSmallM getGoppaPoly() {
        return this.goppaPoly;
    }

    public GF2Matrix getSInv() {
        return this.sInv;
    }

    public Permutation getP1() {
        return this.f1465p1;
    }

    public Permutation getP2() {
        return this.f1466p2;
    }

    public GF2Matrix getH() {
        return this.f1462h;
    }

    public PolynomialGF2mSmallM[] getQInv() {
        return this.qInv;
    }

    public String getOIDString() {
        return this.oid;
    }

    public String toString() {
        return (((((" length of the code          : " + this.f1464n + "\n") + " dimension of the code       : " + this.f1463k + "\n") + " irreducible Goppa polynomial: " + this.goppaPoly + "\n") + " (k x k)-matrix S^-1         : " + this.sInv + "\n") + " permutation P1              : " + this.f1465p1 + "\n") + " permutation P2              : " + this.f1466p2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCMcEliecePrivateKey)) {
            return false;
        }
        BCMcEliecePrivateKey bCMcEliecePrivateKey = (BCMcEliecePrivateKey) obj;
        if (this.f1464n != bCMcEliecePrivateKey.f1464n || this.f1463k != bCMcEliecePrivateKey.f1463k || !this.field.equals(bCMcEliecePrivateKey.field) || !this.goppaPoly.equals(bCMcEliecePrivateKey.goppaPoly) || !this.sInv.equals(bCMcEliecePrivateKey.sInv) || !this.f1465p1.equals(bCMcEliecePrivateKey.f1465p1) || !this.f1466p2.equals(bCMcEliecePrivateKey.f1466p2) || !this.f1462h.equals(bCMcEliecePrivateKey.f1462h)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.f1463k + this.f1464n + this.field.hashCode() + this.goppaPoly.hashCode() + this.sInv.hashCode() + this.f1465p1.hashCode() + this.f1466p2.hashCode() + this.f1462h.hashCode();
    }

    /* access modifiers changed from: protected */
    public ASN1ObjectIdentifier getOID() {
        return new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.4.1");
    }

    public byte[] getEncoded() {
        try {
            try {
                return new PrivateKeyInfo(new AlgorithmIdentifier(getOID(), DERNull.INSTANCE), new McEliecePrivateKey(new ASN1ObjectIdentifier(this.oid), this.f1464n, this.f1463k, this.field, this.goppaPoly, this.sInv, this.f1465p1, this.f1466p2, this.f1462h, this.qInv)).getEncoded();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public McElieceParameters getMcElieceParameters() {
        return this.mcElieceParams;
    }
}
