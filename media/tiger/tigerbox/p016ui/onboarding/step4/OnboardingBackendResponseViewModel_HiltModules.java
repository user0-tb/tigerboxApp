package media.tiger.tigerbox.p016ui.onboarding.step4;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel_HiltModules */
public final class OnboardingBackendResponseViewModel_HiltModules {
    private OnboardingBackendResponseViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel")
        @IntoMap
        public abstract ViewModel binds(OnboardingBackendResponseViewModel onboardingBackendResponseViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel";
        }

        private KeyModule() {
        }
    }
}
