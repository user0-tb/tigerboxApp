package media.tiger.tigerbox.p016ui;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.usecase.OnboardingCompletedUseCase;

/* renamed from: media.tiger.tigerbox.ui.LaunchViewModel_Factory */
public final class LaunchViewModel_Factory implements Factory<LaunchViewModel> {
    private final Provider<OnboardingCompletedUseCase> onboardingCompletedUseCaseProvider;

    public LaunchViewModel_Factory(Provider<OnboardingCompletedUseCase> provider) {
        this.onboardingCompletedUseCaseProvider = provider;
    }

    public LaunchViewModel get() {
        return newInstance(this.onboardingCompletedUseCaseProvider.get());
    }

    public static LaunchViewModel_Factory create(Provider<OnboardingCompletedUseCase> provider) {
        return new LaunchViewModel_Factory(provider);
    }

    public static LaunchViewModel newInstance(OnboardingCompletedUseCase onboardingCompletedUseCase) {
        return new LaunchViewModel(onboardingCompletedUseCase);
    }
}
