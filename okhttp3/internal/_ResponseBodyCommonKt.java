package okhttp3.internal;

import java.io.Closeable;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(mo33736d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0000\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0001H\u0000\u001a\f\u0010\u000b\u001a\u00020\f*\u00020\u0001H\u0000\u001aG\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f*\u00020\u00012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u000e0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u00020\u00130\u0011H\bø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0016\u0010\u0015\u001a\u00020\u0001*\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0016"}, mo33737d2 = {"commonAsResponseBody", "Lokhttp3/ResponseBody;", "Lokio/BufferedSource;", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "commonByteString", "Lokio/ByteString;", "commonBytes", "", "commonClose", "", "commonConsumeSource", "T", "", "consumer", "Lkotlin/Function1;", "sizeMapper", "", "(Lokhttp3/ResponseBody;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "commonToResponseBody", "okhttp"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -ResponseBodyCommon.kt */
public final class _ResponseBodyCommonKt {
    public static final <T> T commonConsumeSource(ResponseBody responseBody, Function1<? super BufferedSource, ? extends T> function1, Function1<? super T, Integer> function12) {
        T t;
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        Intrinsics.checkNotNullParameter(function1, "consumer");
        Intrinsics.checkNotNullParameter(function12, "sizeMapper");
        long contentLength = responseBody.contentLength();
        if (contentLength <= 2147483647L) {
            Closeable source = responseBody.source();
            Throwable th = null;
            try {
                t = function1.invoke(source);
            } catch (Throwable th2) {
                th = th2;
                t = null;
            }
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th3) {
                    if (th == null) {
                        th = th3;
                    } else {
                        ExceptionsKt.addSuppressed(th, th3);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(t);
                int intValue = function12.invoke(t).intValue();
                if (contentLength == -1 || contentLength == ((long) intValue)) {
                    return t;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + intValue + ") disagree");
            }
            throw th;
        }
        throw new IOException("Cannot buffer entire body for content length: " + contentLength);
    }

    public static final void commonClose(ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        _UtilCommonKt.closeQuietly(responseBody.source());
    }

    public static final ResponseBody commonToResponseBody(byte[] bArr, MediaType mediaType) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ResponseBody.Companion.create((BufferedSource) new Buffer().write(bArr), mediaType, (long) bArr.length);
    }

    public static final ResponseBody commonToResponseBody(ByteString byteString, MediaType mediaType) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return ResponseBody.Companion.create((BufferedSource) new Buffer().write(byteString), mediaType, (long) byteString.size());
    }

    public static final ResponseBody commonAsResponseBody(BufferedSource bufferedSource, MediaType mediaType, long j) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        return new _ResponseBodyCommonKt$commonAsResponseBody$1(mediaType, j, bufferedSource);
    }

    public static final byte[] commonBytes(ResponseBody responseBody) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        long contentLength = responseBody.contentLength();
        if (contentLength <= 2147483647L) {
            Closeable source = responseBody.source();
            Throwable th = null;
            try {
                bArr = ((BufferedSource) source).readByteArray();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bArr = null;
                th = th3;
            }
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        ExceptionsKt.addSuppressed(th, th4);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(bArr);
                int length = bArr.length;
                if (contentLength == -1 || contentLength == ((long) length)) {
                    return bArr;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
            }
            throw th;
        }
        throw new IOException("Cannot buffer entire body for content length: " + contentLength);
    }

    public static final ByteString commonByteString(ResponseBody responseBody) {
        ByteString byteString;
        Intrinsics.checkNotNullParameter(responseBody, "<this>");
        long contentLength = responseBody.contentLength();
        if (contentLength <= 2147483647L) {
            Closeable source = responseBody.source();
            Throwable th = null;
            try {
                byteString = ((BufferedSource) source).readByteString();
            } catch (Throwable th2) {
                Throwable th3 = th2;
                byteString = null;
                th = th3;
            }
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        ExceptionsKt.addSuppressed(th, th4);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(byteString);
                int size = byteString.size();
                if (contentLength == -1 || contentLength == ((long) size)) {
                    return byteString;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
            }
            throw th;
        }
        throw new IOException("Cannot buffer entire body for content length: " + contentLength);
    }
}
