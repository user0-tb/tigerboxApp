package com.google.android.exoplayer2.source.rtsp.reader;

import android.util.Log;
import com.google.android.exoplayer2.C0963C;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPacket;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C1229Util;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class RtpPcmReader implements RtpPayloadReader {
    private static final String TAG = "RtpPcmReader";
    private long firstReceivedTimestamp = C0963C.TIME_UNSET;
    private final RtpPayloadFormat payloadFormat;
    private int previousSequenceNumber = -1;
    private long startTimeOffsetUs = 0;
    private TrackOutput trackOutput;

    public RtpPcmReader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 1);
        this.trackOutput = track;
        track.format(this.payloadFormat.format);
    }

    public void onReceivingFirstPacket(long j, int i) {
        this.firstReceivedTimestamp = j;
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) {
        int nextSequenceNumber;
        int i2 = i;
        Assertions.checkNotNull(this.trackOutput);
        int i3 = this.previousSequenceNumber;
        if (!(i3 == -1 || i2 == (nextSequenceNumber = RtpPacket.getNextSequenceNumber(i3)))) {
            Log.w(TAG, C1229Util.formatInvariant("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(nextSequenceNumber), Integer.valueOf(i)));
        }
        long sampleTimeUs = RtpReaderUtils.toSampleTimeUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp, this.payloadFormat.clockRate);
        int bytesLeft = parsableByteArray.bytesLeft();
        this.trackOutput.sampleData(parsableByteArray, bytesLeft);
        this.trackOutput.sampleMetadata(sampleTimeUs, 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
        this.previousSequenceNumber = i2;
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.startTimeOffsetUs = j2;
    }
}
