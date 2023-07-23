package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.RestartServicesSafely;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideRestartServicesSafelyFactory */
public final class ProcessModule_ProvideRestartServicesSafelyFactory implements Factory<RestartServicesSafely> {
    private final Provider<Context> contextProvider;

    public ProcessModule_ProvideRestartServicesSafelyFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public RestartServicesSafely get() {
        return provideRestartServicesSafely(this.contextProvider.get());
    }

    public static ProcessModule_ProvideRestartServicesSafelyFactory create(Provider<Context> provider) {
        return new ProcessModule_ProvideRestartServicesSafelyFactory(provider);
    }

    public static RestartServicesSafely provideRestartServicesSafely(Context context) {
        return (RestartServicesSafely) Preconditions.checkNotNullFromProvides(ProcessModule.INSTANCE.provideRestartServicesSafely(context));
    }
}
