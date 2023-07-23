package org.spongycastle.pqc.crypto.ntru;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.crypto.ntru.NTRUSigningPrivateKeyParameters;
import org.spongycastle.pqc.math.ntru.euclid.BigIntEuclidean;
import org.spongycastle.pqc.math.ntru.polynomial.BigDecimalPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.BigIntPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Resultant;

public class NTRUSigningKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NTRUSigningKeyGenerationParameters params;

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.params = (NTRUSigningKeyGenerationParameters) keyGenerationParameters;
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        int i = this.params.f1420B;
        while (true) {
            nTRUSigningPublicKeyParameters = null;
            if (i < 0) {
                break;
            }
            arrayList.add(newCachedThreadPool.submit(new BasisGenerationTask()));
            i--;
        }
        newCachedThreadPool.shutdown();
        ArrayList arrayList2 = new ArrayList();
        int i2 = this.params.f1420B;
        while (i2 >= 0) {
            Future future = (Future) arrayList.get(i2);
            try {
                arrayList2.add(future.get());
                if (i2 == this.params.f1420B) {
                    nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(((NTRUSigningPrivateKeyParameters.Basis) future.get()).f1437h, this.params.getSigningParameters());
                }
                i2--;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters((List<NTRUSigningPrivateKeyParameters.Basis>) arrayList2, nTRUSigningPublicKeyParameters));
    }

    public AsymmetricCipherKeyPair generateKeyPairSingleThread() {
        ArrayList arrayList = new ArrayList();
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = null;
        for (int i = this.params.f1420B; i >= 0; i--) {
            NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis = generateBoundedBasis();
            arrayList.add(generateBoundedBasis);
            if (i == 0) {
                nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(generateBoundedBasis.f1437h, this.params.getSigningParameters());
            }
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRUSigningPublicKeyParameters, (AsymmetricKeyParameter) new NTRUSigningPrivateKeyParameters((List<NTRUSigningPrivateKeyParameters.Basis>) arrayList, nTRUSigningPublicKeyParameters));
    }

    private void minimizeFG(IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, IntegerPolynomial integerPolynomial4, int i) {
        IntegerPolynomial integerPolynomial5 = integerPolynomial;
        IntegerPolynomial integerPolynomial6 = integerPolynomial2;
        IntegerPolynomial integerPolynomial7 = integerPolynomial3;
        IntegerPolynomial integerPolynomial8 = integerPolynomial4;
        int i2 = i;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += i2 * 2 * ((integerPolynomial5.coeffs[i4] * integerPolynomial5.coeffs[i4]) + (integerPolynomial6.coeffs[i4] * integerPolynomial6.coeffs[i4]));
        }
        int i5 = i3 - 4;
        IntegerPolynomial integerPolynomial9 = (IntegerPolynomial) integerPolynomial.clone();
        IntegerPolynomial integerPolynomial10 = (IntegerPolynomial) integerPolynomial2.clone();
        int i6 = 0;
        int i7 = 0;
        while (i6 < i2 && i7 < i2) {
            int i8 = 0;
            for (int i9 = 0; i9 < i2; i9++) {
                i8 += i2 * 4 * ((integerPolynomial7.coeffs[i9] * integerPolynomial5.coeffs[i9]) + (integerPolynomial8.coeffs[i9] * integerPolynomial6.coeffs[i9]));
            }
            int sumCoeffs = i8 - ((integerPolynomial3.sumCoeffs() + integerPolynomial4.sumCoeffs()) * 4);
            if (sumCoeffs > i5) {
                integerPolynomial7.sub(integerPolynomial9);
                integerPolynomial8.sub(integerPolynomial10);
            } else if (sumCoeffs < (-i5)) {
                integerPolynomial7.add(integerPolynomial9);
                integerPolynomial8.add(integerPolynomial10);
            } else {
                i7++;
                integerPolynomial9.rotate1();
                integerPolynomial10.rotate1();
            }
            i6++;
            i7 = 0;
            i7++;
            integerPolynomial9.rotate1();
            integerPolynomial10.rotate1();
        }
    }

    private FGBasis generateBasis() {
        boolean z;
        Polynomial polynomial;
        Polynomial polynomial2;
        IntegerPolynomial integerPolynomial;
        IntegerPolynomial invertFq;
        int i;
        int i2;
        int i3;
        Resultant resultant;
        Polynomial polynomial3;
        IntegerPolynomial integerPolynomial2;
        IntegerPolynomial integerPolynomial3;
        Polynomial polynomial4;
        Polynomial polynomial5;
        IntegerPolynomial integerPolynomial4;
        Resultant resultant2;
        BigIntEuclidean calculate;
        BigIntPolynomial bigIntPolynomial;
        IntegerPolynomial integerPolynomial5;
        IntegerPolynomial integerPolynomial6;
        int i4 = this.params.f1421N;
        int i5 = this.params.f1426q;
        int i6 = this.params.f1422d;
        int i7 = this.params.f1423d1;
        int i8 = this.params.f1424d2;
        int i9 = this.params.f1425d3;
        int i10 = this.params.basisType;
        int i11 = (i4 * 2) + 1;
        boolean z2 = this.params.primeCheck;
        while (true) {
            if (this.params.polyType == 0) {
                polynomial = DenseTernaryPolynomial.generateRandom(i4, i6 + 1, i6, new SecureRandom());
                z = z2;
            } else {
                z = z2;
                polynomial = ProductFormPolynomial.generateRandom(i4, i7, i8, i9 + 1, i9, new SecureRandom());
            }
            polynomial2 = polynomial;
            integerPolynomial = polynomial2.toIntegerPolynomial();
            if ((!z || !integerPolynomial.resultant(i11).res.equals(BigInteger.ZERO)) && (invertFq = integerPolynomial.invertFq(i5)) != null) {
                break;
            }
            z2 = z;
        }
        Resultant resultant3 = integerPolynomial.resultant();
        while (true) {
            if (this.params.polyType == 0) {
                polynomial4 = DenseTernaryPolynomial.generateRandom(i4, i6 + 1, i6, new SecureRandom());
                resultant = resultant3;
                i2 = i7;
                i3 = i8;
                i = i9;
                integerPolynomial3 = invertFq;
                integerPolynomial2 = integerPolynomial;
                polynomial3 = polynomial2;
            } else {
                int i12 = i7;
                resultant = resultant3;
                int i13 = i8;
                i2 = i7;
                integerPolynomial3 = invertFq;
                int i14 = i9 + 1;
                i3 = i8;
                integerPolynomial2 = integerPolynomial;
                int i15 = i9;
                i = i9;
                polynomial3 = polynomial2;
                polynomial4 = ProductFormPolynomial.generateRandom(i4, i12, i13, i14, i15, new SecureRandom());
            }
            polynomial5 = polynomial4;
            integerPolynomial4 = polynomial5.toIntegerPolynomial();
            if (!z || !integerPolynomial4.resultant(i11).res.equals(BigInteger.ZERO)) {
                if (integerPolynomial4.invertFq(i5) != null) {
                    resultant2 = integerPolynomial4.resultant();
                    calculate = BigIntEuclidean.calculate(resultant.res, resultant2.res);
                    if (calculate.gcd.equals(BigInteger.ONE)) {
                        break;
                    }
                }
            }
            invertFq = integerPolynomial3;
            integerPolynomial = integerPolynomial2;
            polynomial2 = polynomial3;
            resultant3 = resultant;
            i8 = i3;
            i7 = i2;
            i9 = i;
        }
        BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) resultant.rho.clone();
        int i16 = i10;
        Resultant resultant4 = resultant;
        bigIntPolynomial2.mult(calculate.f1503x.multiply(BigInteger.valueOf((long) i5)));
        BigIntPolynomial bigIntPolynomial3 = (BigIntPolynomial) resultant2.rho.clone();
        bigIntPolynomial3.mult(calculate.f1504y.multiply(BigInteger.valueOf((long) (-i5))));
        int i17 = 0;
        if (this.params.keyGenAlg == 0) {
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            iArr[0] = integerPolynomial2.coeffs[0];
            iArr2[0] = integerPolynomial4.coeffs[0];
            for (int i18 = 1; i18 < i4; i18++) {
                int i19 = i4 - i18;
                iArr[i18] = integerPolynomial2.coeffs[i19];
                iArr2[i18] = integerPolynomial4.coeffs[i19];
            }
            IntegerPolynomial integerPolynomial7 = new IntegerPolynomial(iArr);
            IntegerPolynomial integerPolynomial8 = new IntegerPolynomial(iArr2);
            IntegerPolynomial mult = polynomial3.mult(integerPolynomial7);
            mult.add(polynomial5.mult(integerPolynomial8));
            Resultant resultant5 = mult.resultant();
            BigIntPolynomial mult2 = integerPolynomial7.mult(bigIntPolynomial3);
            mult2.add(integerPolynomial8.mult(bigIntPolynomial2));
            bigIntPolynomial = mult2.mult(resultant5.rho);
            bigIntPolynomial.div(resultant5.res);
        } else {
            for (int i20 = 1; i20 < i4; i20 *= 10) {
                i17++;
            }
            BigDecimalPolynomial div = resultant4.rho.div(new BigDecimal(resultant4.res), bigIntPolynomial3.getMaxCoeffLength() + 1 + i17);
            BigDecimalPolynomial div2 = resultant2.rho.div(new BigDecimal(resultant2.res), bigIntPolynomial2.getMaxCoeffLength() + 1 + i17);
            BigDecimalPolynomial mult3 = div.mult(bigIntPolynomial3);
            mult3.add(div2.mult(bigIntPolynomial2));
            mult3.halve();
            bigIntPolynomial = mult3.round();
        }
        BigIntPolynomial bigIntPolynomial4 = (BigIntPolynomial) bigIntPolynomial3.clone();
        bigIntPolynomial4.sub(polynomial3.mult(bigIntPolynomial));
        BigIntPolynomial bigIntPolynomial5 = (BigIntPolynomial) bigIntPolynomial2.clone();
        bigIntPolynomial5.sub(polynomial5.mult(bigIntPolynomial));
        IntegerPolynomial integerPolynomial9 = new IntegerPolynomial(bigIntPolynomial4);
        IntegerPolynomial integerPolynomial10 = new IntegerPolynomial(bigIntPolynomial5);
        minimizeFG(integerPolynomial2, integerPolynomial4, integerPolynomial9, integerPolynomial10, i4);
        if (i16 == 0) {
            integerPolynomial5 = polynomial5.mult(integerPolynomial3, i5);
            integerPolynomial6 = integerPolynomial9;
        } else {
            integerPolynomial5 = integerPolynomial9.mult(integerPolynomial3, i5);
            integerPolynomial6 = polynomial5;
        }
        integerPolynomial5.modPositive(i5);
        return new FGBasis(polynomial3, integerPolynomial6, integerPolynomial5, integerPolynomial9, integerPolynomial10, this.params);
    }

    public NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis() {
        FGBasis generateBasis;
        do {
            generateBasis = generateBasis();
        } while (!generateBasis.isNormOk());
        return generateBasis;
    }

    private class BasisGenerationTask implements Callable<NTRUSigningPrivateKeyParameters.Basis> {
        private BasisGenerationTask() {
        }

        public NTRUSigningPrivateKeyParameters.Basis call() throws Exception {
            return NTRUSigningKeyPairGenerator.this.generateBoundedBasis();
        }
    }

    public class FGBasis extends NTRUSigningPrivateKeyParameters.Basis {

        /* renamed from: F */
        public IntegerPolynomial f1427F;

        /* renamed from: G */
        public IntegerPolynomial f1428G;

        FGBasis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            super(polynomial, polynomial2, integerPolynomial, nTRUSigningKeyGenerationParameters);
            this.f1427F = integerPolynomial2;
            this.f1428G = integerPolynomial3;
        }

        /* access modifiers changed from: package-private */
        public boolean isNormOk() {
            double d = this.params.keyNormBoundSq;
            int i = this.params.f1426q;
            return ((double) this.f1427F.centeredNormSq(i)) < d && ((double) this.f1428G.centeredNormSq(i)) < d;
        }
    }
}
