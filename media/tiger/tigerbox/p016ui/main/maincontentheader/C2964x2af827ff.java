package media.tiger.tigerbox.p016ui.main.maincontentheader;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.main.maincontentheader.MainContentHeaderBarViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel_HiltModules_KeyModule_ProvideFactory */
public final class C2964x2af827ff implements Factory<String> {
    public String get() {
        return provide();
    }

    public static C2964x2af827ff create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(MainContentHeaderBarViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final C2964x2af827ff INSTANCE = new C2964x2af827ff();

        private InstanceHolder() {
        }
    }
}
