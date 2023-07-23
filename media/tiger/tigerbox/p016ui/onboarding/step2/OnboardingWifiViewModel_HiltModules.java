package media.tiger.tigerbox.p016ui.onboarding.step2;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel_HiltModules */
public final class OnboardingWifiViewModel_HiltModules {
    private OnboardingWifiViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel")
        @IntoMap
        public abstract ViewModel binds(OnboardingWifiViewModel onboardingWifiViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel";
        }

        private KeyModule() {
        }
    }
}
