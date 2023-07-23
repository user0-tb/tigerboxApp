package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.mac.AesCmacParameters;
import com.google.crypto.tink.util.Bytes;
import com.google.crypto.tink.util.SecretBytes;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

public final class AesCmacKey extends MacKey {
    private final SecretBytes aesKeyBytes;
    @Nullable
    private final Integer idRequirement;
    private final AesCmacParameters parameters;

    private AesCmacKey(AesCmacParameters aesCmacParameters, SecretBytes secretBytes, @Nullable Integer num) {
        this.parameters = aesCmacParameters;
        this.aesKeyBytes = secretBytes;
        this.idRequirement = num;
    }

    public static AesCmacKey create(AesCmacParameters aesCmacParameters, SecretBytes secretBytes) throws GeneralSecurityException {
        if (secretBytes.size() != 32) {
            throw new GeneralSecurityException("Invalid key size");
        } else if (!aesCmacParameters.hasIdRequirement()) {
            return new AesCmacKey(aesCmacParameters, secretBytes, (Integer) null);
        } else {
            throw new GeneralSecurityException("Must use createForKeyset for parameters with ID requirement");
        }
    }

    public static AesCmacKey createForKeyset(AesCmacParameters aesCmacParameters, SecretBytes secretBytes, @Nullable Integer num) throws GeneralSecurityException {
        if (secretBytes.size() != 32) {
            throw new GeneralSecurityException("Invalid key size");
        } else if (aesCmacParameters.hasIdRequirement() && num == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with format with ID requirement");
        } else if (aesCmacParameters.hasIdRequirement() || num == null) {
            return new AesCmacKey(aesCmacParameters, secretBytes, num);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with format without ID requirement");
        }
    }

    public SecretBytes getAesKey() {
        return this.aesKeyBytes;
    }

    public Bytes getOutputPrefix() {
        if (this.parameters.getVariant() == AesCmacParameters.Variant.NO_PREFIX) {
            return Bytes.copyFrom(new byte[0]);
        }
        if (this.parameters.getVariant() == AesCmacParameters.Variant.LEGACY || this.parameters.getVariant() == AesCmacParameters.Variant.CRUNCHY) {
            return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 0).putInt(this.idRequirement.intValue()).array());
        }
        if (this.parameters.getVariant() == AesCmacParameters.Variant.TINK) {
            return Bytes.copyFrom(ByteBuffer.allocate(5).put((byte) 1).putInt(this.idRequirement.intValue()).array());
        }
        throw new IllegalStateException("Unknown AesCmacParameters.Variant: " + this.parameters.getVariant());
    }

    public AesCmacParameters getParameters() {
        return this.parameters;
    }

    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public boolean equalsKey(Key key) {
        if (!(key instanceof AesCmacKey)) {
            return false;
        }
        AesCmacKey aesCmacKey = (AesCmacKey) key;
        if (!aesCmacKey.parameters.equals(this.parameters) || !aesCmacKey.aesKeyBytes.equalsSecretBytes(this.aesKeyBytes) || !Objects.equals(aesCmacKey.idRequirement, this.idRequirement)) {
            return false;
        }
        return true;
    }
}
