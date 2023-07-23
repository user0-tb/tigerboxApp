package com.google.common.base;

import com.google.android.exoplayer2.C0963C;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
public final class Charsets {
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset US_ASCII = Charset.forName(C0963C.ASCII_NAME);
    public static final Charset UTF_16 = Charset.forName(C0963C.UTF16_NAME);
    public static final Charset UTF_16BE = Charset.forName("UTF-16BE");
    public static final Charset UTF_16LE = Charset.forName(C0963C.UTF16LE_NAME);
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    private Charsets() {
    }
}
