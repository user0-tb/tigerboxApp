package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpPacketReorderingQueue;
import java.util.Comparator;

public final /* synthetic */ class RtpPacketReorderingQueue$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ RtpPacketReorderingQueue$$ExternalSyntheticLambda0 INSTANCE = new RtpPacketReorderingQueue$$ExternalSyntheticLambda0();

    private /* synthetic */ RtpPacketReorderingQueue$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return RtpPacketReorderingQueue.calculateSequenceNumberShift(((RtpPacketReorderingQueue.RtpPacketContainer) obj).packet.sequenceNumber, ((RtpPacketReorderingQueue.RtpPacketContainer) obj2).packet.sequenceNumber);
    }
}
