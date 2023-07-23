package media.tiger.tigerbox.p016ui.main.mediaplayer;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.ChapterListViewModel_HiltModules */
public final class ChapterListViewModel_HiltModules {
    private ChapterListViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.ChapterListViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.main.mediaplayer.ChapterListViewModel")
        @IntoMap
        public abstract ViewModel binds(ChapterListViewModel chapterListViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.ChapterListViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.main.mediaplayer.ChapterListViewModel";
        }

        private KeyModule() {
        }
    }
}
