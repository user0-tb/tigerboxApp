package media.tiger.tigerbox.p016ui.settings.sendLogs;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel_HiltModules */
public final class SendLogsNoneViewModel_HiltModules {
    private SendLogsNoneViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel")
        @IntoMap
        public abstract ViewModel binds(SendLogsNoneViewModel sendLogsNoneViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.sendLogs.SendLogsNoneViewModel";
        }

        private KeyModule() {
        }
    }
}
