package media.tiger.tigerbox.p016ui.settings;

import android.view.View;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsAdapter$$ExternalSyntheticLambda3 */
public final /* synthetic */ class SettingsAdapter$$ExternalSyntheticLambda3 implements View.OnLongClickListener {
    public final /* synthetic */ SettingsAdapter f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ SettingsItemData f$2;

    public /* synthetic */ SettingsAdapter$$ExternalSyntheticLambda3(SettingsAdapter settingsAdapter, int i, SettingsItemData settingsItemData) {
        this.f$0 = settingsAdapter;
        this.f$1 = i;
        this.f$2 = settingsItemData;
    }

    public final boolean onLongClick(View view) {
        return SettingsAdapter.m2509onBindViewHolder$lambda5$lambda4(this.f$0, this.f$1, this.f$2, view);
    }
}
