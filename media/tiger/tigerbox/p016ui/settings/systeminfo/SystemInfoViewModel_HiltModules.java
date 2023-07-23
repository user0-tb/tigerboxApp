package media.tiger.tigerbox.p016ui.settings.systeminfo;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel_HiltModules */
public final class SystemInfoViewModel_HiltModules {
    private SystemInfoViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel")
        @IntoMap
        public abstract ViewModel binds(SystemInfoViewModel systemInfoViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.systeminfo.SystemInfoViewModel";
        }

        private KeyModule() {
        }
    }
}
