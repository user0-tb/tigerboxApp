package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;

public final /* synthetic */ class MediaCodecUtil$$ExternalSyntheticLambda0 implements MediaCodecUtil.ScoreProvider {
    public final /* synthetic */ Format f$0;

    public /* synthetic */ MediaCodecUtil$$ExternalSyntheticLambda0(Format format) {
        this.f$0 = format;
    }

    public final int getScore(Object obj) {
        return MediaCodecUtil.lambda$getDecoderInfosSortedByFormatSupport$0(this.f$0, (MediaCodecInfo) obj);
    }
}
