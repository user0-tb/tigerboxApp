package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.OtaWebService;
import media.tiger.tigerbox.infrastructure.functional.DownloadProgressUpdate;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.AssetService;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DownloadFirmware_Factory */
public final class DownloadFirmware_Factory implements Factory<DownloadFirmware> {
    private final Provider<AssetService> assetServiceProvider;
    private final Provider<Base64Converter> base64ConverterProvider;
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<DownloadProgressUpdate> downloadProgressNotifierProvider;
    private final Provider<LargeDownloadHandler> largeDownloadHandlerProvider;
    private final Provider<OtaWebService> otaWebServiceProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<DigestValidator> validateDigestProvider;

    public DownloadFirmware_Factory(Provider<OtaWebService> provider, Provider<DigestValidator> provider2, Provider<AssetService> provider3, Provider<StorageService> provider4, Provider<DownloadProgressUpdate> provider5, Provider<Base64Converter> provider6, Provider<LargeDownloadHandler> provider7, Provider<ConfigurationProperties> provider8) {
        this.otaWebServiceProvider = provider;
        this.validateDigestProvider = provider2;
        this.assetServiceProvider = provider3;
        this.storageServiceProvider = provider4;
        this.downloadProgressNotifierProvider = provider5;
        this.base64ConverterProvider = provider6;
        this.largeDownloadHandlerProvider = provider7;
        this.configurationPropertiesProvider = provider8;
    }

    public DownloadFirmware get() {
        return newInstance(this.otaWebServiceProvider.get(), this.validateDigestProvider.get(), this.assetServiceProvider.get(), this.storageServiceProvider.get(), this.downloadProgressNotifierProvider.get(), this.base64ConverterProvider.get(), this.largeDownloadHandlerProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static DownloadFirmware_Factory create(Provider<OtaWebService> provider, Provider<DigestValidator> provider2, Provider<AssetService> provider3, Provider<StorageService> provider4, Provider<DownloadProgressUpdate> provider5, Provider<Base64Converter> provider6, Provider<LargeDownloadHandler> provider7, Provider<ConfigurationProperties> provider8) {
        return new DownloadFirmware_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static DownloadFirmware newInstance(OtaWebService otaWebService, DigestValidator digestValidator, AssetService assetService, StorageService storageService, DownloadProgressUpdate downloadProgressUpdate, Base64Converter base64Converter, LargeDownloadHandler largeDownloadHandler, ConfigurationProperties configurationProperties) {
        return new DownloadFirmware(otaWebService, digestValidator, assetService, storageService, downloadProgressUpdate, base64Converter, largeDownloadHandler, configurationProperties);
    }
}
