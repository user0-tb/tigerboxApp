package com.google.android.exoplayer2.drm;

import android.media.MediaDrm;
import com.google.android.exoplayer2.drm.ExoMediaDrm;

public final /* synthetic */ class FrameworkMediaDrm$$ExternalSyntheticLambda1 implements MediaDrm.OnExpirationUpdateListener {
    public final /* synthetic */ FrameworkMediaDrm f$0;
    public final /* synthetic */ ExoMediaDrm.OnExpirationUpdateListener f$1;

    public /* synthetic */ FrameworkMediaDrm$$ExternalSyntheticLambda1(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        this.f$0 = frameworkMediaDrm;
        this.f$1 = onExpirationUpdateListener;
    }

    public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j) {
        this.f$0.mo16928x78401754(this.f$1, mediaDrm, bArr, j);
    }
}
