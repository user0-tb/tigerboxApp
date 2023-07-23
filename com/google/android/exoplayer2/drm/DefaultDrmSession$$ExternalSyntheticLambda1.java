package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class DefaultDrmSession$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ Exception f$0;

    public /* synthetic */ DefaultDrmSession$$ExternalSyntheticLambda1(Exception exc) {
        this.f$0 = exc;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmSessionManagerError(this.f$0);
    }
}
