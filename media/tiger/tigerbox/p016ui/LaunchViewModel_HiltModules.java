package media.tiger.tigerbox.p016ui;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.LaunchViewModel_HiltModules */
public final class LaunchViewModel_HiltModules {
    private LaunchViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.LaunchViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.LaunchViewModel")
        @IntoMap
        public abstract ViewModel binds(LaunchViewModel launchViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.LaunchViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.LaunchViewModel";
        }

        private KeyModule() {
        }
    }
}
