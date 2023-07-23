package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import media.tiger.tigerbox.model.domain.AccountSubscriptionDomain;

@Metadata(mo33736d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JB\u0010\u000e\u001a\u00020\u000f28\u0010\u0010\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000f0\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/AccountSubscriptionService;", "", "activeState", "Lmedia/tiger/tigerbox/services/interfaces/SubscriptionState;", "getActiveState", "()Lmedia/tiger/tigerbox/services/interfaces/SubscriptionState;", "activeSubscription", "Lmedia/tiger/tigerbox/model/domain/AccountSubscriptionDomain;", "getActiveSubscription", "()Lmedia/tiger/tigerbox/model/domain/AccountSubscriptionDomain;", "loaded", "", "getLoaded", "()Z", "updateAccountSubscription", "", "lambda", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "subscription", "state", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AccountSubscriptionService.kt */
public interface AccountSubscriptionService {
    SubscriptionState getActiveState();

    AccountSubscriptionDomain getActiveSubscription();

    boolean getLoaded();

    void updateAccountSubscription(Function2<? super AccountSubscriptionDomain, ? super SubscriptionState, Unit> function2);
}
