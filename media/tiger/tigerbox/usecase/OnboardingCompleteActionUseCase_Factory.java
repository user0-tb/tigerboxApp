package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.services.interfaces.StorageService;

public final class OnboardingCompleteActionUseCase_Factory implements Factory<OnboardingCompleteActionUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<StorageService> preferenceStorageProvider;

    public OnboardingCompleteActionUseCase_Factory(Provider<StorageService> provider, Provider<CoroutineDispatcher> provider2) {
        this.preferenceStorageProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public OnboardingCompleteActionUseCase get() {
        return newInstance(this.preferenceStorageProvider.get(), this.dispatcherProvider.get());
    }

    public static OnboardingCompleteActionUseCase_Factory create(Provider<StorageService> provider, Provider<CoroutineDispatcher> provider2) {
        return new OnboardingCompleteActionUseCase_Factory(provider, provider2);
    }

    public static OnboardingCompleteActionUseCase newInstance(StorageService storageService, CoroutineDispatcher coroutineDispatcher) {
        return new OnboardingCompleteActionUseCase(storageService, coroutineDispatcher);
    }
}
