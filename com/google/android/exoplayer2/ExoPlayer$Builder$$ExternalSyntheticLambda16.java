package com.google.android.exoplayer2;

import com.google.android.exoplayer2.analytics.DefaultAnalyticsCollector;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.base.Function;

public final /* synthetic */ class ExoPlayer$Builder$$ExternalSyntheticLambda16 implements Function {
    public static final /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda16 INSTANCE = new ExoPlayer$Builder$$ExternalSyntheticLambda16();

    private /* synthetic */ ExoPlayer$Builder$$ExternalSyntheticLambda16() {
    }

    public final Object apply(Object obj) {
        return new DefaultAnalyticsCollector((Clock) obj);
    }
}
