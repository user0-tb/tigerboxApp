package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C3043x2b4967d8 implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C3043x2b4967d8 create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(WildCardReAssigningStep1ViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C3043x2b4967d8 INSTANCE = new C3043x2b4967d8();

        private InstanceHolder() {
        }
    }
}
