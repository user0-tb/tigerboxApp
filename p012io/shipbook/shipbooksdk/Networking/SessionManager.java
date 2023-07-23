package p012io.shipbook.shipbooksdk.Networking;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p013io.FilesKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import org.json.JSONObject;
import p012io.shipbook.shipbooksdk.BroadcastNames;
import p012io.shipbook.shipbooksdk.C2696R;
import p012io.shipbook.shipbooksdk.Events.EventManager;
import p012io.shipbook.shipbooksdk.ExceptionManager;
import p012io.shipbook.shipbooksdk.InnerLog;
import p012io.shipbook.shipbooksdk.LogManager;
import p012io.shipbook.shipbooksdk.Models.ConfigResponse;
import p012io.shipbook.shipbooksdk.Models.Login;
import p012io.shipbook.shipbooksdk.Models.User;

@Metadata(mo33736d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010:\u001a\u00020&H\u0002J>\u0010\u001f\u001a\u00020&2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010;\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0014\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&\u0018\u00010%2\b\u0010=\u001a\u0004\u0018\u00010>J\u0006\u0010?\u001a\u00020&J\u0010\u0010@\u001a\u00020&2\u0006\u0010A\u001a\u00020\u0013H\u0002J\u0010\u0010@\u001a\u00020&2\u0006\u0010B\u001a\u00020CH\u0002J\u0010\u0010@\u001a\u00020&2\u0006\u0010D\u001a\u00020\u0004H\u0002J\u0011\u0010E\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010FJL\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020\u00042\b\u0010I\u001a\u0004\u0018\u00010\u00042\b\u0010J\u001a\u0004\u0018\u00010\u00042\b\u0010K\u001a\u0004\u0018\u00010\u00042\b\u0010L\u001a\u0004\u0018\u00010\u00042\u0014\u0010M\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010NR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001b\"\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\u0004\u0018\u00010\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R(\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020&\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u0002\u0004\n\u0002\b\u0019¨\u0006O"}, mo33737d2 = {"Lio/shipbook/shipbooksdk/Networking/SessionManager;", "", "()V", "TAG", "", "_login", "Lio/shipbook/shipbooksdk/Models/Login;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "appKey", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "configFile", "Ljava/io/File;", "getConfigFile", "()Ljava/io/File;", "setConfigFile", "(Ljava/io/File;)V", "connected", "", "getConnected", "()Z", "isInLoginRequest", "setInLoginRequest", "(Z)V", "login", "getLogin", "()Lio/shipbook/shipbooksdk/Models/Login;", "setLogin", "(Lio/shipbook/shipbooksdk/Models/Login;)V", "sessionCompletion", "Lkotlin/Function1;", "", "getSessionCompletion", "()Lkotlin/jvm/functions/Function1;", "setSessionCompletion", "(Lkotlin/jvm/functions/Function1;)V", "threadContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getThreadContext", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "token", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "user", "Lio/shipbook/shipbooksdk/Models/User;", "getUser", "()Lio/shipbook/shipbooksdk/Models/User;", "setUser", "(Lio/shipbook/shipbooksdk/Models/User;)V", "innerLogin", "appId", "completion", "userConfig", "Ljava/net/URI;", "logout", "readConfig", "file", "input", "Ljava/io/InputStream;", "configString", "refreshToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUser", "userId", "userName", "fullName", "email", "phoneNumber", "additionalInfo", "", "shipbooksdk_release"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: io.shipbook.shipbooksdk.Networking.SessionManager */
/* compiled from: SessionManager.kt */
public final class SessionManager {
    public static final SessionManager INSTANCE = new SessionManager();
    /* access modifiers changed from: private */
    public static final String TAG = "SessionManager";
    private static Login _login;
    private static String appKey;
    private static Application application;
    private static File configFile;
    private static volatile boolean isInLoginRequest;
    private static Function1<? super String, Unit> sessionCompletion;
    private static final ExecutorCoroutineDispatcher threadContext = ThreadPoolDispatcherKt.newSingleThreadContext("shipbook");
    private static volatile String token;
    private static User user;

    private SessionManager() {
    }

    static {
        Intrinsics.checkNotNullExpressionValue("SessionManager", "SessionManager::class.java.simpleName");
    }

    public final ExecutorCoroutineDispatcher getThreadContext() {
        return threadContext;
    }

    public final Application getApplication() {
        return application;
    }

    public final void setApplication(Application application2) {
        application = application2;
    }

    public final Context getAppContext() {
        Application application2 = application;
        if (application2 == null) {
            return null;
        }
        return application2.getApplicationContext();
    }

    public final String getToken() {
        return token;
    }

    public final void setToken(String str) {
        token = str;
    }

    public final Function1<String, Unit> getSessionCompletion() {
        return sessionCompletion;
    }

    public final void setSessionCompletion(Function1<? super String, Unit> function1) {
        sessionCompletion = function1;
    }

    public final Login getLogin() {
        Login login;
        if (!(user == null || (login = _login) == null)) {
            login.setUser(INSTANCE.getUser());
        }
        return _login;
    }

    public final void setLogin(Login login) {
        _login = login;
    }

    public final User getUser() {
        return user;
    }

    public final void setUser(User user2) {
        user = user2;
    }

    public final File getConfigFile() {
        return configFile;
    }

    public final void setConfigFile(File file) {
        configFile = file;
    }

    public final boolean isInLoginRequest() {
        return isInLoginRequest;
    }

    public final void setInLoginRequest(boolean z) {
        isInLoginRequest = z;
    }

    public final boolean getConnected() {
        if (token != null) {
            return true;
        }
        innerLogin();
        return false;
    }

    public final void login(Application application2, String str, String str2, Function1<? super String, Unit> function1, URI uri) {
        Application application3 = application2;
        String str3 = str2;
        URI uri2 = uri;
        Intrinsics.checkNotNullParameter(application3, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str3, "appKey");
        try {
            application = application3;
            Context appContext = getAppContext();
            File file = new File(appContext == null ? null : appContext.getFilesDir(), "config.json");
            configFile = file;
            Intrinsics.checkNotNull(file);
            if (file.isFile()) {
                File file2 = configFile;
                Intrinsics.checkNotNull(file2);
                if (file2.length() > 0) {
                    File file3 = configFile;
                    Intrinsics.checkNotNull(file3);
                    readConfig(file3);
                    appKey = str3;
                    sessionCompletion = function1;
                    setLogin(new Login(str, str2, (String) null, (String) null, (String) null, (Date) null, (Date) null, (String) null, (String) null, 0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, false, false, (User) null, 524284, (DefaultConstructorMarker) null));
                    innerLogin();
                }
            }
            if (uri2 != null) {
                readConfig(new File(uri2));
            } else {
                Context appContext2 = getAppContext();
                Intrinsics.checkNotNull(appContext2);
                InputStream openRawResource = appContext2.getResources().openRawResource(C2696R.C2702raw.config);
                Intrinsics.checkNotNullExpressionValue(openRawResource, "appContext!!.resources.o…RawResource(R.raw.config)");
                readConfig(openRawResource);
            }
            appKey = str3;
            sessionCompletion = function1;
            setLogin(new Login(str, str2, (String) null, (String) null, (String) null, (Date) null, (Date) null, (String) null, (String) null, 0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, false, false, (User) null, 524284, (DefaultConstructorMarker) null));
            innerLogin();
        } catch (Throwable th) {
            InnerLog.INSTANCE.mo33259e(TAG, "login file failed", th);
        }
    }

    private final void innerLogin() {
        if (!isInLoginRequest && getLogin() != null) {
            isInLoginRequest = true;
            token = null;
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, threadContext, (CoroutineStart) null, new SessionManager$innerLogin$1((Continuation<? super SessionManager$innerLogin$1>) null), 2, (Object) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        kotlin.p013io.CloseableKt.closeFinally(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void readConfig(java.io.InputStream r3) {
        /*
            r2 = this;
            java.nio.charset.Charset r0 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r3, r0)
            java.io.Reader r1 = (java.io.Reader) r1
            boolean r3 = r1 instanceof java.io.BufferedReader
            if (r3 == 0) goto L_0x0010
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x0018
        L_0x0010:
            java.io.BufferedReader r3 = new java.io.BufferedReader
            r0 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r1, r0)
            r1 = r3
        L_0x0018:
            java.io.Closeable r1 = (java.io.Closeable) r1
            r3 = 0
            r0 = r1
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x002b }
            java.io.Reader r0 = (java.io.Reader) r0     // Catch:{ all -> 0x002b }
            java.lang.String r0 = kotlin.p013io.TextStreamsKt.readText(r0)     // Catch:{ all -> 0x002b }
            kotlin.p013io.CloseableKt.closeFinally(r1, r3)
            r2.readConfig((java.lang.String) r0)
            return
        L_0x002b:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002d }
        L_0x002d:
            r0 = move-exception
            kotlin.p013io.CloseableKt.closeFinally(r1, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p012io.shipbook.shipbooksdk.Networking.SessionManager.readConfig(java.io.InputStream):void");
    }

    private final void readConfig(File file) {
        readConfig(FilesKt.readText$default(file, (Charset) null, 1, (Object) null));
    }

    private final void readConfig(String str) {
        ConfigResponse create = ConfigResponse.Companion.create(new JSONObject(str));
        if (!create.getExceptionReportDisabled()) {
            ExceptionManager.start$default(ExceptionManager.INSTANCE, false, 1, (Object) null);
        }
        if (!create.getEventLoggingDisabled()) {
            EventManager.INSTANCE.start();
        }
        LogManager.INSTANCE.config(create);
    }

    public final void registerUser(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "userId");
        user = new User(str, str2, str3, str4, str5, map);
        if (getLogin() != null) {
            Context appContext = getAppContext();
            Intrinsics.checkNotNull(appContext);
            LocalBroadcastManager.getInstance(appContext).sendBroadcast(new Intent(BroadcastNames.INSTANCE.getUSER_CHANGE()));
        }
    }

    public final void logout() {
        token = null;
        user = null;
        if (getLogin() != null) {
            Login login = getLogin();
            Intrinsics.checkNotNull(login);
            String appId = login.getAppId();
            Login login2 = getLogin();
            Intrinsics.checkNotNull(login2);
            setLogin(new Login(appId, login2.getAppKey(), (String) null, (String) null, (String) null, (Date) null, (Date) null, (String) null, (String) null, 0, (String) null, 0, (String) null, (String) null, (String) null, (String) null, false, false, (User) null, 524284, (DefaultConstructorMarker) null));
        }
        innerLogin();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0080 A[Catch:{ all -> 0x00bb, all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088 A[SYNTHETIC, Splitter:B:27:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refreshToken(kotlin.coroutines.Continuation<? super java.lang.Boolean> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof p012io.shipbook.shipbooksdk.Networking.SessionManager$refreshToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            io.shipbook.shipbooksdk.Networking.SessionManager$refreshToken$1 r0 = (p012io.shipbook.shipbooksdk.Networking.SessionManager$refreshToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            io.shipbook.shipbooksdk.Networking.SessionManager$refreshToken$1 r0 = new io.shipbook.shipbooksdk.Networking.SessionManager$refreshToken$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            io.shipbook.shipbooksdk.Networking.SessionManager r0 = (p012io.shipbook.shipbooksdk.Networking.SessionManager) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0078
        L_0x002f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = r11.getToken()
            if (r12 == 0) goto L_0x00d2
            java.lang.String r12 = appKey
            if (r12 != 0) goto L_0x0046
            goto L_0x00d2
        L_0x0046:
            io.shipbook.shipbooksdk.Models.RefreshToken r12 = new io.shipbook.shipbooksdk.Models.RefreshToken
            java.lang.String r2 = r11.getToken()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r5 = appKey
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r12.<init>(r2, r5)
            r11.setInLoginRequest(r3)
            r2 = 0
            r11.setToken(r2)
            io.shipbook.shipbooksdk.Networking.ConnectionClient r2 = p012io.shipbook.shipbooksdk.Networking.ConnectionClient.INSTANCE
            org.json.JSONObject r12 = r12.toJson()
            java.lang.String r12 = r12.toString()
            io.shipbook.shipbooksdk.Networking.HttpMethod r5 = p012io.shipbook.shipbooksdk.Networking.HttpMethod.POST
            r0.L$0 = r11
            r0.label = r3
            java.lang.String r6 = "auth/refreshSdkToken"
            java.lang.Object r12 = r2.request((java.lang.String) r6, (java.lang.String) r12, (p012io.shipbook.shipbooksdk.Networking.HttpMethod) r5, (kotlin.coroutines.Continuation<? super p012io.shipbook.shipbooksdk.Networking.ResponseData>) r0)
            if (r12 != r1) goto L_0x0077
            return r1
        L_0x0077:
            r0 = r11
        L_0x0078:
            io.shipbook.shipbooksdk.Networking.ResponseData r12 = (p012io.shipbook.shipbooksdk.Networking.ResponseData) r12
            boolean r1 = r12.getOk()     // Catch:{ all -> 0x00bb }
            if (r1 != 0) goto L_0x0088
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch:{ all -> 0x00bb }
            r0.setInLoginRequest(r4)
            return r12
        L_0x0088:
            org.json.JSONObject r1 = r12.getData()     // Catch:{ all -> 0x00bb }
            if (r1 != 0) goto L_0x00a2
            io.shipbook.shipbooksdk.InnerLog r5 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ all -> 0x00bb }
            java.lang.String r6 = TAG     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = "missing data"
            r8 = 0
            r9 = 4
            r10 = 0
            p012io.shipbook.shipbooksdk.InnerLog.e$default(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00bb }
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch:{ all -> 0x00bb }
            r0.setInLoginRequest(r4)
            return r12
        L_0x00a2:
            io.shipbook.shipbooksdk.Models.RefreshTokenResponse$Companion r1 = p012io.shipbook.shipbooksdk.Models.RefreshTokenResponse.Companion     // Catch:{ all -> 0x00bb }
            org.json.JSONObject r12 = r12.getData()     // Catch:{ all -> 0x00bb }
            io.shipbook.shipbooksdk.Models.RefreshTokenResponse r12 = r1.create(r12)     // Catch:{ all -> 0x00bb }
            java.lang.String r12 = r12.getToken()     // Catch:{ all -> 0x00bb }
            r0.setToken(r12)     // Catch:{ all -> 0x00bb }
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch:{ all -> 0x00bb }
            r0.setInLoginRequest(r4)
            return r12
        L_0x00bb:
            r12 = move-exception
            io.shipbook.shipbooksdk.InnerLog r1 = p012io.shipbook.shipbooksdk.InnerLog.INSTANCE     // Catch:{ all -> 0x00cd }
            java.lang.String r2 = TAG     // Catch:{ all -> 0x00cd }
            java.lang.String r3 = "There was a problem with the data"
            r1.mo33259e(r2, r3, r12)     // Catch:{ all -> 0x00cd }
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)     // Catch:{ all -> 0x00cd }
            r0.setInLoginRequest(r4)
            return r12
        L_0x00cd:
            r12 = move-exception
            r0.setInLoginRequest(r4)
            throw r12
        L_0x00d2:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p012io.shipbook.shipbooksdk.Networking.SessionManager.refreshToken(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
