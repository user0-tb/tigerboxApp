package media.tiger.tigerbox.services.interfaces.downloadsManager;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo33736d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadsManagerListener;", "", "downloadRequestFailed", "", "errorMessage", "", "request", "Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadJob;", "downloadRequestFinished", "downloadRequestProgressed", "downloadingStateChanged", "downloadsInProgress", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadsManagerListener.kt */
public interface DownloadsManagerListener {

    @Metadata(mo33738k = 3, mo33739mv = {1, 6, 0}, mo33741xi = 48)
    /* compiled from: DownloadsManagerListener.kt */
    public static final class DefaultImpls {
        public static void downloadRequestFailed(DownloadsManagerListener downloadsManagerListener, String str, DownloadJob downloadJob) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
            Intrinsics.checkNotNullParameter(downloadJob, "request");
        }

        public static void downloadRequestFinished(DownloadsManagerListener downloadsManagerListener, DownloadJob downloadJob) {
            Intrinsics.checkNotNullParameter(downloadJob, "request");
        }

        public static void downloadRequestProgressed(DownloadsManagerListener downloadsManagerListener, DownloadJob downloadJob) {
            Intrinsics.checkNotNullParameter(downloadJob, "request");
        }

        public static void downloadingStateChanged(DownloadsManagerListener downloadsManagerListener, boolean z) {
        }
    }

    void downloadRequestFailed(String str, DownloadJob downloadJob);

    void downloadRequestFinished(DownloadJob downloadJob);

    void downloadRequestProgressed(DownloadJob downloadJob);

    void downloadingStateChanged(boolean z);
}
