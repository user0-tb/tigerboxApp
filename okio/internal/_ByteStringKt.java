package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;

@Metadata(mo33736d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005¨\u0006>"}, mo33737d2 = {"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonCopyInto", "", "offset", "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -ByteString.kt */
public final class _ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }

    public static final String commonUtf8(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String utf8$okio = byteString.getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(byteString.internalArray$okio());
        byteString.setUtf8$okio(utf8String);
        return utf8String;
    }

    public static final String commonBase64(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64$default(byteString.getData$okio(), (byte[]) null, 1, (Object) null);
    }

    public static final String commonBase64Url(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return _Base64Kt.encodeBase64(byteString.getData$okio(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final String commonHex(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        char[] cArr = new char[(byteString.getData$okio().length * 2)];
        int i = 0;
        for (byte b : byteString.getData$okio()) {
            int i2 = i + 1;
            cArr[i] = getHEX_DIGIT_CHARS()[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = getHEX_DIGIT_CHARS()[b & Ascii.f278SI];
        }
        return StringsKt.concatToString(cArr);
    }

    public static final ByteString commonToAsciiLowercase(ByteString byteString) {
        byte b;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int i = 0;
        while (i < byteString.getData$okio().length) {
            byte b2 = byteString.getData$okio()[i];
            byte b3 = (byte) 65;
            if (b2 < b3 || b2 > (b = (byte) 90)) {
                i++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final ByteString commonToAsciiUppercase(ByteString byteString) {
        byte b;
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int i = 0;
        while (i < byteString.getData$okio().length) {
            byte b2 = byteString.getData$okio()[i];
            byte b3 = (byte) 97;
            if (b2 < b3 || b2 > (b = (byte) 122)) {
                i++;
            } else {
                byte[] data$okio = byteString.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
                copyOf[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < copyOf.length; i2++) {
                    byte b4 = copyOf[i2];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i2] = (byte) (b4 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    public static final ByteString commonSubstring(ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString, i2);
        boolean z = true;
        if (i >= 0) {
            if (resolveDefaultParameter <= byteString.getData$okio().length) {
                if (resolveDefaultParameter - i < 0) {
                    z = false;
                }
                if (!z) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i == 0 && resolveDefaultParameter == byteString.getData$okio().length) {
                    return byteString;
                } else {
                    return new ByteString(ArraysKt.copyOfRange(byteString.getData$okio(), i, resolveDefaultParameter));
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public static final byte commonGetByte(ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio()[i];
    }

    public static final int commonGetSize(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio().length;
    }

    public static final byte[] commonToByteArray(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        byte[] data$okio = byteString.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return copyOf;
    }

    public static final byte[] commonInternalArray(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.getData$okio();
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i, ByteString byteString2, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString2.rangeEquals(i2, byteString.getData$okio(), i, i3);
    }

    public static final boolean commonRangeEquals(ByteString byteString, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        return i >= 0 && i <= byteString.getData$okio().length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && _UtilKt.arrayRangeEquals(byteString.getData$okio(), i, bArr, i2, i3);
    }

    public static final void commonCopyInto(ByteString byteString, int i, byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, TypedValues.AttributesType.S_TARGET);
        ArraysKt.copyInto(byteString.getData$okio(), bArr, i2, i, i3 + i);
    }

    public static final boolean commonStartsWith(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final boolean commonStartsWith(ByteString byteString, byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "prefix");
        return byteString.rangeEquals(0, bArr, 0, bArr.length);
    }

    public static final boolean commonEndsWith(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEndsWith(ByteString byteString, byte[] bArr) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "suffix");
        return byteString.rangeEquals(byteString.size() - bArr.length, bArr, 0, bArr.length);
    }

    public static final int commonIndexOf(ByteString byteString, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        int length = byteString.getData$okio().length - bArr.length;
        int max = Math.max(i, 0);
        if (max > length) {
            return -1;
        }
        while (!_UtilKt.arrayRangeEquals(byteString.getData$okio(), max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public static final int commonLastIndexOf(ByteString byteString, ByteString byteString2, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), i);
    }

    public static final int commonLastIndexOf(ByteString byteString, byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (int min = Math.min(_UtilKt.resolveDefaultParameter(byteString, i), byteString.getData$okio().length - bArr.length); -1 < min; min--) {
            if (_UtilKt.arrayRangeEquals(byteString.getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonEquals(ByteString byteString, Object obj) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            return byteString2.size() == byteString.getData$okio().length && byteString2.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length);
        }
    }

    public static final int commonHashCode(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        int hashCode$okio = byteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(hashCode);
        return hashCode;
    }

    public static final int commonCompareTo(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, "other");
        int size = byteString.size();
        int size2 = byteString2.size();
        int min = Math.min(size, size2);
        int i = 0;
        while (i < min) {
            byte b = byteString.getByte(i) & 255;
            byte b2 = byteString2.getByte(i) & 255;
            if (b == b2) {
                i++;
            } else if (b < b2) {
                return -1;
            } else {
                return 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        if (size < size2) {
            return -1;
        }
        return 1;
    }

    public static final ByteString commonOf(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final ByteString commonToByteString(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(bArr, i2);
        _UtilKt.checkOffsetAndCount((long) bArr.length, (long) i, (long) resolveDefaultParameter);
        return new ByteString(ArraysKt.copyOfRange(bArr, i, resolveDefaultParameter + i));
    }

    public static final ByteString commonEncodeUtf8(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
        byteString.setUtf8$okio(str);
        return byteString;
    }

    public static final ByteString commonDecodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    public static final ByteString commonDecodeHex(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i = 0; i < length; i++) {
                int i2 = i * 2;
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i2)) << 4) + decodeHexDigit(str.charAt(i2 + 1)));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
    }

    public static final void commonWrite(ByteString byteString, Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.write(byteString.getData$okio(), i, i2);
    }

    /* access modifiers changed from: private */
    public static final int decodeHexDigit(char c) {
        boolean z = true;
        if ('0' <= c && c < ':') {
            return c - '0';
        }
        char c2 = 'a';
        if (!('a' <= c && c < 'g')) {
            c2 = 'A';
            if ('A' > c || c >= 'G') {
                z = false;
            }
            if (!z) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c);
            }
        }
        return (c - c2) + 10;
    }

    public static final String commonToString(ByteString byteString) {
        ByteString byteString2 = byteString;
        Intrinsics.checkNotNullParameter(byteString2, "<this>");
        boolean z = true;
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int access$codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (access$codePointIndexToCharIndex != -1) {
            String utf8 = byteString.utf8();
            String substring = utf8.substring(0, access$codePointIndexToCharIndex);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String replace$default = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null), "\n", "\\n", false, 4, (Object) null), "\r", "\\r", false, 4, (Object) null);
            if (access$codePointIndexToCharIndex < utf8.length()) {
                return "[size=" + byteString.getData$okio().length + " text=" + replace$default + "…]";
            }
            return "[text=" + replace$default + ']';
        } else if (byteString.getData$okio().length <= 64) {
            return "[hex=" + byteString.hex() + ']';
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(byteString.getData$okio().length);
            sb.append(" hex=");
            int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(byteString2, 64);
            if (resolveDefaultParameter <= byteString.getData$okio().length) {
                if (resolveDefaultParameter + 0 < 0) {
                    z = false;
                }
                if (z) {
                    if (resolveDefaultParameter != byteString.getData$okio().length) {
                        byteString2 = new ByteString(ArraysKt.copyOfRange(byteString.getData$okio(), 0, resolveDefaultParameter));
                    }
                    sb.append(byteString2.hex());
                    sb.append("…]");
                    return sb.toString();
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0044 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x015e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x007c A[EDGE_INSN: B:263:0x007c->B:51:0x007c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:274:0x00d3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0201 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        /*
            r0 = r19
            r1 = r20
            int r2 = r0.length
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0008:
            if (r4 >= r2) goto L_0x0212
            byte r7 = r0[r4]
            r8 = 160(0xa0, float:2.24E-43)
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 32
            r11 = 13
            r12 = 65533(0xfffd, float:9.1831E-41)
            r13 = 10
            r14 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            r17 = 1
            if (r7 < 0) goto L_0x0085
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x0026
            return r5
        L_0x0026:
            if (r7 == r13) goto L_0x0042
            if (r7 == r11) goto L_0x0042
            if (r7 < 0) goto L_0x0030
            if (r7 >= r10) goto L_0x0030
            r6 = 1
            goto L_0x0031
        L_0x0030:
            r6 = 0
        L_0x0031:
            if (r6 != 0) goto L_0x003f
            if (r9 > r7) goto L_0x0039
            if (r7 >= r8) goto L_0x0039
            r6 = 1
            goto L_0x003a
        L_0x0039:
            r6 = 0
        L_0x003a:
            if (r6 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r6 = 0
            goto L_0x0040
        L_0x003f:
            r6 = 1
        L_0x0040:
            if (r6 != 0) goto L_0x0044
        L_0x0042:
            if (r7 != r12) goto L_0x0045
        L_0x0044:
            return r16
        L_0x0045:
            if (r7 >= r14) goto L_0x0049
            r6 = 1
            goto L_0x004a
        L_0x0049:
            r6 = 2
        L_0x004a:
            int r5 = r5 + r6
            int r4 = r4 + 1
        L_0x004d:
            r6 = r18
            if (r4 >= r2) goto L_0x0008
            byte r7 = r0[r4]
            if (r7 < 0) goto L_0x0008
            int r7 = r4 + 1
            byte r4 = r0[r4]
            int r18 = r6 + 1
            if (r6 != r1) goto L_0x005e
            return r5
        L_0x005e:
            if (r4 == r13) goto L_0x007a
            if (r4 == r11) goto L_0x007a
            if (r4 < 0) goto L_0x0068
            if (r4 >= r10) goto L_0x0068
            r6 = 1
            goto L_0x0069
        L_0x0068:
            r6 = 0
        L_0x0069:
            if (r6 != 0) goto L_0x0077
            if (r9 > r4) goto L_0x0071
            if (r4 >= r8) goto L_0x0071
            r6 = 1
            goto L_0x0072
        L_0x0071:
            r6 = 0
        L_0x0072:
            if (r6 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r6 = 0
            goto L_0x0078
        L_0x0077:
            r6 = 1
        L_0x0078:
            if (r6 != 0) goto L_0x007c
        L_0x007a:
            if (r4 != r12) goto L_0x007d
        L_0x007c:
            return r16
        L_0x007d:
            if (r4 >= r14) goto L_0x0081
            r4 = 1
            goto L_0x0082
        L_0x0081:
            r4 = 2
        L_0x0082:
            int r5 = r5 + r4
            r4 = r7
            goto L_0x004d
        L_0x0085:
            int r3 = r7 >> 5
            r15 = -2
            r14 = 128(0x80, float:1.794E-43)
            if (r3 != r15) goto L_0x00e1
            int r3 = r4 + 1
            if (r2 > r3) goto L_0x0094
            if (r6 != r1) goto L_0x0093
            return r5
        L_0x0093:
            return r16
        L_0x0094:
            byte r7 = r0[r4]
            byte r3 = r0[r3]
            r15 = r3 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x009e
            r15 = 1
            goto L_0x009f
        L_0x009e:
            r15 = 0
        L_0x009f:
            if (r15 != 0) goto L_0x00a5
            if (r6 != r1) goto L_0x00a4
            return r5
        L_0x00a4:
            return r16
        L_0x00a5:
            r3 = r3 ^ 3968(0xf80, float:5.56E-42)
            int r7 = r7 << 6
            r3 = r3 ^ r7
            if (r3 >= r14) goto L_0x00b0
            if (r6 != r1) goto L_0x00af
            return r5
        L_0x00af:
            return r16
        L_0x00b0:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x00b5
            return r5
        L_0x00b5:
            if (r3 == r13) goto L_0x00d1
            if (r3 == r11) goto L_0x00d1
            if (r3 < 0) goto L_0x00bf
            if (r3 >= r10) goto L_0x00bf
            r6 = 1
            goto L_0x00c0
        L_0x00bf:
            r6 = 0
        L_0x00c0:
            if (r6 != 0) goto L_0x00ce
            if (r9 > r3) goto L_0x00c8
            if (r3 >= r8) goto L_0x00c8
            r6 = 1
            goto L_0x00c9
        L_0x00c8:
            r6 = 0
        L_0x00c9:
            if (r6 == 0) goto L_0x00cc
            goto L_0x00ce
        L_0x00cc:
            r6 = 0
            goto L_0x00cf
        L_0x00ce:
            r6 = 1
        L_0x00cf:
            if (r6 != 0) goto L_0x00d3
        L_0x00d1:
            if (r3 != r12) goto L_0x00d4
        L_0x00d3:
            return r16
        L_0x00d4:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x00da
            r15 = 1
            goto L_0x00db
        L_0x00da:
            r15 = 2
        L_0x00db:
            int r5 = r5 + r15
            int r4 = r4 + 2
        L_0x00de:
            r6 = r7
            goto L_0x0008
        L_0x00e1:
            int r3 = r7 >> 4
            r12 = 57344(0xe000, float:8.0356E-41)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r3 != r15) goto L_0x016b
            int r3 = r4 + 2
            if (r2 > r3) goto L_0x00f3
            if (r6 != r1) goto L_0x00f2
            return r5
        L_0x00f2:
            return r16
        L_0x00f3:
            byte r7 = r0[r4]
            int r15 = r4 + 1
            byte r15 = r0[r15]
            r9 = r15 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x00ff
            r9 = 1
            goto L_0x0100
        L_0x00ff:
            r9 = 0
        L_0x0100:
            if (r9 != 0) goto L_0x0106
            if (r6 != r1) goto L_0x0105
            return r5
        L_0x0105:
            return r16
        L_0x0106:
            byte r3 = r0[r3]
            r9 = r3 & 192(0xc0, float:2.69E-43)
            if (r9 != r14) goto L_0x010e
            r9 = 1
            goto L_0x010f
        L_0x010e:
            r9 = 0
        L_0x010f:
            if (r9 != 0) goto L_0x0115
            if (r6 != r1) goto L_0x0114
            return r5
        L_0x0114:
            return r16
        L_0x0115:
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r3 = r3 ^ r9
            int r9 = r15 << 6
            r3 = r3 ^ r9
            int r7 = r7 << 12
            r3 = r3 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r3 >= r7) goto L_0x0127
            if (r6 != r1) goto L_0x0126
            return r5
        L_0x0126:
            return r16
        L_0x0127:
            if (r8 > r3) goto L_0x012d
            if (r3 >= r12) goto L_0x012d
            r7 = 1
            goto L_0x012e
        L_0x012d:
            r7 = 0
        L_0x012e:
            if (r7 == 0) goto L_0x0134
            if (r6 != r1) goto L_0x0133
            return r5
        L_0x0133:
            return r16
        L_0x0134:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x0139
            return r5
        L_0x0139:
            if (r3 == r13) goto L_0x0159
            if (r3 == r11) goto L_0x0159
            if (r3 < 0) goto L_0x0143
            if (r3 >= r10) goto L_0x0143
            r6 = 1
            goto L_0x0144
        L_0x0143:
            r6 = 0
        L_0x0144:
            if (r6 != 0) goto L_0x0156
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x0150
            r6 = 160(0xa0, float:2.24E-43)
            if (r3 >= r6) goto L_0x0150
            r6 = 1
            goto L_0x0151
        L_0x0150:
            r6 = 0
        L_0x0151:
            if (r6 == 0) goto L_0x0154
            goto L_0x0156
        L_0x0154:
            r6 = 0
            goto L_0x0157
        L_0x0156:
            r6 = 1
        L_0x0157:
            if (r6 != 0) goto L_0x015e
        L_0x0159:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x015f
        L_0x015e:
            return r16
        L_0x015f:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x0165
            r15 = 1
            goto L_0x0166
        L_0x0165:
            r15 = 2
        L_0x0166:
            int r5 = r5 + r15
            int r4 = r4 + 3
            goto L_0x00de
        L_0x016b:
            int r3 = r7 >> 3
            if (r3 != r15) goto L_0x020e
            int r3 = r4 + 3
            if (r2 > r3) goto L_0x0177
            if (r6 != r1) goto L_0x0176
            return r5
        L_0x0176:
            return r16
        L_0x0177:
            byte r7 = r0[r4]
            int r9 = r4 + 1
            byte r9 = r0[r9]
            r15 = r9 & 192(0xc0, float:2.69E-43)
            if (r15 != r14) goto L_0x0183
            r15 = 1
            goto L_0x0184
        L_0x0183:
            r15 = 0
        L_0x0184:
            if (r15 != 0) goto L_0x018a
            if (r6 != r1) goto L_0x0189
            return r5
        L_0x0189:
            return r16
        L_0x018a:
            int r15 = r4 + 2
            byte r15 = r0[r15]
            r10 = r15 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x0194
            r10 = 1
            goto L_0x0195
        L_0x0194:
            r10 = 0
        L_0x0195:
            if (r10 != 0) goto L_0x019b
            if (r6 != r1) goto L_0x019a
            return r5
        L_0x019a:
            return r16
        L_0x019b:
            byte r3 = r0[r3]
            r10 = r3 & 192(0xc0, float:2.69E-43)
            if (r10 != r14) goto L_0x01a3
            r10 = 1
            goto L_0x01a4
        L_0x01a3:
            r10 = 0
        L_0x01a4:
            if (r10 != 0) goto L_0x01aa
            if (r6 != r1) goto L_0x01a9
            return r5
        L_0x01a9:
            return r16
        L_0x01aa:
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r3 = r3 ^ r10
            int r10 = r15 << 6
            r3 = r3 ^ r10
            int r9 = r9 << 12
            r3 = r3 ^ r9
            int r7 = r7 << 18
            r3 = r3 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r3 <= r7) goto L_0x01c0
            if (r6 != r1) goto L_0x01bf
            return r5
        L_0x01bf:
            return r16
        L_0x01c0:
            if (r8 > r3) goto L_0x01c6
            if (r3 >= r12) goto L_0x01c6
            r7 = 1
            goto L_0x01c7
        L_0x01c6:
            r7 = 0
        L_0x01c7:
            if (r7 == 0) goto L_0x01cd
            if (r6 != r1) goto L_0x01cc
            return r5
        L_0x01cc:
            return r16
        L_0x01cd:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r7) goto L_0x01d5
            if (r6 != r1) goto L_0x01d4
            return r5
        L_0x01d4:
            return r16
        L_0x01d5:
            int r7 = r6 + 1
            if (r6 != r1) goto L_0x01da
            return r5
        L_0x01da:
            if (r3 == r13) goto L_0x01fc
            if (r3 == r11) goto L_0x01fc
            if (r3 < 0) goto L_0x01e6
            r6 = 32
            if (r3 >= r6) goto L_0x01e6
            r6 = 1
            goto L_0x01e7
        L_0x01e6:
            r6 = 0
        L_0x01e7:
            if (r6 != 0) goto L_0x01f9
            r6 = 127(0x7f, float:1.78E-43)
            if (r6 > r3) goto L_0x01f3
            r6 = 160(0xa0, float:2.24E-43)
            if (r3 >= r6) goto L_0x01f3
            r6 = 1
            goto L_0x01f4
        L_0x01f3:
            r6 = 0
        L_0x01f4:
            if (r6 == 0) goto L_0x01f7
            goto L_0x01f9
        L_0x01f7:
            r6 = 0
            goto L_0x01fa
        L_0x01f9:
            r6 = 1
        L_0x01fa:
            if (r6 != 0) goto L_0x0201
        L_0x01fc:
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r3 != r6) goto L_0x0202
        L_0x0201:
            return r16
        L_0x0202:
            r6 = 65536(0x10000, float:9.18355E-41)
            if (r3 >= r6) goto L_0x0208
            r15 = 1
            goto L_0x0209
        L_0x0208:
            r15 = 2
        L_0x0209:
            int r5 = r5 + r15
            int r4 = r4 + 4
            goto L_0x00de
        L_0x020e:
            if (r6 != r1) goto L_0x0211
            return r5
        L_0x0211:
            return r16
        L_0x0212:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }
}
