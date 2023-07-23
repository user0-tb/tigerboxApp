package media.tiger.tigerbox.p016ui.settings;

import androidx.lifecycle.Observer;
import java.util.List;
import media.tiger.tigerbox.p016ui.settings.SettingsViewModel;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$$ExternalSyntheticLambda9 */
public final /* synthetic */ class SettingsFragment$$ExternalSyntheticLambda9 implements Observer {
    public final /* synthetic */ SettingsFragment f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ SettingsFragment$$ExternalSyntheticLambda9(SettingsFragment settingsFragment, List list) {
        this.f$0 = settingsFragment;
        this.f$1 = list;
    }

    public final void onChanged(Object obj) {
        SettingsFragment.m2527onCreateView$lambda8(this.f$0, this.f$1, (SettingsViewModel.ViewState) obj);
    }
}
