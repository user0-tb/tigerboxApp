package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.C1229Util;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.base.Ascii;

final class RtpAacReader implements RtpPayloadReader {
    private static final String AAC_HIGH_BITRATE_MODE = "AAC-hbr";
    private static final String AAC_LOW_BITRATE_MODE = "AAC-lbr";
    private static final String TAG = "RtpAacReader";
    private final ParsableBitArray auHeaderScratchBit = new ParsableBitArray();
    private final int auIndexFieldBitSize;
    private final int auSizeFieldBitSize;
    private long firstReceivedTimestamp;
    private final int numBitsInAuHeader;
    private final RtpPayloadFormat payloadFormat;
    private final int sampleRate;
    private long startTimeOffsetUs;
    private TrackOutput trackOutput;

    public RtpAacReader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
        this.sampleRate = rtpPayloadFormat.clockRate;
        String str = (String) Assertions.checkNotNull(rtpPayloadFormat.fmtpParameters.get("mode"));
        if (Ascii.equalsIgnoreCase(str, AAC_HIGH_BITRATE_MODE)) {
            this.auSizeFieldBitSize = 13;
            this.auIndexFieldBitSize = 3;
        } else if (Ascii.equalsIgnoreCase(str, AAC_LOW_BITRATE_MODE)) {
            this.auSizeFieldBitSize = 6;
            this.auIndexFieldBitSize = 2;
        } else {
            throw new UnsupportedOperationException("AAC mode not supported");
        }
        this.numBitsInAuHeader = this.auIndexFieldBitSize + this.auSizeFieldBitSize;
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
        Assertions.checkNotNull(this.trackOutput);
        short readShort = parsableByteArray.readShort();
        int i2 = readShort / this.numBitsInAuHeader;
        long sampleTimeUs = RtpReaderUtils.toSampleTimeUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp, this.sampleRate);
        this.auHeaderScratchBit.reset(parsableByteArray);
        if (i2 == 1) {
            int readBits = this.auHeaderScratchBit.readBits(this.auSizeFieldBitSize);
            this.auHeaderScratchBit.skipBits(this.auIndexFieldBitSize);
            this.trackOutput.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            if (z) {
                outputSampleMetadata(this.trackOutput, sampleTimeUs, readBits);
                return;
            }
            return;
        }
        parsableByteArray.skipBytes((readShort + 7) / 8);
        for (int i3 = 0; i3 < i2; i3++) {
            int readBits2 = this.auHeaderScratchBit.readBits(this.auSizeFieldBitSize);
            this.auHeaderScratchBit.skipBits(this.auIndexFieldBitSize);
            this.trackOutput.sampleData(parsableByteArray, readBits2);
            outputSampleMetadata(this.trackOutput, sampleTimeUs, readBits2);
            sampleTimeUs += C1229Util.scaleLargeTimestamp((long) i2, 1000000, (long) this.sampleRate);
        }
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.startTimeOffsetUs = j2;
    }

    private static void outputSampleMetadata(TrackOutput trackOutput2, long j, int i) {
        trackOutput2.sampleMetadata(j, 1, i, 0, (TrackOutput.CryptoData) null);
    }
}
