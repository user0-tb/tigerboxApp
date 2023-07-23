package media.tiger.tigerbox.p016ui.onboarding.step4;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendCommunicationViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C3004x887e5a76 implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C3004x887e5a76 create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(OnboardingBackendCommunicationViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C3004x887e5a76 INSTANCE = new C3004x887e5a76();

        private InstanceHolder() {
        }
    }
}
