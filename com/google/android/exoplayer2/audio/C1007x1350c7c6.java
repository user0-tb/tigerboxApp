package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

/* renamed from: com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda5 */
public final /* synthetic */ class C1007x1350c7c6 implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ Exception f$1;

    public /* synthetic */ C1007x1350c7c6(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f$0 = eventDispatcher;
        this.f$1 = exc;
    }

    public final void run() {
        this.f$0.mo16575x305f60bf(this.f$1);
    }
}
