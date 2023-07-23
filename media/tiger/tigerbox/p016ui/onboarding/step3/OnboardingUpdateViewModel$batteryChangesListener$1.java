package media.tiger.tigerbox.p016ui.onboarding.step3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.model.domain.BatterySummary;
import media.tiger.tigerbox.p016ui.onboarding.step3.OnboardingUpdateViewModel;
import media.tiger.tigerbox.services.interfaces.BatteryChangesListener;

@Metadata(mo33736d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo33737d2 = {"media/tiger/tigerbox/ui/onboarding/step3/OnboardingUpdateViewModel$batteryChangesListener$1", "Lmedia/tiger/tigerbox/services/interfaces/BatteryChangesListener;", "onCablePluggedIn", "", "onStatusChanged", "batterySummary", "Lmedia/tiger/tigerbox/model/domain/BatterySummary;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel$batteryChangesListener$1 */
/* compiled from: OnboardingUpdateViewModel.kt */
public final class OnboardingUpdateViewModel$batteryChangesListener$1 implements BatteryChangesListener {
    final /* synthetic */ OnboardingUpdateViewModel this$0;

    public void onCablePluggedIn() {
    }

    OnboardingUpdateViewModel$batteryChangesListener$1(OnboardingUpdateViewModel onboardingUpdateViewModel) {
        this.this$0 = onboardingUpdateViewModel;
    }

    public void onStatusChanged(BatterySummary batterySummary) {
        Intrinsics.checkNotNullParameter(batterySummary, "batterySummary");
        if (this.this$0.firmwareUpdateService.getHasEnoughBattery()) {
            this.this$0.batteryService.unsubscribeFromBatteryChanges(this);
            this.this$0._viewState.postValue(new OnboardingUpdateViewModel.ViewState.AllowUpdate(this.this$0.isCancellable()));
            return;
        }
        this.this$0._viewState.postValue(new OnboardingUpdateViewModel.ViewState.BatteryInsufficient((int) batterySummary.getBatteryPercent(), batterySummary.isCharging(), this.this$0.isCancellable()));
    }
}
