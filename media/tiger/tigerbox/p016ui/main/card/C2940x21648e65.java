package media.tiger.tigerbox.p016ui.main.card;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketPurchaseViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C2940x21648e65 implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C2940x21648e65 create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(TigerTicketPurchaseViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketPurchaseViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C2940x21648e65 INSTANCE = new C2940x21648e65();

        private InstanceHolder() {
        }
    }
}
