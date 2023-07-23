package media.tiger.tigerbox.p016ui.onboarding.step3.security;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.OtaWebService;
import media.tiger.tigerbox.services.interfaces.AssetService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step3.security.ValidateUpdateSignature_Factory */
public final class ValidateUpdateSignature_Factory implements Factory<ValidateUpdateSignature> {
    private final Provider<AssetService> assetServiceProvider;
    private final Provider<Base64Converter> base64ConverterProvider;
    private final Provider<LargeDownloadHandler> largeDownloadHandlerProvider;
    private final Provider<OtaWebService> otaWebServiceProvider;
    private final Provider<DigestValidator> validateDigestProvider;

    public ValidateUpdateSignature_Factory(Provider<OtaWebService> provider, Provider<DigestValidator> provider2, Provider<AssetService> provider3, Provider<Base64Converter> provider4, Provider<LargeDownloadHandler> provider5) {
        this.otaWebServiceProvider = provider;
        this.validateDigestProvider = provider2;
        this.assetServiceProvider = provider3;
        this.base64ConverterProvider = provider4;
        this.largeDownloadHandlerProvider = provider5;
    }

    public ValidateUpdateSignature get() {
        return newInstance(this.otaWebServiceProvider.get(), this.validateDigestProvider.get(), this.assetServiceProvider.get(), this.base64ConverterProvider.get(), this.largeDownloadHandlerProvider.get());
    }

    public static ValidateUpdateSignature_Factory create(Provider<OtaWebService> provider, Provider<DigestValidator> provider2, Provider<AssetService> provider3, Provider<Base64Converter> provider4, Provider<LargeDownloadHandler> provider5) {
        return new ValidateUpdateSignature_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static ValidateUpdateSignature newInstance(OtaWebService otaWebService, DigestValidator digestValidator, AssetService assetService, Base64Converter base64Converter, LargeDownloadHandler largeDownloadHandler) {
        return new ValidateUpdateSignature(otaWebService, digestValidator, assetService, base64Converter, largeDownloadHandler);
    }
}
