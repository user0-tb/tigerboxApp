package media.tiger.tigerbox.p016ui.settings.parentalGate;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_HiltModules */
public final class ParentalGateEnableDisableStepViewModel_HiltModules {
    private ParentalGateEnableDisableStepViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel")
        @IntoMap
        public abstract ViewModel binds(ParentalGateEnableDisableStepViewModel parentalGateEnableDisableStepViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.settings.parentalGate.ParentalGateEnableDisableStepViewModel";
        }

        private KeyModule() {
        }
    }
}
