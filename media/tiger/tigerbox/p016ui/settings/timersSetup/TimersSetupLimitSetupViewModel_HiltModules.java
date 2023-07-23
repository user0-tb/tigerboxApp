package media.tiger.tigerbox.p016ui.settings.timersSetup;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel_HiltModules */
public final class TimersSetupLimitSetupViewModel_HiltModules {
    private TimersSetupLimitSetupViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel")
        @IntoMap
        public abstract ViewModel binds(TimersSetupLimitSetupViewModel timersSetupLimitSetupViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel";
        }

        private KeyModule() {
        }
    }
}
