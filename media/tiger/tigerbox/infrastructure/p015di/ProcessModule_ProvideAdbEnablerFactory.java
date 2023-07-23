package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.AdbEnabler;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideAdbEnablerFactory */
public final class ProcessModule_ProvideAdbEnablerFactory implements Factory<AdbEnabler> {
    private final Provider<Context> contextProvider;

    public ProcessModule_ProvideAdbEnablerFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public AdbEnabler get() {
        return provideAdbEnabler(this.contextProvider.get());
    }

    public static ProcessModule_ProvideAdbEnablerFactory create(Provider<Context> provider) {
        return new ProcessModule_ProvideAdbEnablerFactory(provider);
    }

    public static AdbEnabler provideAdbEnabler(Context context) {
        return (AdbEnabler) Preconditions.checkNotNullFromProvides(ProcessModule.INSTANCE.provideAdbEnabler(context));
    }
}
