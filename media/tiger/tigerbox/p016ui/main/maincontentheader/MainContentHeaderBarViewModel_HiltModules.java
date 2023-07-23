package media.tiger.tigerbox.p016ui.main.maincontentheader;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel_HiltModules */
public final class MainContentHeaderBarViewModel_HiltModules {
    private MainContentHeaderBarViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel")
        @IntoMap
        public abstract ViewModel binds(MainContentHeaderBarViewModel mainContentHeaderBarViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel";
        }

        private KeyModule() {
        }
    }
}
