package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: media.tiger.tigerbox.infrastructure.di.CoroutinesModule_ProvidesDefaultDispatcherFactory */
public final class CoroutinesModule_ProvidesDefaultDispatcherFactory implements Factory<CoroutineDispatcher> {
    public CoroutineDispatcher get() {
        return providesDefaultDispatcher();
    }

    public static CoroutinesModule_ProvidesDefaultDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesDefaultDispatcher() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(CoroutinesModule.INSTANCE.providesDefaultDispatcher());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.CoroutinesModule_ProvidesDefaultDispatcherFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CoroutinesModule_ProvidesDefaultDispatcherFactory INSTANCE = new CoroutinesModule_ProvidesDefaultDispatcherFactory();

        private InstanceHolder() {
        }
    }
}
