package media.tiger.tigerbox.p016ui.main.profiles;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel_MembersInjector */
public final class ProfilePictureViewModel_MembersInjector implements MembersInjector<ProfilePictureViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public ProfilePictureViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<ProfilePictureViewModel> create(Provider<LightControlService> provider) {
        return new ProfilePictureViewModel_MembersInjector(provider);
    }

    public void injectMembers(ProfilePictureViewModel profilePictureViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(profilePictureViewModel, this._lightControlProvider.get());
    }
}
