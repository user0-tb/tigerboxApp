package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;

public final /* synthetic */ class MediaParserExtractorAdapter$$ExternalSyntheticLambda0 implements ProgressiveMediaExtractor.Factory {
    public static final /* synthetic */ MediaParserExtractorAdapter$$ExternalSyntheticLambda0 INSTANCE = new MediaParserExtractorAdapter$$ExternalSyntheticLambda0();

    private /* synthetic */ MediaParserExtractorAdapter$$ExternalSyntheticLambda0() {
    }

    public final ProgressiveMediaExtractor createProgressiveMediaExtractor(PlayerId playerId) {
        return new MediaParserExtractorAdapter(playerId);
    }
}
