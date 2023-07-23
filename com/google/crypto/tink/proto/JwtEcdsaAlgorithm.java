package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum JwtEcdsaAlgorithm implements Internal.EnumLite {
    ES_UNKNOWN(0),
    ES256(1),
    ES384(2),
    ES512(3),
    UNRECOGNIZED(-1);
    
    public static final int ES256_VALUE = 1;
    public static final int ES384_VALUE = 2;
    public static final int ES512_VALUE = 3;
    public static final int ES_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<JwtEcdsaAlgorithm>() {
            public JwtEcdsaAlgorithm findValueByNumber(int i) {
                return JwtEcdsaAlgorithm.forNumber(i);
            }
        };
    }

    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    public static JwtEcdsaAlgorithm valueOf(int i) {
        return forNumber(i);
    }

    public static JwtEcdsaAlgorithm forNumber(int i) {
        if (i == 0) {
            return ES_UNKNOWN;
        }
        if (i == 1) {
            return ES256;
        }
        if (i == 2) {
            return ES384;
        }
        if (i != 3) {
            return null;
        }
        return ES512;
    }

    public static Internal.EnumLiteMap<JwtEcdsaAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtEcdsaAlgorithmVerifier.INSTANCE;
    }

    private static final class JwtEcdsaAlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private JwtEcdsaAlgorithmVerifier() {
        }

        static {
            INSTANCE = new JwtEcdsaAlgorithmVerifier();
        }

        public boolean isInRange(int i) {
            return JwtEcdsaAlgorithm.forNumber(i) != null;
        }
    }

    private JwtEcdsaAlgorithm(int i) {
        this.value = i;
    }
}
