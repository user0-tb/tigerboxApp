package media.tiger.tigerbox.p016ui.onboarding.step1;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel_Factory */
public final class OnboardingStep1Screen1ViewModel_Factory implements Factory<OnboardingStep1Screen1ViewModel> {
    private final Provider<InfoSoundService> infoSoundServiceProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<WifiService> wifiServiceProvider;

    public OnboardingStep1Screen1ViewModel_Factory(Provider<StorageService> provider, Provider<MetaDataService> provider2, Provider<InfoSoundService> provider3, Provider<WifiService> provider4) {
        this.storageServiceProvider = provider;
        this.metaDataServiceProvider = provider2;
        this.infoSoundServiceProvider = provider3;
        this.wifiServiceProvider = provider4;
    }

    public OnboardingStep1Screen1ViewModel get() {
        return newInstance(this.storageServiceProvider.get(), this.metaDataServiceProvider.get(), this.infoSoundServiceProvider.get(), this.wifiServiceProvider.get());
    }

    public static OnboardingStep1Screen1ViewModel_Factory create(Provider<StorageService> provider, Provider<MetaDataService> provider2, Provider<InfoSoundService> provider3, Provider<WifiService> provider4) {
        return new OnboardingStep1Screen1ViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static OnboardingStep1Screen1ViewModel newInstance(StorageService storageService, MetaDataService metaDataService, InfoSoundService infoSoundService, WifiService wifiService) {
        return new OnboardingStep1Screen1ViewModel(storageService, metaDataService, infoSoundService, wifiService);
    }
}
