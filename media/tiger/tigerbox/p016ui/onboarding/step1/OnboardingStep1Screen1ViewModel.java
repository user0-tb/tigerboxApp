package media.tiger.tigerbox.p016ui.onboarding.step1;

import androidx.lifecycle.LiveData;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.infrastructure.functional.SingleLiveEvent;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingViewModel;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;

@Metadata(mo33736d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0013R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel;", "Lmedia/tiger/tigerbox/ui/onboarding/OnboardingViewModel;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "infoSoundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/services/interfaces/WifiService;)V", "_navigationEvent", "Lmedia/tiger/tigerbox/infrastructure/functional/SingleLiveEvent;", "Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent;", "navigationEvent", "Landroidx/lifecycle/LiveData;", "getNavigationEvent", "()Landroidx/lifecycle/LiveData;", "onViewPrepared", "", "loggedOut", "", "showNextScreen", "NavigationEvent", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel */
/* compiled from: OnboardingStep1Screen1ViewModel.kt */
public final class OnboardingStep1Screen1ViewModel extends OnboardingViewModel {
    private final SingleLiveEvent<NavigationEvent> _navigationEvent;
    private final InfoSoundService infoSoundService;
    private final MetaDataService metaDataService;
    private final LiveData<NavigationEvent> navigationEvent;
    private final StorageService storageService;
    private final WifiService wifiService;

    @Inject
    public OnboardingStep1Screen1ViewModel(StorageService storageService2, MetaDataService metaDataService2, InfoSoundService infoSoundService2, WifiService wifiService2) {
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(infoSoundService2, "infoSoundService");
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        this.storageService = storageService2;
        this.metaDataService = metaDataService2;
        this.infoSoundService = infoSoundService2;
        this.wifiService = wifiService2;
        SingleLiveEvent<NavigationEvent> singleLiveEvent = new SingleLiveEvent<>();
        this._navigationEvent = singleLiveEvent;
        this.navigationEvent = singleLiveEvent;
    }

    public final LiveData<NavigationEvent> getNavigationEvent() {
        return this.navigationEvent;
    }

    public final void onViewPrepared(boolean z) {
        if (this.storageService.getGoToLogin()) {
            this._navigationEvent.postValue(NavigationEvent.NavigateToLogin.INSTANCE);
            return;
        }
        MetaDataService metaDataService2 = this.metaDataService;
        metaDataService2.setVolume((int) (((float) metaDataService2.getMaxVolume()) * 0.4f));
        this.wifiService.setWifiEnabled(true);
        if (!z) {
            this.wifiService.forgetAllNetworks();
            this.infoSoundService.playSound(InfoSoundService.SoundType.WELCOME);
        }
        this.wifiService.scanForWifiNetworks();
    }

    public final void showNextScreen() {
        this._navigationEvent.postValue(NavigationEvent.NavigateToNextOnboardingScreen.INSTANCE);
    }

    @Metadata(mo33736d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent;", "", "()V", "NavigateToLogin", "NavigateToMainContent", "NavigateToNextOnboardingScreen", "Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent$NavigateToNextOnboardingScreen;", "Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent$NavigateToMainContent;", "Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent$NavigateToLogin;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel$NavigationEvent */
    /* compiled from: OnboardingStep1Screen1ViewModel.kt */
    public static abstract class NavigationEvent {
        public /* synthetic */ NavigationEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent$NavigateToNextOnboardingScreen;", "Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel$NavigationEvent$NavigateToNextOnboardingScreen */
        /* compiled from: OnboardingStep1Screen1ViewModel.kt */
        public static final class NavigateToNextOnboardingScreen extends NavigationEvent {
            public static final NavigateToNextOnboardingScreen INSTANCE = new NavigateToNextOnboardingScreen();

            private NavigateToNextOnboardingScreen() {
                super((DefaultConstructorMarker) null);
            }
        }

        private NavigationEvent() {
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent$NavigateToMainContent;", "Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel$NavigationEvent$NavigateToMainContent */
        /* compiled from: OnboardingStep1Screen1ViewModel.kt */
        public static final class NavigateToMainContent extends NavigationEvent {
            public static final NavigateToMainContent INSTANCE = new NavigateToMainContent();

            private NavigateToMainContent() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo33736d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent$NavigateToLogin;", "Lmedia/tiger/tigerbox/ui/onboarding/step1/OnboardingStep1Screen1ViewModel$NavigationEvent;", "()V", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
        /* renamed from: media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel$NavigationEvent$NavigateToLogin */
        /* compiled from: OnboardingStep1Screen1ViewModel.kt */
        public static final class NavigateToLogin extends NavigationEvent {
            public static final NavigateToLogin INSTANCE = new NavigateToLogin();

            private NavigateToLogin() {
                super((DefaultConstructorMarker) null);
            }
        }
    }
}
