package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

/* renamed from: com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda1 */
public final /* synthetic */ class C1003x1350c7c2 implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ C1003x1350c7c2(AudioRendererEventListener.EventDispatcher eventDispatcher, long j) {
        this.f$0 = eventDispatcher;
        this.f$1 = j;
    }

    public final void run() {
        this.f$0.mo16582x4b664277(this.f$1);
    }
}
