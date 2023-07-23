package media.tiger.tigerbox.usecase;

import dagger.internal.Factory;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import media.tiger.tigerbox.data.network.TigerBoxWebService;

public final class PostTrackingEventUseCase_Factory implements Factory<PostTrackingEventUseCase> {
    private final Provider<CoroutineDispatcher> dispatcherProvider;
    private final Provider<TigerBoxWebService> tigerBoxWebServiceProvider;

    public PostTrackingEventUseCase_Factory(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        this.tigerBoxWebServiceProvider = provider;
        this.dispatcherProvider = provider2;
    }

    public PostTrackingEventUseCase get() {
        return newInstance(this.tigerBoxWebServiceProvider.get(), this.dispatcherProvider.get());
    }

    public static PostTrackingEventUseCase_Factory create(Provider<TigerBoxWebService> provider, Provider<CoroutineDispatcher> provider2) {
        return new PostTrackingEventUseCase_Factory(provider, provider2);
    }

    public static PostTrackingEventUseCase newInstance(TigerBoxWebService tigerBoxWebService, CoroutineDispatcher coroutineDispatcher) {
        return new PostTrackingEventUseCase(tigerBoxWebService, coroutineDispatcher);
    }
}
