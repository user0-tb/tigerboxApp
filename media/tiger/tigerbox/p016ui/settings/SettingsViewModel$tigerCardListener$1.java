package media.tiger.tigerbox.p016ui.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.p016ui.settings.SettingsViewModel;
import media.tiger.tigerbox.services.interfaces.CardValidationFailError;
import media.tiger.tigerbox.services.interfaces.TicketFailure;
import media.tiger.tigerbox.services.interfaces.TigerCardDomain;
import media.tiger.tigerbox.services.interfaces.TigerCardsListener;
import media.tiger.tigerbox.services.interfaces.TigerTicketStepDomain;
import media.tiger.tigerbox.services.interfaces.WildcardReassignStep;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, mo33737d2 = {"media/tiger/tigerbox/ui/settings/SettingsViewModel$tigerCardListener$1", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsListener;", "onCardInsertedAndValidated", "", "card", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardDomain;", "onCardRemoved", "onCardValidateFailure", "failError", "Lmedia/tiger/tigerbox/services/interfaces/CardValidationFailError;", "ticketFailure", "Lmedia/tiger/tigerbox/services/interfaces/TicketFailure;", "onTigerTicketStep", "step", "Lmedia/tiger/tigerbox/services/interfaces/TigerTicketStepDomain;", "onWildcardReassignStep", "Lmedia/tiger/tigerbox/services/interfaces/WildcardReassignStep;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel$tigerCardListener$1 */
/* compiled from: SettingsViewModel.kt */
public final class SettingsViewModel$tigerCardListener$1 implements TigerCardsListener {
    final /* synthetic */ SettingsViewModel this$0;

    SettingsViewModel$tigerCardListener$1(SettingsViewModel settingsViewModel) {
        this.this$0 = settingsViewModel;
    }

    public void onCardInsertedAndValidated(TigerCardDomain tigerCardDomain) {
        Intrinsics.checkNotNullParameter(tigerCardDomain, "card");
        Timber.Forest.mo50221i("SettingsViewModel onCardInsertedAndValidated", new Object[0]);
        this.this$0.insertedNfcCardType = tigerCardDomain.getCardType();
        this.this$0.postViewState();
    }

    public void onCardValidateFailure(CardValidationFailError cardValidationFailError, TicketFailure ticketFailure) {
        Intrinsics.checkNotNullParameter(cardValidationFailError, "failError");
        Timber.Forest.mo50221i("SettingsViewModel onCardValidateFailure", new Object[0]);
    }

    public void onTigerTicketStep(TigerTicketStepDomain tigerTicketStepDomain) {
        Intrinsics.checkNotNullParameter(tigerTicketStepDomain, "step");
        Timber.Forest.mo50221i("SettingsViewModel onTigerTicketStep", new Object[0]);
    }

    public void onWildcardReassignStep(WildcardReassignStep wildcardReassignStep) {
        Intrinsics.checkNotNullParameter(wildcardReassignStep, "step");
        Timber.Forest.mo50221i("SettingsViewModel onWildcardReassignStep", new Object[0]);
        this.this$0._wildcardReassignState.setValue(new SettingsViewModel.WildcardState(wildcardReassignStep));
    }

    public void onCardRemoved() {
        Timber.Forest.mo50221i("SettingsViewModel onCardRemoved", new Object[0]);
        this.this$0.insertedNfcCardType = null;
        this.this$0.postViewState();
    }
}
