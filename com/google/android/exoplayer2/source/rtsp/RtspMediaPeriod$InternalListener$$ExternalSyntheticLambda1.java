package com.google.android.exoplayer2.source.rtsp;

public final /* synthetic */ class RtspMediaPeriod$InternalListener$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ RtspMediaPeriod f$0;

    public /* synthetic */ RtspMediaPeriod$InternalListener$$ExternalSyntheticLambda1(RtspMediaPeriod rtspMediaPeriod) {
        this.f$0 = rtspMediaPeriod;
    }

    public final void run() {
        this.f$0.maybeFinishPrepare();
    }
}
