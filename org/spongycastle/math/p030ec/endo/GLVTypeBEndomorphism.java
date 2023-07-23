package org.spongycastle.math.p030ec.endo;

import java.math.BigInteger;
import org.spongycastle.math.p030ec.ECConstants;
import org.spongycastle.math.p030ec.ECCurve;
import org.spongycastle.math.p030ec.ECPointMap;
import org.spongycastle.math.p030ec.ScaleXPointMap;

/* renamed from: org.spongycastle.math.ec.endo.GLVTypeBEndomorphism */
public class GLVTypeBEndomorphism implements GLVEndomorphism {
    protected final ECCurve curve;
    protected final GLVTypeBParameters parameters;
    protected final ECPointMap pointMap;

    public boolean hasEfficientPointMap() {
        return true;
    }

    public GLVTypeBEndomorphism(ECCurve eCCurve, GLVTypeBParameters gLVTypeBParameters) {
        this.curve = eCCurve;
        this.parameters = gLVTypeBParameters;
        this.pointMap = new ScaleXPointMap(eCCurve.fromBigInteger(gLVTypeBParameters.getBeta()));
    }

    public BigInteger[] decomposeScalar(BigInteger bigInteger) {
        int bits = this.parameters.getBits();
        BigInteger calculateB = calculateB(bigInteger, this.parameters.getG1(), bits);
        BigInteger calculateB2 = calculateB(bigInteger, this.parameters.getG2(), bits);
        BigInteger[] v1 = this.parameters.getV1();
        BigInteger[] v2 = this.parameters.getV2();
        return new BigInteger[]{bigInteger.subtract(calculateB.multiply(v1[0]).add(calculateB2.multiply(v2[0]))), calculateB.multiply(v1[1]).add(calculateB2.multiply(v2[1])).negate()};
    }

    public ECPointMap getPointMap() {
        return this.pointMap;
    }

    /* access modifiers changed from: protected */
    public BigInteger calculateB(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        boolean z = bigInteger2.signum() < 0;
        BigInteger multiply = bigInteger.multiply(bigInteger2.abs());
        boolean testBit = multiply.testBit(i - 1);
        BigInteger shiftRight = multiply.shiftRight(i);
        if (testBit) {
            shiftRight = shiftRight.add(ECConstants.ONE);
        }
        return z ? shiftRight.negate() : shiftRight;
    }
}
