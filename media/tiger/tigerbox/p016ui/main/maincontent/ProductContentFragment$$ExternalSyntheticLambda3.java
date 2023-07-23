package media.tiger.tigerbox.p016ui.main.maincontent;

import androidx.lifecycle.Observer;
import media.tiger.tigerbox.services.interfaces.audioPlayer.AudioProductInfo;

/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentFragment$$ExternalSyntheticLambda3 */
public final /* synthetic */ class ProductContentFragment$$ExternalSyntheticLambda3 implements Observer {
    public final /* synthetic */ ProductContentFragment f$0;

    public /* synthetic */ ProductContentFragment$$ExternalSyntheticLambda3(ProductContentFragment productContentFragment) {
        this.f$0 = productContentFragment;
    }

    public final void onChanged(Object obj) {
        ProductContentFragment.m2399onViewCreated$lambda7(this.f$0, (AudioProductInfo) obj);
    }
}
