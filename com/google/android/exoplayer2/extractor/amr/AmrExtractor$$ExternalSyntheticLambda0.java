package com.google.android.exoplayer2.extractor.amr;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class AmrExtractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ AmrExtractor$$ExternalSyntheticLambda0 INSTANCE = new AmrExtractor$$ExternalSyntheticLambda0();

    private /* synthetic */ AmrExtractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return AmrExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
