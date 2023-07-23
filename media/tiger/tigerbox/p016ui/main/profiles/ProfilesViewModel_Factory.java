package media.tiger.tigerbox.p016ui.main.profiles;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase;

/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel_Factory */
public final class ProfilesViewModel_Factory implements Factory<ProfilesViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<AssignProfileToAccountUseCase> assignProfileToAccountUseCaseProvider;
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ProfilesViewModel_Factory(Provider<StorageService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<AssignProfileToAccountUseCase> provider3, Provider<AudioPlayerService> provider4, Provider<ButtonService> provider5, Provider<HeaderProvider> provider6, Provider<LightControlService> provider7) {
        this.storageServiceProvider = provider;
        this.accountRepositoryProvider = provider2;
        this.assignProfileToAccountUseCaseProvider = provider3;
        this.audioPlayerServiceProvider = provider4;
        this.buttonServiceProvider = provider5;
        this.headerProvider = provider6;
        this._lightControlProvider = provider7;
    }

    public ProfilesViewModel get() {
        ProfilesViewModel newInstance = newInstance(this.storageServiceProvider.get(), this.accountRepositoryProvider.get(), this.assignProfileToAccountUseCaseProvider.get(), this.audioPlayerServiceProvider.get(), this.buttonServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static ProfilesViewModel_Factory create(Provider<StorageService> provider, Provider<TigerBoxAccountRepository> provider2, Provider<AssignProfileToAccountUseCase> provider3, Provider<AudioPlayerService> provider4, Provider<ButtonService> provider5, Provider<HeaderProvider> provider6, Provider<LightControlService> provider7) {
        return new ProfilesViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static ProfilesViewModel newInstance(StorageService storageService, TigerBoxAccountRepository tigerBoxAccountRepository, AssignProfileToAccountUseCase assignProfileToAccountUseCase, AudioPlayerService audioPlayerService, ButtonService buttonService, HeaderProvider headerProvider2) {
        return new ProfilesViewModel(storageService, tigerBoxAccountRepository, assignProfileToAccountUseCase, audioPlayerService, buttonService, headerProvider2);
    }
}
