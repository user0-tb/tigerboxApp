package media.tiger.tigerbox.p016ui.settings.sendLogs;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsInProgressViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel_HiltModules_KeyModule_ProvideFactory */
public final class SendLogsInProgressViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static SendLogsInProgressViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(SendLogsInProgressViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SendLogsInProgressViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SendLogsInProgressViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
