package org.spongycastle.cms;

import org.spongycastle.operator.OperatorCreationException;

public interface SignerInformationVerifierProvider {
    SignerInformationVerifier get(SignerId signerId) throws OperatorCreationException;
}
