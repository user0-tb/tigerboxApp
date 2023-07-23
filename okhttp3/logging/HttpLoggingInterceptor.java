package okhttp3.logging;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p013io.CloseableKt;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.internal.Utf8Kt;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

@Metadata(mo33736d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\n\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, mo33737d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", "i", "", "redactHeader", "name", "setLevel", "Level", "Logger", "logging-interceptor"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HttpLoggingInterceptor.kt */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, mo33737d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", "", "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "logging-interceptor"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HttpLoggingInterceptor.kt */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public HttpLoggingInterceptor() {
        this((Logger) null, 1, (DefaultConstructorMarker) null);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.logger = logger2;
        this.headersToRedact = SetsKt.emptySet();
        this.level = Level.NONE;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpLoggingInterceptor(Logger logger2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Logger.DEFAULT : logger2);
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void level(Level level2) {
        Intrinsics.checkNotNullParameter(level2, "<set-?>");
        this.level = level2;
    }

    @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo33737d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "", "log", "", "message", "", "Companion", "logging-interceptor"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: HttpLoggingInterceptor.kt */
    public interface Logger {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        void log(String str);

        @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, mo33737d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", "", "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DefaultLogger", "logging-interceptor"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* compiled from: HttpLoggingInterceptor.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            @Metadata(mo33736d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo33737d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "()V", "log", "", "message", "", "logging-interceptor"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
            /* compiled from: HttpLoggingInterceptor.kt */
            private static final class DefaultLogger implements Logger {
                public void log(String str) {
                    Intrinsics.checkNotNullParameter(str, "message");
                    Platform.log$default(Platform.Companion.get(), str, 0, (Throwable) null, 6, (Object) null);
                }
            }
        }
    }

    public final void redactHeader(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        Collection collection = treeSet;
        CollectionsKt.addAll(collection, this.headersToRedact);
        collection.add(str);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level2) {
        Intrinsics.checkNotNullParameter(level2, "level");
        HttpLoggingInterceptor httpLoggingInterceptor = this;
        httpLoggingInterceptor.level = level2;
        return httpLoggingInterceptor;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to var", replaceWith = @ReplaceWith(expression = "level", imports = {}))
    /* renamed from: -deprecated_level  reason: not valid java name */
    public final Level m2727deprecated_level() {
        return this.level;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        String str2;
        boolean z;
        String str3;
        String str4;
        String str5;
        String str6;
        long j;
        char c;
        String str7;
        String str8;
        Long l;
        Throwable th;
        String str9;
        Long l2;
        Throwable th2;
        Interceptor.Chain chain2 = chain;
        Intrinsics.checkNotNullParameter(chain2, "chain");
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain2.proceed(request);
        }
        boolean z2 = level2 == Level.BODY;
        boolean z3 = z2 || level2 == Level.HEADERS;
        RequestBody body = request.body();
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        if (connection != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(' ');
            sb2.append(connection.protocol());
            str = sb2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        String sb3 = sb.toString();
        if (!z3 && body != null) {
            sb3 = sb3 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(sb3);
        if (z3) {
            Headers headers = request.headers();
            if (body != null) {
                MediaType contentType = body.contentType();
                z = z3;
                if (contentType == null || headers.get("Content-Type") != null) {
                    str9 = "-byte body)";
                } else {
                    Logger logger2 = this.logger;
                    StringBuilder sb4 = new StringBuilder();
                    str9 = "-byte body)";
                    sb4.append("Content-Type: ");
                    sb4.append(contentType);
                    logger2.log(sb4.toString());
                }
                if (body.contentLength() == -1 || headers.get("Content-Length") != null) {
                    str4 = "-gzipped-byte body)";
                } else {
                    Logger logger3 = this.logger;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Content-Length: ");
                    str4 = "-gzipped-byte body)";
                    sb5.append(body.contentLength());
                    logger3.log(sb5.toString());
                }
            } else {
                z = z3;
                str4 = "-gzipped-byte body)";
                str9 = "-byte body)";
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                logHeader(headers, i);
            }
            if (!z2 || body == null) {
                str2 = "gzip";
                str3 = str9;
                this.logger.log("--> END " + request.method());
            } else {
                if (bodyHasUnknownEncoding(request.headers())) {
                    this.logger.log("--> END " + request.method() + " (encoded body omitted)");
                } else if (body.isDuplex()) {
                    this.logger.log("--> END " + request.method() + " (duplex request body omitted)");
                } else if (body.isOneShot()) {
                    this.logger.log("--> END " + request.method() + " (one-shot body omitted)");
                } else {
                    Buffer buffer = new Buffer();
                    body.writeTo(buffer);
                    if (StringsKt.equals("gzip", headers.get("Content-Encoding"), true)) {
                        l2 = Long.valueOf(buffer.size());
                        Closeable gzipSource = new GzipSource(buffer);
                        try {
                            Buffer buffer2 = new Buffer();
                            buffer2.writeAll((GzipSource) gzipSource);
                            CloseableKt.closeFinally(gzipSource, (Throwable) null);
                            buffer = buffer2;
                        } catch (Throwable th3) {
                            Throwable th4 = th3;
                            CloseableKt.closeFinally(gzipSource, th2);
                            throw th4;
                        }
                    } else {
                        l2 = null;
                    }
                    str2 = "gzip";
                    Charset charset$default = Internal.charset$default(body.contentType(), (Charset) null, 1, (Object) null);
                    this.logger.log("");
                    if (!Utf8Kt.isProbablyUtf8(buffer)) {
                        this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                    } else if (l2 != null) {
                        this.logger.log("--> END " + request.method() + " (" + buffer.size() + "-byte, " + l2 + str4);
                    } else {
                        this.logger.log(buffer.readString(charset$default));
                        Logger logger4 = this.logger;
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("--> END ");
                        sb6.append(request.method());
                        sb6.append(" (");
                        sb6.append(body.contentLength());
                        str3 = str9;
                        sb6.append(str3);
                        logger4.log(sb6.toString());
                    }
                    str3 = str9;
                }
                str2 = "gzip";
                str3 = str9;
            }
        } else {
            z = z3;
            str2 = "gzip";
            str4 = "-gzipped-byte body)";
            str3 = "-byte body)";
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            Intrinsics.checkNotNull(body2);
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(contentLength);
                str5 = str3;
                sb7.append("-byte");
                str6 = sb7.toString();
            } else {
                str5 = str3;
                str6 = "unknown-length";
            }
            Logger logger5 = this.logger;
            String str10 = str4;
            StringBuilder sb8 = new StringBuilder();
            String str11 = "-byte, ";
            sb8.append("<-- ");
            sb8.append(proceed.code());
            if (proceed.message().length() == 0) {
                j = contentLength;
                str7 = "";
                c = ' ';
            } else {
                String message = proceed.message();
                j = contentLength;
                StringBuilder sb9 = new StringBuilder();
                c = ' ';
                sb9.append(' ');
                sb9.append(message);
                str7 = sb9.toString();
            }
            sb8.append(str7);
            sb8.append(c);
            sb8.append(proceed.request().url());
            sb8.append(" (");
            sb8.append(millis);
            sb8.append("ms");
            if (!z) {
                str8 = ", " + str6 + " body";
            } else {
                str8 = "";
            }
            sb8.append(str8);
            sb8.append(')');
            logger5.log(sb8.toString());
            if (z) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    logHeader(headers2, i2);
                }
                if (!z2 || !HttpHeaders.promisesBody(proceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(proceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer3 = source.getBuffer();
                    if (StringsKt.equals(str2, headers2.get("Content-Encoding"), true)) {
                        l = Long.valueOf(buffer3.size());
                        Closeable gzipSource2 = new GzipSource(buffer3.clone());
                        try {
                            Buffer buffer4 = new Buffer();
                            buffer4.writeAll((GzipSource) gzipSource2);
                            CloseableKt.closeFinally(gzipSource2, (Throwable) null);
                            buffer3 = buffer4;
                        } catch (Throwable th5) {
                            Throwable th6 = th5;
                            CloseableKt.closeFinally(gzipSource2, th);
                            throw th6;
                        }
                    } else {
                        l = null;
                    }
                    Charset charset$default2 = Internal.charset$default(body2.contentType(), (Charset) null, 1, (Object) null);
                    if (!Utf8Kt.isProbablyUtf8(buffer3)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + buffer3.size() + "-byte body omitted)");
                        return proceed;
                    }
                    if (j != 0) {
                        this.logger.log("");
                        this.logger.log(buffer3.clone().readString(charset$default2));
                    }
                    if (l != null) {
                        this.logger.log("<-- END HTTP (" + buffer3.size() + str11 + l + str10);
                    } else {
                        this.logger.log("<-- END HTTP (" + buffer3.size() + str5);
                    }
                }
            }
            return proceed;
        } catch (Exception e) {
            Exception exc = e;
            this.logger.log("<-- HTTP FAILED: " + exc);
            throw exc;
        }
    }

    private final void logHeader(Headers headers, int i) {
        String value = this.headersToRedact.contains(headers.name(i)) ? "██" : headers.value(i);
        Logger logger2 = this.logger;
        logger2.log(headers.name(i) + ": " + value);
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        if (str != null && !StringsKt.equals(str, "identity", true) && !StringsKt.equals(str, "gzip", true)) {
            return true;
        }
        return false;
    }
}
