package media.tiger.tigerbox.p016ui.settings.sendLogs;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.sendLogs.SendLogsNoneViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel_HiltModules_KeyModule_ProvideFactory */
public final class SendLogsNoneViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static SendLogsNoneViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(SendLogsNoneViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final SendLogsNoneViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new SendLogsNoneViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
