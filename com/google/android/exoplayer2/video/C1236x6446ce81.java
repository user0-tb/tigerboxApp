package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

/* renamed from: com.google.android.exoplayer2.video.VideoRendererEventListener$EventDispatcher$$ExternalSyntheticLambda5 */
public final /* synthetic */ class C1236x6446ce81 implements Runnable {
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f$0;
    public final /* synthetic */ VideoSize f$1;

    public /* synthetic */ C1236x6446ce81(VideoRendererEventListener.EventDispatcher eventDispatcher, VideoSize videoSize) {
        this.f$0 = eventDispatcher;
        this.f$1 = videoSize;
    }

    public final void run() {
        this.f$0.mo20106x75d86d2f(this.f$1);
    }
}
