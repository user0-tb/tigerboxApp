package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class DefaultDrmSession$$ExternalSyntheticLambda4 implements Consumer {
    public static final /* synthetic */ DefaultDrmSession$$ExternalSyntheticLambda4 INSTANCE = new DefaultDrmSession$$ExternalSyntheticLambda4();

    private /* synthetic */ DefaultDrmSession$$ExternalSyntheticLambda4() {
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).drmKeysRestored();
    }
}
