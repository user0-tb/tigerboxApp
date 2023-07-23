package media.tiger.tigerbox.p016ui.settings.timersSetup;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupWindowSetupViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C3032xc74673f7 implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C3032xc74673f7 create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(TimersSetupWindowSetupViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C3032xc74673f7 INSTANCE = new C3032xc74673f7();

        private InstanceHolder() {
        }
    }
}
