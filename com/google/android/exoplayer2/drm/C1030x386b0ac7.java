package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

/* renamed from: com.google.android.exoplayer2.drm.DefaultDrmSessionManager$PreacquiredSessionReference$$ExternalSyntheticLambda1 */
public final /* synthetic */ class C1030x386b0ac7 implements Runnable {
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference f$0;
    public final /* synthetic */ Format f$1;

    public /* synthetic */ C1030x386b0ac7(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference, Format format) {
        this.f$0 = preacquiredSessionReference;
        this.f$1 = format;
    }

    public final void run() {
        this.f$0.mo16843xe3bb136(this.f$1);
    }
}
