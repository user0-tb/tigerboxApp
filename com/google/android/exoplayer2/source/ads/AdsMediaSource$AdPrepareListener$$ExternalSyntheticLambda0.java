package com.google.android.exoplayer2.source.ads;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;

public final /* synthetic */ class AdsMediaSource$AdPrepareListener$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AdsMediaSource.AdPrepareListener f$0;
    public final /* synthetic */ MediaSource.MediaPeriodId f$1;

    public /* synthetic */ AdsMediaSource$AdPrepareListener$$ExternalSyntheticLambda0(AdsMediaSource.AdPrepareListener adPrepareListener, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f$0 = adPrepareListener;
        this.f$1 = mediaPeriodId;
    }

    public final void run() {
        this.f$0.mo18142x605e06cc(this.f$1);
    }
}
