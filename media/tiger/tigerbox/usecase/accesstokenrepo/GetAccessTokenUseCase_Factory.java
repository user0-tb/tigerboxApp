package media.tiger.tigerbox.usecase.accesstokenrepo;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.AccessTokenRepository;

public final class GetAccessTokenUseCase_Factory implements Factory<GetAccessTokenUseCase> {
    private final Provider<AccessTokenRepository> repositoryProvider;

    public GetAccessTokenUseCase_Factory(Provider<AccessTokenRepository> provider) {
        this.repositoryProvider = provider;
    }

    public GetAccessTokenUseCase get() {
        return newInstance(this.repositoryProvider);
    }

    public static GetAccessTokenUseCase_Factory create(Provider<AccessTokenRepository> provider) {
        return new GetAccessTokenUseCase_Factory(provider);
    }

    public static GetAccessTokenUseCase newInstance(Provider<AccessTokenRepository> provider) {
        return new GetAccessTokenUseCase(provider);
    }
}
