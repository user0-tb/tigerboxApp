package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import android.media.AudioManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.HlsKeyProviderService;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideAudioPlayerServiceFactory */
public final class ServiceModule_ProvideAudioPlayerServiceFactory implements Factory<AudioPlayerService> {
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<ProductAcquisitionService> acquisitionServiceProvider;
    private final Provider<AudioManager> audioManagerProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<Context> contextProvider;
    private final Provider<HlsKeyProviderService> hlsServiceProvider;
    private final Provider<LockedModeService> lockedModeServiceProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ServiceModule_ProvideAudioPlayerServiceFactory(Provider<Context> provider, Provider<HlsKeyProviderService> provider2, Provider<StorageService> provider3, Provider<AvailabilityService> provider4, Provider<ProductAcquisitionService> provider5, Provider<AudioManager> provider6, Provider<TigerBoxAccountRepository> provider7, Provider<LockedModeService> provider8) {
        this.contextProvider = provider;
        this.hlsServiceProvider = provider2;
        this.storageServiceProvider = provider3;
        this.availabilityServiceProvider = provider4;
        this.acquisitionServiceProvider = provider5;
        this.audioManagerProvider = provider6;
        this.accountRepositoryProvider = provider7;
        this.lockedModeServiceProvider = provider8;
    }

    public AudioPlayerService get() {
        return provideAudioPlayerService(this.contextProvider.get(), this.hlsServiceProvider.get(), this.storageServiceProvider.get(), this.availabilityServiceProvider.get(), this.acquisitionServiceProvider.get(), this.audioManagerProvider.get(), this.accountRepositoryProvider.get(), this.lockedModeServiceProvider.get());
    }

    public static ServiceModule_ProvideAudioPlayerServiceFactory create(Provider<Context> provider, Provider<HlsKeyProviderService> provider2, Provider<StorageService> provider3, Provider<AvailabilityService> provider4, Provider<ProductAcquisitionService> provider5, Provider<AudioManager> provider6, Provider<TigerBoxAccountRepository> provider7, Provider<LockedModeService> provider8) {
        return new ServiceModule_ProvideAudioPlayerServiceFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static AudioPlayerService provideAudioPlayerService(Context context, HlsKeyProviderService hlsKeyProviderService, StorageService storageService, AvailabilityService availabilityService, ProductAcquisitionService productAcquisitionService, AudioManager audioManager, TigerBoxAccountRepository tigerBoxAccountRepository, LockedModeService lockedModeService) {
        return (AudioPlayerService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideAudioPlayerService(context, hlsKeyProviderService, storageService, availabilityService, productAcquisitionService, audioManager, tigerBoxAccountRepository, lockedModeService));
    }
}
