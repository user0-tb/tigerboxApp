package media.tiger.tigerbox.p016ui.settings.timersSetup;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel_HiltModules_KeyModule_ProvideFactory */
public final class TimersSetupViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static TimersSetupViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(TimersSetupViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TimersSetupViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new TimersSetupViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
