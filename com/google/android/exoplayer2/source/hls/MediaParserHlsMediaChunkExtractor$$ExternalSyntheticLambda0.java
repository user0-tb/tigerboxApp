package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.List;
import java.util.Map;

public final /* synthetic */ class MediaParserHlsMediaChunkExtractor$$ExternalSyntheticLambda0 implements HlsExtractorFactory {
    public static final /* synthetic */ MediaParserHlsMediaChunkExtractor$$ExternalSyntheticLambda0 INSTANCE = new MediaParserHlsMediaChunkExtractor$$ExternalSyntheticLambda0();

    private /* synthetic */ MediaParserHlsMediaChunkExtractor$$ExternalSyntheticLambda0() {
    }

    public final HlsMediaChunkExtractor createExtractor(Uri uri, Format format, List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput, PlayerId playerId) {
        return MediaParserHlsMediaChunkExtractor.lambda$static$0(uri, format, list, timestampAdjuster, map, extractorInput, playerId);
    }
}
