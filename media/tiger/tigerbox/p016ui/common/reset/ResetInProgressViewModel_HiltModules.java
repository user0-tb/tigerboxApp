package media.tiger.tigerbox.p016ui.common.reset;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.common.reset.ResetInProgressViewModel_HiltModules */
public final class ResetInProgressViewModel_HiltModules {
    private ResetInProgressViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.reset.ResetInProgressViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.common.reset.ResetInProgressViewModel")
        @IntoMap
        public abstract ViewModel binds(ResetInProgressViewModel resetInProgressViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.reset.ResetInProgressViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.common.reset.ResetInProgressViewModel";
        }

        private KeyModule() {
        }
    }
}
