package media.tiger.tigerbox.p016ui.main.maincontent;

import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.AvailabilityListener;

@Metadata(mo33736d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, mo33737d2 = {"media/tiger/tigerbox/ui/main/maincontent/ProductContentViewModel$availabilityServiceListener$1", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityListener;", "downloadedProductsDidChange", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontent.ProductContentViewModel$availabilityServiceListener$1 */
/* compiled from: ProductContentViewModel.kt */
public final class ProductContentViewModel$availabilityServiceListener$1 implements AvailabilityListener {
    final /* synthetic */ ProductContentViewModel this$0;

    ProductContentViewModel$availabilityServiceListener$1(ProductContentViewModel productContentViewModel) {
        this.this$0 = productContentViewModel;
    }

    public void didFailDownloadingProduct(int i) {
        AvailabilityListener.DefaultImpls.didFailDownloadingProduct(this, i);
    }

    public void didProgressDownloadingProduct(int i, int i2) {
        AvailabilityListener.DefaultImpls.didProgressDownloadingProduct(this, i, i2);
    }

    public void downloadsInProgressDidChange(boolean z) {
        AvailabilityListener.DefaultImpls.downloadsInProgressDidChange(this, z);
    }

    public void downloadedProductsDidChange() {
        this.this$0.updateListDlStatus();
    }
}
