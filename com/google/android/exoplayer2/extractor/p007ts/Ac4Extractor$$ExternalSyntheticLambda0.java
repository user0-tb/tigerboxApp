package com.google.android.exoplayer2.extractor.p007ts;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.extractor.ts.Ac4Extractor$$ExternalSyntheticLambda0 */
public final /* synthetic */ class Ac4Extractor$$ExternalSyntheticLambda0 implements ExtractorsFactory {
    public static final /* synthetic */ Ac4Extractor$$ExternalSyntheticLambda0 INSTANCE = new Ac4Extractor$$ExternalSyntheticLambda0();

    private /* synthetic */ Ac4Extractor$$ExternalSyntheticLambda0() {
    }

    public final Extractor[] createExtractors() {
        return Ac4Extractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return ExtractorsFactory.CC.$default$createExtractors(this, uri, map);
    }
}
