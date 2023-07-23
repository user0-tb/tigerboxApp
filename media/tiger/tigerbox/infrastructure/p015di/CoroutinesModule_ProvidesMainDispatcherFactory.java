package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: media.tiger.tigerbox.infrastructure.di.CoroutinesModule_ProvidesMainDispatcherFactory */
public final class CoroutinesModule_ProvidesMainDispatcherFactory implements Factory<CoroutineDispatcher> {
    public CoroutineDispatcher get() {
        return providesMainDispatcher();
    }

    public static CoroutinesModule_ProvidesMainDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesMainDispatcher() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(CoroutinesModule.INSTANCE.providesMainDispatcher());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.CoroutinesModule_ProvidesMainDispatcherFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CoroutinesModule_ProvidesMainDispatcherFactory INSTANCE = new CoroutinesModule_ProvidesMainDispatcherFactory();

        private InstanceHolder() {
        }
    }
}
