package org.spongycastle.operator.p031bc;

import org.spongycastle.asn1.kisa.KISAObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

/* renamed from: org.spongycastle.operator.bc.SEEDUtil */
class SEEDUtil {
    SEEDUtil() {
    }

    static AlgorithmIdentifier determineKeyEncAlg() {
        return new AlgorithmIdentifier(KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap);
    }
}
