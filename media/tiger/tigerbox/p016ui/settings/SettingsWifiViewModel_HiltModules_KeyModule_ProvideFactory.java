package media.tiger.tigerbox.p016ui.settings;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.SettingsWifiViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.SettingsWifiViewModel_HiltModules_KeyModule_ProvideFactory */
public final class SettingsWifiViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static SettingsWifiViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(SettingsWifiViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.SettingsWifiViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SettingsWifiViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SettingsWifiViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
