package media.tiger.tigerbox.p016ui.settings.systeminfo;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.systeminfo.SystemInfoViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel_HiltModules_KeyModule_ProvideFactory */
public final class SystemInfoViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static SystemInfoViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(SystemInfoViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SystemInfoViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SystemInfoViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
