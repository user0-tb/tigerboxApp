package com.google.android.exoplayer2.extractor.p007ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.ts.AdtsExtractor$$ExternalSyntheticLambda0 */
public final /* synthetic */ class AdtsExtractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ AdtsExtractor$$ExternalSyntheticLambda0 INSTANCE = new AdtsExtractor$$ExternalSyntheticLambda0();

    private /* synthetic */ AdtsExtractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return AdtsExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
