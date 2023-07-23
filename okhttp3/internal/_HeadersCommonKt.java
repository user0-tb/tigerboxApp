package okhttp3.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import okhttp3.Headers;

@Metadata(mo33736d1 = {"\u0000\\\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u001a%\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0005\u001a!\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0003\"\u00020\u0001H\u0000¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u000fH\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u0014\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0007*\u00020\u0011H\u0000\u001a\u0016\u0010\u0016\u001a\u00020\u0017*\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0000\u001a\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u0001*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u0007H\u0000\u001a\u001e\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u001f0\u001e*\u00020\u0007H\u0000\u001a\u0014\u0010 \u001a\u00020\u0001*\u00020\u00072\u0006\u0010!\u001a\u00020\u001cH\u0000\u001a\f\u0010\"\u001a\u00020\u0011*\u00020\u0007H\u0000\u001a\u0014\u0010#\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u001c\u0010$\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0001H\u0000\u001a\u0018\u0010%\u001a\u00020\u0007*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010&H\u0000\u001a\f\u0010'\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\u0014\u0010(\u001a\u00020\u0001*\u00020\u00072\u0006\u0010!\u001a\u00020\u001cH\u0000\u001a\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00010**\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¨\u0006+"}, mo33737d2 = {"commonHeadersGet", "", "namesAndValues", "", "name", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "commonHeadersOf", "Lokhttp3/Headers;", "inputNamesAndValues", "([Ljava/lang/String;)Lokhttp3/Headers;", "headersCheckName", "", "headersCheckValue", "value", "charCode", "", "commonAdd", "Lokhttp3/Headers$Builder;", "commonAddAll", "headers", "commonAddLenient", "commonBuild", "commonEquals", "", "other", "", "commonGet", "commonHashCode", "", "commonIterator", "", "Lkotlin/Pair;", "commonName", "index", "commonNewBuilder", "commonRemoveAll", "commonSet", "commonToHeaders", "", "commonToString", "commonValue", "commonValues", "", "okhttp"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -HeadersCommon.kt */
public final class _HeadersCommonKt {
    public static final String commonName(Headers headers, int i) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        String str = (String) ArraysKt.getOrNull((T[]) headers.getNamesAndValues$okhttp(), i * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + i + ']');
    }

    public static final String commonValue(Headers headers, int i) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        String str = (String) ArraysKt.getOrNull((T[]) headers.getNamesAndValues$okhttp(), (i * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + i + ']');
    }

    public static final List<String> commonValues(Headers headers, String str) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        int size = headers.size();
        List<String> list = null;
        List list2 = null;
        for (int i = 0; i < size; i++) {
            if (StringsKt.equals(str, headers.name(i), true)) {
                if (list2 == null) {
                    list2 = new ArrayList(2);
                }
                list2.add(headers.value(i));
            }
        }
        if (list2 != null) {
            list = CollectionsKt.toList(list2);
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public static final Iterator<Pair<String, String>> commonIterator(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        int size = headers.size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = TuplesKt.m475to(headers.name(i), headers.value(i));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    public static final Headers.Builder commonNewBuilder(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        Headers.Builder builder = new Headers.Builder();
        CollectionsKt.addAll(builder.getNamesAndValues$okhttp(), (T[]) headers.getNamesAndValues$okhttp());
        return builder;
    }

    public static final boolean commonEquals(Headers headers, Object obj) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        return (obj instanceof Headers) && Arrays.equals(headers.getNamesAndValues$okhttp(), ((Headers) obj).getNamesAndValues$okhttp());
    }

    public static final int commonHashCode(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        return Arrays.hashCode(headers.getNamesAndValues$okhttp());
    }

    public static final String commonToString(Headers headers) {
        Intrinsics.checkNotNullParameter(headers, "<this>");
        StringBuilder sb = new StringBuilder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            sb.append(name);
            sb.append(": ");
            if (_UtilCommonKt.isSensitiveHeader(name)) {
                value = "██";
            }
            sb.append(value);
            sb.append("\n");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final String commonHeadersGet(String[] strArr, String str) {
        Intrinsics.checkNotNullParameter(strArr, "namesAndValues");
        Intrinsics.checkNotNullParameter(str, "name");
        int length = strArr.length - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement > length) {
            return null;
        }
        while (!StringsKt.equals(str, strArr[length], true)) {
            if (length == progressionLastElement) {
                return null;
            }
            length -= 2;
        }
        return strArr[length + 1];
    }

    public static final Headers.Builder commonAdd(Headers.Builder builder, String str, String str2) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        headersCheckName(str);
        headersCheckValue(str2, str);
        commonAddLenient(builder, str, str2);
        return builder;
    }

    public static final Headers.Builder commonAddAll(Headers.Builder builder, Headers headers) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            commonAddLenient(builder, headers.name(i), headers.value(i));
        }
        return builder;
    }

    public static final Headers.Builder commonAddLenient(Headers.Builder builder, String str, String str2) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        builder.getNamesAndValues$okhttp().add(str);
        builder.getNamesAndValues$okhttp().add(StringsKt.trim((CharSequence) str2).toString());
        return builder;
    }

    public static final Headers.Builder commonRemoveAll(Headers.Builder builder, String str) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        int i = 0;
        while (i < builder.getNamesAndValues$okhttp().size()) {
            if (StringsKt.equals(str, builder.getNamesAndValues$okhttp().get(i), true)) {
                builder.getNamesAndValues$okhttp().remove(i);
                builder.getNamesAndValues$okhttp().remove(i);
                i -= 2;
            }
            i += 2;
        }
        return builder;
    }

    public static final Headers.Builder commonSet(Headers.Builder builder, String str, String str2) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        headersCheckName(str);
        headersCheckValue(str2, str);
        builder.removeAll(str);
        commonAddLenient(builder, str, str2);
        return builder;
    }

    public static final String commonGet(Headers.Builder builder, String str) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        int size = builder.getNamesAndValues$okhttp().size() - 2;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(size, 0, -2);
        if (progressionLastElement > size) {
            return null;
        }
        while (!StringsKt.equals(str, builder.getNamesAndValues$okhttp().get(size), true)) {
            if (size == progressionLastElement) {
                return null;
            }
            size -= 2;
        }
        return builder.getNamesAndValues$okhttp().get(size + 1);
    }

    public static final Headers commonBuild(Headers.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Object[] array = builder.getNamesAndValues$okhttp().toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new Headers((String[]) array);
    }

    public static final void headersCheckName(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (str.length() > 0) {
            int length = str.length();
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if ('!' <= charAt && charAt < 127) {
                    i++;
                } else {
                    throw new IllegalArgumentException(("Unexpected char 0x" + charCode(charAt) + " at " + i + " in header name: " + str).toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("name is empty".toString());
    }

    public static final void headersCheckValue(String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "value");
        Intrinsics.checkNotNullParameter(str2, "name");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            boolean z = true;
            if (charAt != 9) {
                if (!(' ' <= charAt && charAt < 127)) {
                    z = false;
                }
            }
            if (!z) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected char 0x");
                sb.append(charCode(charAt));
                sb.append(" at ");
                sb.append(i);
                sb.append(" in ");
                sb.append(str2);
                sb.append(" value");
                if (_UtilCommonKt.isSensitiveHeader(str2)) {
                    str3 = "";
                } else {
                    str3 = ": " + str;
                }
                sb.append(str3);
                throw new IllegalArgumentException(sb.toString().toString());
            }
        }
    }

    private static final String charCode(char c) {
        String num = Integer.toString(c, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        if (num.length() >= 2) {
            return num;
        }
        return '0' + num;
    }

    public static final Headers commonHeadersOf(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "inputNamesAndValues");
        int i = 0;
        if (strArr.length % 2 == 0) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
            int length = strArr2.length;
            int i2 = 0;
            while (i2 < length) {
                if (strArr2[i2] != null) {
                    strArr2[i2] = StringsKt.trim((CharSequence) strArr[i2]).toString();
                    i2++;
                } else {
                    throw new IllegalArgumentException("Headers cannot be null".toString());
                }
            }
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, strArr2.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    String str = strArr2[i];
                    String str2 = strArr2[i + 1];
                    headersCheckName(str);
                    headersCheckValue(str2, str);
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 2;
                }
            }
            return new Headers(strArr2);
        }
        throw new IllegalArgumentException("Expected alternating header names and values".toString());
    }

    public static final Headers commonToHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String[] strArr = new String[(map.size() * 2)];
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            String obj = StringsKt.trim((CharSequence) (String) next.getKey()).toString();
            String obj2 = StringsKt.trim((CharSequence) (String) next.getValue()).toString();
            headersCheckName(obj);
            headersCheckValue(obj2, obj);
            strArr[i] = obj;
            strArr[i + 1] = obj2;
            i += 2;
        }
        return new Headers(strArr);
    }
}
