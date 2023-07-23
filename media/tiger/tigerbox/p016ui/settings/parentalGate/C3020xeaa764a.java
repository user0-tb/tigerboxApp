package media.tiger.tigerbox.p016ui.settings.parentalGate;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C3020xeaa764a implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C3020xeaa764a create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(ParentalGateEnableDisableStepViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C3020xeaa764a INSTANCE = new C3020xeaa764a();

        private InstanceHolder() {
        }
    }
}
