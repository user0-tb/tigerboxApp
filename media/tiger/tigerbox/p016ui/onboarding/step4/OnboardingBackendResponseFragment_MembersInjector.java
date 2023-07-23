package media.tiger.tigerbox.p016ui.onboarding.step4;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.services.interfaces.MetaDataService;

/* renamed from: media.tiger.tigerbox.ui.onboarding.step4.OnboardingBackendResponseFragment_MembersInjector */
public final class OnboardingBackendResponseFragment_MembersInjector implements MembersInjector<OnboardingBackendResponseFragment> {
    private final Provider<MetaDataService> metaDataServiceProvider;

    public OnboardingBackendResponseFragment_MembersInjector(Provider<MetaDataService> provider) {
        this.metaDataServiceProvider = provider;
    }

    public static MembersInjector<OnboardingBackendResponseFragment> create(Provider<MetaDataService> provider) {
        return new OnboardingBackendResponseFragment_MembersInjector(provider);
    }

    public void injectMembers(OnboardingBackendResponseFragment onboardingBackendResponseFragment) {
        injectMetaDataService(onboardingBackendResponseFragment, this.metaDataServiceProvider.get());
    }

    public static void injectMetaDataService(OnboardingBackendResponseFragment onboardingBackendResponseFragment, MetaDataService metaDataService) {
        onboardingBackendResponseFragment.metaDataService = metaDataService;
    }
}
