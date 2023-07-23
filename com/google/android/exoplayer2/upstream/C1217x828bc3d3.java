package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.common.base.Predicate;
import java.util.Map;

/* renamed from: com.google.android.exoplayer2.upstream.DefaultHttpDataSource$NullFilteringHeadersMap$$ExternalSyntheticLambda1 */
public final /* synthetic */ class C1217x828bc3d3 implements Predicate {
    public static final /* synthetic */ C1217x828bc3d3 INSTANCE = new C1217x828bc3d3();

    private /* synthetic */ C1217x828bc3d3() {
    }

    public final boolean apply(Object obj) {
        return DefaultHttpDataSource.NullFilteringHeadersMap.lambda$entrySet$1((Map.Entry) obj);
    }
}
