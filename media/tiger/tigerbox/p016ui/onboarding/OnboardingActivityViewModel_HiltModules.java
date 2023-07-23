package media.tiger.tigerbox.p016ui.onboarding;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel_HiltModules */
public final class OnboardingActivityViewModel_HiltModules {
    private OnboardingActivityViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel")
        @IntoMap
        public abstract ViewModel binds(OnboardingActivityViewModel onboardingActivityViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel";
        }

        private KeyModule() {
        }
    }
}
