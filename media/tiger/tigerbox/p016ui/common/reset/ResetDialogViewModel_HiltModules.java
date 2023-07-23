package media.tiger.tigerbox.p016ui.common.reset;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel_HiltModules */
public final class ResetDialogViewModel_HiltModules {
    private ResetDialogViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel")
        @IntoMap
        public abstract ViewModel binds(ResetDialogViewModel resetDialogViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel";
        }

        private KeyModule() {
        }
    }
}
