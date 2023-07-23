package media.tiger.tigerbox.infrastructure.p015di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: media.tiger.tigerbox.infrastructure.di.CoroutinesModule_ProvidesMainImmediateDispatcherFactory */
public final class CoroutinesModule_ProvidesMainImmediateDispatcherFactory implements Factory<CoroutineDispatcher> {
    public CoroutineDispatcher get() {
        return providesMainImmediateDispatcher();
    }

    public static CoroutinesModule_ProvidesMainImmediateDispatcherFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static CoroutineDispatcher providesMainImmediateDispatcher() {
        return (CoroutineDispatcher) Preconditions.checkNotNullFromProvides(CoroutinesModule.INSTANCE.providesMainImmediateDispatcher());
    }

    /* renamed from: media.tiger.tigerbox.infrastructure.di.CoroutinesModule_ProvidesMainImmediateDispatcherFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final CoroutinesModule_ProvidesMainImmediateDispatcherFactory INSTANCE = new CoroutinesModule_ProvidesMainImmediateDispatcherFactory();

        private InstanceHolder() {
        }
    }
}
