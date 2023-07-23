package media.tiger.tigerbox.p016ui.main.maincontent;

import androidx.lifecycle.ViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel_HiltModules */
public final class ProductContentViewModel_HiltModules {
    private ProductContentViewModel_HiltModules() {
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel_HiltModules$BindsModule */
    public static abstract class BindsModule {
        @Binds
        @StringKey("media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel")
        @IntoMap
        public abstract ViewModel binds(ProductContentViewModel productContentViewModel);

        private BindsModule() {
        }
    }

    @Module
    /* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel_HiltModules$KeyModule */
    public static final class KeyModule {
        @IntoSet
        @Provides
        public static String provide() {
            return "media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel";
        }

        private KeyModule() {
        }
    }
}
