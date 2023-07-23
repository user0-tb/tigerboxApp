package com.google.android.exoplayer2.source;

public final /* synthetic */ class ProgressiveMediaPeriod$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ProgressiveMediaPeriod f$0;

    public /* synthetic */ ProgressiveMediaPeriod$$ExternalSyntheticLambda2(ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.f$0 = progressiveMediaPeriod;
    }

    public final void run() {
        this.f$0.maybeFinishPrepare();
    }
}
