package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

/* renamed from: com.google.android.exoplayer2.audio.AudioRendererEventListener$EventDispatcher$$ExternalSyntheticLambda7 */
public final /* synthetic */ class C1009x1350c7c8 implements Runnable {
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ C1009x1350c7c8(AudioRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f$0 = eventDispatcher;
        this.f$1 = str;
    }

    public final void run() {
        this.f$0.mo16578x97e584ca(this.f$1);
    }
}
