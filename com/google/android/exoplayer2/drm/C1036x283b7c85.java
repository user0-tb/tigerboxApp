package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

/* renamed from: com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher$$ExternalSyntheticLambda2 */
public final /* synthetic */ class C1036x283b7c85 implements Runnable {
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher f$0;
    public final /* synthetic */ DrmSessionEventListener f$1;

    public /* synthetic */ C1036x283b7c85(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.f$0 = eventDispatcher;
        this.f$1 = drmSessionEventListener;
    }

    public final void run() {
        this.f$0.mo16883x8910d2ab(this.f$1);
    }
}
