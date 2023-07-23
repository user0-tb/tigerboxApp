package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.implementations.ButtonService;
import media.tiger.tigerbox.services.interfaces.SafeguardService;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideButtonServiceFactory */
public final class ServiceModule_ProvideButtonServiceFactory implements Factory<ButtonService> {
    private final Provider<SafeguardService> safeguardServiceProvider;

    public ServiceModule_ProvideButtonServiceFactory(Provider<SafeguardService> provider) {
        this.safeguardServiceProvider = provider;
    }

    public ButtonService get() {
        return provideButtonService(this.safeguardServiceProvider.get());
    }

    public static ServiceModule_ProvideButtonServiceFactory create(Provider<SafeguardService> provider) {
        return new ServiceModule_ProvideButtonServiceFactory(provider);
    }

    public static ButtonService provideButtonService(SafeguardService safeguardService) {
        return (ButtonService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideButtonService(safeguardService));
    }
}
