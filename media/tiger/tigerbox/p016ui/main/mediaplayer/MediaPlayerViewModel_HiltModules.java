package media.tiger.tigerbox.p016ui.main.mediaplayer;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel_HiltModules */
public final class MediaPlayerViewModel_HiltModules {
    private MediaPlayerViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel")
        @IntoMap
        public abstract ViewModel binds(MediaPlayerViewModel mediaPlayerViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel";
        }

        private KeyModule() {
        }
    }
}
