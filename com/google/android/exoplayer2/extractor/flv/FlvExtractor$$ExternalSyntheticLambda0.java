package com.google.android.exoplayer2.extractor.flv;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class FlvExtractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ FlvExtractor$$ExternalSyntheticLambda0 INSTANCE = new FlvExtractor$$ExternalSyntheticLambda0();

    private /* synthetic */ FlvExtractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return FlvExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
