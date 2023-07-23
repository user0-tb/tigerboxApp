package media.tiger.tigerbox.p016ui;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.TigerBoxActivityViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.TigerBoxActivityViewModel_HiltModules_KeyModule_ProvideFactory */
public final class TigerBoxActivityViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static TigerBoxActivityViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(TigerBoxActivityViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.TigerBoxActivityViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final TigerBoxActivityViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new TigerBoxActivityViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
