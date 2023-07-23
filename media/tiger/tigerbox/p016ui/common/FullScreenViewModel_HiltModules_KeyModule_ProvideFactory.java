package media.tiger.tigerbox.p016ui.common;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.common.FullScreenViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.common.FullScreenViewModel_HiltModules_KeyModule_ProvideFactory */
public final class FullScreenViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static FullScreenViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(FullScreenViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.common.FullScreenViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final FullScreenViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new FullScreenViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
