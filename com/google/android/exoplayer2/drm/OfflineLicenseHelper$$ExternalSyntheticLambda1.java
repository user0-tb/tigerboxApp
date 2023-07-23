package com.google.android.exoplayer2.drm;

import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class OfflineLicenseHelper$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ OfflineLicenseHelper f$0;
    public final /* synthetic */ DrmSession f$1;
    public final /* synthetic */ SettableFuture f$2;

    public /* synthetic */ OfflineLicenseHelper$$ExternalSyntheticLambda1(OfflineLicenseHelper offlineLicenseHelper, DrmSession drmSession, SettableFuture settableFuture) {
        this.f$0 = offlineLicenseHelper;
        this.f$1 = drmSession;
        this.f$2 = settableFuture;
    }

    public final void run() {
        this.f$0.mo16941x43a0200b(this.f$1, this.f$2);
    }
}
