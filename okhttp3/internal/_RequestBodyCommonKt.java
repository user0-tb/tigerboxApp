package okhttp3.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.ByteString;

@Metadata(mo33736d1 = {"\u0000,\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0002\u001a$\u0010\u0006\u001a\u00020\u0002*\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u000e"}, mo33737d2 = {"commonContentLength", "", "Lokhttp3/RequestBody;", "commonIsDuplex", "", "commonIsOneShot", "commonToRequestBody", "", "contentType", "Lokhttp3/MediaType;", "offset", "", "byteCount", "Lokio/ByteString;", "okhttp"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -RequestBodyCommon.kt */
public final class _RequestBodyCommonKt {
    public static final long commonContentLength(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "<this>");
        return -1;
    }

    public static final boolean commonIsDuplex(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "<this>");
        return false;
    }

    public static final boolean commonIsOneShot(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(requestBody, "<this>");
        return false;
    }

    public static final RequestBody commonToRequestBody(byte[] bArr, MediaType mediaType, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        _UtilCommonKt.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        return new _RequestBodyCommonKt$commonToRequestBody$1(mediaType, i2, bArr, i);
    }

    public static final RequestBody commonToRequestBody(ByteString byteString, MediaType mediaType) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return new _RequestBodyCommonKt$commonToRequestBody$2(mediaType, byteString);
    }
}
