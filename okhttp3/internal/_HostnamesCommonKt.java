package okhttp3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okio.Buffer;

@Metadata(mo33736d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\u001a0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0007H\u0000\u001a\"\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\n\u0010\u000e\u001a\u00020\u0003*\u00020\u0005\u001a\f\u0010\u000f\u001a\u00020\u0003*\u00020\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo33737d2 = {"VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "inet6AddressToAscii", "canParseAsIpAddress", "containsInvalidHostnameAsciiCodes", "okhttp"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -HostnamesCommon.kt */
public final class _HostnamesCommonKt {
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static final boolean canParseAsIpAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches(str);
    }

    public static final boolean containsInvalidHostnameAsciiCodes(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0 || StringsKt.indexOf$default((CharSequence) " #%/:?@[\\]", charAt, 0, false, 6, (Object) null) != -1) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0088 A[LOOP:0: B:1:0x0013->B:36:0x0088, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009a A[EDGE_INSN: B:43:0x009a->B:37:0x009a ?: BREAK  
    EDGE_INSN: B:44:0x009a->B:37:0x009a ?: BREAK  , RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] decodeIpv6(java.lang.String r18, int r19, int r20) {
        /*
            r6 = r18
            r7 = r20
            java.lang.String r0 = "input"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r8 = 16
            byte[] r9 = new byte[r8]
            r11 = -1
            r12 = r19
            r13 = 0
            r14 = -1
            r15 = -1
        L_0x0013:
            r16 = 0
            if (r12 >= r7) goto L_0x009b
            if (r13 != r8) goto L_0x001a
            return r16
        L_0x001a:
            int r5 = r12 + 2
            if (r5 > r7) goto L_0x003d
            r3 = 0
            r4 = 4
            r17 = 0
            java.lang.String r1 = "::"
            r0 = r18
            r2 = r12
            r10 = r5
            r5 = r17
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x003d
            if (r14 == r11) goto L_0x0033
            return r16
        L_0x0033:
            int r13 = r13 + 2
            if (r10 != r7) goto L_0x003a
            r14 = r13
            goto L_0x009b
        L_0x003a:
            r15 = r10
            r14 = r13
            goto L_0x006c
        L_0x003d:
            if (r13 == 0) goto L_0x006b
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = ":"
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x0050
            int r12 = r12 + 1
            goto L_0x006b
        L_0x0050:
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r1 = "."
            r0 = r18
            r2 = r12
            boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x006a
            int r0 = r13 + -2
            boolean r0 = decodeIpv4Suffix(r6, r15, r7, r9, r0)
            if (r0 != 0) goto L_0x0067
            return r16
        L_0x0067:
            int r13 = r13 + 2
            goto L_0x009b
        L_0x006a:
            return r16
        L_0x006b:
            r15 = r12
        L_0x006c:
            r12 = r15
            r0 = 0
        L_0x006e:
            if (r12 >= r7) goto L_0x0080
            char r1 = r6.charAt(r12)
            int r1 = okhttp3.internal._UtilCommonKt.parseHexDigit(r1)
            if (r1 == r11) goto L_0x0080
            int r0 = r0 << 4
            int r0 = r0 + r1
            int r12 = r12 + 1
            goto L_0x006e
        L_0x0080:
            int r1 = r12 - r15
            if (r1 == 0) goto L_0x009a
            r2 = 4
            if (r1 <= r2) goto L_0x0088
            goto L_0x009a
        L_0x0088:
            int r1 = r13 + 1
            int r2 = r0 >>> 8
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r9[r13] = r2
            int r13 = r1 + 1
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r9[r1] = r0
            goto L_0x0013
        L_0x009a:
            return r16
        L_0x009b:
            if (r13 == r8) goto L_0x00ad
            if (r14 != r11) goto L_0x00a0
            return r16
        L_0x00a0:
            int r0 = r13 - r14
            int r0 = 16 - r0
            kotlin.collections.ArraysKt.copyInto((byte[]) r9, (byte[]) r9, (int) r0, (int) r14, (int) r13)
            int r8 = r8 - r13
            int r8 = r8 + r14
            r0 = 0
            kotlin.collections.ArraysKt.fill((byte[]) r9, (byte) r0, (int) r14, (int) r8)
        L_0x00ad:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._HostnamesCommonKt.decodeIpv6(java.lang.String, int, int):byte[]");
    }

    public static final boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
        Intrinsics.checkNotNullParameter(str, "input");
        Intrinsics.checkNotNullParameter(bArr, "address");
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char charAt = str.charAt(i5);
                if (Intrinsics.compare((int) charAt, 48) < 0 || Intrinsics.compare((int) charAt, 57) > 0) {
                    break;
                } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i5++;
                }
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        if (i4 == i3 + 4) {
            return true;
        }
        return false;
    }

    public static final String inet6AddressToAscii(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "address");
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        Buffer buffer = new Buffer();
        while (i < bArr.length) {
            if (i == i2) {
                buffer.writeByte(58);
                i += i4;
                if (i == 16) {
                    buffer.writeByte(58);
                }
            } else {
                if (i > 0) {
                    buffer.writeByte(58);
                }
                buffer.writeHexadecimalUnsignedLong((long) ((_UtilCommonKt.and(bArr[i], 255) << 8) | _UtilCommonKt.and(bArr[i + 1], 255)));
                i += 2;
            }
        }
        return buffer.readUtf8();
    }
}
