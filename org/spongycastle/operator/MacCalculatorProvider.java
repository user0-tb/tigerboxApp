package org.spongycastle.operator;

import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public interface MacCalculatorProvider {
    MacCalculator get(AlgorithmIdentifier algorithmIdentifier);
}
