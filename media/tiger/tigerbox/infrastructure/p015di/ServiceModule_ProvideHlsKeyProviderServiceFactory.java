package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.HlsKeysRepository;
import media.tiger.tigerbox.services.interfaces.audioPlayer.HlsKeyProviderService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideHlsKeyProviderServiceFactory */
public final class ServiceModule_ProvideHlsKeyProviderServiceFactory implements Factory<HlsKeyProviderService> {
    private final Provider<HlsKeysRepository> hlsKeysRepositoryProvider;
    private final Provider<TigerBoxWebService> webServiceProvider;

    public ServiceModule_ProvideHlsKeyProviderServiceFactory(Provider<TigerBoxWebService> provider, Provider<HlsKeysRepository> provider2) {
        this.webServiceProvider = provider;
        this.hlsKeysRepositoryProvider = provider2;
    }

    public HlsKeyProviderService get() {
        return provideHlsKeyProviderService(this.webServiceProvider.get(), this.hlsKeysRepositoryProvider.get());
    }

    public static ServiceModule_ProvideHlsKeyProviderServiceFactory create(Provider<TigerBoxWebService> provider, Provider<HlsKeysRepository> provider2) {
        return new ServiceModule_ProvideHlsKeyProviderServiceFactory(provider, provider2);
    }

    public static HlsKeyProviderService provideHlsKeyProviderService(TigerBoxWebService tigerBoxWebService, HlsKeysRepository hlsKeysRepository) {
        return (HlsKeyProviderService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideHlsKeyProviderService(tigerBoxWebService, hlsKeysRepository));
    }
}
