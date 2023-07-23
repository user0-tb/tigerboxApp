package media.tiger.tigerbox.infrastructure.p015di;

import android.app.AlarmManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.os.PowerManager;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.TigerBoxLogTree;
import media.tiger.tigerbox.WriteToFileExceptionHandler;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.network.DownloadsWebService;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.HlsKeysRepository;
import media.tiger.tigerbox.data.repository.PlaybackPositionsRepository;
import media.tiger.tigerbox.data.repository.PlaybackTrackingRepository;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.infrastructure.properties.AndroidSystemProperties;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.main.update.UpdateCheck;
import media.tiger.tigerbox.p016ui.onboarding.step2.RequiresUpdate;
import media.tiger.tigerbox.p016ui.onboarding.step3.InstallFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.AndroidBase64Converter;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.Base64Converter;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DownloadFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature;
import media.tiger.tigerbox.services.implementations.AccountSubscription;
import media.tiger.tigerbox.services.implementations.AndroidAssetService;
import media.tiger.tigerbox.services.implementations.Availability;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.implementations.DataMigrationServiceImpl;
import media.tiger.tigerbox.services.implementations.DeepSleepTimerService;
import media.tiger.tigerbox.services.implementations.DeviceWakeService;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.implementations.FirmwareUpdate;
import media.tiger.tigerbox.services.implementations.HardwareBatteryService;
import media.tiger.tigerbox.services.implementations.HardwareNfcService;
import media.tiger.tigerbox.services.implementations.HardwareSafeguardService;
import media.tiger.tigerbox.services.implementations.HardwareWifiService;
import media.tiger.tigerbox.services.implementations.HeaderBarProvider;
import media.tiger.tigerbox.services.implementations.HeadsetService;
import media.tiger.tigerbox.services.implementations.InfoSoundPlayer;
import media.tiger.tigerbox.services.implementations.InstallTigerBoxFirmware;
import media.tiger.tigerbox.services.implementations.LightControl;
import media.tiger.tigerbox.services.implementations.NightLightTimer;
import media.tiger.tigerbox.services.implementations.PendingIntentFactory;
import media.tiger.tigerbox.services.implementations.PowerManagement;
import media.tiger.tigerbox.services.implementations.ProductAcquisition;
import media.tiger.tigerbox.services.implementations.TigerBoxMetaDataService;
import media.tiger.tigerbox.services.implementations.TigerCardsManager;
import media.tiger.tigerbox.services.implementations.UpdateCheckTimer;
import media.tiger.tigerbox.services.implementations.audioPlayer.AudioPlayer;
import media.tiger.tigerbox.services.implementations.audioPlayer.HlsKeyProvider;
import media.tiger.tigerbox.services.implementations.audioPlayer.LastUsedProduct;
import media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackPosition;
import media.tiger.tigerbox.services.implementations.audioPlayer.PlaybackTracking;
import media.tiger.tigerbox.services.implementations.downloadsManager.DownloadsManager;
import media.tiger.tigerbox.services.implementations.timersController.LockedMode;
import media.tiger.tigerbox.services.implementations.timersController.ShutDownTimer;
import media.tiger.tigerbox.services.implementations.timersController.TimeLimitTimer;
import media.tiger.tigerbox.services.implementations.timersController.TimersController;
import media.tiger.tigerbox.services.implementations.timersController.WindowedLimitTimer;
import media.tiger.tigerbox.services.interfaces.AccountSubscriptionService;
import media.tiger.tigerbox.services.interfaces.AssetService;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.DataMigrationService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.InfoSoundService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.NfcService;
import media.tiger.tigerbox.services.interfaces.NightLightTimerService;
import media.tiger.tigerbox.services.interfaces.PowerManagementService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.SafeguardService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.TigerCardsManagerService;
import media.tiger.tigerbox.services.interfaces.TimeService;
import media.tiger.tigerbox.services.interfaces.UpdateCheckTimerService;
import media.tiger.tigerbox.services.interfaces.WakeService;
import media.tiger.tigerbox.services.interfaces.WifiService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.HlsKeyProviderService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.LastUsedProductService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackPositionService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.PlaybackTrackingService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.services.interfaces.timersController.LockedModeService;
import media.tiger.tigerbox.services.interfaces.timersController.ShutDownTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimeLimitTimerService;
import media.tiger.tigerbox.services.interfaces.timersController.TimersControllerService;
import media.tiger.tigerbox.services.interfaces.timersController.WindowedLimitTimeService;
import media.tiger.tigerbox.usecase.CheckAcquisitionsUseCase;
import media.tiger.tigerbox.usecase.CheckForUpdateUseCase;
import media.tiger.tigerbox.usecase.GetPlayStatesUseCase;
import media.tiger.tigerbox.usecase.GetProductAssetsUseCase;
import media.tiger.tigerbox.usecase.GetProductDetailsUseCase;
import media.tiger.tigerbox.usecase.GetSubscriptionsUseCase;
import media.tiger.tigerbox.usecase.GetValidTigerCardUseCase;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;
import media.tiger.tigerbox.usecase.PostPlayStateUseCase;
import media.tiger.tigerbox.usecase.PostTrackingEventUseCase;
import media.tiger.tigerbox.usecase.ReportInformationUseCase;
import media.tiger.tigerbox.usecase.ReportLastCardProductUseCase;
import media.tiger.tigerbox.usecase.RequestAcquisitionUseCase;
import media.tiger.tigerbox.usecase.TigerTicketGetProductUseCase;
import media.tiger.tigerbox.usecase.WildCardReassignUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import media.tiger.tigerbox.utils.FileUtils;

@Metadata(mo33736d1 = {"\u0000ò\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007JJ\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007JH\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0007J\b\u0010*\u001a\u00020+H\u0007J*\u0010,\u001a\u00020-2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020%2\u0006\u00100\u001a\u000201H\u0007J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0007J\b\u00106\u001a\u000201H\u0007J\"\u00107\u001a\u00020!2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0007Jr\u0010:\u001a\u00020;2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010<\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010=\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0007JP\u0010L\u001a\u00020M2\u0006\u0010\"\u001a\u00020#2\u0006\u0010<\u001a\u00020-2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020/2\u0006\u0010U\u001a\u00020\u00102\u0006\u0010V\u001a\u00020;H\u0007J\b\u0010W\u001a\u00020XH\u0007J\u0018\u0010Y\u001a\u00020\u00122\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]H\u0007J\u001a\u0010^\u001a\u00020/2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J0\u0010_\u001a\u00020`2\u0006\u0010U\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010a\u001a\u00020b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010c\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0018\u0010d\u001a\u00020\u001e2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0007J\u0001\u0010i\u001a\u00020S2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010<\u001a\u00020-2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010j\u001a\u00020k2\u0006\u0010$\u001a\u00020%2\u0006\u0010U\u001a\u00020\u00102\u0006\u0010l\u001a\u00020m2\u0006\u0010N\u001a\u00020O2\u0006\u0010n\u001a\u00020Q2\u0006\u0010o\u001a\u00020'2\u0006\u0010T\u001a\u00020/2\u0006\u0010p\u001a\u00020q2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020\b2\u0006\u0010u\u001a\u00020vH\u0007J\u0010\u0010w\u001a\u00020x2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J2\u0010y\u001a\u00020k2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010z\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010{\u001a\u00020|H\u0007J5\u0010}\u001a\u00020~2\u0006\u0010U\u001a\u00020\u00102\u0007\u0010\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J>\u0010\u0001\u001a\u00030\u00012\u0006\u0010U\u001a\u00020\u00102\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J5\u0010\u0001\u001a\u00020m2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u00100\u001a\u0002012\u0006\u0010<\u001a\u00020-2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010U\u001a\u00020\u0010H\u0007JR\u0010\u0001\u001a\u00020\u00182\u0007\u0010\u0001\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0013\u0010\u0001\u001a\u00020G2\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\u0019\u0010\u0001\u001a\u00020K2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010H\u001a\u00020IH\u0007J\u0013\u0010\u0001\u001a\u0002052\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0007J\u0019\u0010\u0001\u001a\u00020O2\u0006\u0010l\u001a\u00020m2\u0006\u0010U\u001a\u00020\u0010H\u0007J,\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010R\u001a\u00020S2\u0006\u0010H\u001a\u00020IH\u0007Jb\u0010 \u0001\u001a\u00030¡\u00012\u0007\u0010¢\u0001\u001a\u00020x2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0007\u0010£\u0001\u001a\u00020\u00182\b\u0010¤\u0001\u001a\u00030¥\u00012\b\u0010¦\u0001\u001a\u00030§\u00012\b\u0010¨\u0001\u001a\u00030©\u0001H\u0007J3\u0010ª\u0001\u001a\u00020f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010{\u001a\u00020|2\u0006\u0010H\u001a\u00020IH\u0007J\t\u0010«\u0001\u001a\u00020'H\u0007J)\u0010¬\u0001\u001a\u00020Q2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010U\u001a\u00020\u00102\u0006\u00100\u001a\u000201H\u0007J,\u0010­\u0001\u001a\u00030®\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010R\u001a\u00020S2\b\u0010¯\u0001\u001a\u00030°\u00012\u0006\u0010H\u001a\u00020IH\u0007J4\u0010±\u0001\u001a\u00030²\u00012\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010{\u001a\u00020|2\u0006\u0010V\u001a\u00020;2\u0006\u0010H\u001a\u00020IH\u0007J\u0013\u0010³\u0001\u001a\u00020)2\b\u0010´\u0001\u001a\u00030µ\u0001H\u0007J\u001b\u0010¶\u0001\u001a\u00020#2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020IH\u0007J+\u0010·\u0001\u001a\u00020h2\b\b\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'2\u0006\u0010{\u001a\u00020|H\u0007J$\u0010¸\u0001\u001a\u00030¹\u00012\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010R\u001a\u00020SH\u0007¨\u0006º\u0001"}, mo33737d2 = {"Lmedia/tiger/tigerbox/infrastructure/di/ServiceModule;", "", "()V", "provideAccountSubscriptionService", "Lmedia/tiger/tigerbox/services/interfaces/AccountSubscriptionService;", "getTigerBoxAccountUseCase", "Lmedia/tiger/tigerbox/usecase/tigerboxuserrepo/GetTigerBoxAccountUseCase;", "sharedPreferences", "Landroid/content/SharedPreferences;", "subscriptionsUseCase", "Lmedia/tiger/tigerbox/usecase/GetSubscriptionsUseCase;", "provideAssetService", "Lmedia/tiger/tigerbox/services/interfaces/AssetService;", "context", "Landroid/content/Context;", "provideAudioPlayerService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/AudioPlayerService;", "hlsService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/HlsKeyProviderService;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "availabilityService", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityService;", "acquisitionService", "Lmedia/tiger/tigerbox/services/interfaces/ProductAcquisitionService;", "audioManager", "Landroid/media/AudioManager;", "accountRepository", "Lmedia/tiger/tigerbox/data/repository/TigerBoxAccountRepository;", "lockedModeService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/LockedModeService;", "provideAvailabilityService", "dlService", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerService;", "wifiService", "Lmedia/tiger/tigerbox/services/interfaces/WifiService;", "lightControlService", "Lmedia/tiger/tigerbox/services/interfaces/LightControlService;", "timeService", "Lmedia/tiger/tigerbox/services/interfaces/TimeService;", "wakeService", "Lmedia/tiger/tigerbox/services/interfaces/WakeService;", "provideBase64Converter", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/Base64Converter;", "provideBatteryService", "Lmedia/tiger/tigerbox/services/interfaces/BatteryService;", "soundService", "Lmedia/tiger/tigerbox/services/interfaces/InfoSoundService;", "displayService", "Lmedia/tiger/tigerbox/services/implementations/DisplayService;", "provideButtonService", "Lmedia/tiger/tigerbox/services/implementations/ButtonService;", "safeguardService", "Lmedia/tiger/tigerbox/services/interfaces/SafeguardService;", "provideDisplayService", "provideDownloadsManagerService", "webDlService", "Lmedia/tiger/tigerbox/data/network/DownloadsWebService;", "provideFirmwareUpdateService", "Lmedia/tiger/tigerbox/services/interfaces/FirmwareUpdateService;", "batteryService", "audioService", "checkForUpdateUseCase", "Lmedia/tiger/tigerbox/usecase/CheckForUpdateUseCase;", "validateUpdateSignature", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/ValidateUpdateSignature;", "downloadFirmware", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DownloadFirmware;", "decryptFirmware", "Lmedia/tiger/tigerbox/ui/onboarding/step3/security/DecryptFirmware;", "installFirmware", "Lmedia/tiger/tigerbox/ui/onboarding/step3/InstallFirmware;", "configurationProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/ConfigurationProperties;", "requiresUpdate", "Lmedia/tiger/tigerbox/ui/onboarding/step2/RequiresUpdate;", "provideHeaderBar", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "shutDownTimerService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/ShutDownTimerService;", "timersControllerService", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimersControllerService;", "metaDataService", "Lmedia/tiger/tigerbox/services/interfaces/MetaDataService;", "infoSoundService", "audioPlayerService", "firmwareUpdateService", "provideHeadsetService", "Lmedia/tiger/tigerbox/services/implementations/HeadsetService;", "provideHlsKeyProviderService", "webService", "Lmedia/tiger/tigerbox/data/network/TigerBoxWebService;", "hlsKeysRepository", "Lmedia/tiger/tigerbox/data/repository/HlsKeysRepository;", "provideInfoSoundService", "provideLastUsedProductService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/LastUsedProductService;", "reportLastCardProductUseCase", "Lmedia/tiger/tigerbox/usecase/ReportLastCardProductUseCase;", "provideLightControlService", "provideLockedMode", "timeLimitTimer", "Lmedia/tiger/tigerbox/services/interfaces/timersController/TimeLimitTimerService;", "windowedLimit", "Lmedia/tiger/tigerbox/services/interfaces/timersController/WindowedLimitTimeService;", "provideMetaDataService", "nightLightTimerService", "Lmedia/tiger/tigerbox/services/interfaces/NightLightTimerService;", "powerManagementService", "Lmedia/tiger/tigerbox/services/interfaces/PowerManagementService;", "timersController", "systemTimeService", "systemProperties", "Lmedia/tiger/tigerbox/infrastructure/properties/AndroidSystemProperties;", "provideMigrationService", "Lmedia/tiger/tigerbox/services/interfaces/DataMigrationService;", "encryptedSharedPreferences", "tigerBoxDatabase", "Lmedia/tiger/tigerbox/data/database/TigerBoxDatabase;", "provideNfcService", "Lmedia/tiger/tigerbox/services/interfaces/NfcService;", "provideNightLightTimerService", "lightControl", "alarmManager", "Landroid/app/AlarmManager;", "providePlaybackPositionService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/PlaybackPositionService;", "playbackPositionsRepository", "Lmedia/tiger/tigerbox/data/repository/PlaybackPositionsRepository;", "getPlayStatesUseCase", "Lmedia/tiger/tigerbox/usecase/GetPlayStatesUseCase;", "postPlayStateUseCase", "Lmedia/tiger/tigerbox/usecase/PostPlayStateUseCase;", "providePlaybackTrackingService", "Lmedia/tiger/tigerbox/services/interfaces/audioPlayer/PlaybackTrackingService;", "playbackTrackingRepository", "Lmedia/tiger/tigerbox/data/repository/PlaybackTrackingRepository;", "postTrackingEventUseCase", "Lmedia/tiger/tigerbox/usecase/PostTrackingEventUseCase;", "providePowerManagementService", "deepSleepTimerService", "Lmedia/tiger/tigerbox/services/implementations/DeepSleepTimerService;", "provideProductAcquisitionService", "dlManagerService", "getProductAssetsUseCase", "Lmedia/tiger/tigerbox/usecase/GetProductAssetsUseCase;", "getProductDetailsUseCase", "Lmedia/tiger/tigerbox/usecase/GetProductDetailsUseCase;", "requestAcquisitionUseCase", "Lmedia/tiger/tigerbox/usecase/RequestAcquisitionUseCase;", "checkAcquisitionsUseCase", "Lmedia/tiger/tigerbox/usecase/CheckAcquisitionsUseCase;", "provideReadyToUpdate", "provideRequiresUpdate", "provideSafeguardService", "provideSleepTimerService", "provideTigerBoxLogTree", "Lmedia/tiger/tigerbox/TigerBoxLogTree;", "postLogsUseCase", "Lmedia/tiger/tigerbox/usecase/PostCrashLogsUseCase;", "provideTigerCardsManagerService", "Lmedia/tiger/tigerbox/services/interfaces/TigerCardsManagerService;", "nfcService", "productAcquisition", "validCardUseCase", "Lmedia/tiger/tigerbox/usecase/GetValidTigerCardUseCase;", "tigerTicketGetProductUseCase", "Lmedia/tiger/tigerbox/usecase/TigerTicketGetProductUseCase;", "wildCardReassignUseCase", "Lmedia/tiger/tigerbox/usecase/WildCardReassignUseCase;", "provideTimeLimitTimerService", "provideTimeService", "provideTimersController", "provideUpdateCheck", "Lmedia/tiger/tigerbox/ui/main/update/UpdateCheck;", "reportSuccessfulUpdate", "Lmedia/tiger/tigerbox/usecase/ReportInformationUseCase;", "provideUpdateCheckTimer", "Lmedia/tiger/tigerbox/services/interfaces/UpdateCheckTimerService;", "provideWakeService", "powerManager", "Landroid/os/PowerManager;", "provideWifiService", "provideWindowedLimitTimerService", "provideWriteToFileExceptionHandler", "Lmedia/tiger/tigerbox/WriteToFileExceptionHandler;", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
@Module
/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule */
/* compiled from: ServiceModule.kt */
public final class ServiceModule {
    public static final ServiceModule INSTANCE = new ServiceModule();

    private ServiceModule() {
    }

    @Singleton
    @Provides
    public final LightControlService provideLightControlService(StorageService storageService) {
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        return new LightControl(storageService, FileUtils.INSTANCE);
    }

    @Provides
    public final AccountSubscriptionService provideAccountSubscriptionService(GetTigerBoxAccountUseCase getTigerBoxAccountUseCase, SharedPreferences sharedPreferences, GetSubscriptionsUseCase getSubscriptionsUseCase) {
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase, "getTigerBoxAccountUseCase");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(getSubscriptionsUseCase, "subscriptionsUseCase");
        return new AccountSubscription(getTigerBoxAccountUseCase, sharedPreferences, getSubscriptionsUseCase);
    }

    @Singleton
    @Provides
    public final WifiService provideWifiService(@ApplicationContext Context context, ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        return new HardwareWifiService(context, Long.parseLong(configurationProperties.getProperty("wifi.refresh.delay")), configurationProperties.getProperty("rest.url"), Integer.parseInt(configurationProperties.getProperty("webserver.port")));
    }

    @Singleton
    @Provides
    public final SafeguardService provideSafeguardService(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new HardwareSafeguardService(context, FileUtils.INSTANCE);
    }

    @Singleton
    @Provides
    public final MetaDataService provideMetaDataService(@ApplicationContext Context context, StorageService storageService, WifiService wifiService, BatteryService batteryService, AvailabilityService availabilityService, NightLightTimerService nightLightTimerService, LightControlService lightControlService, AudioPlayerService audioPlayerService, PowerManagementService powerManagementService, ShutDownTimerService shutDownTimerService, TimersControllerService timersControllerService, TimeService timeService, InfoSoundService infoSoundService, AndroidSystemProperties androidSystemProperties, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        StorageService storageService2 = storageService;
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        WifiService wifiService2 = wifiService;
        Intrinsics.checkNotNullParameter(wifiService2, "wifiService");
        BatteryService batteryService2 = batteryService;
        Intrinsics.checkNotNullParameter(batteryService2, "batteryService");
        AvailabilityService availabilityService2 = availabilityService;
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        NightLightTimerService nightLightTimerService2 = nightLightTimerService;
        Intrinsics.checkNotNullParameter(nightLightTimerService2, "nightLightTimerService");
        LightControlService lightControlService2 = lightControlService;
        Intrinsics.checkNotNullParameter(lightControlService2, "lightControlService");
        AudioPlayerService audioPlayerService2 = audioPlayerService;
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        PowerManagementService powerManagementService2 = powerManagementService;
        Intrinsics.checkNotNullParameter(powerManagementService2, "powerManagementService");
        ShutDownTimerService shutDownTimerService2 = shutDownTimerService;
        Intrinsics.checkNotNullParameter(shutDownTimerService2, "shutDownTimerService");
        TimersControllerService timersControllerService2 = timersControllerService;
        Intrinsics.checkNotNullParameter(timersControllerService2, "timersController");
        TimeService timeService2 = timeService;
        Intrinsics.checkNotNullParameter(timeService2, "systemTimeService");
        InfoSoundService infoSoundService2 = infoSoundService;
        Intrinsics.checkNotNullParameter(infoSoundService2, "infoSoundService");
        AndroidSystemProperties androidSystemProperties2 = androidSystemProperties;
        Intrinsics.checkNotNullParameter(androidSystemProperties2, "systemProperties");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase, "getTigerBoxAccountUseCase");
        return new TigerBoxMetaDataService(context2, storageService2, wifiService2, batteryService2, availabilityService2, nightLightTimerService2, lightControlService2, audioPlayerService2, powerManagementService2, shutDownTimerService2, timersControllerService2, timeService2, infoSoundService2, androidSystemProperties2, getTigerBoxAccountUseCase);
    }

    @Singleton
    @Provides
    public final BatteryService provideBatteryService(@ApplicationContext Context context, InfoSoundService infoSoundService, LightControlService lightControlService, DisplayService displayService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(infoSoundService, "soundService");
        Intrinsics.checkNotNullParameter(lightControlService, "lightControlService");
        Intrinsics.checkNotNullParameter(displayService, "displayService");
        return new HardwareBatteryService(context, infoSoundService, lightControlService, displayService);
    }

    @Singleton
    @Provides
    public final ShutDownTimerService provideSleepTimerService(PowerManagementService powerManagementService, AudioPlayerService audioPlayerService) {
        Intrinsics.checkNotNullParameter(powerManagementService, "powerManagementService");
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioPlayerService");
        return new ShutDownTimer(powerManagementService, audioPlayerService);
    }

    @Singleton
    @Provides
    public final TimersControllerService provideTimersController(TimeLimitTimerService timeLimitTimerService, WindowedLimitTimeService windowedLimitTimeService, AudioPlayerService audioPlayerService, DisplayService displayService) {
        Intrinsics.checkNotNullParameter(timeLimitTimerService, "timeLimitTimer");
        Intrinsics.checkNotNullParameter(windowedLimitTimeService, "windowedLimit");
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioPlayerService");
        Intrinsics.checkNotNullParameter(displayService, "displayService");
        return new TimersController(timeLimitTimerService, windowedLimitTimeService, audioPlayerService, displayService);
    }

    @Singleton
    @Provides
    public final TimeLimitTimerService provideTimeLimitTimerService(@ApplicationContext Context context, StorageService storageService, TimeService timeService, AlarmManager alarmManager, ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(timeService, "timeService");
        Intrinsics.checkNotNullParameter(alarmManager, "alarmManager");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        return new TimeLimitTimer(context, storageService, timeService, alarmManager, configurationProperties);
    }

    @Singleton
    @Provides
    public final WindowedLimitTimeService provideWindowedLimitTimerService(@ApplicationContext Context context, StorageService storageService, TimeService timeService, AlarmManager alarmManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(timeService, "timeService");
        Intrinsics.checkNotNullParameter(alarmManager, "alarmManager");
        return new WindowedLimitTimer(context, storageService, timeService, alarmManager, (PendingIntentFactory) null, 16, (DefaultConstructorMarker) null);
    }

    @Singleton
    @Provides
    public final LockedModeService provideLockedMode(TimeLimitTimerService timeLimitTimerService, WindowedLimitTimeService windowedLimitTimeService) {
        Intrinsics.checkNotNullParameter(timeLimitTimerService, "timeLimitTimer");
        Intrinsics.checkNotNullParameter(windowedLimitTimeService, "windowedLimit");
        return new LockedMode(timeLimitTimerService, windowedLimitTimeService);
    }

    @Singleton
    @Provides
    public final AudioPlayerService provideAudioPlayerService(@ApplicationContext Context context, HlsKeyProviderService hlsKeyProviderService, StorageService storageService, AvailabilityService availabilityService, ProductAcquisitionService productAcquisitionService, AudioManager audioManager, TigerBoxAccountRepository tigerBoxAccountRepository, LockedModeService lockedModeService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(hlsKeyProviderService, "hlsService");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(availabilityService, "availabilityService");
        Intrinsics.checkNotNullParameter(productAcquisitionService, "acquisitionService");
        AudioManager audioManager2 = audioManager;
        Intrinsics.checkNotNullParameter(audioManager2, "audioManager");
        TigerBoxAccountRepository tigerBoxAccountRepository2 = tigerBoxAccountRepository;
        Intrinsics.checkNotNullParameter(tigerBoxAccountRepository2, "accountRepository");
        LockedModeService lockedModeService2 = lockedModeService;
        Intrinsics.checkNotNullParameter(lockedModeService2, "lockedModeService");
        return new AudioPlayer(context, hlsKeyProviderService, storageService, availabilityService, productAcquisitionService, audioManager2, tigerBoxAccountRepository2, lockedModeService2);
    }

    @Singleton
    @Provides
    public final HlsKeyProviderService provideHlsKeyProviderService(TigerBoxWebService tigerBoxWebService, HlsKeysRepository hlsKeysRepository) {
        Intrinsics.checkNotNullParameter(tigerBoxWebService, "webService");
        Intrinsics.checkNotNullParameter(hlsKeysRepository, "hlsKeysRepository");
        return new HlsKeyProvider(tigerBoxWebService, hlsKeysRepository);
    }

    @Singleton
    @Provides
    public final FirmwareUpdateService provideFirmwareUpdateService(@ApplicationContext Context context, StorageService storageService, BatteryService batteryService, AvailabilityService availabilityService, AudioPlayerService audioPlayerService, LightControlService lightControlService, CheckForUpdateUseCase checkForUpdateUseCase, ValidateUpdateSignature validateUpdateSignature, DownloadFirmware downloadFirmware, DecryptFirmware decryptFirmware, InstallFirmware installFirmware, ConfigurationProperties configurationProperties, RequiresUpdate requiresUpdate) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "context");
        StorageService storageService2 = storageService;
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        BatteryService batteryService2 = batteryService;
        Intrinsics.checkNotNullParameter(batteryService2, "batteryService");
        AvailabilityService availabilityService2 = availabilityService;
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        AudioPlayerService audioPlayerService2 = audioPlayerService;
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioService");
        LightControlService lightControlService2 = lightControlService;
        Intrinsics.checkNotNullParameter(lightControlService2, "lightControlService");
        CheckForUpdateUseCase checkForUpdateUseCase2 = checkForUpdateUseCase;
        Intrinsics.checkNotNullParameter(checkForUpdateUseCase2, "checkForUpdateUseCase");
        ValidateUpdateSignature validateUpdateSignature2 = validateUpdateSignature;
        Intrinsics.checkNotNullParameter(validateUpdateSignature2, "validateUpdateSignature");
        DownloadFirmware downloadFirmware2 = downloadFirmware;
        Intrinsics.checkNotNullParameter(downloadFirmware2, "downloadFirmware");
        DecryptFirmware decryptFirmware2 = decryptFirmware;
        Intrinsics.checkNotNullParameter(decryptFirmware2, "decryptFirmware");
        InstallFirmware installFirmware2 = installFirmware;
        Intrinsics.checkNotNullParameter(installFirmware2, "installFirmware");
        ConfigurationProperties configurationProperties2 = configurationProperties;
        Intrinsics.checkNotNullParameter(configurationProperties2, "configurationProperties");
        RequiresUpdate requiresUpdate2 = requiresUpdate;
        Intrinsics.checkNotNullParameter(requiresUpdate2, "requiresUpdate");
        return new FirmwareUpdate(context2, storageService2, batteryService2, availabilityService2, audioPlayerService2, lightControlService2, checkForUpdateUseCase2, validateUpdateSignature2, downloadFirmware2, decryptFirmware2, installFirmware2, configurationProperties2, requiresUpdate2);
    }

    @Singleton
    @Provides
    public final AvailabilityService provideAvailabilityService(DownloadsManagerService downloadsManagerService, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase, SharedPreferences sharedPreferences, WifiService wifiService, HlsKeyProviderService hlsKeyProviderService, LightControlService lightControlService, TimeService timeService, WakeService wakeService) {
        Intrinsics.checkNotNullParameter(downloadsManagerService, "dlService");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase, "getTigerBoxAccountUseCase");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(wifiService, "wifiService");
        HlsKeyProviderService hlsKeyProviderService2 = hlsKeyProviderService;
        Intrinsics.checkNotNullParameter(hlsKeyProviderService2, "hlsService");
        LightControlService lightControlService2 = lightControlService;
        Intrinsics.checkNotNullParameter(lightControlService2, "lightControlService");
        TimeService timeService2 = timeService;
        Intrinsics.checkNotNullParameter(timeService2, "timeService");
        WakeService wakeService2 = wakeService;
        Intrinsics.checkNotNullParameter(wakeService2, "wakeService");
        return new Availability(downloadsManagerService, getTigerBoxAccountUseCase, sharedPreferences, wifiService, hlsKeyProviderService2, lightControlService2, timeService2, wakeService2, FileUtils.INSTANCE);
    }

    @Singleton
    @Provides
    public final DownloadsManagerService provideDownloadsManagerService(@ApplicationContext Context context, WifiService wifiService, DownloadsWebService downloadsWebService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(wifiService, "wifiService");
        Intrinsics.checkNotNullParameter(downloadsWebService, "webDlService");
        String str = context.getApplicationInfo().dataDir;
        Intrinsics.checkNotNullExpressionValue(str, "context.applicationInfo.dataDir");
        return new DownloadsManager(str, context, wifiService, downloadsWebService);
    }

    @Singleton
    @Provides
    public final ProductAcquisitionService provideProductAcquisitionService(DownloadsManagerService downloadsManagerService, StorageService storageService, AvailabilityService availabilityService, GetProductAssetsUseCase getProductAssetsUseCase, GetProductDetailsUseCase getProductDetailsUseCase, RequestAcquisitionUseCase requestAcquisitionUseCase, CheckAcquisitionsUseCase checkAcquisitionsUseCase, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        Intrinsics.checkNotNullParameter(downloadsManagerService, "dlManagerService");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(availabilityService, "availabilityService");
        Intrinsics.checkNotNullParameter(getProductAssetsUseCase, "getProductAssetsUseCase");
        Intrinsics.checkNotNullParameter(getProductDetailsUseCase, "getProductDetailsUseCase");
        RequestAcquisitionUseCase requestAcquisitionUseCase2 = requestAcquisitionUseCase;
        Intrinsics.checkNotNullParameter(requestAcquisitionUseCase2, "requestAcquisitionUseCase");
        CheckAcquisitionsUseCase checkAcquisitionsUseCase2 = checkAcquisitionsUseCase;
        Intrinsics.checkNotNullParameter(checkAcquisitionsUseCase2, "checkAcquisitionsUseCase");
        GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2 = getTigerBoxAccountUseCase;
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
        return new ProductAcquisition(downloadsManagerService, storageService, availabilityService, getProductAssetsUseCase, getProductDetailsUseCase, requestAcquisitionUseCase2, checkAcquisitionsUseCase2, getTigerBoxAccountUseCase2);
    }

    @Singleton
    @Provides
    public final PlaybackPositionService providePlaybackPositionService(AudioPlayerService audioPlayerService, PlaybackPositionsRepository playbackPositionsRepository, GetPlayStatesUseCase getPlayStatesUseCase, PostPlayStateUseCase postPlayStateUseCase, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioPlayerService");
        Intrinsics.checkNotNullParameter(playbackPositionsRepository, "playbackPositionsRepository");
        Intrinsics.checkNotNullParameter(getPlayStatesUseCase, "getPlayStatesUseCase");
        Intrinsics.checkNotNullParameter(postPlayStateUseCase, "postPlayStateUseCase");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase, "getTigerBoxAccountUseCase");
        return new PlaybackPosition(audioPlayerService, playbackPositionsRepository, getPlayStatesUseCase, postPlayStateUseCase, getTigerBoxAccountUseCase);
    }

    @Singleton
    @Provides
    public final LastUsedProductService provideLastUsedProductService(AudioPlayerService audioPlayerService, SharedPreferences sharedPreferences, StorageService storageService, ReportLastCardProductUseCase reportLastCardProductUseCase, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioPlayerService");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(reportLastCardProductUseCase, "reportLastCardProductUseCase");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase, "getTigerBoxAccountUseCase");
        return new LastUsedProduct(audioPlayerService, sharedPreferences, reportLastCardProductUseCase, getTigerBoxAccountUseCase);
    }

    @Singleton
    @Provides
    public final PlaybackTrackingService providePlaybackTrackingService(AudioPlayerService audioPlayerService, PlaybackTrackingRepository playbackTrackingRepository, WifiService wifiService, StorageService storageService, PostTrackingEventUseCase postTrackingEventUseCase, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioPlayerService");
        Intrinsics.checkNotNullParameter(playbackTrackingRepository, "playbackTrackingRepository");
        Intrinsics.checkNotNullParameter(wifiService, "wifiService");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(postTrackingEventUseCase, "postTrackingEventUseCase");
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase, "getTigerBoxAccountUseCase");
        return new PlaybackTracking(audioPlayerService, playbackTrackingRepository, wifiService, storageService, postTrackingEventUseCase, getTigerBoxAccountUseCase);
    }

    @Singleton
    @Provides
    public final ButtonService provideButtonService(SafeguardService safeguardService) {
        Intrinsics.checkNotNullParameter(safeguardService, "safeguardService");
        return new ButtonService(safeguardService);
    }

    @Singleton
    @Provides
    public final NightLightTimerService provideNightLightTimerService(@ApplicationContext Context context, LightControlService lightControlService, StorageService storageService, TimeService timeService, AlarmManager alarmManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lightControlService, "lightControl");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(timeService, "timeService");
        Intrinsics.checkNotNullParameter(alarmManager, "alarmManager");
        return new NightLightTimer(context, lightControlService, storageService, timeService, alarmManager, (PendingIntentFactory) null, 32, (DefaultConstructorMarker) null);
    }

    @Singleton
    @Provides
    public final UpdateCheckTimerService provideUpdateCheckTimer(@ApplicationContext Context context, TimeService timeService, AlarmManager alarmManager, FirmwareUpdateService firmwareUpdateService, ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(timeService, "timeService");
        Intrinsics.checkNotNullParameter(alarmManager, "alarmManager");
        Intrinsics.checkNotNullParameter(firmwareUpdateService, "firmwareUpdateService");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        return new UpdateCheckTimer(context, timeService, alarmManager, firmwareUpdateService, configurationProperties, (PendingIntentFactory) null, 32, (DefaultConstructorMarker) null);
    }

    @Singleton
    @Provides
    public final HeadsetService provideHeadsetService() {
        return new HeadsetService();
    }

    @Singleton
    @Provides
    public final DisplayService provideDisplayService() {
        return new DisplayService();
    }

    @Singleton
    @Provides
    public final NfcService provideNfcService(LockedModeService lockedModeService) {
        Intrinsics.checkNotNullParameter(lockedModeService, "lockedModeService");
        return new HardwareNfcService(lockedModeService);
    }

    @Singleton
    @Provides
    public final TigerCardsManagerService provideTigerCardsManagerService(NfcService nfcService, SharedPreferences sharedPreferences, WifiService wifiService, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase, AudioPlayerService audioPlayerService, AvailabilityService availabilityService, ProductAcquisitionService productAcquisitionService, GetValidTigerCardUseCase getValidTigerCardUseCase, TigerTicketGetProductUseCase tigerTicketGetProductUseCase, WildCardReassignUseCase wildCardReassignUseCase) {
        Intrinsics.checkNotNullParameter(nfcService, "nfcService");
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(wifiService, "wifiService");
        GetTigerBoxAccountUseCase getTigerBoxAccountUseCase2 = getTigerBoxAccountUseCase;
        Intrinsics.checkNotNullParameter(getTigerBoxAccountUseCase2, "getTigerBoxAccountUseCase");
        AudioPlayerService audioPlayerService2 = audioPlayerService;
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        AvailabilityService availabilityService2 = availabilityService;
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        ProductAcquisitionService productAcquisitionService2 = productAcquisitionService;
        Intrinsics.checkNotNullParameter(productAcquisitionService2, "productAcquisition");
        GetValidTigerCardUseCase getValidTigerCardUseCase2 = getValidTigerCardUseCase;
        Intrinsics.checkNotNullParameter(getValidTigerCardUseCase2, "validCardUseCase");
        TigerTicketGetProductUseCase tigerTicketGetProductUseCase2 = tigerTicketGetProductUseCase;
        Intrinsics.checkNotNullParameter(tigerTicketGetProductUseCase2, "tigerTicketGetProductUseCase");
        WildCardReassignUseCase wildCardReassignUseCase2 = wildCardReassignUseCase;
        Intrinsics.checkNotNullParameter(wildCardReassignUseCase2, "wildCardReassignUseCase");
        return new TigerCardsManager(nfcService, sharedPreferences, wifiService, getTigerBoxAccountUseCase2, audioPlayerService2, availabilityService2, productAcquisitionService2, getValidTigerCardUseCase2, tigerTicketGetProductUseCase2, wildCardReassignUseCase2);
    }

    @Singleton
    @Provides
    public final InfoSoundService provideInfoSoundService(@ApplicationContext Context context, StorageService storageService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        return new InfoSoundPlayer(context, storageService);
    }

    @Singleton
    @Provides
    public final WakeService provideWakeService(PowerManager powerManager) {
        Intrinsics.checkNotNullParameter(powerManager, "powerManager");
        return new DeviceWakeService(powerManager);
    }

    @Singleton
    @Provides
    public final PowerManagementService providePowerManagementService(@ApplicationContext Context context, DisplayService displayService, BatteryService batteryService, DeepSleepTimerService deepSleepTimerService, AudioPlayerService audioPlayerService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(displayService, "displayService");
        Intrinsics.checkNotNullParameter(batteryService, "batteryService");
        Intrinsics.checkNotNullParameter(deepSleepTimerService, "deepSleepTimerService");
        Intrinsics.checkNotNullParameter(audioPlayerService, "audioPlayerService");
        return new PowerManagement(context, displayService, batteryService, deepSleepTimerService, audioPlayerService);
    }

    @Singleton
    @Provides
    public final TimeService provideTimeService() {
        return new ServiceModule$provideTimeService$1();
    }

    @Singleton
    @Provides
    public final AssetService provideAssetService(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        AssetManager assets = context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        return new AndroidAssetService(assets);
    }

    @Singleton
    @Provides
    public final Base64Converter provideBase64Converter() {
        return AndroidBase64Converter.INSTANCE;
    }

    @Singleton
    @Provides
    public final InstallFirmware provideReadyToUpdate(@ApplicationContext Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new InstallTigerBoxFirmware(context);
    }

    @Singleton
    @Provides
    public final UpdateCheck provideUpdateCheck(StorageService storageService, MetaDataService metaDataService, ReportInformationUseCase reportInformationUseCase, ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService, "metaDataService");
        Intrinsics.checkNotNullParameter(reportInformationUseCase, "reportSuccessfulUpdate");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        return new UpdateCheck(storageService, metaDataService, reportInformationUseCase, configurationProperties);
    }

    @Singleton
    @Provides
    public final RequiresUpdate provideRequiresUpdate(StorageService storageService, ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        return new RequiresUpdate(storageService, configurationProperties);
    }

    @Singleton
    @Provides
    public final HeaderProvider provideHeaderBar(WifiService wifiService, BatteryService batteryService, ShutDownTimerService shutDownTimerService, TimersControllerService timersControllerService, AvailabilityService availabilityService, MetaDataService metaDataService, InfoSoundService infoSoundService, AudioPlayerService audioPlayerService, FirmwareUpdateService firmwareUpdateService) {
        Intrinsics.checkNotNullParameter(wifiService, "wifiService");
        Intrinsics.checkNotNullParameter(batteryService, "batteryService");
        Intrinsics.checkNotNullParameter(shutDownTimerService, "shutDownTimerService");
        Intrinsics.checkNotNullParameter(timersControllerService, "timersControllerService");
        AvailabilityService availabilityService2 = availabilityService;
        Intrinsics.checkNotNullParameter(availabilityService2, "availabilityService");
        MetaDataService metaDataService2 = metaDataService;
        Intrinsics.checkNotNullParameter(metaDataService2, "metaDataService");
        InfoSoundService infoSoundService2 = infoSoundService;
        Intrinsics.checkNotNullParameter(infoSoundService2, "infoSoundService");
        AudioPlayerService audioPlayerService2 = audioPlayerService;
        Intrinsics.checkNotNullParameter(audioPlayerService2, "audioPlayerService");
        FirmwareUpdateService firmwareUpdateService2 = firmwareUpdateService;
        Intrinsics.checkNotNullParameter(firmwareUpdateService2, "firmwareUpdateService");
        return new HeaderBarProvider(wifiService, batteryService, shutDownTimerService, timersControllerService, availabilityService2, metaDataService2, infoSoundService2, audioPlayerService2, firmwareUpdateService2);
    }

    @Provides
    public final DataMigrationService provideMigrationService(SharedPreferences sharedPreferences, TigerBoxDatabase tigerBoxDatabase) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "encryptedSharedPreferences");
        Intrinsics.checkNotNullParameter(tigerBoxDatabase, "tigerBoxDatabase");
        return new DataMigrationServiceImpl(sharedPreferences, tigerBoxDatabase);
    }

    @Singleton
    @Provides
    public final WriteToFileExceptionHandler provideWriteToFileExceptionHandler(PostCrashLogsUseCase postCrashLogsUseCase, StorageService storageService, MetaDataService metaDataService) {
        Intrinsics.checkNotNullParameter(postCrashLogsUseCase, "postLogsUseCase");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService, "metaDataService");
        return new WriteToFileExceptionHandler(postCrashLogsUseCase, storageService, metaDataService);
    }

    @Singleton
    @Provides
    public final TigerBoxLogTree provideTigerBoxLogTree(PostCrashLogsUseCase postCrashLogsUseCase, StorageService storageService, MetaDataService metaDataService, ConfigurationProperties configurationProperties) {
        Intrinsics.checkNotNullParameter(postCrashLogsUseCase, "postLogsUseCase");
        Intrinsics.checkNotNullParameter(storageService, "storageService");
        Intrinsics.checkNotNullParameter(metaDataService, "metaDataService");
        Intrinsics.checkNotNullParameter(configurationProperties, "configurationProperties");
        return new TigerBoxLogTree(postCrashLogsUseCase, metaDataService, storageService, configurationProperties);
    }
}
