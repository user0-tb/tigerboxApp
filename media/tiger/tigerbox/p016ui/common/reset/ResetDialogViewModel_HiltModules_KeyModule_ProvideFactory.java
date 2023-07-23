package media.tiger.tigerbox.p016ui.common.reset;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.common.reset.ResetDialogViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel_HiltModules_KeyModule_ProvideFactory */
public final class ResetDialogViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static ResetDialogViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(ResetDialogViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.common.reset.ResetDialogViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ResetDialogViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ResetDialogViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
