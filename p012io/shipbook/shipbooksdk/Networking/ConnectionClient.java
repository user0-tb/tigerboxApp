package p012io.shipbook.shipbooksdk.Networking;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import p012io.shipbook.shipbooksdk.Models.BaseObj;

@Metadata(mo33736d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHHø\u0001\u0000¢\u0006\u0002\u0010\u0010J-\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00122\b\b\u0002\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Networking/ConnectionClient;", "", "()V", "baseUrl", "", "getBaseUrl", "()Ljava/lang/String;", "setBaseUrl", "(Ljava/lang/String;)V", "request", "Lio/shipbook/shipbooksdk/Networking/ResponseData;", "url", "data", "Lio/shipbook/shipbooksdk/Models/BaseObj;", "method", "Lio/shipbook/shipbooksdk/Networking/HttpMethod;", "(Ljava/lang/String;Lio/shipbook/shipbooksdk/Models/BaseObj;Lio/shipbook/shipbooksdk/Networking/HttpMethod;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Lio/shipbook/shipbooksdk/Networking/HttpMethod;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/lang/String;Ljava/util/List;Lio/shipbook/shipbooksdk/Networking/HttpMethod;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Networking.ConnectionClient */
/* compiled from: ConnectionClient.kt */
public final class ConnectionClient {
    public static final ConnectionClient INSTANCE = new ConnectionClient();
    private static String baseUrl = "https://api.shipbook.io/v1/";

    private ConnectionClient() {
    }

    public final String getBaseUrl() {
        return baseUrl;
    }

    public final void setBaseUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        baseUrl = str;
    }

    public static /* synthetic */ Object request$default(ConnectionClient connectionClient, String str, List list, HttpMethod httpMethod, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            httpMethod = HttpMethod.GET;
        }
        return connectionClient.request(str, (List<? extends BaseObj>) list, httpMethod, (Continuation<? super ResponseData>) continuation);
    }

    public final Object request(String str, List<? extends BaseObj> list, HttpMethod httpMethod, Continuation<? super ResponseData> continuation) {
        JSONArray jSONArray = new JSONArray();
        for (BaseObj json : list) {
            jSONArray.put(json.toJson());
        }
        return request(str, jSONArray.toString(), httpMethod, continuation);
    }

    public static /* synthetic */ Object request$default(ConnectionClient connectionClient, String str, BaseObj baseObj, HttpMethod httpMethod, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            httpMethod = HttpMethod.GET;
        }
        String jSONObject = baseObj.toJson().toString();
        InlineMarker.mark(0);
        Object request = connectionClient.request(str, jSONObject, httpMethod, (Continuation<? super ResponseData>) continuation);
        InlineMarker.mark(1);
        return request;
    }

    private final Object request$$forInline(String str, BaseObj baseObj, HttpMethod httpMethod, Continuation<? super ResponseData> continuation) {
        String jSONObject = baseObj.toJson().toString();
        InlineMarker.mark(0);
        Object request = request(str, jSONObject, httpMethod, continuation);
        InlineMarker.mark(1);
        return request;
    }

    public final Object request(String str, BaseObj baseObj, HttpMethod httpMethod, Continuation<? super ResponseData> continuation) {
        return request(str, baseObj.toJson().toString(), httpMethod, continuation);
    }

    public static /* synthetic */ Object request$default(ConnectionClient connectionClient, String str, String str2, HttpMethod httpMethod, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            httpMethod = HttpMethod.GET;
        }
        return connectionClient.request(str, str2, httpMethod, (Continuation<? super ResponseData>) continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01d2 A[Catch:{ Exception -> 0x0201 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object request(java.lang.String r23, java.lang.String r24, p012io.shipbook.shipbooksdk.Networking.HttpMethod r25, kotlin.coroutines.Continuation<? super p012io.shipbook.shipbooksdk.Networking.ResponseData> r26) {
        /*
            r22 = this;
            r0 = r23
            r1 = r24
            r2 = r26
            boolean r3 = r2 instanceof p012io.shipbook.shipbooksdk.Networking.ConnectionClient$request$4
            if (r3 == 0) goto L_0x001c
            r3 = r2
            io.shipbook.shipbooksdk.Networking.ConnectionClient$request$4 r3 = (p012io.shipbook.shipbooksdk.Networking.ConnectionClient$request$4) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001c
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            r4 = r22
            goto L_0x0023
        L_0x001c:
            io.shipbook.shipbooksdk.Networking.ConnectionClient$request$4 r3 = new io.shipbook.shipbooksdk.Networking.ConnectionClient$request$4
            r4 = r22
            r3.<init>(r4, r2)
        L_0x0023:
            java.lang.Object r2 = r3.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r3.label
            r7 = 2
            r8 = 1
            r9 = 0
            if (r6 == 0) goto L_0x005d
            if (r6 == r8) goto L_0x0041
            if (r6 != r7) goto L_0x0039
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ Exception -> 0x0201 }
            goto L_0x01e5
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0041:
            java.lang.Object r0 = r3.L$3
            io.shipbook.shipbooksdk.Networking.ResponseData r0 = (p012io.shipbook.shipbooksdk.Networking.ResponseData) r0
            java.lang.Object r1 = r3.L$2
            io.shipbook.shipbooksdk.Networking.HttpMethod r1 = (p012io.shipbook.shipbooksdk.Networking.HttpMethod) r1
            java.lang.Object r6 = r3.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r8 = r3.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ Exception -> 0x0201 }
            r11 = r0
            r0 = r8
            r21 = r6
            r6 = r1
            r1 = r21
            goto L_0x01ca
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.String r2 = r22.getBaseUrl()
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r0)
            io.shipbook.shipbooksdk.InnerLog r10 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE
            java.lang.String r11 = p012io.shipbook.shipbooksdk.Networking.ConnectionClientKt.TAG
            java.lang.String r6 = "the url: "
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r2)
            r13 = 0
            r14 = 4
            r15 = 0
            p012io.shipbook.shipbooksdk.InnerLog.d$default(r10, r11, r12, r13, r14, r15)
            java.net.URL r6 = new java.net.URL
            r6.<init>(r2)
            java.net.URLConnection r2 = r6.openConnection()     // Catch:{ Exception -> 0x0201 }
            if (r2 == 0) goto L_0x01f9
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x0201 }
            java.lang.String r6 = r25.getValue()     // Catch:{ Exception -> 0x0201 }
            r2.setRequestMethod(r6)     // Catch:{ Exception -> 0x0201 }
            io.shipbook.shipbooksdk.InnerLog r10 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ Exception -> 0x0201 }
            java.lang.String r11 = p012io.shipbook.shipbooksdk.Networking.ConnectionClientKt.TAG     // Catch:{ Exception -> 0x0201 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0201 }
            r6.<init>()     // Catch:{ Exception -> 0x0201 }
            java.lang.String r12 = "Sending '"
            r6.append(r12)     // Catch:{ Exception -> 0x0201 }
            java.lang.String r12 = r25.getValue()     // Catch:{ Exception -> 0x0201 }
            r6.append(r12)     // Catch:{ Exception -> 0x0201 }
            java.lang.String r12 = "' request to URL : "
            r6.append(r12)     // Catch:{ Exception -> 0x0201 }
            r6.append(r0)     // Catch:{ Exception -> 0x0201 }
            java.lang.String r12 = r6.toString()     // Catch:{ Exception -> 0x0201 }
            r13 = 0
            r14 = 4
            r15 = 0
            p012io.shipbook.shipbooksdk.InnerLog.i$default(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0201 }
            io.shipbook.shipbooksdk.Networking.SessionManager r6 = p012io.shipbook.shipbooksdk.Networking.SessionManager.INSTANCE     // Catch:{ Exception -> 0x0201 }
            java.lang.String r6 = r6.getToken()     // Catch:{ Exception -> 0x0201 }
            if (r6 != 0) goto L_0x00c0
            goto L_0x00cb
        L_0x00c0:
            java.lang.String r10 = "Authorization"
            java.lang.String r11 = "Bearer "
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r6)     // Catch:{ Exception -> 0x0201 }
            r2.setRequestProperty(r10, r6)     // Catch:{ Exception -> 0x0201 }
        L_0x00cb:
            r6 = 8192(0x2000, float:1.14794E-41)
            if (r1 != 0) goto L_0x00d0
            goto L_0x0115
        L_0x00d0:
            io.shipbook.shipbooksdk.InnerLog r10 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ Exception -> 0x0201 }
            java.lang.String r11 = p012io.shipbook.shipbooksdk.Networking.ConnectionClientKt.TAG     // Catch:{ Exception -> 0x0201 }
            java.lang.String r12 = "Sending output : "
            java.lang.String r12 = kotlin.jvm.internal.Intrinsics.stringPlus(r12, r1)     // Catch:{ Exception -> 0x0201 }
            r13 = 0
            r14 = 4
            r15 = 0
            p012io.shipbook.shipbooksdk.InnerLog.d$default(r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0201 }
            java.lang.String r10 = "Content-Type"
            java.lang.String r11 = "application/json"
            r2.setRequestProperty(r10, r11)     // Catch:{ Exception -> 0x0201 }
            java.io.OutputStream r10 = r2.getOutputStream()     // Catch:{ Exception -> 0x0201 }
            java.lang.String r11 = "outputStream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)     // Catch:{ Exception -> 0x0201 }
            java.nio.charset.Charset r11 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0201 }
            java.io.OutputStreamWriter r12 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0201 }
            r12.<init>(r10, r11)     // Catch:{ Exception -> 0x0201 }
            java.io.Writer r12 = (java.io.Writer) r12     // Catch:{ Exception -> 0x0201 }
            boolean r10 = r12 instanceof java.io.BufferedWriter     // Catch:{ Exception -> 0x0201 }
            if (r10 == 0) goto L_0x0102
            java.io.BufferedWriter r12 = (java.io.BufferedWriter) r12     // Catch:{ Exception -> 0x0201 }
            goto L_0x0108
        L_0x0102:
            java.io.BufferedWriter r10 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0201 }
            r10.<init>(r12, r6)     // Catch:{ Exception -> 0x0201 }
            r12 = r10
        L_0x0108:
            java.io.Closeable r12 = (java.io.Closeable) r12     // Catch:{ Exception -> 0x0201 }
            r10 = r12
            java.io.BufferedWriter r10 = (java.io.BufferedWriter) r10     // Catch:{ all -> 0x01f0 }
            r10.write(r1)     // Catch:{ all -> 0x01f0 }
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x01f0 }
            kotlin.p013io.CloseableKt.closeFinally(r12, r9)     // Catch:{ Exception -> 0x0201 }
        L_0x0115:
            io.shipbook.shipbooksdk.InnerLog r13 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ Exception -> 0x0201 }
            java.lang.String r14 = p012io.shipbook.shipbooksdk.Networking.ConnectionClientKt.TAG     // Catch:{ Exception -> 0x0201 }
            java.lang.String r10 = "Response Code : "
            int r11 = r2.getResponseCode()     // Catch:{ Exception -> 0x0201 }
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)     // Catch:{ Exception -> 0x0201 }
            java.lang.String r15 = kotlin.jvm.internal.Intrinsics.stringPlus(r10, r11)     // Catch:{ Exception -> 0x0201 }
            r16 = 0
            r17 = 4
            r18 = 0
            p012io.shipbook.shipbooksdk.InnerLog.i$default(r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x0201 }
            int r10 = r2.getResponseCode()     // Catch:{ Exception -> 0x0201 }
            r11 = 200(0xc8, float:2.8E-43)
            r12 = 0
            if (r11 > r10) goto L_0x0141
            r11 = 300(0x12c, float:4.2E-43)
            if (r10 >= r11) goto L_0x0141
            r10 = 1
            goto L_0x0142
        L_0x0141:
            r10 = 0
        L_0x0142:
            if (r10 != 0) goto L_0x0149
            java.io.InputStream r11 = r2.getErrorStream()     // Catch:{ Exception -> 0x0201 }
            goto L_0x014d
        L_0x0149:
            java.io.InputStream r11 = r2.getInputStream()     // Catch:{ Exception -> 0x0201 }
        L_0x014d:
            java.lang.String r13 = "stream"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r13)     // Catch:{ Exception -> 0x0201 }
            java.nio.charset.Charset r13 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0201 }
            java.io.InputStreamReader r14 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0201 }
            r14.<init>(r11, r13)     // Catch:{ Exception -> 0x0201 }
            java.io.Reader r14 = (java.io.Reader) r14     // Catch:{ Exception -> 0x0201 }
            boolean r11 = r14 instanceof java.io.BufferedReader     // Catch:{ Exception -> 0x0201 }
            if (r11 == 0) goto L_0x0162
            java.io.BufferedReader r14 = (java.io.BufferedReader) r14     // Catch:{ Exception -> 0x0201 }
            goto L_0x0168
        L_0x0162:
            java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0201 }
            r11.<init>(r14, r6)     // Catch:{ Exception -> 0x0201 }
            r14 = r11
        L_0x0168:
            java.io.Closeable r14 = (java.io.Closeable) r14     // Catch:{ Exception -> 0x0201 }
            r6 = r14
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch:{ all -> 0x01e7 }
            java.io.Reader r6 = (java.io.Reader) r6     // Catch:{ all -> 0x01e7 }
            java.lang.String r6 = kotlin.p013io.TextStreamsKt.readText(r6)     // Catch:{ all -> 0x01e7 }
            kotlin.p013io.CloseableKt.closeFinally(r14, r9)     // Catch:{ Exception -> 0x0201 }
            io.shipbook.shipbooksdk.InnerLog r15 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ Exception -> 0x0201 }
            java.lang.String r16 = p012io.shipbook.shipbooksdk.Networking.ConnectionClientKt.TAG     // Catch:{ Exception -> 0x0201 }
            java.lang.String r11 = "The response "
            java.lang.String r17 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r6)     // Catch:{ Exception -> 0x0201 }
            r18 = 0
            r19 = 4
            r20 = 0
            p012io.shipbook.shipbooksdk.InnerLog.d$default(r15, r16, r17, r18, r19, r20)     // Catch:{ Exception -> 0x0201 }
            io.shipbook.shipbooksdk.Networking.ResponseData r11 = new io.shipbook.shipbooksdk.Networking.ResponseData     // Catch:{ Exception -> 0x0201 }
            if (r10 == 0) goto L_0x0190
            r12 = 1
        L_0x0190:
            int r13 = r2.getResponseCode()     // Catch:{ Exception -> 0x0201 }
            r11.<init>(r12, r13, r6)     // Catch:{ Exception -> 0x0201 }
            if (r10 != 0) goto L_0x01e6
            int r2 = r2.getResponseCode()     // Catch:{ Exception -> 0x0201 }
            r6 = 401(0x191, float:5.62E-43)
            if (r2 != r6) goto L_0x01e6
            io.shipbook.shipbooksdk.Models.ErrorResponse r2 = r11.getError()     // Catch:{ Exception -> 0x0201 }
            if (r2 != 0) goto L_0x01a9
            r2 = r9
            goto L_0x01ad
        L_0x01a9:
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x0201 }
        L_0x01ad:
            java.lang.String r6 = "TokenExpired"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r6)     // Catch:{ Exception -> 0x0201 }
            if (r2 == 0) goto L_0x01e6
            io.shipbook.shipbooksdk.Networking.SessionManager r2 = p012io.shipbook.shipbooksdk.Networking.SessionManager.INSTANCE     // Catch:{ Exception -> 0x0201 }
            r3.L$0 = r0     // Catch:{ Exception -> 0x0201 }
            r3.L$1 = r1     // Catch:{ Exception -> 0x0201 }
            r6 = r25
            r3.L$2 = r6     // Catch:{ Exception -> 0x0201 }
            r3.L$3 = r11     // Catch:{ Exception -> 0x0201 }
            r3.label = r8     // Catch:{ Exception -> 0x0201 }
            java.lang.Object r2 = r2.refreshToken(r3)     // Catch:{ Exception -> 0x0201 }
            if (r2 != r5) goto L_0x01ca
            return r5
        L_0x01ca:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0201 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0201 }
            if (r2 == 0) goto L_0x01e6
            io.shipbook.shipbooksdk.Networking.ConnectionClient r2 = INSTANCE     // Catch:{ Exception -> 0x0201 }
            r3.L$0 = r9     // Catch:{ Exception -> 0x0201 }
            r3.L$1 = r9     // Catch:{ Exception -> 0x0201 }
            r3.L$2 = r9     // Catch:{ Exception -> 0x0201 }
            r3.L$3 = r9     // Catch:{ Exception -> 0x0201 }
            r3.label = r7     // Catch:{ Exception -> 0x0201 }
            java.lang.Object r2 = r2.request((java.lang.String) r0, (java.lang.String) r1, (p012io.shipbook.shipbooksdk.Networking.HttpMethod) r6, (kotlin.coroutines.Continuation<? super p012io.shipbook.shipbooksdk.Networking.ResponseData>) r3)     // Catch:{ Exception -> 0x0201 }
            if (r2 != r5) goto L_0x01e5
            return r5
        L_0x01e5:
            return r2
        L_0x01e6:
            return r11
        L_0x01e7:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x01ea }
        L_0x01ea:
            r0 = move-exception
            r2 = r0
            kotlin.p013io.CloseableKt.closeFinally(r14, r1)     // Catch:{ Exception -> 0x0201 }
            throw r2     // Catch:{ Exception -> 0x0201 }
        L_0x01f0:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x01f3 }
        L_0x01f3:
            r0 = move-exception
            r2 = r0
            kotlin.p013io.CloseableKt.closeFinally(r12, r1)     // Catch:{ Exception -> 0x0201 }
            throw r2     // Catch:{ Exception -> 0x0201 }
        L_0x01f9:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException     // Catch:{ Exception -> 0x0201 }
            java.lang.String r1 = "null cannot be cast to non-null type java.net.HttpURLConnection"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0201 }
            throw r0     // Catch:{ Exception -> 0x0201 }
        L_0x0201:
            r0 = move-exception
            io.shipbook.shipbooksdk.InnerLog r1 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE
            java.lang.String r2 = p012io.shipbook.shipbooksdk.Networking.ConnectionClientKt.TAG
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.String r3 = "connection error"
            r1.mo33259e(r2, r3, r0)
            io.shipbook.shipbooksdk.Networking.ResponseData r0 = new io.shipbook.shipbooksdk.Networking.ResponseData
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p012io.shipbook.shipbooksdk.Networking.ConnectionClient.request(java.lang.String, java.lang.String, io.shipbook.shipbooksdk.Networking.HttpMethod, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
