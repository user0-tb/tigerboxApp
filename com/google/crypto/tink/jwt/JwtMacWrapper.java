package com.google.crypto.tink.jwt;

import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

class JwtMacWrapper implements PrimitiveWrapper<JwtMacInternal, JwtMac> {
    private static void validate(PrimitiveSet<JwtMacInternal> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet.getPrimary() != null) {
            for (List<PrimitiveSet.Entry<JwtMacInternal>> it : primitiveSet.getAll()) {
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
            return;
        }
        throw new GeneralSecurityException("Primitive set has no primary.");
    }

    @Immutable
    private static class WrappedJwtMac implements JwtMac {
        private final PrimitiveSet<JwtMacInternal> primitives;

        private WrappedJwtMac(PrimitiveSet<JwtMacInternal> primitiveSet) {
            this.primitives = primitiveSet;
        }

        public String computeMacAndEncode(RawJwt rawJwt) throws GeneralSecurityException {
            PrimitiveSet.Entry<JwtMacInternal> primary = this.primitives.getPrimary();
            return primary.getPrimitive().computeMacAndEncodeWithKid(rawJwt, JwtFormat.getKid(primary.getKeyId(), primary.getOutputPrefixType()));
        }

        public VerifiedJwt verifyMacAndDecode(String str, JwtValidator jwtValidator) throws GeneralSecurityException {
            GeneralSecurityException generalSecurityException = null;
            for (List<PrimitiveSet.Entry<JwtMacInternal>> it : this.primitives.getAll()) {
                Iterator it2 = it.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        PrimitiveSet.Entry entry = (PrimitiveSet.Entry) it2.next();
                        try {
                            return ((JwtMacInternal) entry.getPrimitive()).verifyMacAndDecodeWithKid(str, jwtValidator, JwtFormat.getKid(entry.getKeyId(), entry.getOutputPrefixType()));
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
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    JwtMacWrapper() {
    }

    public JwtMac wrap(PrimitiveSet<JwtMacInternal> primitiveSet) throws GeneralSecurityException {
        validate(primitiveSet);
        return new WrappedJwtMac(primitiveSet);
    }

    public Class<JwtMac> getPrimitiveClass() {
        return JwtMac.class;
    }

    public Class<JwtMacInternal> getInputPrimitiveClass() {
        return JwtMacInternal.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new JwtMacWrapper());
    }
}
