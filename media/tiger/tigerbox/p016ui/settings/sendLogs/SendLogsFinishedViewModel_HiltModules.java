package media.tiger.tigerbox.p016ui.settings.sendLogs;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsFinishedViewModel_HiltModules */
public final class SendLogsFinishedViewModel_HiltModules {
    private SendLogsFinishedViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsFinishedViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.sendLogs.SendLogsFinishedViewModel")
        @IntoMap
        public abstract ViewModel binds(SendLogsFinishedViewModel sendLogsFinishedViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsFinishedViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.sendLogs.SendLogsFinishedViewModel";
        }

        private KeyModule() {
        }
    }
}
