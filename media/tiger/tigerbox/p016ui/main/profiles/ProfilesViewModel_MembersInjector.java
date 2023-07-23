package media.tiger.tigerbox.p016ui.main.profiles;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel_MembersInjector */
public final class ProfilesViewModel_MembersInjector implements MembersInjector<ProfilesViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public ProfilesViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<ProfilesViewModel> create(Provider<LightControlService> provider) {
        return new ProfilesViewModel_MembersInjector(provider);
    }

    public void injectMembers(ProfilesViewModel profilesViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(profilesViewModel, this._lightControlProvider.get());
    }
}
