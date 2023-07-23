package media.tiger.tigerbox.p016ui.common;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.common.BaseViewModel_HiltModules */
public final class BaseViewModel_HiltModules {
    private BaseViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.BaseViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.common.BaseViewModel")
        @IntoMap
        public abstract ViewModel binds(BaseViewModel baseViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.BaseViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.common.BaseViewModel";
        }

        private KeyModule() {
        }
    }
}
