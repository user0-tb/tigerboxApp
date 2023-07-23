package com.google.android.exoplayer2.drm;

import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class OfflineLicenseHelper$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ OfflineLicenseHelper f$0;
    public final /* synthetic */ SettableFuture f$1;
    public final /* synthetic */ DrmSession f$2;

    public /* synthetic */ OfflineLicenseHelper$$ExternalSyntheticLambda3(OfflineLicenseHelper offlineLicenseHelper, SettableFuture settableFuture, DrmSession drmSession) {
        this.f$0 = offlineLicenseHelper;
        this.f$1 = settableFuture;
        this.f$2 = drmSession;
    }

    public final void run() {
        this.f$0.mo16942xe95153c6(this.f$1, this.f$2);
    }
}
