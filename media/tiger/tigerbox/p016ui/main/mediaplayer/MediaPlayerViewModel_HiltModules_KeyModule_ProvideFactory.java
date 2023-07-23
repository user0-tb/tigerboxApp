package media.tiger.tigerbox.p016ui.main.mediaplayer;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel_HiltModules_KeyModule_ProvideFactory */
public final class MediaPlayerViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static MediaPlayerViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(MediaPlayerViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final MediaPlayerViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new MediaPlayerViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
