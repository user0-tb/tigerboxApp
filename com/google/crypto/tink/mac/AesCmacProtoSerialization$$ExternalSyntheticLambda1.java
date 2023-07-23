package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeySerializer;
import com.google.crypto.tink.internal.Serialization;

public final /* synthetic */ class AesCmacProtoSerialization$$ExternalSyntheticLambda1 implements KeySerializer.KeySerializationFunction {
    public static final /* synthetic */ AesCmacProtoSerialization$$ExternalSyntheticLambda1 INSTANCE = new AesCmacProtoSerialization$$ExternalSyntheticLambda1();

    private /* synthetic */ AesCmacProtoSerialization$$ExternalSyntheticLambda1() {
    }

    public final Serialization serializeKey(Key key, SecretKeyAccess secretKeyAccess) {
        return AesCmacProtoSerialization.serializeKey((AesCmacKey) key, secretKeyAccess);
    }
}
