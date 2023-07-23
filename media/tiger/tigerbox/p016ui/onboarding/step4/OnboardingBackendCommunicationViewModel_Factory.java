package media.tiger.tigerbox.p016ui.onboarding.step4;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.AssignBoxToAccountUseCase;
import media.tiger.tigerbox.usecase.OnboardingCompleteActionUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.FetchAndStoreAccessTokenUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.FetchAccountInfoUseCase;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationViewModel_Factory */
public final class OnboardingBackendCommunicationViewModel_Factory implements Factory<OnboardingBackendCommunicationViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<AssignBoxToAccountUseCase> assignBoxToAccountUseCaseProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<FetchAndStoreAccessTokenUseCase> fetchAndStoreAccessTokenUseCaseProvider;
    private final Provider<FetchAccountInfoUseCase> getLoggedAccountInfoUseCaseProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<OnboardingCompleteActionUseCase> onboardingCompleteActionUseCaseProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<TigerBoxAccountRepository> tigerBoxAccountRepositoryProvider;

    public OnboardingBackendCommunicationViewModel_Factory(Provider<FetchAndStoreAccessTokenUseCase> provider, Provider<FetchAccountInfoUseCase> provider2, Provider<AssignBoxToAccountUseCase> provider3, Provider<TigerBoxAccountRepository> provider4, Provider<StorageService> provider5, Provider<MetaDataService> provider6, Provider<ConfigurationProperties> provider7, Provider<OnboardingCompleteActionUseCase> provider8, Provider<LightControlService> provider9) {
        this.fetchAndStoreAccessTokenUseCaseProvider = provider;
        this.getLoggedAccountInfoUseCaseProvider = provider2;
        this.assignBoxToAccountUseCaseProvider = provider3;
        this.tigerBoxAccountRepositoryProvider = provider4;
        this.storageServiceProvider = provider5;
        this.metaDataServiceProvider = provider6;
        this.configurationPropertiesProvider = provider7;
        this.onboardingCompleteActionUseCaseProvider = provider8;
        this._lightControlProvider = provider9;
    }

    public OnboardingBackendCommunicationViewModel get() {
        OnboardingBackendCommunicationViewModel newInstance = newInstance(this.fetchAndStoreAccessTokenUseCaseProvider.get(), this.getLoggedAccountInfoUseCaseProvider.get(), this.assignBoxToAccountUseCaseProvider.get(), this.tigerBoxAccountRepositoryProvider.get(), this.storageServiceProvider.get(), this.metaDataServiceProvider.get(), this.configurationPropertiesProvider.get(), this.onboardingCompleteActionUseCaseProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static OnboardingBackendCommunicationViewModel_Factory create(Provider<FetchAndStoreAccessTokenUseCase> provider, Provider<FetchAccountInfoUseCase> provider2, Provider<AssignBoxToAccountUseCase> provider3, Provider<TigerBoxAccountRepository> provider4, Provider<StorageService> provider5, Provider<MetaDataService> provider6, Provider<ConfigurationProperties> provider7, Provider<OnboardingCompleteActionUseCase> provider8, Provider<LightControlService> provider9) {
        return new OnboardingBackendCommunicationViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static OnboardingBackendCommunicationViewModel newInstance(FetchAndStoreAccessTokenUseCase fetchAndStoreAccessTokenUseCase, FetchAccountInfoUseCase fetchAccountInfoUseCase, AssignBoxToAccountUseCase assignBoxToAccountUseCase, TigerBoxAccountRepository tigerBoxAccountRepository, StorageService storageService, MetaDataService metaDataService, ConfigurationProperties configurationProperties, OnboardingCompleteActionUseCase onboardingCompleteActionUseCase) {
        return new OnboardingBackendCommunicationViewModel(fetchAndStoreAccessTokenUseCase, fetchAccountInfoUseCase, assignBoxToAccountUseCase, tigerBoxAccountRepository, storageService, metaDataService, configurationProperties, onboardingCompleteActionUseCase);
    }
}
