package media.tiger.tigerbox.p016ui.onboarding.step1;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel_HiltModules */
public final class OnboardingStep1Screen1ViewModel_HiltModules {
    private OnboardingStep1Screen1ViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel")
        @IntoMap
        public abstract ViewModel binds(OnboardingStep1Screen1ViewModel onboardingStep1Screen1ViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel";
        }

        private KeyModule() {
        }
    }
}
