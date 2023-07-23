package com.google.android.exoplayer2.source.rtsp;

import android.os.HandlerThread;

public final /* synthetic */ class RtspMessageChannel$Sender$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ HandlerThread f$0;

    public /* synthetic */ RtspMessageChannel$Sender$$ExternalSyntheticLambda0(HandlerThread handlerThread) {
        this.f$0 = handlerThread;
    }

    public final void run() {
        this.f$0.quit();
    }
}
