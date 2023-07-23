package media.tiger.tigerbox.p016ui.onboarding.step1;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen1ViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C2986xee60c5f4 implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C2986xee60c5f4 create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(OnboardingStep1Screen1ViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C2986xee60c5f4 INSTANCE = new C2986xee60c5f4();

        private InstanceHolder() {
        }
    }
}
