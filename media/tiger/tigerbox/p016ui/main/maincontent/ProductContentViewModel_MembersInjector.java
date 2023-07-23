package media.tiger.tigerbox.p016ui.main.maincontent;

import dagger.MembersInjector;
import javax.inject.Provider;
import media.tiger.tigerbox.p016ui.common.BaseViewModel_MembersInjector;
import media.tiger.tigerbox.services.interfaces.LightControlService;

/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel_MembersInjector */
public final class ProductContentViewModel_MembersInjector implements MembersInjector<ProductContentViewModel> {
    private final Provider<LightControlService> _lightControlProvider;

    public ProductContentViewModel_MembersInjector(Provider<LightControlService> provider) {
        this._lightControlProvider = provider;
    }

    public static MembersInjector<ProductContentViewModel> create(Provider<LightControlService> provider) {
        return new ProductContentViewModel_MembersInjector(provider);
    }

    public void injectMembers(ProductContentViewModel productContentViewModel) {
        BaseViewModel_MembersInjector.inject_lightControl(productContentViewModel, this._lightControlProvider.get());
    }
}
