package com.google.crypto.tink.internal;

import com.google.common.base.Ascii;
import com.google.crypto.tink.util.Bytes;
import java.security.SecureRandom;
import javax.annotation.Nullable;

/* renamed from: com.google.crypto.tink.internal.Util */
public final class C2194Util {
    public static int randKeyId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b = 0;
        while (b == 0) {
            secureRandom.nextBytes(bArr);
            b = ((bArr[0] & Byte.MAX_VALUE) << Ascii.CAN) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b;
    }

    private static final byte toByteFromPrintableAscii(char c) {
        if (c >= '!' && c <= '~') {
            return (byte) c;
        }
        throw new TinkBugException("Not a printable ASCII character: " + c);
    }

    public static final Bytes toBytesFromPrintableAscii(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = toByteFromPrintableAscii(str.charAt(i));
        }
        return Bytes.copyFrom(bArr);
    }

    @Nullable
    public static Integer getAndroidApiLevel() {
        return BuildDispatchedCode.getApiLevel();
    }

    private C2194Util() {
    }
}
