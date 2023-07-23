package com.google.crypto.tink.jwt;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

class JwtPublicKeyVerifyWrapper implements PrimitiveWrapper<JwtPublicKeyVerifyInternal, JwtPublicKeyVerify> {
    JwtPublicKeyVerifyWrapper() {
    }

    private static void validate(PrimitiveSet<JwtPublicKeyVerifyInternal> primitiveSet) throws GeneralSecurityException {
        for (List<PrimitiveSet.Entry<JwtPublicKeyVerifyInternal>> it : primitiveSet.getAll()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    PrimitiveSet.Entry entry = (PrimitiveSet.Entry) it2.next();
                    if (entry.getOutputPrefixType() != OutputPrefixType.RAW && entry.getOutputPrefixType() != OutputPrefixType.TINK) {
                        throw new GeneralSecurityException("unsupported OutputPrefixType");
                    }
                }
            }
        }
    }

    @Immutable
    private static class WrappedJwtPublicKeyVerify implements JwtPublicKeyVerify {
        private final PrimitiveSet<JwtPublicKeyVerifyInternal> primitives;

        public WrappedJwtPublicKeyVerify(PrimitiveSet<JwtPublicKeyVerifyInternal> primitiveSet) {
            this.primitives = primitiveSet;
        }

        public VerifiedJwt verifyAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException {
            GeneralSecurityException generalSecurityException = null;
            for (List<PrimitiveSet.Entry<JwtPublicKeyVerifyInternal>> it : this.primitives.getAll()) {
                Iterator it2 = it.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        PrimitiveSet.Entry entry = (PrimitiveSet.Entry) it2.next();
                        try {
                            return ((JwtPublicKeyVerifyInternal) entry.getPrimitive()).verifyAndDecodeWithKid(str, jwtValidator, JwtFormat.getKid(entry.getKeyId(), entry.getOutputPrefixType()));
                        } catch (GeneralSecurityException e) {
                            if (e instanceof JwtInvalidException) {
                                generalSecurityException = e;
                            }
                        }
                    }
                }
            }
            if (generalSecurityException != null) {
                throw generalSecurityException;
            }
            throw new GeneralSecurityException("invalid JWT");
        }
    }

    public JwtPublicKeyVerify wrap(PrimitiveSet<JwtPublicKeyVerifyInternal> primitiveSet) throws GeneralSecurityException {
        validate(primitiveSet);
        return new WrappedJwtPublicKeyVerify(primitiveSet);
    }

    public Class<JwtPublicKeyVerify> getPrimitiveClass() {
        return JwtPublicKeyVerify.class;
    }

    public Class<JwtPublicKeyVerifyInternal> getInputPrimitiveClass() {
        return JwtPublicKeyVerifyInternal.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new JwtPublicKeyVerifyWrapper());
    }
}
