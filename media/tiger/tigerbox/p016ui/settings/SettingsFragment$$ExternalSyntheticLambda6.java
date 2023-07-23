package media.tiger.tigerbox.p016ui.settings;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Ref;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$$ExternalSyntheticLambda6 */
public final /* synthetic */ class SettingsFragment$$ExternalSyntheticLambda6 implements Observer {
    public final /* synthetic */ SettingsCircleProgressItemData f$0;
    public final /* synthetic */ Ref.IntRef f$1;
    public final /* synthetic */ SettingsFragment f$2;

    public /* synthetic */ SettingsFragment$$ExternalSyntheticLambda6(SettingsCircleProgressItemData settingsCircleProgressItemData, Ref.IntRef intRef, SettingsFragment settingsFragment) {
        this.f$0 = settingsCircleProgressItemData;
        this.f$1 = intRef;
        this.f$2 = settingsFragment;
    }

    public final void onChanged(Object obj) {
        SettingsFragment.m2525onCreateView$lambda10(this.f$0, this.f$1, this.f$2, (Integer) obj);
    }
}
