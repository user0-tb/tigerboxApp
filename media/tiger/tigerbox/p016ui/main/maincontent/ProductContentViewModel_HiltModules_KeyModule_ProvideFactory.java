package media.tiger.tigerbox.p016ui.main.maincontent;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import media.tiger.tigerbox.p016ui.main.maincontent.ProductContentViewModel_HiltModules;

/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel_HiltModules_KeyModule_ProvideFactory */
public final class ProductContentViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
    public String get() {
        return provide();
    }

    public static ProductContentViewModel_HiltModules_KeyModule_ProvideFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static String provide() {
        return (String) Preconditions.checkNotNullFromProvides(ProductContentViewModel_HiltModules.KeyModule.provide());
    }

    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel_HiltModules_KeyModule_ProvideFactory$InstanceHolder */
    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ProductContentViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new ProductContentViewModel_HiltModules_KeyModule_ProvideFactory();

        private InstanceHolder() {
        }
    }
}
