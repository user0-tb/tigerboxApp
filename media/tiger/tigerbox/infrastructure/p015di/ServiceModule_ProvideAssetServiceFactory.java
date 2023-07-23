package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.AssetService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideAssetServiceFactory */
public final class ServiceModule_ProvideAssetServiceFactory implements Factory<AssetService> {
    private final Provider<Context> contextProvider;

    public ServiceModule_ProvideAssetServiceFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public AssetService get() {
        return provideAssetService(this.contextProvider.get());
    }

    public static ServiceModule_ProvideAssetServiceFactory create(Provider<Context> provider) {
        return new ServiceModule_ProvideAssetServiceFactory(provider);
    }

    public static AssetService provideAssetService(Context context) {
        return (AssetService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideAssetService(context));
    }
}
