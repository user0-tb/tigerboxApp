package com.google.android.exoplayer2.source.rtsp.reader;

import com.google.android.exoplayer2.util.C1229Util;

class RtpReaderUtils {
    public static long toSampleTimeUs(long j, long j2, long j3, int i) {
        return j + C1229Util.scaleLargeTimestamp(j2 - j3, 1000000, (long) i);
    }

    private RtpReaderUtils() {
    }
}
