package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpDataLoadable;
import com.google.android.exoplayer2.source.rtsp.RtspMediaPeriod;

public final /* synthetic */ class RtspMediaPeriod$RtpLoadInfo$$ExternalSyntheticLambda0 implements RtpDataLoadable.EventListener {
    public final /* synthetic */ RtspMediaPeriod.RtpLoadInfo f$0;

    public /* synthetic */ RtspMediaPeriod$RtpLoadInfo$$ExternalSyntheticLambda0(RtspMediaPeriod.RtpLoadInfo rtpLoadInfo) {
        this.f$0 = rtpLoadInfo;
    }

    public final void onTransportReady(String str, RtpDataChannel rtpDataChannel) {
        this.f$0.mo18667x3d57be61(str, rtpDataChannel);
    }
}
