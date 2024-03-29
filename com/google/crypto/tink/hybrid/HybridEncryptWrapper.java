package com.google.crypto.tink.hybrid;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.PrimitiveSet;
import com.google.crypto.tink.PrimitiveWrapper;
import com.google.crypto.tink.Registry;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;

public class HybridEncryptWrapper implements PrimitiveWrapper<HybridEncrypt, HybridEncrypt> {

    private static class WrappedHybridEncrypt implements HybridEncrypt {
        final PrimitiveSet<HybridEncrypt> primitives;

        public WrappedHybridEncrypt(PrimitiveSet<HybridEncrypt> primitiveSet) {
            this.primitives = primitiveSet;
        }

        public byte[] encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
            if (this.primitives.getPrimary() != null) {
                return Bytes.concat(this.primitives.getPrimary().getIdentifier(), this.primitives.getPrimary().getPrimitive().encrypt(bArr, bArr2));
            }
            throw new GeneralSecurityException("keyset without primary key");
        }
    }

    HybridEncryptWrapper() {
    }

    public HybridEncrypt wrap(PrimitiveSet<HybridEncrypt> primitiveSet) {
        return new WrappedHybridEncrypt(primitiveSet);
    }

    public Class<HybridEncrypt> getPrimitiveClass() {
        return HybridEncrypt.class;
    }

    public Class<HybridEncrypt> getInputPrimitiveClass() {
        return HybridEncrypt.class;
    }

    public static void register() throws GeneralSecurityException {
        Registry.registerPrimitiveWrapper(new HybridEncryptWrapper());
    }
}
