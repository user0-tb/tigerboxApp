package com.google.android.exoplayer2.extractor.flac;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class FlacExtractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ FlacExtractor$$ExternalSyntheticLambda0 INSTANCE = new FlacExtractor$$ExternalSyntheticLambda0();

    private /* synthetic */ FlacExtractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return FlacExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
