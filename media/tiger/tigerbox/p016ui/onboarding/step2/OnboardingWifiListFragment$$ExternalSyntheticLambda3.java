package media.tiger.tigerbox.p016ui.onboarding.step2;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiListFragment$$ExternalSyntheticLambda3 */
public final /* synthetic */ class OnboardingWifiListFragment$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ OnboardingWifiListFragment f$0;

    public /* synthetic */ OnboardingWifiListFragment$$ExternalSyntheticLambda3(OnboardingWifiListFragment onboardingWifiListFragment) {
        this.f$0 = onboardingWifiListFragment;
    }

    public final void onChanged(Object obj) {
        OnboardingWifiListFragment.m2481registerObservers$lambda1(this.f$0, (WifiViewModel.ViewState) obj);
    }
}
