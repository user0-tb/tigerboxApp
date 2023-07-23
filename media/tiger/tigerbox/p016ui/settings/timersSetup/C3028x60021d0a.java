package media.tiger.tigerbox.p016ui.settings.timersSetup;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C3028x60021d0a implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C3028x60021d0a create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(TimersSetupLimitSetupViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C3028x60021d0a INSTANCE = new C3028x60021d0a();

        private InstanceHolder() {
        }
    }
}
