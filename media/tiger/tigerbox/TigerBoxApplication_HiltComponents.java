package media.tiger.tigerbox;

import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.C2547xb4b32df6;
import dagger.hilt.android.internal.managers.C2548x7709314e;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import javax.inject.Singleton;
import media.tiger.tigerbox.developer.AdbReceiver_GeneratedInjector;
import media.tiger.tigerbox.infrastructure.p015di.AndroidModule;
import media.tiger.tigerbox.infrastructure.p015di.ConfigurationPropertiesModule;
import media.tiger.tigerbox.infrastructure.p015di.CoroutinesModule;
import media.tiger.tigerbox.infrastructure.p015di.FragmentFactoryModule;
import media.tiger.tigerbox.infrastructure.p015di.HttpClientModule;
import media.tiger.tigerbox.infrastructure.p015di.ProcessModule;
import media.tiger.tigerbox.infrastructure.p015di.RetrofitModule;
import media.tiger.tigerbox.infrastructure.p015di.ServiceModule;
import media.tiger.tigerbox.infrastructure.p015di.StorageModule;
import media.tiger.tigerbox.infrastructure.p015di.WebServerModule;
import media.tiger.tigerbox.p016ui.LaunchViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.LauncherActivity_GeneratedInjector;
import media.tiger.tigerbox.p016ui.TigerBoxActivityViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.TigerBoxActivity_GeneratedInjector;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.common.reset.ResetDialogFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.common.reset.ResetDialogViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.common.reset.ResetInProgressFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.common.reset.ResetInProgressViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.MainContentActivity_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketPurchaseFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketPurchaseViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketValidFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductContentFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductContentViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductListMainContentFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.maincontentheader.MainContentHeaderBarViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.maincontentheader.MainContentHeaderFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.mediaplayer.ChapterListViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerChapterListFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.mediaplayer.MediaPlayerViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.multiproductcard.MultiProductCardFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.offlinemode.OfflineModeFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.main.offlinemode.OfflineModeViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilePictureViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.profiles.ProfilesViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.main.seemoreproducts.SeeMoreProductsFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivityViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.onboarding.OnboardingActivity_GeneratedInjector;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen1Fragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen1ViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen2Fragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.onboarding.step1.OnboardingStep1Screen3Fragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.onboarding.step2.OnboardingWifiListFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.onboarding.step2.OnboardingWifiViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.onboarding.step3.OnboardingUpdateFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.onboarding.step3.OnboardingUpdateViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendCommunicationFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendCommunicationViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendResponseFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.onboarding.step4.OnboardingBackendResponseViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.FullScreenSeekBarFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.FullScreenSeekBarViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.SettingsActivity_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.SettingsFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.SettingsViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.SettingsWifiFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.SettingsWifiViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateDisableStepFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateEnableStepFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.parentalGate.ParentalGateViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsFinishedFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsFinishedViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsInProgressFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsInProgressViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsNoneFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsNoneViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.systeminfo.SystemInfoFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.systeminfo.SystemInfoViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupLimitSetupViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupWindowSetupFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.timersSetup.TimersSetupWindowSetupViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberDialogFragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep1Fragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep1ViewModel_HiltModules;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep2Fragment_GeneratedInjector;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.WildCardReAssigningStep2ViewModel_HiltModules;
import media.tiger.tigerbox.services.implementations.receiver.ButtonBroadcastReceiver_GeneratedInjector;
import media.tiger.tigerbox.services.implementations.receiver.DateChangeBroadcastReceiver_GeneratedInjector;
import media.tiger.tigerbox.services.implementations.receiver.DisplayBroadcastReceiver_GeneratedInjector;
import media.tiger.tigerbox.services.implementations.receiver.HeadsetBroadcastReceiver_GeneratedInjector;
import media.tiger.tigerbox.services.implementations.receiver.NfcBroadcastReceiver_GeneratedInjector;
import media.tiger.tigerbox.services.implementations.receiver.SafeguardBroadcastReceiver_GeneratedInjector;
import media.tiger.tigerbox.services.implementations.receiver.WindowedLimitBroadcastReceiver_GeneratedInjector;

public final class TigerBoxApplication_HiltComponents {

    @Subcomponent(modules = {HiltWrapper_ActivityModule.class, HiltWrapper_DefaultViewModelFactories_ActivityModule.class, FragmentCBuilderModule.class, ViewCBuilderModule.class})
    public static abstract class ActivityC implements ActivityComponent, DefaultViewModelFactories.ActivityEntryPoint, HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint, FragmentComponentManager.FragmentComponentBuilderEntryPoint, ViewComponentManager.ViewComponentBuilderEntryPoint, GeneratedComponent, LauncherActivity_GeneratedInjector, TigerBoxActivity_GeneratedInjector, MainContentActivity_GeneratedInjector, OnboardingActivity_GeneratedInjector, SettingsActivity_GeneratedInjector {

        @Subcomponent.Builder
        interface Builder extends ActivityComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityC.class})
    interface ActivityCBuilderModule {
        @Binds
        ActivityComponentBuilder bind(ActivityC.Builder builder);
    }

    @Subcomponent(modules = {BaseViewModel_HiltModules.KeyModule.class, ChapterListViewModel_HiltModules.KeyModule.class, FullScreenSeekBarViewModel_HiltModules.KeyModule.class, FullScreenViewModel_HiltModules.KeyModule.class, HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class, LaunchViewModel_HiltModules.KeyModule.class, MainContentHeaderBarViewModel_HiltModules.KeyModule.class, MediaPlayerViewModel_HiltModules.KeyModule.class, OfflineModeViewModel_HiltModules.KeyModule.class, OnboardingActivityViewModel_HiltModules.KeyModule.class, OnboardingBackendCommunicationViewModel_HiltModules.KeyModule.class, OnboardingBackendResponseViewModel_HiltModules.KeyModule.class, OnboardingStep1Screen1ViewModel_HiltModules.KeyModule.class, OnboardingUpdateViewModel_HiltModules.KeyModule.class, OnboardingWifiViewModel_HiltModules.KeyModule.class, ParentalGateEnableDisableStepViewModel_HiltModules.KeyModule.class, ParentalGateViewModel_HiltModules.KeyModule.class, ProductContentViewModel_HiltModules.KeyModule.class, ProfilePictureViewModel_HiltModules.KeyModule.class, ProfilesViewModel_HiltModules.KeyModule.class, ResetDialogViewModel_HiltModules.KeyModule.class, ResetInProgressViewModel_HiltModules.KeyModule.class, SendLogsFinishedViewModel_HiltModules.KeyModule.class, SendLogsInProgressViewModel_HiltModules.KeyModule.class, SendLogsNoneViewModel_HiltModules.KeyModule.class, SettingsViewModel_HiltModules.KeyModule.class, SettingsWifiViewModel_HiltModules.KeyModule.class, SystemInfoViewModel_HiltModules.KeyModule.class, TicketRedeemTicketNumberViewModel_HiltModules.KeyModule.class, TigerBoxActivityViewModel_HiltModules.KeyModule.class, ActivityCBuilderModule.class, ViewModelCBuilderModule.class, TigerTicketInputPinViewModel_HiltModules.KeyModule.class, TigerTicketPurchaseViewModel_HiltModules.KeyModule.class, TimersSetupLimitSetupViewModel_HiltModules.KeyModule.class, TimersSetupViewModel_HiltModules.KeyModule.class, TimersSetupWindowSetupViewModel_HiltModules.KeyModule.class, WifiEnterPasswordViewModel_HiltModules.KeyModule.class, WifiViewModel_HiltModules.KeyModule.class, WildCardReAssigningStep1ViewModel_HiltModules.KeyModule.class, WildCardReAssigningStep2ViewModel_HiltModules.KeyModule.class})
    public static abstract class ActivityRetainedC implements ActivityRetainedComponent, ActivityComponentManager.ActivityComponentBuilderEntryPoint, C2548x7709314e, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ActivityRetainedComponentBuilder {
        }
    }

    @Module(subcomponents = {ActivityRetainedC.class})
    interface ActivityRetainedCBuilderModule {
        @Binds
        ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
    }

    @Subcomponent(modules = {ViewWithFragmentCBuilderModule.class})
    public static abstract class FragmentC implements FragmentComponent, DefaultViewModelFactories.FragmentEntryPoint, ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint, GeneratedComponent, ResetDialogFragment_GeneratedInjector, ResetInProgressFragment_GeneratedInjector, WifiEnterPasswordFragment_GeneratedInjector, TigerTicketInputPinFragment_GeneratedInjector, TigerTicketPurchaseFragment_GeneratedInjector, TigerTicketValidFragment_GeneratedInjector, ProductContentFragment_GeneratedInjector, ProductListMainContentFragment_GeneratedInjector, MainContentHeaderFragment_GeneratedInjector, MediaPlayerChapterListFragment_GeneratedInjector, MediaPlayerFragment_GeneratedInjector, MultiProductCardFragment_GeneratedInjector, OfflineModeFragment_GeneratedInjector, SeeMoreProductsFragment_GeneratedInjector, OnboardingStep1Screen1Fragment_GeneratedInjector, OnboardingStep1Screen2Fragment_GeneratedInjector, OnboardingStep1Screen3Fragment_GeneratedInjector, OnboardingWifiListFragment_GeneratedInjector, OnboardingUpdateFragment_GeneratedInjector, OnboardingBackendCommunicationFragment_GeneratedInjector, OnboardingBackendResponseFragment_GeneratedInjector, FullScreenSeekBarFragment_GeneratedInjector, SettingsFragment_GeneratedInjector, SettingsWifiFragment_GeneratedInjector, ParentalGateDisableStepFragment_GeneratedInjector, ParentalGateEnableStepFragment_GeneratedInjector, ParentalGateFragment_GeneratedInjector, SendLogsFinishedFragment_GeneratedInjector, SendLogsInProgressFragment_GeneratedInjector, SendLogsNoneFragment_GeneratedInjector, SystemInfoFragment_GeneratedInjector, TimersSetupFragment_GeneratedInjector, TimersSetupLimitSetupFragment_GeneratedInjector, TimersSetupWindowSetupFragment_GeneratedInjector, TicketRedeemTicketNumberDialogFragment_GeneratedInjector, WildCardReAssigningStep1Fragment_GeneratedInjector, WildCardReAssigningStep2Fragment_GeneratedInjector {

        @Subcomponent.Builder
        interface Builder extends FragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {FragmentC.class})
    interface FragmentCBuilderModule {
        @Binds
        FragmentComponentBuilder bind(FragmentC.Builder builder);
    }

    @Subcomponent
    public static abstract class ServiceC implements ServiceComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ServiceComponentBuilder {
        }
    }

    @Module(subcomponents = {ServiceC.class})
    interface ServiceCBuilderModule {
        @Binds
        ServiceComponentBuilder bind(ServiceC.Builder builder);
    }

    @Component(modules = {AndroidModule.class, ApplicationContextModule.class, ConfigurationPropertiesModule.class, CoroutinesModule.class, FragmentFactoryModule.class, HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class, HttpClientModule.class, ProcessModule.class, RetrofitModule.class, ServiceModule.class, StorageModule.class, ActivityRetainedCBuilderModule.class, ServiceCBuilderModule.class, WebServerModule.class})
    @Singleton
    public static abstract class SingletonC implements FragmentGetContextFix.FragmentGetContextFixEntryPoint, C2547xb4b32df6, ServiceComponentManager.ServiceComponentBuilderEntryPoint, SingletonComponent, GeneratedComponent, TigerBoxApplication_GeneratedInjector, AdbReceiver_GeneratedInjector, ButtonBroadcastReceiver_GeneratedInjector, DateChangeBroadcastReceiver_GeneratedInjector, DisplayBroadcastReceiver_GeneratedInjector, HeadsetBroadcastReceiver_GeneratedInjector, NfcBroadcastReceiver_GeneratedInjector, SafeguardBroadcastReceiver_GeneratedInjector, WindowedLimitBroadcastReceiver_GeneratedInjector {
    }

    @Subcomponent
    public static abstract class ViewC implements ViewComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewC.class})
    interface ViewCBuilderModule {
        @Binds
        ViewComponentBuilder bind(ViewC.Builder builder);
    }

    @Subcomponent(modules = {BaseViewModel_HiltModules.BindsModule.class, ChapterListViewModel_HiltModules.BindsModule.class, FullScreenSeekBarViewModel_HiltModules.BindsModule.class, FullScreenViewModel_HiltModules.BindsModule.class, HiltWrapper_HiltViewModelFactory_ViewModelModule.class, LaunchViewModel_HiltModules.BindsModule.class, MainContentHeaderBarViewModel_HiltModules.BindsModule.class, MediaPlayerViewModel_HiltModules.BindsModule.class, OfflineModeViewModel_HiltModules.BindsModule.class, OnboardingActivityViewModel_HiltModules.BindsModule.class, OnboardingBackendCommunicationViewModel_HiltModules.BindsModule.class, OnboardingBackendResponseViewModel_HiltModules.BindsModule.class, OnboardingStep1Screen1ViewModel_HiltModules.BindsModule.class, OnboardingUpdateViewModel_HiltModules.BindsModule.class, OnboardingWifiViewModel_HiltModules.BindsModule.class, ParentalGateEnableDisableStepViewModel_HiltModules.BindsModule.class, ParentalGateViewModel_HiltModules.BindsModule.class, ProductContentViewModel_HiltModules.BindsModule.class, ProfilePictureViewModel_HiltModules.BindsModule.class, ProfilesViewModel_HiltModules.BindsModule.class, ResetDialogViewModel_HiltModules.BindsModule.class, ResetInProgressViewModel_HiltModules.BindsModule.class, SendLogsFinishedViewModel_HiltModules.BindsModule.class, SendLogsInProgressViewModel_HiltModules.BindsModule.class, SendLogsNoneViewModel_HiltModules.BindsModule.class, SettingsViewModel_HiltModules.BindsModule.class, SettingsWifiViewModel_HiltModules.BindsModule.class, SystemInfoViewModel_HiltModules.BindsModule.class, TicketRedeemTicketNumberViewModel_HiltModules.BindsModule.class, TigerBoxActivityViewModel_HiltModules.BindsModule.class, TigerTicketInputPinViewModel_HiltModules.BindsModule.class, TigerTicketPurchaseViewModel_HiltModules.BindsModule.class, TimersSetupLimitSetupViewModel_HiltModules.BindsModule.class, TimersSetupViewModel_HiltModules.BindsModule.class, TimersSetupWindowSetupViewModel_HiltModules.BindsModule.class, WifiEnterPasswordViewModel_HiltModules.BindsModule.class, WifiViewModel_HiltModules.BindsModule.class, WildCardReAssigningStep1ViewModel_HiltModules.BindsModule.class, WildCardReAssigningStep2ViewModel_HiltModules.BindsModule.class})
    public static abstract class ViewModelC implements ViewModelComponent, HiltViewModelFactory.ViewModelFactoriesEntryPoint, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewModelComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewModelC.class})
    interface ViewModelCBuilderModule {
        @Binds
        ViewModelComponentBuilder bind(ViewModelC.Builder builder);
    }

    @Subcomponent
    public static abstract class ViewWithFragmentC implements ViewWithFragmentComponent, GeneratedComponent {

        @Subcomponent.Builder
        interface Builder extends ViewWithFragmentComponentBuilder {
        }
    }

    @Module(subcomponents = {ViewWithFragmentC.class})
    interface ViewWithFragmentCBuilderModule {
        @Binds
        ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
    }

    private TigerBoxApplication_HiltComponents() {
    }
}
