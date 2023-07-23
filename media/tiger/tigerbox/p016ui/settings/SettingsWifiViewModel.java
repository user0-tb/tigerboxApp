package media.tiger.tigerbox.p016ui.settings;

import androidx.lifecycle.ViewModelKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.usecase.ReportInformationRequestBody;
import media.tiger.tigerbox.usecase.ReportInformationUseCase;
import timber.log.Timber;

@Metadata(mo33736d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BG\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/settings/SettingsWifiViewModel;", "Lmedia/tiger/tigerbox/ui/common/wifi/WifiViewModel;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "infoSoundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "buttonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "reportInformationUseCase", "Lmedia/tiger/tigerbox/usecase/ReportInformationUseCase;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "(Lmedia/tiger/tigerbox/services/interfaces/WifiService;Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;Lmedia/tiger/tigerbox/services/implementations/ButtonService;Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;Lmedia/tiger/tigerbox/usecase/ReportInformationUseCase;Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;)V", "sendDeviceInformation", "", "wifiConnectionSuccessHandler", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.settings.SettingsWifiViewModel */
/* compiled from: SettingsWifiViewModel.kt */
public final class SettingsWifiViewModel extends WifiViewModel {
    private final TigerBoxAccountRepository accountRepository;
    private final InfoSoundService infoSoundService;
    private final MetaDataService metaDataService;
    private final ReportInformationUseCase reportInformationUseCase;
    private final StorageService storageService;
    private final WifiService wifiService;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SettingsWifiViewModel(WifiService wifiService2, StorageService storageService2, InfoSoundService infoSoundService2, ButtonService buttonService, ConfigurationProperties configurationProperties, MetaDataService metaDataService2, ReportInformationUseCase reportInformationUseCase2, TigerBoxAccountRepository tigerBoxAccountRepository) {
        super(wifiService2, storageService2, infoSoundService2, buttonService, configurationProperties);
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(infoSoundService2, "infoSoundService");
        Intrinsics.checkNotNullParameter(buttonService, "buttonService");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        Intrinsics.checkNotNullParameter(reportInformationUseCase2, "reportInformationUseCase");
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository, "accountRepository");
        this.wifiService = wifiService2;
        this.storageService = storageService2;
        this.infoSoundService = infoSoundService2;
        this.metaDataService = metaDataService2;
        this.reportInformationUseCase = reportInformationUseCase2;
        this.accountRepository = tigerBoxAccountRepository;
    }

    public final void sendDeviceInformation() {
        Timber.Forest.mo50221i("Wifi changed sendDeviceInformation", new Object[0]);
        this.reportInformationUseCase.invoke(new ReportInformationRequestBody(this.metaDataService.getCpuId(), this.metaDataService.getSerialNumber(), this.metaDataService.getFirmwareVersion(), this.metaDataService.getIpAddress()), ViewModelKt.getViewModelScope(this), SettingsWifiViewModel$sendDeviceInformation$1.INSTANCE);
    }

    public void wifiConnectionSuccessHandler() {
        super.wifiConnectionSuccessHandler();
        sendDeviceInformation();
    }
}
