package media.tiger.tigerbox.infrastructure.p015di;

import android.content.SharedPreferences;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.AccountSubscriptionService;
import media.tiger.tigerbox.usecase.GetSubscriptionsUseCase;
import media.tiger.tigerbox.usecase.tigerboxuserrepo.GetTigerBoxAccountUseCase;

/* renamed from: media.tiger.tigerbox.infrastructure.di.ServiceModule_ProvideAccountSubscriptionServiceFactory */
public final class ServiceModule_ProvideAccountSubscriptionServiceFactory implements Factory<AccountSubscriptionService> {
    private final Provider<GetTigerBoxAccountUseCase> getTigerBoxAccountUseCaseProvider;
    private final Provider<SharedPreferences> sharedPreferencesProvider;
    private final Provider<GetSubscriptionsUseCase> subscriptionsUseCaseProvider;

    public ServiceModule_ProvideAccountSubscriptionServiceFactory(Provider<GetTigerBoxAccountUseCase> provider, Provider<SharedPreferences> provider2, Provider<GetSubscriptionsUseCase> provider3) {
        this.getTigerBoxAccountUseCaseProvider = provider;
        this.sharedPreferencesProvider = provider2;
        this.subscriptionsUseCaseProvider = provider3;
    }

    public AccountSubscriptionService get() {
        return provideAccountSubscriptionService(this.getTigerBoxAccountUseCaseProvider.get(), this.sharedPreferencesProvider.get(), this.subscriptionsUseCaseProvider.get());
    }

    public static ServiceModule_ProvideAccountSubscriptionServiceFactory create(Provider<GetTigerBoxAccountUseCase> provider, Provider<SharedPreferences> provider2, Provider<GetSubscriptionsUseCase> provider3) {
        return new ServiceModule_ProvideAccountSubscriptionServiceFactory(provider, provider2, provider3);
    }

    public static AccountSubscriptionService provideAccountSubscriptionService(GetTigerBoxAccountUseCase getTigerBoxAccountUseCase, SharedPreferences sharedPreferences, GetSubscriptionsUseCase getSubscriptionsUseCase) {
        return (AccountSubscriptionService) Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideAccountSubscriptionService(getTigerBoxAccountUseCase, sharedPreferences, getSubscriptionsUseCase));
    }
}
