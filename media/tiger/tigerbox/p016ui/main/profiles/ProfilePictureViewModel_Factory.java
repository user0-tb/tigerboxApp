package media.tiger.tigerbox.p016ui.main.profiles;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;

/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel_Factory */
public final class ProfilePictureViewModel_Factory implements Factory<ProfilePictureViewModel> {
    private final Provider<LightControlService> _lightControlProvider;
    private final Provider<TigerBoxAccountRepository> accountRepositoryProvider;
    private final Provider<ButtonService> buttonServiceProvider;
    private final Provider<HeaderProvider> headerProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;

    public ProfilePictureViewModel_Factory(Provider<TigerBoxAccountRepository> provider, Provider<MetaDataService> provider2, Provider<ButtonService> provider3, Provider<HeaderProvider> provider4, Provider<LightControlService> provider5) {
        this.accountRepositoryProvider = provider;
        this.metaDataServiceProvider = provider2;
        this.buttonServiceProvider = provider3;
        this.headerProvider = provider4;
        this._lightControlProvider = provider5;
    }

    public ProfilePictureViewModel get() {
        ProfilePictureViewModel newInstance = newInstance(this.accountRepositoryProvider.get(), this.metaDataServiceProvider.get(), this.buttonServiceProvider.get(), this.headerProvider.get());
        BaseViewModel_MembersInjector.inject_lightControl(newInstance, this._lightControlProvider.get());
        return newInstance;
    }

    public static ProfilePictureViewModel_Factory create(Provider<TigerBoxAccountRepository> provider, Provider<MetaDataService> provider2, Provider<ButtonService> provider3, Provider<HeaderProvider> provider4, Provider<LightControlService> provider5) {
        return new ProfilePictureViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ProfilePictureViewModel newInstance(TigerBoxAccountRepository tigerBoxAccountRepository, MetaDataService metaDataService, ButtonService buttonService, HeaderProvider headerProvider2) {
        return new ProfilePictureViewModel(tigerBoxAccountRepository, metaDataService, buttonService, headerProvider2);
    }
}
