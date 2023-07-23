package media.tiger.tigerbox.p016ui.settings;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel_HiltModules */
public final class SettingsViewModel_HiltModules {
    private SettingsViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.SettingsViewModel")
        @IntoMap
        public abstract ViewModel binds(SettingsViewModel settingsViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.SettingsViewModel";
        }

        private KeyModule() {
        }
    }
}
