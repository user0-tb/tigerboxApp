package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.util.Consumer;

public final /* synthetic */ class SampleQueue$$ExternalSyntheticLambda0 implements Consumer {
    public static final /* synthetic */ SampleQueue$$ExternalSyntheticLambda0 INSTANCE = new SampleQueue$$ExternalSyntheticLambda0();

    private /* synthetic */ SampleQueue$$ExternalSyntheticLambda0() {
    }

    public final void accept(Object obj) {
        ((SampleQueue.SharedSampleMetadata) obj).drmSessionReference.release();
    }
}
