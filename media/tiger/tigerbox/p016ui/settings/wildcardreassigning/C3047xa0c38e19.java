package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep2ViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep2ViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C3047xa0c38e19 implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C3047xa0c38e19 create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(WildCardReAssigningStep2ViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep2ViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C3047xa0c38e19 INSTANCE = new C3047xa0c38e19();

        private InstanceHolder() {
        }
    }
}
