package media.tiger.tigerbox.p016ui.settings;

import android.view.View;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsAdapter$$ExternalSyntheticLambda2 */
public final /* synthetic */ class SettingsAdapter$$ExternalSyntheticLambda2 implements View.OnLongClickListener {
    public final /* synthetic */ SettingsAdapter f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ SettingsCircleProgressItemData f$2;

    public /* synthetic */ SettingsAdapter$$ExternalSyntheticLambda2(SettingsAdapter settingsAdapter, int i, SettingsCircleProgressItemData settingsCircleProgressItemData) {
        this.f$0 = settingsAdapter;
        this.f$1 = i;
        this.f$2 = settingsCircleProgressItemData;
    }

    public final boolean onLongClick(View view) {
        return SettingsAdapter.m2507onBindViewHolder$lambda2$lambda1(this.f$0, this.f$1, this.f$2, view);
    }
}
