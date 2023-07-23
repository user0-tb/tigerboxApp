package media.tiger.tigerbox.p016ui.main.maincontentheader;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import media.tiger.tigerbox.p016ui.common.BaseViewModel;
import media.tiger.tigerbox.services.interfaces.AvailabilityListener;
import media.tiger.tigerbox.services.interfaces.HeaderProvider;
import media.tiger.tigerbox.services.interfaces.StorageService;

@Metadata(mo33736d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo33737d2 = {"Lmedia/tiger/tigerbox/ui/main/maincontentheader/MainContentHeaderBarViewModel;", "Lmedia/tiger/tigerbox/ui/common/BaseViewModel;", "Lmedia/tiger/tigerbox/services/interfaces/AvailabilityListener;", "storageService", "Lmedia/tiger/tigerbox/services/interfaces/StorageService;", "headerProvider", "Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "(Lmedia/tiger/tigerbox/services/interfaces/StorageService;Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;)V", "getHeaderProvider", "()Lmedia/tiger/tigerbox/services/interfaces/HeaderProvider;", "isCurrentlyInOfflineMode", "", "()Z", "setCurrentlyInOfflineMode", "(Z)V", "onViewDestroyed", "", "onViewPrepared", "removeCurrentTimeAndDate", "storeCurrentTimeAndDate", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* renamed from: media.tiger.tigerbox.ui.main.maincontentheader.MainContentHeaderBarViewModel */
/* compiled from: MainContentHeaderBarViewModel.kt */
public final class MainContentHeaderBarViewModel extends BaseViewModel implements AvailabilityListener {
    private final HeaderProvider headerProvider;
    private boolean isCurrentlyInOfflineMode;
    private final StorageService storageService;

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
        AvailabilityListener.DefaultImpls.downloadsInProgressDidChange(this, z);
    }

    public final HeaderProvider getHeaderProvider() {
        return this.headerProvider;
    }

    @Inject
    public MainContentHeaderBarViewModel(StorageService storageService2, HeaderProvider headerProvider2) {
        Intrinsics.checkNotNullParameter(storageService2, "storageService");
        Intrinsics.checkNotNullParameter(headerProvider2, "headerProvider");
        this.storageService = storageService2;
        this.headerProvider = headerProvider2;
    }

    public final boolean isCurrentlyInOfflineMode() {
        return this.isCurrentlyInOfflineMode;
    }

    public final void setCurrentlyInOfflineMode(boolean z) {
        this.isCurrentlyInOfflineMode = z;
    }

    public final void onViewPrepared() {
        this.headerProvider.subscribe();
    }

    public final void onViewDestroyed() {
        this.headerProvider.unsubscribe();
    }

    public final void storeCurrentTimeAndDate() {
        this.storageService.storeOfflineStartTimeAndDate();
    }

    public final void removeCurrentTimeAndDate() {
        this.storageService.removeOfflineStartTimeAndDate();
    }
}
