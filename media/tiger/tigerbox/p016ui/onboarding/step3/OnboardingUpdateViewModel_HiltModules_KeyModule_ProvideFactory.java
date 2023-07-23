package media.tiger.tigerbox.p016ui.onboarding.step3;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.onboarding.step3.OnboardingUpdateViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel_HiltModules_KeyModule_ProvideFactory */
public final class OnboardingUpdateViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static OnboardingUpdateViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(OnboardingUpdateViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OnboardingUpdateViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new OnboardingUpdateViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
