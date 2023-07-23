package com.google.android.exoplayer2.extractor.ogg;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class OggExtractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ OggExtractor$$ExternalSyntheticLambda0 INSTANCE = new OggExtractor$$ExternalSyntheticLambda0();

    private /* synthetic */ OggExtractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return OggExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
