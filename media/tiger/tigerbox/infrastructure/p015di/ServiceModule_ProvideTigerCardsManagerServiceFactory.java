package media.tiger.tigerbox.infrastructure.p015di;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.usecase.GetValidTigerCardUseCase;
import media.tiger.tigerbox.usecase.TigerTicketGetProductUseCase;
import media.tiger.tigerbox.usecase.WildCardReassignUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideTigerCardsManagerServiceFactory */
public final class ServiceModule_ProvideTigerCardsManagerServiceFactory implements Factory<TigerCardsManagerService> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<GetTigerBoxAccountUseCase> getTigerBoxAccountUseCaseProvider;
    private final Provider<NfcService> nfcServiceProvider;
    private final Provider<ProductAcquisitionService> productAcquisitionProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<TigerTicketGetProductUseCase> tigerTicketGetProductUseCaseProvider;
    private final Provider<GetValidTigerCardUseCase> validCardUseCaseProvider;
    private final Provider<WifiService> wifiServiceProvider;
    private final Provider<WildCardReassignUseCase> wildCardReassignUseCaseProvider;

    public ServiceModule_ProvideTigerCardsManagerServiceFactory(Provider<NfcService> provider, Provider<SharedPreferences> provider2, Provider<WifiService> provider3, Provider<GetTigerBoxAccountUseCase> provider4, Provider<AudioPlayerService> provider5, Provider<AvailabilityService> provider6, Provider<ProductAcquisitionService> provider7, Provider<GetValidTigerCardUseCase> provider8, Provider<TigerTicketGetProductUseCase> provider9, Provider<WildCardReassignUseCase> provider10) {
        this.nfcServiceProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.wifiServiceProvider = provider3;
        this.getTigerBoxAccountUseCaseProvider = provider4;
        this.audioPlayerServiceProvider = provider5;
        this.availabilityServiceProvider = provider6;
        this.productAcquisitionProvider = provider7;
        this.validCardUseCaseProvider = provider8;
        this.tigerTicketGetProductUseCaseProvider = provider9;
        this.wildCardReassignUseCaseProvider = provider10;
    }

    public TigerCardsManagerService get() {
        return provideTigerCardsManagerService(this.nfcServiceProvider.get(), this.sharedPreferencesProvider.get(), this.wifiServiceProvider.get(), this.getTigerBoxAccountUseCaseProvider.get(), this.audioPlayerServiceProvider.get(), this.availabilityServiceProvider.get(), this.productAcquisitionProvider.get(), this.validCardUseCaseProvider.get(), this.tigerTicketGetProductUseCaseProvider.get(), this.wildCardReassignUseCaseProvider.get());
    }

    public static ServiceModule_ProvideTigerCardsManagerServiceFactory create(Provider<NfcService> provider, Provider<SharedPreferences> provider2, Provider<WifiService> provider3, Provider<GetTigerBoxAccountUseCase> provider4, Provider<AudioPlayerService> provider5, Provider<AvailabilityService> provider6, Provider<ProductAcquisitionService> provider7, Provider<GetValidTigerCardUseCase> provider8, Provider<TigerTicketGetProductUseCase> provider9, Provider<WildCardReassignUseCase> provider10) {
        return new ServiceModule_ProvideTigerCardsManagerServiceFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static TigerCardsManagerService provideTigerCardsManagerService(NfcService nfcService, SharedPreferences sharedPreferences, WifiService wifiService, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase, AudioPlayerService audioPlayerService, AvailabilityService availabilityService, ProductAcquisitionService productAcquisitionService, GetValidTigerCardUseCase getValidTigerCardUseCase, TigerTicketGetProductUseCase tigerTicketGetProductUseCase, WildCardReassignUseCase wildCardReassignUseCase) {
        return (TigerCardsManagerService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideTigerCardsManagerService(nfcService, sharedPreferences, wifiService, getTigerBoxAccountUseCase, audioPlayerService, availabilityService, productAcquisitionService, getValidTigerCardUseCase, tigerTicketGetProductUseCase, wildCardReassignUseCase));
    }
}
