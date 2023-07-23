package media.tiger.tigerbox.p016ui.common;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.common.FullScreenViewModel_HiltModules */
public final class FullScreenViewModel_HiltModules {
    private FullScreenViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.FullScreenViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.common.FullScreenViewModel")
        @IntoMap
        public abstract ViewModel binds(FullScreenViewModel fullScreenViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.FullScreenViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.common.FullScreenViewModel";
        }

        private KeyModule() {
        }
    }
}
