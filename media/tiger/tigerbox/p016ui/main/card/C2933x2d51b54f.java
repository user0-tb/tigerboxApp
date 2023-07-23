package media.tiger.tigerbox.p016ui.main.card;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.main.card.TigerTicketInputPinViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C2933x2d51b54f implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C2933x2d51b54f create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(TigerTicketInputPinViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.main.card.TigerTicketInputPinViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C2933x2d51b54f INSTANCE = new C2933x2d51b54f();

        private InstanceHolder() {
        }
    }
}
