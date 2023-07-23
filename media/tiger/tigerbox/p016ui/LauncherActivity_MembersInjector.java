package media.tiger.tigerbox.p016ui;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;

/* renamed from: media.tiger.tigerbox.ui.LauncherActivity_MembersInjector */
public final class LauncherActivity_MembersInjector implements MembersInjector<LauncherActivity> {
    private final Provider<InfoSoundService> infoSoundServiceProvider;

    public LauncherActivity_MembersInjector(Provider<InfoSoundService> provider) {
        this.infoSoundServiceProvider = provider;
    }

    public static MembersInjector<LauncherActivity> create(Provider<InfoSoundService> provider) {
        return new LauncherActivity_MembersInjector(provider);
    }

    public void injectMembers(LauncherActivity launcherActivity) {
        injectInfoSoundService(launcherActivity, this.infoSoundServiceProvider.get());
    }

    public static void injectInfoSoundService(LauncherActivity launcherActivity, InfoSoundService infoSoundService) {
        launcherActivity.infoSoundService = infoSoundService;
    }
}
