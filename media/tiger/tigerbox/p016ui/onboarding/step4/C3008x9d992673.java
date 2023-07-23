package media.tiger.tigerbox.p016ui.onboarding.step4;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendResponseViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C3008x9d992673 implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C3008x9d992673 create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(OnboardingBackendResponseViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C3008x9d992673 INSTANCE = new C3008x9d992673();

        private InstanceHolder() {
        }
    }
}
