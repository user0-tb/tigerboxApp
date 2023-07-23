package okhttp3.internal;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;

@Metadata(mo33736d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001a\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\n\u001a\u00020\b\u001a\u0014\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0004\u001a\n\u0010\u000f\u001a\u00020\u0004*\u00020\u0004\u001a\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001a\u0010\u0010\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u0012*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\r\u001a\n\u0010\u0017\u001a\u00020\u0004*\u00020\t\u001a\u0012\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0019\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001\u001a1\u0010\u001c\u001a\u00020\u0004\"\b\b\u0000\u0010\u001d*\u00020\u001e*\u00020\u00042\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u001d0 2\b\u0010!\u001a\u0004\u0018\u0001H\u001d¢\u0006\u0002\u0010\"¨\u0006#"}, mo33737d2 = {"canonicalUrl", "", "url", "commonAddHeader", "Lokhttp3/Request$Builder;", "name", "value", "commonCacheControl", "Lokhttp3/CacheControl;", "Lokhttp3/Request;", "cacheControl", "commonDelete", "body", "Lokhttp3/RequestBody;", "commonGet", "commonHead", "commonHeader", "commonHeaders", "", "headers", "Lokhttp3/Headers;", "commonMethod", "method", "commonNewBuilder", "commonPatch", "commonPost", "commonPut", "commonRemoveHeader", "commonTag", "T", "", "type", "Lkotlin/reflect/KClass;", "tag", "(Lokhttp3/Request$Builder;Lkotlin/reflect/KClass;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "okhttp"}, mo33738k = 2, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: -RequestCommon.kt */
public final class _RequestCommonKt {
    public static final String commonHeader(Request request, String str) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        return request.headers().get(str);
    }

    public static final List<String> commonHeaders(Request request, String str) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        return request.headers().values(str);
    }

    public static final Request.Builder commonNewBuilder(Request request) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        return new Request.Builder(request);
    }

    public static final CacheControl commonCacheControl(Request request) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        CacheControl lazyCacheControl$okhttp = request.getLazyCacheControl$okhttp();
        if (lazyCacheControl$okhttp != null) {
            return lazyCacheControl$okhttp;
        }
        CacheControl parse = CacheControl.Companion.parse(request.headers());
        request.setLazyCacheControl$okhttp(parse);
        return parse;
    }

    public static final String canonicalUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        if (StringsKt.startsWith(str, "ws:", true)) {
            StringBuilder sb = new StringBuilder();
            sb.append("http:");
            String substring = str.substring(3);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            return sb.toString();
        } else if (!StringsKt.startsWith(str, "wss:", true)) {
            return str;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https:");
            String substring2 = str.substring(4);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            sb2.append(substring2);
            return sb2.toString();
        }
    }

    public static final Request.Builder commonHeader(Request.Builder builder, String str, String str2) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        builder.getHeaders$okhttp().set(str, str2);
        return builder;
    }

    public static final Request.Builder commonAddHeader(Request.Builder builder, String str, String str2) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "value");
        builder.getHeaders$okhttp().add(str, str2);
        return builder;
    }

    public static final Request.Builder commonRemoveHeader(Request.Builder builder, String str) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        builder.getHeaders$okhttp().removeAll(str);
        return builder;
    }

    public static final Request.Builder commonHeaders(Request.Builder builder, Headers headers) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        builder.setHeaders$okhttp(headers.newBuilder());
        return builder;
    }

    public static final Request.Builder commonCacheControl(Request.Builder builder, CacheControl cacheControl) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
        String cacheControl2 = cacheControl.toString();
        if (cacheControl2.length() == 0) {
            return builder.removeHeader("Cache-Control");
        }
        return builder.header("Cache-Control", cacheControl2);
    }

    public static final Request.Builder commonGet(Request.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.method("GET", (RequestBody) null);
    }

    public static final Request.Builder commonHead(Request.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.method("HEAD", (RequestBody) null);
    }

    public static final Request.Builder commonPost(Request.Builder builder, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(requestBody, TtmlNode.TAG_BODY);
        return builder.method("POST", requestBody);
    }

    public static final Request.Builder commonDelete(Request.Builder builder, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        return builder.method("DELETE", requestBody);
    }

    public static final Request.Builder commonPut(Request.Builder builder, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(requestBody, TtmlNode.TAG_BODY);
        return builder.method("PUT", requestBody);
    }

    public static final Request.Builder commonPatch(Request.Builder builder, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(requestBody, TtmlNode.TAG_BODY);
        return builder.method("PATCH", requestBody);
    }

    public static final Request.Builder commonMethod(Request.Builder builder, String str, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "method");
        if (str.length() > 0) {
            if (requestBody == null) {
                if (!(true ^ HttpMethod.requiresRequestBody(str))) {
                    throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
            }
            builder.setMethod$okhttp(str);
            builder.setBody$okhttp(requestBody);
            return builder;
        }
        throw new IllegalArgumentException("method.isEmpty() == true".toString());
    }

    public static final <T> Request.Builder commonTag(Request.Builder builder, KClass<T> kClass, T t) {
        Map map;
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(kClass, SessionDescription.ATTR_TYPE);
        if (t != null) {
            if (builder.getTags$okhttp().isEmpty()) {
                map = new LinkedHashMap();
                builder.setTags$okhttp(map);
            } else {
                map = TypeIntrinsics.asMutableMap(builder.getTags$okhttp());
            }
            map.put(kClass, t);
        } else if (!builder.getTags$okhttp().isEmpty()) {
            TypeIntrinsics.asMutableMap(builder.getTags$okhttp()).remove(kClass);
        }
        return builder;
    }
}
