package media.tiger.tigerbox.services.interfaces.downloadsManager;

import kotlin.Metadata;

@Metadata(mo33736d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R\u0012\u0010\u0013\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\tR\u0012\u0010\u0015\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0005¨\u0006\u0019"}, mo33737d2 = {"Lmedia/tiger/tigerbox/services/interfaces/downloadsManager/DownloadJob;", "", "destinationPath", "", "getDestinationPath", "()Ljava/lang/String;", "downloadedLengthKb", "", "getDownloadedLengthKb", "()J", "isInProgress", "", "()Z", "progress", "", "getProgress", "()I", "sourceUrl", "getSourceUrl", "totalLengthKb", "getTotalLengthKb", "uuid", "getUuid", "cancel", "", "app_tigerBoxRelease"}, mo33738k = 1, mo33739mv = {1, 6, 0}, mo33741xi = 48)
/* compiled from: DownloadJob.kt */
public interface DownloadJob {
    void cancel();

    String getDestinationPath();

    long getDownloadedLengthKb();

    int getProgress();

    String getSourceUrl();

    long getTotalLengthKb();

    String getUuid();

    boolean isInProgress();
}
