package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;

final class TransferRtpDataChannelFactory implements RtpDataChannel.Factory {
    private static final int INTERLEAVED_CHANNELS_PER_TRACK = 2;
    private final long timeoutMs;

    public /* synthetic */ RtpDataChannel.Factory createFallbackDataChannelFactory() {
        return RtpDataChannel.Factory.CC.$default$createFallbackDataChannelFactory(this);
    }

    public TransferRtpDataChannelFactory(long j) {
        this.timeoutMs = j;
    }

    public RtpDataChannel createAndOpenDataChannel(int i) {
        TransferRtpDataChannel transferRtpDataChannel = new TransferRtpDataChannel(this.timeoutMs);
        transferRtpDataChannel.open(RtpUtils.getIncomingRtpDataSpec(i * 2));
        return transferRtpDataChannel;
    }
}
