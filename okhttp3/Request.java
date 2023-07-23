package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.internal._RequestCommonKt;
import okhttp3.internal._UtilCommonKt;

@Metadata(mo33736d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u00013B/\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u000f\b\u0000\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000f\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b!J\r\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\b\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u0007J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\b%J\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00070&2\u0006\u0010$\u001a\u00020\u0007J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b'J\u0006\u0010(\u001a\u00020\fJ\b\u0010)\u001a\u0004\u0018\u00010\u0001J\u001e\u0010)\u001a\u0004\u0018\u0001H*\"\n\b\u0000\u0010*\u0018\u0001*\u00020\u0001H\b¢\u0006\u0004\b+\u0010,J#\u0010)\u001a\u0004\u0018\u0001H*\"\u0004\b\u0000\u0010*2\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u0002H*0.¢\u0006\u0002\u0010/J%\u0010)\u001a\u0004\u0018\u0001H*\"\b\b\u0000\u0010**\u00020\u00012\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H*0\u001d¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\u0007H\u0016J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b2R\u0015\u0010\b\u001a\u0004\u0018\u00010\t8G¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00058G¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u00020\u00078G¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001aR$\u0010\u001b\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d\u0012\u0004\u0012\u00020\u00010\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0002\u001a\u00020\u00038G¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010 ¨\u00064"}, mo33737d2 = {"Lokhttp3/Request;", "", "url", "Lokhttp3/HttpUrl;", "headers", "Lokhttp3/Headers;", "method", "", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/HttpUrl;Lokhttp3/Headers;Ljava/lang/String;Lokhttp3/RequestBody;)V", "builder", "Lokhttp3/Request$Builder;", "(Lokhttp3/Request$Builder;)V", "()Lokhttp3/RequestBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Headers;", "isHttps", "", "()Z", "lazyCacheControl", "getLazyCacheControl$okhttp", "setLazyCacheControl$okhttp", "(Lokhttp3/CacheControl;)V", "()Ljava/lang/String;", "tags", "", "Lkotlin/reflect/KClass;", "getTags$okhttp", "()Ljava/util/Map;", "()Lokhttp3/HttpUrl;", "-deprecated_body", "-deprecated_cacheControl", "header", "name", "-deprecated_headers", "", "-deprecated_method", "newBuilder", "tag", "T", "reifiedTag", "()Ljava/lang/Object;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", "-deprecated_url", "Builder", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: Request.kt */
public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<KClass<?>, Object> tags;
    private final HttpUrl url;

    public Request(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        HttpUrl url$okhttp = builder.getUrl$okhttp();
        if (url$okhttp != null) {
            this.url = url$okhttp;
            this.method = builder.getMethod$okhttp();
            this.headers = builder.getHeaders$okhttp().build();
            this.body = builder.getBody$okhttp();
            this.tags = MapsKt.toMap(builder.getTags$okhttp());
            return;
        }
        throw new IllegalStateException("url == null".toString());
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final String method() {
        return this.method;
    }

    public final Headers headers() {
        return this.headers;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final Map<KClass<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final CacheControl getLazyCacheControl$okhttp() {
        return this.lazyCacheControl;
    }

    public final void setLazyCacheControl$okhttp(CacheControl cacheControl) {
        this.lazyCacheControl = cacheControl;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Request(HttpUrl httpUrl, Headers headers2, String str, RequestBody requestBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpUrl, (i & 2) != 0 ? Headers.Companion.mo42054of(new String[0]) : headers2, (i & 4) != 0 ? "\u0000" : str, (i & 8) != 0 ? null : requestBody);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Request(HttpUrl httpUrl, Headers headers2, String str, RequestBody requestBody) {
        this(new Builder().url(httpUrl).headers(headers2).method(Intrinsics.areEqual((Object) str, (Object) "\u0000") ? requestBody != null ? "POST" : "GET" : str, requestBody));
        Intrinsics.checkNotNullParameter(httpUrl, "url");
        Intrinsics.checkNotNullParameter(headers2, "headers");
        Intrinsics.checkNotNullParameter(str, "method");
    }

    public final String header(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return _RequestCommonKt.commonHeader(this, str);
    }

    public final List<String> headers(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return _RequestCommonKt.commonHeaders(this, str);
    }

    public final /* synthetic */ <T> T reifiedTag() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return tag(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> T tag(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, SessionDescription.ATTR_TYPE);
        return JvmClassMappingKt.getJavaClass(kClass).cast(this.tags.get(kClass));
    }

    public final <T> T tag(Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(cls, SessionDescription.ATTR_TYPE);
        return tag(JvmClassMappingKt.getKotlinClass(cls));
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m2706deprecated_url() {
        return this.url;
    }

    @Metadata(mo33736d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H\u0016J\u0014\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0017J\b\u0010,\u001a\u00020\u0000H\u0016J\b\u0010-\u001a\u00020\u0000H\u0016J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u0013H\u0016J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020/H\u0016J\u001a\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00101\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00102\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u00103\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0013H\u0016J&\u00104\u001a\u00020\u0000\"\n\b\u0000\u00105\u0018\u0001*\u00020\u00012\b\u00104\u001a\u0004\u0018\u0001H5H\b¢\u0006\u0004\b6\u00107J-\u00104\u001a\u00020\u0000\"\u0004\b\u0000\u001052\u000e\u00108\u001a\n\u0012\u0006\b\u0000\u0012\u0002H5092\b\u00104\u001a\u0004\u0018\u0001H5H\u0016¢\u0006\u0002\u0010:J\u0012\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0001H\u0016J-\u00104\u001a\u00020\u0000\"\b\b\u0000\u00105*\u00020\u00012\f\u00108\u001a\b\u0012\u0004\u0012\u0002H50\u001a2\b\u00104\u001a\u0004\u0018\u0001H5¢\u0006\u0002\u0010;J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020<H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a\u0012\u0004\u0012\u00020\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006="}, mo33737d2 = {"Lokhttp3/Request$Builder;", "", "()V", "request", "Lokhttp3/Request;", "(Lokhttp3/Request;)V", "body", "Lokhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "method", "", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "tags", "", "Lkotlin/reflect/KClass;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "url", "Lokhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "addHeader", "name", "value", "build", "cacheControl", "Lokhttp3/CacheControl;", "delete", "get", "head", "header", "Lokhttp3/Headers;", "patch", "post", "put", "removeHeader", "tag", "T", "reifiedTag", "(Ljava/lang/Object;)Lokhttp3/Request$Builder;", "type", "Ljava/lang/Class;", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Ljava/net/URL;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: Request.kt */
    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<KClass<?>, ? extends Object> tags;
        private HttpUrl url;

        public final Builder delete() {
            return delete$default(this, (RequestBody) null, 1, (Object) null);
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    requestBody = _UtilCommonKt.getCommonEmptyRequestBody();
                }
                return builder.delete(requestBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final void setMethod$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.method = str;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.headers = builder;
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final Map<KClass<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final void setTags$okhttp(Map<KClass<?>, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.tags = map;
        }

        public Builder() {
            this.tags = MapsKt.emptyMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder(Request request) {
            Map<KClass<?>, ? extends Object> map;
            Intrinsics.checkNotNullParameter(request, "request");
            this.tags = MapsKt.emptyMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                map = MapsKt.emptyMap();
            } else {
                map = MapsKt.toMutableMap(request.getTags$okhttp());
            }
            this.tags = map;
            this.headers = request.headers().newBuilder();
        }

        public Builder url(HttpUrl httpUrl) {
            Intrinsics.checkNotNullParameter(httpUrl, "url");
            Builder builder = this;
            builder.url = httpUrl;
            return builder;
        }

        public Builder url(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return url(HttpUrl.Companion.get(_RequestCommonKt.canonicalUrl(str)));
        }

        public Builder url(URL url2) {
            Intrinsics.checkNotNullParameter(url2, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String url3 = url2.toString();
            Intrinsics.checkNotNullExpressionValue(url3, "url.toString()");
            return url(companion.get(url3));
        }

        public Builder header(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            return _RequestCommonKt.commonHeader(this, str, str2);
        }

        public Builder addHeader(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "value");
            return _RequestCommonKt.commonAddHeader(this, str, str2);
        }

        public Builder removeHeader(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return _RequestCommonKt.commonRemoveHeader(this, str);
        }

        public Builder headers(Headers headers2) {
            Intrinsics.checkNotNullParameter(headers2, "headers");
            return _RequestCommonKt.commonHeaders(this, headers2);
        }

        public Builder cacheControl(CacheControl cacheControl) {
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            return _RequestCommonKt.commonCacheControl(this, cacheControl);
        }

        public Builder get() {
            return _RequestCommonKt.commonGet(this);
        }

        public Builder head() {
            return _RequestCommonKt.commonHead(this);
        }

        public Builder post(RequestBody requestBody) {
            Intrinsics.checkNotNullParameter(requestBody, TtmlNode.TAG_BODY);
            return _RequestCommonKt.commonPost(this, requestBody);
        }

        public Builder delete(RequestBody requestBody) {
            return _RequestCommonKt.commonDelete(this, requestBody);
        }

        public Builder put(RequestBody requestBody) {
            Intrinsics.checkNotNullParameter(requestBody, TtmlNode.TAG_BODY);
            return _RequestCommonKt.commonPut(this, requestBody);
        }

        public Builder patch(RequestBody requestBody) {
            Intrinsics.checkNotNullParameter(requestBody, TtmlNode.TAG_BODY);
            return _RequestCommonKt.commonPatch(this, requestBody);
        }

        public Builder method(String str, RequestBody requestBody) {
            Intrinsics.checkNotNullParameter(str, "method");
            return _RequestCommonKt.commonMethod(this, str, requestBody);
        }

        public final /* synthetic */ <T> Builder reifiedTag(T t) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return tag(Reflection.getOrCreateKotlinClass(Object.class), t);
        }

        public final <T> Builder tag(KClass<T> kClass, T t) {
            Intrinsics.checkNotNullParameter(kClass, SessionDescription.ATTR_TYPE);
            return _RequestCommonKt.commonTag(this, kClass, t);
        }

        public Builder tag(Object obj) {
            return _RequestCommonKt.commonTag(this, Reflection.getOrCreateKotlinClass(Object.class), obj);
        }

        public <T> Builder tag(Class<? super T> cls, T t) {
            Intrinsics.checkNotNullParameter(cls, SessionDescription.ATTR_TYPE);
            return _RequestCommonKt.commonTag(this, JvmClassMappingKt.getKotlinClass(cls), t);
        }

        public Request build() {
            return new Request(this);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "method", imports = {}))
    /* renamed from: -deprecated_method  reason: not valid java name */
    public final String m2705deprecated_method() {
        return this.method;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))
    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m2704deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    /* renamed from: -deprecated_body  reason: not valid java name */
    public final RequestBody m2702deprecated_body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))
    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m2703deprecated_cacheControl() {
        return cacheControl();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Object next : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair pair = (Pair) next;
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append(':');
                sb.append(str2);
                i = i2;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final Object tag() {
        return tag(Reflection.getOrCreateKotlinClass(Object.class));
    }
}
