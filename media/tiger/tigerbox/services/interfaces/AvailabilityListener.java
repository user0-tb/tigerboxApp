package media.tiger.tigerbox.services.interfaces;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/AvailabilityListener;", "", "didFailDownloadingProduct", "", "productId", "", "didProgressDownloadingProduct", "percent", "downloadedProductsDidChange", "downloadsInProgressDidChange", "inProgress", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: AvailabilityService.kt */
public interface AvailabilityListener {

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: AvailabilityService.kt */
    public static final class DefaultImpls {
        public static void didFailDownloadingProduct(AvailabilityListener availabilityListener, int i) {
        }

        public static void didProgressDownloadingProduct(AvailabilityListener availabilityListener, int i, int i2) {
        }

        public static void downloadedProductsDidChange(AvailabilityListener availabilityListener) {
        }

        public static void downloadsInProgressDidChange(AvailabilityListener availabilityListener, boolean z) {
        }
    }

    void didFailDownloadingProduct(int i);

    void didProgressDownloadingProduct(int i, int i2);

    void downloadedProductsDidChange();

    void downloadsInProgressDidChange(boolean z);
}
