package media.tiger.tigerbox.p016ui.settings.parentalGate;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel_HiltModules_KeyModule_ProvideFactory */
public final class ParentalGateViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static ParentalGateViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(ParentalGateViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ParentalGateViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ParentalGateViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
