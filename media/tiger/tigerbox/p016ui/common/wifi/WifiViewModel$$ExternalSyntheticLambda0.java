package media.tiger.tigerbox.p016ui.common.wifi;

import androidx.lifecycle.Observer;

/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel$$ExternalSyntheticLambda0 */
public final /* synthetic */ class WifiViewModel$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ WifiViewModel f$0;

    public /* synthetic */ WifiViewModel$$ExternalSyntheticLambda0(WifiViewModel wifiViewModel) {
        this.f$0 = wifiViewModel;
    }

    public final void onChanged(Object obj) {
        WifiViewModel.m2383scanProgressObserver$lambda0(this.f$0, (Boolean) obj);
    }
}
