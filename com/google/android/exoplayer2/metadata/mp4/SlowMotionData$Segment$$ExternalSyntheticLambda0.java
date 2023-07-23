package com.google.android.exoplayer2.metadata.mp4;

import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.common.collect.ComparisonChain;
import java.util.Comparator;

public final /* synthetic */ class SlowMotionData$Segment$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ SlowMotionData$Segment$$ExternalSyntheticLambda0 INSTANCE = new SlowMotionData$Segment$$ExternalSyntheticLambda0();

    private /* synthetic */ SlowMotionData$Segment$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return ComparisonChain.start().compare(((SlowMotionData.Segment) obj).startTimeMs, ((SlowMotionData.Segment) obj2).startTimeMs).compare(((SlowMotionData.Segment) obj).endTimeMs, ((SlowMotionData.Segment) obj2).endTimeMs).compare(((SlowMotionData.Segment) obj).speedDivisor, ((SlowMotionData.Segment) obj2).speedDivisor).result();
    }
}
