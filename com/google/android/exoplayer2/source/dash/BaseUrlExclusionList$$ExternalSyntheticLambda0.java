package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.manifest.BaseUrl;
import java.util.Comparator;

public final /* synthetic */ class BaseUrlExclusionList$$ExternalSyntheticLambda0 implements Comparator {
    public static final /* synthetic */ BaseUrlExclusionList$$ExternalSyntheticLambda0 INSTANCE = new BaseUrlExclusionList$$ExternalSyntheticLambda0();

    private /* synthetic */ BaseUrlExclusionList$$ExternalSyntheticLambda0() {
    }

    public final int compare(Object obj, Object obj2) {
        return BaseUrlExclusionList.compareBaseUrl((BaseUrl) obj, (BaseUrl) obj2);
    }
}
