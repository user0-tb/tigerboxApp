package media.tiger.tigerbox.p016ui.onboarding;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.TigerBoxActivity_MembersInjector;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.OnboardingActivity_MembersInjector */
public final class OnboardingActivity_MembersInjector implements MembersInjector<OnboardingActivity> {
    private final Provider<AudioPlayerService> audioPlayerServiceProvider;
    private final Provider<NfcService> nfcServiceProvider;

    public OnboardingActivity_MembersInjector(Provider<NfcService> provider, Provider<AudioPlayerService> provider2) {
        this.nfcServiceProvider = provider;
        this.audioPlayerServiceProvider = provider2;
    }

    public static MembersInjector<OnboardingActivity> create(Provider<NfcService> provider, Provider<AudioPlayerService> provider2) {
        return new OnboardingActivity_MembersInjector(provider, provider2);
    }

    public void injectMembers(OnboardingActivity onboardingActivity) {
        TigerBoxActivity_MembersInjector.injectNfcService(onboardingActivity, this.nfcServiceProvider.get());
        injectAudioPlayerService(onboardingActivity, this.audioPlayerServiceProvider.get());
    }

    public static void injectAudioPlayerService(OnboardingActivity onboardingActivity, AudioPlayerService audioPlayerService) {
        onboardingActivity.audioPlayerService = audioPlayerService;
    }
}
