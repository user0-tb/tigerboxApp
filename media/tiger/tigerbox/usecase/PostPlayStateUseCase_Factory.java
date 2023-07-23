package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;

public final class PostPlayStateUseCase_Factory implements Factory<PostPlayStateUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public PostPlayStateUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        this.tigerBoxWebServiceProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public PostPlayStateUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.dispatcherProvider.get());
    }

    public static PostPlayStateUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        return new PostPlayStateUseCase_Factory(provider, provider2);
    }

    public static PostPlayStateUseCase newInstance(TigerBoxWebService tigerBoxWebService, CoroutineDispatcher coroutineDispatcher) {
        return new PostPlayStateUseCase(tigerBoxWebService, coroutineDispatcher);
    }
}
