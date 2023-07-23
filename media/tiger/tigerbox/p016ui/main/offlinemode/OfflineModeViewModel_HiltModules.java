package media.tiger.tigerbox.p016ui.main.offlinemode;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel_HiltModules */
public final class OfflineModeViewModel_HiltModules {
    private OfflineModeViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel")
        @IntoMap
        public abstract ViewModel binds(OfflineModeViewModel offlineModeViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel";
        }

        private KeyModule() {
        }
    }
}
