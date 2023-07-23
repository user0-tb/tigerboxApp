package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: media.tiger.tigerbox.infrastructure.di.CoroutinesModule_ProvidesIoDispatcherFactory */
public final class CoroutinesModule_ProvidesIoDispatcherFactory implements Factory<CoroutineDispatcher> {
    public CoroutineDispatcher get() {
        return providesIoDispatcher();
    }

    public static CoroutinesModule_ProvidesIoDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesIoDispatcher() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(CoroutinesModule.INSTANCE.providesIoDispatcher());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.CoroutinesModule_ProvidesIoDispatcherFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CoroutinesModule_ProvidesIoDispatcherFactory INSTANCE = new CoroutinesModule_ProvidesIoDispatcherFactory();

        private InstanceHolder() {
        }
    }
}
