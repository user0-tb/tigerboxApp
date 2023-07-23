package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.Comparator;

public final /* synthetic */ class DownloadManager$InternalHandler$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ DownloadManager$InternalHandler$$ExternalSyntheticLambda0 INSTANCE = new DownloadManager$InternalHandler$$ExternalSyntheticLambda0();

    private /* synthetic */ DownloadManager$InternalHandler$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return DownloadManager.InternalHandler.compareStartTimes((Download) obj, (Download) obj2);
    }
}
