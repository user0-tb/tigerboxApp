package media.tiger.tigerbox.p016ui.settings;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import media.tiger.tigerbox.model.domain.AccountSubscriptionDomain;
import media.tiger.tigerbox.p016ui.settings.SettingsViewModel;
import media.tiger.tigerbox.services.interfaces.SubscriptionState;

@Metadata(mo33736d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo33737d2 = {"<anonymous>", "", "subscription", "Lmedia/tiger/tigerbox/model/domain/AccountSubscriptionDomain;", "state", "Lmedia/tiger/tigerbox/services/interfaces/SubscriptionState;", "invoke"}, mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel$updateSubscriptionInfo$1 */
/* compiled from: SettingsViewModel.kt */
final class SettingsViewModel$updateSubscriptionInfo$1 extends Lambda implements Function2<AccountSubscriptionDomain, SubscriptionState, Unit> {
    final /* synthetic */ SettingsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsViewModel$updateSubscriptionInfo$1(SettingsViewModel settingsViewModel) {
        super(2);
        this.this$0 = settingsViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((AccountSubscriptionDomain) obj, (SubscriptionState) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(AccountSubscriptionDomain accountSubscriptionDomain, SubscriptionState subscriptionState) {
        String str;
        Intrinsics.checkNotNullParameter(subscriptionState, "state");
        SettingsViewModel settingsViewModel = this.this$0;
        if (accountSubscriptionDomain == null || (str = accountSubscriptionDomain.getFormattedEndDate()) == null) {
            str = "";
        }
        boolean z = false;
        boolean z2 = subscriptionState == SubscriptionState.EXPIRED;
        if (subscriptionState == SubscriptionState.SUBSCRIBED_BUT_ABOUT_TO_EXPIRE) {
            z = true;
        }
        settingsViewModel.subscriptionInfo = new SettingsViewModel.SubscriptionViewState(str, z2, z, true);
        this.this$0.postViewState();
    }
}
