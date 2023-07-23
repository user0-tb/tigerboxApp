package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.Comparator;

public final /* synthetic */ class MediaCodecUtil$$ExternalSyntheticLambda3 implements Comparator {
    public final /* synthetic */ MediaCodecUtil.ScoreProvider f$0;

    public /* synthetic */ MediaCodecUtil$$ExternalSyntheticLambda3(MediaCodecUtil.ScoreProvider scoreProvider) {
        this.f$0 = scoreProvider;
    }

    public final int compare(Object obj, Object obj2) {
        return MediaCodecUtil.lambda$sortByScore$3(this.f$0, obj, obj2);
    }
}
