package media.tiger.tigerbox.p016ui.onboarding.step2;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.onboarding.step2.OnboardingWifiViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel_HiltModules_KeyModule_ProvideFactory */
public final class OnboardingWifiViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static OnboardingWifiViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(OnboardingWifiViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final OnboardingWifiViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new OnboardingWifiViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
