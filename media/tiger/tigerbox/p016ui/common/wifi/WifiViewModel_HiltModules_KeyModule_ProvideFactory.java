package media.tiger.tigerbox.p016ui.common.wifi;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.common.wifi.WifiViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel_HiltModules_KeyModule_ProvideFactory */
public final class WifiViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static WifiViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(WifiViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final WifiViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new WifiViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
