package okhttp3.internal;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;

@Metadata(mo33736d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002\u001a\u001a\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u001a\u0012\u0010\u0013\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0011*\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u001a\n\u0010\u0018\u001a\u00020\f*\u00020\u0002\u001a\u0012\u0010\u0019\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b\u001a \u0010\u001c\u001a\u0004\u0018\u00010\u000e*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u000eH\u0007\u001a\u001a\u0010\u001c\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000e\u001a\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u0010\u001e\u001a\u00020\u0011*\u00020\u00112\u0006\u0010 \u001a\u00020!\u001a\u0012\u0010\"\u001a\u00020\u0011*\u00020\u00112\u0006\u0010#\u001a\u00020\u000e\u001a\u0014\u0010$\u001a\u00020\u0011*\u00020\u00112\b\u0010%\u001a\u0004\u0018\u00010\u0002\u001a\n\u0010&\u001a\u00020\u0011*\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u0015*\u00020\u00022\u0006\u0010(\u001a\u00020)\u001a\u0014\u0010*\u001a\u00020\u0011*\u00020\u00112\b\u0010+\u001a\u0004\u0018\u00010\u0002\u001a\u0012\u0010,\u001a\u00020\u0011*\u00020\u00112\u0006\u0010-\u001a\u00020.\u001a\u0012\u0010/\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\r\u001a\u00020\u000e\u001a\u0012\u00100\u001a\u00020\u0011*\u00020\u00112\u0006\u00101\u001a\u000202\u001a\n\u00103\u001a\u00020\u000e*\u00020\u0002\u001a\n\u00104\u001a\u00020\u0002*\u00020\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u00065"}, mo33737d2 = {"commonCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Response;", "getCommonCacheControl", "(Lokhttp3/Response;)Lokhttp3/CacheControl;", "commonIsRedirect", "", "getCommonIsRedirect", "(Lokhttp3/Response;)Z", "commonIsSuccessful", "getCommonIsSuccessful", "checkSupportResponse", "", "name", "", "response", "commonAddHeader", "Lokhttp3/Response$Builder;", "value", "commonBody", "body", "Lokhttp3/ResponseBody;", "commonCacheResponse", "cacheResponse", "commonClose", "commonCode", "code", "", "commonHeader", "defaultValue", "commonHeaders", "", "headers", "Lokhttp3/Headers;", "commonMessage", "message", "commonNetworkResponse", "networkResponse", "commonNewBuilder", "commonPeekBody", "byteCount", "", "commonPriorResponse", "priorResponse", "commonProtocol", "protocol", "Lokhttp3/Protocol;", "commonRemoveHeader", "commonRequest", "request", "Lokhttp3/Request;", "commonToString", "stripBody", "okhttp"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -ResponseCommon.kt */
public final class _ResponseCommonKt {
    public static final Response stripBody(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return response.newBuilder().body(new UnreadableResponseBody(response.body().contentType(), response.body().contentLength())).build();
    }

    public static final boolean getCommonIsSuccessful(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        int code = response.code();
        return 200 <= code && code < 300;
    }

    public static final List<String> commonHeaders(Response response, String str) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        return response.headers().values(str);
    }

    public static final String commonHeader(Response response, String str, String str2) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        String str3 = response.headers().get(str);
        return str3 == null ? str2 : str3;
    }

    public static final ResponseBody commonPeekBody(Response response, long j) throws IOException {
        Intrinsics.checkNotNullParameter(response, "<this>");
        BufferedSource peek = response.body().source().peek();
        Buffer buffer = new Buffer();
        peek.request(j);
        buffer.write((Source) peek, Math.min(j, peek.getBuffer().size()));
        return ResponseBody.Companion.create((BufferedSource) buffer, response.body().contentType(), buffer.size());
    }

    public static final Response.Builder commonNewBuilder(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return new Response.Builder(response);
    }

    public static final boolean getCommonIsRedirect(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        int code = response.code();
        if (!(code == 307 || code == 308)) {
            switch (code) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public static final CacheControl getCommonCacheControl(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        CacheControl lazyCacheControl$okhttp = response.getLazyCacheControl$okhttp();
        if (lazyCacheControl$okhttp != null) {
            return lazyCacheControl$okhttp;
        }
        CacheControl parse = CacheControl.Companion.parse(response.headers());
        response.setLazyCacheControl$okhttp(parse);
        return parse;
    }

    public static final void commonClose(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        response.body().close();
    }

    public static final String commonToString(Response response) {
        Intrinsics.checkNotNullParameter(response, "<this>");
        return "Response{protocol=" + response.protocol() + ", code=" + response.code() + ", message=" + response.message() + ", url=" + response.request().url() + '}';
    }

    public static final Response.Builder commonRequest(Response.Builder builder, Request request) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(request, "request");
        builder.setRequest$okhttp(request);
        return builder;
    }

    public static final Response.Builder commonProtocol(Response.Builder builder, Protocol protocol) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        builder.setProtocol$okhttp(protocol);
        return builder;
    }

    public static final Response.Builder commonCode(Response.Builder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setCode$okhttp(i);
        return builder;
    }

    public static final Response.Builder commonMessage(Response.Builder builder, String str) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "message");
        builder.setMessage$okhttp(str);
        return builder;
    }

    public static final Response.Builder commonHeader(Response.Builder builder, String str, String str2) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        builder.getHeaders$okhttp().set(str, str2);
        return builder;
    }

    public static final Response.Builder commonAddHeader(Response.Builder builder, String str, String str2) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        builder.getHeaders$okhttp().add(str, str2);
        return builder;
    }

    public static final Response.Builder commonRemoveHeader(Response.Builder builder, String str) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        builder.getHeaders$okhttp().removeAll(str);
        return builder;
    }

    public static final Response.Builder commonHeaders(Response.Builder builder, Headers headers) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        builder.setHeaders$okhttp(headers.newBuilder());
        return builder;
    }

    public static final Response.Builder commonBody(Response.Builder builder, ResponseBody responseBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(responseBody, TtmlNode.TAG_BODY);
        builder.setBody$okhttp(responseBody);
        return builder;
    }

    public static final Response.Builder commonNetworkResponse(Response.Builder builder, Response response) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        checkSupportResponse("networkResponse", response);
        builder.setNetworkResponse$okhttp(response);
        return builder;
    }

    public static final Response.Builder commonCacheResponse(Response.Builder builder, Response response) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        checkSupportResponse("cacheResponse", response);
        builder.setCacheResponse$okhttp(response);
        return builder;
    }

    private static final void checkSupportResponse(String str, Response response) {
        if (response != null) {
            boolean z = true;
            if (response.networkResponse() == null) {
                if (response.cacheResponse() == null) {
                    if (response.priorResponse() != null) {
                        z = false;
                    }
                    if (!z) {
                        throw new IllegalArgumentException((str + ".priorResponse != null").toString());
                    }
                    return;
                }
                throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
            }
            throw new IllegalArgumentException((str + ".networkResponse != null").toString());
        }
    }

    public static final Response.Builder commonPriorResponse(Response.Builder builder, Response response) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.setPriorResponse$okhttp(response);
        return builder;
    }
}
