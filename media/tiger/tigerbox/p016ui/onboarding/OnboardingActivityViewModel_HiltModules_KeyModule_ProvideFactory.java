package media.tiger.tigerbox.p016ui.onboarding;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel_HiltModules_KeyModule_ProvideFactory */
public final class OnboardingActivityViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static OnboardingActivityViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(OnboardingActivityViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OnboardingActivityViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new OnboardingActivityViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
