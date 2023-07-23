package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.p016ui.onboarding.step2.RequiresUpdate;
import media.tiger.tigerbox.p016ui.onboarding.step3.InstallFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DecryptFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.DownloadFirmware;
import media.tiger.tigerbox.p016ui.onboarding.step3.security.ValidateUpdateSignature;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.BatteryService;
import media.tiger.tigerbox.services.interfaces.FirmwareUpdateService;
import media.tiger.tigerbox.services.interfaces.LightControlService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioPlayerService;
import media.tiger.tigerbox.usecase.CheckForUpdateUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideFirmwareUpdateServiceFactory */
public final class ServiceModule_ProvideFirmwareUpdateServiceFactory implements Factory<FirmwareUpdateService> {
    private final Provider<AudioPlayerService> audioServiceProvider;
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<BatteryService> batteryServiceProvider;
    private final Provider<CheckForUpdateUseCase> checkForUpdateUseCaseProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<Context> contextProvider;
    private final Provider<DecryptFirmware> decryptFirmwareProvider;
    private final Provider<DownloadFirmware> downloadFirmwareProvider;
    private final Provider<InstallFirmware> installFirmwareProvider;
    private final Provider<LightControlService> lightControlServiceProvider;
    private final Provider<RequiresUpdate> requiresUpdateProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<ValidateUpdateSignature> validateUpdateSignatureProvider;

    public ServiceModule_ProvideFirmwareUpdateServiceFactory(Provider<Context> provider, Provider<StorageService> provider2, Provider<BatteryService> provider3, Provider<AvailabilityService> provider4, Provider<AudioPlayerService> provider5, Provider<LightControlService> provider6, Provider<CheckForUpdateUseCase> provider7, Provider<ValidateUpdateSignature> provider8, Provider<DownloadFirmware> provider9, Provider<DecryptFirmware> provider10, Provider<InstallFirmware> provider11, Provider<ConfigurationProperties> provider12, Provider<RequiresUpdate> provider13) {
        this.contextProvider = provider;
        this.storageServiceProvider = provider2;
        this.batteryServiceProvider = provider3;
        this.availabilityServiceProvider = provider4;
        this.audioServiceProvider = provider5;
        this.lightControlServiceProvider = provider6;
        this.checkForUpdateUseCaseProvider = provider7;
        this.validateUpdateSignatureProvider = provider8;
        this.downloadFirmwareProvider = provider9;
        this.decryptFirmwareProvider = provider10;
        this.installFirmwareProvider = provider11;
        this.configurationPropertiesProvider = provider12;
        this.requiresUpdateProvider = provider13;
    }

    public FirmwareUpdateService get() {
        return provideFirmwareUpdateService(this.contextProvider.get(), this.storageServiceProvider.get(), this.batteryServiceProvider.get(), this.availabilityServiceProvider.get(), this.audioServiceProvider.get(), this.lightControlServiceProvider.get(), this.checkForUpdateUseCaseProvider.get(), this.validateUpdateSignatureProvider.get(), this.downloadFirmwareProvider.get(), this.decryptFirmwareProvider.get(), this.installFirmwareProvider.get(), this.configurationPropertiesProvider.get(), this.requiresUpdateProvider.get());
    }

    public static ServiceModule_ProvideFirmwareUpdateServiceFactory create(Provider<Context> provider, Provider<StorageService> provider2, Provider<BatteryService> provider3, Provider<AvailabilityService> provider4, Provider<AudioPlayerService> provider5, Provider<LightControlService> provider6, Provider<CheckForUpdateUseCase> provider7, Provider<ValidateUpdateSignature> provider8, Provider<DownloadFirmware> provider9, Provider<DecryptFirmware> provider10, Provider<InstallFirmware> provider11, Provider<ConfigurationProperties> provider12, Provider<RequiresUpdate> provider13) {
        return new ServiceModule_ProvideFirmwareUpdateServiceFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static FirmwareUpdateService provideFirmwareUpdateService(Context context, StorageService storageService, BatteryService batteryService, AvailabilityService availabilityService, AudioPlayerService audioPlayerService, LightControlService lightControlService, CheckForUpdateUseCase checkForUpdateUseCase, ValidateUpdateSignature validateUpdateSignature, DownloadFirmware downloadFirmware, DecryptFirmware decryptFirmware, InstallFirmware installFirmware, ConfigurationProperties configurationProperties, RequiresUpdate requiresUpdate) {
        return (FirmwareUpdateService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideFirmwareUpdateService(context, storageService, batteryService, availabilityService, audioPlayerService, lightControlService, checkForUpdateUseCase, validateUpdateSignature, downloadFirmware, decryptFirmware, installFirmware, configurationProperties, requiresUpdate));
    }
}
