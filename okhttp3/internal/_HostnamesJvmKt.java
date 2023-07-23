package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo33736d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0001¨\u0006\u0002"}, mo33737d2 = {"toCanonicalHost", "", "okhttp"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -HostnamesJvm.kt */
public final class _HostnamesJvmKt {
    public static final String toCanonicalHost(String str) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z = false;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) ":", false, 2, (Object) null)) {
            if (!StringsKt.startsWith$default(str, "[", false, 2, (Object) null) || !StringsKt.endsWith$default(str, "]", false, 2, (Object) null)) {
                bArr = _HostnamesCommonKt.decodeIpv6(str, 0, str.length());
            } else {
                bArr = _HostnamesCommonKt.decodeIpv6(str, 1, str.length() - 1);
            }
            if (bArr == null) {
                return null;
            }
            InetAddress byAddress = InetAddress.getByAddress(bArr);
            byte[] address = byAddress.getAddress();
            if (address.length == 16) {
                Intrinsics.checkNotNullExpressionValue(address, "address");
                return _HostnamesCommonKt.inet6AddressToAscii(address);
            } else if (address.length == 4) {
                return byAddress.getHostAddress();
            } else {
                throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
            }
        } else {
            try {
                String ascii = IDN.toASCII(str);
                Intrinsics.checkNotNullExpressionValue(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                String lowerCase = ascii.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() == 0) {
                    z = true;
                }
                if (z) {
                    return null;
                }
                if (_HostnamesCommonKt.containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }
}
