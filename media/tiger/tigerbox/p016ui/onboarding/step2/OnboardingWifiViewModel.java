package media.tiger.tigerbox.p016ui.onboarding.step2;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;

@Metadata(mo33736d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B?\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u0012\u001a\u00020\u0013XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/onboarding/step2/OnboardingWifiViewModel;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "storageProvider", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "infoSoundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "delayPeriodMillis", "", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "(Lkotlinx/coroutines/CoroutineScope;Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;JLmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "(Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;)V", "enforceInternetConnectionCheck", "", "getEnforceInternetConnectionCheck", "()Z", "continueAction", "", "setUpWifiManager", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel */
/* compiled from: OnboardingWifiViewModel.kt */
public final class OnboardingWifiViewModel extends WifiViewModel {
    private final boolean enforceInternetConnectionCheck;
    private final WifiService wifiService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public OnboardingWifiViewModel(WifiService wifiService2, StorageService storageService, InfoSoundService infoSoundService, ButtonService buttonService, ConfigurationProperties configurationProperties) {
        super(wifiService2, storageService, infoSoundService, buttonService, configurationProperties);
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(storageService, "storageProvider");
        Intrinsics.checkNotNullParameter(infoSoundService, "infoSoundService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        this.wifiService = wifiService2;
        this.enforceInternetConnectionCheck = true;
    }

    /* access modifiers changed from: protected */
    public boolean getEnforceInternetConnectionCheck() {
        return this.enforceInternetConnectionCheck;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OnboardingWifiViewModel(CoroutineScope coroutineScope, WifiService wifiService2, StorageService storageService, InfoSoundService infoSoundService, ButtonService buttonService, long j, ConfigurationProperties configurationProperties) {
        this(wifiService2, storageService, infoSoundService, buttonService, configurationProperties);
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(storageService, "storageProvider");
        Intrinsics.checkNotNullParameter(infoSoundService, "infoSoundService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        setDelayPeriodMillis(j);
        setCoroutineScope(coroutineScope);
    }

    public final void continueAction() {
        updateNavigationState(WifiViewModel.NavigationEvent.ShowUpdateScreen.INSTANCE);
    }

    public final void setUpWifiManager() {
        this.wifiService.setWifiEnabled(true);
    }
}
