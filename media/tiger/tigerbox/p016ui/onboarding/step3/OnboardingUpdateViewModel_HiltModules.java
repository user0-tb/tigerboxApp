package media.tiger.tigerbox.p016ui.onboarding.step3;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel_HiltModules */
public final class OnboardingUpdateViewModel_HiltModules {
    private OnboardingUpdateViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel")
        @IntoMap
        public abstract ViewModel binds(OnboardingUpdateViewModel onboardingUpdateViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel";
        }

        private KeyModule() {
        }
    }
}
