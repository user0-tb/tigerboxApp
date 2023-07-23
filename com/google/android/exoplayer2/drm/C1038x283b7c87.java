package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

/* renamed from: com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda4 */
public final /* synthetic */ class C1038x283b7c87 implements Runnable {
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f$0;
    public final /* synthetic */ DrmSessionEventListener f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ C1038x283b7c87(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, int i) {
        this.f$0 = eventDispatcher;
        this.f$1 = drmSessionEventListener;
        this.f$2 = i;
    }

    public final void run() {
        this.f$0.mo16884x7aff32be(this.f$1, this.f$2);
    }
}
