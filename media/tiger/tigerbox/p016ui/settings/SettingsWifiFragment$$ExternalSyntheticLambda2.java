package media.tiger.tigerbox.p016ui.settings;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsWifiFragment$$ExternalSyntheticLambda2 */
public final /* synthetic */ class SettingsWifiFragment$$ExternalSyntheticLambda2 implements Observer {
    public final /* synthetic */ SettingsWifiFragment f$0;

    public /* synthetic */ SettingsWifiFragment$$ExternalSyntheticLambda2(SettingsWifiFragment settingsWifiFragment) {
        this.f$0 = settingsWifiFragment;
    }

    public final void onChanged(Object obj) {
        SettingsWifiFragment.m2531registerObservers$lambda2(this.f$0, (WifiViewModel.ViewState) obj);
    }
}
