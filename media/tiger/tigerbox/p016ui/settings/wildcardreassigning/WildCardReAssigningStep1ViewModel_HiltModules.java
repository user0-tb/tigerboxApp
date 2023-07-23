package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_HiltModules */
public final class WildCardReAssigningStep1ViewModel_HiltModules {
    private WildCardReAssigningStep1ViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel")
        @IntoMap
        public abstract ViewModel binds(WildCardReAssigningStep1ViewModel wildCardReAssigningStep1ViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel";
        }

        private KeyModule() {
        }
    }
}
