package media.tiger.tigerbox.p016ui.settings.timersSetup;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel_HiltModules */
public final class TimersSetupViewModel_HiltModules {
    private TimersSetupViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel")
        @IntoMap
        public abstract ViewModel binds(TimersSetupViewModel timersSetupViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel";
        }

        private KeyModule() {
        }
    }
}
