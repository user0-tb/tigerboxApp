package media.tiger.tigerbox.p016ui.common.wifi;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel_HiltModules */
public final class WifiEnterPasswordViewModel_HiltModules {
    private WifiEnterPasswordViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel")
        @IntoMap
        public abstract ViewModel binds(WifiEnterPasswordViewModel wifiEnterPasswordViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.common.wifi.WifiEnterPasswordViewModel";
        }

        private KeyModule() {
        }
    }
}
