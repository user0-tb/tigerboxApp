package media.tiger.tigerbox.services.implementations;

import kotlin.Metadata;
import media.tiger.tigerbox.services.interfaces.AvailabilityListener;

@Metadata(mo33736d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo33737d2 = {"media/tiger/tigerbox/services/implementations/HeaderBarProvider$downloadsListener$1", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityListener;", "downloadsInProgressDidChange", "", "inProgress", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: HeaderBarProvider.kt */
public final class HeaderBarProvider$downloadsListener$1 implements AvailabilityListener {
    final /* synthetic */ HeaderBarProvider this$0;

    HeaderBarProvider$downloadsListener$1(HeaderBarProvider headerBarProvider) {
        this.this$0 = headerBarProvider;
    }

    public void didFailDownloadingProduct(int i) {
        AvailabilityListener.DefaultImpls.didFailDownloadingProduct(this, i);
    }

    public void didProgressDownloadingProduct(int i, int i2) {
        AvailabilityListener.DefaultImpls.didProgressDownloadingProduct(this, i, i2);
    }

    public void downloadedProductsDidChange() {
        AvailabilityListener.DefaultImpls.downloadedProductsDidChange(this);
    }

    public void downloadsInProgressDidChange(boolean z) {
        this.this$0._downloadsInProgress.postValue(Boolean.valueOf(z));
    }
}
