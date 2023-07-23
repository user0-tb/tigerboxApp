package media.tiger.tigerbox.p016ui.settings.timersSetup;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel_HiltModules */
public final class TimersSetupWindowSetupViewModel_HiltModules {
    private TimersSetupWindowSetupViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel")
        @IntoMap
        public abstract ViewModel binds(TimersSetupWindowSetupViewModel timersSetupWindowSetupViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel";
        }

        private KeyModule() {
        }
    }
}
