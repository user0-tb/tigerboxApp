package media.tiger.tigerbox.p016ui.common.wifi;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.common.wifi.WifiEnterPasswordViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel_HiltModules_KeyModule_ProvideFactory */
public final class WifiEnterPasswordViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static WifiEnterPasswordViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(WifiEnterPasswordViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final WifiEnterPasswordViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new WifiEnterPasswordViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
