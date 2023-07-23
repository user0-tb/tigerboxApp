package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

/* renamed from: com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda9 */
public final /* synthetic */ class C1011x1350c7ca implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ C1011x1350c7ca(AudioRendererEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.f$0 = eventDispatcher;
        this.f$1 = z;
    }

    public final void run() {
        this.f$0.mo16583x9104d974(this.f$1);
    }
}
