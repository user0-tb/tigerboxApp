package media.tiger.tigerbox.p016ui.main.card;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel_HiltModules */
public final class TigerTicketInputPinViewModel_HiltModules {
    private TigerTicketInputPinViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel")
        @IntoMap
        public abstract ViewModel binds(TigerTicketInputPinViewModel tigerTicketInputPinViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel";
        }

        private KeyModule() {
        }
    }
}
