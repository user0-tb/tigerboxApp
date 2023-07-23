package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.network.ScalarTigerBoxWebService;

public final class RequestPemCertificateUseCase_Factory implements Factory<RequestPemCertificateUseCase> {
    private final Provider<ScalarTigerBoxWebService> scalarTigerBoxWebServiceProvider;

    public RequestPemCertificateUseCase_Factory(Provider<ScalarTigerBoxWebService> provider) {
        this.scalarTigerBoxWebServiceProvider = provider;
    }

    public RequestPemCertificateUseCase get() {
        return newInstance(this.scalarTigerBoxWebServiceProvider.get());
    }

    public static RequestPemCertificateUseCase_Factory create(Provider<ScalarTigerBoxWebService> provider) {
        return new RequestPemCertificateUseCase_Factory(provider);
    }

    public static RequestPemCertificateUseCase newInstance(ScalarTigerBoxWebService scalarTigerBoxWebService) {
        return new RequestPemCertificateUseCase(scalarTigerBoxWebService);
    }
}
