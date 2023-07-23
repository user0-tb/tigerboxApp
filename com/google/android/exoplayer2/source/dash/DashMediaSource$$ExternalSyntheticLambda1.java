package com.google.android.exoplayer2.source.dash;

public final /* synthetic */ class DashMediaSource$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ DashMediaSource f$0;

    public /* synthetic */ DashMediaSource$$ExternalSyntheticLambda1(DashMediaSource dashMediaSource) {
        this.f$0 = dashMediaSource;
    }

    public final void run() {
        this.f$0.startLoadingManifest();
    }
}
