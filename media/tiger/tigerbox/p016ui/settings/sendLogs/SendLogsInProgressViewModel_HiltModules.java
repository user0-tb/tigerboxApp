package media.tiger.tigerbox.p016ui.settings.sendLogs;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel_HiltModules */
public final class SendLogsInProgressViewModel_HiltModules {
    private SendLogsInProgressViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel")
        @IntoMap
        public abstract ViewModel binds(SendLogsInProgressViewModel sendLogsInProgressViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.sendLogs.SendLogsInProgressViewModel";
        }

        private KeyModule() {
        }
    }
}
