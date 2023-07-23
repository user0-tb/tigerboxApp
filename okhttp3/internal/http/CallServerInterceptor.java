package okhttp3.internal.http;

import kotlin.Metadata;
import okhttp3.Interceptor;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo33737d2 = {"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: CallServerInterceptor.kt */
public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z) {
        this.forWebSocket = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0090, code lost:
        if (r3.isDuplex() == false) goto L_0x0092;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a8 A[SYNTHETIC, Splitter:B:40:0x00a8] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dd A[Catch:{ IOException -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0118 A[Catch:{ IOException -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011d A[Catch:{ IOException -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x015f A[Catch:{ IOException -> 0x0187 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0160 A[Catch:{ IOException -> 0x0187 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0195  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r14) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "Connection"
            java.lang.String r1 = "close"
            java.lang.String r2 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r2)
            okhttp3.internal.http.RealInterceptorChain r14 = (okhttp3.internal.http.RealInterceptorChain) r14
            okhttp3.internal.connection.Exchange r2 = r14.getExchange$okhttp()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            okhttp3.Request r14 = r14.getRequest$okhttp()
            okhttp3.RequestBody r3 = r14.body()
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 0
            r7 = 0
            r8 = 1
            r2.writeRequestHeaders(r14)     // Catch:{ IOException -> 0x0099 }
            java.lang.String r9 = r14.method()     // Catch:{ IOException -> 0x0099 }
            boolean r9 = okhttp3.internal.http.HttpMethod.permitsRequestBody(r9)     // Catch:{ IOException -> 0x0099 }
            if (r9 == 0) goto L_0x0085
            if (r3 == 0) goto L_0x0085
            java.lang.String r9 = "100-continue"
            java.lang.String r10 = "Expect"
            java.lang.String r10 = r14.header(r10)     // Catch:{ IOException -> 0x0099 }
            boolean r9 = kotlin.text.StringsKt.equals(r9, r10, r8)     // Catch:{ IOException -> 0x0099 }
            if (r9 == 0) goto L_0x004c
            r2.flushRequest()     // Catch:{ IOException -> 0x0099 }
            okhttp3.Response$Builder r9 = r2.readResponseHeaders(r8)     // Catch:{ IOException -> 0x0099 }
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x004a }
            r10 = 0
            goto L_0x004e
        L_0x004a:
            r3 = move-exception
            goto L_0x009b
        L_0x004c:
            r9 = r6
            r10 = 1
        L_0x004e:
            if (r9 != 0) goto L_0x0074
            boolean r11 = r3.isDuplex()     // Catch:{ IOException -> 0x0097 }
            if (r11 == 0) goto L_0x0065
            r2.flushRequest()     // Catch:{ IOException -> 0x0097 }
            okio.Sink r11 = r2.createRequestBody(r14, r8)     // Catch:{ IOException -> 0x0097 }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ IOException -> 0x0097 }
            r3.writeTo(r11)     // Catch:{ IOException -> 0x0097 }
            goto L_0x008a
        L_0x0065:
            okio.Sink r11 = r2.createRequestBody(r14, r7)     // Catch:{ IOException -> 0x0097 }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ IOException -> 0x0097 }
            r3.writeTo(r11)     // Catch:{ IOException -> 0x0097 }
            r11.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x008a
        L_0x0074:
            r2.noRequestBody()     // Catch:{ IOException -> 0x0097 }
            okhttp3.internal.connection.RealConnection r11 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x0097 }
            boolean r11 = r11.isMultiplexed$okhttp()     // Catch:{ IOException -> 0x0097 }
            if (r11 != 0) goto L_0x008a
            r2.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x0097 }
            goto L_0x008a
        L_0x0085:
            r2.noRequestBody()     // Catch:{ IOException -> 0x0099 }
            r9 = r6
            r10 = 1
        L_0x008a:
            if (r3 == 0) goto L_0x0092
            boolean r3 = r3.isDuplex()     // Catch:{ IOException -> 0x0097 }
            if (r3 != 0) goto L_0x0095
        L_0x0092:
            r2.finishRequest()     // Catch:{ IOException -> 0x0097 }
        L_0x0095:
            r3 = r6
            goto L_0x00a6
        L_0x0097:
            r3 = move-exception
            goto L_0x009c
        L_0x0099:
            r3 = move-exception
            r9 = r6
        L_0x009b:
            r10 = 1
        L_0x009c:
            boolean r11 = r3 instanceof okhttp3.internal.http2.ConnectionShutdownException
            if (r11 != 0) goto L_0x0195
            boolean r11 = r2.getHasFailure$okhttp()
            if (r11 == 0) goto L_0x0194
        L_0x00a6:
            if (r9 != 0) goto L_0x00b5
            okhttp3.Response$Builder r9 = r2.readResponseHeaders(r7)     // Catch:{ IOException -> 0x0187 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)     // Catch:{ IOException -> 0x0187 }
            if (r10 == 0) goto L_0x00b5
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x0187 }
            r10 = 0
        L_0x00b5:
            okhttp3.Response$Builder r9 = r9.request(r14)     // Catch:{ IOException -> 0x0187 }
            okhttp3.internal.connection.RealConnection r11 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x0187 }
            okhttp3.Handshake r11 = r11.handshake()     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response$Builder r9 = r9.handshake(r11)     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response$Builder r9 = r9.sentRequestAtMillis(r4)     // Catch:{ IOException -> 0x0187 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response$Builder r9 = r9.receivedResponseAtMillis(r11)     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response r9 = r9.build()     // Catch:{ IOException -> 0x0187 }
            int r11 = r9.code()     // Catch:{ IOException -> 0x0187 }
            r12 = 100
            if (r11 != r12) goto L_0x010d
            okhttp3.Response$Builder r7 = r2.readResponseHeaders(r7)     // Catch:{ IOException -> 0x0187 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ IOException -> 0x0187 }
            if (r10 == 0) goto L_0x00e9
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x0187 }
        L_0x00e9:
            okhttp3.Response$Builder r14 = r7.request(r14)     // Catch:{ IOException -> 0x0187 }
            okhttp3.internal.connection.RealConnection r7 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x0187 }
            okhttp3.Handshake r7 = r7.handshake()     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response$Builder r14 = r14.handshake(r7)     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response$Builder r14 = r14.sentRequestAtMillis(r4)     // Catch:{ IOException -> 0x0187 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response$Builder r14 = r14.receivedResponseAtMillis(r4)     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response r9 = r14.build()     // Catch:{ IOException -> 0x0187 }
            int r11 = r9.code()     // Catch:{ IOException -> 0x0187 }
        L_0x010d:
            r2.responseHeadersEnd(r9)     // Catch:{ IOException -> 0x0187 }
            boolean r14 = r13.forWebSocket     // Catch:{ IOException -> 0x0187 }
            if (r14 == 0) goto L_0x011d
            r14 = 101(0x65, float:1.42E-43)
            if (r11 != r14) goto L_0x011d
            okhttp3.Response r14 = okhttp3.internal._ResponseCommonKt.stripBody(r9)     // Catch:{ IOException -> 0x0187 }
            goto L_0x012d
        L_0x011d:
            okhttp3.Response$Builder r14 = r9.newBuilder()     // Catch:{ IOException -> 0x0187 }
            okhttp3.ResponseBody r4 = r2.openResponseBody(r9)     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response$Builder r14 = r14.body(r4)     // Catch:{ IOException -> 0x0187 }
            okhttp3.Response r14 = r14.build()     // Catch:{ IOException -> 0x0187 }
        L_0x012d:
            okhttp3.Request r4 = r14.request()     // Catch:{ IOException -> 0x0187 }
            java.lang.String r4 = r4.header(r0)     // Catch:{ IOException -> 0x0187 }
            boolean r4 = kotlin.text.StringsKt.equals(r1, r4, r8)     // Catch:{ IOException -> 0x0187 }
            if (r4 != 0) goto L_0x0146
            r4 = 2
            java.lang.String r0 = okhttp3.Response.header$default(r14, r0, r6, r4, r6)     // Catch:{ IOException -> 0x0187 }
            boolean r0 = kotlin.text.StringsKt.equals(r1, r0, r8)     // Catch:{ IOException -> 0x0187 }
            if (r0 == 0) goto L_0x0149
        L_0x0146:
            r2.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x0187 }
        L_0x0149:
            r0 = 204(0xcc, float:2.86E-43)
            if (r11 == r0) goto L_0x0151
            r0 = 205(0xcd, float:2.87E-43)
            if (r11 != r0) goto L_0x015f
        L_0x0151:
            okhttp3.ResponseBody r0 = r14.body()     // Catch:{ IOException -> 0x0187 }
            long r0 = r0.contentLength()     // Catch:{ IOException -> 0x0187 }
            r4 = 0
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0160
        L_0x015f:
            return r14
        L_0x0160:
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0187 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0187 }
            r1.<init>()     // Catch:{ IOException -> 0x0187 }
            java.lang.String r2 = "HTTP "
            r1.append(r2)     // Catch:{ IOException -> 0x0187 }
            r1.append(r11)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r2 = " had non-zero Content-Length: "
            r1.append(r2)     // Catch:{ IOException -> 0x0187 }
            okhttp3.ResponseBody r14 = r14.body()     // Catch:{ IOException -> 0x0187 }
            long r4 = r14.contentLength()     // Catch:{ IOException -> 0x0187 }
            r1.append(r4)     // Catch:{ IOException -> 0x0187 }
            java.lang.String r14 = r1.toString()     // Catch:{ IOException -> 0x0187 }
            r0.<init>(r14)     // Catch:{ IOException -> 0x0187 }
            throw r0     // Catch:{ IOException -> 0x0187 }
        L_0x0187:
            r14 = move-exception
            if (r3 == 0) goto L_0x0193
            r0 = r3
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            kotlin.ExceptionsKt.addSuppressed(r0, r14)
            throw r3
        L_0x0193:
            throw r14
        L_0x0194:
            throw r3
        L_0x0195:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
