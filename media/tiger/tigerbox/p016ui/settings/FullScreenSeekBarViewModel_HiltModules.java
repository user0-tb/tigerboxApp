package media.tiger.tigerbox.p016ui.settings;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.FullScreenSeekBarViewModel_HiltModules */
public final class FullScreenSeekBarViewModel_HiltModules {
    private FullScreenSeekBarViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.FullScreenSeekBarViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.FullScreenSeekBarViewModel")
        @IntoMap
        public abstract ViewModel binds(FullScreenSeekBarViewModel fullScreenSeekBarViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.FullScreenSeekBarViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.FullScreenSeekBarViewModel";
        }

        private KeyModule() {
        }
    }
}
