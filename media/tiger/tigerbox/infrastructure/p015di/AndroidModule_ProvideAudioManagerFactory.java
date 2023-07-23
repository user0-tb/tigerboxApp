package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import android.media.AudioManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* renamed from: media.tiger.tigerbox.infrastructure.di.AndroidModule_ProvideAudioManagerFactory */
public final class AndroidModule_ProvideAudioManagerFactory implements Factory<AudioManager> {
    private final Provider<Context> contextProvider;

    public AndroidModule_ProvideAudioManagerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public AudioManager get() {
        return provideAudioManager(this.contextProvider.get());
    }

    public static AndroidModule_ProvideAudioManagerFactory create(Provider<Context> provider) {
        return new AndroidModule_ProvideAudioManagerFactory(provider);
    }

    public static AudioManager provideAudioManager(Context context) {
        return (AudioManager) Preconditions.checkNotNullFromProvides(AndroidModule.INSTANCE.provideAudioManager(context));
    }
}
