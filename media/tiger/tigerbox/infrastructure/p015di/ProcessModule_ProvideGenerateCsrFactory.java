package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.main.maincontent.GenerateCsr;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.RequestPemCertificateUseCase;
import media.tiger.tigerbox.webserver.WebServer;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ProcessModule_ProvideGenerateCsrFactory */
public final class ProcessModule_ProvideGenerateCsrFactory implements Factory<GenerateCsr> {
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<RequestPemCertificateUseCase> requestPemCertificateUseCaseProvider;
    private final Provider<StorageService> storageServiceProvider;
    private final Provider<WebServer> webServerProvider;

    public ProcessModule_ProvideGenerateCsrFactory(Provider<RequestPemCertificateUseCase> provider, Provider<StorageService> provider2, Provider<MetaDataService> provider3, Provider<WebServer> provider4) {
        this.requestPemCertificateUseCaseProvider = provider;
        this.storageServiceProvider = provider2;
        this.metaDataServiceProvider = provider3;
        this.webServerProvider = provider4;
    }

    public GenerateCsr get() {
        return provideGenerateCsr(this.requestPemCertificateUseCaseProvider.get(), this.storageServiceProvider.get(), this.metaDataServiceProvider.get(), this.webServerProvider.get());
    }

    public static ProcessModule_ProvideGenerateCsrFactory create(Provider<RequestPemCertificateUseCase> provider, Provider<StorageService> provider2, Provider<MetaDataService> provider3, Provider<WebServer> provider4) {
        return new ProcessModule_ProvideGenerateCsrFactory(provider, provider2, provider3, provider4);
    }

    public static GenerateCsr provideGenerateCsr(RequestPemCertificateUseCase requestPemCertificateUseCase, StorageService storageService, MetaDataService metaDataService, WebServer webServer) {
        return (GenerateCsr) Preconditions.checkNotNullFromProvides(ProcessModule.INSTANCE.provideGenerateCsr(requestPemCertificateUseCase, storageService, metaDataService, webServer));
    }
}
