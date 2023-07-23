package media.tiger.tigerbox.usecase.tigerboxuserrepo;

import dagger.internal.Factory;
import javax.inject.Provider;
import media.tiger.tigerbox.data.repository.TigerBoxAccountRepository;

public final class GetTigerBoxAccountUseCase_Factory implements Factory<GetTigerBoxAccountUseCase> {
    private final Provider<TigerBoxAccountRepository> repositoryProvider;

    public GetTigerBoxAccountUseCase_Factory(Provider<TigerBoxAccountRepository> provider) {
        this.repositoryProvider = provider;
    }

    public GetTigerBoxAccountUseCase get() {
        return newInstance(this.repositoryProvider.get());
    }

    public static GetTigerBoxAccountUseCase_Factory create(Provider<TigerBoxAccountRepository> provider) {
        return new GetTigerBoxAccountUseCase_Factory(provider);
    }

    public static GetTigerBoxAccountUseCase newInstance(TigerBoxAccountRepository tigerBoxAccountRepository) {
        return new GetTigerBoxAccountUseCase(tigerBoxAccountRepository);
    }
}
