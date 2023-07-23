package com.google.crypto.tink.proto;

import com.google.crypto.tink.shaded.protobuf.Internal;

public enum JwtHmacAlgorithm implements Internal.EnumLite {
    HS_UNKNOWN(0),
    HS256(1),
    HS384(2),
    HS512(3),
    UNRECOGNIZED(-1);
    
    public static final int HS256_VALUE = 1;
    public static final int HS384_VALUE = 2;
    public static final int HS512_VALUE = 3;
    public static final int HS_UNKNOWN_VALUE = 0;
    private static final Internal.EnumLiteMap<JwtHmacAlgorithm> internalValueMap = null;
    private final int value;

    static {
        internalValueMap = new Internal.EnumLiteMap<JwtHmacAlgorithm>() {
            public JwtHmacAlgorithm findValueByNumber(int i) {
                return JwtHmacAlgorithm.forNumber(i);
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
    public static JwtHmacAlgorithm valueOf(int i) {
        return forNumber(i);
    }

    public static JwtHmacAlgorithm forNumber(int i) {
        if (i == 0) {
            return HS_UNKNOWN;
        }
        if (i == 1) {
            return HS256;
        }
        if (i == 2) {
            return HS384;
        }
        if (i != 3) {
            return null;
        }
        return HS512;
    }

    public static Internal.EnumLiteMap<JwtHmacAlgorithm> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return JwtHmacAlgorithmVerifier.INSTANCE;
    }

    private static final class JwtHmacAlgorithmVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = null;

        private JwtHmacAlgorithmVerifier() {
        }

        static {
            INSTANCE = new JwtHmacAlgorithmVerifier();
        }

        public boolean isInRange(int i) {
            return JwtHmacAlgorithm.forNumber(i) != null;
        }
    }

    private JwtHmacAlgorithm(int i) {
        this.value = i;
    }
}
