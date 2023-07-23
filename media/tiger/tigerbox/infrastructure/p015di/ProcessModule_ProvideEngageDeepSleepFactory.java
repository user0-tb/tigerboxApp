package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.EngageDeepSleep;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideEngageDeepSleepFactory */
public final class ProcessModule_ProvideEngageDeepSleepFactory implements Factory<EngageDeepSleep> {
    private final Provider<Context> contextProvider;

    public ProcessModule_ProvideEngageDeepSleepFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public EngageDeepSleep get() {
        return provideEngageDeepSleep(this.contextProvider.get());
    }

    public static ProcessModule_ProvideEngageDeepSleepFactory create(Provider<Context> provider) {
        return new ProcessModule_ProvideEngageDeepSleepFactory(provider);
    }

    public static EngageDeepSleep provideEngageDeepSleep(Context context) {
        return (EngageDeepSleep) Preconditions.checkNotNullFromProvides(ProcessModule.INSTANCE.provideEngageDeepSleep(context));
    }
}
