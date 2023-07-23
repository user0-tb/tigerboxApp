package media.tiger.tigerbox.p016ui.main.card;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel_HiltModules */
public final class TigerTicketPurchaseViewModel_HiltModules {
    private TigerTicketPurchaseViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel")
        @IntoMap
        public abstract ViewModel binds(TigerTicketPurchaseViewModel tigerTicketPurchaseViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel";
        }

        private KeyModule() {
        }
    }
}
