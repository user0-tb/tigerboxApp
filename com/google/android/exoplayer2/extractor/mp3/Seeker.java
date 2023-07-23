package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C0963C;
import com.google.android.exoplayer2.extractor.SeekMap;

interface Seeker extends SeekMap {
    long getDataEndPosition();

    long getTimeUs(long j);

    public static class UnseekableSeeker extends SeekMap.Unseekable implements Seeker {
        public long getDataEndPosition() {
            return -1;
        }

        public long getTimeUs(long j) {
            return 0;
        }

        public UnseekableSeeker() {
            super(C0963C.TIME_UNSET);
        }
    }
}
