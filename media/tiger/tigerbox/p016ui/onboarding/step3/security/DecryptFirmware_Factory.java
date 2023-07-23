package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.AssetService;
import media.tiger.tigerbox.services.interfaces.StorageService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.DecryptFirmware_Factory */
public final class DecryptFirmware_Factory implements Factory<DecryptFirmware> {
    private final Provider<AssetService> assetServiceProvider;
    private final Provider<Base64Converter> base64ConverterProvider;
    private final Provider<StorageService> storageServiceProvider;

    public DecryptFirmware_Factory(Provider<AssetService> provider, Provider<StorageService> provider2, Provider<Base64Converter> provider3) {
        this.assetServiceProvider = provider;
        this.storageServiceProvider = provider2;
        this.base64ConverterProvider = provider3;
    }

    public DecryptFirmware get() {
        return newInstance(this.assetServiceProvider.get(), this.storageServiceProvider.get(), this.base64ConverterProvider.get());
    }

    public static DecryptFirmware_Factory create(Provider<AssetService> provider, Provider<StorageService> provider2, Provider<Base64Converter> provider3) {
        return new DecryptFirmware_Factory(provider, provider2, provider3);
    }

    public static DecryptFirmware newInstance(AssetService assetService, StorageService storageService, Base64Converter base64Converter) {
        return new DecryptFirmware(assetService, storageService, base64Converter);
    }
}
