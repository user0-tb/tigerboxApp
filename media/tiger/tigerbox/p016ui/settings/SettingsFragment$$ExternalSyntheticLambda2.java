package media.tiger.tigerbox.p016ui.settings;

import p009j$.util.function.Predicate;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsFragment$$ExternalSyntheticLambda2 */
public final /* synthetic */ class SettingsFragment$$ExternalSyntheticLambda2 implements Predicate {
    public static final /* synthetic */ SettingsFragment$$ExternalSyntheticLambda2 INSTANCE = new SettingsFragment$$ExternalSyntheticLambda2();

    private /* synthetic */ SettingsFragment$$ExternalSyntheticLambda2() {
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
        return SettingsFragment.m2517createSettingsList$lambda18((SettingsItemData) obj);
    }
}
