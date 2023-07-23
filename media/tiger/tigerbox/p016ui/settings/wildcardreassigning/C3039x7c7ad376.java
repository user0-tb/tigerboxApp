package media.tiger.tigerbox.p016ui.settings.wildcardreassigning;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C3039x7c7ad376 implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C3039x7c7ad376 create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(TicketRedeemTicketNumberViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.settings.wildcardreassigning.TicketRedeemTicketNumberViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C3039x7c7ad376 INSTANCE = new C3039x7c7ad376();

        private InstanceHolder() {
        }
    }
}
