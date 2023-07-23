package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.onboarding.step3.InstallFirmware;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideReadyToUpdateFactory */
public final class ServiceModule_ProvideReadyToUpdateFactory implements Factory<InstallFirmware> {
    private final Provider<Context> contextProvider;

    public ServiceModule_ProvideReadyToUpdateFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public InstallFirmware get() {
        return provideReadyToUpdate(this.contextProvider.get());
    }

    public static ServiceModule_ProvideReadyToUpdateFactory create(Provider<Context> provider) {
        return new ServiceModule_ProvideReadyToUpdateFactory(provider);
    }

    public static InstallFirmware provideReadyToUpdate(Context context) {
        return (InstallFirmware) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideReadyToUpdate(context));
    }
}
