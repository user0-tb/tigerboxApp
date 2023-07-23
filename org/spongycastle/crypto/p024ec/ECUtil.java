package org.spongycastle.crypto.p024ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.spongycastle.math.p030ec.ECConstants;

/* renamed from: org.spongycastle.crypto.ec.ECUtil */
class ECUtil {
    ECUtil() {
    }

    static BigInteger generateK(BigInteger bigInteger, SecureRandom secureRandom) {
        int bitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigInteger2 = new BigInteger(bitLength, secureRandom);
            if (!bigInteger2.equals(ECConstants.ZERO) && bigInteger2.compareTo(bigInteger) < 0) {
                return bigInteger2;
            }
        }
    }
}
