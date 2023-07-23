package media.tiger.tigerbox.infrastructure.p015di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.SafeguardService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideSafeguardServiceFactory */
public final class ServiceModule_ProvideSafeguardServiceFactory implements Factory<SafeguardService> {
    private final Provider<Context> contextProvider;

    public ServiceModule_ProvideSafeguardServiceFactory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public SafeguardService get() {
        return provideSafeguardService(this.contextProvider.get());
    }

    public static ServiceModule_ProvideSafeguardServiceFactory create(Provider<Context> provider) {
        return new ServiceModule_ProvideSafeguardServiceFactory(provider);
    }

    public static SafeguardService provideSafeguardService(Context context) {
        return (SafeguardService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideSafeguardService(context));
    }
}
