package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* renamed from: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda7 */
public final /* synthetic */ class C1238x6446ce83 implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ C1238x6446ce83(VideoRendererEventListener.EventDispatcher eventDispatcher, Object obj, long j) {
        this.f$0 = eventDispatcher;
        this.f$1 = obj;
        this.f$2 = j;
    }

    public final void run() {
        this.f$0.mo20103xc9a6e54(this.f$1, this.f$2);
    }
}
