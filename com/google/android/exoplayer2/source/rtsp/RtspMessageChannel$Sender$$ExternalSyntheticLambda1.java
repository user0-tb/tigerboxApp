package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import java.util.List;

public final /* synthetic */ class RtspMessageChannel$Sender$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ RtspMessageChannel.Sender f$0;
    public final /* synthetic */ byte[] f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ RtspMessageChannel$Sender$$ExternalSyntheticLambda1(RtspMessageChannel.Sender sender, byte[] bArr, List list) {
        this.f$0 = sender;
        this.f$1 = bArr;
        this.f$2 = list;
    }

    public final void run() {
        this.f$0.mo18695x9fa6909d(this.f$1, this.f$2);
    }
}
