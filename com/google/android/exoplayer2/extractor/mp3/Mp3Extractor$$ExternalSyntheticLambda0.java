package com.google.android.exoplayer2.extractor.mp3;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class Mp3Extractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ Mp3Extractor$$ExternalSyntheticLambda0 INSTANCE = new Mp3Extractor$$ExternalSyntheticLambda0();

    private /* synthetic */ Mp3Extractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return Mp3Extractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
