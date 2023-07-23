package media.tiger.tigerbox.p016ui.settings;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsWifiFragment$$ExternalSyntheticLambda1 */
public final /* synthetic */ class SettingsWifiFragment$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ SettingsWifiFragment f$0;

    public /* synthetic */ SettingsWifiFragment$$ExternalSyntheticLambda1(SettingsWifiFragment settingsWifiFragment) {
        this.f$0 = settingsWifiFragment;
    }

    public final void onChanged(Object obj) {
        SettingsWifiFragment.m2533registerObservers$lambda4(this.f$0, (WifiViewModel.NavigationEvent) obj);
    }
}
