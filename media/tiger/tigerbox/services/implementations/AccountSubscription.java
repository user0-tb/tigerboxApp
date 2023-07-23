package media.tiger.tigerbox.services.implementations;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import media.tiger.tigerbox.infrastructure.exception.Failure;
import media.tiger.tigerbox.model.domain.AccountSubscriptionDomain;
import media.tiger.tigerbox.services.interfaces.AccountSubscriptionService;
import media.tiger.tigerbox.services.interfaces.SubscriptionState;
import media.tiger.tigerbox.usecase.GetSubscriptionsUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import media.tiger.tigerbox.utils.DateUtilsKt;

@Metadata(mo33736d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0012\u0010$\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\nH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002JB\u0010&\u001a\u00020\u001e28\u0010'\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\nH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011RB\u0010\u0018\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/AccountSubscription;", "Lmedia/tiger/tigerbox/services/interfaces/AccountSubscriptionService;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "sharedPreferences", "Landroid/content/SharedPreferences;", "subscriptionsUseCase", "Lmedia/tiger/tigerbox/usecase/GetSubscriptionsUseCase;", "(Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;Landroid/content/SharedPreferences;Lmedia/tiger/tigerbox/usecase/GetSubscriptionsUseCase;)V", "_localSubscription", "Lmedia/tiger/tigerbox/model/domain/AccountSubscriptionDomain;", "activeState", "Lmedia/tiger/tigerbox/services/interfaces/SubscriptionState;", "getActiveState", "()Lmedia/tiger/tigerbox/services/interfaces/SubscriptionState;", "activeSubscription", "getActiveSubscription", "()Lmedia/tiger/tigerbox/model/domain/AccountSubscriptionDomain;", "loaded", "", "getLoaded", "()Z", "localSubscription", "getLocalSubscription", "onDoneLambda", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "subscription", "state", "", "getState", "info", "handleReqFailure", "failure", "Lmedia/tiger/tigerbox/infrastructure/exception/Failure;", "handleReqSuccess", "requestSubscription", "updateAccountSubscription", "lambda", "updateLocalInfo", "Companion", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AccountSubscription.kt */
public final class AccountSubscription implements AccountSubscriptionService {
    private static final int ABOUT_TO_EXPIRE_DAYS = 5;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    private static final String LOCAL_ACCOUNT_SUBSCRIPTION_ID = "localAccountSubscriptionInfo";
    private AccountSubscriptionDomain _localSubscription;
    private final GetTigerBoxAccountUseCase getTigerBoxAccountUseCase;
    private Function2<? super AccountSubscriptionDomain, ? super SubscriptionState, Unit> onDoneLambda;
    /* access modifiers changed from: private */
    public final SharedPreferences sharedPreferences;
    private final GetSubscriptionsUseCase subscriptionsUseCase;

    public AccountSubscription(GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2, SharedPreferences sharedPreferences2, GetSubscriptionsUseCase getSubscriptionsUseCase) {
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(getSubscriptionsUseCase, "subscriptionsUseCase");
        this.getTigerBoxAccountUseCase = getTigerBoxAccountUseCase2;
        this.sharedPreferences = sharedPreferences2;
        this.subscriptionsUseCase = getSubscriptionsUseCase;
    }

    public AccountSubscriptionDomain getActiveSubscription() {
        return getLocalSubscription();
    }

    public SubscriptionState getActiveState() {
        if (getLocalSubscription() == null) {
            return SubscriptionState.EXPIRED;
        }
        AccountSubscriptionDomain localSubscription = getLocalSubscription();
        Intrinsics.checkNotNull(localSubscription);
        return getState(localSubscription);
    }

    public boolean getLoaded() {
        return getLocalSubscription() != null;
    }

    public void updateAccountSubscription(Function2<? super AccountSubscriptionDomain, ? super SubscriptionState, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "lambda");
        this.onDoneLambda = function2;
        requestSubscription();
    }

    private final void requestSubscription() {
        this.subscriptionsUseCase.invoke(new GetSubscriptionsUseCase.RequestParams(String.valueOf(this.getTigerBoxAccountUseCase.invoke().getUser().getAccountId())), CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new AccountSubscription$requestSubscription$1(this));
    }

    private final SubscriptionState getState(AccountSubscriptionDomain accountSubscriptionDomain) {
        if (accountSubscriptionDomain == null) {
            return SubscriptionState.EXPIRED;
        }
        if (!accountSubscriptionDomain.getActive() || accountSubscriptionDomain.getValidUntil() == null) {
            return SubscriptionState.EXPIRED;
        }
        Date date = new Date();
        Calendar instance = Calendar.getInstance();
        instance.add(5, 5);
        Date date2 = DateUtilsKt.toDate(accountSubscriptionDomain.getValidUntil(), "yyyy-MM-dd'T'HH:mm:ss");
        if (date2.before(date)) {
            return SubscriptionState.EXPIRED;
        }
        if (date2.compareTo(date) < 0 || date2.compareTo(instance.getTime()) > 0) {
            return SubscriptionState.SUBSCRIBED;
        }
        return SubscriptionState.SUBSCRIBED_BUT_ABOUT_TO_EXPIRE;
    }

    /* access modifiers changed from: private */
    public final void handleReqFailure(Failure failure) {
        Function2<? super AccountSubscriptionDomain, ? super SubscriptionState, Unit> function2 = this.onDoneLambda;
        if (function2 != null) {
            function2.invoke(getLocalSubscription(), getState(getLocalSubscription()));
        }
    }

    /* access modifiers changed from: private */
    public final void handleReqSuccess(AccountSubscriptionDomain accountSubscriptionDomain) {
        if (accountSubscriptionDomain != null) {
            updateLocalInfo(accountSubscriptionDomain);
        }
        Function2<? super AccountSubscriptionDomain, ? super SubscriptionState, Unit> function2 = this.onDoneLambda;
        if (function2 != null) {
            function2.invoke(accountSubscriptionDomain, getState(accountSubscriptionDomain));
        }
    }

    private final AccountSubscriptionDomain getLocalSubscription() {
        String string;
        boolean z = true;
        if (this._localSubscription == null && (string = this.sharedPreferences.getString(LOCAL_ACCOUNT_SUBSCRIPTION_ID, "")) != null) {
            if (string.length() > 0) {
                this._localSubscription = (AccountSubscriptionDomain) new Gson().fromJson(string, new AccountSubscription$localSubscription$statesType$1().getType());
            }
        }
        AccountSubscriptionDomain accountSubscriptionDomain = this._localSubscription;
        if (accountSubscriptionDomain == null || this.getTigerBoxAccountUseCase.invoke().getUser().getAccountId() != accountSubscriptionDomain.getAccountId()) {
            z = false;
        }
        if (z) {
            return this._localSubscription;
        }
        return null;
    }

    private final void updateLocalInfo(AccountSubscriptionDomain accountSubscriptionDomain) {
        this._localSubscription = accountSubscriptionDomain;
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), (CoroutineContext) null, (CoroutineStart) null, new AccountSubscription$updateLocalInfo$1(accountSubscriptionDomain, this, (Continuation<? super AccountSubscription$updateLocalInfo$1>) null), 3, (Object) null);
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/implementations/AccountSubscription$Companion;", "", "()V", "ABOUT_TO_EXPIRE_DAYS", "", "DATE_FORMAT", "", "LOCAL_ACCOUNT_SUBSCRIPTION_ID", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AccountSubscription.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
