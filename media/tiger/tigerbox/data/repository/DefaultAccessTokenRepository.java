package media.tiger.tigerbox.data.repository;

import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.DatabaseMigrationService;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.infrastructure.functional.Either;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.model.domain.AccessTokenDomain;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.usecase.accesstokenrepo.GetTokenParameters;
import timber.log.Timber;

@Singleton
@Metadata(mo33736d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0016\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0%H\u0016J\u0011\u0010&\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010'J%\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f0\u00172\u0006\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010+J\u001d\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f0\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0010\u0010-\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/DefaultAccessTokenRepository;", "Lmedia/tiger/tigerbox/data/repository/AccessTokenRepository;", "databaseMigrationService", "Lmedia/tiger/tigerbox/DatabaseMigrationService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "tigerBoxDataBase", "Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Lmedia/tiger/tigerbox/DatabaseMigrationService;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "_accessToken", "Ljava/util/concurrent/atomic/AtomicReference;", "Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "kotlin.jvm.PlatformType", "_didLoadDbData", "", "_loadDbInProgress", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadAccessInProgress", "previousReauthenticationEither", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "previousReauthenticationTime", "", "reAuthenticationInProgress", "shutdownThreadHook", "Ljava/lang/Thread;", "tokens", "getTokens", "()Lmedia/tiger/tigerbox/model/domain/AccessTokenDomain;", "updatingDatabaseInProgress", "loadInitialDatabaseData", "", "onDone", "Lkotlin/Function0;", "removeAccessToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAccessTokens", "params", "Lmedia/tiger/tigerbox/usecase/accesstokenrepo/GetTokenParameters;", "(Lmedia/tiger/tigerbox/usecase/accesstokenrepo/GetTokenParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestReAuthentication", "updateTokens", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AccessTokenRepository.kt */
public class DefaultAccessTokenRepository implements AccessTokenRepository {
    /* access modifiers changed from: private */
    public AtomicReference<AccessTokenDomain> _accessToken = new AtomicReference<>(new AccessTokenDomain());
    private boolean _didLoadDbData;
    /* access modifiers changed from: private */
    public AtomicBoolean _loadDbInProgress = new AtomicBoolean(false);
    private final ConfigurationProperties configurationProperties;
    private final DatabaseMigrationService databaseMigrationService;
    /* access modifiers changed from: private */
    public final AtomicBoolean loadAccessInProgress = new AtomicBoolean(true);
    private Either<? extends Failure, AccessTokenDomain> previousReauthenticationEither;
    private long previousReauthenticationTime;
    private AtomicBoolean reAuthenticationInProgress = new AtomicBoolean(false);
    private Thread shutdownThreadHook;
    /* access modifiers changed from: private */
    public final TigerBoxDatabase tigerBoxDataBase;
    private final TigerBoxWebService tigerBoxWebService;
    private final TimeService timeService;
    /* access modifiers changed from: private */
    public AtomicBoolean updatingDatabaseInProgress = new AtomicBoolean(false);

    public Object removeAccessToken(Continuation<? super Unit> continuation) {
        return removeAccessToken$suspendImpl(this, continuation);
    }

    public Object requestAccessTokens(GetTokenParameters getTokenParameters, Continuation<? super Either<? extends Failure, AccessTokenDomain>> continuation) {
        return requestAccessTokens$suspendImpl(this, getTokenParameters, continuation);
    }

    public Object requestReAuthentication(Continuation<? super Either<? extends Failure, AccessTokenDomain>> continuation) {
        return requestReAuthentication$suspendImpl(this, continuation);
    }

    @Inject
    public DefaultAccessTokenRepository(DatabaseMigrationService databaseMigrationService2, TimeService timeService2, TigerBoxWebService tigerBoxWebService2, TigerBoxDatabase tigerBoxDatabase, ConfigurationProperties configurationProperties2) {
        Intrinsics.checkNotNullParameter(databaseMigrationService2, "databaseMigrationService");
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        Intrinsics.checkNotNullParameter(tigerBoxWebService2, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDataBase");
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        this.databaseMigrationService = databaseMigrationService2;
        this.timeService = timeService2;
        this.tigerBoxWebService = tigerBoxWebService2;
        this.tigerBoxDataBase = tigerBoxDatabase;
        this.configurationProperties = configurationProperties2;
        loadInitialDatabaseData(new Function0<Unit>(this) {
            final /* synthetic */ DefaultAccessTokenRepository this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.loadAccessInProgress.set(false);
            }
        });
        do {
        } while (this.loadAccessInProgress.get());
    }

    public void loadInitialDatabaseData(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onDone");
        if (!this._didLoadDbData) {
            this._didLoadDbData = true;
            this._loadDbInProgress.set(true);
            Log.d("TigerBoxUserRepository", "Doing initial read of tokens info from database. We should only see this once.");
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new DefaultAccessTokenRepository$loadInitialDatabaseData$1(this, function0, (Continuation<? super DefaultAccessTokenRepository$loadInitialDatabaseData$1>) null), 3, (Object) null);
        }
    }

    public AccessTokenDomain getTokens() {
        AccessTokenDomain accessTokenDomain = this._accessToken.get();
        Intrinsics.checkNotNullExpressionValue(accessTokenDomain, "_accessToken.get()");
        return accessTokenDomain;
    }

    /* access modifiers changed from: private */
    public final void updateTokens(AccessTokenDomain accessTokenDomain) {
        this._accessToken.set(accessTokenDomain);
        if (this.shutdownThreadHook == null) {
            Thread defaultAccessTokenRepository$updateTokens$1 = new DefaultAccessTokenRepository$updateTokens$1(this);
            this.shutdownThreadHook = defaultAccessTokenRepository$updateTokens$1;
            try {
                Runtime.getRuntime().addShutdownHook(defaultAccessTokenRepository$updateTokens$1);
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("updateTokens addShutdownHook exception " + e, new Object[0]);
            }
        }
        this.updatingDatabaseInProgress.set(true);
        Timber.Forest.mo50217e("Update tokens database", new Object[0]);
        this.tigerBoxDataBase.accessTokenDao().deleteAllAccessToken();
        this.tigerBoxDataBase.accessTokenDao().insertAccessToken(accessTokenDomain);
        this.updatingDatabaseInProgress.set(false);
        Thread thread = this.shutdownThreadHook;
        if (thread != null) {
            Runtime.getRuntime().removeShutdownHook(thread);
        }
        this.shutdownThreadHook = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object requestAccessTokens$suspendImpl(media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository r9, media.tiger.tigerbox.usecase.accesstokenrepo.GetTokenParameters r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestAccessTokens$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestAccessTokens$1 r0 = (media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestAccessTokens$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestAccessTokens$1 r0 = new media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestAccessTokens$1
            r0.<init>(r9, r11)
        L_0x0019:
            r7 = r0
            java.lang.Object r11 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 != r2) goto L_0x0035
            java.lang.Object r9 = r7.L$1
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r9 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r9
            java.lang.Object r10 = r7.L$0
            media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository r10 = (media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r1 = r9
            r9 = r10
            goto L_0x008d
        L_0x0035:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r11)
            timber.log.Timber$Forest r11 = timber.log.Timber.Forest
            java.lang.String r1 = "DefaultAccessTokenRepository"
            timber.log.Timber$Tree r11 = r11.tag(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "requestAccessTokens: ["
            r1.append(r3)
            r1.append(r10)
            r3 = 93
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r11.mo50214d(r1, r3)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r11 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r1 = r9.tigerBoxWebService
            java.lang.String r3 = r10.getAuthHeader()
            java.lang.String r4 = r10.getUsername()
            java.lang.String r5 = r10.getPassword()
            java.lang.String r6 = r10.getDevId()
            r7.L$0 = r9
            r7.L$1 = r11
            r7.label = r2
            java.lang.String r10 = "password"
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r10
            java.lang.Object r10 = r1.getToken(r2, r3, r4, r5, r6, r7)
            if (r10 != r0) goto L_0x008b
            return r0
        L_0x008b:
            r1 = r11
            r11 = r10
        L_0x008d:
            r2 = r11
            media.tiger.tigerbox.data.network.ApiResponse r2 = (media.tiger.tigerbox.data.network.ApiResponse) r2
            media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestAccessTokens$2 r10 = new media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestAccessTokens$2
            r10.<init>(r9)
            r3 = r10
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            media.tiger.tigerbox.model.domain.AccessTokenDomain r4 = new media.tiger.tigerbox.model.domain.AccessTokenDomain
            r4.<init>()
            media.tiger.tigerbox.infrastructure.exception.LoginFailure$BearerTokenNotSuccessful r9 = media.tiger.tigerbox.infrastructure.exception.LoginFailure.BearerTokenNotSuccessful.INSTANCE
            r5 = r9
            media.tiger.tigerbox.infrastructure.exception.Failure r5 = (media.tiger.tigerbox.infrastructure.exception.Failure) r5
            r6 = 0
            r7 = 16
            r8 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r9 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository.requestAccessTokens$suspendImpl(media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository, media.tiger.tigerbox.usecase.accesstokenrepo.GetTokenParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object requestReAuthentication$suspendImpl(media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository r13, kotlin.coroutines.Continuation r14) {
        /*
            boolean r0 = r14 instanceof media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestReAuthentication$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestReAuthentication$1 r0 = (media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestReAuthentication$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestReAuthentication$1 r0 = new media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestReAuthentication$1
            r0.<init>(r13, r14)
        L_0x0019:
            r6 = r0
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            r9 = 0
            if (r1 == 0) goto L_0x0047
            if (r1 != r2) goto L_0x003f
            java.lang.Object r13 = r6.L$2
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r13 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r13
            java.lang.Object r0 = r6.L$1
            media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository r0 = (media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository) r0
            java.lang.Object r1 = r6.L$0
            media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository r1 = (media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository) r1
            kotlin.ResultKt.throwOnFailure(r14)
            r11 = r0
            r0 = r13
            r13 = r11
            r12 = r1
            r1 = r14
            r14 = r12
            goto L_0x0106
        L_0x003f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r14)
        L_0x004a:
            java.util.concurrent.atomic.AtomicBoolean r14 = r13.reAuthenticationInProgress
            boolean r14 = r14.get()
            if (r14 == 0) goto L_0x005c
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest
            java.lang.Object[] r1 = new java.lang.Object[r9]
            java.lang.String r3 = "We are already trying to re-authenticate - waiting...."
            r14.mo50221i(r3, r1)
            goto L_0x004a
        L_0x005c:
            media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.domain.AccessTokenDomain> r14 = r13.previousReauthenticationEither
            if (r14 == 0) goto L_0x007f
            boolean r1 = r14.isRight()
            if (r1 == 0) goto L_0x007f
            media.tiger.tigerbox.services.interfaces.TimeService r1 = r13.timeService
            long r3 = r1.getCurrentSystemTimeMillis()
            long r7 = r13.previousReauthenticationTime
            long r3 = r3 - r7
            r7 = 5000(0x1388, double:2.4703E-320)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x007f
            timber.log.Timber$Forest r13 = timber.log.Timber.Forest
            java.lang.Object[] r0 = new java.lang.Object[r9]
            java.lang.String r1 = "We just reAuthenticated - so we are returning the same value"
            r13.mo50221i(r1, r0)
            return r14
        L_0x007f:
            media.tiger.tigerbox.model.domain.AccessTokenDomain r14 = r13.getTokens()
            java.lang.String r3 = r14.getRefreshToken()
            timber.log.Timber$Forest r14 = timber.log.Timber.Forest
            java.lang.String r1 = "DefaultAccessTokenRepository"
            timber.log.Timber$Tree r14 = r14.tag(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "Attempt to refresh access token with refresh token: ["
            r1.append(r4)
            r1.append(r3)
            r4 = 93
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            java.lang.Object[] r4 = new java.lang.Object[r9]
            r14.mo50214d(r1, r4)
            r14 = r3
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            int r14 = r14.length()
            if (r14 != 0) goto L_0x00b5
            r14 = 1
            goto L_0x00b6
        L_0x00b5:
            r14 = 0
        L_0x00b6:
            if (r14 == 0) goto L_0x00c9
            timber.log.Timber$Forest r13 = timber.log.Timber.Forest
            java.lang.Object[] r14 = new java.lang.Object[r9]
            java.lang.String r0 = "Attempt to refresh access token with empty refresh token."
            r13.mo50217e(r0, r14)
            media.tiger.tigerbox.infrastructure.functional.Either$Left r13 = new media.tiger.tigerbox.infrastructure.functional.Either$Left
            media.tiger.tigerbox.infrastructure.exception.LoginFailure$BearerTokenNotSuccessful r14 = media.tiger.tigerbox.infrastructure.exception.LoginFailure.BearerTokenNotSuccessful.INSTANCE
            r13.<init>(r14)
            return r13
        L_0x00c9:
            java.util.concurrent.atomic.AtomicBoolean r14 = r13.reAuthenticationInProgress
            r14.set(r2)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r14 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r1 = r13.tigerBoxWebService
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Basic "
            r4.append(r5)
            media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties r5 = r13.configurationProperties
            java.lang.String r7 = "auth.header"
            java.lang.String r5 = r5.getProperty(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 0
            r7 = 0
            r8 = 12
            r10 = 0
            r6.L$0 = r13
            r6.L$1 = r13
            r6.L$2 = r14
            r6.label = r2
            r2 = r4
            r4 = r5
            r5 = r7
            r7 = r8
            r8 = r10
            java.lang.Object r1 = media.tiger.tigerbox.data.network.TigerBoxWebService.DefaultImpls.getRefreshToken$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r1 != r0) goto L_0x0104
            return r0
        L_0x0104:
            r0 = r14
            r14 = r13
        L_0x0106:
            media.tiger.tigerbox.data.network.ApiResponse r1 = (media.tiger.tigerbox.data.network.ApiResponse) r1
            media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestReAuthentication$3 r2 = new media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository$requestReAuthentication$3
            r2.<init>(r14)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            media.tiger.tigerbox.model.domain.AccessTokenDomain r3 = new media.tiger.tigerbox.model.domain.AccessTokenDomain
            r3.<init>()
            media.tiger.tigerbox.infrastructure.exception.LoginFailure$BearerTokenNotSuccessful r4 = media.tiger.tigerbox.infrastructure.exception.LoginFailure.BearerTokenNotSuccessful.INSTANCE
            media.tiger.tigerbox.infrastructure.exception.Failure r4 = (media.tiger.tigerbox.infrastructure.exception.Failure) r4
            r5 = 0
            r6 = 16
            r7 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r0 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r0, r1, r2, r3, r4, r5, r6, r7)
            media.tiger.tigerbox.services.interfaces.TimeService r1 = r14.timeService
            long r1 = r1.getCurrentSystemTimeMillis()
            r14.previousReauthenticationTime = r1
            java.util.concurrent.atomic.AtomicBoolean r1 = r14.reAuthenticationInProgress
            r1.set(r9)
            r13.previousReauthenticationEither = r0
            media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.domain.AccessTokenDomain> r13 = r14.previousReauthenticationEither
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository.requestReAuthentication$suspendImpl(media.tiger.tigerbox.data.repository.DefaultAccessTokenRepository, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object removeAccessToken$suspendImpl(DefaultAccessTokenRepository defaultAccessTokenRepository, Continuation continuation) {
        defaultAccessTokenRepository.tigerBoxDataBase.accessTokenDao().deleteAllAccessToken();
        defaultAccessTokenRepository._accessToken.set(new AccessTokenDomain());
        return Unit.INSTANCE;
    }
}
