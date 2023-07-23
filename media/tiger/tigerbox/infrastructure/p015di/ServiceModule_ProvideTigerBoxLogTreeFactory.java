package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.TigerBoxLogTree;
import media.tiger.tigerbox.infrastructure.properties.ConfigurationProperties;
import media.tiger.tigerbox.services.interfaces.MetaDataService;
import media.tiger.tigerbox.services.interfaces.StorageService;
import media.tiger.tigerbox.usecase.PostCrashLogsUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideTigerBoxLogTreeFactory */
public final class ServiceModule_ProvideTigerBoxLogTreeFactory implements Factory<TigerBoxLogTree> {
    private final Provider<ConfigurationProperties> configurationPropertiesProvider;
    private final Provider<MetaDataService> metaDataServiceProvider;
    private final Provider<PostCrashLogsUseCase> postLogsUseCaseProvider;
    private final Provider<StorageService> storageServiceProvider;

    public ServiceModule_ProvideTigerBoxLogTreeFactory(Provider<PostCrashLogsUseCase> provider, Provider<StorageService> provider2, Provider<MetaDataService> provider3, Provider<ConfigurationProperties> provider4) {
        this.postLogsUseCaseProvider = provider;
        this.storageServiceProvider = provider2;
        this.metaDataServiceProvider = provider3;
        this.configurationPropertiesProvider = provider4;
    }

    public TigerBoxLogTree get() {
        return provideTigerBoxLogTree(this.postLogsUseCaseProvider.get(), this.storageServiceProvider.get(), this.metaDataServiceProvider.get(), this.configurationPropertiesProvider.get());
    }

    public static ServiceModule_ProvideTigerBoxLogTreeFactory create(Provider<PostCrashLogsUseCase> provider, Provider<StorageService> provider2, Provider<MetaDataService> provider3, Provider<ConfigurationProperties> provider4) {
        return new ServiceModule_ProvideTigerBoxLogTreeFactory(provider, provider2, provider3, provider4);
    }

    public static TigerBoxLogTree provideTigerBoxLogTree(PostCrashLogsUseCase postCrashLogsUseCase, StorageService storageService, MetaDataService metaDataService, ConfigurationProperties configurationProperties) {
        return (TigerBoxLogTree) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideTigerBoxLogTree(postCrashLogsUseCase, storageService, metaDataService, configurationProperties));
    }
}
