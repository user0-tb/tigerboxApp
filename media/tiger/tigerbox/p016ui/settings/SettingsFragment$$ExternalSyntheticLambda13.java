package media.tiger.tigerbox.p016ui.settings;

import p009j$.util.function.Predicate;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$$ExternalSyntheticLambda13 */
public final /* synthetic */ class SettingsFragment$$ExternalSyntheticLambda13 implements Predicate {
    public static final /* synthetic */ SettingsFragment$$ExternalSyntheticLambda13 INSTANCE = new SettingsFragment$$ExternalSyntheticLambda13();

    private /* synthetic */ SettingsFragment$$ExternalSyntheticLambda13() {
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    /* renamed from: or */
    public /* synthetic */ Predicate mo6806or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return SettingsFragment.m2521createSettingsList$lambda22((SettingsItemData) obj);
    }
}
