package media.tiger.tigerbox.p016ui.settings;

import p009j$.util.function.Predicate;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$$ExternalSyntheticLambda3 */
public final /* synthetic */ class SettingsFragment$$ExternalSyntheticLambda3 implements Predicate {
    public static final /* synthetic */ SettingsFragment$$ExternalSyntheticLambda3 INSTANCE = new SettingsFragment$$ExternalSyntheticLambda3();

    private /* synthetic */ SettingsFragment$$ExternalSyntheticLambda3() {
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
        return SettingsFragment.m2523createSettingsList$lambda24((SettingsItemData) obj);
    }
}
