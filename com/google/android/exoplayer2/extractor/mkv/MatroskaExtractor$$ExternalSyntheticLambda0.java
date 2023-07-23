package com.google.android.exoplayer2.extractor.mkv;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class MatroskaExtractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ MatroskaExtractor$$ExternalSyntheticLambda0 INSTANCE = new MatroskaExtractor$$ExternalSyntheticLambda0();

    private /* synthetic */ MatroskaExtractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return MatroskaExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
