package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.InitServices;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideInitServicesFactory */
public final class ProcessModule_ProvideInitServicesFactory implements Factory<InitServices> {
    private final Provider<Context> contextProvider;
    private final Provider<PowerManagementService> powerManagementServiceProvider;

    public ProcessModule_ProvideInitServicesFactory(Provider<Context> provider, Provider<PowerManagementService> provider2) {
        this.contextProvider = provider;
        this.powerManagementServiceProvider = provider2;
    }

    public InitServices get() {
        return provideInitServices(this.contextProvider.get(), this.powerManagementServiceProvider.get());
    }

    public static ProcessModule_ProvideInitServicesFactory create(Provider<Context> provider, Provider<PowerManagementService> provider2) {
        return new ProcessModule_ProvideInitServicesFactory(provider, provider2);
    }

    public static InitServices provideInitServices(Context context, PowerManagementService powerManagementService) {
        return (InitServices) Preconditions.checkNotNullFromProvides(ProcessModule.INSTANCE.provideInitServices(context, powerManagementService));
    }
}
