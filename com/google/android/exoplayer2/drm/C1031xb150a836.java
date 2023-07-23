package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;

/* renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$ReferenceCountListenerImpl$$ExternalSyntheticLambda0 */
public final /* synthetic */ class C1031xb150a836 implements Runnable {
    public final /* synthetic */ DefaultDrmSession f$0;

    public /* synthetic */ C1031xb150a836(DefaultDrmSession defaultDrmSession) {
        this.f$0 = defaultDrmSession;
    }

    public final void run() {
        this.f$0.release((DrmSessionEventListener.EventDispatcher) null);
    }
}
