package com.google.android.exoplayer2.extractor.mp4;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class Mp4Extractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ Mp4Extractor$$ExternalSyntheticLambda0 INSTANCE = new Mp4Extractor$$ExternalSyntheticLambda0();

    private /* synthetic */ Mp4Extractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return Mp4Extractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
