package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.WriteToFileExceptionHandler;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideWriteToFileExceptionHandlerFactory */
public final class ServiceModule_ProvideWriteToFileExceptionHandlerFactory implements Factory<WriteToFileExceptionHandler> {
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<PostCrashLogsUseCase> postLogsUseCaseProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ServiceModule_ProvideWriteToFileExceptionHandlerFactory(Provider<PostCrashLogsUseCase> provider, Provider<StorageService> provider2, Provider<MetaDataService> provider3) {
        this.postLogsUseCaseProvider = provider;
        this.storageServiceProvider = provider2;
        this.metaDataServiceProvider = provider3;
    }

    public WriteToFileExceptionHandler get() {
        return provideWriteToFileExceptionHandler(this.postLogsUseCaseProvider.get(), this.storageServiceProvider.get(), this.metaDataServiceProvider.get());
    }

    public static ServiceModule_ProvideWriteToFileExceptionHandlerFactory create(Provider<PostCrashLogsUseCase> provider, Provider<StorageService> provider2, Provider<MetaDataService> provider3) {
        return new ServiceModule_ProvideWriteToFileExceptionHandlerFactory(provider, provider2, provider3);
    }

    public static WriteToFileExceptionHandler provideWriteToFileExceptionHandler(PostCrashLogsUseCase postCrashLogsUseCase, StorageService storageService, MetaDataService metaDataService) {
        return (WriteToFileExceptionHandler) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideWriteToFileExceptionHandler(postCrashLogsUseCase, storageService, metaDataService));
    }
}
