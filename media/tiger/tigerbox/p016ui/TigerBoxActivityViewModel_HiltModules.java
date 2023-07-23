package media.tiger.tigerbox.p016ui;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.TigerBoxActivityViewModel_HiltModules */
public final class TigerBoxActivityViewModel_HiltModules {
    private TigerBoxActivityViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.TigerBoxActivityViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.TigerBoxActivityViewModel")
        @IntoMap
        public abstract ViewModel binds(TigerBoxActivityViewModel tigerBoxActivityViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.TigerBoxActivityViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.TigerBoxActivityViewModel";
        }

        private KeyModule() {
        }
    }
}
