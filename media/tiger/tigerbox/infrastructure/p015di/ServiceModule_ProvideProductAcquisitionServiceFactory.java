package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.AvailabilityService;
import media.tiger.tigerbox.services.interfaces.ProductAcquisitionService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.services.interfaces.downloadsManager.DownloadsManagerService;
import media.tiger.tigerbox.usecase.CheckAcquisitionsUseCase;
import media.tiger.tigerbox.usecase.GetProductAssetsUseCase;
import media.tiger.tigerbox.usecase.GetProductDetailsUseCase;
import media.tiger.tigerbox.usecase.RequestAcquisitionUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideProductAcquisitionServiceFactory */
public final class ServiceModule_ProvideProductAcquisitionServiceFactory implements Factory<ProductAcquisitionService> {
    private final Provider<AvailabilityService> availabilityServiceProvider;
    private final Provider<CheckAcquisitionsUseCase> checkAcquisitionsUseCaseProvider;
    private final Provider<DownloadsManagerService> dlManagerServiceProvider;
    private final Provider<GetProductAssetsUseCase> getProductAssetsUseCaseProvider;
    private final Provider<GetProductDetailsUseCase> getProductDetailsUseCaseProvider;
    private final Provider<GetTigerBoxAccountUseCase> getTigerBoxAccountUseCaseProvider;
    private final Provider<RequestAcquisitionUseCase> requestAcquisitionUseCaseProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ServiceModule_ProvideProductAcquisitionServiceFactory(Provider<DownloadsManagerService> provider, Provider<StorageService> provider2, Provider<AvailabilityService> provider3, Provider<GetProductAssetsUseCase> provider4, Provider<GetProductDetailsUseCase> provider5, Provider<RequestAcquisitionUseCase> provider6, Provider<CheckAcquisitionsUseCase> provider7, Provider<GetTigerBoxAccountUseCase> provider8) {
        this.dlManagerServiceProvider = provider;
        this.storageServiceProvider = provider2;
        this.availabilityServiceProvider = provider3;
        this.getProductAssetsUseCaseProvider = provider4;
        this.getProductDetailsUseCaseProvider = provider5;
        this.requestAcquisitionUseCaseProvider = provider6;
        this.checkAcquisitionsUseCaseProvider = provider7;
        this.getTigerBoxAccountUseCaseProvider = provider8;
    }

    public ProductAcquisitionService get() {
        return provideProductAcquisitionService(this.dlManagerServiceProvider.get(), this.storageServiceProvider.get(), this.availabilityServiceProvider.get(), this.getProductAssetsUseCaseProvider.get(), this.getProductDetailsUseCaseProvider.get(), this.requestAcquisitionUseCaseProvider.get(), this.checkAcquisitionsUseCaseProvider.get(), this.getTigerBoxAccountUseCaseProvider.get());
    }

    public static ServiceModule_ProvideProductAcquisitionServiceFactory create(Provider<DownloadsManagerService> provider, Provider<StorageService> provider2, Provider<AvailabilityService> provider3, Provider<GetProductAssetsUseCase> provider4, Provider<GetProductDetailsUseCase> provider5, Provider<RequestAcquisitionUseCase> provider6, Provider<CheckAcquisitionsUseCase> provider7, Provider<GetTigerBoxAccountUseCase> provider8) {
        return new ServiceModule_ProvideProductAcquisitionServiceFactory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static ProductAcquisitionService provideProductAcquisitionService(DownloadsManagerService downloadsManagerService, StorageService storageService, AvailabilityService availabilityService, GetProductAssetsUseCase getProductAssetsUseCase, GetProductDetailsUseCase getProductDetailsUseCase, RequestAcquisitionUseCase requestAcquisitionUseCase, CheckAcquisitionsUseCase checkAcquisitionsUseCase, GetTigerBoxAccountUseCase getTigerBoxAccountUseCase) {
        return (ProductAcquisitionService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideProductAcquisitionService(downloadsManagerService, storageService, availabilityService, getProductAssetsUseCase, getProductDetailsUseCase, requestAcquisitionUseCase, checkAcquisitionsUseCase, getTigerBoxAccountUseCase));
    }
}
