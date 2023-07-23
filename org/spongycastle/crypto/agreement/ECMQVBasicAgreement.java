package org.spongycastle.crypto.agreement;

import java.math.BigInteger;
import org.spongycastle.crypto.BasicAgreement;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.MQVPrivateParameters;
import org.spongycastle.crypto.params.MQVPublicParameters;
import org.spongycastle.math.p030ec.ECAlgorithms;
import org.spongycastle.math.p030ec.ECConstants;
import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECPoint;

public class ECMQVBasicAgreement implements BasicAgreement {
    MQVPrivateParameters privParams;

    public void init(CipherParameters cipherParameters) {
        this.privParams = (MQVPrivateParameters) cipherParameters;
    }

    public int getFieldSize() {
        return (this.privParams.getStaticPrivateKey().getParameters().getCurve().getFieldSize() + 7) / 8;
    }

    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
        ECPrivateKeyParameters staticPrivateKey = this.privParams.getStaticPrivateKey();
        ECPoint normalize = calculateMqvAgreement(staticPrivateKey.getParameters(), staticPrivateKey, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), mQVPublicParameters.getStaticPublicKey(), mQVPublicParameters.getEphemeralPublicKey()).normalize();
        if (!normalize.isInfinity()) {
            return normalize.getAffineXCoord().toBigInteger();
        }
        throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
    }

    private ECPoint calculateMqvAgreement(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        BigInteger n = eCDomainParameters.getN();
        int bitLength = (n.bitLength() + 1) / 2;
        BigInteger shiftLeft = ECConstants.ONE.shiftLeft(bitLength);
        ECCurve curve = eCDomainParameters.getCurve();
        ECPoint[] eCPointArr = new ECPoint[3];
        eCPointArr[0] = ECAlgorithms.importPoint(curve, eCPublicKeyParameters == null ? eCDomainParameters.getG().multiply(eCPrivateKeyParameters2.getD()) : eCPublicKeyParameters.getQ());
        eCPointArr[1] = ECAlgorithms.importPoint(curve, eCPublicKeyParameters2.getQ());
        eCPointArr[2] = ECAlgorithms.importPoint(curve, eCPublicKeyParameters3.getQ());
        curve.normalizeAll(eCPointArr);
        ECPoint eCPoint = eCPointArr[0];
        ECPoint eCPoint2 = eCPointArr[1];
        ECPoint eCPoint3 = eCPointArr[2];
        BigInteger mod = eCPrivateKeyParameters.getD().multiply(eCPoint.getAffineXCoord().toBigInteger().mod(shiftLeft).setBit(bitLength)).add(eCPrivateKeyParameters2.getD()).mod(n);
        BigInteger bit = eCPoint3.getAffineXCoord().toBigInteger().mod(shiftLeft).setBit(bitLength);
        BigInteger mod2 = eCDomainParameters.getH().multiply(mod).mod(n);
        return ECAlgorithms.sumOfTwoMultiplies(eCPoint2, bit.multiply(mod2).mod(n), eCPoint3, mod2);
    }
}
