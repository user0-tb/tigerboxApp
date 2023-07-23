package media.tiger.tigerbox.p016ui.settings;

import p009j$.util.function.Predicate;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$$ExternalSyntheticLambda12 */
public final /* synthetic */ class SettingsFragment$$ExternalSyntheticLambda12 implements Predicate {
    public static final /* synthetic */ SettingsFragment$$ExternalSyntheticLambda12 INSTANCE = new SettingsFragment$$ExternalSyntheticLambda12();

    private /* synthetic */ SettingsFragment$$ExternalSyntheticLambda12() {
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
        return SettingsFragment.m2522createSettingsList$lambda23((SettingsItemData) obj);
    }
}
