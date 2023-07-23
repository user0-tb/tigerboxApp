package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.Format;
import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class OfflineLicenseHelper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ OfflineLicenseHelper f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ byte[] f$2;
    public final /* synthetic */ SettableFuture f$3;
    public final /* synthetic */ Format f$4;

    public /* synthetic */ OfflineLicenseHelper$$ExternalSyntheticLambda0(OfflineLicenseHelper offlineLicenseHelper, int i, byte[] bArr, SettableFuture settableFuture, Format format) {
        this.f$0 = offlineLicenseHelper;
        this.f$1 = i;
        this.f$2 = bArr;
        this.f$3 = settableFuture;
        this.f$4 = format;
    }

    public final void run() {
        this.f$0.mo16940x4269cd2c(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
