package com.google.android.exoplayer2.text.webvtt;

import java.util.Comparator;

public final /* synthetic */ class WebvttSubtitle$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ WebvttSubtitle$$ExternalSyntheticLambda0 INSTANCE = new WebvttSubtitle$$ExternalSyntheticLambda0();

    private /* synthetic */ WebvttSubtitle$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return Long.compare(((WebvttCueInfo) obj).startTimeUs, ((WebvttCueInfo) obj2).startTimeUs);
    }
}
