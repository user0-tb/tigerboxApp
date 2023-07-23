package com.google.android.exoplayer2.extractor.wav;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class WavExtractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ WavExtractor$$ExternalSyntheticLambda0 INSTANCE = new WavExtractor$$ExternalSyntheticLambda0();

    private /* synthetic */ WavExtractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return WavExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
