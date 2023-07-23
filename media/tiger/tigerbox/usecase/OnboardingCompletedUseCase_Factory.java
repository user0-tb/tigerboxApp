package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.services.interfaces.StorageService;

public final class OnboardingCompletedUseCase_Factory implements Factory<OnboardingCompletedUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<StorageService> preferenceStorageProvider;

    public OnboardingCompletedUseCase_Factory(Provider<StorageService> provider, Provider<CoroutineDispatcher> provider2) {
        this.preferenceStorageProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public OnboardingCompletedUseCase get() {
        return newInstance(this.preferenceStorageProvider.get(), this.dispatcherProvider.get());
    }

    public static OnboardingCompletedUseCase_Factory create(Provider<StorageService> provider, Provider<CoroutineDispatcher> provider2) {
        return new OnboardingCompletedUseCase_Factory(provider, provider2);
    }

    public static OnboardingCompletedUseCase newInstance(StorageService storageService, CoroutineDispatcher coroutineDispatcher) {
        return new OnboardingCompletedUseCase(storageService, coroutineDispatcher);
    }
}
