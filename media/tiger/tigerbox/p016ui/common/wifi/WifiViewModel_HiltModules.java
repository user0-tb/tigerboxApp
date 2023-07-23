package media.tiger.tigerbox.p016ui.common.wifi;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel_HiltModules */
public final class WifiViewModel_HiltModules {
    private WifiViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.common.wifi.WifiViewModel")
        @IntoMap
        public abstract ViewModel binds(WifiViewModel wifiViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.common.wifi.WifiViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.common.wifi.WifiViewModel";
        }

        private KeyModule() {
        }
    }
}
