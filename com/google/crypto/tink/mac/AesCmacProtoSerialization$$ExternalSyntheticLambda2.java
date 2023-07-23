package com.google.crypto.tink.mac;

import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.internal.ParametersParser;
import com.google.crypto.tink.internal.ProtoParametersSerialization;
import com.google.crypto.tink.internal.Serialization;

public final /* synthetic */ class AesCmacProtoSerialization$$ExternalSyntheticLambda2 implements ParametersParser.ParametersParsingFunction {
    public static final /* synthetic */ AesCmacProtoSerialization$$ExternalSyntheticLambda2 INSTANCE = new AesCmacProtoSerialization$$ExternalSyntheticLambda2();

    private /* synthetic */ AesCmacProtoSerialization$$ExternalSyntheticLambda2() {
    }

    public final Parameters parseParameters(Serialization serialization) {
        return AesCmacProtoSerialization.parseParameters((ProtoParametersSerialization) serialization);
    }
}
