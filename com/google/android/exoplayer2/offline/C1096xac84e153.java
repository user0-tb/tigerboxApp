package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadService;

/* renamed from: com.google.android.exoplayer2.offline.DownloadService$ForegroundNotificationUpdater$$ExternalSyntheticLambda0 */
public final /* synthetic */ class C1096xac84e153 implements Runnable {
    public final /* synthetic */ DownloadService.ForegroundNotificationUpdater f$0;

    public /* synthetic */ C1096xac84e153(DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater) {
        this.f$0 = foregroundNotificationUpdater;
    }

    public final void run() {
        this.f$0.update();
    }
}
