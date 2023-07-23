package media.tiger.tigerbox.data.network;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.onboarding.ReauthenticationLoginHandler;
import media.tiger.tigerbox.usecase.accesstokenrepo.GetAccessTokenUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.RequestReAuthAndStoreTokenUseCase;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\u0010\u0010\"\u001a\u00020 2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\f\u0010#\u001a\u00020\u0015*\u00020$H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/AuthenticationInterceptor;", "Lokhttp3/Interceptor;", "reAuthenticationLoginHandler", "Lmedia/tiger/tigerbox/ui/onboarding/ReauthenticationLoginHandler;", "getAccessTokenUseCase", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/GetAccessTokenUseCase;", "requestReAuthAndStoreTokenUseCase", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RequestReAuthAndStoreTokenUseCase;", "removeAccountDataUseCase", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RemoveAccountDataUseCase;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Lmedia/tiger/tigerbox/ui/onboarding/ReauthenticationLoginHandler;Lmedia/tiger/tigerbox/usecase/accesstokenrepo/GetAccessTokenUseCase;Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RequestReAuthAndStoreTokenUseCase;Lmedia/tiger/tigerbox/usecase/accesstokenrepo/RemoveAccountDataUseCase;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "attemptReauthorizationAndUpdateRequest", "Lokhttp3/Request;", "request", "buildOriginalRequest", "originalRequest", "getRequestAccessToken", "", "hasNoAuthorizationTag", "", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isAccessTokenDifferent", "isBaseUrlRequest", "url", "isBasicAuth", "isNotAuthRequest", "rollbackToLogin", "", "updateRequestAuthorizationToken", "verifyAuthStatusForRequest", "isUnauthorized", "", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AuthenticationInterceptor.kt */
public final class AuthenticationInterceptor implements Interceptor {
    private static final String AUTH_HEADER = "Authorization";
    private static final String AUTH_HEADER_PREFIX = "Bearer";
    public static final String AUTH_HEADER_PREFIX_BASIC = "Basic";
    private static final String AUTH_URL_PART = "/oauth";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "AuthenticationInterceptor";
    public static final String NO_AUTHORIZATION_TAG = "NO_AUTHORIZATION_TAG";
    private final ConfigurationProperties configurationProperties;
    /* access modifiers changed from: private */
    public final GetAccessTokenUseCase getAccessTokenUseCase;
    private final ReauthenticationLoginHandler reAuthenticationLoginHandler;
    private final RemoveAccountDataUseCase removeAccountDataUseCase;
    /* access modifiers changed from: private */
    public final RequestReAuthAndStoreTokenUseCase requestReAuthAndStoreTokenUseCase;

    private final boolean isUnauthorized(int i) {
        return i == 401;
    }

    public AuthenticationInterceptor(ReauthenticationLoginHandler reauthenticationLoginHandler, GetAccessTokenUseCase getAccessTokenUseCase2, RequestReAuthAndStoreTokenUseCase requestReAuthAndStoreTokenUseCase2, RemoveAccountDataUseCase removeAccountDataUseCase2, ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(reauthenticationLoginHandler, "reAuthenticationLoginHandler");
        Intrinsics.checkNotNullParameter(getAccessTokenUseCase2, "getAccessTokenUseCase");
        Intrinsics.checkNotNullParameter(requestReAuthAndStoreTokenUseCase2, "requestReAuthAndStoreTokenUseCase");
        Intrinsics.checkNotNullParameter(removeAccountDataUseCase2, "removeAccountDataUseCase");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        this.reAuthenticationLoginHandler = reauthenticationLoginHandler;
        this.getAccessTokenUseCase = getAccessTokenUseCase2;
        this.requestReAuthAndStoreTokenUseCase = requestReAuthAndStoreTokenUseCase2;
        this.removeAccountDataUseCase = removeAccountDataUseCase2;
        this.configurationProperties = configurationProperties2;
    }

    @Metadata(mo33736d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/network/AuthenticationInterceptor$Companion;", "", "()V", "AUTH_HEADER", "", "AUTH_HEADER_PREFIX", "AUTH_HEADER_PREFIX_BASIC", "AUTH_URL_PART", "LOG_TAG", "NO_AUTHORIZATION_TAG", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AuthenticationInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Response intercept(Interceptor.Chain chain) {
        Interceptor.Chain chain2 = chain;
        Intrinsics.checkNotNullParameter(chain2, "chain");
        Request request = chain.request();
        if (hasNoAuthorizationTag(request)) {
            return chain2.proceed(buildOriginalRequest(request));
        }
        try {
            verifyAuthStatusForRequest(request);
        } catch (NoAuthenticationParamsException unused) {
            Timber.Forest.tag(LOG_TAG).mo50217e("NoAuthenticationParamsException exception we will try to re-authenticate", new Object[0]);
        } catch (Exception e) {
            Exception exc = e;
            Timber.Tree tag = Timber.Forest.tag(LOG_TAG);
            tag.mo50217e("Unknown exception " + exc + " we will try to re-authenticate", new Object[0]);
        }
        Response proceed = chain2.proceed(buildOriginalRequest(request));
        if (isUnauthorized(proceed.code()) && !isBasicAuth(request)) {
            Timber.Tree tag2 = Timber.Forest.tag(LOG_TAG);
            tag2.mo50217e("Request is unauthorized: " + request.url(), new Object[0]);
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            proceed.close();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Timber.Forest forest = Timber.Forest;
            forest.mo50217e("Will try to refresh token - caused by original request: " + request.url(), new Object[0]);
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), (CoroutineContext) null, (CoroutineStart) null, new AuthenticationInterceptor$intercept$1(request, proceed, this, objectRef, atomicBoolean, (Continuation<? super AuthenticationInterceptor$intercept$1>) null), 3, (Object) null);
            do {
            } while (atomicBoolean.get());
            if (((Request) objectRef.element) != null) {
                T t = objectRef.element;
                Intrinsics.checkNotNull(t);
                proceed = chain2.proceed((Request) t);
                if (isUnauthorized(proceed.code())) {
                    Timber.Forest.mo50217e("..........START - updatedRequestResponse IS STILL UNAUTHORIZED................", new Object[0]);
                    Timber.Forest forest2 = Timber.Forest;
                    forest2.mo50217e("updatedRequestResponse is: " + proceed, new Object[0]);
                    Timber.Forest forest3 = Timber.Forest;
                    forest3.mo50217e("updatedRequestResponse-headers: " + proceed.headers(), new Object[0]);
                    Timber.Forest forest4 = Timber.Forest;
                    forest4.mo50217e("updatedRequestResponse-body: " + proceed.body(), new Object[0]);
                    Timber.Forest forest5 = Timber.Forest;
                    forest5.mo50217e("NEW request: " + objectRef.element, new Object[0]);
                    Timber.Forest forest6 = Timber.Forest;
                    StringBuilder sb = new StringBuilder();
                    sb.append("NEW request body: ");
                    T t2 = objectRef.element;
                    Intrinsics.checkNotNull(t2);
                    sb.append(((Request) t2).body());
                    forest6.mo50217e(sb.toString(), new Object[0]);
                    Timber.Forest forest7 = Timber.Forest;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("NEW request access token: ");
                    T t3 = objectRef.element;
                    Intrinsics.checkNotNull(t3);
                    sb2.append(getRequestAccessToken((Request) t3));
                    forest7.mo50217e(sb2.toString(), new Object[0]);
                    Timber.Forest forest8 = Timber.Forest;
                    forest8.mo50217e("Current Access Token: " + this.getAccessTokenUseCase.invoke().getAccessToken(), new Object[0]);
                    Timber.Forest.mo50217e("..........END - updatedRequestResponse IS UNAUTHORIZED................", new Object[0]);
                    proceed.close();
                    Timber.Tree tag3 = Timber.Forest.tag(LOG_TAG);
                    tag3.mo50217e("Refreshing token failed. Request unauthorized " + request.url() + " accessToken " + this.getAccessTokenUseCase.invoke().getAccessToken(), new Object[0]);
                    rollbackToLogin();
                }
            }
        }
        return proceed;
    }

    private final void verifyAuthStatusForRequest(Request request) {
        if (!isBaseUrlRequest(request.url().toString()) && isNotAuthRequest(request.url().toString())) {
            if (this.getAccessTokenUseCase.invoke().getAccessToken().length() == 0) {
                throw new NoAuthenticationParamsException("Request invalid, no authentication params present.");
            }
        }
    }

    private final Request buildOriginalRequest(Request request) {
        if (hasNoAuthorizationTag(request)) {
            return request.newBuilder().removeHeader("Authorization").build();
        }
        if (isBaseUrlRequest(request.url().toString())) {
            return request.newBuilder().removeHeader("Authorization").build();
        }
        if (isBasicAuth(request)) {
            return request;
        }
        Request.Builder removeHeader = request.newBuilder().removeHeader("Authorization");
        return removeHeader.addHeader("Authorization", "Bearer " + this.getAccessTokenUseCase.invoke().getAccessToken()).build();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a4, code lost:
        return r6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized okhttp3.Request attemptReauthorizationAndUpdateRequest(okhttp3.Request r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            media.tiger.tigerbox.usecase.accesstokenrepo.GetAccessTokenUseCase r0 = r5.getAccessTokenUseCase     // Catch:{ all -> 0x00a5 }
            media.tiger.tigerbox.model.domain.AccessTokenDomain r0 = r0.invoke()     // Catch:{ all -> 0x00a5 }
            java.lang.String r0 = r0.getRefreshToken()     // Catch:{ all -> 0x00a5 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x00a5 }
            int r0 = r0.length()     // Catch:{ all -> 0x00a5 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 == 0) goto L_0x0038
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest     // Catch:{ all -> 0x00a5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Unable to re-authenticate - no refresh token, original url: "
            r1.append(r3)     // Catch:{ all -> 0x00a5 }
            okhttp3.HttpUrl r3 = r6.url()     // Catch:{ all -> 0x00a5 }
            r1.append(r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a5 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a5 }
            r0.mo50217e(r1, r2)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r5)
            return r6
        L_0x0038:
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest     // Catch:{ all -> 0x00a5 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r3.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r4 = "Refreshing token - but first check if request and token is different: "
            r3.append(r4)     // Catch:{ all -> 0x00a5 }
            boolean r4 = r5.isAccessTokenDifferent(r6)     // Catch:{ all -> 0x00a5 }
            r3.append(r4)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00a5 }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a5 }
            r0.mo50221i(r3, r4)     // Catch:{ all -> 0x00a5 }
            boolean r0 = r5.isAccessTokenDifferent(r6)     // Catch:{ all -> 0x00a5 }
            if (r0 == 0) goto L_0x0081
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = "AuthenticationInterceptor"
            timber.log.Timber$Tree r0 = r0.tag(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            r1.<init>()     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Token already refreshed "
            r1.append(r3)     // Catch:{ all -> 0x00a5 }
            okhttp3.HttpUrl r3 = r6.url()     // Catch:{ all -> 0x00a5 }
            r1.append(r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a5 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a5 }
            r0.mo50214d(r1, r2)     // Catch:{ all -> 0x00a5 }
            okhttp3.Request r6 = r5.updateRequestAuthorizationToken(r6)     // Catch:{ all -> 0x00a5 }
            goto L_0x00a3
        L_0x0081:
            media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$1 r0 = new media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$1     // Catch:{ all -> 0x00a5 }
            r2 = 0
            r0.<init>(r6, r5, r2)     // Catch:{ all -> 0x00a5 }
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0     // Catch:{ all -> 0x00a5 }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(r2, r0, r1, r2)     // Catch:{ all -> 0x00a5 }
            media.tiger.tigerbox.infrastructure.functional.Either r0 = (media.tiger.tigerbox.infrastructure.functional.Either) r0     // Catch:{ all -> 0x00a5 }
            media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$2 r1 = new media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$2     // Catch:{ all -> 0x00a5 }
            r1.<init>(r6)     // Catch:{ all -> 0x00a5 }
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1     // Catch:{ all -> 0x00a5 }
            media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$3 r2 = new media.tiger.tigerbox.data.network.AuthenticationInterceptor$attemptReauthorizationAndUpdateRequest$3     // Catch:{ all -> 0x00a5 }
            r2.<init>(r6, r5)     // Catch:{ all -> 0x00a5 }
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch:{ all -> 0x00a5 }
            java.lang.Object r6 = r0.fold(r1, r2)     // Catch:{ all -> 0x00a5 }
            okhttp3.Request r6 = (okhttp3.Request) r6     // Catch:{ all -> 0x00a5 }
        L_0x00a3:
            monitor-exit(r5)
            return r6
        L_0x00a5:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.network.AuthenticationInterceptor.attemptReauthorizationAndUpdateRequest(okhttp3.Request):okhttp3.Request");
    }

    /* access modifiers changed from: private */
    public final void rollbackToLogin() {
        Timber.Forest.tag(LOG_TAG).mo50217e("Rollback to login screen...............", new Object[0]);
        Timber.Forest.tag(LOG_TAG).mo50221i("Refresh token unsuccessful", new Object[0]);
        Timber.Forest.tag(LOG_TAG).mo50221i("show login", new Object[0]);
        this.reAuthenticationLoginHandler.showLogin();
    }

    /* access modifiers changed from: private */
    public final Request updateRequestAuthorizationToken(Request request) {
        Timber.Forest forest = Timber.Forest;
        forest.mo50221i("updateRequestAuthorizationToken " + request.url() + " token: " + this.getAccessTokenUseCase.invoke().getAccessToken(), new Object[0]);
        Request.Builder removeHeader = request.newBuilder().removeHeader("Authorization");
        return removeHeader.addHeader("Authorization", "Bearer " + this.getAccessTokenUseCase.invoke().getAccessToken()).build();
    }

    /* access modifiers changed from: private */
    public final String getRequestAccessToken(Request request) {
        String str = request.headers().get("Authorization");
        if (str == null) {
            str = "";
        }
        return StringsKt.substringAfter$default(str, "Bearer ", (String) null, 2, (Object) null);
    }

    private final boolean isAccessTokenDifferent(Request request) {
        String accessToken = this.getAccessTokenUseCase.invoke().getAccessToken();
        String str = request.headers().get("Authorization");
        if (str == null) {
            str = "";
        }
        String substringAfter$default = StringsKt.substringAfter$default(str, "Bearer ", (String) null, 2, (Object) null);
        if (accessToken.length() > 0) {
            return (substringAfter$default.length() > 0) && !Intrinsics.areEqual((Object) substringAfter$default, (Object) accessToken);
        }
    }

    private final boolean isNotAuthRequest(String str) {
        return !StringsKt.contains$default((CharSequence) str, (CharSequence) AUTH_URL_PART, false, 2, (Object) null);
    }

    private final boolean hasNoAuthorizationTag(Request request) {
        return Intrinsics.areEqual(request.tag(String.class), (Object) NO_AUTHORIZATION_TAG);
    }

    private final boolean isBaseUrlRequest(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.configurationProperties.getProperty("rest.url"));
        sb.append('/');
        return Intrinsics.areEqual((Object) str, (Object) sb.toString()) || Intrinsics.areEqual((Object) str, (Object) this.configurationProperties.getProperty("rest.url"));
    }

    private final boolean isBasicAuth(Request request) {
        String header = request.header("Authorization");
        if (header == null) {
            header = "";
        }
        return StringsKt.contains$default((CharSequence) header, (CharSequence) AUTH_HEADER_PREFIX_BASIC, false, 2, (Object) null);
    }
}
