package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import java.util.List;

public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT = MediaCodecSelector$$ExternalSyntheticLambda0.INSTANCE;

    List<MediaCodecInfo> getDecoderInfos(String str, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException;
}
