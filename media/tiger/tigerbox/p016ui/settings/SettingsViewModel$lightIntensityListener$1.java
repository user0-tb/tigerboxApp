package media.tiger.tigerbox.p016ui.settings;

import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.LightIntensityChangedListener;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/ui/settings/SettingsViewModel$lightIntensityListener$1", "Lmedia/tiger/tigerbox/services/interfaces/LightIntensityChangedListener;", "onChange", "", "intensity", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel$lightIntensityListener$1 */
/* compiled from: SettingsViewModel.kt */
public final class SettingsViewModel$lightIntensityListener$1 implements LightIntensityChangedListener {
    final /* synthetic */ SettingsViewModel this$0;

    SettingsViewModel$lightIntensityListener$1(SettingsViewModel settingsViewModel) {
        this.this$0 = settingsViewModel;
    }

    public void onChange(int i) {
        this.this$0.postViewState();
    }
}
