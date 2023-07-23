package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.SlidingPercentile;
import java.util.Comparator;

public final /* synthetic */ class SlidingPercentile$$ExternalSyntheticLambda1 implements Comparator {
    public static final /* synthetic */ SlidingPercentile$$ExternalSyntheticLambda1 INSTANCE = new SlidingPercentile$$ExternalSyntheticLambda1();

    private /* synthetic */ SlidingPercentile$$ExternalSyntheticLambda1() {
    }

    public final int compare(Object obj, Object obj2) {
        return Float.compare(((SlidingPercentile.Sample) obj).value, ((SlidingPercentile.Sample) obj2).value);
    }
}
