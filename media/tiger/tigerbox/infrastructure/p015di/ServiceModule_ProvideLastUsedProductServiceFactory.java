package media.tiger.tigerbox.infrastructure.p015di;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.LastUsedProductService;
import media.tiger.tigerbox.usecase.ReportLastCardProductUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideLastUsedProductServiceFactory */
public final class ServiceModule_ProvideLastUsedProductServiceFactory implements Factory<LastUsedProductService> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<GetTigerBoxAccountUseCase> getTigerBoxAccountUseCaseProvider;
    private final Provider<ReportLastCardProductUseCase> reportLastCardProductUseCaseProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ServiceModule_ProvideLastUsedProductServiceFactory(Provider<AudioPlayerService> provider, Provider<SharedPreferences> provider2, Provider<StorageService> provider3, Provider<ReportLastCardProductUseCase> provider4, Provider<GetTigerBoxAccountUseCase> provider5) {
        this.audioPlayerServiceProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.storageServiceProvider = provider3;
        this.reportLastCardProductUseCaseProvider = provider4;
        this.getTigerBoxAccountUseCaseProvider = provider5;
    }

    public LastUsedProductService get() {
        return provideLastUsedProductService(this.audioPlayerServiceProvider.get(), this.sharedPreferencesProvider.get(), this.storageServiceProvider.get(), this.reportLastCardProductUseCaseProvider.get(), this.getTigerBoxAccountUseCaseProvider.get());
    }

    public static ServiceModule_ProvideLastUsedProductServiceFactory create(Provider<AudioPlayerService> provider, Provider<SharedPreferences> provider2, Provider<StorageService> provider3, Provider<ReportLastCardProductUseCase> provider4, Provider<GetTigerBoxAccountUseCase> provider5) {
        return new ServiceModule_ProvideLastUsedProductServiceFactory(provider, provider2, provider3, provider4, provider5);
    }

    public static LastUsedProductService provideLastUsedProductService(AudioPlayerService audioPlayerService, SharedPreferences sharedPreferences, StorageService storageService, ReportLastCardProductUseCase reportLastCardProductUseCase, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        return (LastUsedProductService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideLastUsedProductService(audioPlayerService, sharedPreferences, storageService, reportLastCardProductUseCase, getTigerBoxAccountUseCase));
    }
}
