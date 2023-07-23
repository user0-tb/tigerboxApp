package com.google.crypto.tink.mac;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.ParametersSerializer;
import com.google.crypto.tink.internal.Serialization;

public final /* synthetic */ class AesCmacProtoSerialization$$ExternalSyntheticLambda3 implements ParametersSerializer.ParametersSerializationFunction {
    public static final /* synthetic */ AesCmacProtoSerialization$$ExternalSyntheticLambda3 INSTANCE = new AesCmacProtoSerialization$$ExternalSyntheticLambda3();

    private /* synthetic */ AesCmacProtoSerialization$$ExternalSyntheticLambda3() {
    }

    public final Serialization serializeParameters(Parameters parameters) {
        return AesCmacProtoSerialization.serializeParameters((AesCmacParameters) parameters);
    }
}
