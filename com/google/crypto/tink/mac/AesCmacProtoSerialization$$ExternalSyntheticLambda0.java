package com.google.crypto.tink.mac;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.internal.KeyParser;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.Serialization;

public final /* synthetic */ class AesCmacProtoSerialization$$ExternalSyntheticLambda0 implements KeyParser.KeyParsingFunction {
    public static final /* synthetic */ AesCmacProtoSerialization$$ExternalSyntheticLambda0 INSTANCE = new AesCmacProtoSerialization$$ExternalSyntheticLambda0();

    private /* synthetic */ AesCmacProtoSerialization$$ExternalSyntheticLambda0() {
    }

    public final Key parseKey(Serialization serialization, SecretKeyAccess secretKeyAccess) {
        return AesCmacProtoSerialization.parseKey((ProtoKeySerialization) serialization, secretKeyAccess);
    }
}
