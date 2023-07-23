package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;

/* renamed from: media.tiger.tigerbox.infrastructure.di.CoroutinesModule_ProvidesApplicationScopeFactory */
public final class CoroutinesModule_ProvidesApplicationScopeFactory implements Factory<CoroutineScope> {
    private final Provider<CoroutineDispatcher> defaultDispatcherProvider;

    public CoroutinesModule_ProvidesApplicationScopeFactory(Provider<CoroutineDispatcher> provider) {
        this.defaultDispatcherProvider = provider;
    }

    public CoroutineScope get() {
        return providesApplicationScope(this.defaultDispatcherProvider.get());
    }

    public static CoroutinesModule_ProvidesApplicationScopeFactory create(Provider<CoroutineDispatcher> provider) {
        return new CoroutinesModule_ProvidesApplicationScopeFactory(provider);
    }

    public static CoroutineScope providesApplicationScope(CoroutineDispatcher coroutineDispatcher) {
        return (CoroutineScope) Preconditions.checkNotNullFromProvides(CoroutinesModule.INSTANCE.providesApplicationScope(coroutineDispatcher));
    }
}
