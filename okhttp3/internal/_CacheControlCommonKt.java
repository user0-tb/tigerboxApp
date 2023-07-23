package okhttp3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import okhttp3.CacheControl;

@Metadata(mo33736d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\u001c\u0010\n\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\f\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\u0014\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\f\u0010\u0015\u001a\u00020\u0002*\u00020\u0002H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0001H\u0000\u001a\u001e\u0010\u001b\u001a\u00020\u0004*\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u0004H\u0002¨\u0006\u001e"}, mo33737d2 = {"commonBuild", "Lokhttp3/CacheControl;", "Lokhttp3/CacheControl$Builder;", "commonClampToInt", "", "", "commonForceCache", "Lokhttp3/CacheControl$Companion;", "commonForceNetwork", "commonImmutable", "commonMaxAge", "maxAge", "timeUnit", "Lkotlin/time/DurationUnit;", "commonMaxStale", "maxStale", "commonMinFresh", "minFresh", "commonNoCache", "commonNoStore", "commonNoTransform", "commonOnlyIfCached", "commonParse", "headers", "Lokhttp3/Headers;", "commonToString", "", "indexOfElement", "characters", "startIndex", "okhttp"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -CacheControlCommon.kt */
public final class _CacheControlCommonKt {
    public static final int commonClampToInt(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    public static final String commonToString(CacheControl cacheControl) {
        Intrinsics.checkNotNullParameter(cacheControl, "<this>");
        String headerValue$okhttp = cacheControl.getHeaderValue$okhttp();
        if (headerValue$okhttp != null) {
            return headerValue$okhttp;
        }
        StringBuilder sb = new StringBuilder();
        if (cacheControl.noCache()) {
            sb.append("no-cache, ");
        }
        if (cacheControl.noStore()) {
            sb.append("no-store, ");
        }
        if (cacheControl.maxAgeSeconds() != -1) {
            sb.append("max-age=");
            sb.append(cacheControl.maxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.sMaxAgeSeconds() != -1) {
            sb.append("s-maxage=");
            sb.append(cacheControl.sMaxAgeSeconds());
            sb.append(", ");
        }
        if (cacheControl.isPrivate()) {
            sb.append("private, ");
        }
        if (cacheControl.isPublic()) {
            sb.append("public, ");
        }
        if (cacheControl.mustRevalidate()) {
            sb.append("must-revalidate, ");
        }
        if (cacheControl.maxStaleSeconds() != -1) {
            sb.append("max-stale=");
            sb.append(cacheControl.maxStaleSeconds());
            sb.append(", ");
        }
        if (cacheControl.minFreshSeconds() != -1) {
            sb.append("min-fresh=");
            sb.append(cacheControl.minFreshSeconds());
            sb.append(", ");
        }
        if (cacheControl.onlyIfCached()) {
            sb.append("only-if-cached, ");
        }
        if (cacheControl.noTransform()) {
            sb.append("no-transform, ");
        }
        if (cacheControl.immutable()) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(sb.delete(sb.length() - 2, sb.length()), "this.delete(startIndex, endIndex)");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        cacheControl.setHeaderValue$okhttp(sb2);
        return sb2;
    }

    public static final CacheControl.Builder commonMaxAge(CacheControl.Builder builder, int i, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(durationUnit, "timeUnit");
        if (i >= 0) {
            builder.setMaxAgeSeconds$okhttp(commonClampToInt(Duration.m2112getInWholeSecondsimpl(DurationKt.toDuration(i, durationUnit))));
            return builder;
        }
        throw new IllegalArgumentException(("maxAge < 0: " + i).toString());
    }

    public static final CacheControl.Builder commonMaxStale(CacheControl.Builder builder, int i, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(durationUnit, "timeUnit");
        if (i >= 0) {
            builder.setMaxStaleSeconds$okhttp(commonClampToInt(Duration.m2112getInWholeSecondsimpl(DurationKt.toDuration(i, durationUnit))));
            return builder;
        }
        throw new IllegalArgumentException(("maxStale < 0: " + i).toString());
    }

    public static final CacheControl.Builder commonMinFresh(CacheControl.Builder builder, int i, DurationUnit durationUnit) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(durationUnit, "timeUnit");
        if (i >= 0) {
            builder.setMinFreshSeconds$okhttp(commonClampToInt(Duration.m2112getInWholeSecondsimpl(DurationKt.toDuration(i, durationUnit))));
            return builder;
        }
        throw new IllegalArgumentException(("minFresh < 0: " + i).toString());
    }

    public static final CacheControl commonForceNetwork(CacheControl.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new CacheControl.Builder().noCache().build();
    }

    public static final CacheControl commonForceCache(CacheControl.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new CacheControl.Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, DurationUnit.SECONDS).build();
    }

    public static final CacheControl commonBuild(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return new CacheControl(builder.getNoCache$okhttp(), builder.getNoStore$okhttp(), builder.getMaxAgeSeconds$okhttp(), -1, false, false, false, builder.getMaxStaleSeconds$okhttp(), builder.getMinFreshSeconds$okhttp(), builder.getOnlyIfCached$okhttp(), builder.getNoTransform$okhttp(), builder.getImmutable$okhttp(), (String) null);
    }

    public static final CacheControl.Builder commonNoCache(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoCache$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoStore(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoStore$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setOnlyIfCached$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setNoTransform$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonImmutable(CacheControl.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setImmutable$okhttp(true);
        return builder;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okhttp3.CacheControl commonParse(okhttp3.CacheControl.Companion r29, okhttp3.Headers r30) {
        /*
            r0 = r30
            java.lang.String r1 = "<this>"
            r2 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            int r1 = r30.size()
            r5 = 1
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = -1
            r17 = -1
            r18 = 0
            r19 = 0
            r20 = 0
        L_0x0027:
            if (r6 >= r1) goto L_0x01a0
            java.lang.String r2 = r0.name(r6)
            java.lang.String r4 = r0.value(r6)
            java.lang.String r3 = "Cache-Control"
            boolean r3 = kotlin.text.StringsKt.equals(r2, r3, r5)
            if (r3 == 0) goto L_0x003e
            if (r8 == 0) goto L_0x003c
            goto L_0x0046
        L_0x003c:
            r8 = r4
            goto L_0x0047
        L_0x003e:
            java.lang.String r3 = "Pragma"
            boolean r2 = kotlin.text.StringsKt.equals(r2, r3, r5)
            if (r2 == 0) goto L_0x0195
        L_0x0046:
            r7 = 0
        L_0x0047:
            r2 = 0
        L_0x0048:
            int r3 = r4.length()
            if (r2 >= r3) goto L_0x0195
            java.lang.String r3 = "=,;"
            int r3 = indexOfElement(r4, r3, r2)
            java.lang.String r2 = r4.substring(r2, r3)
            java.lang.String r5 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r2 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r2)
            java.lang.String r2 = r2.toString()
            int r0 = r4.length()
            if (r3 == r0) goto L_0x00ca
            char r0 = r4.charAt(r3)
            r22 = r1
            r1 = 44
            if (r0 == r1) goto L_0x00cc
            char r0 = r4.charAt(r3)
            r1 = 59
            if (r0 != r1) goto L_0x0080
            goto L_0x00cc
        L_0x0080:
            int r3 = r3 + 1
            int r0 = okhttp3.internal._UtilCommonKt.indexOfNonWhitespace(r4, r3)
            int r1 = r4.length()
            if (r0 >= r1) goto L_0x00b2
            char r1 = r4.charAt(r0)
            r3 = 34
            if (r1 != r3) goto L_0x00b2
            int r0 = r0 + 1
            r23 = r4
            java.lang.CharSequence r23 = (java.lang.CharSequence) r23
            r24 = 34
            r26 = 0
            r27 = 4
            r28 = 0
            r25 = r0
            int r1 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r23, (char) r24, (int) r25, (boolean) r26, (int) r27, (java.lang.Object) r28)
            java.lang.String r0 = r4.substring(r0, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            r3 = 1
            int r1 = r1 + r3
            goto L_0x00d0
        L_0x00b2:
            java.lang.String r1 = ",;"
            int r1 = indexOfElement(r4, r1, r0)
            java.lang.String r0 = r4.substring(r0, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r5)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0)
            java.lang.String r0 = r0.toString()
            goto L_0x00d0
        L_0x00ca:
            r22 = r1
        L_0x00cc:
            int r3 = r3 + 1
            r1 = r3
            r0 = 0
        L_0x00d0:
            java.lang.String r3 = "no-cache"
            r5 = 1
            boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
            if (r3 == 0) goto L_0x00e1
            r0 = r30
            r2 = r1
            r1 = r22
            r9 = 1
            goto L_0x0048
        L_0x00e1:
            java.lang.String r3 = "no-store"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
            if (r3 == 0) goto L_0x00f1
            r0 = r30
            r2 = r1
            r1 = r22
            r10 = 1
            goto L_0x0048
        L_0x00f1:
            java.lang.String r3 = "max-age"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
            if (r3 == 0) goto L_0x0105
            r3 = -1
            int r11 = okhttp3.internal._UtilCommonKt.toNonNegativeInt(r0, r3)
        L_0x00fe:
            r0 = r30
            r2 = r1
            r1 = r22
            goto L_0x0048
        L_0x0105:
            java.lang.String r3 = "s-maxage"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
            if (r3 == 0) goto L_0x0113
            r3 = -1
            int r12 = okhttp3.internal._UtilCommonKt.toNonNegativeInt(r0, r3)
            goto L_0x00fe
        L_0x0113:
            java.lang.String r3 = "private"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
            if (r3 == 0) goto L_0x0123
            r0 = r30
            r2 = r1
            r1 = r22
            r13 = 1
            goto L_0x0048
        L_0x0123:
            java.lang.String r3 = "public"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
            if (r3 == 0) goto L_0x0133
            r0 = r30
            r2 = r1
            r1 = r22
            r14 = 1
            goto L_0x0048
        L_0x0133:
            java.lang.String r3 = "must-revalidate"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
            if (r3 == 0) goto L_0x0143
            r0 = r30
            r2 = r1
            r1 = r22
            r15 = 1
            goto L_0x0048
        L_0x0143:
            java.lang.String r3 = "max-stale"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
            if (r3 == 0) goto L_0x0153
            r2 = 2147483647(0x7fffffff, float:NaN)
            int r16 = okhttp3.internal._UtilCommonKt.toNonNegativeInt(r0, r2)
            goto L_0x00fe
        L_0x0153:
            java.lang.String r3 = "min-fresh"
            boolean r3 = kotlin.text.StringsKt.equals(r3, r2, r5)
            if (r3 == 0) goto L_0x0161
            r3 = -1
            int r17 = okhttp3.internal._UtilCommonKt.toNonNegativeInt(r0, r3)
            goto L_0x00fe
        L_0x0161:
            r3 = -1
            java.lang.String r0 = "only-if-cached"
            boolean r0 = kotlin.text.StringsKt.equals(r0, r2, r5)
            if (r0 == 0) goto L_0x0173
            r0 = r30
            r2 = r1
            r1 = r22
            r18 = 1
            goto L_0x0048
        L_0x0173:
            java.lang.String r0 = "no-transform"
            boolean r0 = kotlin.text.StringsKt.equals(r0, r2, r5)
            if (r0 == 0) goto L_0x0184
            r0 = r30
            r2 = r1
            r1 = r22
            r19 = 1
            goto L_0x0048
        L_0x0184:
            java.lang.String r0 = "immutable"
            boolean r0 = kotlin.text.StringsKt.equals(r0, r2, r5)
            if (r0 == 0) goto L_0x00fe
            r0 = r30
            r2 = r1
            r1 = r22
            r20 = 1
            goto L_0x0048
        L_0x0195:
            r22 = r1
            r3 = -1
            int r6 = r6 + 1
            r0 = r30
            r1 = r22
            goto L_0x0027
        L_0x01a0:
            if (r7 != 0) goto L_0x01a5
            r21 = 0
            goto L_0x01a7
        L_0x01a5:
            r21 = r8
        L_0x01a7:
            okhttp3.CacheControl r0 = new okhttp3.CacheControl
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._CacheControlCommonKt.commonParse(okhttp3.CacheControl$Companion, okhttp3.Headers):okhttp3.CacheControl");
    }

    static /* synthetic */ int indexOfElement$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOfElement(str, str2, i);
    }

    private static final int indexOfElement(String str, String str2, int i) {
        int length = str.length();
        while (i < length) {
            if (StringsKt.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return str.length();
    }
}
