package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* renamed from: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda8 */
public final /* synthetic */ class C1239x6446ce84 implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ C1239x6446ce84(VideoRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f$0 = eventDispatcher;
        this.f$1 = str;
    }

    public final void run() {
        this.f$0.mo20098x4f63d3e(this.f$1);
    }
}
