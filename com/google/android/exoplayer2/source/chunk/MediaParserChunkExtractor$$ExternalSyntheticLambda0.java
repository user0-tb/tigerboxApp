package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import java.util.List;

public final /* synthetic */ class MediaParserChunkExtractor$$ExternalSyntheticLambda0 implements ChunkExtractor.Factory {
    public static final /* synthetic */ MediaParserChunkExtractor$$ExternalSyntheticLambda0 INSTANCE = new MediaParserChunkExtractor$$ExternalSyntheticLambda0();

    private /* synthetic */ MediaParserChunkExtractor$$ExternalSyntheticLambda0() {
    }

    public final ChunkExtractor createProgressiveMediaExtractor(int i, Format format, boolean z, List list, TrackOutput trackOutput, PlayerId playerId) {
        return MediaParserChunkExtractor.lambda$static$0(i, format, z, list, trackOutput, playerId);
    }
}
