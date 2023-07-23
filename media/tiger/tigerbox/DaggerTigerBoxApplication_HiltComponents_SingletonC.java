package media.tiger.tigerbox;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Service;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.PowerManager;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideApplicationFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import media.tiger.tigerbox.TigerBoxApplication_HiltComponents;
import media.tiger.tigerbox.data.database.TigerBoxDatabase;
import media.tiger.tigerbox.data.network.DownloadsWebService;
import media.tiger.tigerbox.data.network.OtaWebService;
import media.tiger.tigerbox.data.network.ScalarTigerBoxWebService;
import media.tiger.tigerbox.data.network.TigerBoxWebService;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;
import media.tiger.tigerbox.data.repository.HlsKeysRepository;
import media.tiger.tigerbox.data.repository.PlaybackPositionsRepository;
import media.tiger.tigerbox.data.repository.PlaybackTrackingRepository;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;
import media.tiger.tigerbox.developer.AdbReceiver;
import media.tiger.tigerbox.developer.AdbReceiver_MembersInjector;
import media.tiger.tigerbox.infrastructure.functional.DownloadProgressUpdate;
import media.tiger.tigerbox.infrastructure.p015di.AndroidModule;
import media.tiger.tigerbox.infrastructure.p015di.AndroidModule_ProvideAlarmManagerFactory;
import media.tiger.tigerbox.infrastructure.p015di.AndroidModule_ProvideAudioManagerFactory;
import media.tiger.tigerbox.infrastructure.p015di.AndroidModule_ProvidePowerManagerFactory;
import media.tiger.tigerbox.infrastructure.p015di.C2865x2b05c698;
import media.tiger.tigerbox.infrastructure.p015di.ConfigurationPropertiesModule;
import media.tiger.tigerbox.infrastructure.p015di.CoroutinesModule;
import media.tiger.tigerbox.infrastructure.p015di.CoroutinesModule_ProvidesIoDispatcherFactory;
import media.tiger.tigerbox.infrastructure.p015di.HttpClientModule;
import media.tiger.tigerbox.infrastructure.p015di.HttpClientModule_ProvideAuthInterceptorOkHttpClientFactory;
import media.tiger.tigerbox.infrastructure.p015di.HttpClientModule_ProvideDownloadsOkHttpClientFactory;
import media.tiger.tigerbox.infrastructure.p015di.HttpClientModule_ProvideOtaWebServiceOkHttpClientFactory;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule_ProvideAdbEnablerFactory;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule_ProvideAndroidSystemPropertiesFactory;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule_ProvideDatabaseMigrationServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule_ProvideEngageDeepSleepFactory;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule_ProvideGenerateCsrFactory;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule_ProvideGetProductListRequestFactory;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule_ProvideInitServicesFactory;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule_ProvideLargeDownloadHandlerFactory;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule_ProvideRestartServicesSafelyFactory;
import media.tiger.tigerbox.infrastructure.p015di.RetrofitModule;
import media.tiger.tigerbox.infrastructure.p015di.RetrofitModule_ProvideDownloadProgressNotifierFactory;
import media.tiger.tigerbox.infrastructure.p015di.RetrofitModule_ProvideDownloadsWebServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.RetrofitModule_ProvideOpenLoginScreenFactory;
import media.tiger.tigerbox.infrastructure.p015di.RetrofitModule_ProvideOtaWebServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.RetrofitModule_ProvideScalarTigerBoxServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.RetrofitModule_ProvideSignatureValidatorFactory;
import media.tiger.tigerbox.infrastructure.p015di.RetrofitModule_ProvideTigerBoxServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideAccountSubscriptionServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideAssetServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideAudioPlayerServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideAvailabilityServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideBase64ConverterFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideBatteryServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideButtonServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideDisplayServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideDownloadsManagerServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideFirmwareUpdateServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideHeaderBarFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideHeadsetServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideHlsKeyProviderServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideInfoSoundServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideLastUsedProductServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideLightControlServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideLockedModeFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideMetaDataServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideMigrationServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideNfcServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideNightLightTimerServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvidePlaybackPositionServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvidePlaybackTrackingServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvidePowerManagementServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideProductAcquisitionServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideReadyToUpdateFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideRequiresUpdateFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideSafeguardServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideSleepTimerServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideTigerBoxLogTreeFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideTigerCardsManagerServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideTimeLimitTimerServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideTimeServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideTimersControllerFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideUpdateCheckFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideUpdateCheckTimerFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideWakeServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideWifiServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideWindowedLimitTimerServiceFactory;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule_ProvideWriteToFileExceptionHandlerFactory;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule_ProvideAccessTokenRepositoryFactory;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule_ProvideDatabaseFactory;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule_ProvideEncryptedSharedPreferencesFactory;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule_ProvideHlsKeysRepositoryFactory;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule_ProvidePlaybackPositionsRepositoryFactory;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule_ProvidePlaybackTrackingRepositoryFactory;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule_ProvideStorageProviderFactory;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule_ProvideTigerBoxAccountRepositoryFactory;
import media.tiger.tigerbox.infrastructure.p015di.WebServerModule;
import media.tiger.tigerbox.infrastructure.p015di.WebServerModule_ProvideMediaRestControllerFactory;
import media.tiger.tigerbox.infrastructure.p015di.WebServerModule_ProvideWebServerFactory;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.LaunchViewModel;
import media.tiger.tigerbox.p016ui.LaunchViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.LauncherActivity;
import media.tiger.tigerbox.p016ui.LauncherActivity_MembersInjector;
import media.tiger.tigerbox.p016ui.TigerBoxActivity;
import media.tiger.tigerbox.p016ui.TigerBoxActivityViewModel;
import media.tiger.tigerbox.p016ui.TigerBoxActivityViewModel_Factory;
import media.tiger.tigerbox.p016ui.TigerBoxActivityViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.TigerBoxActivity_MembersInjector;
import media.tiger.tigerbox.p016ui.common.BaseViewModel;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_Factory;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel_Factory;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.common.reset.ResetDialogFragment;
import media.tiger.tigerbox.p016ui.common.reset.ResetDialogViewModel;
import media.tiger.tigerbox.p016ui.common.reset.ResetDialogViewModel_Factory;
import media.tiger.tigerbox.p016ui.common.reset.ResetDialogViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.common.reset.ResetInProgressFragment;
import media.tiger.tigerbox.p016ui.common.reset.ResetInProgressViewModel;
import media.tiger.tigerbox.p016ui.common.reset.ResetInProgressViewModel_Factory;
import media.tiger.tigerbox.p016ui.common.reset.ResetInProgressViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordFragment;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordViewModel;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordViewModel_Factory;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel_Factory;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.main.MainContentActivity;
import media.tiger.tigerbox.p016ui.main.MainContentActivity_MembersInjector;
import media.tiger.tigerbox.p016ui.main.card.C2933x2d51b54f;
import media.tiger.tigerbox.p016ui.main.card.C2940x21648e65;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinFragment;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel_Factory;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketPurchaseFragment;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketPurchaseViewModel;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketPurchaseViewModel_Factory;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketValidFragment;
import media.tiger.tigerbox.p016ui.main.maincontent.GenerateCsr;
import media.tiger.tigerbox.p016ui.main.maincontent.GetProductListRequest;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductContentFragment;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductContentViewModel;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductContentViewModel_Factory;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductContentViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductListMainContentFragment;
import media.tiger.tigerbox.p016ui.main.maincontentheader.C2964x2af827ff;
import media.tiger.tigerbox.p016ui.main.maincontentheader.MainContentHeaderBarViewModel;
import media.tiger.tigerbox.p016ui.main.maincontentheader.MainContentHeaderBarViewModel_Factory;
import media.tiger.tigerbox.p016ui.main.maincontentheader.MainContentHeaderFragment;
import media.tiger.tigerbox.p016ui.main.mediaplayer.ChapterListViewModel;
import media.tiger.tigerbox.p016ui.main.mediaplayer.ChapterListViewModel_Factory;
import media.tiger.tigerbox.p016ui.main.mediaplayer.ChapterListViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerChapterListFragment;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerFragment;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel_Factory;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.main.multiproductcard.MultiProductCardFragment;
import media.tiger.tigerbox.p016ui.main.offlinemode.OfflineModeFragment;
import media.tiger.tigerbox.p016ui.main.offlinemode.OfflineModeViewModel;
import media.tiger.tigerbox.p016ui.main.offlinemode.OfflineModeViewModel_Factory;
import media.tiger.tigerbox.p016ui.main.offlinemode.OfflineModeViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilePictureViewModel;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilePictureViewModel_Factory;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilePictureViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilesViewModel;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilesViewModel_Factory;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilesViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.main.seemoreproducts.SeeMoreProductsFragment;
import media.tiger.tigerbox.p016ui.main.update.UpdateCheck;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivity;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityViewModel;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityViewModel_Factory;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivity_MembersInjector;
import media.tiger.tigerbox.p016ui.onboarding.ReauthenticationLoginHandler;
import media.tiger.tigerbox.p016ui.onboarding.step1.C2986xee60c5f4;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen1Fragment;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen1ViewModel;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen2Fragment;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen3Fragment;
import media.tiger.tigerbox.p016ui.onboarding.step2.OnboardingWifiListFragment;
import media.tiger.tigerbox.p016ui.onboarding.step2.OnboardingWifiViewModel;
import media.tiger.tigerbox.p016ui.onboarding.step2.OnboardingWifiViewModel_Factory;
import media.tiger.tigerbox.p016ui.onboarding.step2.OnboardingWifiViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.onboarding.step2.RequiresUpdate;
import media.tiger.tigerbox.p016ui.onboarding.step3.InstallFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.OnboardingUpdateFragment;
import media.tiger.tigerbox.p016ui.onboarding.step3.OnboardingUpdateViewModel;
import media.tiger.tigerbox.p016ui.onboarding.step3.OnboardingUpdateViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.Base64Converter;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DigestValidator;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DownloadFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.LargeDownloadHandler;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature;
import media.tiger.tigerbox.p016ui.onboarding.step4.C3004x887e5a76;
import media.tiger.tigerbox.p016ui.onboarding.step4.C3008x9d992673;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendCommunicationFragment;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendCommunicationViewModel;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendCommunicationViewModel_Factory;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendResponseFragment;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendResponseFragment_MembersInjector;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendResponseViewModel;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendResponseViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.FullScreenSeekBarFragment;
import media.tiger.tigerbox.p016ui.settings.FullScreenSeekBarViewModel;
import media.tiger.tigerbox.p016ui.settings.FullScreenSeekBarViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.FullScreenSeekBarViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.settings.SettingsActivity;
import media.tiger.tigerbox.p016ui.settings.SettingsFragment;
import media.tiger.tigerbox.p016ui.settings.SettingsViewModel;
import media.tiger.tigerbox.p016ui.settings.SettingsViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.SettingsViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.settings.SettingsWifiFragment;
import media.tiger.tigerbox.p016ui.settings.SettingsWifiViewModel;
import media.tiger.tigerbox.p016ui.settings.SettingsWifiViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.SettingsWifiViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.settings.parentalGate.C3020xeaa764a;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateDisableStepFragment;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateEnableStepFragment;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateFragment;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateViewModel;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsFinishedFragment;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsFinishedViewModel;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsFinishedViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsFinishedViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsInProgressFragment;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsInProgressViewModel;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsInProgressViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsInProgressViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsNoneFragment;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsNoneViewModel;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsNoneViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsNoneViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.settings.systeminfo.SystemInfoFragment;
import media.tiger.tigerbox.p016ui.settings.systeminfo.SystemInfoViewModel;
import media.tiger.tigerbox.p016ui.settings.systeminfo.SystemInfoViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.systeminfo.SystemInfoViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.settings.timersSetup.C3028x60021d0a;
import media.tiger.tigerbox.p016ui.settings.timersSetup.C3032xc74673f7;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupFragment;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupFragment;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupViewModel;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupViewModel;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupViewModel_HiltModules_KeyModule_ProvideFactory;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupWindowSetupFragment;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupWindowSetupViewModel;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupWindowSetupViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.C3039x7c7ad376;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.C3043x2b4967d8;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.C3047xa0c38e19;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberDialogFragment;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep1Fragment;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_Factory;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep2Fragment;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep2ViewModel;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep2ViewModel_Factory;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.implementations.DeepSleepTimerService;
import media.tiger.tigerbox.services.implementations.DisplayService;
import media.tiger.tigerbox.services.implementations.HeadsetService;
import media.tiger.tigerbox.services.implementations.receiver.ButtonBroadcastReceiver;
import media.tiger.tigerbox.services.implementations.receiver.ButtonBroadcastReceiver_MembersInjector;
import media.tiger.tigerbox.services.implementations.receiver.DateChangeBroadcastReceiver;
import media.tiger.tigerbox.services.implementations.receiver.DateChangeBroadcastReceiver_MembersInjector;
import media.tiger.tigerbox.services.implementations.receiver.DisplayBroadcastReceiver;
import media.tiger.tigerbox.services.implementations.receiver.DisplayBroadcastReceiver_MembersInjector;
import media.tiger.tigerbox.services.implementations.receiver.HeadsetBroadcastReceiver;
import media.tiger.tigerbox.services.implementations.receiver.HeadsetBroadcastReceiver_MembersInjector;
import media.tiger.tigerbox.services.implementations.receiver.NfcBroadcastReceiver;
import media.tiger.tigerbox.services.implementations.receiver.NfcBroadcastReceiver_MembersInjector;
import media.tiger.tigerbox.services.implementations.receiver.SafeguardBroadcastReceiver;
import media.tiger.tigerbox.services.implementations.receiver.SafeguardBroadcastReceiver_MembersInjector;
import media.tiger.tigerbox.services.implementations.receiver.WindowedLimitBroadcastReceiver;
import media.tiger.tigerbox.services.implementations.receiver.WindowedLimitBroadcastReceiver_MembersInjector;
import media.tiger.tigerbox.services.interfaces.AccountSubscriptionService;
import media.tiger.tigerbox.services.interfaces.AdbEnabler;
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
import media.tiger.tigerbox.usecase.AssignBoxToAccountUseCase;
import media.tiger.tigerbox.usecase.AssignProfileToAccountUseCase;
import media.tiger.tigerbox.usecase.CheckAcquisitionsUseCase;
import media.tiger.tigerbox.usecase.CheckForUpdateUseCase;
import media.tiger.tigerbox.usecase.GetMainContentUseCase;
import media.tiger.tigerbox.usecase.GetPlayStatesUseCase;
import media.tiger.tigerbox.usecase.GetProductAssetsUseCase;
import media.tiger.tigerbox.usecase.GetProductDetailsUseCase;
import media.tiger.tigerbox.usecase.GetSubscriptionsUseCase;
import media.tiger.tigerbox.usecase.GetValidTigerCardUseCase;
import media.tiger.tigerbox.usecase.OnboardingCompleteActionUseCase;
import media.tiger.tigerbox.usecase.OnboardingCompletedUseCase;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;
import media.tiger.tigerbox.usecase.PostPlayStateUseCase;
import media.tiger.tigerbox.usecase.PostTrackingEventUseCase;
import media.tiger.tigerbox.usecase.ReportInformationUseCase;
import media.tiger.tigerbox.usecase.ReportLastCardProductUseCase;
import media.tiger.tigerbox.usecase.RequestAcquisitionUseCase;
import media.tiger.tigerbox.usecase.RequestPemCertificateUseCase;
import media.tiger.tigerbox.usecase.TigerTicketGetProductUseCase;
import media.tiger.tigerbox.usecase.TigerTicketPurchaseUseCase;
import media.tiger.tigerbox.usecase.TigerTicketValidatePinUseCase;
import media.tiger.tigerbox.usecase.WildCardReassignUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.FetchAndStoreAccessTokenUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.GetAccessTokenUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.RemoveAccountDataUseCase;
import media.tiger.tigerbox.usecase.accesstokenrepo.RequestReAuthAndStoreTokenUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.FetchAccountInfoUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;
import media.tiger.tigerbox.webserver.WebServer;
import media.tiger.tigerbox.webserver.controller.MediaRestController;
import okhttp3.OkHttpClient;

public final class DaggerTigerBoxApplication_HiltComponents_SingletonC {
    private DaggerTigerBoxApplication_HiltComponents_SingletonC() {
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private ApplicationContextModule applicationContextModule;

        private Builder() {
        }

        @Deprecated
        public Builder androidModule(AndroidModule androidModule) {
            Preconditions.checkNotNull(androidModule);
            return this;
        }

        public Builder applicationContextModule(ApplicationContextModule applicationContextModule2) {
            this.applicationContextModule = (ApplicationContextModule) Preconditions.checkNotNull(applicationContextModule2);
            return this;
        }

        @Deprecated
        public Builder configurationPropertiesModule(ConfigurationPropertiesModule configurationPropertiesModule) {
            Preconditions.checkNotNull(configurationPropertiesModule);
            return this;
        }

        @Deprecated
        public Builder coroutinesModule(CoroutinesModule coroutinesModule) {
            Preconditions.checkNotNull(coroutinesModule);
            return this;
        }

        @Deprecated
        public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
            Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
            return this;
        }

        @Deprecated
        public Builder httpClientModule(HttpClientModule httpClientModule) {
            Preconditions.checkNotNull(httpClientModule);
            return this;
        }

        @Deprecated
        public Builder processModule(ProcessModule processModule) {
            Preconditions.checkNotNull(processModule);
            return this;
        }

        @Deprecated
        public Builder retrofitModule(RetrofitModule retrofitModule) {
            Preconditions.checkNotNull(retrofitModule);
            return this;
        }

        @Deprecated
        public Builder serviceModule(ServiceModule serviceModule) {
            Preconditions.checkNotNull(serviceModule);
            return this;
        }

        @Deprecated
        public Builder storageModule(StorageModule storageModule) {
            Preconditions.checkNotNull(storageModule);
            return this;
        }

        @Deprecated
        public Builder webServerModule(WebServerModule webServerModule) {
            Preconditions.checkNotNull(webServerModule);
            return this;
        }

        public TigerBoxApplication_HiltComponents.SingletonC build() {
            Preconditions.checkBuilderRequirement(this.applicationContextModule, ApplicationContextModule.class);
            return new SingletonCImpl(this.applicationContextModule);
        }
    }

    private static final class ActivityRetainedCBuilder implements TigerBoxApplication_HiltComponents.ActivityRetainedC.Builder {
        private final SingletonCImpl singletonCImpl;

        private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl2) {
            this.singletonCImpl = singletonCImpl2;
        }

        public TigerBoxApplication_HiltComponents.ActivityRetainedC build() {
            return new ActivityRetainedCImpl(this.singletonCImpl);
        }
    }

    private static final class ActivityCBuilder implements TigerBoxApplication_HiltComponents.ActivityC.Builder {
        private Activity activity;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;

        private ActivityCBuilder(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2) {
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
        }

        public ActivityCBuilder activity(Activity activity2) {
            this.activity = (Activity) Preconditions.checkNotNull(activity2);
            return this;
        }

        public TigerBoxApplication_HiltComponents.ActivityC build() {
            Preconditions.checkBuilderRequirement(this.activity, Activity.class);
            return new ActivityCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activity);
        }
    }

    private static final class FragmentCBuilder implements TigerBoxApplication_HiltComponents.FragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Fragment fragment;
        private final SingletonCImpl singletonCImpl;

        private FragmentCBuilder(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2) {
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }

        public FragmentCBuilder fragment(Fragment fragment2) {
            this.fragment = (Fragment) Preconditions.checkNotNull(fragment2);
            return this;
        }

        public TigerBoxApplication_HiltComponents.FragmentC build() {
            Preconditions.checkBuilderRequirement(this.fragment, Fragment.class);
            return new FragmentCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragment);
        }
    }

    private static final class ViewWithFragmentCBuilder implements TigerBoxApplication_HiltComponents.ViewWithFragmentC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;
        private View view;

        private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, FragmentCImpl fragmentCImpl2) {
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
            this.fragmentCImpl = fragmentCImpl2;
        }

        public ViewWithFragmentCBuilder view(View view2) {
            this.view = (View) Preconditions.checkNotNull(view2);
            return this;
        }

        public TigerBoxApplication_HiltComponents.ViewWithFragmentC build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewWithFragmentCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl, this.view);
        }
    }

    private static final class ViewCBuilder implements TigerBoxApplication_HiltComponents.ViewC.Builder {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;
        private View view;

        private ViewCBuilder(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2) {
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }

        public ViewCBuilder view(View view2) {
            this.view = (View) Preconditions.checkNotNull(view2);
            return this;
        }

        public TigerBoxApplication_HiltComponents.ViewC build() {
            Preconditions.checkBuilderRequirement(this.view, View.class);
            return new ViewCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.view);
        }
    }

    private static final class ViewModelCBuilder implements TigerBoxApplication_HiltComponents.ViewModelC.Builder {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private SavedStateHandle savedStateHandle;
        private final SingletonCImpl singletonCImpl;

        private ViewModelCBuilder(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2) {
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
        }

        public ViewModelCBuilder savedStateHandle(SavedStateHandle savedStateHandle2) {
            this.savedStateHandle = (SavedStateHandle) Preconditions.checkNotNull(savedStateHandle2);
            return this;
        }

        public TigerBoxApplication_HiltComponents.ViewModelC build() {
            Preconditions.checkBuilderRequirement(this.savedStateHandle, SavedStateHandle.class);
            return new ViewModelCImpl(this.singletonCImpl, this.activityRetainedCImpl, this.savedStateHandle);
        }
    }

    private static final class ServiceCBuilder implements TigerBoxApplication_HiltComponents.ServiceC.Builder {
        private Service service;
        private final SingletonCImpl singletonCImpl;

        private ServiceCBuilder(SingletonCImpl singletonCImpl2) {
            this.singletonCImpl = singletonCImpl2;
        }

        public ServiceCBuilder service(Service service2) {
            this.service = (Service) Preconditions.checkNotNull(service2);
            return this;
        }

        public TigerBoxApplication_HiltComponents.ServiceC build() {
            Preconditions.checkBuilderRequirement(this.service, Service.class);
            return new ServiceCImpl(this.singletonCImpl, this.service);
        }
    }

    private static final class ViewWithFragmentCImpl extends TigerBoxApplication_HiltComponents.ViewWithFragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewWithFragmentCImpl viewWithFragmentCImpl;

        private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, FragmentCImpl fragmentCImpl2, View view) {
            this.viewWithFragmentCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
            this.fragmentCImpl = fragmentCImpl2;
        }
    }

    private static final class FragmentCImpl extends TigerBoxApplication_HiltComponents.FragmentC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final FragmentCImpl fragmentCImpl;
        private final SingletonCImpl singletonCImpl;

        public void injectFullScreenSeekBarFragment(FullScreenSeekBarFragment fullScreenSeekBarFragment) {
        }

        public void injectMainContentHeaderFragment(MainContentHeaderFragment mainContentHeaderFragment) {
        }

        public void injectMediaPlayerChapterListFragment(MediaPlayerChapterListFragment mediaPlayerChapterListFragment) {
        }

        public void injectMediaPlayerFragment(MediaPlayerFragment mediaPlayerFragment) {
        }

        public void injectMultiProductCardFragment(MultiProductCardFragment multiProductCardFragment) {
        }

        public void injectOfflineModeFragment(OfflineModeFragment offlineModeFragment) {
        }

        public void injectOnboardingBackendCommunicationFragment(OnboardingBackendCommunicationFragment onboardingBackendCommunicationFragment) {
        }

        public void injectOnboardingStep1Screen1Fragment(OnboardingStep1Screen1Fragment onboardingStep1Screen1Fragment) {
        }

        public void injectOnboardingStep1Screen2Fragment(OnboardingStep1Screen2Fragment onboardingStep1Screen2Fragment) {
        }

        public void injectOnboardingStep1Screen3Fragment(OnboardingStep1Screen3Fragment onboardingStep1Screen3Fragment) {
        }

        public void injectOnboardingUpdateFragment(OnboardingUpdateFragment onboardingUpdateFragment) {
        }

        public void injectOnboardingWifiListFragment(OnboardingWifiListFragment onboardingWifiListFragment) {
        }

        public void injectParentalGateDisableStepFragment(ParentalGateDisableStepFragment parentalGateDisableStepFragment) {
        }

        public void injectParentalGateEnableStepFragment(ParentalGateEnableStepFragment parentalGateEnableStepFragment) {
        }

        public void injectParentalGateFragment(ParentalGateFragment parentalGateFragment) {
        }

        public void injectProductContentFragment(ProductContentFragment productContentFragment) {
        }

        public void injectProductListMainContentFragment(ProductListMainContentFragment productListMainContentFragment) {
        }

        public void injectResetDialogFragment(ResetDialogFragment resetDialogFragment) {
        }

        public void injectResetInProgressFragment(ResetInProgressFragment resetInProgressFragment) {
        }

        public void injectSeeMoreProductsFragment(SeeMoreProductsFragment seeMoreProductsFragment) {
        }

        public void injectSendLogsFinishedFragment(SendLogsFinishedFragment sendLogsFinishedFragment) {
        }

        public void injectSendLogsInProgressFragment(SendLogsInProgressFragment sendLogsInProgressFragment) {
        }

        public void injectSendLogsNoneFragment(SendLogsNoneFragment sendLogsNoneFragment) {
        }

        public void injectSettingsFragment(SettingsFragment settingsFragment) {
        }

        public void injectSettingsWifiFragment(SettingsWifiFragment settingsWifiFragment) {
        }

        public void injectSystemInfoFragment(SystemInfoFragment systemInfoFragment) {
        }

        public void injectTicketRedeemTicketNumberDialogFragment(TicketRedeemTicketNumberDialogFragment ticketRedeemTicketNumberDialogFragment) {
        }

        public void injectTigerTicketInputPinFragment(TigerTicketInputPinFragment tigerTicketInputPinFragment) {
        }

        public void injectTigerTicketPurchaseFragment(TigerTicketPurchaseFragment tigerTicketPurchaseFragment) {
        }

        public void injectTigerTicketValidFragment(TigerTicketValidFragment tigerTicketValidFragment) {
        }

        public void injectTimersSetupFragment(TimersSetupFragment timersSetupFragment) {
        }

        public void injectTimersSetupLimitSetupFragment(TimersSetupLimitSetupFragment timersSetupLimitSetupFragment) {
        }

        public void injectTimersSetupWindowSetupFragment(TimersSetupWindowSetupFragment timersSetupWindowSetupFragment) {
        }

        public void injectWifiEnterPasswordFragment(WifiEnterPasswordFragment wifiEnterPasswordFragment) {
        }

        public void injectWildCardReAssigningStep1Fragment(WildCardReAssigningStep1Fragment wildCardReAssigningStep1Fragment) {
        }

        public void injectWildCardReAssigningStep2Fragment(WildCardReAssigningStep2Fragment wildCardReAssigningStep2Fragment) {
        }

        private FragmentCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, Fragment fragment) {
            this.fragmentCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }

        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return this.activityCImpl.getHiltInternalFactoryFactory();
        }

        public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
            return new ViewWithFragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl, this.fragmentCImpl);
        }

        public void injectOnboardingBackendResponseFragment(OnboardingBackendResponseFragment onboardingBackendResponseFragment) {
            injectOnboardingBackendResponseFragment2(onboardingBackendResponseFragment);
        }

        private OnboardingBackendResponseFragment injectOnboardingBackendResponseFragment2(OnboardingBackendResponseFragment onboardingBackendResponseFragment) {
            OnboardingBackendResponseFragment_MembersInjector.injectMetaDataService(onboardingBackendResponseFragment, (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get());
            return onboardingBackendResponseFragment;
        }
    }

    private static final class ViewCImpl extends TigerBoxApplication_HiltComponents.ViewC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;
        private final ViewCImpl viewCImpl;

        private ViewCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ActivityCImpl activityCImpl2, View view) {
            this.viewCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            this.activityCImpl = activityCImpl2;
        }
    }

    private static final class ActivityCImpl extends TigerBoxApplication_HiltComponents.ActivityC {
        private final ActivityCImpl activityCImpl;
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private final SingletonCImpl singletonCImpl;

        private ActivityCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, Activity activity) {
            this.activityCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
        }

        public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
            return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(ApplicationContextModule_ProvideApplicationFactory.provideApplication(this.singletonCImpl.applicationContextModule), getViewModelKeys(), new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl));
        }

        public Set<String> getViewModelKeys() {
            return ImmutableSet.m314of(BaseViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ChapterListViewModel_HiltModules_KeyModule_ProvideFactory.provide(), FullScreenSeekBarViewModel_HiltModules_KeyModule_ProvideFactory.provide(), FullScreenViewModel_HiltModules_KeyModule_ProvideFactory.provide(), LaunchViewModel_HiltModules_KeyModule_ProvideFactory.provide(), C2964x2af827ff.provide(), MediaPlayerViewModel_HiltModules_KeyModule_ProvideFactory.provide(), OfflineModeViewModel_HiltModules_KeyModule_ProvideFactory.provide(), OnboardingActivityViewModel_HiltModules_KeyModule_ProvideFactory.provide(), C3004x887e5a76.provide(), C3008x9d992673.provide(), C2986xee60c5f4.provide(), OnboardingUpdateViewModel_HiltModules_KeyModule_ProvideFactory.provide(), OnboardingWifiViewModel_HiltModules_KeyModule_ProvideFactory.provide(), C3020xeaa764a.provide(), ParentalGateViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ProductContentViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ProfilePictureViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ProfilesViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ResetDialogViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ResetInProgressViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SendLogsFinishedViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SendLogsInProgressViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SendLogsNoneViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SettingsViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SettingsWifiViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SystemInfoViewModel_HiltModules_KeyModule_ProvideFactory.provide(), C3039x7c7ad376.provide(), TigerBoxActivityViewModel_HiltModules_KeyModule_ProvideFactory.provide(), C2933x2d51b54f.provide(), C2940x21648e65.provide(), C3028x60021d0a.provide(), TimersSetupViewModel_HiltModules_KeyModule_ProvideFactory.provide(), C3032xc74673f7.provide(), WifiEnterPasswordViewModel_HiltModules_KeyModule_ProvideFactory.provide(), WifiViewModel_HiltModules_KeyModule_ProvideFactory.provide(), C3043x2b4967d8.provide(), C3047xa0c38e19.provide());
        }

        public ViewModelComponentBuilder getViewModelComponentBuilder() {
            return new ViewModelCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        public FragmentComponentBuilder fragmentComponentBuilder() {
            return new FragmentCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        public ViewComponentBuilder viewComponentBuilder() {
            return new ViewCBuilder(this.singletonCImpl, this.activityRetainedCImpl, this.activityCImpl);
        }

        public void injectLauncherActivity(LauncherActivity launcherActivity) {
            injectLauncherActivity2(launcherActivity);
        }

        public void injectTigerBoxActivity(TigerBoxActivity tigerBoxActivity) {
            injectTigerBoxActivity2(tigerBoxActivity);
        }

        public void injectMainContentActivity(MainContentActivity mainContentActivity) {
            injectMainContentActivity2(mainContentActivity);
        }

        public void injectOnboardingActivity(OnboardingActivity onboardingActivity) {
            injectOnboardingActivity2(onboardingActivity);
        }

        public void injectSettingsActivity(SettingsActivity settingsActivity) {
            injectSettingsActivity2(settingsActivity);
        }

        private LauncherActivity injectLauncherActivity2(LauncherActivity launcherActivity) {
            LauncherActivity_MembersInjector.injectInfoSoundService(launcherActivity, (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get());
            return launcherActivity;
        }

        private TigerBoxActivity injectTigerBoxActivity2(TigerBoxActivity tigerBoxActivity) {
            TigerBoxActivity_MembersInjector.injectNfcService(tigerBoxActivity, (NfcService) this.singletonCImpl.provideNfcServiceProvider.get());
            return tigerBoxActivity;
        }

        private MainContentActivity injectMainContentActivity2(MainContentActivity mainContentActivity) {
            TigerBoxActivity_MembersInjector.injectNfcService(mainContentActivity, (NfcService) this.singletonCImpl.provideNfcServiceProvider.get());
            MainContentActivity_MembersInjector.injectWebServer(mainContentActivity, (WebServer) this.singletonCImpl.provideWebServerProvider.get());
            MainContentActivity_MembersInjector.injectStorageService(mainContentActivity, (StorageService) this.singletonCImpl.provideStorageProvider.get());
            MainContentActivity_MembersInjector.injectUpdateCheck(mainContentActivity, (UpdateCheck) this.singletonCImpl.provideUpdateCheckProvider.get());
            MainContentActivity_MembersInjector.injectTimersController(mainContentActivity, (TimersControllerService) this.singletonCImpl.provideTimersControllerProvider.get());
            MainContentActivity_MembersInjector.injectLockedModeService(mainContentActivity, (LockedModeService) this.singletonCImpl.provideLockedModeProvider.get());
            MainContentActivity_MembersInjector.injectPowerManagementService(mainContentActivity, (PowerManagementService) this.singletonCImpl.providePowerManagementServiceProvider.get());
            MainContentActivity_MembersInjector.injectConfigurationProperties(mainContentActivity, (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
            return mainContentActivity;
        }

        private OnboardingActivity injectOnboardingActivity2(OnboardingActivity onboardingActivity) {
            TigerBoxActivity_MembersInjector.injectNfcService(onboardingActivity, (NfcService) this.singletonCImpl.provideNfcServiceProvider.get());
            OnboardingActivity_MembersInjector.injectAudioPlayerService(onboardingActivity, (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get());
            return onboardingActivity;
        }

        private SettingsActivity injectSettingsActivity2(SettingsActivity settingsActivity) {
            TigerBoxActivity_MembersInjector.injectNfcService(settingsActivity, (NfcService) this.singletonCImpl.provideNfcServiceProvider.get());
            return settingsActivity;
        }
    }

    private static final class ViewModelCImpl extends TigerBoxApplication_HiltComponents.ViewModelC {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider<BaseViewModel> baseViewModelProvider;
        private Provider<ChapterListViewModel> chapterListViewModelProvider;
        private Provider<FullScreenSeekBarViewModel> fullScreenSeekBarViewModelProvider;
        private Provider<FullScreenViewModel> fullScreenViewModelProvider;
        private Provider<LaunchViewModel> launchViewModelProvider;
        private Provider<MainContentHeaderBarViewModel> mainContentHeaderBarViewModelProvider;
        private Provider<MediaPlayerViewModel> mediaPlayerViewModelProvider;
        private Provider<OfflineModeViewModel> offlineModeViewModelProvider;
        private Provider<OnboardingActivityViewModel> onboardingActivityViewModelProvider;
        private Provider<OnboardingBackendCommunicationViewModel> onboardingBackendCommunicationViewModelProvider;
        private Provider<OnboardingBackendResponseViewModel> onboardingBackendResponseViewModelProvider;
        private Provider<OnboardingStep1Screen1ViewModel> onboardingStep1Screen1ViewModelProvider;
        private Provider<OnboardingUpdateViewModel> onboardingUpdateViewModelProvider;
        private Provider<OnboardingWifiViewModel> onboardingWifiViewModelProvider;
        private Provider<ParentalGateEnableDisableStepViewModel> parentalGateEnableDisableStepViewModelProvider;
        private Provider<ParentalGateViewModel> parentalGateViewModelProvider;
        private Provider<ProductContentViewModel> productContentViewModelProvider;
        private Provider<ProfilePictureViewModel> profilePictureViewModelProvider;
        private Provider<ProfilesViewModel> profilesViewModelProvider;
        private Provider<ResetDialogViewModel> resetDialogViewModelProvider;
        private Provider<ResetInProgressViewModel> resetInProgressViewModelProvider;
        private Provider<SendLogsFinishedViewModel> sendLogsFinishedViewModelProvider;
        private Provider<SendLogsInProgressViewModel> sendLogsInProgressViewModelProvider;
        private Provider<SendLogsNoneViewModel> sendLogsNoneViewModelProvider;
        private Provider<SettingsViewModel> settingsViewModelProvider;
        private Provider<SettingsWifiViewModel> settingsWifiViewModelProvider;
        private final SingletonCImpl singletonCImpl;
        private Provider<SystemInfoViewModel> systemInfoViewModelProvider;
        private Provider<TicketRedeemTicketNumberViewModel> ticketRedeemTicketNumberViewModelProvider;
        private Provider<TigerBoxActivityViewModel> tigerBoxActivityViewModelProvider;
        private Provider<TigerTicketInputPinViewModel> tigerTicketInputPinViewModelProvider;
        private Provider<TigerTicketPurchaseViewModel> tigerTicketPurchaseViewModelProvider;
        private Provider<TimersSetupLimitSetupViewModel> timersSetupLimitSetupViewModelProvider;
        private Provider<TimersSetupViewModel> timersSetupViewModelProvider;
        private Provider<TimersSetupWindowSetupViewModel> timersSetupWindowSetupViewModelProvider;
        private final ViewModelCImpl viewModelCImpl;
        private Provider<WifiEnterPasswordViewModel> wifiEnterPasswordViewModelProvider;
        private Provider<WifiViewModel> wifiViewModelProvider;
        private Provider<WildCardReAssigningStep1ViewModel> wildCardReAssigningStep1ViewModelProvider;
        private Provider<WildCardReAssigningStep2ViewModel> wildCardReAssigningStep2ViewModelProvider;

        private ViewModelCImpl(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, SavedStateHandle savedStateHandle) {
            this.viewModelCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            this.activityRetainedCImpl = activityRetainedCImpl2;
            initialize(savedStateHandle);
        }

        /* access modifiers changed from: private */
        public OnboardingCompletedUseCase onboardingCompletedUseCase() {
            return new OnboardingCompletedUseCase((StorageService) this.singletonCImpl.provideStorageProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public FetchAndStoreAccessTokenUseCase fetchAndStoreAccessTokenUseCase() {
            return new FetchAndStoreAccessTokenUseCase((AccessTokenRepository) this.singletonCImpl.provideAccessTokenRepositoryProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public FetchAccountInfoUseCase fetchAccountInfoUseCase() {
            return new FetchAccountInfoUseCase((TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public AssignBoxToAccountUseCase assignBoxToAccountUseCase() {
            return new AssignBoxToAccountUseCase((TigerBoxWebService) this.singletonCImpl.provideTigerBoxServiceProvider.get(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public OnboardingCompleteActionUseCase onboardingCompleteActionUseCase() {
            return new OnboardingCompleteActionUseCase((StorageService) this.singletonCImpl.provideStorageProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public GetMainContentUseCase getMainContentUseCase() {
            return new GetMainContentUseCase((TigerBoxWebService) this.singletonCImpl.provideTigerBoxServiceProvider.get(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public AssignProfileToAccountUseCase assignProfileToAccountUseCase() {
            return new AssignProfileToAccountUseCase((TigerBoxWebService) this.singletonCImpl.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public TigerTicketValidatePinUseCase tigerTicketValidatePinUseCase() {
            return new TigerTicketValidatePinUseCase((TigerBoxWebService) this.singletonCImpl.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public TigerTicketPurchaseUseCase tigerTicketPurchaseUseCase() {
            return new TigerTicketPurchaseUseCase((TigerBoxWebService) this.singletonCImpl.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        private void initialize(SavedStateHandle savedStateHandle) {
            this.baseViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 0);
            this.chapterListViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 1);
            this.fullScreenSeekBarViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 2);
            this.fullScreenViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 3);
            this.launchViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 4);
            this.mainContentHeaderBarViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 5);
            this.mediaPlayerViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 6);
            this.offlineModeViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 7);
            this.onboardingActivityViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 8);
            this.onboardingBackendCommunicationViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 9);
            this.onboardingBackendResponseViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 10);
            this.onboardingStep1Screen1ViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 11);
            this.onboardingUpdateViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 12);
            this.onboardingWifiViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 13);
            this.parentalGateEnableDisableStepViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 14);
            this.parentalGateViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 15);
            this.productContentViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 16);
            this.profilePictureViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 17);
            this.profilesViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 18);
            this.resetDialogViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 19);
            this.resetInProgressViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 20);
            this.sendLogsFinishedViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 21);
            this.sendLogsInProgressViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 22);
            this.sendLogsNoneViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 23);
            this.settingsViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 24);
            this.settingsWifiViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 25);
            this.systemInfoViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 26);
            this.ticketRedeemTicketNumberViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 27);
            this.tigerBoxActivityViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 28);
            this.tigerTicketInputPinViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 29);
            this.tigerTicketPurchaseViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 30);
            this.timersSetupLimitSetupViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 31);
            this.timersSetupViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 32);
            this.timersSetupWindowSetupViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 33);
            this.wifiEnterPasswordViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 34);
            this.wifiViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 35);
            this.wildCardReAssigningStep1ViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 36);
            this.wildCardReAssigningStep2ViewModelProvider = new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, this.viewModelCImpl, 37);
        }

        public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
            return ImmutableMap.builderWithExpectedSize(38).put("media.tiger.tigerbox.ui.common.BaseViewModel", this.baseViewModelProvider).put("media.tiger.tigerbox.ui.main.mediaplayer.ChapterListViewModel", this.chapterListViewModelProvider).put("media.tiger.tigerbox.ui.settings.FullScreenSeekBarViewModel", this.fullScreenSeekBarViewModelProvider).put("media.tiger.tigerbox.ui.common.FullScreenViewModel", this.fullScreenViewModelProvider).put("media.tiger.tigerbox.ui.LaunchViewModel", this.launchViewModelProvider).put("media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel", this.mainContentHeaderBarViewModelProvider).put("media.tiger.tigerbox.ui.main.mediaplayer.MediaPlayerViewModel", this.mediaPlayerViewModelProvider).put("media.tiger.tigerbox.ui.main.offlinemode.OfflineModeViewModel", this.offlineModeViewModelProvider).put("media.tiger.tigerbox.ui.onboarding.OnboardingActivityViewModel", this.onboardingActivityViewModelProvider).put("media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendCommunicationViewModel", this.onboardingBackendCommunicationViewModelProvider).put("media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseViewModel", this.onboardingBackendResponseViewModelProvider).put("media.tiger.tigerbox.ui.onboarding.step1.OnboardingStep1Screen1ViewModel", this.onboardingStep1Screen1ViewModelProvider).put("media.tiger.tigerbox.ui.onboarding.step3.OnboardingUpdateViewModel", this.onboardingUpdateViewModelProvider).put("media.tiger.tigerbox.ui.onboarding.step2.OnboardingWifiViewModel", this.onboardingWifiViewModelProvider).put("media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel", this.parentalGateEnableDisableStepViewModelProvider).put("media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateViewModel", this.parentalGateViewModelProvider).put("media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel", this.productContentViewModelProvider).put("media.tiger.tigerbox.ui.main.profiles.ProfilePictureViewModel", this.profilePictureViewModelProvider).put("media.tiger.tigerbox.ui.main.profiles.ProfilesViewModel", this.profilesViewModelProvider).put("media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel", this.resetDialogViewModelProvider).put("media.tiger.tigerbox.ui.common.reset.ResetInProgressViewModel", this.resetInProgressViewModelProvider).put("media.tiger.tigerbox.ui.settings.sendLogs.SendLogsFinishedViewModel", this.sendLogsFinishedViewModelProvider).put("media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel", this.sendLogsInProgressViewModelProvider).put("media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel", this.sendLogsNoneViewModelProvider).put("media.tiger.tigerbox.ui.settings.SettingsViewModel", this.settingsViewModelProvider).put("media.tiger.tigerbox.ui.settings.SettingsWifiViewModel", this.settingsWifiViewModelProvider).put("media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel", this.systemInfoViewModelProvider).put("media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel", this.ticketRedeemTicketNumberViewModelProvider).put("media.tiger.tigerbox.ui.TigerBoxActivityViewModel", this.tigerBoxActivityViewModelProvider).put("media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel", this.tigerTicketInputPinViewModelProvider).put("media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel", this.tigerTicketPurchaseViewModelProvider).put("media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupLimitSetupViewModel", this.timersSetupLimitSetupViewModelProvider).put("media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupViewModel", this.timersSetupViewModelProvider).put("media.tiger.tigerbox.ui.settings.timersSetup.TimersSetupWindowSetupViewModel", this.timersSetupWindowSetupViewModelProvider).put("media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel", this.wifiEnterPasswordViewModelProvider).put("media.tiger.tigerbox.ui.common.wifi.WifiViewModel", this.wifiViewModelProvider).put("media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel", this.wildCardReAssigningStep1ViewModelProvider).put("media.tiger.tigerbox.ui.settings.wildcardreassigning.WildCardReAssigningStep2ViewModel", this.wildCardReAssigningStep2ViewModelProvider).build();
        }

        /* access modifiers changed from: private */
        public BaseViewModel injectBaseViewModel(BaseViewModel baseViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(baseViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return baseViewModel;
        }

        /* access modifiers changed from: private */
        public ChapterListViewModel injectChapterListViewModel(ChapterListViewModel chapterListViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(chapterListViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return chapterListViewModel;
        }

        /* access modifiers changed from: private */
        public FullScreenSeekBarViewModel injectFullScreenSeekBarViewModel(FullScreenSeekBarViewModel fullScreenSeekBarViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(fullScreenSeekBarViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return fullScreenSeekBarViewModel;
        }

        /* access modifiers changed from: private */
        public FullScreenViewModel injectFullScreenViewModel(FullScreenViewModel fullScreenViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(fullScreenViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return fullScreenViewModel;
        }

        /* access modifiers changed from: private */
        public MainContentHeaderBarViewModel injectMainContentHeaderBarViewModel(MainContentHeaderBarViewModel mainContentHeaderBarViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(mainContentHeaderBarViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return mainContentHeaderBarViewModel;
        }

        /* access modifiers changed from: private */
        public MediaPlayerViewModel injectMediaPlayerViewModel(MediaPlayerViewModel mediaPlayerViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(mediaPlayerViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return mediaPlayerViewModel;
        }

        /* access modifiers changed from: private */
        public OfflineModeViewModel injectOfflineModeViewModel(OfflineModeViewModel offlineModeViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(offlineModeViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return offlineModeViewModel;
        }

        /* access modifiers changed from: private */
        public OnboardingActivityViewModel injectOnboardingActivityViewModel(OnboardingActivityViewModel onboardingActivityViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(onboardingActivityViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return onboardingActivityViewModel;
        }

        /* access modifiers changed from: private */
        public OnboardingBackendCommunicationViewModel injectOnboardingBackendCommunicationViewModel(OnboardingBackendCommunicationViewModel onboardingBackendCommunicationViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(onboardingBackendCommunicationViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return onboardingBackendCommunicationViewModel;
        }

        /* access modifiers changed from: private */
        public OnboardingBackendResponseViewModel injectOnboardingBackendResponseViewModel(OnboardingBackendResponseViewModel onboardingBackendResponseViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(onboardingBackendResponseViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return onboardingBackendResponseViewModel;
        }

        /* access modifiers changed from: private */
        public OnboardingWifiViewModel injectOnboardingWifiViewModel(OnboardingWifiViewModel onboardingWifiViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(onboardingWifiViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return onboardingWifiViewModel;
        }

        /* access modifiers changed from: private */
        public ParentalGateEnableDisableStepViewModel injectParentalGateEnableDisableStepViewModel(ParentalGateEnableDisableStepViewModel parentalGateEnableDisableStepViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(parentalGateEnableDisableStepViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return parentalGateEnableDisableStepViewModel;
        }

        /* access modifiers changed from: private */
        public ParentalGateViewModel injectParentalGateViewModel(ParentalGateViewModel parentalGateViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(parentalGateViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return parentalGateViewModel;
        }

        /* access modifiers changed from: private */
        public ProductContentViewModel injectProductContentViewModel(ProductContentViewModel productContentViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(productContentViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return productContentViewModel;
        }

        /* access modifiers changed from: private */
        public ProfilePictureViewModel injectProfilePictureViewModel(ProfilePictureViewModel profilePictureViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(profilePictureViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return profilePictureViewModel;
        }

        /* access modifiers changed from: private */
        public ProfilesViewModel injectProfilesViewModel(ProfilesViewModel profilesViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(profilesViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return profilesViewModel;
        }

        /* access modifiers changed from: private */
        public ResetDialogViewModel injectResetDialogViewModel(ResetDialogViewModel resetDialogViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(resetDialogViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return resetDialogViewModel;
        }

        /* access modifiers changed from: private */
        public ResetInProgressViewModel injectResetInProgressViewModel(ResetInProgressViewModel resetInProgressViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(resetInProgressViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return resetInProgressViewModel;
        }

        /* access modifiers changed from: private */
        public SendLogsFinishedViewModel injectSendLogsFinishedViewModel(SendLogsFinishedViewModel sendLogsFinishedViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(sendLogsFinishedViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return sendLogsFinishedViewModel;
        }

        /* access modifiers changed from: private */
        public SendLogsInProgressViewModel injectSendLogsInProgressViewModel(SendLogsInProgressViewModel sendLogsInProgressViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(sendLogsInProgressViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return sendLogsInProgressViewModel;
        }

        /* access modifiers changed from: private */
        public SendLogsNoneViewModel injectSendLogsNoneViewModel(SendLogsNoneViewModel sendLogsNoneViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(sendLogsNoneViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return sendLogsNoneViewModel;
        }

        /* access modifiers changed from: private */
        public SettingsViewModel injectSettingsViewModel(SettingsViewModel settingsViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(settingsViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return settingsViewModel;
        }

        /* access modifiers changed from: private */
        public SettingsWifiViewModel injectSettingsWifiViewModel(SettingsWifiViewModel settingsWifiViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(settingsWifiViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return settingsWifiViewModel;
        }

        /* access modifiers changed from: private */
        public SystemInfoViewModel injectSystemInfoViewModel(SystemInfoViewModel systemInfoViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(systemInfoViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return systemInfoViewModel;
        }

        /* access modifiers changed from: private */
        public TicketRedeemTicketNumberViewModel injectTicketRedeemTicketNumberViewModel(TicketRedeemTicketNumberViewModel ticketRedeemTicketNumberViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(ticketRedeemTicketNumberViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return ticketRedeemTicketNumberViewModel;
        }

        /* access modifiers changed from: private */
        public TigerBoxActivityViewModel injectTigerBoxActivityViewModel(TigerBoxActivityViewModel tigerBoxActivityViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(tigerBoxActivityViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return tigerBoxActivityViewModel;
        }

        /* access modifiers changed from: private */
        public TigerTicketInputPinViewModel injectTigerTicketInputPinViewModel(TigerTicketInputPinViewModel tigerTicketInputPinViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(tigerTicketInputPinViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return tigerTicketInputPinViewModel;
        }

        /* access modifiers changed from: private */
        public TigerTicketPurchaseViewModel injectTigerTicketPurchaseViewModel(TigerTicketPurchaseViewModel tigerTicketPurchaseViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(tigerTicketPurchaseViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return tigerTicketPurchaseViewModel;
        }

        /* access modifiers changed from: private */
        public TimersSetupLimitSetupViewModel injectTimersSetupLimitSetupViewModel(TimersSetupLimitSetupViewModel timersSetupLimitSetupViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(timersSetupLimitSetupViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return timersSetupLimitSetupViewModel;
        }

        /* access modifiers changed from: private */
        public TimersSetupViewModel injectTimersSetupViewModel(TimersSetupViewModel timersSetupViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(timersSetupViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return timersSetupViewModel;
        }

        /* access modifiers changed from: private */
        public TimersSetupWindowSetupViewModel injectTimersSetupWindowSetupViewModel(TimersSetupWindowSetupViewModel timersSetupWindowSetupViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(timersSetupWindowSetupViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return timersSetupWindowSetupViewModel;
        }

        /* access modifiers changed from: private */
        public WifiEnterPasswordViewModel injectWifiEnterPasswordViewModel(WifiEnterPasswordViewModel wifiEnterPasswordViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(wifiEnterPasswordViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return wifiEnterPasswordViewModel;
        }

        /* access modifiers changed from: private */
        public WifiViewModel injectWifiViewModel(WifiViewModel wifiViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(wifiViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return wifiViewModel;
        }

        /* access modifiers changed from: private */
        public WildCardReAssigningStep1ViewModel injectWildCardReAssigningStep1ViewModel(WildCardReAssigningStep1ViewModel wildCardReAssigningStep1ViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(wildCardReAssigningStep1ViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return wildCardReAssigningStep1ViewModel;
        }

        /* access modifiers changed from: private */
        public WildCardReAssigningStep2ViewModel injectWildCardReAssigningStep2ViewModel(WildCardReAssigningStep2ViewModel wildCardReAssigningStep2ViewModel) {
            BaseViewModel_MembersInjector.inject_lightControl(wildCardReAssigningStep2ViewModel, (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get());
            return wildCardReAssigningStep2ViewModel;
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;

            /* renamed from: id */
            private final int f574id;
            private final SingletonCImpl singletonCImpl;
            private final ViewModelCImpl viewModelCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, ViewModelCImpl viewModelCImpl2, int i) {
                this.singletonCImpl = singletonCImpl2;
                this.activityRetainedCImpl = activityRetainedCImpl2;
                this.viewModelCImpl = viewModelCImpl2;
                this.f574id = i;
            }

            public T get() {
                switch (this.f574id) {
                    case 0:
                        return this.viewModelCImpl.injectBaseViewModel(BaseViewModel_Factory.newInstance());
                    case 1:
                        return this.viewModelCImpl.injectChapterListViewModel(ChapterListViewModel_Factory.newInstance((AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 2:
                        return this.viewModelCImpl.injectFullScreenSeekBarViewModel(FullScreenSeekBarViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get(), (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (ShutDownTimerService) this.singletonCImpl.provideSleepTimerServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get()));
                    case 3:
                        return this.viewModelCImpl.injectFullScreenViewModel(FullScreenViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 4:
                        return new LaunchViewModel(this.viewModelCImpl.onboardingCompletedUseCase());
                    case 5:
                        return this.viewModelCImpl.injectMainContentHeaderBarViewModel(MainContentHeaderBarViewModel_Factory.newInstance((StorageService) this.singletonCImpl.provideStorageProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 6:
                        return this.viewModelCImpl.injectMediaPlayerViewModel(MediaPlayerViewModel_Factory.newInstance((AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 7:
                        return this.viewModelCImpl.injectOfflineModeViewModel(OfflineModeViewModel_Factory.newInstance((AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (DisplayService) this.singletonCImpl.provideDisplayServiceProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get()));
                    case 8:
                        return this.viewModelCImpl.injectOnboardingActivityViewModel(OnboardingActivityViewModel_Factory.newInstance((WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get()));
                    case 9:
                        ViewModelCImpl viewModelCImpl2 = this.viewModelCImpl;
                        return viewModelCImpl2.injectOnboardingBackendCommunicationViewModel(OnboardingBackendCommunicationViewModel_Factory.newInstance(viewModelCImpl2.fetchAndStoreAccessTokenUseCase(), this.viewModelCImpl.fetchAccountInfoUseCase(), this.viewModelCImpl.assignBoxToAccountUseCase(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get(), this.viewModelCImpl.onboardingCompleteActionUseCase()));
                    case 10:
                        return this.viewModelCImpl.injectOnboardingBackendResponseViewModel(OnboardingBackendResponseViewModel_Factory.newInstance(this.singletonCImpl.removeAccountDataUseCase(), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get()));
                    case 11:
                        return new OnboardingStep1Screen1ViewModel((StorageService) this.singletonCImpl.provideStorageProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get(), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get());
                    case 12:
                        return new OnboardingUpdateViewModel((FirmwareUpdateService) this.singletonCImpl.provideFirmwareUpdateServiceProvider.get(), (BatteryService) this.singletonCImpl.provideBatteryServiceProvider.get());
                    case 13:
                        return this.viewModelCImpl.injectOnboardingWifiViewModel(OnboardingWifiViewModel_Factory.newInstance((WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get()));
                    case 14:
                        return this.viewModelCImpl.injectParentalGateEnableDisableStepViewModel(ParentalGateEnableDisableStepViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get()));
                    case 15:
                        return this.viewModelCImpl.injectParentalGateViewModel(ParentalGateViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get()));
                    case 16:
                        ViewModelCImpl viewModelCImpl3 = this.viewModelCImpl;
                        return viewModelCImpl3.injectProductContentViewModel(ProductContentViewModel_Factory.newInstance(viewModelCImpl3.getMainContentUseCase(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (ProductAcquisitionService) this.singletonCImpl.provideProductAcquisitionServiceProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), (PlaybackPositionService) this.singletonCImpl.providePlaybackPositionServiceProvider.get(), (LastUsedProductService) this.singletonCImpl.provideLastUsedProductServiceProvider.get(), (PlaybackTrackingService) this.singletonCImpl.providePlaybackTrackingServiceProvider.get(), (PowerManagementService) this.singletonCImpl.providePowerManagementServiceProvider.get(), (TigerCardsManagerService) this.singletonCImpl.provideTigerCardsManagerServiceProvider.get(), (NightLightTimerService) this.singletonCImpl.provideNightLightTimerServiceProvider.get(), (UpdateCheckTimerService) this.singletonCImpl.provideUpdateCheckTimerProvider.get(), this.singletonCImpl.mediaRestController(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), this.singletonCImpl.reportInformationUseCase(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeadsetService) this.singletonCImpl.provideHeadsetServiceProvider.get(), (BatteryService) this.singletonCImpl.provideBatteryServiceProvider.get(), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (GenerateCsr) this.singletonCImpl.provideGenerateCsrProvider.get(), (GetProductListRequest) this.singletonCImpl.provideGetProductListRequestProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get()));
                    case 17:
                        return this.viewModelCImpl.injectProfilePictureViewModel(ProfilePictureViewModel_Factory.newInstance((TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 18:
                        return this.viewModelCImpl.injectProfilesViewModel(ProfilesViewModel_Factory.newInstance((StorageService) this.singletonCImpl.provideStorageProvider.get(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), this.viewModelCImpl.assignProfileToAccountUseCase(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 19:
                        return this.viewModelCImpl.injectResetDialogViewModel(ResetDialogViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get()));
                    case 20:
                        return this.viewModelCImpl.injectResetInProgressViewModel(ResetInProgressViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get()));
                    case 21:
                        return this.viewModelCImpl.injectSendLogsFinishedViewModel(SendLogsFinishedViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get()));
                    case 22:
                        return this.viewModelCImpl.injectSendLogsInProgressViewModel(SendLogsInProgressViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (WriteToFileExceptionHandler) this.singletonCImpl.provideWriteToFileExceptionHandlerProvider.get(), (TigerBoxLogTree) this.singletonCImpl.provideTigerBoxLogTreeProvider.get()));
                    case 23:
                        return this.viewModelCImpl.injectSendLogsNoneViewModel(SendLogsNoneViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get()));
                    case 24:
                        return this.viewModelCImpl.injectSettingsViewModel(SettingsViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (TigerCardsManagerService) this.singletonCImpl.provideTigerCardsManagerServiceProvider.get(), this.singletonCImpl.accountSubscriptionService(), (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get(), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (ShutDownTimerService) this.singletonCImpl.provideSleepTimerServiceProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get(), (WriteToFileExceptionHandler) this.singletonCImpl.provideWriteToFileExceptionHandlerProvider.get(), (TigerBoxLogTree) this.singletonCImpl.provideTigerBoxLogTreeProvider.get(), (FirmwareUpdateService) this.singletonCImpl.provideFirmwareUpdateServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 25:
                        return this.viewModelCImpl.injectSettingsWifiViewModel(SettingsWifiViewModel_Factory.newInstance((WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), this.singletonCImpl.reportInformationUseCase(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get()));
                    case 26:
                        return this.viewModelCImpl.injectSystemInfoViewModel(SystemInfoViewModel_Factory.newInstance((ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 27:
                        return this.viewModelCImpl.injectTicketRedeemTicketNumberViewModel(TicketRedeemTicketNumberViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (TigerCardsManagerService) this.singletonCImpl.provideTigerCardsManagerServiceProvider.get(), this.singletonCImpl.tigerTicketGetProductUseCase()));
                    case 28:
                        return this.viewModelCImpl.injectTigerBoxActivityViewModel(TigerBoxActivityViewModel_Factory.newInstance((DisplayService) this.singletonCImpl.provideDisplayServiceProvider.get(), (SafeguardService) this.singletonCImpl.provideSafeguardServiceProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get()));
                    case 29:
                        return this.viewModelCImpl.injectTigerTicketInputPinViewModel(TigerTicketInputPinViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (TigerCardsManagerService) this.singletonCImpl.provideTigerCardsManagerServiceProvider.get(), this.viewModelCImpl.tigerTicketValidatePinUseCase()));
                    case 30:
                        return this.viewModelCImpl.injectTigerTicketPurchaseViewModel(TigerTicketPurchaseViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (TigerCardsManagerService) this.singletonCImpl.provideTigerCardsManagerServiceProvider.get(), this.viewModelCImpl.tigerTicketPurchaseUseCase()));
                    case 31:
                        return this.viewModelCImpl.injectTimersSetupLimitSetupViewModel(TimersSetupLimitSetupViewModel_Factory.newInstance((StorageService) this.singletonCImpl.provideStorageProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (TimersControllerService) this.singletonCImpl.provideTimersControllerProvider.get(), (TimeLimitTimerService) this.singletonCImpl.provideTimeLimitTimerServiceProvider.get(), (ShutDownTimerService) this.singletonCImpl.provideSleepTimerServiceProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 32:
                        return this.viewModelCImpl.injectTimersSetupViewModel(TimersSetupViewModel_Factory.newInstance((TimersControllerService) this.singletonCImpl.provideTimersControllerProvider.get(), (ShutDownTimerService) this.singletonCImpl.provideSleepTimerServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 33:
                        return this.viewModelCImpl.injectTimersSetupWindowSetupViewModel(TimersSetupWindowSetupViewModel_Factory.newInstance((StorageService) this.singletonCImpl.provideStorageProvider.get(), (TimersControllerService) this.singletonCImpl.provideTimersControllerProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (HeaderProvider) this.singletonCImpl.provideHeaderBarProvider.get()));
                    case 34:
                        return this.viewModelCImpl.injectWifiEnterPasswordViewModel(WifiEnterPasswordViewModel_Factory.newInstance((StorageService) this.singletonCImpl.provideStorageProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get()));
                    case 35:
                        return this.viewModelCImpl.injectWifiViewModel(WifiViewModel_Factory.newInstance((WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get(), (ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get()));
                    case 36:
                        return this.viewModelCImpl.injectWildCardReAssigningStep1ViewModel(WildCardReAssigningStep1ViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (TigerCardsManagerService) this.singletonCImpl.provideTigerCardsManagerServiceProvider.get()));
                    case 37:
                        return this.viewModelCImpl.injectWildCardReAssigningStep2ViewModel(WildCardReAssigningStep2ViewModel_Factory.newInstance((ButtonService) this.singletonCImpl.provideButtonServiceProvider.get(), (TigerCardsManagerService) this.singletonCImpl.provideTigerCardsManagerServiceProvider.get(), this.singletonCImpl.getTigerBoxAccountUseCase()));
                    default:
                        throw new AssertionError(this.f574id);
                }
            }
        }
    }

    private static final class ActivityRetainedCImpl extends TigerBoxApplication_HiltComponents.ActivityRetainedC {
        private final ActivityRetainedCImpl activityRetainedCImpl;
        private Provider lifecycleProvider;
        private final SingletonCImpl singletonCImpl;

        private ActivityRetainedCImpl(SingletonCImpl singletonCImpl2) {
            this.activityRetainedCImpl = this;
            this.singletonCImpl = singletonCImpl2;
            initialize();
        }

        private void initialize() {
            this.lifecycleProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, this.activityRetainedCImpl, 0));
        }

        public ActivityComponentBuilder activityComponentBuilder() {
            return new ActivityCBuilder(this.singletonCImpl, this.activityRetainedCImpl);
        }

        public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
            return (ActivityRetainedLifecycle) this.lifecycleProvider.get();
        }

        private static final class SwitchingProvider<T> implements Provider<T> {
            private final ActivityRetainedCImpl activityRetainedCImpl;

            /* renamed from: id */
            private final int f572id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl2, ActivityRetainedCImpl activityRetainedCImpl2, int i) {
                this.singletonCImpl = singletonCImpl2;
                this.activityRetainedCImpl = activityRetainedCImpl2;
                this.f572id = i;
            }

            public T get() {
                if (this.f572id == 0) {
                    return ActivityRetainedComponentManager_Lifecycle_Factory.newInstance();
                }
                throw new AssertionError(this.f572id);
            }
        }
    }

    private static final class ServiceCImpl extends TigerBoxApplication_HiltComponents.ServiceC {
        private final ServiceCImpl serviceCImpl;
        private final SingletonCImpl singletonCImpl;

        private ServiceCImpl(SingletonCImpl singletonCImpl2, Service service) {
            this.serviceCImpl = this;
            this.singletonCImpl = singletonCImpl2;
        }
    }

    private static final class SingletonCImpl extends TigerBoxApplication_HiltComponents.SingletonC {
        /* access modifiers changed from: private */
        public final ApplicationContextModule applicationContextModule;
        /* access modifiers changed from: private */
        public Provider<AccessTokenRepository> provideAccessTokenRepositoryProvider;
        /* access modifiers changed from: private */
        public Provider<AlarmManager> provideAlarmManagerProvider;
        private Provider<AssetService> provideAssetServiceProvider;
        /* access modifiers changed from: private */
        public Provider<AudioManager> provideAudioManagerProvider;
        /* access modifiers changed from: private */
        public Provider<AudioPlayerService> provideAudioPlayerServiceProvider;
        /* access modifiers changed from: private */
        public Provider<AvailabilityService> provideAvailabilityServiceProvider;
        private Provider<Base64Converter> provideBase64ConverterProvider;
        /* access modifiers changed from: private */
        public Provider<BatteryService> provideBatteryServiceProvider;
        /* access modifiers changed from: private */
        public Provider<ButtonService> provideButtonServiceProvider;
        /* access modifiers changed from: private */
        public Provider<ConfigurationProperties> provideConfigurationPropertiesProvider;
        /* access modifiers changed from: private */
        public Provider<DatabaseMigrationService> provideDatabaseMigrationServiceProvider;
        /* access modifiers changed from: private */
        public Provider<TigerBoxDatabase> provideDatabaseProvider;
        /* access modifiers changed from: private */
        public Provider<DisplayService> provideDisplayServiceProvider;
        private Provider<DownloadProgressUpdate> provideDownloadProgressNotifierProvider;
        /* access modifiers changed from: private */
        public Provider<DownloadsManagerService> provideDownloadsManagerServiceProvider;
        /* access modifiers changed from: private */
        public Provider<DownloadsWebService> provideDownloadsWebServiceProvider;
        /* access modifiers changed from: private */
        public Provider<SharedPreferences> provideEncryptedSharedPreferencesProvider;
        private Provider<EngageDeepSleep> provideEngageDeepSleepProvider;
        /* access modifiers changed from: private */
        public Provider<FirmwareUpdateService> provideFirmwareUpdateServiceProvider;
        /* access modifiers changed from: private */
        public Provider<GenerateCsr> provideGenerateCsrProvider;
        /* access modifiers changed from: private */
        public Provider<GetProductListRequest> provideGetProductListRequestProvider;
        /* access modifiers changed from: private */
        public Provider<HeaderProvider> provideHeaderBarProvider;
        /* access modifiers changed from: private */
        public Provider<HeadsetService> provideHeadsetServiceProvider;
        /* access modifiers changed from: private */
        public Provider<HlsKeyProviderService> provideHlsKeyProviderServiceProvider;
        /* access modifiers changed from: private */
        public Provider<HlsKeysRepository> provideHlsKeysRepositoryProvider;
        /* access modifiers changed from: private */
        public Provider<InfoSoundService> provideInfoSoundServiceProvider;
        private Provider<InitServices> provideInitServicesProvider;
        private Provider<LargeDownloadHandler> provideLargeDownloadHandlerProvider;
        /* access modifiers changed from: private */
        public Provider<LastUsedProductService> provideLastUsedProductServiceProvider;
        /* access modifiers changed from: private */
        public Provider<LightControlService> provideLightControlServiceProvider;
        /* access modifiers changed from: private */
        public Provider<LockedModeService> provideLockedModeProvider;
        /* access modifiers changed from: private */
        public Provider<MetaDataService> provideMetaDataServiceProvider;
        /* access modifiers changed from: private */
        public Provider<NfcService> provideNfcServiceProvider;
        /* access modifiers changed from: private */
        public Provider<NightLightTimerService> provideNightLightTimerServiceProvider;
        /* access modifiers changed from: private */
        public Provider<ReauthenticationLoginHandler> provideOpenLoginScreenProvider;
        private Provider<OtaWebService> provideOtaWebServiceProvider;
        /* access modifiers changed from: private */
        public Provider<PlaybackPositionService> providePlaybackPositionServiceProvider;
        /* access modifiers changed from: private */
        public Provider<PlaybackPositionsRepository> providePlaybackPositionsRepositoryProvider;
        /* access modifiers changed from: private */
        public Provider<PlaybackTrackingRepository> providePlaybackTrackingRepositoryProvider;
        /* access modifiers changed from: private */
        public Provider<PlaybackTrackingService> providePlaybackTrackingServiceProvider;
        /* access modifiers changed from: private */
        public Provider<PowerManagementService> providePowerManagementServiceProvider;
        /* access modifiers changed from: private */
        public Provider<PowerManager> providePowerManagerProvider;
        /* access modifiers changed from: private */
        public Provider<ProductAcquisitionService> provideProductAcquisitionServiceProvider;
        /* access modifiers changed from: private */
        public Provider<InstallFirmware> provideReadyToUpdateProvider;
        /* access modifiers changed from: private */
        public Provider<RequiresUpdate> provideRequiresUpdateProvider;
        private Provider<RestartServicesSafely> provideRestartServicesSafelyProvider;
        /* access modifiers changed from: private */
        public Provider<SafeguardService> provideSafeguardServiceProvider;
        private Provider<ScalarTigerBoxWebService> provideScalarTigerBoxServiceProvider;
        private Provider<DigestValidator> provideSignatureValidatorProvider;
        /* access modifiers changed from: private */
        public Provider<ShutDownTimerService> provideSleepTimerServiceProvider;
        /* access modifiers changed from: private */
        public Provider<StorageService> provideStorageProvider;
        /* access modifiers changed from: private */
        public Provider<TigerBoxAccountRepository> provideTigerBoxAccountRepositoryProvider;
        /* access modifiers changed from: private */
        public Provider<TigerBoxLogTree> provideTigerBoxLogTreeProvider;
        /* access modifiers changed from: private */
        public Provider<TigerBoxWebService> provideTigerBoxServiceProvider;
        /* access modifiers changed from: private */
        public Provider<TigerCardsManagerService> provideTigerCardsManagerServiceProvider;
        /* access modifiers changed from: private */
        public Provider<TimeLimitTimerService> provideTimeLimitTimerServiceProvider;
        /* access modifiers changed from: private */
        public Provider<TimeService> provideTimeServiceProvider;
        /* access modifiers changed from: private */
        public Provider<TimersControllerService> provideTimersControllerProvider;
        /* access modifiers changed from: private */
        public Provider<UpdateCheck> provideUpdateCheckProvider;
        /* access modifiers changed from: private */
        public Provider<UpdateCheckTimerService> provideUpdateCheckTimerProvider;
        /* access modifiers changed from: private */
        public Provider<WakeService> provideWakeServiceProvider;
        /* access modifiers changed from: private */
        public Provider<WebServer> provideWebServerProvider;
        /* access modifiers changed from: private */
        public Provider<WifiService> provideWifiServiceProvider;
        /* access modifiers changed from: private */
        public Provider<WindowedLimitTimeService> provideWindowedLimitTimerServiceProvider;
        /* access modifiers changed from: private */
        public Provider<WriteToFileExceptionHandler> provideWriteToFileExceptionHandlerProvider;
        private final SingletonCImpl singletonCImpl;

        private SingletonCImpl(ApplicationContextModule applicationContextModule2) {
            this.singletonCImpl = this;
            this.applicationContextModule = applicationContextModule2;
            initialize(applicationContextModule2);
        }

        /* access modifiers changed from: private */
        public DeepSleepTimerService deepSleepTimerService() {
            return new DeepSleepTimerService(this.provideConfigurationPropertiesProvider.get(), this.provideEngageDeepSleepProvider.get(), this.provideRestartServicesSafelyProvider.get());
        }

        /* access modifiers changed from: private */
        public DataMigrationService dataMigrationService() {
            return ServiceModule_ProvideMigrationServiceFactory.provideMigrationService(this.provideEncryptedSharedPreferencesProvider.get(), this.provideDatabaseProvider.get());
        }

        private GetAccessTokenUseCase getAccessTokenUseCase() {
            return new GetAccessTokenUseCase(this.provideAccessTokenRepositoryProvider);
        }

        private RequestReAuthAndStoreTokenUseCase requestReAuthAndStoreTokenUseCase() {
            return new RequestReAuthAndStoreTokenUseCase(this.provideAccessTokenRepositoryProvider, CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public RemoveAccountDataUseCase removeAccountDataUseCase() {
            return new RemoveAccountDataUseCase(this.provideAccessTokenRepositoryProvider, this.provideTigerBoxAccountRepositoryProvider, CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public OkHttpClient authInterceptorOkHttpClientOkHttpClient() {
            return HttpClientModule_ProvideAuthInterceptorOkHttpClientFactory.provideAuthInterceptorOkHttpClient(this.provideOpenLoginScreenProvider.get(), getAccessTokenUseCase(), requestReAuthAndStoreTokenUseCase(), removeAccountDataUseCase(), this.provideConfigurationPropertiesProvider.get());
        }

        /* access modifiers changed from: private */
        public OkHttpClient downloadsOkHttpClientOkHttpClient() {
            return HttpClientModule_ProvideDownloadsOkHttpClientFactory.provideDownloadsOkHttpClient(this.provideOpenLoginScreenProvider.get(), this.provideConfigurationPropertiesProvider.get(), getAccessTokenUseCase(), requestReAuthAndStoreTokenUseCase(), removeAccountDataUseCase());
        }

        /* access modifiers changed from: private */
        public GetTigerBoxAccountUseCase getTigerBoxAccountUseCase() {
            return new GetTigerBoxAccountUseCase(this.provideTigerBoxAccountRepositoryProvider.get());
        }

        /* access modifiers changed from: private */
        public GetProductAssetsUseCase getProductAssetsUseCase() {
            return new GetProductAssetsUseCase(this.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public GetProductDetailsUseCase getProductDetailsUseCase() {
            return new GetProductDetailsUseCase(this.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public RequestAcquisitionUseCase requestAcquisitionUseCase() {
            return new RequestAcquisitionUseCase(this.provideTigerBoxServiceProvider.get(), this.provideConfigurationPropertiesProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public CheckAcquisitionsUseCase checkAcquisitionsUseCase() {
            return new CheckAcquisitionsUseCase(this.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public PostCrashLogsUseCase postCrashLogsUseCase() {
            return new PostCrashLogsUseCase(this.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public OkHttpClient otaWebServiceOkHttpClientOkHttpClient() {
            return HttpClientModule_ProvideOtaWebServiceOkHttpClientFactory.provideOtaWebServiceOkHttpClient(this.provideConfigurationPropertiesProvider.get(), this.provideDownloadProgressNotifierProvider.get());
        }

        /* access modifiers changed from: private */
        public CheckForUpdateUseCase checkForUpdateUseCase() {
            return new CheckForUpdateUseCase(this.provideOtaWebServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher(), this.provideConfigurationPropertiesProvider.get());
        }

        /* access modifiers changed from: private */
        public ValidateUpdateSignature validateUpdateSignature() {
            return new ValidateUpdateSignature(this.provideOtaWebServiceProvider.get(), this.provideSignatureValidatorProvider.get(), this.provideAssetServiceProvider.get(), this.provideBase64ConverterProvider.get(), this.provideLargeDownloadHandlerProvider.get());
        }

        /* access modifiers changed from: private */
        public DownloadFirmware downloadFirmware() {
            return new DownloadFirmware(this.provideOtaWebServiceProvider.get(), this.provideSignatureValidatorProvider.get(), this.provideAssetServiceProvider.get(), this.provideStorageProvider.get(), this.provideDownloadProgressNotifierProvider.get(), this.provideBase64ConverterProvider.get(), this.provideLargeDownloadHandlerProvider.get(), this.provideConfigurationPropertiesProvider.get());
        }

        /* access modifiers changed from: private */
        public DecryptFirmware decryptFirmware() {
            return new DecryptFirmware(this.provideAssetServiceProvider.get(), this.provideStorageProvider.get(), this.provideBase64ConverterProvider.get());
        }

        private AdbEnabler adbEnabler() {
            return ProcessModule_ProvideAdbEnablerFactory.provideAdbEnabler(ApplicationContextModule_ProvideContextFactory.provideContext(this.applicationContextModule));
        }

        /* access modifiers changed from: private */
        public ReportInformationUseCase reportInformationUseCase() {
            return new ReportInformationUseCase(this.provideTigerBoxServiceProvider.get(), this.provideStorageProvider.get(), adbEnabler(), this.provideConfigurationPropertiesProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public GetPlayStatesUseCase getPlayStatesUseCase() {
            return new GetPlayStatesUseCase(this.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public PostPlayStateUseCase postPlayStateUseCase() {
            return new PostPlayStateUseCase(this.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public ReportLastCardProductUseCase reportLastCardProductUseCase() {
            return new ReportLastCardProductUseCase(this.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public PostTrackingEventUseCase postTrackingEventUseCase() {
            return new PostTrackingEventUseCase(this.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public GetValidTigerCardUseCase getValidTigerCardUseCase() {
            return new GetValidTigerCardUseCase(this.provideTigerBoxServiceProvider.get(), this.provideConfigurationPropertiesProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public TigerTicketGetProductUseCase tigerTicketGetProductUseCase() {
            return new TigerTicketGetProductUseCase(this.provideTigerBoxServiceProvider.get(), this.provideConfigurationPropertiesProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public WildCardReassignUseCase wildCardReassignUseCase() {
            return new WildCardReassignUseCase(this.provideTigerBoxServiceProvider.get(), this.provideConfigurationPropertiesProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public MediaRestController mediaRestController() {
            return WebServerModule_ProvideMediaRestControllerFactory.provideMediaRestController(this.provideWebServerProvider.get());
        }

        /* access modifiers changed from: private */
        public RequestPemCertificateUseCase requestPemCertificateUseCase() {
            return new RequestPemCertificateUseCase(this.provideScalarTigerBoxServiceProvider.get());
        }

        private GetSubscriptionsUseCase getSubscriptionsUseCase() {
            return new GetSubscriptionsUseCase(this.provideTigerBoxServiceProvider.get(), CoroutinesModule_ProvidesIoDispatcherFactory.providesIoDispatcher());
        }

        /* access modifiers changed from: private */
        public AccountSubscriptionService accountSubscriptionService() {
            return ServiceModule_ProvideAccountSubscriptionServiceFactory.provideAccountSubscriptionService(getTigerBoxAccountUseCase(), this.provideEncryptedSharedPreferencesProvider.get(), getSubscriptionsUseCase());
        }

        private void initialize(ApplicationContextModule applicationContextModule2) {
            this.provideEncryptedSharedPreferencesProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 1));
            this.provideConfigurationPropertiesProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 0));
            this.provideDisplayServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 4));
            this.provideAudioManagerProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 8));
            this.provideStorageProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 7));
            this.provideInfoSoundServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 6));
            this.provideLightControlServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 9));
            this.provideBatteryServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 5));
            this.provideEngageDeepSleepProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 10));
            this.provideRestartServicesSafelyProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 11));
            this.provideOpenLoginScreenProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 15));
            this.provideDatabaseProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 18));
            this.provideDatabaseMigrationServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 17));
            this.provideTimeServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 19));
            this.provideAccessTokenRepositoryProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 16));
            this.provideTigerBoxAccountRepositoryProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 20));
            this.provideTigerBoxServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 14));
            this.provideHlsKeysRepositoryProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 21));
            this.provideHlsKeyProviderServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 13));
            this.provideWifiServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 24));
            this.provideDownloadsWebServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 25));
            this.provideDownloadsManagerServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 23));
            this.providePowerManagerProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 27));
            this.provideWakeServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 26));
            this.provideAvailabilityServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 22));
            this.provideProductAcquisitionServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 28));
            this.provideAlarmManagerProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 31));
            this.provideTimeLimitTimerServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 30));
            this.provideWindowedLimitTimerServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 32));
            this.provideLockedModeProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 29));
            this.provideAudioPlayerServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 12));
            this.providePowerManagementServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 3));
            this.provideInitServicesProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 2));
            this.provideNightLightTimerServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 34));
            this.provideSleepTimerServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 35));
            this.provideTimersControllerProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 36));
            this.provideMetaDataServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 33));
            this.provideSafeguardServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 37));
            this.provideWriteToFileExceptionHandlerProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 38));
            this.provideDownloadProgressNotifierProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 42));
            this.provideOtaWebServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 41));
            this.provideSignatureValidatorProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 43));
            this.provideAssetServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 44));
            this.provideBase64ConverterProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 45));
            this.provideLargeDownloadHandlerProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 46));
            this.provideReadyToUpdateProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 47));
            this.provideRequiresUpdateProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 48));
            this.provideFirmwareUpdateServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 40));
            this.provideUpdateCheckTimerProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 39));
            this.provideNfcServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 49));
            this.provideButtonServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 50));
            this.provideHeadsetServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 51));
            this.provideWebServerProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 52));
            this.provideUpdateCheckProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 53));
            this.provideHeaderBarProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 54));
            this.providePlaybackPositionsRepositoryProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 56));
            this.providePlaybackPositionServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 55));
            this.provideLastUsedProductServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 57));
            this.providePlaybackTrackingRepositoryProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 59));
            this.providePlaybackTrackingServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 58));
            this.provideTigerCardsManagerServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 60));
            this.provideScalarTigerBoxServiceProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 62));
            this.provideGenerateCsrProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 61));
            this.provideGetProductListRequestProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 63));
            this.provideTigerBoxLogTreeProvider = DoubleCheck.provider(new SwitchingProvider(this.singletonCImpl, 64));
        }

        public Set<Boolean> getDisableFragmentGetContextFix() {
            return ImmutableSet.m308of();
        }

        public ActivityRetainedComponentBuilder retainedComponentBuilder() {
            return new ActivityRetainedCBuilder(this.singletonCImpl);
        }

        public ServiceComponentBuilder serviceComponentBuilder() {
            return new ServiceCBuilder(this.singletonCImpl);
        }

        public void injectTigerBoxApplication(TigerBoxApplication tigerBoxApplication) {
            injectTigerBoxApplication2(tigerBoxApplication);
        }

        public void injectAdbReceiver(AdbReceiver adbReceiver) {
            injectAdbReceiver2(adbReceiver);
        }

        public void injectButtonBroadcastReceiver(ButtonBroadcastReceiver buttonBroadcastReceiver) {
            injectButtonBroadcastReceiver2(buttonBroadcastReceiver);
        }

        public void injectDateChangeBroadcastReceiver(DateChangeBroadcastReceiver dateChangeBroadcastReceiver) {
            injectDateChangeBroadcastReceiver2(dateChangeBroadcastReceiver);
        }

        public void injectDisplayBroadcastReceiver(DisplayBroadcastReceiver displayBroadcastReceiver) {
            injectDisplayBroadcastReceiver2(displayBroadcastReceiver);
        }

        public void injectHeadsetBroadcastReceiver(HeadsetBroadcastReceiver headsetBroadcastReceiver) {
            injectHeadsetBroadcastReceiver2(headsetBroadcastReceiver);
        }

        public void injectNfcBroadcastReceiver(NfcBroadcastReceiver nfcBroadcastReceiver) {
            injectNfcBroadcastReceiver2(nfcBroadcastReceiver);
        }

        public void injectSafeguardBroadcastReceiver(SafeguardBroadcastReceiver safeguardBroadcastReceiver) {
            injectSafeguardBroadcastReceiver2(safeguardBroadcastReceiver);
        }

        public void injectWindowedLimitBroadcastReceiver(WindowedLimitBroadcastReceiver windowedLimitBroadcastReceiver) {
            injectWindowedLimitBroadcastReceiver2(windowedLimitBroadcastReceiver);
        }

        private TigerBoxApplication injectTigerBoxApplication2(TigerBoxApplication tigerBoxApplication) {
            TigerBoxApplication_MembersInjector.injectConfigurationProperties(tigerBoxApplication, this.provideConfigurationPropertiesProvider.get());
            TigerBoxApplication_MembersInjector.injectInitServices(tigerBoxApplication, this.provideInitServicesProvider.get());
            TigerBoxApplication_MembersInjector.injectMetaDataService(tigerBoxApplication, this.provideMetaDataServiceProvider.get());
            TigerBoxApplication_MembersInjector.injectStorageService(tigerBoxApplication, this.provideStorageProvider.get());
            TigerBoxApplication_MembersInjector.injectWifiService(tigerBoxApplication, this.provideWifiServiceProvider.get());
            TigerBoxApplication_MembersInjector.injectSafeguardService(tigerBoxApplication, this.provideSafeguardServiceProvider.get());
            TigerBoxApplication_MembersInjector.injectPostCrashLogsUseCase(tigerBoxApplication, postCrashLogsUseCase());
            TigerBoxApplication_MembersInjector.injectWriteToFileExceptionHandler(tigerBoxApplication, this.provideWriteToFileExceptionHandlerProvider.get());
            return tigerBoxApplication;
        }

        private AdbReceiver injectAdbReceiver2(AdbReceiver adbReceiver) {
            AdbReceiver_MembersInjector.injectConfigurationProperties(adbReceiver, this.provideConfigurationPropertiesProvider.get());
            AdbReceiver_MembersInjector.injectProductAcquisitionService(adbReceiver, this.provideProductAcquisitionServiceProvider.get());
            AdbReceiver_MembersInjector.injectUpdateCheckTimerService(adbReceiver, this.provideUpdateCheckTimerProvider.get());
            AdbReceiver_MembersInjector.injectStorageService(adbReceiver, this.provideStorageProvider.get());
            AdbReceiver_MembersInjector.injectNfcService(adbReceiver, this.provideNfcServiceProvider.get());
            AdbReceiver_MembersInjector.injectTimeLimitController(adbReceiver, this.provideTimersControllerProvider.get());
            AdbReceiver_MembersInjector.injectAccountRepository(adbReceiver, this.provideTigerBoxAccountRepositoryProvider.get());
            AdbReceiver_MembersInjector.injectAccessTokenRepository(adbReceiver, this.provideAccessTokenRepositoryProvider.get());
            AdbReceiver_MembersInjector.injectTimeService(adbReceiver, this.provideTimeServiceProvider.get());
            return adbReceiver;
        }

        private ButtonBroadcastReceiver injectButtonBroadcastReceiver2(ButtonBroadcastReceiver buttonBroadcastReceiver) {
            ButtonBroadcastReceiver_MembersInjector.injectButtonService(buttonBroadcastReceiver, this.provideButtonServiceProvider.get());
            return buttonBroadcastReceiver;
        }

        private DateChangeBroadcastReceiver injectDateChangeBroadcastReceiver2(DateChangeBroadcastReceiver dateChangeBroadcastReceiver) {
            DateChangeBroadcastReceiver_MembersInjector.injectLimitTimer(dateChangeBroadcastReceiver, this.provideTimersControllerProvider.get());
            return dateChangeBroadcastReceiver;
        }

        private DisplayBroadcastReceiver injectDisplayBroadcastReceiver2(DisplayBroadcastReceiver displayBroadcastReceiver) {
            DisplayBroadcastReceiver_MembersInjector.injectDisplayService(displayBroadcastReceiver, this.provideDisplayServiceProvider.get());
            return displayBroadcastReceiver;
        }

        private HeadsetBroadcastReceiver injectHeadsetBroadcastReceiver2(HeadsetBroadcastReceiver headsetBroadcastReceiver) {
            HeadsetBroadcastReceiver_MembersInjector.injectHeadsetService(headsetBroadcastReceiver, this.provideHeadsetServiceProvider.get());
            return headsetBroadcastReceiver;
        }

        private NfcBroadcastReceiver injectNfcBroadcastReceiver2(NfcBroadcastReceiver nfcBroadcastReceiver) {
            NfcBroadcastReceiver_MembersInjector.injectNfcService(nfcBroadcastReceiver, this.provideNfcServiceProvider.get());
            return nfcBroadcastReceiver;
        }

        private SafeguardBroadcastReceiver injectSafeguardBroadcastReceiver2(SafeguardBroadcastReceiver safeguardBroadcastReceiver) {
            SafeguardBroadcastReceiver_MembersInjector.injectService(safeguardBroadcastReceiver, this.provideSafeguardServiceProvider.get());
            return safeguardBroadcastReceiver;
        }

        private WindowedLimitBroadcastReceiver injectWindowedLimitBroadcastReceiver2(WindowedLimitBroadcastReceiver windowedLimitBroadcastReceiver) {
            WindowedLimitBroadcastReceiver_MembersInjector.injectLimitTimer(windowedLimitBroadcastReceiver, this.provideTimersControllerProvider.get());
            return windowedLimitBroadcastReceiver;
        }

        private static final class SwitchingProvider<T> implements Provider<T> {

            /* renamed from: id */
            private final int f573id;
            private final SingletonCImpl singletonCImpl;

            SwitchingProvider(SingletonCImpl singletonCImpl2, int i) {
                this.singletonCImpl = singletonCImpl2;
                this.f573id = i;
            }

            public T get() {
                switch (this.f573id) {
                    case 0:
                        return C2865x2b05c698.provideConfigurationProperties(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (SharedPreferences) this.singletonCImpl.provideEncryptedSharedPreferencesProvider.get());
                    case 1:
                        return StorageModule_ProvideEncryptedSharedPreferencesFactory.provideEncryptedSharedPreferences(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 2:
                        return ProcessModule_ProvideInitServicesFactory.provideInitServices(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (PowerManagementService) this.singletonCImpl.providePowerManagementServiceProvider.get());
                    case 3:
                        return ServiceModule_ProvidePowerManagementServiceFactory.providePowerManagementService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (DisplayService) this.singletonCImpl.provideDisplayServiceProvider.get(), (BatteryService) this.singletonCImpl.provideBatteryServiceProvider.get(), this.singletonCImpl.deepSleepTimerService(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get());
                    case 4:
                        return ServiceModule_ProvideDisplayServiceFactory.provideDisplayService();
                    case 5:
                        return ServiceModule_ProvideBatteryServiceFactory.provideBatteryService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get(), (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get(), (DisplayService) this.singletonCImpl.provideDisplayServiceProvider.get());
                    case 6:
                        return ServiceModule_ProvideInfoSoundServiceFactory.provideInfoSoundService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (StorageService) this.singletonCImpl.provideStorageProvider.get());
                    case 7:
                        return StorageModule_ProvideStorageProviderFactory.provideStorageProvider(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (SharedPreferences) this.singletonCImpl.provideEncryptedSharedPreferencesProvider.get(), (AudioManager) this.singletonCImpl.provideAudioManagerProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 8:
                        return AndroidModule_ProvideAudioManagerFactory.provideAudioManager(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 9:
                        return ServiceModule_ProvideLightControlServiceFactory.provideLightControlService((StorageService) this.singletonCImpl.provideStorageProvider.get());
                    case 10:
                        return ProcessModule_ProvideEngageDeepSleepFactory.provideEngageDeepSleep(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 11:
                        return ProcessModule_ProvideRestartServicesSafelyFactory.provideRestartServicesSafely(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 12:
                        return ServiceModule_ProvideAudioPlayerServiceFactory.provideAudioPlayerService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (HlsKeyProviderService) this.singletonCImpl.provideHlsKeyProviderServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (ProductAcquisitionService) this.singletonCImpl.provideProductAcquisitionServiceProvider.get(), (AudioManager) this.singletonCImpl.provideAudioManagerProvider.get(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), (LockedModeService) this.singletonCImpl.provideLockedModeProvider.get());
                    case 13:
                        return ServiceModule_ProvideHlsKeyProviderServiceFactory.provideHlsKeyProviderService((TigerBoxWebService) this.singletonCImpl.provideTigerBoxServiceProvider.get(), (HlsKeysRepository) this.singletonCImpl.provideHlsKeysRepositoryProvider.get());
                    case 14:
                        return RetrofitModule_ProvideTigerBoxServiceFactory.provideTigerBoxService(this.singletonCImpl.authInterceptorOkHttpClientOkHttpClient(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 15:
                        return RetrofitModule_ProvideOpenLoginScreenFactory.provideOpenLoginScreen(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 16:
                        return StorageModule_ProvideAccessTokenRepositoryFactory.provideAccessTokenRepository((DatabaseMigrationService) this.singletonCImpl.provideDatabaseMigrationServiceProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (TigerBoxWebService) this.singletonCImpl.provideTigerBoxServiceProvider.get(), (TigerBoxDatabase) this.singletonCImpl.provideDatabaseProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 17:
                        return ProcessModule_ProvideDatabaseMigrationServiceFactory.provideDatabaseMigrationService(this.singletonCImpl.dataMigrationService());
                    case 18:
                        return StorageModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideApplicationFactory.provideApplication(this.singletonCImpl.applicationContextModule), (StorageService) this.singletonCImpl.provideStorageProvider.get());
                    case 19:
                        return ServiceModule_ProvideTimeServiceFactory.provideTimeService();
                    case 20:
                        return StorageModule_ProvideTigerBoxAccountRepositoryFactory.provideTigerBoxAccountRepository((DatabaseMigrationService) this.singletonCImpl.provideDatabaseMigrationServiceProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (TigerBoxWebService) this.singletonCImpl.provideTigerBoxServiceProvider.get(), (TigerBoxDatabase) this.singletonCImpl.provideDatabaseProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (ReauthenticationLoginHandler) this.singletonCImpl.provideOpenLoginScreenProvider.get());
                    case 21:
                        return StorageModule_ProvideHlsKeysRepositoryFactory.provideHlsKeysRepository((TigerBoxDatabase) this.singletonCImpl.provideDatabaseProvider.get(), (SharedPreferences) this.singletonCImpl.provideEncryptedSharedPreferencesProvider.get());
                    case 22:
                        return ServiceModule_ProvideAvailabilityServiceFactory.provideAvailabilityService((DownloadsManagerService) this.singletonCImpl.provideDownloadsManagerServiceProvider.get(), this.singletonCImpl.getTigerBoxAccountUseCase(), (SharedPreferences) this.singletonCImpl.provideEncryptedSharedPreferencesProvider.get(), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (HlsKeyProviderService) this.singletonCImpl.provideHlsKeyProviderServiceProvider.get(), (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (WakeService) this.singletonCImpl.provideWakeServiceProvider.get());
                    case 23:
                        return ServiceModule_ProvideDownloadsManagerServiceFactory.provideDownloadsManagerService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (DownloadsWebService) this.singletonCImpl.provideDownloadsWebServiceProvider.get());
                    case 24:
                        return ServiceModule_ProvideWifiServiceFactory.provideWifiService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 25:
                        return RetrofitModule_ProvideDownloadsWebServiceFactory.provideDownloadsWebService(this.singletonCImpl.downloadsOkHttpClientOkHttpClient(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 26:
                        return ServiceModule_ProvideWakeServiceFactory.provideWakeService((PowerManager) this.singletonCImpl.providePowerManagerProvider.get());
                    case 27:
                        return AndroidModule_ProvidePowerManagerFactory.providePowerManager(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 28:
                        return ServiceModule_ProvideProductAcquisitionServiceFactory.provideProductAcquisitionService((DownloadsManagerService) this.singletonCImpl.provideDownloadsManagerServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), this.singletonCImpl.getProductAssetsUseCase(), this.singletonCImpl.getProductDetailsUseCase(), this.singletonCImpl.requestAcquisitionUseCase(), this.singletonCImpl.checkAcquisitionsUseCase(), this.singletonCImpl.getTigerBoxAccountUseCase());
                    case 29:
                        return ServiceModule_ProvideLockedModeFactory.provideLockedMode((TimeLimitTimerService) this.singletonCImpl.provideTimeLimitTimerServiceProvider.get(), (WindowedLimitTimeService) this.singletonCImpl.provideWindowedLimitTimerServiceProvider.get());
                    case 30:
                        return ServiceModule_ProvideTimeLimitTimerServiceFactory.provideTimeLimitTimerService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (AlarmManager) this.singletonCImpl.provideAlarmManagerProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 31:
                        return AndroidModule_ProvideAlarmManagerFactory.provideAlarmManager(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 32:
                        return ServiceModule_ProvideWindowedLimitTimerServiceFactory.provideWindowedLimitTimerService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (AlarmManager) this.singletonCImpl.provideAlarmManagerProvider.get());
                    case 33:
                        return ServiceModule_ProvideMetaDataServiceFactory.provideMetaDataService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (BatteryService) this.singletonCImpl.provideBatteryServiceProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (NightLightTimerService) this.singletonCImpl.provideNightLightTimerServiceProvider.get(), (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (PowerManagementService) this.singletonCImpl.providePowerManagementServiceProvider.get(), (ShutDownTimerService) this.singletonCImpl.provideSleepTimerServiceProvider.get(), (TimersControllerService) this.singletonCImpl.provideTimersControllerProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get(), ProcessModule_ProvideAndroidSystemPropertiesFactory.provideAndroidSystemProperties(), this.singletonCImpl.getTigerBoxAccountUseCase());
                    case 34:
                        return ServiceModule_ProvideNightLightTimerServiceFactory.provideNightLightTimerService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (AlarmManager) this.singletonCImpl.provideAlarmManagerProvider.get());
                    case 35:
                        return ServiceModule_ProvideSleepTimerServiceFactory.provideSleepTimerService((PowerManagementService) this.singletonCImpl.providePowerManagementServiceProvider.get(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get());
                    case 36:
                        return ServiceModule_ProvideTimersControllerFactory.provideTimersController((TimeLimitTimerService) this.singletonCImpl.provideTimeLimitTimerServiceProvider.get(), (WindowedLimitTimeService) this.singletonCImpl.provideWindowedLimitTimerServiceProvider.get(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (DisplayService) this.singletonCImpl.provideDisplayServiceProvider.get());
                    case 37:
                        return ServiceModule_ProvideSafeguardServiceFactory.provideSafeguardService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 38:
                        return ServiceModule_ProvideWriteToFileExceptionHandlerFactory.provideWriteToFileExceptionHandler(this.singletonCImpl.postCrashLogsUseCase(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get());
                    case 39:
                        return ServiceModule_ProvideUpdateCheckTimerFactory.provideUpdateCheckTimer(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get(), (AlarmManager) this.singletonCImpl.provideAlarmManagerProvider.get(), (FirmwareUpdateService) this.singletonCImpl.provideFirmwareUpdateServiceProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 40:
                        return ServiceModule_ProvideFirmwareUpdateServiceFactory.provideFirmwareUpdateService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (BatteryService) this.singletonCImpl.provideBatteryServiceProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (LightControlService) this.singletonCImpl.provideLightControlServiceProvider.get(), this.singletonCImpl.checkForUpdateUseCase(), this.singletonCImpl.validateUpdateSignature(), this.singletonCImpl.downloadFirmware(), this.singletonCImpl.decryptFirmware(), (InstallFirmware) this.singletonCImpl.provideReadyToUpdateProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get(), (RequiresUpdate) this.singletonCImpl.provideRequiresUpdateProvider.get());
                    case 41:
                        return RetrofitModule_ProvideOtaWebServiceFactory.provideOtaWebService(this.singletonCImpl.otaWebServiceOkHttpClientOkHttpClient(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 42:
                        return RetrofitModule_ProvideDownloadProgressNotifierFactory.provideDownloadProgressNotifier();
                    case 43:
                        return RetrofitModule_ProvideSignatureValidatorFactory.provideSignatureValidator();
                    case 44:
                        return ServiceModule_ProvideAssetServiceFactory.provideAssetService(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 45:
                        return ServiceModule_ProvideBase64ConverterFactory.provideBase64Converter();
                    case 46:
                        return ProcessModule_ProvideLargeDownloadHandlerFactory.provideLargeDownloadHandler();
                    case 47:
                        return ServiceModule_ProvideReadyToUpdateFactory.provideReadyToUpdate(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule));
                    case 48:
                        return ServiceModule_ProvideRequiresUpdateFactory.provideRequiresUpdate((StorageService) this.singletonCImpl.provideStorageProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 49:
                        return ServiceModule_ProvideNfcServiceFactory.provideNfcService((LockedModeService) this.singletonCImpl.provideLockedModeProvider.get());
                    case 50:
                        return ServiceModule_ProvideButtonServiceFactory.provideButtonService((SafeguardService) this.singletonCImpl.provideSafeguardServiceProvider.get());
                    case 51:
                        return ServiceModule_ProvideHeadsetServiceFactory.provideHeadsetService();
                    case 52:
                        return WebServerModule_ProvideWebServerFactory.provideWebServer(ApplicationContextModule_ProvideContextFactory.provideContext(this.singletonCImpl.applicationContextModule), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (ProductAcquisitionService) this.singletonCImpl.provideProductAcquisitionServiceProvider.get(), (WakeService) this.singletonCImpl.provideWakeServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get(), (TimersControllerService) this.singletonCImpl.provideTimersControllerProvider.get(), (TigerBoxAccountRepository) this.singletonCImpl.provideTigerBoxAccountRepositoryProvider.get(), (TimeService) this.singletonCImpl.provideTimeServiceProvider.get());
                    case 53:
                        return ServiceModule_ProvideUpdateCheckFactory.provideUpdateCheck((StorageService) this.singletonCImpl.provideStorageProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), this.singletonCImpl.reportInformationUseCase(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 54:
                        return ServiceModule_ProvideHeaderBarFactory.provideHeaderBar((WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (BatteryService) this.singletonCImpl.provideBatteryServiceProvider.get(), (ShutDownTimerService) this.singletonCImpl.provideSleepTimerServiceProvider.get(), (TimersControllerService) this.singletonCImpl.provideTimersControllerProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (InfoSoundService) this.singletonCImpl.provideInfoSoundServiceProvider.get(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (FirmwareUpdateService) this.singletonCImpl.provideFirmwareUpdateServiceProvider.get());
                    case 55:
                        return ServiceModule_ProvidePlaybackPositionServiceFactory.providePlaybackPositionService((AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (PlaybackPositionsRepository) this.singletonCImpl.providePlaybackPositionsRepositoryProvider.get(), this.singletonCImpl.getPlayStatesUseCase(), this.singletonCImpl.postPlayStateUseCase(), this.singletonCImpl.getTigerBoxAccountUseCase());
                    case 56:
                        return StorageModule_ProvidePlaybackPositionsRepositoryFactory.providePlaybackPositionsRepository((TigerBoxDatabase) this.singletonCImpl.provideDatabaseProvider.get());
                    case 57:
                        return ServiceModule_ProvideLastUsedProductServiceFactory.provideLastUsedProductService((AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (SharedPreferences) this.singletonCImpl.provideEncryptedSharedPreferencesProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), this.singletonCImpl.reportLastCardProductUseCase(), this.singletonCImpl.getTigerBoxAccountUseCase());
                    case 58:
                        return ServiceModule_ProvidePlaybackTrackingServiceFactory.providePlaybackTrackingService((AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (PlaybackTrackingRepository) this.singletonCImpl.providePlaybackTrackingRepositoryProvider.get(), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), this.singletonCImpl.postTrackingEventUseCase(), this.singletonCImpl.getTigerBoxAccountUseCase());
                    case 59:
                        return StorageModule_ProvidePlaybackTrackingRepositoryFactory.providePlaybackTrackingRepository((TigerBoxDatabase) this.singletonCImpl.provideDatabaseProvider.get());
                    case 60:
                        return ServiceModule_ProvideTigerCardsManagerServiceFactory.provideTigerCardsManagerService((NfcService) this.singletonCImpl.provideNfcServiceProvider.get(), (SharedPreferences) this.singletonCImpl.provideEncryptedSharedPreferencesProvider.get(), (WifiService) this.singletonCImpl.provideWifiServiceProvider.get(), this.singletonCImpl.getTigerBoxAccountUseCase(), (AudioPlayerService) this.singletonCImpl.provideAudioPlayerServiceProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get(), (ProductAcquisitionService) this.singletonCImpl.provideProductAcquisitionServiceProvider.get(), this.singletonCImpl.getValidTigerCardUseCase(), this.singletonCImpl.tigerTicketGetProductUseCase(), this.singletonCImpl.wildCardReassignUseCase());
                    case 61:
                        return ProcessModule_ProvideGenerateCsrFactory.provideGenerateCsr(this.singletonCImpl.requestPemCertificateUseCase(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (WebServer) this.singletonCImpl.provideWebServerProvider.get());
                    case 62:
                        return RetrofitModule_ProvideScalarTigerBoxServiceFactory.provideScalarTigerBoxService(this.singletonCImpl.authInterceptorOkHttpClientOkHttpClient(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    case 63:
                        return ProcessModule_ProvideGetProductListRequestFactory.provideGetProductListRequest((TigerBoxWebService) this.singletonCImpl.provideTigerBoxServiceProvider.get(), (AvailabilityService) this.singletonCImpl.provideAvailabilityServiceProvider.get());
                    case 64:
                        return ServiceModule_ProvideTigerBoxLogTreeFactory.provideTigerBoxLogTree(this.singletonCImpl.postCrashLogsUseCase(), (StorageService) this.singletonCImpl.provideStorageProvider.get(), (MetaDataService) this.singletonCImpl.provideMetaDataServiceProvider.get(), (ConfigurationProperties) this.singletonCImpl.provideConfigurationPropertiesProvider.get());
                    default:
                        throw new AssertionError(this.f573id);
                }
            }
        }
    }
}
