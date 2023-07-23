package media.tiger.tigerbox.p016ui.onboarding.step2;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiListFragment$$ExternalSyntheticLambda2 */
public final /* synthetic */ class OnboardingWifiListFragment$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ OnboardingWifiListFragment f$0;

    public /* synthetic */ OnboardingWifiListFragment$$ExternalSyntheticLambda2(OnboardingWifiListFragment onboardingWifiListFragment) {
        this.f$0 = onboardingWifiListFragment;
    }

    public final void onChanged(Object obj) {
        OnboardingWifiListFragment.m2484registerObservers$lambda3(this.f$0, (WifiViewModel.NavigationEvent) obj);
    }
}
