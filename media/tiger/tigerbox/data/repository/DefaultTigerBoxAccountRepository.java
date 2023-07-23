package media.tiger.tigerbox.data.repository;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
import media.tiger.tigerbox.model.domain.TigerBoxAccountDomain;
import media.tiger.tigerbox.model.domain.TigerBoxProfileDomain;
import media.tiger.tigerbox.model.domain.TigerBoxUserDomain;
import media.tiger.tigerbox.p016ui.onboarding.ReauthenticationLoginHandler;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000203H\u0002J\u001d\u00105\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00110-H@ø\u0001\u0000¢\u0006\u0002\u00106J#\u00107\u001a\u0014\u0012\u0004\u0012\u00020.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d000-H@ø\u0001\u0000¢\u0006\u0002\u00106J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020\u001d00H\u0016J\b\u00109\u001a\u00020:H\u0016J\u0016\u0010;\u001a\u0002032\f\u0010<\u001a\b\u0012\u0004\u0012\u0002030=H\u0016J\u0010\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020!H\u0002J\u0010\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020'H\u0016J\u0011\u0010B\u001a\u000203H@ø\u0001\u0000¢\u0006\u0002\u00106J%\u0010C\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020D0-2\u0006\u0010E\u001a\u00020FH@ø\u0001\u0000¢\u0006\u0002\u0010GJ0\u0010H\u001a\u0002032&\u0010I\u001a\"\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d000-\u0012\u0004\u0012\u000203\u0018\u00010JH\u0016J\u0010\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020!H\u0016J\u0010\u0010L\u001a\u0002032\u0006\u0010A\u001a\u00020'H\u0016J\b\u0010M\u001a\u000203H\u0002J\u0010\u0010N\u001a\u0002032\u0006\u0010O\u001a\u00020\u0011H\u0002R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118B@BX\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u0012\u0012\u0004\u0012\u00020'0&j\b\u0012\u0004\u0012\u00020'`(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0011\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\"\u0010/\u001a\u0016\u0012\u0004\u0012\u00020.\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d00\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006P"}, mo33737d2 = {"Lmedia/tiger/tigerbox/data/repository/DefaultTigerBoxAccountRepository;", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "databaseMigrationService", "Lmedia/tiger/tigerbox/DatabaseMigrationService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "tigerBoxWebService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "tigerBoxDataBase", "Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "reauthenticationLoginHandler", "Lmedia/tiger/tigerbox/ui/onboarding/ReauthenticationLoginHandler;", "(Lmedia/tiger/tigerbox/DatabaseMigrationService;Lmedia/tiger/tigerbox/services/interfaces/TimeService;Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/ui/onboarding/ReauthenticationLoginHandler;)V", "_accountInfo", "Ljava/util/concurrent/atomic/AtomicReference;", "Lmedia/tiger/tigerbox/model/domain/TigerBoxAccountDomain;", "kotlin.jvm.PlatformType", "_didLoadDbData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "_loadDbInProgress", "newValue", "accountInfo", "getAccountInfo", "()Lmedia/tiger/tigerbox/model/domain/TigerBoxAccountDomain;", "setAccountInfo", "(Lmedia/tiger/tigerbox/model/domain/TigerBoxAccountDomain;)V", "activeProfile", "Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "getActiveProfile", "()Lmedia/tiger/tigerbox/model/domain/TigerBoxProfileDomain;", "currentActiveProfileId", "", "lastGetMeTimeInMillis", "", "lastProfilesTimeInMillis", "listeners", "Ljava/util/ArrayList;", "Lmedia/tiger/tigerbox/data/repository/ProfileChangeListener;", "Lkotlin/collections/ArrayList;", "loadAccountInProgress", "shutdownThreadHook", "Ljava/lang/Thread;", "tigerBoxAccountResult", "Lmedia/tiger/tigerbox/infrastructure/functional/Either;", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "tigerBoxProfilesResult", "", "updatingDatabaseInProgress", "deleteAllProfilesFromDatabase", "", "deleteAllUsersFromDatabase", "fetchAccountInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchProfilesInfo", "getTigerBoxProfiles", "getTigerBoxUser", "Lmedia/tiger/tigerbox/model/domain/TigerBoxUserDomain;", "loadInitialDatabaseData", "onDone", "Lkotlin/Function0;", "notifyAllDidChangeProfile", "profileId", "registerProfileChangeListener", "listener", "removeTigerBoxAccountInfo", "requestDeviceInformation", "Lmedia/tiger/tigerbox/model/dto/DeviceInformation;", "deviceIdentifier", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestUpdatedProfilesInfoFromServer", "onResult", "Lkotlin/Function1;", "setActiveProfile", "unregisterProfileChangeListener", "updateActiveProfileForCurrentDevice", "updateDatabaseWithAccountInfo", "info", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: TigerBoxUserRepository.kt */
public final class DefaultTigerBoxAccountRepository implements TigerBoxAccountRepository {
    /* access modifiers changed from: private */
    public AtomicReference<TigerBoxAccountDomain> _accountInfo = new AtomicReference<>(new TigerBoxAccountDomain());
    /* access modifiers changed from: private */
    public AtomicBoolean _didLoadDbData = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public AtomicBoolean _loadDbInProgress = new AtomicBoolean(false);
    private int currentActiveProfileId = -1;
    private final DatabaseMigrationService databaseMigrationService;
    private long lastGetMeTimeInMillis;
    private long lastProfilesTimeInMillis;
    /* access modifiers changed from: private */
    public ArrayList<ProfileChangeListener> listeners = new ArrayList<>();
    /* access modifiers changed from: private */
    public final AtomicBoolean loadAccountInProgress = new AtomicBoolean(true);
    private final ReauthenticationLoginHandler reauthenticationLoginHandler;
    /* access modifiers changed from: private */
    public Thread shutdownThreadHook;
    /* access modifiers changed from: private */
    public final StorageService storageService;
    private Either<? extends Failure, TigerBoxAccountDomain> tigerBoxAccountResult;
    /* access modifiers changed from: private */
    public final TigerBoxDatabase tigerBoxDataBase;
    private Either<? extends Failure, ? extends List<TigerBoxProfileDomain>> tigerBoxProfilesResult;
    private final TigerBoxWebService tigerBoxWebService;
    private final TimeService timeService;
    /* access modifiers changed from: private */
    public AtomicBoolean updatingDatabaseInProgress = new AtomicBoolean(false);

    @Inject
    public DefaultTigerBoxAccountRepository(DatabaseMigrationService databaseMigrationService2, TimeService timeService2, TigerBoxWebService tigerBoxWebService2, TigerBoxDatabase tigerBoxDatabase, StorageService storageService2, ReauthenticationLoginHandler reauthenticationLoginHandler2) {
        Intrinsics.checkNotNullParameter(databaseMigrationService2, "databaseMigrationService");
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        Intrinsics.checkNotNullParameter(tigerBoxWebService2, "tigerBoxWebService");
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDataBase");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(reauthenticationLoginHandler2, "reauthenticationLoginHandler");
        this.databaseMigrationService = databaseMigrationService2;
        this.timeService = timeService2;
        this.tigerBoxWebService = tigerBoxWebService2;
        this.tigerBoxDataBase = tigerBoxDatabase;
        this.storageService = storageService2;
        this.reauthenticationLoginHandler = reauthenticationLoginHandler2;
        loadInitialDatabaseData(new Function0<Unit>(this) {
            final /* synthetic */ DefaultTigerBoxAccountRepository this$0;

            {
                this.this$0 = r1;
            }

            public final void invoke() {
                this.this$0.loadAccountInProgress.set(false);
            }
        });
        do {
        } while (this.loadAccountInProgress.get());
    }

    public void loadInitialDatabaseData(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onDone");
        if (!this._didLoadDbData.get()) {
            Log.d("TigerBoxUserRepository", "Doing initial read of account info from database. We should only see this once.");
            this._loadDbInProgress.set(true);
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new DefaultTigerBoxAccountRepository$loadInitialDatabaseData$1(this, function0, (Continuation<? super DefaultTigerBoxAccountRepository$loadInitialDatabaseData$1>) null), 3, (Object) null);
        }
    }

    private final void updateDatabaseWithAccountInfo(TigerBoxAccountDomain tigerBoxAccountDomain) {
        if (this.shutdownThreadHook == null) {
            Thread defaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$1 = new DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$1(this);
            this.shutdownThreadHook = defaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$1;
            try {
                Runtime.getRuntime().addShutdownHook(defaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$1);
            } catch (Exception e) {
                Timber.Forest forest = Timber.Forest;
                forest.mo50217e("updateDatabaseWithAccountInfo addShutdownHook exception " + e, new Object[0]);
            }
        }
        this.updatingDatabaseInProgress.set(true);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$3(tigerBoxAccountDomain, this, (Continuation<? super DefaultTigerBoxAccountRepository$updateDatabaseWithAccountInfo$3>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final TigerBoxAccountDomain getAccountInfo() {
        TigerBoxAccountDomain tigerBoxAccountDomain = this._accountInfo.get();
        Intrinsics.checkNotNullExpressionValue(tigerBoxAccountDomain, "_accountInfo.get()");
        return tigerBoxAccountDomain;
    }

    private final void setAccountInfo(TigerBoxAccountDomain tigerBoxAccountDomain) {
        this._accountInfo.set(tigerBoxAccountDomain);
        updateDatabaseWithAccountInfo(tigerBoxAccountDomain);
    }

    public TigerBoxUserDomain getTigerBoxUser() {
        if (getAccountInfo().getUser().getAccountId() == -1) {
            Timber.Forest forest = Timber.Forest;
            forest.mo50221i("getTigerBoxUser accountInfo user accountId invalid - we have no account - show login didLoadDbData " + this._didLoadDbData.get() + " accountInfo " + getAccountInfo(), new Object[0]);
            this.reauthenticationLoginHandler.showLogin();
        }
        return getAccountInfo().getUser();
    }

    public List<TigerBoxProfileDomain> getTigerBoxProfiles() {
        if (getAccountInfo().getProfiles().isEmpty()) {
            Timber.Forest.mo50221i("getTigerBoxProfiles - profiles information is empty - will update from server, for now, returning an empty list", new Object[0]);
            requestUpdatedProfilesInfoFromServer(DefaultTigerBoxAccountRepository$getTigerBoxProfiles$1.INSTANCE);
        }
        return getAccountInfo().getProfiles();
    }

    public void setActiveProfile(int i) {
        TigerBoxAccountDomain accountInfo = getAccountInfo();
        setAccountInfo(TigerBoxAccountDomain.copy$default(accountInfo, TigerBoxUserDomain.copy$default(accountInfo.getUser(), 0, 0, i, (String) null, (String) null, 27, (Object) null), (List) null, 2, (Object) null));
        notifyAllDidChangeProfile(i);
    }

    private final void notifyAllDidChangeProfile(int i) {
        if (this.currentActiveProfileId != i) {
            this.currentActiveProfileId = i;
            Iterator<ProfileChangeListener> it = this.listeners.iterator();
            while (it.hasNext()) {
                it.next().didChangeProfile(i);
            }
        }
    }

    public TigerBoxProfileDomain getActiveProfile() {
        List<TigerBoxProfileDomain> tigerBoxProfiles = getTigerBoxProfiles();
        for (TigerBoxProfileDomain next : tigerBoxProfiles) {
            if (next.getId() == getAccountInfo().getUser().getActiveProfileId()) {
                return next;
            }
        }
        TigerBoxProfileDomain tigerBoxProfileDomain = (TigerBoxProfileDomain) CollectionsKt.firstOrNull(tigerBoxProfiles);
        if (tigerBoxProfileDomain != null) {
            return tigerBoxProfileDomain;
        }
        Timber.Forest.mo50221i("Returning default profile id, as no active profile id was found.", new Object[0]);
        return TigerBoxProfileDomain.copy$default(new TigerBoxProfileDomain(), getTigerBoxUser().getProfileId(), (String) null, 0, (String) null, (String) null, (String) null, (String) null, 126, (Object) null);
    }

    public void registerProfileChangeListener(ProfileChangeListener profileChangeListener) {
        Intrinsics.checkNotNullParameter(profileChangeListener, "listener");
        if (!this.listeners.contains(profileChangeListener)) {
            this.listeners.add(profileChangeListener);
        }
    }

    public void unregisterProfileChangeListener(ProfileChangeListener profileChangeListener) {
        Intrinsics.checkNotNullParameter(profileChangeListener, "listener");
        this.listeners.remove(profileChangeListener);
    }

    public Object removeTigerBoxAccountInfo(Continuation<? super Unit> continuation) {
        Timber.Forest.mo50217e("removeTigerBoxAccountInfo", new Object[0]);
        deleteAllUsersFromDatabase();
        deleteAllProfilesFromDatabase();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void deleteAllUsersFromDatabase() {
        Timber.Forest.mo50217e("deleteAllUsersFromDatabase", new Object[0]);
        this.tigerBoxDataBase.tigerBoxUserDao().deleteAllUsers();
    }

    /* access modifiers changed from: private */
    public final void deleteAllProfilesFromDatabase() {
        Timber.Forest.mo50217e("deleteAllProfilesFromDatabase", new Object[0]);
        this.tigerBoxDataBase.tigerBoxProfileDao().deleteAllProfiles();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object fetchAccountInfo(kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.domain.TigerBoxAccountDomain>> r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$1 r2 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$1 r2 = new media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x0058
            if (r4 == r6) goto L_0x0047
            if (r4 != r5) goto L_0x003f
            java.lang.Object r3 = r2.L$2
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r3 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository) r3
            java.lang.Object r4 = r2.L$1
            media.tiger.tigerbox.infrastructure.functional.Either r4 = (media.tiger.tigerbox.infrastructure.functional.Either) r4
            java.lang.Object r2 = r2.L$0
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r2 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0129
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            java.lang.Object r4 = r2.L$2
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r4 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r4
            java.lang.Object r6 = r2.L$1
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r6 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository) r6
            java.lang.Object r8 = r2.L$0
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r8 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository) r8
            kotlin.ResultKt.throwOnFailure(r1)
        L_0x0056:
            r9 = r4
            goto L_0x00c5
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r1)
        L_0x005b:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0._loadDbInProgress
            boolean r1 = r1.get()
            if (r1 != 0) goto L_0x005b
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "fetchAccountInfo "
            r4.append(r8)
            media.tiger.tigerbox.services.interfaces.TimeService r8 = r0.timeService
            long r8 = r8.getCurrentSystemTimeMillis()
            long r10 = r0.lastGetMeTimeInMillis
            long r8 = r8 - r10
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r1.mo50221i(r4, r8)
            media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.domain.TigerBoxAccountDomain> r1 = r0.tigerBoxAccountResult
            if (r1 == 0) goto L_0x00a7
            media.tiger.tigerbox.services.interfaces.TimeService r4 = r0.timeService
            long r8 = r4.getCurrentSystemTimeMillis()
            long r10 = r0.lastGetMeTimeInMillis
            long r8 = r8 - r10
            r10 = 1500(0x5dc, double:7.41E-321)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x00a7
            boolean r4 = r1.isRight()
            if (r4 == 0) goto L_0x00a7
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.Object[] r3 = new java.lang.Object[r7]
            java.lang.String r4 = "fetchAccountInfo - WE RETURN THE SAME RESULT - AS WE ALREADY READ THIS IN THE PAST SECOND"
            r2.mo50221i(r4, r3)
            return r1
        L_0x00a7:
            media.tiger.tigerbox.services.interfaces.TimeService r1 = r0.timeService
            long r8 = r1.getCurrentSystemTimeMillis()
            r0.lastGetMeTimeInMillis = r8
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r4 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r1 = r0.tigerBoxWebService
            r2.L$0 = r0
            r2.L$1 = r0
            r2.L$2 = r4
            r2.label = r6
            java.lang.Object r1 = r1.getLoggedUserInfo(r2)
            if (r1 != r3) goto L_0x00c2
            return r3
        L_0x00c2:
            r6 = r0
            r8 = r6
            goto L_0x0056
        L_0x00c5:
            r10 = r1
            media.tiger.tigerbox.data.network.ApiResponse r10 = (media.tiger.tigerbox.data.network.ApiResponse) r10
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$3 r1 = new media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$3
            r1.<init>(r8)
            r11 = r1
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            media.tiger.tigerbox.model.domain.TigerBoxAccountDomain r12 = new media.tiger.tigerbox.model.domain.TigerBoxAccountDomain
            r12.<init>()
            media.tiger.tigerbox.infrastructure.exception.LoginFailure$GetUserInfoFailure r1 = media.tiger.tigerbox.infrastructure.exception.LoginFailure.GetUserInfoFailure.INSTANCE
            r13 = r1
            media.tiger.tigerbox.infrastructure.exception.Failure r13 = (media.tiger.tigerbox.infrastructure.exception.Failure) r13
            r14 = 0
            r15 = 16
            r16 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r4 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r1 = r4.isRight()
            if (r1 == 0) goto L_0x012c
            java.lang.Object r1 = media.tiger.tigerbox.infrastructure.functional.EitherKt.get(r4)
            media.tiger.tigerbox.model.domain.TigerBoxAccountDomain r1 = (media.tiger.tigerbox.model.domain.TigerBoxAccountDomain) r1
            timber.log.Timber$Forest r9 = timber.log.Timber.Forest
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "We update account info from api/me "
            r10.append(r11)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r9.mo50221i(r10, r7)
            r8.setAccountInfo(r1)
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$4$1 r7 = new media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchAccountInfo$4$1
            r9 = 0
            r7.<init>(r8, r9)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r2.L$0 = r8
            r2.L$1 = r4
            r2.L$2 = r6
            r2.label = r5
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r7, r2)
            if (r1 != r3) goto L_0x0127
            return r3
        L_0x0127:
            r3 = r6
            r2 = r8
        L_0x0129:
            r8 = r2
            r6 = r3
            goto L_0x0135
        L_0x012c:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.Object[] r2 = new java.lang.Object[r7]
            java.lang.String r3 = "/api/me returned with error"
            r1.mo50217e(r3, r2)
        L_0x0135:
            r6.tigerBoxAccountResult = r4
            media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.domain.TigerBoxAccountDomain> r1 = r8.tigerBoxAccountResult
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository.fetchAccountInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object fetchProfilesInfo(kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, ? extends java.util.List<media.tiger.tigerbox.model.domain.TigerBoxProfileDomain>>> r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            boolean r2 = r1 instanceof media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchProfilesInfo$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchProfilesInfo$1 r2 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchProfilesInfo$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchProfilesInfo$1 r2 = new media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchProfilesInfo$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x0059
            if (r4 == r6) goto L_0x0047
            if (r4 != r5) goto L_0x003f
            java.lang.Object r3 = r2.L$2
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r3 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository) r3
            java.lang.Object r4 = r2.L$1
            media.tiger.tigerbox.infrastructure.functional.Either r4 = (media.tiger.tigerbox.infrastructure.functional.Either) r4
            java.lang.Object r2 = r2.L$0
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r2 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository) r2
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0141
        L_0x003f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0047:
            java.lang.Object r4 = r2.L$2
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r4 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r4
            java.lang.Object r8 = r2.L$1
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r8 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository) r8
            java.lang.Object r9 = r2.L$0
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository r9 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository) r9
            kotlin.ResultKt.throwOnFailure(r1)
        L_0x0056:
            r10 = r4
            goto L_0x00d6
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r1)
        L_0x005c:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0._loadDbInProgress
            boolean r1 = r1.get()
            if (r1 != 0) goto L_0x005c
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r8 = "fetchProfilesInfo "
            r4.append(r8)
            media.tiger.tigerbox.services.interfaces.TimeService r8 = r0.timeService
            long r8 = r8.getCurrentSystemTimeMillis()
            long r10 = r0.lastProfilesTimeInMillis
            long r8 = r8 - r10
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r1.mo50221i(r4, r8)
            media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, ? extends java.util.List<media.tiger.tigerbox.model.domain.TigerBoxProfileDomain>> r1 = r0.tigerBoxProfilesResult
            if (r1 == 0) goto L_0x00a8
            media.tiger.tigerbox.services.interfaces.TimeService r4 = r0.timeService
            long r8 = r4.getCurrentSystemTimeMillis()
            long r10 = r0.lastProfilesTimeInMillis
            long r8 = r8 - r10
            r10 = 1500(0x5dc, double:7.41E-321)
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x00a8
            boolean r4 = r1.isRight()
            if (r4 == 0) goto L_0x00a8
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.Object[] r3 = new java.lang.Object[r7]
            java.lang.String r4 = "fetchProfilesInfo - WE RETURN THE SAME RESULT - AS WE ALREADY READ THIS IN THE PAST SECOND"
            r2.mo50221i(r4, r3)
            return r1
        L_0x00a8:
            media.tiger.tigerbox.services.interfaces.TimeService r1 = r0.timeService
            long r8 = r1.getCurrentSystemTimeMillis()
            r0.lastProfilesTimeInMillis = r8
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r4 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r1 = r0.tigerBoxWebService
            media.tiger.tigerbox.model.domain.TigerBoxAccountDomain r8 = r18.getAccountInfo()
            media.tiger.tigerbox.model.domain.TigerBoxUserDomain r8 = r8.getUser()
            int r8 = r8.getAccountId()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r2.L$0 = r0
            r2.L$1 = r0
            r2.L$2 = r4
            r2.label = r6
            java.lang.Object r1 = r1.getProfilesInfo(r8, r2)
            if (r1 != r3) goto L_0x00d3
            return r3
        L_0x00d3:
            r8 = r0
            r9 = r8
            goto L_0x0056
        L_0x00d6:
            r11 = r1
            media.tiger.tigerbox.data.network.ApiResponse r11 = (media.tiger.tigerbox.data.network.ApiResponse) r11
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchProfilesInfo$3 r1 = new media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchProfilesInfo$3
            r1.<init>(r9)
            r12 = r1
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
            java.util.List r13 = kotlin.collections.CollectionsKt.emptyList()
            media.tiger.tigerbox.infrastructure.exception.LoginFailure$GetUserInfoFailure r1 = media.tiger.tigerbox.infrastructure.exception.LoginFailure.GetUserInfoFailure.INSTANCE
            r14 = r1
            media.tiger.tigerbox.infrastructure.exception.Failure r14 = (media.tiger.tigerbox.infrastructure.exception.Failure) r14
            r15 = 0
            r16 = 16
            r17 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r4 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r10, r11, r12, r13, r14, r15, r16, r17)
            boolean r1 = r4.isRight()
            if (r1 == 0) goto L_0x0144
            java.lang.Object r1 = media.tiger.tigerbox.infrastructure.functional.EitherKt.get(r4)
            java.util.List r1 = (java.util.List) r1
            timber.log.Timber$Forest r10 = timber.log.Timber.Forest
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "We update profiles info from api/accounts/{account_id}/profiles "
            r11.append(r12)
            r11.append(r1)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r10.mo50221i(r11, r7)
            media.tiger.tigerbox.model.domain.TigerBoxAccountDomain r7 = r9.getAccountInfo()
            r10 = 0
            media.tiger.tigerbox.model.domain.TigerBoxAccountDomain r1 = media.tiger.tigerbox.model.domain.TigerBoxAccountDomain.copy$default(r7, r10, r1, r6, r10)
            r9.setAccountInfo(r1)
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchProfilesInfo$4$1 r6 = new media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$fetchProfilesInfo$4$1
            r6.<init>(r9, r10)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r2.L$0 = r9
            r2.L$1 = r4
            r2.L$2 = r8
            r2.label = r5
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r6, r2)
            if (r1 != r3) goto L_0x013f
            return r3
        L_0x013f:
            r3 = r8
            r2 = r9
        L_0x0141:
            r9 = r2
            r8 = r3
            goto L_0x014d
        L_0x0144:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.Object[] r2 = new java.lang.Object[r7]
            java.lang.String r3 = "api/accounts/{account_id}/profiles returned with error"
            r1.mo50217e(r3, r2)
        L_0x014d:
            r8.tigerBoxProfilesResult = r4
            media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, ? extends java.util.List<media.tiger.tigerbox.model.domain.TigerBoxProfileDomain>> r1 = r9.tigerBoxProfilesResult
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository.fetchProfilesInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object requestDeviceInformation(java.lang.String r11, kotlin.coroutines.Continuation<? super media.tiger.tigerbox.infrastructure.functional.Either<? extends media.tiger.tigerbox.infrastructure.exception.Failure, media.tiger.tigerbox.model.dto.DeviceInformation>> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestDeviceInformation$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestDeviceInformation$1 r0 = (media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestDeviceInformation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestDeviceInformation$1 r0 = new media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestDeviceInformation$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r11 = r0.L$0
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r11 = (media.tiger.tigerbox.infrastructure.functional.RequestUtils) r11
            kotlin.ResultKt.throwOnFailure(r12)
            r2 = r11
            goto L_0x004b
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            media.tiger.tigerbox.infrastructure.functional.RequestUtils r12 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.INSTANCE
            media.tiger.tigerbox.data.network.TigerBoxWebService r2 = r10.tigerBoxWebService
            r0.L$0 = r12
            r0.label = r3
            java.lang.Object r11 = r2.deviceSearchWithIdentifier(r11, r0)
            if (r11 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r2 = r12
            r12 = r11
        L_0x004b:
            r3 = r12
            media.tiger.tigerbox.data.network.ApiResponse r3 = (media.tiger.tigerbox.data.network.ApiResponse) r3
            media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestDeviceInformation$2 r11 = media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository$requestDeviceInformation$2.INSTANCE
            r4 = r11
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            media.tiger.tigerbox.model.dto.DeviceInformation r5 = new media.tiger.tigerbox.model.dto.DeviceInformation
            r5.<init>()
            media.tiger.tigerbox.infrastructure.exception.LoginFailure$GetDeviceInfoFailure r11 = media.tiger.tigerbox.infrastructure.exception.LoginFailure.GetDeviceInfoFailure.INSTANCE
            r6 = r11
            media.tiger.tigerbox.infrastructure.exception.Failure r6 = (media.tiger.tigerbox.infrastructure.exception.Failure) r6
            r7 = 0
            r8 = 16
            r9 = 0
            media.tiger.tigerbox.infrastructure.functional.Either r11 = media.tiger.tigerbox.infrastructure.functional.RequestUtils.requestMapper$default(r2, r3, r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: media.tiger.tigerbox.data.repository.DefaultTigerBoxAccountRepository.requestDeviceInformation(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void requestUpdatedProfilesInfoFromServer(Function1<? super Either<? extends Failure, ? extends List<TigerBoxProfileDomain>>, Unit> function1) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), Dispatchers.getIO(), (CoroutineStart) null, new C2856xa4450ed8(this, function1, (Continuation<? super C2856xa4450ed8>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateActiveProfileForCurrentDevice() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), Dispatchers.getIO(), (CoroutineStart) null, new C2859x7c118af3(this, new C2862x48572ba3(this), (Continuation<? super C2859x7c118af3>) null), 2, (Object) null);
    }
}
